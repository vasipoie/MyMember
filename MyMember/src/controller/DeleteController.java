package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IMyMemberService;
import service.MyMemberServiceImpl;

@WebServlet("/memberDelete.do")
public class DeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IMyMemberService mmSer = MyMemberServiceImpl.getInstance();
		
		String memId = req.getParameter("memId");
		mmSer.deleteMember(memId);
		
		resp.sendRedirect(req.getContextPath() + "/list.do");
	}
}
