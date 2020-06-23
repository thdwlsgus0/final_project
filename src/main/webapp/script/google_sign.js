function init() {
	gapi.load('auth2', function() {
		var gauth = gapi.auth2.init({
			client_id : '1052083875747-pmk3tkidgcqvfahkf729t3acqbsfamol.apps.googleusercontent.com',
			scope: 'profile'
		});

		gauth.then(function(){
			console.log('init success');
			var isLogined = gauth.isSignedIn.get();
			if(isLogined) {
				$('#authBtn').val('Logout');
				viewprofile();
			} else {
				$('#authBtn').val('Login');
			}
		}, function(){
			console.error('init fail');
		});
	});
}
function login(){
	var gauth = gapi.auth2.getAuthInstance();
	if($('#authBtn').val() == 'Login') {
		gauth.signIn().then(function(){
			alert('Logined');
			location.reload();
		});
	} else {
		gauth.signOut().then(function(){
			alert('Logouted');
			location.reload();
		});
	}
}
function viewprofile(){
	var gauth = gapi.auth2.getAuthInstance();
	if(gauth.isSignedIn.get() == true){
		var email = gauth.currentUser.get().getBasicProfile().getEmail();
		$('#get_email').html('logined email: ' + email);
	}
	else $('#get_email').html('');
}