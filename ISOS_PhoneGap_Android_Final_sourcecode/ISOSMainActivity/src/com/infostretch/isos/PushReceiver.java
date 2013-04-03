package com.infostretch.isos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

public class PushReceiver extends BroadcastReceiver {

	public static final String DISPLAY_MESSAGE_ACTION = "com.infostretch.isos.DISPLAY_MESSAGE";

	static final String EXTRA_MESSAGE = "message";

	@Override
	public void onReceive(Context context, Intent intent) {
		String newMessage = intent.getExtras().getString(EXTRA_MESSAGE);
		// Waking up mobile if it is sleeping
		WakeLocker.acquire(context);
		/**
		 * Take appropriate action on this message depending upon your app
		 * requirement For now i am just displaying it on the screen
		 * */
		if (newMessage.contains("$$")) {
			newMessage = newMessage.split("\\$\\$")[0];
		}

		// Showing received message
		Toast.makeText(context, newMessage, Toast.LENGTH_SHORT).show();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				WakeLocker.release();
			}
		}, 5000);

		// Releasing wake lock
	}

}
