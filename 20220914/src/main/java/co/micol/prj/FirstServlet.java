package co.micol.prj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.DAO;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement psmt; // DBMS에 명령을 보내고 
	private ResultSet rs; // 실행된 결과를 돌려받을 때 (select문만 받는다)
    
    public FirstServlet() {
       super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO(); // 데이터 베이스 연결을 확인한다.
		String sql = "select * from member";
		try {
			psmt = dao.conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getString("member_id"));
				System.out.println(rs.getString("member_name"));

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter(); // html ������ ����� �޼ҵ�.
		out.print("�Ѿ�� ���̵� �� : ");
		out.print(request.getParameter("id"));
		out.print("�Ѿ�� �н����� �� : ");
		out.print(request.getParameter("password"));

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
