package com.douzone.bookmall.vo;

public class MemberVo {
	private Integer member_no;
	private String name;
	private String tel;
	private String email;
	private String password;
	public Integer getMember_no() {
		return member_no;
	}
	public void setMember_no(Integer member_no) {
		this.member_no = member_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
		return "MemberVo [member_no=" + member_no + ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", password=" + password + "]";
	}
}
