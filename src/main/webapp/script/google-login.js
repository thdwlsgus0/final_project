var main = {
	init:function(){
		var _this = this;		
		$('#btn-google').on('click', function(){ _this.login(); });
	},
	login:function(){
		var _this = this;
		
		$.ajax({
			type: 'GET',
			url: '/recipe/login/google.do',
			dataType: 'text',
			contentType: 'text/text; charset=utf-8',
			async: false
		}).done(function(res){
			window.location.href=res.trim();
		});
	}
};
main.init();