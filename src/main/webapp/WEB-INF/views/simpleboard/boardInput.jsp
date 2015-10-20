<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글넣기</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">

$(jqueryOk);
function jqueryOk() {
	$('button[name=submit]').on('click', function(evt){
		  evt.preventDefault();
       	  	
        	  		  $.ajax({
        	  			type : "post",
        	  			url : "insert",
        	  			dataType : "json",
        	  			data :   $('form').eq(0).serialize()
        	  			,
        	  			success : function(json) {
        	  				if (json.check) {
        	  					alert("저장성공");
        	  					//location.href="<c:url value="/board/list?pnum=1"/>";
        	  					location.href="http://192.168.8.55:8500/SpringWeb/board/list?pnum=1";
        	  				} else{
        	  					alert("저장실패");
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
<h5>글쓰기</h5>
<div>
<form>
<table>
<tr>
<td>글제목 :</td>
<td><input type="text" name="title" ></td>
</tr>
<tr>
<td>글쓴이 :</td>
<td><input type="text"name="author" ></td>
</tr>
<tr>
<td>내용 :</td>
<td><textarea name="bcontents" ></textarea></td>
</tr>

<tr>
<td></td>
<td><button type="button" name="submit">등록하기</button></td>
</tr>
<tr>

<td colspan="2"><a href="list?pnum=1">리스트보기</a></td>
</tr>
</table>
</form>
</div>

</body>
</html>