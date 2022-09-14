<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 여기서 tag라이브러리를 사용 할 수 있다고 알림. 0914 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String names[] = new String[5];
	%>
	<%
	request.setCharacterEncoding("utf-8");
	names[0] = "홍길동";
	names[1] = "김길동";
	names[2] = "고길동";
	names[3] = "박길동";
	names[4] = "이킬동";
	%>
	<h1>넘어온 id 데이터는 ${param.id}</h1>
	<c:if test="${not empty param.name  }">
		<h1>넘어온 name데이터는 ${param.name}</h1>
	</c:if>
	<h1>넘어온 pw 데이터는 ${param.password}</h1>

	<c:forEach var="i" begin="1" end="9">
		<!-- for문 -->
		2 * ${i} = ${2 * i}<br />
	</c:forEach>
	<c:choose>
		<c:when test="${empty param.id}"> <!-- switch의 case와 같음 -->
			<h3>아이디 값이 없습니다.</h3>
		</c:when>
		<c:when test="${empty param.name}">
			<h3>name 값이 없습니다.</h3>
		</c:when>
		<c:when test="${empty param.password}">
			<h3>pw 값이 없습니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>정상 작동 되었습니다.</h3> <!-- switch의 default와 같음 -->
		</c:otherwise>
	</c:choose>

</body>
</html>