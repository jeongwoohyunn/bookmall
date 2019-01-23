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

public class OrderBookDao {
	public boolean insert(OrderBookVo orderBookVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();

			String sql = "insert into ordernumber values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, orderBookVo.getAmount());
			pstmt.setInt(2, orderBookVo.getOrder_no());
			pstmt.setInt(3, orderBookVo.getBook_no());

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

	public List<OrderBookVo> getList() {
		List<OrderBookVo> list = new ArrayList<OrderBookVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. Statement 객체를 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "select a.book_no,a.name,b.amount from book a, cart b where a.book_no = b.book_no";
			rs = stmt.executeQuery(sql);

			// 5. 결과 가져오기
			while (rs.next()) {
//				Integer order_no = rs.getInt(1);
				Integer book_no = rs.getInt(1);
				String book_name = rs.getString(2);
				Integer amount = rs.getInt(3);

				OrderBookVo ov = new OrderBookVo();

				ov.setBook_no(book_no);
				ov.setBook_name(book_name);
				ov.setAmount(amount);

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
