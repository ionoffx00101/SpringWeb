<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>파일 업로드 폼</title>
</head>
<body>
  <form:form method="post" enctype="multipart/form-data" 
   modelAttribute="uploadedFile" action="fileUpload">  
   업로드할 파일 선택: <br>
  <input type="file" name="file"><br>
  <form:errors path="file"/>
  <input type="text" name="desc"><br>
  <input type="submit" value="전 송">  
  </form:form>  
</body>  
</html>