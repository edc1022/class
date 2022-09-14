<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<div>
	<jsp:include page="menu.jsp"></jsp:include>
	</div>
		<div>
			<h1>l o g i n</h1>
		</div>
		<div>
			<form action="FirstServlet" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="150">아이디</th>
							<td width="200"><input type="text" id="id" name="id"
								placeholder="아이디를 입력하세요."></input></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input type="text" id="name" name="name"
								placeholder="이름을 입력하세요."></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" id="password" name="password"
								placeholder="4자리 이상 입력하세요."></td>
						</tr>
					</table>
				</div>
				<br />
				<div>
					<input type="submit" value="로그인"> &nbsp;&nbsp;
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	 <a href="home.jsp">홈페이지</a>
	</div>
</body>
</html>