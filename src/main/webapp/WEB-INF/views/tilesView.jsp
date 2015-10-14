<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 
<%--defaultTemplate를 적용할 때 템플릿의 title, body 영역은 여기에서 오버라이드한다 --%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title">Tiles 3 Test</tiles:putAttribute>
    <tiles:putAttribute name="body">
 
        <div class="body">
            <h1>Hello Apache Tiles !</h1> 
  
            <p>The time on the server is ${serverTime}.</p>
            <p>Spring 4, Tiles 3 Integration Test</P>
        </div>
 
    </tiles:putAttribute>
</tiles:insertDefinition>