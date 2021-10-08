package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Weather;


@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		/* 
		 * 배포한 json.jar을 WEB-INF \\ lib \\ json.jar 을 넣자
		 * 후에 ctrl + shift + 영문자 O 클릭 → import 자동생성 된다.
		 
		 * */
			
	// 1.JSON 객체를 하나 생성 .. json.jar 가 있어야한다.
		// 비동기에서 응답하는 데이터 타입을 객체로 할때 json을 사용한다.
			
		JSONObject json = new JSONObject();
		
		/*
		 * json.put("region", "Busan"); 
		 * json.put("wind", 34); 
		 * json.put("temp", 27);
		 * json.put("rain", 10);
		 * 
		 */
		
		
		
	// 2. Weather 객체를 생성
		Weather weather = new Weather("NYC", 44, 23, 78);
		
		//Weather weather = new Weather(region, wind, temp, rain); 이런 식으로 값을 주입한다.
		json.put("weather",weather);
		
		
		//응답한다 -- 객체를 응답한다,
		out.print(json);	
		
		
	}

}
