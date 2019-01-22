package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		//insertTest("이것이 자바다",30000, 3);
		//insertTest("나의 산에서",10000, 2);
		//insertTest("이거슨 파이썬",25000, 3);
		//insertTest("요거슨 C++",15000, 3);
		getListTest();

	}

	public static void insertTest(String book_name, int price, int category_no) {
		BookVo vo = new BookVo();

		vo.setBook_name(book_name);
		vo.setPrice(price);
		vo.setCategory_no(category_no);

		new BookDao().insert(vo);
	}


	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}
}