<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>답글 작성</h1>
<div class="form-container">
    <form action="reply.do" method="post">
        <input type="hidden" name="nbMvcBoard" value="<%=request.getParameter("nbMvcBoard") %>">
        <table>
            <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="nmName" required>
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" name="nmTitle" required>
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea name="nmContent" required></textarea>
                </td>
            </tr>
        </table>
        <div class="btn-container">
            <input type="submit" value="작성">
            <a href="list.do">목록보기</a>
        </div>
    </form>
</div>
</body>
</html>
