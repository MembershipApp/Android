//global declaration for store lat and long value
window.getCurrentLat;
window.getCurrentLong;

/* Fetch Geolocation Data */
function getGeolcation() {
	
    navigator.geolocation.getCurrentPosition(onSuccess, onError , { enableHighAccuracy: true });
    //var watchId = navigator.geolocation.watchPosition(onSuccess, onError, { timeout: 1000 });
   
}
/* onSuccess Callback for getCurrentPosition */
function onSuccess(position) {    
    var geoLatitude=position.coords.latitude;
    var geoLongitude=position.coords.longitude;
    getCurrentLat=geoLatitude;
    getCurrentLong=geoLongitude;
           
    //store getCurrentLat,getCurrentLong
    localStorage.setItem('currentLat', getCurrentLat); //defining a local storage for login User
    localStorage.setItem('currentLong',getCurrentLong);//defining a local storage for remember me flag
	
	//alert(isLogin);
	
	if(isLogin) {
	 	var checkinUser=localStorage.getItem('currentUserName');
        var checkinToken=localStorage.getItem('fetchCheckinToken');
	 	checkinService(checkinUser,checkinToken,getCurrentLat,getCurrentLong);
	}
};
/* onError Callback receives a PositionError object*/
function onError(error) {
    alert(3);
    alert('code: '    + error.code    + '\n' + 'message: ' + error.message + '\n');
}
