/*
 2020.06.15 월요일 
 
// form 유효성검사 
function signup_check(){
	var frm = document.signup_form;
	
	if(frm.Mem_ID == ''){
		alert("아이디를 입력하세요:");
	    frm.Mem_ID.focus();
	}else if(frm.Mem_password ==''){
		alert("패스워드를 입력하세요:");
		frm.Mem_password.focus();
	}else if(frm.Mem_password2 ==''){
		alert("확인 패스워드를 입력하세요:");
		frm.Mem_email.focus();
	}else if(frm.Mem_age == ''){
		alert("나이를 입력하세요:");
		frm.Mem_age.focus();
	}else if(frm.Mem_birth_yy==''){
		alert("태어난 연도를 입력하세요:");
		frm.Mem_birth_yy.focus();
	}else if(frm.Mem_birth_mm==''){
		alert("태어난 월을 입력하세요:");
		frm.Mem_birth_mm.focus();
	}else if(frm.Mem_birth_dd==''){
		alert("태어난 일을 입력하세요:");
		frm.Mem_birth_dd.focus();
	}else if(frm.Mem_phone==''){
		alert("전화번호를 입력하세요:");
		frm.Mem_phone.focus();
	}else{
		frm.submit();
	}
}*/