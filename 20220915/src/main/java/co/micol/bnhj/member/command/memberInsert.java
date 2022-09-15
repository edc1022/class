package co.micol.bnhj.member.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bnhj.common.Command;
import co.micol.bnhj.member.service.MemberService;
import co.micol.bnhj.member.service.MemberVO;
import co.micol.bnhj.member.serviceImpl.MemberServiceImpl;

public class memberInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 멤버 추가.
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberTel(request.getParameter("memberTel"));
		vo.setMemberAuthor(request.getParameter("memberAuthor"));
		
		
		int n = dao.memberInsert(vo);
		String viewPage = null; // 돌려줄 페이지
		if(n !=0) {
	//		request.setAttribute("message", "정상적으로 입력이 되었습니다.");
		} else {
			request.setAttribute("message", "멤버 추가가 실패했습니다.");
			viewPage = "member/memberMessage";
		}
			
			
		return viewPage;
	}

}
