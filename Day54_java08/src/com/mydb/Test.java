package com.mydb;
import java.sql.*;

public class Test {
	// 드라이버를 이용해서 오라클 연결 확인
	// url 찾기 jdbc:oracle:thin:@127.0.0.1:1521:XE
	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //클래스 참조형 실행상태
		//1. 연결	
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","SCOTT","TIGER");
			//Connection = 연결객체 commit()/rollback()/close()/isclosed() 
			if(!con.isClosed()) {
				System.out.println("연결했어 ");
			}
		//2. 명령수행
			String str = "select  *from emp";
			Statement stmt = con.createStatement();
			
		//3. 결과리턴
			ResultSet rs = stmt.executeQuery(str);
			while(rs.next()) {
				System.out.println(rs.getString(1) +":"+ rs.getString("ENAME")+":"+rs.getDouble("SAL"));
		//4. 종료
			rs.close();
			stmt.close();
			con.close();
			}
			
			
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		}	
}