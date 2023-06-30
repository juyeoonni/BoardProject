<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="list.do" method="post">
	<h2>Board</h2>
	<table width="500" cellpadding="0" border="1">
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>제목</td>
		<td>날짜</td>
		<td>조회수</td>
	</tr>
	
	<c:forEach items ="${list }" var ="dto">
	<tr>
		<td>${dto.nbMvcBoard }</td>
		<td>${dto.nmName }</td>
		<td><a href="content_view.do?nbMvcBoard=${dto.nbMvcBoard}">${dto.nmTitle }</a></td>  
		<td>${dto.dwWrite }</td>
		<td>${dto.cnHit }</td>
	</tr> 
	</c:forEach>
	
	<tr>
		<td colspan="5">
			<a href="list.do">게시글 조회</a> <br/>
			<a href="insertBoard.jsp">게시글 작성</a> <br/>
			<a href="updateBoard.jsp">게시글 수정</a>
			<a href=""></a>
		</td>
	</tr>
	</table>
	</form>
</body>
</html>