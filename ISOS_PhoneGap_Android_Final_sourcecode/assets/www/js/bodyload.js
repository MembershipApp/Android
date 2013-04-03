window.token; //global declaration for store token value

//getting token from iOS native 
function getTokenValue(returnSuccessAPN)
{
    PushNotification.getRegisterDevice(nativePluginResultHandlerAPN,nativePluginErrorHandlerAPN,returnSuccessAPN);
}

//Sucess Notification Token
function nativePluginResultHandlerAPN (notificationToken) {
    //alert("Token SUCCESS: \r\n"+notificationToken );
    token=notificationToken;
}
//Failure Notification Token
function nativePluginErrorHandlerAPN (error) {
}   

//called Native Web Service

function callLoginWebServiceToNative(returnSuccessgetLoginService)
{
	LoginWebService.getLoginService(nativePluginResultHandlergetLoginService,nativePluginErrorHandlergetLoginService,returnSuccessgetLoginService);
}

//Sucess Web Service
function nativePluginResultHandlergetLoginService (sucess) {
    
}
//Failure Web Service
function nativePluginErrorHandlergetLoginService(error) {
}


//Called Google Analytics
function getGoogleAnalytics(returnSuccessGoogleAnalytics)
{
    GoogleAnalytics.getGoogleAnalytics(nativePluginResultHandlergetGoogleAnalytics,nativePluginErrorHandlergetGoogleAnalytics,returnSuccessGoogleAnalytics);
}
//Sucess Google Analytics
function nativePluginResultHandlergetGoogleAnalytics (getGoogleAnalyticsSucess) {
    
}
//Failure Google Analytics
function nativePluginErrorHandlergetGoogleAnalytics(getGoogleAnalyticsError) {
}

//Called Google Analytics Track Event
function getGoogleAnalyticsTrackEvent(returnSuccessGoogleAnalyticsTrackEvent)
{
    GoogleAnalyticsTrackEvent.getGoogleAnalyticsTrackEvent(successGooleAnalyticsTrackEvent,failedGooleAnalyticsTrackEvent,returnSuccessGoogleAnalyticsTrackEvent);
}

function successGooleAnalyticsTrackEvent(sucessTrackEvent)
{

}
function failedGooleAnalyticsTrackEvent(failedTrackEvent)
{
    
}

//Called Google Analytics Track View
function getGoogleAnalyticsTrackPageView(returnSuccessGoogleAnalyticsTrackEventPageView)
{
    GoogleAnalyticsTrackPageview.getGoogleAnalyticsTrackPageview(successGooleAnalyticsTrackPageView,failedGooleAnalyticsTrackPageView,returnSuccessGoogleAnalyticsTrackEventPageView);
}

function successGooleAnalyticsTrackPageView(sucessTrackPageView)
{
    
}
function failedGooleAnalyticsTrackPageView(failedTrackPageView)
{
    
}


//Custom Alert for Server Validation 
function customAlert(message){
    navigator.notification.alert(
                                 message,
                                 callBackFunctionB, // Specify a function to be called
                                 'International SOS',
                                 "OK"
                                 );
    function callBackFunctionB(){
    	
    }
}



//Image Video Click
function playVideo(returnVideoPlay)
{
	PlayVideo.getVideoPlay(sucessVideoPlay,failVideoPlay,returnVideoPlay);
}
function sucessVideoPlay(sucessPlay)
{
    
}
function failVideoPlay(failedPlay)
{
    
}



//Child Browser Open External Link
function getExternalLink(returnExternalLink)
{
    ChildBrowser.getExternalLink(successExternalLink,failedExternalLink,returnExternalLink);
}

function successExternalLink(sucessExternalLink)
{

}
function failedExternalLink(failedExternalLink)
{
    
}
