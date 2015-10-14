<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
<script type="text/javascript" src="<c:url value="resources/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript">
$(jqueryOk);
function jqueryOk() {
	
	$("#edit").on("click",function (){
		location.href="empEdit?empno="+$("#empno").text();
	});
	$("#delete").on("click",function (){
		
	});
	
	$('#delete').click(function(evt) {
		
		evt.preventDefault();
		if(confirm("정말로 삭제하시겠습니까?")){
		$.ajax({
			type : "post",
			url : "empInfo/delete",
			dataType : "json",
			data :  {"empno":$('#empno').text()}
			,
			success : function(json) {
				if (json.ok) {
					alert('삭제 성공');
					location.href="emplist"
				} else
					alert('삭제 실패');
			},
			error : function(err) {
				alert("에러");
			}

		});
		}
	});
}
</script>
</head>
<body>
<table>
<tr><th>사번</th><td id="empno" width="300px" height="30px">${emp.empno}</td></tr>
<tr><th>이름</th><td width="300px" height="30px">${emp.ename}</td></tr>
<tr><th>부서번호</th><td width="300px" height="30px">${emp.deptno}</td></tr>
<tr><th>급료</th><td width="300px" height="30px">${emp.sal}</td></tr>
<tr><th>입사일</th><td width="300px" height="30px">${emp.hiredate}</td></tr>
<tr><td><button id="edit">수정하기</button></td><td><button id="delete">삭제하기</button></td></tr>
</table>
</body>
</html>