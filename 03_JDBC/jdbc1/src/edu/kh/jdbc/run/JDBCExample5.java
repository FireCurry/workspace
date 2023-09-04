package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample5 {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@115.90.212.20:10000:ORCL";
			String id = "a230724_kms_seok";
			String pw = "01094292386";
			
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "SELECT MEMBER_EMAIL, MEMBER_PW FROM MEMBER";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				String memberEmail = rs.getString("MEMBER_EMAIL");
				String memberPw = rs.getString("MEMBER_PW");
				
				System.out.printf("%s / %s \n", memberEmail, memberPw);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
