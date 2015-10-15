<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>eventList</title>
</head>
<body>
<c:forEach var="evt" items="${list}">
    ${evt.eno} |
    ${evt.edate} |
    ${evt.eorg} |<%-- <a href="info.do?empno=${emp.empno}">${emp.ename}</a> --%>
    ${evt.eplace} |
    ${evt.phone}<br>
</c:forEach>
<p>
<a href="eventInput.do">이벤트추가</a>
</body>
</html>