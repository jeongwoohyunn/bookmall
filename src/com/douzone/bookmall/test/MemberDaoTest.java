package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.MemberDao;
import com.douzone.bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		insertTest("정우현","010-xxxx-xxxx","hihitxx@naver.com","xxxxx");
		insertTest("이성민","010-xxxx-xxxx","xxxxxx@naver.com","xxxxxx");
		//getListTest();

	}

	public static void insertTest(String name, String tel, String email, String password) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setTel(tel);
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