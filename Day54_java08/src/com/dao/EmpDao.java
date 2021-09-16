package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Entity.EmpEntity;
import static com.myjdbc.JDBCTemplate.*;

//CRUD만 하겠다. = commit/rollback 
public class EmpDao implements EmpDaoIm{
	Connection con;
	public EmpDao(Connection con) {
		this.con = con;
	}




	//1. select
	public List<EmpEntity> getselectAll(){
		String all = "select * from emp";
		//레코드 한줄씩 EmpEntity 로 담아서 list객체에 추가한 다음 리턴
		List<EmpEntity> Listall = new ArrayList<>();
		EmpEntity entity = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			 stmt = con.createStatement();
			 rs = stmt.executeQuery(select_all);
			 while(rs.next()) {
				 entity = new EmpEntity(rs.getInt(1), 
						  rs.getString("ename"),
						  rs.getString(3),
						  rs.getInt(4),
						  rs.getString(5),
						  rs.getDouble(6),
						  rs.getDouble(7),
						  rs.getInt(8));
				 
				 Listall.add(entity);
			 }//while add
			 
		}catch(Exception e) {
				
		
	} finally {
		Close(rs);
		Close(stmt);
	}//try end
		return Listall; // return하면 jdbctemplate로간닫
	}

	//2. insert
	public int getEmpInsert(EmpEntity entity) {

		PreparedStatement pstm = null;
		int res =0;
		try {
			pstm = con.prepareStatement(insert_emp);
			pstm.setInt(1, entity.getEmpno());
			pstm.setString(2, entity.getEname());
			pstm.setString(3, entity.getJob());
			pstm.setInt(4, entity.getMgr());
			pstm.setString(5, entity.getHiredate());
			pstm.setDouble(6, entity.getSal());
			pstm.setDouble(7, entity.getComm());
			pstm.setInt(8, entity.getDeptno());
			
			res = pstm.executeUpdate(); // insert 실행
			if (res >0) {
				Commit(con);
			}
		}catch(Exception e) {
			//System.out.println(e.toString());
			Rollback(con);
		}finally {
			Close(pstm);
		}
		return res;
	}
	
	
	//3. update
	public int getEmpUpdate(EmpEntity entity) {

		PreparedStatement pstm = null;
		int res =0;
		try {
			pstm = con.prepareStatement(update_emp);
			pstm.setDouble(1, entity.getSal());
			pstm.setInt(2, entity.getEmpno());

			
			res = pstm.executeUpdate(); // insert 실행
			if (res >0) {
				Commit(con);
			}
		}catch(Exception e) {
			//System.out.println(e.toString());
			Rollback(con);
		}finally {
			Close(pstm);
		}
		return res;
	}
	
	
	
	//4. delete
	public int getEmpDelete(EmpEntity entity) {

		PreparedStatement pstm = null;
		int res =0;
		try {
			pstm = con.prepareStatement(delect_emp);
			
			pstm.setInt(1, entity.getEmpno());

			
			res = pstm.executeUpdate(); // insert 실행
			if (res >0) {
				Commit(con);
			}
		}catch(Exception e) {
			
			Rollback(con);
		}finally {
			Close(pstm);
		}
		return res;
	}
	}
