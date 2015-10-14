<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	boolean ok = (boolean) request.getAttribute("loginOk");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- <script type="text/javascript" src="resources/jquery-2.1.4.min.js"></script> -->
<script type="text/javascript" src="<c:url value="resources/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript">

$(jqueryOk);
function jqueryOk() {
 $('td[class=anser]').css("border","solid 2px black");	
}
</script>
<title>Insert title here</title>
</head>
<body>
<table><tr>
	<td>로그인 시도 결과:</td><td class="anser">	
<%
	if (ok) {
%>
	성공
	<%
	} else {
%>실패<%
	}
%></td></tr></table>
</body>
</html>