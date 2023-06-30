<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert.do" method="post">
	작성자: <input type="text" name="nmName"> <br/>
	글 제목: <input type="text" name="nmTitle"> <br/><br/>
	<label for=nmContent>내용:</label>
    <textarea rows="10" cols="50"  type="content" name="nmContent" id="nmContent"></textarea> <br/>
	
	<input type="submit" value="작성">
	
	
	</form>
</body>
</html>