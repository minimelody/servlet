package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class JoinusServlet
 */
@WebServlet(name = "Joinus", urlPatterns = { "/joinus" })
public class JoinusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송값의 한글이 있을 경우 처리할 수 있도록 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. View에서 보낸 데이터를 꺼내어 변수에 저장
		Member m = new Member();
		m.setUserId(request.getParameter("userId"));
		m.setUserPwd(request.getParameter("userPwd"));
		m.setUserName(request.getParameter("userName"));
		m.setAge(Integer.parseInt(request.getParameter("age")));
		m.setAddress(request.getParameter("addr"));
		m.setEmail(request.getParameter("email"));
		m.setPhone(request.getParameter("phone"));
		m.setGender(request.getParameter("gender"));
		m.setHobby(request.getParameter("hobby"));
		m.setActivation("Y");
		
		//3. Controller->Service->Dao->DB
		int result = new MemberService().insertMember(m);
		
		//4. 처리 결과에 따른 페이지
		if(result>0) // 정상 처리 (가입 완료)
		{
			response.sendRedirect("views/member/joinusSuccess.jsp");
		}
		else // 처리 실패 (가입 실패)
		{
			response.sendRedirect("views/member/joinusFail.jsp");
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
