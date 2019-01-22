package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.MemberVo;

public class MemberDao {
	public boolean insert(MemberVo memberVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql = "insert into bookmall values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memberVo.getNo());
			pstmt.setString(2, memberVo.getName());
			pstmt.setString(3, memberVo.getCall());
			pstmt.setString(4, memberVo.getEmail());
			pstmt.setString(5, memberVo.getPassword());

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
	public List<MemberVo> getList() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			// 3. Statement 객체를 생성
			stmt = conn.createStatement();
			// 4. SQL문 실
			String sql = "select a.no, a.call, a.name, a.email, a.password";
			rs = stmt.executeQuery(sql);
			// 5. 결과 가져오기
			while (rs.next()) {
				MemberVo sv = new MemberVo();

				// String first_name = rs.getString(1);
				Integer no = rs.getInt(1);
				String name = rs.getString(2);
				String call = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				// sv.setFirst_name(first_name);
				
				sv.setNo(no);
				sv.setName(name);
				sv.setCall(call);
				sv.setEmail(email);
				sv.setPassword(password);
				
				list.add(sv);
			}

			System.out.println("연결 성공");

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
			String url = "jdbc:mysql://localhost:3306/employees";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}
		return conn;
	}
}
