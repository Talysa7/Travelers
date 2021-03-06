package examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String formedTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
		
		out.print("<html>");
		out.print("<head><title>today</title></head>");
		out.print("<body>");
		out.print("<a href='/aboutme/index.html'>메인화면</a>");
		out.print("<h1><center>");
		out.print("<br><br>");
		out.print("현재시간: " + formedTime);
		out.print("</h1></center>");
		out.print("</body>");
		out.print("</html>");
	}
}
