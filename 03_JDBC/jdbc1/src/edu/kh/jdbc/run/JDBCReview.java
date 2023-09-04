package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCReview {
	public static void main(String[] args) {
		
		// 부서명을 입력 받아
		// 해당 부서에 근무하는 모든 사원의
		// 사번, 이름, 부서명, 직급명을 직급 오름차순 조회
		
		// 1. JDBC 객체 참조 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 2. DriverManager를 이용해 Connection 객체 생성
			// 2-1) Oracle JDBC Driver 객체를 메모리에 로드(적재) 하기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2-2) DB 연결 정보를 이용해서 Connection 객체 생성
			String url = "jdbc:oracle:thin:@115.90.212.20:10000:ORCL";
			String id = "a230724_kms_seok";
			String pw = "01094292386";
			
			conn = DriverManager.getConnection(url, id, pw);
			
			// 3. SQL 작성
			System.out.print("부서명 : ");
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			
			// 입력 받은 문자열이 저장된 변수를 sql에 추가할 때
			// 양쪽에 홑따옴표(' ')를 반드시 작성해야 한다!
			String sql = "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID) \r\n"
					+ "JOIN JOB USING(JOB_CODE)\r\n"
					+ "WHERE DEPT_TITLE = '"+input+"'\r\n"
					+ "ORDER BY JOB_CODE";
			
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			// 연결된 DB와 대화(SQL 수행/결과 반환)를 하기 위한 객체 생성
			
			// 5. Statement 객체를 이용해서 SQL 수행 후 결과 반환 받기
			// (SELECT 수행 후 ResultSet 반환)
			rs = stmt.executeQuery(sql);
			
			// 6. SQL(SELECT) 결과가 담겨있는 ResultSet(rs)를
			//	한 행씩 반복 접근하며 각 행의 컬럼 값을 얻어와 출력
			
			boolean flag = true; // true이면 조회 결과 없음, false면 있음
			
			while (rs.next()) {
				flag = false;
				
				// 현재 행의 EMP_ID 컬럼 값을 String 형태로 얻어와 저장
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				
				System.out.printf("사번 : %s / 이름 : %s / 부서명 : %s / 직급명 : %s \n", empId, empName, deptTitle, jobName);
			}
			
			if (flag) { // while문 종료 후에 flag 값이 true == 조회 결과 없음
				System.out.println("일치하는 부서가 없습니다.");
			}
		} catch (Exception e) {
			// 예외의 최상위 부모 모든 예외를 잡아서 처리
			e.printStackTrace();
		} finally {
			
			// 7. 사용한 JDBC 객체 자원 반환(역순으로!)
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
