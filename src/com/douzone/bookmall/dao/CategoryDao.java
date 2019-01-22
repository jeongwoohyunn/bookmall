package com.douzone.bookmall.dao;

import java.util.List;

import com.douzone.bookmall.vo.MemberVo;

public class CategoryDao {
	public static void main(String[] args) {
		
		getListTest();

	}

	public static void insertTest(Integer no, String name, String call, String email, String password) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setCall(call);
		vo.setEmail(email);
		vo.setPassword(password);

		new MemberDao().insert(vo);
	}

	public static void getListTest() {
		List<MemberVo> list = new MemberDao().getList();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
	}
}