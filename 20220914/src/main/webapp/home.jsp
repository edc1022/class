<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지를 위해
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	
	%> --%>
	<%!
		String[] names = new String[5];
	%>
	
	<%request.setCharacterEncoding("utf-8");
	  
	%>
	<h1>넘어온 id 데이터는 = ${param.id }</h1>
	<c:if test="${not empty param.name}">
			<h1>넘어온 id 데이터는 = ${param.name }</h1>
		</c:if>
	<h1>넘어온 password 데이터는 = ${param.password}</h1>
	<c:forEach var="i" begin="1" end="10">  <!--for 문 -->
	 	2 * ${i } = ${2 * i } 
	 	${names[0] }<br/>
	
	</c:forEach>
	
	<c:forEach items="${param.names }" var="m"> <!-- for each문 -->
		<h1>${m }</h1>
	</c:forEach>
	
	<c:choose>
		<c:when test="${not empty param.name}">
		<h3>아이디 값이 비어있다.</h3>
		</c:when>
		<c:when test="${not empty param.name}">
		<h3>아이디 값이 비어있다.</h3>
		</c:when>
		<c:when test="${not empty param.name}">
		<h3>아이디 값이 비어있다.</h3>
		</c:when>
		<c:otherwise>
			<h3>정상동작 되었다.</h3>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>