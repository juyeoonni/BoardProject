<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String nbMvcBoard = request.getParameter("nbMvcBoard");
    String nmName = request.getParameter("nmName");
    String nmContent = request.getParameter("nmContent");
    String nmTitle = request.getParameter("nmTitle");
    String nbStep = request.getParameter("nbStep");
	System.out.println(nbMvcBoard);
	System.out.println(nmName);
	System.out.println(nmTitle);
	
	System.out.println("nbStep" + nbStep);
%>

<h2></h2>
번호 : <%= nbMvcBoard %></td>
<form action="reply.do" method="post">
    
    <input type="hidden" name="nbMvcBoard" value="<%= nbMvcBoard %>">
    <input type="hidden" name="nbStep" value="<%= nbStep %>">
    
    <label for="nmName">답변자 : </label>
    <input type="text" id="nmName" name="nmName" value="<%= nmName %>" ><br>
    
    <label for="nmTitle">제목 : </label>
    <input type="text" id="nmTitle" name="nmTitle" value="<%= nmTitle %>"><br>
    
    <label for="nmContent">답변 내용 :</label>
    <textarea id="nmContent" name="nmContent" cols="67" rows="15"><%= nmContent %></textarea><br>
    <input type="submit" value="답변">
</form>

