package com.douzone.bookmall.vo;

public class CategoryVo {
	private Integer category_no;
	public String name;
	public Integer getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Integer category_no) {
		this.category_no = category_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return category_no +" "+ name;
	}
	
}
