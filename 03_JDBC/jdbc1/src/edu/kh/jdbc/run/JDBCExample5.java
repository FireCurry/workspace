package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

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
			
			Scanner sc = new Scanner(System.in);
			System.out.print("평균 급여 : ");
			int input = sc.nextInt();
			String sql = "SELECT DEPT_TITLE, JOB_NAME, AVG(SALARY) "
					+ "FROM EMPLOYEE "
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) "
					+ "JOIN JOB USING(JOB_CODE) "
					+ "GROUP BY DEPT_TITLE, JOB_NAME "
					+ "HAVING AVG(SALARY) > "+input+""
							+ "ORDER BY DEPT_TITLE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				double avgSalary = rs.getDouble("AVG(SALARY)");
				
				System.out.printf("부서명 : %s / 직급명 : %s / 평균 급여 : %.2f \n", deptTitle, jobName, avgSalary);
			}
			
		} catch (Exception e) {
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
