<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>
    
bohum<br>
<table border="1" >
<c:forEach items="${bohumDataDetailInfoArr }" varStatus="status" var="test">
	<tr>
		<td>${test.basDt }</td>
		<td>${test.cmpyCd  }</td>
		<td>${test.cmpyNm  }</td>
		<td>${test.ptrn  }</td>
		<td>${test.mog }</td>
		<td>${test.mlInsRt }</td>
		<td>${test.fmlInsRt }</td>
	</tr>
</c:forEach>
</table>
<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>


