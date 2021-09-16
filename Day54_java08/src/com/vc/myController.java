package com.vc; // view + controller �����
import java.util.Scanner;
import com.biz.*;
import com.dao.*;
import com.Entity.*;
import java.sql.*;
import java.util.*;

// view + controller
// 1. view (�� �Է°� ��� ���̾ƿ�) <-> controller(��ȿ���˻� �� ������ �̵�) 			    �� close & connection
// <-> biz(���, ����, ���->���ΰ��Ű����� dao�� �ѱ�) <-> dao(CRUD���) -> JDBCTemplate(C&C, commit, rollback) -> database_Server

// model�� ���µ� ����Ұ������� biz(��� ��ɼ���)�� ���ٰ� controller
// model���� ������ó���ؾߵǸ� dao, jdbctemplete,

public class myController {
	
	Scanner sc = new Scanner(System.in);
		int menu_view(){
		int no = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("1.Select All \n");
		sb.append("2.Insert  \n");
		sb.append("3.Delete  \n");
		sb.append("4.Update  \n");
		sb.append("5.exit  \n");
		System.out.println(sb.toString());
		System.out.println("input no : ");
		
		
		no = sc.nextInt();
		return no;
	}
	public static void main(String[] args) {
		//Controller
		List<EmpEntity>all = new ArrayList<>();
		EmpBiz biz = new EmpBiz();
		EmpEntity entity = null;
		
			int no = 0;
			int res = 0;
			
			do {
			no = new myController().menu_view();
			switch(no) {
			case 1:		
				all = biz.getSelectAll();
				for(EmpEntity emp : all) {
					System.out.println(emp); // 1�� ������ ������ ���´�.............EmpEntity [empno=7369, ename=SMITH, job=CLERK, mgr=7902, hiredate=1980-12-17 00:00:00, sal=800.0, comm=0.0, deptno=20]
				}
						break;
			case 2:		
				entity = new EmpEntity(111, "111", "111", 111, "2021-07-20", 111, 111, 20);
				res = biz.getEmpInsert(entity);
				if (res >0) {
					System.out.println("�Է��߾� ");
				}
				
						break;
			case 3:		
				entity = new EmpEntity();
				entity.setEmpno(111);
				res = biz.getEmpDelete(entity);
				if (res > 0) {
					System.out.println("���� �߾�");
				}
						break;
						
						
			case 4:		
				entity = new EmpEntity();
				entity.setEmpno(111);
				entity.setSal(10000);
				res = biz.getEmpUpdate(entity);
				if (res > 0) {
					System.out.println("���� �߾�");
				}
						break;
						
			case 5:		System.exit(0);
			
			}
		} while (no != 6);
	}
}
