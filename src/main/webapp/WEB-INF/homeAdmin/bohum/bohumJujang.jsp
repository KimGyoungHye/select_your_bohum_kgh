<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>
    
bohum<br>
<table>
<c:forEach items="${bohumJujangInfoArr }" varStatus="status" var="jujang">
	<tr>
		<td>${jujang.cmpyCd }</td>
		<td>${jujang.cmpyNm }</td>
		<td>${jujang.ptrn }</td>
		<td>${jujang.age }</td>
		<td>${jujang.prdNm }</td>
	</tr>
</c:forEach>
</table>

<br> ${pageInfo.pagingHtml}

<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>


