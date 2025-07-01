package com.ecommerce.test.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Logger Log = LogManager.getLogger(Log.class.getName());

    // We can use it when starting of test case
    public static void startTestCase(String sTestCaseName) {
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
        Log.info("$$$$$$$$$$$$$$$$$$$$$" + sTestCaseName + "$$$$$$$$$$$$$$$$$$$$$");
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
    }

    // We can use it when ending of test case
    public static void endTestCase(String sTestCaseName) {
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
        Log.info("$$$$$$$$$$$$$$$$$$$$$" + "-E---N---D-" + "$$$$$$$$$$$$$$$$$$$$$");
        Log.info("****************************************************************************************");
        Log.info("****************************************************************************************");
    }

    // Info Level Logs
    public static void info(String message) {
        Log.info(message);
    }

    // Warn Level Logs
    public static void warn(String message) {
        Log.warn(message);
    }

    // Error Level Logs
    public static void error(String message) {
        Log.error(message);
    }

    // Fatal Level Logs
    public static void fatal(String message) {
        Log.fatal(message);
    }

    // Debug Level Logs
    public static void debug(String message) {
        Log.debug(message);
    }
}

