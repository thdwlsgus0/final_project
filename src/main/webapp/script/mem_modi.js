$(function(){
	$("input[name='file']").change(function(){
		try {
			reader = new FileReader()
			reader.readAsDataURL(this.files[0]);
			reader.onload = function(e){
				$('#mem_profile').attr('src', e.target.result);
			}			
		} catch(e) {
			$('#mem_profile').attr('src', null);
		}
	});
	$('#mem_pw').on('focusout', function(){ pwcheck(); });
	$('#mem_pwr').on('focusout', function(){ pwcheck(); });
	$('#mem_modify').submit(function(){
		if(!pwcheck) return false;
	});
});

function pwcheck(){
	pw = $('#mem_pw').val();
	pwr = $('#mem_pwr').val();
	console.log('pw: ' + pw);
	if((pw.length < 8 || pw.length > 16) || (pwr.length < 8 || pwr.length > 16)){
		$('#pw_check').attr('color', 'red');
		$('#pw_check').html('비밀번호는 8~16자이어야 합니다.');
		return false;
	}
	if(pw != pwr) {
		$('#pw_check').attr('color', 'red');
		$('#pw_check').html('두 비밀번호가 서로 다릅니다.');
		return false;
	}
	else {
		$('#pw_check').attr('color', 'green');
		$('#pw_check').html('좋아요!');
	}
	return true;
}