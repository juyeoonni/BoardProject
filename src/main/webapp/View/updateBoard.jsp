<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="update.do" method="post">
    <h2>�Խñ� ����</h2> <br/>
    ���̵�: <c:out value="${idContent.id}" /><br/>
    ��ȸ��: <c:out value="${idContent.view}" /><br/>
    <input type="hidden" name="id" value="<c:out value='${idContent.id}' />">
    �̸�: <input type="text" name="name" value="<c:out value='${idContent.name}' />"><br/>
    ����: <input type="text" name="title" value="<c:out value='${idContent.title}' />"><br/> 
    ����: <textarea rows="10" cols="50" name="content" id="content"><c:out value='${idContent.content}' /></textarea><br/>
    <input type="submit" value="����">
</form>
</body>
</html>