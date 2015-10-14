<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
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
</style>
<script type="text/javascript"
	src="<c:url value="resources/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript">
$(jqueryOk);
function jqueryOk() {
	
	$("#edit").on("click",function (evt){
        evt.preventDefault();
		
		$.ajax({
			type : "post",
			url : "empEdit",
			dataType : "json",
			data :  $('form').eq(0).serialize()
			,
			success : function(json) {
				if (json.ok) {
					alert('변경 성공');
					location.href="emplist"
				} else
					alert('변경 실패');
			},
			error : function(err) {
				alert("에러");
			}

		});
	});
	
	
}
</script>
</head>
<body>
	<form>
		<table>
			<tr>
				<th>이름</th>
				<td>${emp.ename}</td>
			</tr>
			<tr>
				<th>사번</th>
				<td><input type="text" name=empno value="${emp.empno}"
					readonly="readonly"></td>
			</tr>
			<tr>
				<th>급료</th>
				<td><input type="text" name=sal value="${emp.sal}"></td>
			</tr>
			<tr>
				<th>부서번호</th>
				<td><input type="text" name=deptno value="${emp.deptno}"></td>
			</tr>
			<tr>
				<th>입사일</th>
				<td>${emp.hiredate}</td>
			</tr>
		</table>
		<button id="edit">수정하기</button>
	</form>
	
</body>
</html>