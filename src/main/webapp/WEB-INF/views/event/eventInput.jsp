<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>eventInput</title>
</head>
<body>
<div>
		<form method="post" action="eventInput.do">
			<table>
				<tr>
					<td>행사주관단체 :</td>
					<td><input type="text" name="eorg" required="required"></td>
				</tr>
				<tr>
					<td>행사일 :</td>
					<td><input type="date" name="edate" required="required"></td>
				</tr>
				<tr>
					<td>행사장소 :</td>
					<td><input type="text" name="eplace"></td>
				</tr>
				<tr>
				<tr>
					<td>연락처 :</td>
					<td><input type="text" name="phone" ></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="행사저장" /></td>
				</tr>
				<tr>
					<td colspan="2"><a href="eventList">행사전체리스트 보기</a></td>
				</tr>
			</table>
		</form>
	</div>
	<%-- <div>
		<form:form method="post" action="eventInput.do" modelAttribute="event">
			<table>
				<tr>
					<td>행사주관단체 :</td>
					<td><form:input path="eorg" /></td>
				</tr>
				<tr>
					<td>행사일 :</td>
					<td><form:input path="edate" /> </td>
				</tr>
				<tr>
					<td>행사장소 :</td>
					<td><form:input path="eplace" /></td>
				</tr>
				<tr>
				<tr>
					<td>연락처 :</td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="행사저장" /></td>
				</tr>
				<tr>
					<td colspan="2"><a href="eventList">행사전체리스트 보기</a></td>
				</tr>
			</table>
		</form:form>
	</div> --%>

</body>
</html>