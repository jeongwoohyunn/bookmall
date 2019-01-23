package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.OrderBookVo;
import com.douzone.bookmall.vo.OrderVo;

public class OrderDao {
	public boolean insert(OrderVo orderVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();

			String sql = "insert into order1 values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, orderVo.getPrice());
			pstmt.setString(2, orderVo.getDeparture());
			pstmt.setInt(3, orderVo.getMember_no());

			int count = pstmt.executeUpdate();

			result = count >= 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<OrderVo> getList() {
		List<OrderVo> list = new ArrayList<OrderVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. Statement 객체를 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "select b.order_no,a.name,a.email,(c.price*d.amount),b.departure from member a, order1 b,book c, cart d where c.book_no = d.book_no and a.member_no=b.member_no and a.member_no=d.member_no";
			rs = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			while (rs.next()) {
				Integer order_no = rs.getInt(1);
				String member_name = rs.getString(2);
				String member_email = rs.getString(3);
				Integer totalprice = rs.getInt(4);
				String departure = rs.getString(5);

				OrderVo ov = new OrderVo();
				ov.setOrder_no(order_no);
				ov.setMember_name(member_name);
				ov.setMember_email(member_email);
				ov.setTotalprice(totalprice);
				ov.setDeparture(departure);

				list.add(ov);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. JDBC Driver(MYSQL) 로딩
			Class.forName("com.mysql.jdbc.Driver");
			// pripertiy -> build path를 등록해줘야된다.

			// 2. 연결하기 ( jdbc:연결할database://ip:port/database이름 ) port번호는 생략가능하다.
			// url과 id와 password를 같이 입력해준다. (Connection 객체 얻어오기)
			String url = "jdbc:mysql://localhost:3306/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}
		return conn;
	}
}
