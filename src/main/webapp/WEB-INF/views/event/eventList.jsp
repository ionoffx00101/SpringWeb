<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>eventList</title>
<style type="text/css">
a:link {text-decoration: none; color: black;}
a:visited {text-decoration: none; color: black;}
a:active {text-decoration: none; color: black;}
a:hover {text-decoration: none; color: blue; font-weight: bold;}
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
<script type="text/javascript" src="<c:url value="/resources/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript">
$(function() {
	var cate;
	$('button[name=btn_search]').on('click', function(evt){
		
            var word = $('input[name=searchword]').val();
            cate = $('select[name=category]').val();
          if(word!=null){
        	  location.href='eventSearch.do?word='+word+'&cate='+cate+'';
          }      
    });
  /*   if(cate == '행사날짜'){
    	$('input[name=searchword]').CSS("type","date");
    	
    } */
    $('select[name=category]').change(function(){
    	cate=$('select[name=category]').val();
    	if(cate == '행사날짜'){
    	$('input[name=searchword]').attr("type","date");
    	}
    	else{
        	$('input[name=searchword]').attr("type","text");
        }
    });
     /*  if(word!=null){
    	  
    	  location.href='eventSearch.do?word='+word+'&cate='+cate+'';
      }       */

});

</script>
</head>
<body>
<h2><a href="eventList">행사리스트</a></h2><br>
주관단체명을 누르면 해당 행사의 상세페이지로 이동합니다.<br><br>
<a href="eventInput.do"><button type="button">이벤트추가</button></a><br><br>
<select name="category">
<option>행사주관단체</option>
<option>행사날짜</option>
<option>행사장소</option>
</select> <input type="text" name="searchword"><input type="date" name="searchworddate" hidden="hidden"> <button type="button" name="btn_search"> 검색</button>
<br><br>
<table>
<tr><td>행사번호</td>
<td>행사날짜</td>
<td>행사주관단체</td>
<td>행사장소</td>
<td>연락처</td></tr>
<c:forEach var="evt" items="${list}">
    <tr><td>${evt.eno}</td>
    <td>${evt.edate}</td>
    <td><a href="eventInfo.do?eno=${evt.eno}">${evt.eorg}</a></td>
   <td>${evt.eplace}</td>
    <td>${evt.phone}</td></tr>
</c:forEach>

</table>
<p>

</body>
</html>