package com.app.recipe.model;

public class RecipeCmtDTO {
	private int cmt_seq;
    private int recipe_seq;
    private int parent_seq;
    private String mem_id;
    private String parent_id;
	private String cmt;
    private int lvl;
    private String mem_profile;
	private String regdate;
	
    public int getCmt_seq() {
		return cmt_seq;
	}
	public void setCmt_seq(int cmt_seq) {
		this.cmt_seq = cmt_seq;
	}
	public int getRecipe_seq() {
		return recipe_seq;
	}
	public void setRecipe_seq(int recipe_seq) {
		this.recipe_seq = recipe_seq;
	}
	public int getParent_seq() {
		return parent_seq;
	}
	public void setParent_seq(int parent_seq) {
		this.parent_seq = parent_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public String getMem_profile() {
		return mem_profile;
	}
	public void setMem_profile(String mem_profile) {
		this.mem_profile = mem_profile;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "RecipeCmtDTO [cmt_seq=" + cmt_seq + ", recipe_seq=" + recipe_seq + ", parent_seq=" + parent_seq
				+ ", mem_id=" + mem_id + ", parent_id=" + parent_id + ", cmt=" + cmt + ", lvl=" + lvl + ", mem_profile="
				+ mem_profile + ", regdate=" + regdate + "]";
	}
    
}
