package cotroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberDAO;

@WebServlet("/regist")
public class registserv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
    	String rigistID = request.getParameter("id");
		System.out.println(rigistID);
		String rigistPW = request.getParameter("pw");
		System.out.println(rigistPW);
		String rigistName= request.getParameter("name");
		System.out.println(rigistName);
		String rigistemail= request.getParameter("email");
		System.out.println(rigistemail);

		MemberDAO dao = new MemberDAO();
		    dao.insert(rigistID, rigistPW, rigistName, rigistemail);
		    
		    response.setContentType("text/html; charset=utf-8");
		    PrintWriter out = response.getWriter();
		    String data = "<html><body> <h1>회원가입을 축하드립니다.</h1></body></html>";
		    
		    
	     
	 
	                 

	}
}
