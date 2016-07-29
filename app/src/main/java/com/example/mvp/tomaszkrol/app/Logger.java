package com.example.mvp.tomaszkrol.app;

import android.util.Log;



/**
 * Created by katarzyna.jedrzejews on 2015-08-24.
 */

public class Logger {

    private static final String EXCEPTION_MESSAGE = "MPublisher";
    private static final boolean DEBUG = BuildConfig.DEBUG;

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void i(Class<?> clazz, String msg) {

        if (DEBUG) {
            Log.i(clazz.getName(), msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void d(Class<?> clazz, String msg) {
        if (DEBUG) {
            Log.d(clazz.getName(), msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void e(Class<?> clazz, String msg) {
        if (DEBUG) {
            Log.e(clazz.getName(), msg);
        }
    }

    public static void e(String tag, Throwable throwable) {
        e(tag, EXCEPTION_MESSAGE, throwable);
    }

    public static void e(Class<?> clazz, Throwable throwable) {
        e(clazz, EXCEPTION_MESSAGE, throwable);
    }

    public static void e(String tag, String msg, Throwable throwable) {
        if (DEBUG) {
            Log.e(tag, msg, throwable);
        }
    }

    public static void e(Class<?> clazz, String msg, Throwable throwable) {
        e(clazz.getName(), msg, throwable);
    }

    public static void v(String tag, String msg) {
        if (DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void v(Class<?> clazz, String msg) {
        if (DEBUG) {
            Log.v(clazz.getName(), msg);
        }
    }

    public static void w(String tag, String msg) {
        if (DEBUG) {
            Log.w(tag, msg);
        }
    }

    public static void w(Class<?> clazz, String msg) {
        if (DEBUG) {
            Log.w(clazz.getName(), msg);
        }
    }
}

