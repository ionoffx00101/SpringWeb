<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 리스트</title>
</head>
<body>
<h2>사원정보 리스트</h2>
<c:forEach var="e" items="${empList}" >
${e.empno} 
<a href="empInfo?empno=${e.empno}"> ${e.ename} </a> 
${e.deptno} ${e.job} ${e.sal} <br>
</c:forEach>
<p>
<a href="empInputForm">사원정보 추가</a>
</body>
</html>