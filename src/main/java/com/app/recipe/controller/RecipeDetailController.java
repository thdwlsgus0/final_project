package com.app.recipe.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.recipe.model.RecipeVO;
import com.app.recipe.service.RecipeService;

@Controller
public class RecipeDetailController {

	@Inject
	private RecipeService svc;

	@GetMapping("/cook/recipeDetail.do")
	public String visit(Model model,
						HttpServletRequest req, 
						HttpServletResponse res) {
		int seq = Integer.parseInt(req.getParameter("seq"));
		
		model.addAttribute("dto", svc.getRecipe(seq));
		model.addAttribute("profile", svc.getRecipe_profile(seq));
		
		//레시피 디테일 재료 정보 가져오기
		List<RecipeVO> getRecipeDetail_1 = svc.getRecipeDetail_1(seq);
		req.setAttribute("list_1", getRecipeDetail_1);
		List<RecipeVO> getRecipeDetail_2 = svc.getRecipeDetail_2(seq);
		req.setAttribute("list_2", getRecipeDetail_2);
		List<RecipeVO> getRecipeDetail_3 = svc.getRecipeDetail_3(seq);
		req.setAttribute("list_3", getRecipeDetail_3);
		//레시피 순서 정보 가져오기
		List<RecipeVO> getRecipeDetail_4 = svc.getRecipeDetail_4(seq);
		req.setAttribute("list_4", getRecipeDetail_4);
		
		String str = "recipe_detail_" + seq;
		Cookie[] cs = req.getCookies();
		boolean flag = false;
		for(Cookie c : cs)
			if(c.getName().equals(str))
				flag = true;
		if(!flag) {
			svc.updatehit(seq);
			res.addCookie(new Cookie(str, ""));
		}
		req.setAttribute("seq", seq);
		
		return "/cook/recipeDetail";
	}
}
