package com.infostretch.location;

import java.util.Calendar;
import java.util.TimeZone;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

import com.google.gson.Gson;
import com.infostretch.isos.app.ISOSContext;
import com.infostretch.network.CallBack;
import com.infostretch.network.ConnectionChecker;
import com.infostretch.network.ServiceImpl;
import com.infostretch.util.Globals;
import com.infostretch.util.Preference;

public class ISOSLocationService extends Service implements LocationListener {

	private LocationManager mLocationManager;

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		System.out.println("ISOSLocationService.onStartCommand()");
		Intent alarm_intent = new Intent(getApplicationContext(),
				AlarmReceiver.class);
		// In reality, you would want to have a static variable for the request
		// code instead of 192837
		PendingIntent sender = PendingIntent.getBroadcast(this, 192837,
				alarm_intent, PendingIntent.FLAG_UPDATE_CURRENT);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.MINUTE, 15);
		long interval = 900 * 1000; //
		// Get the AlarmManager service
		AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
				interval, sender);
		init(ISOSContext.getContext());
		return super.onStartCommand(intent, flags, startId);
	}

	public void init(final Context context) {
		try {
			mLocationManager = (LocationManager) context
					.getSystemService(Context.LOCATION_SERVICE);
			ConnectionChecker.selfLearnig(context);
			// The time which has set 300 is static for POC purpose, It will be
			// configurable from server
			mLocationManager.requestLocationUpdates(selectProvider(context), 0,
					300, this);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Returns Location provider
	 */
	public String selectProvider(Context context) {
		String provider = null;
		boolean GPSprovider = mLocationManager
				.isProviderEnabled(LocationManager.GPS_PROVIDER);
		boolean NetWorkprovider = mLocationManager
				.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		if (NetWorkprovider) {
			provider = LocationManager.NETWORK_PROVIDER;
		} else if (GPSprovider) {
			provider = LocationManager.GPS_PROVIDER;
		} else if (Globals.isMobileDataAvailable && NetWorkprovider) {
			provider = LocationManager.NETWORK_PROVIDER;
		} else if (!GPSprovider && !NetWorkprovider) {
			provider = null;
		}
		return provider;
	}

	@Override
	public void onLocationChanged(Location location) {
		if (location != null) {
			CurrentLocationStore.getInstance().setLatitude(
					String.valueOf(location.getLatitude()));
			CurrentLocationStore.getInstance().setLongitude(
					String.valueOf(location.getLongitude()));
			// test for geofencing for crossed fencing
			// Send location details to server
			CallBack callbackdata = new CallBack();
			callbackdata.setLatitude(String.valueOf(location.getLatitude()));
			callbackdata.setLongitude(String.valueOf(location.getLongitude()));
			callbackdata.setDeviceToken(Preference.getToken(ISOSContext.getContext()));
			callbackdata.setDeviceType("A");
			callbackdata.setMembershipID(Preference.getLoginID(ISOSContext.getContext()));
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			callbackdata.setTimestamp(cal.getTimeInMillis());
			new ServiceImpl(new ServiceInterface() {
				
				@Override
				public void onComplete(Object data) {
					
				}
			}).AutoCheckin(new Gson().toJson(callbackdata));
		}

	}

	@Override
	public void onProviderDisabled(String provider) {
		

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
