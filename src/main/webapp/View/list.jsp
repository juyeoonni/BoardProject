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
		<td>${dto.nmTitle }</td>
		<td>${dto.dwWrite }</td>
		<td>${dto.cnHit }</td>
	</tr> 
	</c:forEach>
	
	<tr>
		<td colspan="5">
			<a href="insert.do">글 작성</a>
		</td>
	</tr>
	</table>
	
</body>
</html>