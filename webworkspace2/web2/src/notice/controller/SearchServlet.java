package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.PageData;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(name = "Search", urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글이 있을 경우 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. 값 꺼내서 변수에 저장
		String search = request.getParameter("search"); //검색어
		
		int currentPage;
		if(request.getParameter("currentPage")==null)currentPage=1;
		else currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//3. 비즈니스 로직
		PageData pd = new NoticeService().searchList(search, currentPage);
		
		//4. view 결과값 출력 (jsp 페이지)
		if(pd!=null)
		{
			RequestDispatcher view = request.getRequestDispatcher("views/notice/noticeSearch.jsp");
			request.setAttribute("pageData", pd);
			request.setAttribute("search",search);
			view.forward(request, response);
		}else
		{
			response.sendRedirect("views/notice/Error.html");
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
