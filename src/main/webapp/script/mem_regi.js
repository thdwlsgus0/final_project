var main = {
	init:function(){
		var _this = this;
		$.datepicker.setDefaults({
	        dateFormat: 'yy-mm-dd', prevText: '이전 달', nextText: '다음 달',
	        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	        showMonthAfterYear: true, yearSuffix: '년', yearRange: "-100:+0",
	        onClose: function() { _this.focusOutAge(); }
	    });
		$('#btn-register').on('click', function(){ _this.register(); });
		$('#Mem_ID').on('focusout', function(){ _this.focusOutId(); });
		$('#Mem_password').on('focusout', function(){ _this.pwOverCheck(); });
		$('#Mem_password2').on('focusout', function(){ _this.pwOverCheck(); });
		$('#btn-gen-male').on('click', function(){ _this.gender(true); });
		$('#btn-gen-female').on('click', function(){ _this.gender(false); });
		$('#Mem_birth').datepicker({changeMonth: true, changeYear: true});
		$('#Mem_birth').val(new Date().toISOString().substring(0, 10));
		$('#Mem_email').on('focusout', function(){ _this.emailValid(); })
		$('#div-check').hide();
	},
	emailCheck:function(){
		var _this = this;
		if(!_this.emailValid()) return;
		
		alert('이메일로 인증번호를 발송했습니다!')
		$('#div-check').show();
		var data = {
			id: $('#Mem_ID').val(),
			email: $('#Mem_email').val()
		}
		$.ajax({
			type: 'POST',
			url: '/recipe/email/auth.do',
			dataType: 'text',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(data),
			async: false
		}).done(function(res){
			saveres = res.trim();
		});
		return saveres;
	},
	register:function(){
		// 해당 함수 내용은 signup.jsp정리되면 폼에서 처리하도록 바꾸는게 좋음
		var _this = this;
		if(!_this.focusOutId() || !_this.pwOverCheck() || 
				!_this.focusOutAge() || !_this.emailValid())
			return;
		
		var birth = new Date($('#Mem_birth').val());
		var str_birth =  birth.getFullYear() +
				birth.getMonth() + 
				birth.getDate() + '';
		if(!_this.pwOverCheck()) return;
		var data = {
			id: $('#Mem_ID').val(),
			pw: $('#Mem_password').val(),
			favor: $('#Mem_favor').val(),
			birth: str_birth,
			gender: $('#Mem_gender').val(),
			email: $('#Mem_email').val(),
			phone: $('#Mem_phone').val(),
			check: _this.emailCheck()
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
		});
	},
	focusOutId:function() {
		id = $('#Mem_ID').val()
		if(id.length < 5 || id.length > 20){
			$('#id_check').html('<font color="red">id는 5~20자이어야 합니다.</font>');
			return false;
		}
		$.ajax({
			type: 'POST',
			url: '/recipe/member/idcheck.do',
			dataType: 'text',
			contentType: 'text/text; charset=utf-8',
			data: id,
			async: false
		}).done(function(res){
			saveres = res.trim();
			$('#id_check').html(saveres);
		});
		if(saveres.includes('green')) return true;
		return false;
	},
	pwOverCheck:function(){
		_pw = $('#Mem_password').val();
		_pw2 = $('#Mem_password2').val();
		if((_pw.length < 8 || _pw.length > 16) || (_pw2.length < 8 || _pw2.length > 16)){
			$('#pw_check').html('<font color="red">비밀번호는 8~16자이어야 합니다.</font>');
			return false;
		}
		
		if(_pw != _pw2){
			$('#pw_check').html('<font color="red">비밀번호가 다릅니다.</font>');
			return false;
		}
		$('#pw_check').html('');
		return true;
	},
	gender:function(isMale){
		if(isMale) {
			$("#Mem_gender").val('남자');
			$("#btn-gen-male").attr('class', 'btn btn-sm btn-success');
			$("#btn-gen-female").attr('class', 'btn btn-sm btn-default');
		}
		else {
			$("#Mem_gender").val('여자');
			$("#btn-gen-female").attr('class', 'btn btn-sm btn-success');
			$("#btn-gen-male").attr('class', 'btn btn-sm btn-default');
		}
	},
	focusOutAge:function() {
		curYear = new Date().getFullYear();
		selYear = new Date($('#Mem_birth').val()).getFullYear();
		age = curYear - selYear + 1;
		$('#Mem_age').val(age);
		console.log(age);
		return true;
	},
	emailValid:function(){
		email = $('#Mem_email').val()
		reg = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
		if(reg.test(email)){
			$('#email_check').html('');
			return true;
		}
		$('#email_check').html('<font color="red">이메일 형식이 잘못되었습니다.</font>');
		return false;
	}
};
main.init();