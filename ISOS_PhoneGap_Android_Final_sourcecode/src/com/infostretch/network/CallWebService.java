package com.infostretch.network;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.CoreProtocolPNames;

import android.util.Log;

public class CallWebService {
	//private final static String URL = "http://202.131.96.149:81/isos/services/";
	private final static String URL = "http://appzhao.com:9910/";
	
	/**
	 * Invokes HTTP call
	 */
	public static String SendRequest(String json, String url) {
		String responseString = "";
		String finalUrl = URL.concat(url + "/");
		Log.i("Final url", finalUrl);
		HttpClient httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "Android");
		HttpPost httppost = new HttpPost(finalUrl);
		httppost.addHeader(new BasicHeader("Accept", "application/json"));
		httppost.addHeader(new BasicHeader("Content-type", "application/json; charset=utf-8"));
		try {
			httppost.setEntity(new StringEntity(json));
			responseString = httpclient.execute(httppost,
					new BasicResponseHandler());
			Log.i("HOT Response", responseString);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseString;
	}

}
