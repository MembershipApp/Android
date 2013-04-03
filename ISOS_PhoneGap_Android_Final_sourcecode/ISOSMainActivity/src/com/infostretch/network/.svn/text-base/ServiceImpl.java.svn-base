package com.infostretch.network;

import java.util.Calendar;
import java.util.TimeZone;

import org.json.JSONArray;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import com.google.gson.Gson;
import com.infostretch.isos.ISOSPlugin;
import com.infostretch.isos.app.ISOSApp;
import com.infostretch.isos.app.ISOSContext;
import com.infostretch.location.ISOSLocationProvider;
import com.infostretch.location.ISOSLocationService;
import com.infostretch.location.ServiceInterface;
import com.infostretch.util.Preference;

public class ServiceImpl {

	WebServiceCallBack callBack;
	Context context;
	ServiceInterface mServiceInterface;

	/**
	 * @param callBack
	 */
	public ServiceImpl(ServiceInterface notify) {
		this.context = ISOSContext.getContext();
		this.mServiceInterface = notify;
	}

	public void userLogin(String jsonFromJs) {
		try {
			JSONArray data = new JSONArray(jsonFromJs);
			final CallBack callbackdata = new Gson().fromJson(data
					.getJSONObject(0).toString(), CallBack.class);
			callbackdata.setPassword("123");
			callbackdata.setDeviceType("A");
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			callbackdata.setTimestamp(cal.getTimeInMillis());
			HTTPTask task = new HTTPTask(new Gson().toJson(callbackdata),
					"authenticate", new WebServiceCallBack() {

						@Override
						public void onRequestComplete(Object responseData,
								String callType) {
							String data = (String) responseData;
							try {
								CallBack objClass = new Gson().fromJson(data,
										CallBack.class);
								if (objClass.getStatusCode().equals("0")) {
									
									Preference.setLoginID(context,
											callbackdata.getMembershipID());
									context.startService(new Intent(context,
											ISOSLocationService.class));
									/*new Handler().postDelayed(new Runnable() {

										@Override
										public void run() {

											new ISOSLocationProvider(
													new ServiceInterface() {

														@Override
														public void onComplete(
																Object data) {

														}
													}).init(context);
										}
									}, 60000);*/

								}
								mServiceInterface.onComplete("");
								ISOSPlugin.CallBackLoginService(objClass
										.getStatusCode());
							} catch (Exception e) {
								e.printStackTrace();
								Toast.makeText(context, "Server Error",
										Toast.LENGTH_SHORT).show();
							}
						}
					});
			task.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CheckIn(String jsonFromJs) {

		try {
			JSONArray data = new JSONArray(jsonFromJs);
			CallBack callbackdata = new Gson().fromJson(data.getJSONObject(0)
					.toString(), CallBack.class);
			callbackdata.setDeviceType("A");
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			callbackdata.setTimestamp(cal.getTimeInMillis());
			Preference.setToken(context, callbackdata.getDeviceToken());
			HTTPTask task = new HTTPTask(new Gson().toJson(callbackdata),
					"checkin", new WebServiceCallBack() {

						@Override
						public void onRequestComplete(Object responseData,
								String callType) {
							String data = (String) responseData;
							try {
								CallBack objClass = new Gson().fromJson(data,
										CallBack.class);
								if (objClass.getStatusCode().equals("0")) {
									
								}
								mServiceInterface.onComplete("");
								ISOSPlugin.CallBackCheckinService(objClass
										.getStatusCode());
							} catch (Exception e) {
								e.printStackTrace();
								Toast.makeText(context, "Server Error",
										Toast.LENGTH_SHORT).show();
							}

						}
					});
			task.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void AutoCheckin(String jsonFromJs) {

		try {
			HTTPTask task = new HTTPTask(jsonFromJs, "checkin",
					new WebServiceCallBack() {

						@Override
						public void onRequestComplete(Object responseData,
								String callType) {
							String data = (String) responseData;
							try {
								CallBack objClass = new Gson().fromJson(data,
										CallBack.class);
								objClass.setDeviceType("A");
								Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
								objClass.setTimestamp(cal.getTimeInMillis());
								if (objClass.getStatusCode().equals("0")) {
								}
								mServiceInterface.onComplete("");
								ISOSPlugin.CallBackCheckinService(objClass
										.getStatusCode());
							} catch (Exception e) {
								e.printStackTrace();
								Toast.makeText(context, "Server Error",
										Toast.LENGTH_SHORT).show();
							}

						}
					});
			task.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
