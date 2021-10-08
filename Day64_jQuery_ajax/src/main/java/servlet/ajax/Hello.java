package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 화면에서 넘어온 값을 받아서 console 창에 출력하는 작업
		// 오류 표시 뜬다면 import 하면됨
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name"); //ajax 파일의 name으로 입력받아 hyeri라는 값을 출력
		System.out.println("name :" + name);
		
		
		/*
		 *  화면으로 받은 데이터를
		 *  디비 연결하는 DAO 파일의 
		 *  특정 메소드의 인자값으로 연결
		 *  
		 *  1) DAO 객체를 생성
		 *  2) dao.getMemberByName(name); ---- storage로 연결해서 값을 받음
		 *  3) Member 객체 m을 클라이언트로 응답한다. ---- json 연결
		 *  
		 * */
		
		
		// 코드 실행을 지연시키고 싶을 때
		try {
			Thread.sleep(1000); // 1초동안 지연
		} catch (InterruptedException e) {

		}
		
		
		// 다시 클라이언트로 응답 (넘어온 값을 받아서 다시 돌려줌)
		out.print(name);  // 이때 응답이 들어간다, 응답이 바로 진행되지 않고 무려 1초동안 지연시킴!
	}

}