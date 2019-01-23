package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.MemberDao;
import com.douzone.bookmall.dao.OrderDao;
import com.douzone.bookmall.vo.MemberVo;
import com.douzone.bookmall.vo.OrderBookVo;
import com.douzone.bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {

		insertTest((20000*3),"부산 신선로 삼성아파트",1);
		getListTest();

	}

	public static void insertTest(int price, String departure, int member_no) {
		OrderVo ov = new OrderVo();
		
		ov.setPrice(price);
		ov.setDeparture(departure);
		ov.setMember_no(member_no);
		new OrderDao().insert(ov);
	}
	
	public static void getListTest() {
		List<OrderVo> list = new OrderDao().getList();
		for (OrderVo vo : list) {
			System.out.println(vo);
		}
	}


}
