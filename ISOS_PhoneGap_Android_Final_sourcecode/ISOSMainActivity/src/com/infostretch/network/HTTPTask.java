/**
 * 
 */
package com.infostretch.network;

import android.os.AsyncTask;

public class HTTPTask extends AsyncTask<String, Integer, String> {

	private String mResponseData;
	private boolean hasError = false;
	private String data;
	private String callType;
	private WebServiceCallBack callback;

	public HTTPTask(String data, String callType, WebServiceCallBack callback) {
		this.data = data;
		this.callType = callType;
		this.callback = callback;
	}

	@Override
	protected String doInBackground(String... params) {
		try {
			mResponseData = CallWebService.SendRequest(data, callType);
			if (mResponseData.equals("")) {
				hasError = true;
			}
		} catch (Exception e) {
			hasError = true;
			e.printStackTrace();
		}
		return mResponseData;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if (hasError) {
			callback.onRequestComplete("ERROR", callType);
		} else {
			callback.onRequestComplete(result, callType);
		}
	}

}
