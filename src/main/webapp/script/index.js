function efg_prev(){
	var cur_pos = document.querySelectorAll(".ingre_img li");
    for(var i=0; i<cur_pos.length; i++){
    	if(cur_pos[i].classList.contains('display_none')){
    		cur_pos[i].classList.remove('display_none');
    		cur_pos[i].classList.add('display_block');
    	}
    	else if(cur_pos[i].classList.contains('display_block')){
    		cur_pos[i].classList.remove('display_block');
    		cur_pos[i].classList.add('display_none');
    	}
    }
}
function efg_next(){
	var cur_pos = document.querySelectorAll(".ingre_img li");
	for(var i=0; i<cur_pos.length; i++){
		if(cur_pos[i].classList.contains('display_none')){
    		cur_pos[i].classList.remove('display_none');
    		cur_pos[i].classList.add('display_block');
    	}
    	else if(cur_pos[i].classList.contains('display_block')){
    		cur_pos[i].classList.remove('display_block');
    		cur_pos[i].classList.add('display_none');
    	}
    
	}
}
