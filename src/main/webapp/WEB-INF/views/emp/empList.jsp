<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 리스트</title>
</head>
<body>
<h2>사원정보 리스트</h2>
<c:forEach var="emp" items="${list}">
    ${emp.empno } 
    <a href="info.do?empno=${emp.empno}">${emp.ename}</a> <br>
</c:forEach>
<p>
<a href="insert.do">사원정보 추가</a>
</body>
</html>