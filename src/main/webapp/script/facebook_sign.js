window.fbAsyncInit = function() {
	FB.init({
		appId : '314565806372189',
		cookie : true,
		xfbml : true,
		version : 'v7.0'
	});
	var callback = function(response){
		console.log(response);
		//statusChangeCallback(response);
		if(response.status === 'connected'){
			$('#authBtn').val('Logout');
		}else{
			$('#authBtn').val('Login');
		}
	}
	FB.getLoginStatus(callback);
};

(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement(s);
	js.id = id;
	js.src = "https://connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));