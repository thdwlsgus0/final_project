package com.app.recipe.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;	
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.recipe.model.RecipeCmtDTO;
import com.app.recipe.service.RecipeCmtService;

@Controller
public class RecipeCmtController {
	@Inject
	RecipeCmtService rrsc;
	
	private ModelAndView getInfoRelay(ModelAndView mv, int seq) {
		int totalC = rrsc.getTotalRecipeCmt(seq);
		
		mv.addObject("seq", seq);
		mv.addObject("totalC", totalC);
		
		return mv;
	}
	
	@GetMapping("/recipe/showRecipeCmtList.do")
	public ModelAndView showRecipeCmtList(HttpServletRequest request,
										ModelAndView mv) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		mv = getInfoRelay(mv, seq);
		
		mv.setViewName("/recipe/showRecipeCmtList");
		
		return mv;
	}

	@GetMapping("/recipe/getRecipeCmtList.do")
	public ModelAndView getRecipeCmtList(HttpServletRequest request,
										ModelAndView mv) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String mem_id = request.getParameter("mem_id");
		List<RecipeCmtDTO> list = rrsc.getRecipeCmtList(seq);
			
		mv = getInfoRelay(mv, seq);
		
		mv.addObject("list", list);
		mv.addObject("mem_id", mem_id);
		mv.setViewName("/recipe/getRecipeCmtList");
		
		return mv;
	}
	
	
	@PostMapping("/recipe/writeCmt.do")
	public ModelAndView writeCmt(HttpServletRequest request,
									RecipeCmtDTO dto,
									ModelAndView mv,
									@RequestParam(defaultValue = "0") int parent_seq,
									@RequestParam(defaultValue = "") String parent_id,
									@RequestParam(defaultValue = "0") int lvl) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String mem_id = request.getParameter("mem_id");
		String cmt = request.getParameter("cmt");
		
		dto.setRecipe_seq(seq);
		dto.setParent_seq(parent_seq);
		dto.setMem_id(mem_id);
		dto.setParent_id(parent_id);
		dto.setCmt(cmt);
		dto.setLvl(lvl);
		
		rrsc.writeCmt(dto);
		List<RecipeCmtDTO> list = rrsc.getRecipeCmtList(seq);
		mv.addObject("seq", seq);
		mv.addObject("list", list);
		mv.setViewName("/recipe/getRecipeCmtList");
		
		return mv;
	}
	
	@PostMapping("/recipe/modifyCmt.do")
	public ModelAndView modifyCmt(HttpServletRequest request,
									RecipeCmtDTO dto,
									ModelAndView mv) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int cmt_seq = Integer.parseInt(request.getParameter("cmt_seq"));
		String cmt = request.getParameter("cmt");
		
		dto.setCmt_seq(cmt_seq);
		dto.setCmt(cmt);
		
		rrsc.modifyCmt(dto);
		
		List<RecipeCmtDTO> list = rrsc.getRecipeCmtList(seq);
		
		mv = getInfoRelay(mv, seq);
		mv.addObject("list", list);
		mv.setViewName("/recipe/getRecipeCmtList");
		
		return mv;
		
	}
	
	@PostMapping("/recipe/deleteCmt.do")
	@ResponseBody
	public int deleteCmt(HttpServletRequest request,
									RecipeCmtDTO dto,
									ModelAndView mv) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int cmt_seq = Integer.parseInt(request.getParameter("cmt_seq"));
		
		dto.setRecipe_seq(seq);
		dto.setCmt_seq(cmt_seq);
		
		int childernCnt = rrsc.getChildernCnt(dto);
		
		if(childernCnt < 1) {
			rrsc.deleteCmt(dto);
		}
		List<RecipeCmtDTO> list = rrsc.getRecipeCmtList(seq);
	
		return childernCnt;
	}
	
}
