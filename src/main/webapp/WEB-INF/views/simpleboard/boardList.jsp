<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록보기</title>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript">
	$(function() {
		var cate;
		$('button[name=btn_search]').on(
				'click',
				function(evt) {

					var word = $('input[name=searchword]').val();
					cate = $('select[name=category]').val();
					if (word != null) {
						location.href = 'search?word=' + word + '&cate=' + cate
								+ '&pnum=1';
					}
				});
		$('input[name=searchword]').on(
				'keydown',
				function(evt) {

					var word = $('input[name=searchword]').val();
					cate = $('select[name=category]').val();

					if (evt.keyCode == 13) {
						if (word != null) {
							location.href = 'search?word=' + word + '&cate='
									+ cate + '&pnum=1';
						}
					}

				});
	});
</script>
</head>
<body>
	<a href="list?pnum=1"><h5>글목록</h5></a>
	<select name="category">
		<option>글제목</option>
		<option>글쓴이</option>
	</select>
	<input type="text" name="searchword">
	<button type="button" name="btn_search">검색</button>
	<br>
	<br>
	<br>
	<a href="input"><button type="button">글쓰기</button></a>
	<br>
	<br>
	<c:forEach var="b" items="${list}">
${b.bnum} 
<a href="info?bnum=${b.bnum}"> ${b.title} </a> 
${b.author} ${b.wdate} <br>
	</c:forEach>
	<p>
<c:choose>
    <c:when test="${search}">
			<c:choose>
				<c:when test="${navi.leftMore}">
					<a href="search?word=${word}&cate=${cate}&pnum=1"> [<<] </a>
					<%-- ${navi.links.length-1}${navi.links().length-1}--%>
				</c:when>
			</c:choose>
	</c:when>	


	<c:otherwise>
			<c:choose>
				<c:when test="${navi.leftMore}">
					<a href="list?pnum=1"> [<<] </a>
				</c:when>
			</c:choose>
	</c:otherwise>

</c:choose>


		<!--  -->
		
		<c:choose>
    <c:when test="${search}">
    	<c:forEach var="board" items="${navi.links}">

			<c:choose>
				<c:when test="${navi.currPage==board}">
          [<span style='color: red; font-size: 1.5em;'>${board}</span>]
       </c:when>
				<c:when test="${navi.currPage!=board}">
        [ <a href="search?word=${word}&cate=${cate}&pnum=${board}">${board}</a>]
       </c:when>
			</c:choose>

		</c:forEach>
    </c:when>
    
    <c:otherwise>
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
		</c:otherwise>

</c:choose>
		<!--  -->
		
		
		
<c:choose>
    <c:when test="${search}">	
		
			<c:choose>
				<c:when test="${navi.rightMore}">
					<a href="search?word=${word}&cate=${cate}&pnum=${navi.linknum}">
						[>>] </a>
					<%-- ${navi.links.length-1}${navi.links().length-1}--%>
				</c:when>
			</c:choose>
			
		</c:when>
		
		<c:otherwise>
			<c:choose>
				<c:when test="${navi.rightMore}">
					<a href="list?pnum=${navi.linknum}"> [>>] </a>
					<%-- ${navi.links.length-1}${navi.links().length-1}--%>
				</c:when>
			</c:choose>
			</c:otherwise>

</c:choose>
		
</body>
</html>