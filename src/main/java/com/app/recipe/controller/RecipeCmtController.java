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
	
	private ModelAndView getInfoRelay(ModelAndView mv, int recipe_seq) {
		int totalC = rrsc.getTotalRecipeCmt(recipe_seq);
		
		mv.addObject("recipe_seq", recipe_seq);
		mv.addObject("totalC", totalC);
		
		return mv;
	}
	
	// AJAX 호출 - 1
	// 상세 레시피 시 초기 페이지 로딩시 댓글 불러오기,
	// 또는 입력/삭제/수정 후 댓글 상태를 보여주는 함수
	@GetMapping("/recipe/showRecipeCmtList.do")
	public ModelAndView showRecipeCmtList(HttpServletRequest request,
										ModelAndView mv) {
		int recipe_seq = Integer.parseInt(request.getParameter("seq"));
		
		mv = getInfoRelay(mv, recipe_seq);	// recipe_seq, totalC 데이터 공유시켜주는 사용자 정의 함수
		
		mv.setViewName("/recipe/showRecipeCmtList.jsp");
		
		return mv;
	}
	
	// AJAX 호출 - 2
	// 달린 댓글 전체를 보여 주는 페이지(getRecipeCmtData.jsp)로,
	// 각 상세 레시피에 달린 댓글 전체를 DB로부터 정보를 받아 이 페이지에 표시한다.
	@GetMapping("/recipe/getRecipeCmtList.do")
	public ModelAndView getRecipeCmtList(HttpServletRequest request,
										ModelAndView mv) {
		int recipe_seq = Integer.parseInt(request.getParameter("recipe_seq"));
		
		List<RecipeCmtDTO> list = rrsc.getRecipeCmtList(recipe_seq);
			
		mv = getInfoRelay(mv, recipe_seq);	// recipe_seq, totalC 데이터 공유시켜주는 사용자 정의 함수
		
		mv.addObject("list", list);
		mv.setViewName("/recipe/getRecipeCmtList.jsp");
		
		return mv;
	}
	
	
	@PostMapping("/recipe/writeCmt.do")
	public ModelAndView writeCmt(HttpServletRequest request,
									RecipeCmtDTO dto,
									ModelAndView mv,
									@RequestParam(defaultValue = "0") int parent_seq,
									@RequestParam(defaultValue = "") String parent_id,
									@RequestParam(defaultValue = "0") int lvl) {
		int recipe_seq = Integer.parseInt(request.getParameter("recipe_seq"));
		String mem_id = request.getParameter("mem_id");
		String cmt = request.getParameter("cmt");
		
		dto.setRecipe_seq(recipe_seq);
		dto.setParent_seq(parent_seq);
		dto.setMem_id(mem_id);
		dto.setParent_id(parent_id);
		dto.setCmt(cmt);
		dto.setLvl(lvl);
		
		rrsc.writeCmt(dto);
		List<RecipeCmtDTO> list = rrsc.getRecipeCmtList(recipe_seq);
		mv.addObject("recipe_seq", recipe_seq);
		mv.addObject("list", list);
		mv.setViewName("/recipe/getRecipeCmtList.jsp");
		
		return mv;
	}
	
	@PostMapping("/recipe/modifyCmt.do")
	public ModelAndView modifyCmt(HttpServletRequest request,
									RecipeCmtDTO dto,
									ModelAndView mv) {
		int recipe_seq = Integer.parseInt(request.getParameter("recipe_seq"));
		int cmt_seq = Integer.parseInt(request.getParameter("cmt_seq"));
		String cmt = request.getParameter("cmt");
		
		dto.setCmt_seq(cmt_seq);
		dto.setCmt(cmt);
		
		rrsc.modifyCmt(dto);
		
		List<RecipeCmtDTO> list = rrsc.getRecipeCmtList(recipe_seq);
		
		mv = getInfoRelay(mv, recipe_seq);	// recipe_seq, totalC 데이터 공유시켜주는 사용자 정의 함수
		mv.addObject("list", list);
		mv.setViewName("/recipe/getRecipeCmtList.jsp");
		
		return mv;
		
	}
	
	@PostMapping("/recipe/deleteCmt.do")
	@ResponseBody
//	public ModelAndView deleteCmt(HttpServletRequest request,
	public int deleteCmt(HttpServletRequest request,
									RecipeCmtDTO dto,
									ModelAndView mv) {
		int recipe_seq = Integer.parseInt(request.getParameter("recipe_seq"));
		int cmt_seq = Integer.parseInt(request.getParameter("cmt_seq"));
		
		dto.setRecipe_seq(recipe_seq);
		dto.setCmt_seq(cmt_seq);
		
		// 자식 댓글 수 리턴, 수가 1 이상이면 댓글을 삭제할 수 없다는 메세지 발생.
		int childernCnt = rrsc.getChildernCnt(dto);
		
		if(childernCnt < 1) {
			// 실제 삭제 sql문이 수행되는 것이 아니고, 댓글 내용만 null으로 변경(update문 수행)
			rrsc.deleteCmt(dto);
		}
		List<RecipeCmtDTO> list = rrsc.getRecipeCmtList(recipe_seq);
//		mv = getInfoRelay(mv, recipe_seq);	// recipe_seq, totalC 데이터 공유시켜주는 사용자 정의 함수
//		mv.addObject("childernCnt", childernCnt);
//		mv.addObject("list", list);
//		
//		mv.setViewName("/recipe/getRecipeCmtList.jsp");
		
		return childernCnt;
	}
	
}
