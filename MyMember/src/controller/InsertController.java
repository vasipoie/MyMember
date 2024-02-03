package controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.IMyMemberService;
import service.MyMemberServiceImpl;
import vo.MyMemberVO;

@MultipartConfig
@WebServlet("/insert.do")
public class InsertController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/insertForm.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
		
        IMyMemberService mmSer = MyMemberServiceImpl.getInstance();
        
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memAddr = req.getParameter("memAddr");
		
		MyMemberVO mv = new MyMemberVO();
		mv.setMemId(memId);
		mv.setMemPass(memPass);
		mv.setMemName(memName);
		mv.setMemTel(memTel);
		mv.setMemAddr(memAddr);
		
		String uploadPath = "C:/Users/PC-25/git/HighJava_ddit/MyMember/WebContent/profile/";
        File uploadDir = new File(uploadPath);
        String saveFileName = null;
        
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
	        
        for (Part part : req.getParts()) {
            String fileName = part.getSubmittedFileName();
            
            // 첨부파일이 있으면
            if (fileName != null && !fileName.equals("")) {
                // 파일 이름과 확장자 분리
                String originalFileName = fileName.substring(0, fileName.lastIndexOf('.'));
                String fileExtension = fileName.substring(fileName.lastIndexOf('.'));
    
                saveFileName = UUID.randomUUID().toString().replace("-", "") + fileExtension;
    
                try {
                    part.write(uploadPath + saveFileName);
                } catch (IOException ex) {
                    throw new RuntimeException("업로드 중 오류발생", ex);
                }
            }
        }
        
        mv.setMemPhoto(saveFileName);
        
        int cnt = mmSer.insertMember(mv);
        
        System.out.println(cnt);
        
        resp.sendRedirect(req.getContextPath() + "/list.do");
		
	}
}
