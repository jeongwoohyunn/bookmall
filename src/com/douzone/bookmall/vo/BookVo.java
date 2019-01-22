package com.douzone.bookmall.vo;

public class BookVo {
	
	private Integer price;
	private Integer category_no;
	private String book_name;
	private String category_name;
	private Integer book_no;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getCategory_no() {
		return category_no;
	}

	public void setCategory_no(Integer category_no) {
		this.category_no = category_no;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Integer getBook_no() {
		return book_no;
	}

	public void setBook_no(Integer book_no) {
		this.book_no = book_no;
	}

	@Override
	public String toString() {
		return getBook_no() + " " + getBook_name() + ", " + getCategory_name() + ", " + getPrice();
	}

}
