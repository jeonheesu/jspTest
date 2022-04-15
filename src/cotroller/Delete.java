package cotroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberVo;
import service.MemberDAO;

@WebServlet("/uDelete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		  
		  
		  String deleteID = request.getParameter("userID");
		   System.out.println(deleteID);
		  MemberDAO dao = new MemberDAO();
		  dao.delete(deleteID);
		  
		  response.setContentType("text/html; charset=utf-8");
		  PrintWriter out = response.getWriter();
		  String data = "<html><body> <h1>삭제 완료.</h1></body></html>";
		  out.print(data);
            
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
	
	     
	      
	      
	      
		 	
		 

		
		}
	}


