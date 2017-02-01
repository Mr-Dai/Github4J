package com.github4j.webhook;

import org.apache.commons.cli.*;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class WebHookMain {
    private static final Logger LOG = LoggerFactory.getLogger(WebHookMain.class);
    private static final Path LISTENER_PATH = Paths.get("listener");

    public static void main(String[] args) {
        Options options = prepareCLIOptions();
        CommandLine cli;
        try {
            cli = parseCLI(options, args);
        } catch (ParseException ex) {
            ex.printStackTrace();
            printHelpMessage(options);
            return;
        }
        if (cli.hasOption("h")) {
            printHelpMessage(options);
            return;
        }

        // Load default config
        Config config = new Config();

        String configPath = cli.getOptionValue("config", "github-webhook.properties");

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

        config.host = cli.getOptionValue("host", config.host);
        config.port = cli.hasOption("port") ? Integer.parseInt(cli.getOptionValue("port")) : config.port;
        config.path = cli.getOptionValue("path", config.path);
        config.secret = cli.getOptionValue("secret", config.secret);
        config.verboseLogEnabled = cli.hasOption("verbose") || config.verboseLogEnabled;

        // Start the server
        final WebHookListener listener = new StandaloneWebHookListener(
                config.host, config.port, config.path, config.secret,
                config.verboseLogEnabled, LISTENER_PATH
        );

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

    private static Options prepareCLIOptions() {
        Options options = new Options();
        options.addOption("h", "help", false, "print this message");
        options.addOption("c", "config", true, "path to customized configuration file");
        options.addOption(null, "host", true, "host name to listen to");
        options.addOption(null, "port", true, "port to listen to");
        options.addOption(null, "path", true, "path to listen to");
        options.addOption(null, "secret", true, "secret of the webhook");
        options.addOption(null, "verbose", false, "print verbose log");
        return options;
    }

    private static CommandLine parseCLI(Options options, String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, args);
    }

    private static void printHelpMessage(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("webhook", options, true);
    }

    private static class Config {
        private String host = "";
        private int port = 4567;
        private String path = "";
        private String secret = "";
        private boolean verboseLogEnabled = false;
    }
}
