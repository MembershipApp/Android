package com.infostretch.location;

import java.util.Calendar;
import java.util.TimeZone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.infostretch.network.CallBack;
import com.infostretch.network.ServiceImpl;
import com.infostretch.util.Logger;
import com.infostretch.util.Preference;
import com.infostretch.isos.ISOSPlugin;

public class AlarmReceiver extends BroadcastReceiver{

	
	@Override
	public void onReceive(final Context context, Intent intent) {
		// TODO Auto-generated method stub
		Logger.d("Alarm Service called");
		//ISOSPlugin.CallBackGeoFencing("Crossed fencing");
		
		//Test for geofencing called after 30 mins(for testing purpose it is 1 min)
		ISOSPlugin.CallBackGeoFencing();
		
		new ISOSLocationProvider(new ServiceInterface() {
			
			@Override
			public void onComplete(Object data) {
				// Send location details to server
				CallBack callbackdata = new CallBack();
				callbackdata.setLatitude(CurrentLocationStore.getInstance().getLatitude());
				callbackdata.setLongitude(CurrentLocationStore.getInstance().getLongitude());
				callbackdata.setDeviceToken(Preference.getToken(context));
				callbackdata.setDeviceType("A");
				callbackdata.setMembershipID(Preference.getLoginID(context));
				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
				callbackdata.setTimestamp(cal.getTimeInMillis());
				new ServiceImpl(new ServiceInterface() {
					
					@Override
					public void onComplete(Object data) {
						
					}
				}).AutoCheckin(new Gson().toJson(callbackdata));
			}
		}).initTime(context);
	}

}
