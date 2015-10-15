<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 입력 폼</title>
<style>  
body {  
 font-size: 20px;  
 color: teal;  
}  
   
td {  
 font-size: 15px;  
 color: black;  
 width: 100px;  
 height: 22px;  
 text-align: left;  
}  
   
.heading {  
 font-size: 18px;  
 color: white;  
 font: bold;  
 background-color: orange;  
 border: thick;  
}  
</style>  
</head>  
<body>  
 <h2>사원정보 입력 폼 </h2>   
 
  <div>  
   <form:form method="post" action="insert.do" modelAttribute="emp">  
    <table>  
     <tr>  
      <td>EMPNO :</td>  
      <td><form:input path="empno" /></td>  
     </tr>  
     <tr>  
      <td>ENAME :</td>  
      <td><form:input path="ename" /></td>  
     </tr>  
     <tr>  
      <td>DEPTNO :</td>  
      <td><form:input path="deptno"/></td>  
     </tr>  
     <tr>  
      <td>JOB :</td>  
      <td><form:input path="job" /></td>  
     </tr>  
     <tr>  
      <td> </td>  
      <td><input type="submit" value="Save" /></td>  
     </tr>  
     <tr>  
         
      <td colspan="2"><a href="list">사원정보 리스트 보기</a></td>  
     </tr>  
    </table>  
   </form:form>  
  </div>  
 
</body>  
</html>