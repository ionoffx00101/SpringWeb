<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>eventInput</title>
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
padding:15px 15px 15px 15px;
	border: 1px solid black;
}

th {
	border: 1px solid black;
}
</style>
</head>
<body>
<h2>행사 수정</h2>
<div>
		<form method="post" action="eventEdit.do">
			<table>
				<tr>
					<td>행사번호 :</td>
					<td><input type="text" name="eno" value="${selectevt.eno}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>행사주관단체 :</td>
					<td><input type="text" name="eorg" value="${selectevt.eorg}"></td>
				</tr>
				<tr>
					<td>행사일 :</td>
					<td><input type="date" name="edate" value="${selectevt.edate}"></td>
				</tr>
				<tr>
					<td>행사장소 :</td>
					<td><input type="text" name="eplace" value="${selectevt.eplace}"></td>
				</tr>
				<tr>
				<tr>
					<td>연락처 :</td>
					<td><input type="text" name="phone" value="${selectevt.phone}"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정내역 저장" /></td>
				</tr> 
				<tr>
					<td colspan="2"><a href="eventList">행사전체리스트 보기</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>