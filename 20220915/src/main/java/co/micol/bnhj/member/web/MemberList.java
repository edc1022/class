package co.micol.bnhj.member.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bnhj.member.service.MemberService;
import co.micol.bnhj.member.service.MemberVO;
import co.micol.bnhj.member.serviceImpl.MemberServiceImpl;


//@WebServlet("/MemberList")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberList() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수행할 코드를 적는곳(멤버목록 가져오기)
		request.setCharacterEncoding("utf-8");
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<>();
		members = dao.memberSelectList();
		request.setAttribute("members", members); // request 객체에 서버가 만들어준 결과를 담는다.
		String viesPage = "/WEB-INF/views/member/memberList.jsp"; // 결과를 돌려줄 페이지.
		
		// RequestDispatcher : 처음에 요청했던 request 객체를 새로 만든 request에 그대로 포함 전달.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viesPage);
		dispatcher.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
