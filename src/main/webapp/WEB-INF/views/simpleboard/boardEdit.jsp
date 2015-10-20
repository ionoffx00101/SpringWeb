<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$(jqueryOk);
function jqueryOk() {
	
	$("button[name=submit]").on("click",function (evt){
        evt.preventDefault();
		  $.ajax({
			type : "post",
			url : "update",
			dataType : "json",
			data :   $('form').eq(0).serialize()
			,
			success : function(json) {
				if (json.check) {
					alert("업데이트성공");
					location.href="http://192.168.8.55:8500/SpringWeb/board/info?bnum="+json.bnum+"";
				} else{
					alert("업데이트실패");
				}
			},
			error : function(err) {
				alert("에러 : 다시 시도해주세요");
			}

		}); 
	});
}
</script>
</head>
<body>
<h5>글 수정</h5>

	<div>
		<form>
			<table>
				<tr>
					<td>글번호 :</td>
					<td><input type="text" name="bnum" value="${Info.bnum}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>글제목 :</td>
					<td><input type="text" name="title" value="${Info.title}"></td>
				
				</tr>
				<tr>
					<td>작성자 :</td>
					<td><input type="text"name="author" value="${Info.author}"></td>
				</tr>
				<tr>
					<td>내용 :</td>
					<td><textarea name="bcontents">${Info.bcontents}</textarea></td>
				</tr>

				<tr>
					<td></td>
					<td><button type="button" name="submit">수정하기</button></td>
				</tr>
				<tr>
					<td colspan="2"><a href="list">글목록</a></td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>