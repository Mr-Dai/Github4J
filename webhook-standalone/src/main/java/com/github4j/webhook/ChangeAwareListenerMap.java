package com.github4j.webhook;

import com.github4j.event.GithubEvent;
import com.github4j.webhook.listener.EventListener;
import groovy.lang.GroovyClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class ChangeAwareListenerMap implements Map<Class<? extends GithubEvent>, List<EventListener>> {
    private static final Logger LOG = LoggerFactory.getLogger(ChangeAwareListenerMap.class);

    private final GroovyClassLoader scriptLoader = new GroovyClassLoader();
    private final Map<Class<? extends GithubEvent>, List<EventListener>> innerMap = new HashMap<>();
    private final Map<Path, EventListener> listenerMap = new HashMap<>();

    private Thread watcherThread;

    public ChangeAwareListenerMap(Path listenersPath) {
        // Register listeners
        synchronized (this) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(listenersPath, "*.groovy")) {
                for (Path path : stream) {
                    LOG.debug("Fetched Groovy script file `{}`.", path);
                    addGroovyListener(path);
                }
            } catch (IOException ex) {
                LOG.error("Exception occurred when trying to read listener scripts from `" + listenersPath + "`: ", ex);
            }
        }

        // Register file system hook
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            final WatchKey watchKey = listenersPath.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
            watcherThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    LOG.debug("Script file watcher started.");
                    while (!Thread.interrupted()) {
                        for (WatchEvent<?> event : watchKey.pollEvents()) {
                            WatchEvent.Kind<?> kind = event.kind();
                            if (kind == OVERFLOW)
                                continue;
                            Path path = (Path) event.context();
                            if (kind == ENTRY_CREATE) {
                                addGroovyListener(path);
                            } else if (kind == ENTRY_MODIFY) {
                                removeListener(path);
                                addGroovyListener(path);
                            } else if (kind == ENTRY_DELETE) {
                                removeListener(path);
                            }

                            boolean valid = watchKey.reset();
                            if (!valid) {
                                LOG.warn("Watcher exits as the watch key becomes invalid.");
                                break;
                            }
                        }
                    }
                    LOG.debug("Script file watcher terminated.");
                }
            });
            watcherThread.setDaemon(true);
            watcherThread.start();
        } catch (IOException ex) {
            LOG.warn("Exception occurred when trying to register file system hook on path `" + listenersPath + "`: ", ex);
        }
    }

    private void addGroovyListener(Path path) {
        try {
            Class<?> listenerClass = scriptLoader.parseClass(
                    new String(Files.readAllBytes(path)), path.getFileName().toString()
            );
            LOG.debug("Fetched class `{}`.", listenerClass.getName());
            if (EventListener.class.isAssignableFrom(listenerClass)) {
                EventListener listener = (EventListener) listenerClass.newInstance();
                addListener(path, listener);
            }
        } catch (ReflectiveOperationException ex) {
            LOG.warn("Exception occurred when trying to instantiate the class in `" + path + "`: ", ex);
        } catch (IOException ex) {
            LOG.warn("Exception occurred when trying to read file `" + path + "`: ", ex);
        }
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("ChangeAwareListenerMap does not support method `size`.");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("ChangeAwareListenerMap does not support method `isEmpty`.");
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("ChangeAwareListenerMap does not support method `containsKey`.");
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("ChangeAwareListenerMap does not support method `containsValue.");
    }

    @Override
    public List<EventListener> get(Object key) {
        synchronized (this) {
            return innerMap.get(key);
        }
    }

    public void removeListener(Path path) {
        synchronized (this) {
            EventListener listener = listenerMap.remove(path);
            if (listener == null)
                return;
            LOG.debug("Removing listener class `{}`.", listener.getClass().getName());
            List<Class<? extends GithubEvent>> supportedEvents = listener.getSupportedEvents();
            for (Class<? extends GithubEvent> supportedEvent : supportedEvents) {
                if (innerMap.get(supportedEvent) != null)
                    innerMap.get(supportedEvent).remove(listener);
            }
        }
    }

    public void addListener(Path path, EventListener listener) {
        synchronized (this) {
            LOG.debug("Adding new class `{}` as listener.", listener.getClass().getName());
            if (listenerMap.containsKey(path))
                throw new IllegalStateException(
                        "Path `" + path.toString() + "` has already been registered in this listener map. "
                                + "Remove it first before adding it again."
                );

            listenerMap.put(path, listener);
            List<Class<? extends GithubEvent>> supportedEvents = listener.getSupportedEvents();
            for (Class<? extends GithubEvent> supportedEvent : supportedEvents) {
                if (innerMap.get(supportedEvent) == null)
                    innerMap.put(supportedEvent, new LinkedList<EventListener>());
                innerMap.get(supportedEvent).add(listener);
            }
        }
    }

    @Override
    public List<EventListener> put(Class<? extends GithubEvent> key, List<EventListener> value) {
        synchronized (this) {
            return innerMap.put(key, value);
        }
    }

    @Override
    public List<EventListener> remove(Object key) {
        throw new UnsupportedOperationException("ChangeAwareListenerMap does not support method `remove`.");
    }

    @Override
    public void putAll(Map<? extends Class<? extends GithubEvent>, ? extends List<EventListener>> m) {
        throw new UnsupportedOperationException("ChangeAwareListenerMap does not support method `putAll`.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("ChangeAwareListenerMap does not support method `clear`.");
    }

    @Override
    public Set<Class<? extends GithubEvent>> keySet() {
        throw new UnsupportedOperationException("ChangeAwareListenerMap does not support method `keySet`.");
    }

    @Override
    public Collection<List<EventListener>> values() {
        throw new UnsupportedOperationException("ChangeAwareListenerMap does not support method `values`.");
    }

    @Override
    public Set<Entry<Class<? extends GithubEvent>, List<EventListener>>> entrySet() {
        throw new UnsupportedOperationException("ChangeAwareListenerMap does not support method `entrySet`.");
    }
}
