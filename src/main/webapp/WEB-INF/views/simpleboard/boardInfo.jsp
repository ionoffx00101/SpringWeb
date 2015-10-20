<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세보기</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$(jqueryOk);
function jqueryOk() {
	$('button[name=delete]').on('click', function(evt){
		  evt.preventDefault();
		  var idx = $(this).attr('data-idx');
          if(confirm("정말삭제하시겠습니까")){ 	        	  	
        	  		  $.ajax({
        	  			type : "post",
        	  			url : "delete",
        	  			dataType : "json",
        	  			data :   {"bnum":idx}
        	  			,
        	  			success : function(json) {
        	  				if (json.check) {
        	  					alert("삭제성공");
        	  					//location.href="<c:url value="/board/list?pnum=1"/>";
        	  					location.href="http://192.168.8.55:8500/SpringWeb/board/list?pnum=1";
        	  				} else{
        	  					alert("삭제실패");
        	  				}
        	  			},
        	  			error : function(err) {
        	  				alert("에러 : 다시 시도해주세요");
        	  			}

        	  		}); 
          }
            
    });
}
</script>
</head>
<body>
<h5>글상세보기</h5>
글번호 : ${Info.bnum} <br>
글제목 : ${Info.title} <br>
글쓴이 : ${Info.author} <br>
작성일 : ${Info.wdate} <br>
글내용 : ${Info.bcontents} <br>

<p>
<a href="reinput?refnum=${Info.bnum}&reftitle=${Info.title}">답글쓰기</a>
<a href="edit?bnum=${Info.bnum}">수정</a>
<button type="button" name="delete"  data-idx="${Info.bnum}">삭제</button>
</body>
</html>