package com.app.recipe.model;

public class RecipeCmtDTO {
	private int cmt_seq;		// 레시피(게시글) 고유 번호(recipe_info 테이블), primary key
    private int recipe_seq;		// 게시물 seq(recipe_info 테이블, 외래키)
    private int parent_seq;		// 댓글 부모 번호(원본 글인 경우는 0, 대댓글인 경우 부모글의 seq)
    private String mem_id;		// 댓글 작성자 명(member 테이블, 외래키X)
    private String parent_id;   // 부모 댓글 작성자       
	private String cmt;			// 댓글 내용(최대 약 600자)
    private int lvl;			// 댓글 들여쓰기를 위한 변수
    private String mem_profile;	// member 테이블과 조인하여 얻어온 프로필 사진 경로
	private String regdate;		// 댓글 작성일자
	
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
