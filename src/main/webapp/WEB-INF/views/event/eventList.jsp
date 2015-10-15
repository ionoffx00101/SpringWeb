<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>eventList</title>
<style type="text/css">
a:link {text-decoration: none; color: black;}
a:visited {text-decoration: none; color: black;}
a:active {text-decoration: none; color: black;}
a:hover {text-decoration: none; color: blue; font-weight: bold;}
body {
	text-align: center;
}

table {
	display: inline-block;
	text-align: left;
	border-collapse: collapse;
}

td {
padding:15px 15px 15px 15px;
	border: 1px solid black;
}

th {
	border: 1px solid black;
}
</style>
</head>
<body>
주관단체명을 누르면 해당 행사의 상세페이지로 이동합니다.<br><br><br>
<table>
<tr><td>행사번호</td>
<td>행사날짜</td>
<td>행사주관단체</td>
<td>행사장소</td>
<td>연락처</td></tr>
<c:forEach var="evt" items="${list}">
    <tr><td>${evt.eno}</td>
    <td>${evt.edate}</td>
    <td><a href="eventInfo.do?eno=${evt.eno}">${evt.eorg}</a></td>
   <td>${evt.eplace}</td>
    <td>${evt.phone}</td></tr>
</c:forEach>
</table>
<p>
<a href="eventInput.do">이벤트추가</a>
</body>
</html>