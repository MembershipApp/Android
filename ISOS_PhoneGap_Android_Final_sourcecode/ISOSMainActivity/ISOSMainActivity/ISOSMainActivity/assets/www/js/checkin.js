//Called after checkin button clicked
function onCheckInClick()
{
	//Start loading 
    
    flag=false;
    manualCheckinFlag = true;
    var checkinUser=localStorage.getItem('currentUserName');
    var checkinToken=localStorage.getItem('fetchCheckinToken');
    var checkinLat=localStorage.getItem('currentLat');
    var checkinLong=localStorage.getItem('currentLong');
    //called checkin function
    checkinService(checkinUser,checkinToken,checkinLat,checkinLong);
}
function successCheckIn(){
    manualCheckinFlag=false;
    $("#CheckinSuccessful").remove();
    $("#btnCheckIn").css("display","block");
}