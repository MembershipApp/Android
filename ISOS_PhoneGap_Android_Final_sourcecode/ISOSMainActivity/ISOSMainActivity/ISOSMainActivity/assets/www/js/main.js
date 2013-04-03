window.isLogin = 0;
var AppRouter = Backbone.Router.extend({
    routes: {
       ""  : "home",
       "alertIn" : "alertIn",
       "checkIn" : "checkIn"
         },
       home: function ()
       {
           if(isLogin == "0"){
               $('#wrapper').append(new loginHeaderView().render() );
               $('#wrapper').append(new videoView().render() );
               $('#wrapper').append(new loginView().render() );
           }
           else{
                new dashBoardView();
           }
       },
       alertIn: function()
       {
           //for dashboard page
           flag=false;
           
           //Google Analytics Track Page View
           googleAnalytics("trackPage","/Alert Page");
		   
           alertview = new alertView();
           var parsedJson;
      	   parsedJson = JSON.parse(localStorage.getItem("notificationAlert"));
           var str='';
           for(var i=0;i<parsedJson.length;i++){
                        var li_element = parsedJson[i].Message;
                        var p_element = parsedJson[i].Date;
                        str += "<div class=\"format-row\"><div class=\"plus-sign-orange\">"+"<img src=\"images/Plus__Orange.png\"/></div>"+"<div class='message-text'><p>"+li_element+"</p>"+"<p>"+p_element+"</p></div></div>";
            }
            var width1 = $('body').width();
            $("#datalist").html(str);
            $('.format-row').width(width1); 
            setTimeout(function(){
                $('.plus-sign-orange').css('height', $('.format-row').height());
            },0);
       },
       checkIn: function()
       {
         //Google Analytics Track Page View
         googleAnalytics("trackPage","/Alert Page");
		   
         var checkin = new checkInView();
         //checkinInitialize();
       }
                                       
});
// Instantiation of AppRouter
app = new AppRouter();
Backbone.history.start();