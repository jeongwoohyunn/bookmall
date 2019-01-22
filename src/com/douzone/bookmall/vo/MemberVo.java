package com.douzone.bookmall.vo;

public class MemberVo {
	private Integer no;
	private String name;
	private String call;
	private String email;
	private String password;
	public Integer getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MemberDaoTest [no=" + no + ", name=" + name + ", call=" + call + ", email=" + email + ", password="
				+ password + "]";
	}
}
