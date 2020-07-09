package com.app.recipe.model;

public class RecipeDTO {
   private int seq;
   private int recipe_id;
   private String recipe_nm_ko;
   private String sumry;
   private String nation_code;
   private String nation_nm;
   private String ty_code;
   private String ty_nm;
   private String cooking_time;
   private String calorie;
   private String img_url;
   private String det_url;
   private int good;
   private String datetime;
   private String mem_id;
   private String video_id;
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
   
   @Override
	public String toString() {
		return "RecipeDTO [seq=" + seq + ", recipe_id=" + recipe_id + ", recipe_nm_ko=" + recipe_nm_ko + ", sumry="
				+ sumry + ", nation_code=" + nation_code + ", nation_nm=" + nation_nm + ", ty_code=" + ty_code
				+ ", ty_nm=" + ty_nm + ", cooking_time=" + cooking_time + ", calorie=" + calorie + ", img_url="
				+ img_url + ", det_url=" + det_url + ", good=" + good + ", datetime=" + datetime + ", mem_id=" + mem_id
				+ ", video_id=" + video_id + ", hit=" + hit + "]";
	}
}