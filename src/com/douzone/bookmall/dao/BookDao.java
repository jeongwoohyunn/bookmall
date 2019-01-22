package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.BookVo;

public class BookDao {
	public boolean insert(BookVo bookVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();

			String sql = "insert into book values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bookVo.getBook_name());
			pstmt.setInt(2, bookVo.getPrice());
			pstmt.setInt(3, bookVo.getCategory_no());
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

	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<BookVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			// 3. Statement 객체를 생성
			stmt = conn.createStatement();

			// 4. SQL문 실
			String sql = "select b.book_no, b.name,a.name,b.price " + 
					"from category a, book b " + 
					"where a.category_no = b.category_no";
			rs = stmt.executeQuery(sql);
			// 5. 결과 가져오기
			while (rs.next()) {

				// String first_name = rs.getString(1);
				Integer book_no = rs.getInt(1);
				String book_name = rs.getString(2);
				String category_name = rs.getString(3);
				Integer price = rs.getInt(4);
				
				// sv.setFirst_name(first_name);
				BookVo sv = new BookVo();
				
				//sv.setCategory_no(category_no);
				sv.setBook_no(book_no);
				sv.setBook_name(book_name);
				sv.setCategory_name(category_name);
				sv.setPrice(price);
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
