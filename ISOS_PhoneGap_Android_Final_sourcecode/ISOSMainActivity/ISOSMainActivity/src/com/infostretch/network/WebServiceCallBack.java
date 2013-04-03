package com.infostretch.network;



/**
 * This interface will provide call back mechanism once request completed.
 * 
 * 
 * @author saurabh.gupta
 */
public interface WebServiceCallBack {
	public int MENUE_DEAILS = 0;
	public int FRIST_TIME = 1;
	public int TIMESTAMP_UPDATE = 2;
	public int HOTEL_INFO = 3;
	public int ONE_TOUCH = 4;
	public int SIMPLE_SERVER_CALL = 5;
	public int WHETHER_CALL = 6;
	public int FRIST_TIME_SHOPING = 7;
	public int TIMESTAMP_SHOPING = 8;
	public int LOGIN = 9;
	/**
	 * callback method to provide response data to respected caller
	 * 
	 * @param Object : response data in the form of Object. Need to be type cast before using. 
	 * @param callType : to identify for which web service this call is invoke for
	 *            
	 */
	public abstract void onRequestComplete(Object responseData, String callType);

}
