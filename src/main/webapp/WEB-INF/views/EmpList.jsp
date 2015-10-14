
<%@page import="org.kdea.spring.controller.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<% 
if(session.getAttribute("ok")==null){
	session.setAttribute("ok",false);
}
boolean ok=(boolean)session.getAttribute("ok");
if(!ok){%>
	<script>
	alert("로그인 이후에 이용가능한 페이지 입니다");
	location.href="login";
	</script>
<%}
List<EmpVO> list= (List<EmpVO>) request.getAttribute("list"); %>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
}

table {
	display: inline-block;
	text-align: left;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
}

th {
	border: 1px solid black;
}
td.ename{cursor: pointer;}
</style>
<script type="text/javascript" src="<c:url value="resources/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript">

$(jqueryOk);
function jqueryOk() {
	$("td[class=ename]").mouseover(function () {
		$(this).css("color","red");
		$(this).css("font-size","1.1em");
	});
	$("td[class=ename]").mouseout(function () {
		$(this).css("color","black");
		$(this).css("font-size","1em");
	});
	
	$("td[class=ename]").on("click",function (){
		var idx = $(this).attr('data-idx');
		var num = $('#num'+idx).text();
		location.href="empInfo?empno="+num;
	});
	
	$("#input").on("click",function (){
		location.href="empInput";
	});
}

</script>
</head>
<body>

<table>
<% for(int i=0;i<list.size();i++){%>
<tr><td id="num<%=i%>"><%=list.get(i).getEmpno() %></td><td class="ename" data-idx="<%=i%>" width="300px" height="30px"><%=list.get(i).getEname()%></td></tr>
<%	
} %></table><p>
<button id="input">추가하기</button>



</body>
</html>