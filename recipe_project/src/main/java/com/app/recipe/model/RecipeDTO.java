package com.app.recipe.model;

public class RecipeDTO {
	private int seq;				// 등록 순번
	private int recipe_id;			// 레시피 고유 번호
	private String recipe_nm_ko;	// 레시피 명
	private String sumry;			// 레시피 간단 소개
	private String nation_code;		// 레시피 유형 코드
	private String nation_nm;		// 레시피 유형 명(한식, 중국, 서양)
	private String ty_code;			// 레시피 분류 코드
	private String ty_nm;			// 레시피 분류 명
	private String cooking_time;	// 조리시간
	private String calorie;			// 칼로리
	private String img_url;			// 대표이미지 URL
	private String det_url;			// 상세 URL
	private int good;				// 좋아요 카운트
	private String datetime;		// 레시피 등록 날짜
	private String mem_id;			// 레시피 등록한 멤버 고유 번호
	private String video_id;		// 레시피 관련 유튜브 비디오 아이디
	private int hit;

	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public int getRecipe_id() {
		return recipe_id;
	}
	
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	
	public String getRecipe_nm_ko() {
		return recipe_nm_ko;
	}
	
	public void setRecipe_nm_ko(String recipe_nm_ko) {
		this.recipe_nm_ko = recipe_nm_ko;
	}
	
	public String getSumry() {
		return sumry;
	}

	public void setSumry(String sumry) {
		this.sumry = sumry;
	}
	
	public String getNation_code() {
		return nation_code;
	}
	
	public void setNation_code(String nation_code) {
		this.nation_code = nation_code;
	}
	
	public String getNation_nm() {
		return nation_nm;
	}
	
	public void setNation_nm(String nation_nm) {
		this.nation_nm = nation_nm;
	}
	
	public String getTy_code() {
		return ty_code;
	}
	
	public void setTy_code(String ty_code) {
		this.ty_code = ty_code;
	}
	
	public String getTy_nm() {
		return ty_nm;
	}
	
	public void setTy_nm(String ty_nm) {
		this.ty_nm = ty_nm;
	}
	
	public String getCooking_time() {
		return cooking_time;
	}
	
	public void setCooking_time(String cooking_time) {
		this.cooking_time = cooking_time;
	}
	
	public String getCalorie() {
		return calorie;
	}
	
	public void setCalorie(String calorie) {
		this.calorie = calorie;
	}
	
	public String getImg_url() {
		return img_url;
	}
	
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
	public String getDet_url() {
		return det_url;
	}
	
	public void setDet_url(String det_url) {
		this.det_url = det_url;
	}
	
	public int getGood() {
		return good;
	}
	
	public void setGood(int good) {
		this.good = good;
	}
	
	public String getDatetime() {
		return datetime;
	}
	
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}
	
	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
}
