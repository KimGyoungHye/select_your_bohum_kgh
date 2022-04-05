<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>

<div class="row">
	<div class="col-md-offset-1 col-md-7 checkContainer">
		<h1>myPageMain!!</h1>
	</div>
	<div class="col-md-3 checkContainer">.col-md-3</div>
</div>
<div class="row">
	<c:if test="${myDetailNum!=null }">
		<div class="col-md-offset-1 col-md-4 checkContainer">
			<a href="update.md">내 상세 정보 수정</a>
		</div>
		<div class="col-md-4 checkContainer">
			<a href="delete.md">내 상세 정보 삭제</a>
		</div>
	</c:if>
	<c:if test="${myDetailNum==null }">
		<div class="col-md-offset-1 col-md-4 checkContainer">
			<a href="insert.md">내 상세 정보 추가</a>
		</div>
	</c:if>
	
</div>

<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>