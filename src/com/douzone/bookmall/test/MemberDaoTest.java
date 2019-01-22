package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.MemberDao;
import com.douzone.bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		//insertTest(0,"정우현","010xxxxxxxx","hihitxx@navercom","xxxxx");
		//insertTest(0,"이성민","010xxxxxxxx","xxxxxx@navercom","xxxxxx");
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