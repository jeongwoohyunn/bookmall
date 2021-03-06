package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CartVo;
public class CartDao {
	public boolean insert(CartVo cartVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();

			String sql = "insert into cart values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, cartVo.getAmount());
			pstmt.setLong(2, cartVo.getMember_no());
			pstmt.setLong(3, cartVo.getBook_no());

			int count = pstmt.executeUpdate();

			result = count == 1;

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

	public List<CartVo> getList() {
		List<CartVo> list = new ArrayList<CartVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. Statement 객체를 생성
			stmt = conn.createStatement();

			// 4. SQL문 실
			String sql = "select b.cart_no,a.name,b.amount,(a.price*b.amount) from book a, cart b, member c where a.book_no=b.book_no and b.member_no=c.member_no";
			rs = stmt.executeQuery(sql);
			// 5. 결과 가져오기
			while (rs.next()) {

				// String first_name = rs.getString(1);
				Long cart_no = rs.getLong(1);
				String book_name = rs.getString(2);
				Long amount = rs.getLong(3);
				Long totalprice = rs.getLong(4);

				// sv.setFirst_name(first_name);
				CartVo sv = new CartVo();

				sv.setCart_no(cart_no);
				sv.setBook_name(book_name);
				sv.setAmount(amount);
				sv.setTotalprice(totalprice);

				list.add(sv);
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