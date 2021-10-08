// url:"JqueryAjax"

package servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JqueryAjax")
public class JqueryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		// 에러 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("시간경과");
		}
		
		// 페이지 이동
		request.getRequestDispatcher("resultView.jsp").forward(request, response);
	}

}