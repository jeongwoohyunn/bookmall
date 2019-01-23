package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.MemberDao;
import com.douzone.bookmall.dao.OrderBookDao;
import com.douzone.bookmall.dao.OrderDao;
import com.douzone.bookmall.vo.MemberVo;
import com.douzone.bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {

	public static void main(String[] args) {

//		insertTest(1,2,2);
//		getListTest();
		
	}
	public static void insertTest(int amount,int order_no,int book_no) {
		OrderBookVo ob = new OrderBookVo();
		ob.setAmount(amount);
		ob.setOrder_no(order_no);
		ob.setBook_no(book_no);
		new OrderBookDao().insert(ob);
	}
	public static void getListTest() {
		List<OrderBookVo> list = new OrderBookDao().getList();
		for (OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}
}
