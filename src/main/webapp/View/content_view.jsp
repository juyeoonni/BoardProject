<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>content_view</title>
</head>
<body>

	<form action="modify.do" method="post">
		<table style="width: 500px;">
			<%-- bIdx hidden --%>
			<input type="hidden" name="bIdx" value="${content.bIdx}" />

			<tr>
				<td>번호</td>
				<td>${content.bIdx}</td>
			</tr>
			<tr>
				<td>조회수(히트)</td>
				<td>${content.bReadCount}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bWriter"
					value="${content.bWriter}" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bSubject"
					value="${content.bSubject}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="bContent">${content.bContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;
					<a href="list.do">목록보기</a>&nbsp;&nbsp; <a
					href="delete.do?bIdx=${content.bIdx}">삭제</a>&nbsp;&nbsp; <a
					href="reply_view.do?bIdx=${content.bIdx}">답변</a></td>
			</tr>

			<tr>
				<td colspan="5"><a href="insert.do">글 작성</a></td>
			</tr>

		</table>
	</form>

</body>
</html>