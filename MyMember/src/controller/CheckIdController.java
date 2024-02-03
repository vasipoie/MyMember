// CheckIdController.java

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IMyMemberService;
import service.MyMemberServiceImpl;

@WebServlet("/checkId.do")
public class CheckIdController extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        doPost(request, response);
        
    }

    
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String memId = request.getParameter("memId");
        IMyMemberService mmSer = MyMemberServiceImpl.getInstance();
        boolean isIdAvailable = mmSer.checkMember(memId); // 해당 아이디의 존재 여부를 확인하는 메서드 호출
        
        PrintWriter out = response.getWriter();
        if (!isIdAvailable) { // isIdAvailable가 true이면 사용 가능한 아이디
            out.print("{\"rst\": \"ok\", \"msg\": \"사용 가능한 아이디입니다.\"}");
        } else {
            out.print("{\"rst\": \"dup\", \"msg\": \"이미 사용 중인 아이디입니다.\"}");
        }
        out.flush();
    }
}
