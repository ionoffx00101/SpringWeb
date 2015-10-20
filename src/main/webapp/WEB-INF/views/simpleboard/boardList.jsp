<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록보기</title>
<script type="text/javascript" src="<c:url value="/resources/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript">
$(function() {
	var cate;
	$('button[name=btn_search]').on('click', function(evt){
		
            var word = $('input[name=searchword]').val();
            cate = $('select[name=category]').val();
          if(word!=null){
        	  location.href='search?word='+word+'&cate='+cate+'&pnum='+1+'';
          }      
    });
 
});

</script>
</head>
<body>
<h5>글목록</h5>
<select name="category">
<option>글제목</option>
<option>글쓴이</option>
</select> <input type="text" name="searchword"><button type="button" name="btn_search"> 검색</button><br>

<c:forEach var="b" items="${list}" >
${b.bnum} 
<a href="info?bnum=${b.bnum}"> ${b.title} </a> 
${b.author} ${b.wdate} <br>
</c:forEach>
<p>
<a href="input">사원정보 추가</a>
<br>
<c:choose>
			<c:when test="${navi.leftMore}">
				<a href="list?pnum=1"> [<<] </a>
			</c:when>
		</c:choose> 
		<c:forEach var="board" items="${navi.links}">
 
			<c:choose>
				<c:when test="${navi.currPage==board}">
          [<span style='color: red; font-size: 1.5em;'>${board}</span>]
       </c:when>
				<c:when test="${navi.currPage!=board}">
        [ <a href="list?pnum=${board}">${board}</a>]
       </c:when>
			</c:choose>
 
		</c:forEach>
		
		<c:choose>
			<c:when test="${navi.rightMore}">
				<a href="list?pnum=${navi.linknum-1}"> [>>] </a><%-- ${navi.links.length-1}${navi.links().length-1}--%>
			</c:when>
		</c:choose> 
</body>
</html>