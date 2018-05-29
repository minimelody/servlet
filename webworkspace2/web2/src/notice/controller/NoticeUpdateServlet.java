package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet(name = "NoticeUpdate", urlPatterns = { "/noticeUpdate" })
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Notice n = new Notice();
		int noticeno = Integer.parseInt(request.getParameter("noticeNo"));
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		n.setNoticeNo(noticeno);
		n.setSubject(subject);
		n.setContents(contents);
		
		//3. 비즈니스 로직
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user")!=null&&((Member)session.getAttribute("user")).getUserId().equals("admin")) {
			int result = new NoticeService().updateNotice(n);
			if(result>0)
			{
				RequestDispatcher view = request.getRequestDispatcher("noticeSelect?noticeNo="+n.getNoticeNo());
				request.setAttribute("notice", n);
				view.forward(request, response);
			}
			else
			{
				response.sendRedirect("views/notice/Error.html");
			}
		}
		else {
			response.sendRedirect("views/notice/Error.html");
		}
		

	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
