package com.infostretch.network;



import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.util.Log;

import com.infostretch.location.ISOSLocationService;
import com.infostretch.util.Globals;

/**
 * Connection checked class keeps listners for network connection and update the global state
 * @author dinesh.prajapati
 */
public class ConnectionChecker extends Activity {
	private static final int STATE_DISABLED = 0;
	private static final int STATE_ENABLED = 1;
	private static final int STATE_TURNING_ON = 2;
	private static final int STATE_TURNING_OFF = 3;
	private static final int STATE_UNKNOWN = 4;
	/**
	 * Listners for the Wi-fi status and airplane mode
	 */
	public static class serviceStateReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			Globals.airplaneModeStatus = Settings.System.getInt(
			        context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0);
			if (intent.getAction().equalsIgnoreCase(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
				if (Globals.airplaneModeStatus == (Settings.System.getInt(
				        context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0))) {
					Log.d("AirplanMode", "AirplanMode ON Or Off");
				}
				Log.d(Globals.TAG,
				        "Airplane Mode Service state changed-->"
				                + Settings.System.getInt(context.getContentResolver(),
				                        Settings.System.AIRPLANE_MODE_ON, 0));
			}
			if (intent.getAction().equalsIgnoreCase(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
				WifiManager wifiManager = (WifiManager) context
				        .getSystemService(Context.WIFI_SERVICE);
				int wifiState = wifiManager.getWifiState();
				switch (wifiState) {
				case WifiManager.WIFI_STATE_DISABLED:
					Globals.wifiStatus = STATE_DISABLED;
					Globals.wifiStatusString = "Disabled";
					Globals.isWifiAvailable = false;
					checkConnection(context);
					break;
				case WifiManager.WIFI_STATE_ENABLED:
					Globals.wifiStatus = STATE_ENABLED;
					Globals.wifiStatusString = "Enabled";
					Globals.isWifiAvailable = true;
					break;
				case WifiManager.WIFI_STATE_DISABLING:
					Globals.wifiStatus = STATE_TURNING_OFF;
					Globals.wifiStatusString = "Turning off";
					break;
				case WifiManager.WIFI_STATE_ENABLING:
					Globals.wifiStatus = STATE_TURNING_ON;
					Globals.wifiStatusString = "Turning on";
					break;
				default:
					Globals.wifiStatus = STATE_UNKNOWN;
					Globals.wifiStatusString = "Unknown";
					break;
				}
			}
		}
	}
	
	public void StartLocation() {
		startService(new Intent(ConnectionChecker.this,ISOSLocationService.class));
	}

	/**
	 * Check for the data connection status
	 */
	public static void checkConnection(Context context) {
		ConnectivityManager connMgr = (ConnectivityManager) context
		        .getSystemService(Context.CONNECTIVITY_SERVICE);
		android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (wifi.isAvailable() && wifi.isConnected()) {
			Globals.isWifiAvailable = true;
		}else{
			Globals.isWifiAvailable =false;
		}
		if (mobile.isAvailable() && mobile.isConnected()) {
			Globals.isMobileDataAvailable = true;
		} else {
			Globals.isMobileDataAvailable = false;
		}
	}

	public static boolean selfLearnig(Context context) {

			checkConnection(context);
		    ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

		    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

		    return activeNetworkInfo != null;

		
	}
}
