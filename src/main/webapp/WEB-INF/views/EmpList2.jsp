
<%@page import="org.kdea.spring.controller.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	if(session.getAttribute("ok")==null){
	session.setAttribute("ok",false);
}
boolean ok=(boolean)session.getAttribute("ok");
if(!ok){
%>
<script>
	alert("로그인 이후에 이용가능한 페이지 입니다");
	location.href = "login";
</script>
<%
	}
List<EmpVO> list= (List<EmpVO>) request.getAttribute("list");
%>
<script type="text/javascript"
	src="<c:url value="resources/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript">
	$(jqueryOk);
	function jqueryOk() {
		$("td[class=ename]").mouseover(function() {
			$(this).css("color", "red");
			$(this).css("font-size", "1.1em");
		});
		$("td[class=ename]").mouseout(function() {
			$(this).css("color", "black");
			$(this).css("font-size", "1em");
		});

		$("td[class=ename]").on("click", function() {
			var idx = $(this).attr('data-idx');
			var num = $('#num' + idx).text();
			location.href = "empInfo?empno=" + num;
		});

		$("#input").on("click", function() {
			location.href = "empInput";
		});
	}
</script>

<%--defaultTemplate를 적용할 때 템플릿의 title, body 영역은 여기에서 오버라이드한다 --%>
<tiles:insertDefinition name="listTemplate">
	<tiles:putAttribute name="title">Tiles 3 Test</tiles:putAttribute>
	<tiles:putAttribute name="body">


		<table>
			<c:forEach var="i" items="${list}" begin="0" end="${list.size()}" step="1" varStatus="status">
			<tr>
				<td id="num${status.index+1}">${i.empno}</td>
				<td class="ename" data-idx="${status.index+1}" width="300px" height="30px">${i.ename}</td>
			</tr>
			</c:forEach>
		</table>
		<p>
			<button id="input">추가하기</button>
	</tiles:putAttribute>
</tiles:insertDefinition>