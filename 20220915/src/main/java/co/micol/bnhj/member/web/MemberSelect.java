package co.micol.bnhj.member.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bnhj.member.service.MemberService;
import co.micol.bnhj.member.service.MemberVO;
import co.micol.bnhj.member.serviceImpl.MemberServiceImpl;

//@WebServlet("/MemberSelect")
public class MemberSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한명 조회.
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id")); //  폼에서 넘어온 아이디 담기.
		vo = dao.memberSelect(vo); // 검색결과 얻어서 내 vo 에 담기.
		request.setAttribute("member", vo); // 페이지 전달하기 위해
		String viewPage = "/WEB-INF/views/member/memberSelect.jsp";
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
