package com.app.recipe.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.recipe.dao.RegisterService;
import com.app.recipe.model.MemberModVo;
import com.app.recipe.model.RegisterDto;
import com.app.recipe.util.s3.AmazonS3Service;

@Controller
public class ProfileController {
	
	@Inject private RegisterService svc;
	@Inject private	AmazonS3Service aws;
	
	@GetMapping("/member/profile.do")
	public String index(Model model, HttpSession session) {
		String id;
		try { id = session.getAttribute("realId").toString();
		} catch(Exception e) { return "/member/access.jsp"; }
		
		RegisterDto dto = svc.select(id);
		if(svc.idcheck(id) || dto == null) return "/member/access.jsp";
		
		model.addAttribute("mem_id", id);
		model.addAttribute("mem_favor", dto.getFavor());
		model.addAttribute("mem_phone", dto.getPhone());
		model.addAttribute("mem_profile", aws.getFilePath(dto.getProfile()));
		return "/member/modify.jsp";
	}
	
	@PostMapping("/member/modify.do")
	public String modify(MemberModVo vo) {
		String orifile = vo.getOrifile();
		String file = aws.uploadFile(vo.getFile());
		
		RegisterDto dto = svc.select(vo.getId());
		dto.setPw(vo.getPw());
		dto.setFavor(vo.getFavor());
		dto.setPhone(vo.getPhone());
		
		if(file != null && file.length() > 0) {
			dto.setProfile(file);
		}
		
		if(svc.update(dto))
			if(orifile != null && orifile.length() > 0)
				aws.deleteFile(orifile);
		
		return "redirect:/member/index.do";
	}
}
