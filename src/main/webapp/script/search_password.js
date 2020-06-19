var main = {
	 init:function(){
		 var _this = this;
		 $("#Mem_email").on('focusout', function(){_this.focusEmail();});
		 $("#Mem_ID").on('focusout', function(){_this.focusId();});
	     $("#btn-search").on('click', function(){_this.search_password();});
	 },
	 focusEmail:function(){
		  var email = $("#Mem_email").val();
		  var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		  if(!regEmail.test(email)){
			  $("#email_check").html('<font color="red">이메일이 유효하지 않습니다</font>');
		      return false;
		  }else{
			  $("#email_check").html('<font color="green">올바른 이메일입니다.</font>');
			  return true;
		  }
	 },
	 focusId:function(){
		 id = $("#Mem_ID").val();
		 if(id.length<5 || id.length>20){
			 $('#id_check').html('<font color="red">5~20자 이상이어야 합니다.</font>');
			 return false;
		 }else {
			 $("#id_check").html('<font color="green">아이디 사용 가능</font>');
			 return true;
		 }
	 },
};
main.init();