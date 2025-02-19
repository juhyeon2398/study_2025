package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joonzis.db.DBConnection;

public class Ex02_update {
	public static void main(String[] args) {
		Connection conn = null;

		PreparedStatement ps = null;

		try {
			conn = DBConnection.getConnection();

			// 주의 띄어쓰기, 세미콜론 (삭제)
			String sql = "update person set age = ?, region = ? where name = ? ";

			ps = conn.prepareStatement(sql);
			// ? 에 데이터 set
			
			ps.setInt(1, 100);
			ps.setString(2, "마포");
			ps.setString(3, "김씨");
			
			int result = ps.executeUpdate();
			
			if (result > 0) {
				System.out.println("데이터 수정 성공");
			} else {
				System.out.println("데이터 수정 실패");
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if(conn != null) {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				try {
					ps.close();
					conn.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
	}
}
