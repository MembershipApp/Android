//Mapping with phonegap js and Android 

//Google Cloud Messaging 
var PushNotification = {
    getRegisterDevice:function(success, fail,resultType) {
        return Cordova.exec(success, fail, "com.isos.RegisterPluginClass", "gcmRegisterDevice",[resultType]);
	}
};

//Location Updates Geofencing
var Geofencing = {
    getGeofacingLocationUpdates:function(success, fail,resultType){
        return Cordova.exec(success, fail, "com.isos.RegisterPluginClass", "locationUpdatesGeofacing",[resultType]);
    }
};

//Native Web Service Call  
var LoginWebService = {
	getLoginService:function(success, fail,resultType){
		return Cordova.exec(success, fail, "com.isos.RegisterPluginClass", "webServiceCall",[resultType]);
	}
}


//Google Analytics
var GoogleAnalytics={
    getGoogleAnalytics:function(success, fail,resultType){
        return Cordova.exec(success, fail, "com.isos.RegisterPluginClass", "startTrackerWithAccountID",[resultType]);
    }
}

// Google Analytics track Event
var GoogleAnalyticsTrackEvent={
    getGoogleAnalyticsTrackEvent:function(success,fail,options){
        return Cordova.exec(success, fail,"com.isos.RegisterPluginClass", "trackEvent",[options]);
    }
}

//Google Analytics TrackPageView
var GoogleAnalyticsTrackPageview={
    getGoogleAnalyticsTrackPageview:function(success,fail,options){
        return Cordova.exec(success, fail,"com.isos.RegisterPluginClass", "trackPageview",[options]);
    }
}
 
 //Play Video 
 var PlayVideo={
 	getVideoPlay:function(success,fail,options){
 		return Cordova.exec(success, fail,"com.isos.RegisterPluginClass", "playVideo",[options]);
 	}
 }
 
 //Open External Link

 var ChildBrowser={
 		getExternalLink:function(success,fail,options){
 			return Cordova.exec(success, fail,"com.isos.RegisterPluginClass", "showWebPage",[options]);
 		} 
 }