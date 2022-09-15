package co.micol.bnhj;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bnhj.common.Command;
import co.micol.bnhj.member.command.MemberSelect;
import co.micol.bnhj.member.command.MemberSelectList;
import co.micol.bnhj.member.command.memberInsert;
import co.micol.bnhj.member.command.memberJoinForm;

/**
 * Servlet implementation class FrontController
 * 모든 .do 요청을 분석하고 처리한다. 
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>(); // 요청값을 저장하기위해 HashMap 사용.
    
    public FrontController() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		// 모든 요청을 등록하는 곳. 메모리에 한번 올려놓고 서비스만 함.초기화되는건 한번만.
		map.put("/main.do", new MainCommand()); // 처음 시작하는 페이지.
		map.put("/memberSelectList.do", new MemberSelectList()); // 멤버 목록보기
		map.put("/memberSelect.do", new MemberSelect());// 멤버 상세 정보
		map.put("/memberJoinForm.do", new memberJoinForm());
		map.put("/memberInsert.do", new memberInsert());
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스 요청을 분석하고, 처리하고, 결과를 돌려주는 곳.
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지를 위해.
		String uri = request.getRequestURI(); // 도메인을 제외한 실제 요청정보.
		String contextPath = request.getContextPath(); // ContextPath 구함.
		String page = uri.substring(contextPath.length()); // 처리할 요청명 나옴.

		System.out.println(request.getRequestURL());
		System.out.println(uri);
		System.out.println(contextPath);
		System.out.println(page);
		System.out.println(request.getRemoteUser());

		
		Command command = map.get(page); // 처리할 command를 찾음.
		String viewPage = command.exec(request, response); // Command를 실행하고 돌려줄 페이지를 받음.
		
		if(!viewPage.endsWith(".do")) {
			viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; 
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
		
		
 	}

}
