package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IMyMemberService;
import service.MyMemberServiceImpl;
import vo.MyMemberVO;

@WebServlet("/detail.do")
public class DetailController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memId = req.getParameter("memId");
		
		IMyMemberService mmSer = MyMemberServiceImpl.getInstance();
		
		MyMemberVO mv = mmSer.getMember(memId);
		
		req.setAttribute("mv", mv);
		
		req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
	}
	
	
	
}
