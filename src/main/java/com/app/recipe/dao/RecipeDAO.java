package com.app.recipe.dao;

public interface RecipeDAO {
	public int recipe_select(); // ������ ��ȸ��
	public int recipe_total_select(); // �� ������ ����
	public int recipe_food_result(String food_name); // ������ ���� ���
}
