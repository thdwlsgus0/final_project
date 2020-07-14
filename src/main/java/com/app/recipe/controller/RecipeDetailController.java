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

import com.app.recipe.model.RecipeDTO;
import com.app.recipe.model.RecipeVO;
import com.app.recipe.model.RegisterDto;
import com.app.recipe.service.RecipeService;
import com.app.recipe.service.RegisterService;
import com.app.recipe.util.s3.AmazonS3Service;
import com.app.recipe.util.s3.AmazonS3Service.ImgPath;

@Controller
public class RecipeDetailController {

	@Inject
	private RecipeService svc;
	@Inject
	private RegisterService regisvc;
	@Inject
	private AmazonS3Service s3svc;

	@GetMapping("/cook/recipeDetail.do")
	public String visit(Model model,
						HttpServletRequest req, 
						HttpServletResponse res) {
		int seq = Integer.parseInt(req.getParameter("seq"));
		
		RecipeDTO dto = svc.getRecipe(seq);
		model.addAttribute("dto", dto);
		
		String id = (String) dto.getMem_id();
		if(id != null && id.length() != 0) {
			RegisterDto dto2 = regisvc.select(id);
			if(dto2 != null) {
				String profile = s3svc.getFilePath(dto2.getProfile(), ImgPath.PROFILE);
				if(profile != null) model.addAttribute("profile", profile);
			}
		}
		
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
