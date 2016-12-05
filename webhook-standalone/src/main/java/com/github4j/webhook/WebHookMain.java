package com.github4j.webhook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class WebHookMain {
    private static final Logger LOG = LoggerFactory.getLogger(WebHookMain.class);

    public static void main(String[] args) {
        // Load default config
        Config config = new Config();

        String configPath = "github-webhook.properties";
        // TODO Load customized config file path given from CLI arguments

        // Load config from configuration files
        File file = new File(configPath);
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
            if (properties.containsKey("host"))
                config.host = properties.getProperty("host");
            if (properties.containsKey("port"))
                config.port = Integer.parseInt(properties.getProperty("port"));
            if (properties.containsKey("path"))
                config.path = properties.getProperty("path");
            if (properties.containsKey("secret"))
                config.secret = properties.getProperty("secret");
            if (properties.containsKey("verboseLogEnabled"))
                config.verboseLogEnabled = Boolean.parseBoolean(properties.getProperty("verboseLogEnabled"));
        } catch (Throwable ex) {
            LOG.warn("Exception occurred when reading configuration file. Using default configuration: ", ex);
        }

        // TODO Load config from CLI arguments

        // Start the server
        final WebHookListener listener =
                new WebHookListener(config.host, config.port, config.path, config.secret, config.verboseLogEnabled);

        // TODO Register EventListeners

        try {
            listener.start();
            // Register handler for SIGINT event
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        listener.stop();
                    } catch (Exception ex) {
                        LOG.error("Exception occurred when stopping the listener: ", ex);
                    }
                }
            }));
        } catch (Exception ex) {
            LOG.error("Exception occurred when starting the listener: ", ex);
        }
    }

    private static class Config {
        private String host = "";
        private int port = 4567;
        private String path = "";
        private String secret = "";
        private boolean verboseLogEnabled = false;
    }
}
