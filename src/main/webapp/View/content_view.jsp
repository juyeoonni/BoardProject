<%@page import="com.daodto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "com.daodto.BoardDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>content_view</title>
</head>
<body>
	<form action="update.do" method="post">
		<table style="width: 500px;">
			<%-- bIdx hidden --%>
			<input type="hidden" name="nbMvcBoard" value="${idContent.nbMvcBoard}" />

			<tr>
				<td>번호</td>
				<td>${idContent.nbMvcBoard}</td>
			</tr>
			<tr>
				<td>조회수(히트)</td>
				<td>${idContent.cnHit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="nmName"
					value="${idContent.nmName}" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="nmTitle"
					value="${idContent.nmTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="nmContent">${idContent.nmContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="수정">&nbsp;&nbsp;
					<a href="list.do">목록보기</a>&nbsp;&nbsp; 
					
					<a href="delete.do?nbMvcBoard=${idContent.nbMvcBoard}">삭제</a>&nbsp;&nbsp; 
					<button type="submit" formaction="reply.jsp" formmethod="post" class="btn-reply">답글</button>
				</td>
			</tr>

			<tr>
				<td colspan="5"><a href="insert.do">글 작성</a></td>
			</tr>

		</table>
	</form>

</body>
</html>