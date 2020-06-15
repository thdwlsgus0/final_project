var main = {
	init:function(){
		var _this = this;
		$('#btn-register').on('click', function(){
			_this.register();
		});
		$('#input-id').on('focusout', function(){
			_this.focusOutId();
		});
		$('#btn-gen-male').on('click', function(){
			_this.gender(true);
		});
		$('#btn-gen-female').on('click', function(){
			_this.gender(false);
		});
	},
	register:function(){
		var _this = this;
		var str_birth = $('#Mem_birth_yy').val() + 
				$('#Mem_birth_mm').val() + 
				$('#Mem_birth_dd').val() + '';
		if(!_this.pwOverCheck()) return;
		var data = {
			id: $('#Mem_ID').val(),
			pw: $('#Mem_password').val(),
			//age: parseInt($('#Mem_age').val()),
			favor: $('#Mem_favor').val(),
			birth: str_birth,
			gender: $('#Mem_gender').val(),
			email: $('#Mem_email').val(),
			phone: $('#Mem_phone').val()
		}
		$.ajax({
			type: 'POST',
			url: '/recipe/member/regist.do',
			dataType: 'text',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(data)
		}).done(function(){
			alert('회원가입 성공');
			window.location.href='/recipe/loginForm.do';
		}).fail(function(err){
			console.log(err)
			alert('잘못된 접근');
		});
	},
	focusOutId:function() {
		if(false){ //db연동필요: 아이디 중복 체크
			console.log('사용할 수 없는 아이디입니다.') //UI 처리해야 함
		}
	},
	pwOverCheck:function(){
		_pw = $('#Mem_password').val();
		_pw2 = $('#Mem_password2').val();
		if(_pw != _pw2){
			console.log(_pw + ":" + _pw2)
			console.log('비밀번호가 다릅니다.'); //UI 처리해야 함
			return false;
		}
		return true;
	},
	gender:function(isMale){
		if(isMale){
			$("#Mem_gender").val('남자');
		}else{
			$("#Mem_gender").val('여자');
		}
	}
	
};
main.init();