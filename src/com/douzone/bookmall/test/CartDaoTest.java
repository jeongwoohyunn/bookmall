package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {

//		insertTest(15, 1, 1);
//		insertTest(2, 1, 1);
//		getListTest();
		
		
	}

	public static void insertTest(long amount,long member_no,long book_no) {
		CartVo vo = new CartVo();

		vo.setAmount(amount);
		vo.setMember_no(member_no);
		vo.setBook_no(book_no);

		new CartDao().insert(vo);
	}

	public static void getListTest() {
		List<CartVo> list = new CartDao().getList();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}
}
