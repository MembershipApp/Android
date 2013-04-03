package com.infostretch.util;

import android.content.Context;
import android.content.SharedPreferences;



public class Preference {
	
	private static SharedPreferences mSharedPreferences;
	
	public static void setLoginID(Context context, String username) {
		mSharedPreferences = context.getSharedPreferences(
				Globals.HALOGEN_PREF, Context.MODE_WORLD_WRITEABLE);
		SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();
		prefsEditor.putString(Globals.LOGIN_ID, username);
		prefsEditor.commit();
	}
	
	public static String getLoginID(Context context) {
		mSharedPreferences = context.getSharedPreferences(
				Globals.HALOGEN_PREF, Context.MODE_WORLD_READABLE);
		return mSharedPreferences.getString(Globals.LOGIN_ID,
				"");
	}
	
	public static void setToken(Context context, String token) {
		mSharedPreferences = context.getSharedPreferences(
				Globals.HALOGEN_PREF, Context.MODE_WORLD_WRITEABLE);
		SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();
		prefsEditor.putString(Globals.TOKEN, token);
		prefsEditor.commit();
	}
	
	public static String getToken(Context context) {
		mSharedPreferences = context.getSharedPreferences(
				Globals.HALOGEN_PREF, Context.MODE_WORLD_READABLE);
		return mSharedPreferences.getString(Globals.TOKEN,"");
	}

}
