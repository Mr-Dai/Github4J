package com.github4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        final WebHookListener listener = new WebHookListener("", 4567, "/github-webhook");
        LOG.info("Starting webhook listener...");
        listener.start();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                LOG.info("Received interrupt signal on main thread. Stopping server...");
                try {
                    listener.stop();
                    LOG.info("Server is stopped.");
                } catch (Exception e) {
                    LOG.warn("Exception occurred when try to shutdown the server: ", e);
                }
            }
        }));
        LOG.info("Server started up. Main thread go to sleep...");
        while (!Thread.interrupted())
            Thread.sleep(10000);
    }
}
