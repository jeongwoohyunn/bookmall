package com.douzone.bookmall.vo;

public class OrderBookVo {
	private Integer book_no;
	private Integer order_no;
	private Integer amount;
	private Integer category_no;
	private String book_name;

	public Integer getBook_no() {
		return book_no;
	}

	public void setBook_no(Integer book_no) {
		this.book_no = book_no;
	}

	public Integer getOrder_no() {
		return order_no;
	}

	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public Integer getCategory_no() {
		return category_no;
	}

	public void setCategory_no(Integer category_no) {
		this.category_no = category_no;
	}

	@Override
	public String toString() {
		return getBook_no()+" "+getBook_name()+getAmount();
	}

}
