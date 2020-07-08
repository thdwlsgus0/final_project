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
function google_login(flag){
	var gauth = gapi.auth2.getAuthInstance();
	if(flag == true) {
		gauth.signIn().then(function(){
			google_viewprofile();
			//alert('Logined');
			//location.reload();
		});
	} else {
		gauth.signOut().then(function(){
			//alert('Logouted');
		});
	}
}
function google_viewprofile(){
	var gauth = gapi.auth2.getAuthInstance();
	if(gauth.isSignedIn.get() == true){
		var profile = gauth.currentUser.get().getBasicProfile();
		var name = profile.getName();
		var email = profile.getEmail();
		var imageUrl = profile.getImageUrl();
		$('#get_email').html('logined email: ' + email);
		google_sendprofiletocontrol(email, name, imageUrl);
	}
	else $('#get_email').html('');
}
function google_sendprofiletocontrol(email, name, imageUrl){
	var data = {
		email: email,
		name: name,
		imageUrl: imageUrl
	}
	$.ajax({
		type: 'POST',
		url: '/login/google.do',
		dataType: 'json',
		contentType: 'application/json; charset=utf-8',
		data: JSON.stringify(data),
		async: false
	}).done(function(res){
		url = res['url']
	});
	google_login(false);
	
	window.location.href = url;
}
function normal_login(){
	id = $('#mem_id').val();
	pw = $('#mem_pw').val();
	data = {
		id: id,
		pw: pw
	}
	$.ajax({
		type: 'POST',
		url: '/member/login.do',
		dataType: 'text',
		contentType: 'application/json; charset=utf-8',
		data: JSON.stringify(data),
		async: false
	}).done(function(){
		flag = true;
	}).fail(function(){
		flag = false;
	});
	if(flag) window.location.href = '/member/index.do';
	else alert('로그인 실패!');
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
			google_viewprofile();
			//alert('Logined');
			//location.reload();
		});
	} else {
		gauth.signOut().then(function(){
			//alert('Logouted');
		});
	}
}
function google_viewprofile(){
	var gauth = gapi.auth2.getAuthInstance();
	if(gauth.isSignedIn.get() == true){
		var profile = gauth.currentUser.get().getBasicProfile();
		var name = profile.getName();
		var email = profile.getEmail();
		var imageUrl = profile.getImageUrl();
		$('#get_email').html('logined email: ' + email);
		google_sendprofiletocontrol(email, name, imageUrl);
	}
	else $('#get_email').html('');
}
function google_sendprofiletocontrol(email, name, imageUrl){
	var data = {
		email: email,
		name: name,
		imageUrl: imageUrl
	}
	$.ajax({
		type: 'POST',
		url: '/login/google.do',
		dataType: 'json',
		contentType: 'application/json; charset=utf-8',
		data: JSON.stringify(data),
		async: false
	}).done(function(res){
		flag_login = res['login'];
		flag_regi = res['regi'];
	});
	google_login(false);
	
	if(flag_regi) {
		window.location.href = '/member/signup.do';
		return;
	}
	if(flag_login) window.location.href = '/';
	else alert('이메일 인증을 받아주세요!');
}