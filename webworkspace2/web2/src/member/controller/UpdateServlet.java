package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet(name = "Update", urlPatterns = { "/update" })
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글이 있을 경우를 위해 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//2. view에서 넘겨준 전송값 꺼내서 변수에 저장
		Member m = new Member(
					request.getParameter("userId"),
					request.getParameter("userPwd"),
					request.getParameter("userName"),
					Integer.parseInt(request.getParameter("age")),
					request.getParameter("email"),
					request.getParameter("phone"),
					request.getParameter("addr"),
					request.getParameter("gender"),
					request.getParameter("hobby"),
					"Y"
				);
		
		//3. 비즈니스 로직 처리
		int result = new MemberService().updateMember(m);
		if(result>0)
		{
			response.sendRedirect("views/member/updateSuccess.jsp");
		}else {
			response.sendRedirect("views/member/Error.html");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
