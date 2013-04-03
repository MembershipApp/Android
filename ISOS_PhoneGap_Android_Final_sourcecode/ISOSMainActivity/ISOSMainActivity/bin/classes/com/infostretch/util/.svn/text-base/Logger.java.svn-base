package com.infostretch.util;

import android.util.Log;

public final class Logger {
	// Constant flags to enable/ disable each log type
	private static final boolean DEBUG = true;
	private static final boolean VERBOSE = true;
	private static final boolean ERROR = true;
	private static final boolean WARN = true;
	private static final boolean INFO = true;

	/**
	 * @param msg
	 *            -Error messages to be printed
	 */
	public static void e(String msg) {
		if (ERROR) {
			Log.e(Globals.TAG, msg);
		}
	}

	/**
	 * @param msg
	 *            - messages to be printed
	 * @param e
	 *            - Throwable messages in case of exception
	 */
	public static void e(String msg, Throwable e) {
		if (ERROR) {
			Log.e(Globals.TAG, msg, e);
		}
	}

	/**
	 * @param msg
	 *            - debug statements to be printed
	 */
	public static void d(String msg) {
		if (DEBUG) {
			Log.d(Globals.TAG, msg);
		}
	}

	/**
	 * @param msg
	 *            Verbose statement to be printed
	 */
	public static void v(String msg) {
		if (VERBOSE) {
			Log.v(Globals.TAG, msg);
		}
	}

	/**
	 * @param msg
	 *            Warning messages to be printed
	 */
	public static void w(String msg) {
		if (WARN) {
			Log.w(Globals.TAG, msg);
		}
	}

	/**
	 * @param msg
	 *            - Information messages to be printed
	 */
	public static void i(String msg) {
		if (INFO) {
			Log.i(Globals.TAG, msg);
		}
	}
}
