<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 결과</title>
</head>
<body>
<h2>업로드된 파일 정보</h2>
파일명: ${filename} <br>
설 명 : ${desc} <br>
<form action="download" method="post">
    <input type="hidden" name="filename" value="${filename}"><br>
    <input type="submit" value="DOWNLOAD"><br>
</form>
</body>
</html>