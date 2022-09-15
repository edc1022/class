package co.micol.bnhj.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.bnhj.common.DataSource;
import co.micol.bnhj.member.service.MemberService;
import co.micol.bnhj.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DataSource dao = new DataSource(); // 데이터 연결객체 생성
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelectList() {
		// 전체 멤버 목록 가져오기
		List<MemberVO> list = new ArrayList();
		MemberVO vo;
		String sql = "SELECT * FROM MEMBER";
		try {
			psmt = dao.conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) { // rs.next() :resultset 한행 읽을때 사용하는 커서 명령어.
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberTel(rs.getString("member_tel"));
				vo.setMemberAuthor(rs.getString("member_author"));
				list.add(vo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // connection 을 끊어준다.

		}
	

	return list;

}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// 한명의 멤버를 조회한다.
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID=?";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery(); // select 는 set에 결과담기
			
			if(rs.next()) {
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberTel(rs.getString("member_tel"));
				vo.setMemberAuthor(rs.getString("member_author"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// 한명의 데이터 추가.
		int n = 0;
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?)";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1,vo.getMemberId());
			psmt.setString(2,vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberTel());
			psmt.setString(5, vo.getMemberAuthor());
			n = psmt.executeUpdate(); // insert 성공하면 1, 실패시 0. 숫자로 반환됨.
					
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// 한명의 데이터 변경, 아이디를 제외한 모든값이 변경 가능함.
		int n = 0;
		String sql = "UPDATE MEMBER SET MEMBER_PASSWORD= ?,MEMBER_NAME= ?,"
				+ "MEMBER_TEL= ?, MEMBER_AUTHOR= ? WHERE MEMBER_ID= ?";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberPassword());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberTel());
			psmt.setString(4, vo.getMemberAuthor());
			psmt.setString(5, vo.getMemberId());
			n = psmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close();
		}
				
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// 멤버 삭제.
		int n = 0;
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1,vo.getMemberId());
			
		} catch (Exception e) {
			
		}
		return n;
	}

	@Override
	public boolean isMemberId(String id) {
		// 아이디 중복체크. 존재하면... false 리턴.
		boolean b = false;
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID=?";
		try {
			psmt = dao.conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) { // 레코드 한행이 if 사용. 여러줄이면 while? 
				b = false; // 존재하면 false.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return b;
	}

	public void close() { // DBMS 와 연결을 끊어준다.
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(dao.conn != null) rs.close();
		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
}
