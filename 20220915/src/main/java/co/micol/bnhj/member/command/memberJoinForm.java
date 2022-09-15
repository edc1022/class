package co.micol.bnhj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.bnhj.common.Command;

public class memberJoinForm implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 멤버입력 화면 호출
		return "member/memberJoinForm";
	}

}
