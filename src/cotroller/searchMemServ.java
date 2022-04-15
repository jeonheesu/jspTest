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

@WebServlet("/searchMem")
public class searchMemServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		  PrintWriter out = response.getWriter();
    	String searchID = request.getParameter("searchID");
		System.out.println(searchID);
		
		 MemberDAO dao = new MemberDAO();
		 
		MemberVo vo = new MemberVo();
		vo.setId(request.getParameter("id"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		  
		 

		
		}
	}


