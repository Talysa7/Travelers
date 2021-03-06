package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.LogonDBBean;

public class LoginProHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws HandlerException {
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		LogonDBBean memberDao=LogonDBBean.getInstance();
		int result=memberDao.passcheck(id, passwd);
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		return "member/loginPro.jsp";
	}
}