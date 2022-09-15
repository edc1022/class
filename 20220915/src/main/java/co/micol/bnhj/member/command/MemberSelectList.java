package co.micol.bnhj.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bnhj.common.Command;
import co.micol.bnhj.member.service.MemberService;
import co.micol.bnhj.member.service.MemberVO;
import co.micol.bnhj.member.serviceImpl.MemberServiceImpl;

public class MemberSelectList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 멤버목록 보기
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<>();
		members = dao.memberSelectList();
		request.setAttribute("members", members);
		
		return "member/memberList";
	}

}
