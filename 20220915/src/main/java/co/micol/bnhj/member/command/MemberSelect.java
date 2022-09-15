package co.micol.bnhj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bnhj.common.Command;
import co.micol.bnhj.member.service.MemberService;
import co.micol.bnhj.member.service.MemberVO;
import co.micol.bnhj.member.serviceImpl.MemberServiceImpl;

public class MemberSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 상세보기
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("id")); //  폼에서 넘어온 아이디 담기.
		vo = dao.memberSelect(vo); // 검색결과 얻어서 내 vo 에 담기.
		request.setAttribute("member", vo); // 페이지 전달하기 위해
		return "member/memberSelect";
	}

}
