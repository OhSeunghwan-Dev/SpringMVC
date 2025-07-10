<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	<!-- jstl 라이브러리 필수 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>예외발생!!!!</h2>
	
	<h4><c:out value="${exception.getMessage() }"></c:out></h4>
	<!-- 				표현식 : Model 객체로부터 전달받은 데이터를 출력한다. -->
	
	<ul>
		<c:forEach items="${exception.getStackTrace() }" var="stack">
			<li>
				<c:out value="${stack }"></c:out>
				<!--  -->
			</li>
		</c:forEach>
	</ul>
</body>
</html>