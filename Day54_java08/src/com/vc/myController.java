package com.vc; // view + controller 만들기
import java.util.Scanner;
import com.biz.*;
import com.dao.*;
import com.Entity.*;
import java.sql.*;
import java.util.*;

// view + controller
// 1. view (값 입력과 출력 레이아웃) <-> controller(유효성검사 및 페이지 이동) 			    ↓ close & connection
// <-> biz(계산, 파일, 디비->디비로갈거같으면 dao로 넘김) <-> dao(CRUD담당) -> JDBCTemplate(C&C, commit, rollback) -> database_Server

// model로 갔는데 계산할게있으면 biz(모든 기능수행)로 갔다가 controller
// model에서 정보를처리해야되면 dao, jdbctemplete,

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
					System.out.println(emp); // 1을 누르면 줄줄줄 나온당.............EmpEntity [empno=7369, ename=SMITH, job=CLERK, mgr=7902, hiredate=1980-12-17 00:00:00, sal=800.0, comm=0.0, deptno=20]
				}
						break;
			case 2:		
				entity = new EmpEntity(111, "111", "111", 111, "2021-07-20", 111, 111, 20);
				res = biz.getEmpInsert(entity);
				if (res >0) {
					System.out.println("입력했어 ");
				}
				
						break;
			case 3:		
				entity = new EmpEntity();
				entity.setEmpno(111);
				res = biz.getEmpDelete(entity);
				if (res > 0) {
					System.out.println("삭제 했어");
				}
						break;
						
						
			case 4:		
				entity = new EmpEntity();
				entity.setEmpno(111);
				entity.setSal(10000);
				res = biz.getEmpUpdate(entity);
				if (res > 0) {
					System.out.println("수정 했어");
				}
						break;
						
			case 5:		System.exit(0);
			
			}
		} while (no != 6);
	}
}
