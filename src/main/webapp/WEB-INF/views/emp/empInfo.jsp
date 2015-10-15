<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 상세 페이지</title>
</head>
<body>
<h2>사원정보 상세 페이지</h2>
사번 ${empInfo.empno } <br>
이름 ${empInfo.ename } <br>
부서 ${empInfo.deptno } <br>
입사 ${empInfo.hiredate } <br>
직무 ${empInfo.job } <br>
급여 ${empInfo.sal } <br>
<p>
<a href="edit.do?empno=${empInfo.empno}">사원정보 수정</a>
<a href="delete.do?empno=${empInfo.empno}">사원정보 삭제</a>
</body>
</html>