package com.app.recipe.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.recipe.model.MemberModVo;
import com.app.recipe.model.RegisterDto;
import com.app.recipe.service.RegisterService;
import com.app.recipe.util.s3.AmazonS3Service;
import com.app.recipe.util.s3.AmazonS3Service.ImgPath;

@Controller
public class ProfileController {
	
	@Inject private RegisterService svc;
	@Inject private	AmazonS3Service aws;
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MEMBER')")
	@GetMapping("/profile")
	public String index(Model model, HttpSession session) {
		String id;
		try { id = session.getAttribute("realId").toString();
		} catch(Exception e) { return "/access"; }
		
		RegisterDto dto = svc.select(id);
		if(svc.idcheck(id) || dto == null) return "/access";
		
		model.addAttribute("mem_id", id);
		model.addAttribute("mem_favor", dto.getFavor());
		model.addAttribute("mem_phone", dto.getPhone());
		model.addAttribute("mem_profile", aws.getFilePath(dto.getProfile(), ImgPath.PROFILE));
		return "/member/modify";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MEMBER')")
	@PostMapping("/member/modify")
	public String modify(MemberModVo vo) {
		String orifile = vo.getOrifile();
		String file = aws.uploadFile(vo.getFile(), ImgPath.PROFILE);
		
		RegisterDto dto = svc.select(vo.getId());
		dto.setPw(vo.getPw());
		dto.setFavor(vo.getFavor());
		dto.setPhone(vo.getPhone());
		
		if(file != null && file.length() > 0) {
			dto.setProfile(file);
		}
		
		if(svc.update(dto))
			if(orifile != null && orifile.length() > 0)
				aws.deleteFile(orifile, ImgPath.PROFILE);
		
		return "redirect:/";
	}
	
	@GetMapping("/access")
	public String accessdenied() {
		return "/member/access";
	}
}
