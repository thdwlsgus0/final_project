function google_init() {
	gapi.load('auth2', function() {
		var gauth = gapi.auth2.init({
			client_id : '1052083875747-pmk3tkidgcqvfahkf729t3acqbsfamol.apps.googleusercontent.com',
			scope: 'profile'
		});
		return;
		gauth.then(function(){
			console.log('init success');
			var isLogined = gauth.isSignedIn.get();
			if(isLogined) {
				$('#authBtn').val('Logout');
			} else {
				$('#authBtn').val('Login');
			}
		}, function(){
			console.error('init fail');
		});
	});
	alert('${error}');
	if('${error}') alert('${error}');
	else if('${logout}') alert('${logout}');
}
function google_init() {
	gapi.load('auth2', function() {
		var gauth = gapi.auth2.init({
			client_id : '1052083875747-pmk3tkidgcqvfahkf729t3acqbsfamol.apps.googleusercontent.com',
			scope: 'profile'
		});
		return;
		gauth.then(function(){
			console.log('init success');
			var isLogined = gauth.isSignedIn.get();
			if(isLogined) {
				$('#authBtn').val('Logout');
			} else {
				$('#authBtn').val('Login');
			}
		}, function(){
			console.error('init fail');
		});
	});
}
function google_login(flag){
	var gauth = gapi.auth2.getAuthInstance();
	if(flag == true) {
		gauth.signIn().then(function(){
			if(gauth.isSignedIn.get() == true){
				var profile = gauth.currentUser.get().getBasicProfile();
				var email = profile.getEmail();
				var name = profile.getName();
				var auth = 'google';
				$('#mem_id').attr('type', 'hidden');
				$('#mem_id').val('auth!'+auth+'!'+email+'!'+name);
				$('#logiform').submit();
			}
		});
	}
}