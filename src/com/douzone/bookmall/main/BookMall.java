package com.douzone.bookmall.main;

import com.douzone.bookmall.test.BookDaoTest;
import com.douzone.bookmall.test.CartDaoTest;
import com.douzone.bookmall.test.CategoryDaoTest;
import com.douzone.bookmall.test.MemberDaoTest;
import com.douzone.bookmall.test.OrderBookDaoTest;
import com.douzone.bookmall.test.OrderDaoTest;

public class BookMall {

	public static void main(String[] args) {
		System.out.println("회원정보");
		System.out.println();
		MemberDaoTest.insertTest("정우현","010-xxxx-xxxx","hihitxx@naver.com","******");
		
		MemberDaoTest.getListTest();
		System.out.println("======================================================================================");
		System.out.println("카테고리 리스트");
		System.out.println();
		CategoryDaoTest.insertTest("소설");
		CategoryDaoTest.insertTest("수필");
		CategoryDaoTest.insertTest("컴퓨터/IT");
		CategoryDaoTest.insertTest("예술");
		
		CategoryDaoTest.getListTest();
		System.out.println("======================================================================================");		
		System.out.println("상품리스트");
		System.out.println();
		
		BookDaoTest.insertTest("이것이 자바다",30000, 3);
		BookDaoTest.insertTest("나의 산에서",10000, 2);
		BookDaoTest.insertTest("이거슨 파이썬",25000, 3);
		BookDaoTest.insertTest("요거슨 C++",15000, 3);
		
		BookDaoTest.getListTest();
		System.out.println("======================================================================================");
		System.out.println("카트 리스트");
		System.out.println();
		CartDaoTest.insertTest(2,1,1);		
		CartDaoTest.getListTest();
		System.out.println("======================================================================================");
		System.out.println("주문리스트");
		System.out.println();
		
		OrderDaoTest.insertTest(60000,"부산 신선로 삼성아파트",1);
		
		OrderDaoTest.getListTest();
		System.out.println("======================================================================================");
		System.out.println("주문목록리스트");
		System.out.println();
		
		OrderBookDaoTest.insertTest(1,1,1);
		
		OrderBookDaoTest.getListTest();

	}

}
