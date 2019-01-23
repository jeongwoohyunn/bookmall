package com.douzone.bookmall.vo;

public class CartVo {
	private Long cart_no;
	private Long amount;
	private Long member_no;
	private Long book_no;
	private String book_name;
	private Long totalprice;
	public Long getCart_no() {
		return cart_no;
	}
	public void setCart_no(Long cart_no) {
		this.cart_no = cart_no;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getMember_no() {
		return member_no;
	}
	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Long getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Long totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return getCart_no() + " "+getBook_name()+", "+getAmount()+", "+getTotalprice();
	}
	
}
