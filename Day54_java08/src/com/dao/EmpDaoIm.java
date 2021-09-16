package com.dao;

public interface EmpDaoIm {
	String select_all = "select * from emp";
	String insert_emp = "Insert into Emp values(?,?,?,?,?,?,?,?)";
	String delect_emp = "Delete from emp where empno =?";
	String update_emp = "Update emp set sal =? where empno =?";
	
}
