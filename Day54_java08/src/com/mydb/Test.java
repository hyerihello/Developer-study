package com.mydb;
import java.sql.*;

public class Test {
	// ����̹��� �̿��ؼ� ����Ŭ ���� Ȯ��
	// url ã�� jdbc:oracle:thin:@127.0.0.1:1521:XE
	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Ŭ���� ������ �������
		//1. ����	
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","SCOTT","TIGER");
			//Connection = ���ᰴü commit()/rollback()/close()/isclosed() 
			if(!con.isClosed()) {
				System.out.println("�����߾� ");
			}
		//2. ��ɼ���
			String str = "select  *from emp";
			Statement stmt = con.createStatement();
			
		//3. �������
			ResultSet rs = stmt.executeQuery(str);
			while(rs.next()) {
				System.out.println(rs.getString(1) +":"+ rs.getString("ENAME")+":"+rs.getDouble("SAL"));
		//4. ����
			rs.close();
			stmt.close();
			con.close();
			}
			
			
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		}	
}