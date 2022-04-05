<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp" %>
<%@include file="/WEB-INF/common/common_memberDetail_value.jsp" %>
	<div class="row">
		<div class=" col-md-offset-1 col-md-7 checkContainer"><h1>Insert</h1></div>
		<div class="col-md-3 checkContainer">.col-md-3</div>
	</div>
	<div class="row">
		<div class="col-md-offset-1 col-md-10 checkContainer">
		<form:form role="form" method="post" commandName="memberBean"
			action="delete.md" class="form-horizontal">
			<input name="num" value="${loginInfo.userDetail }">
			<div class="form-group">
				<label for="password" class="col-md-3 control-label"> 나이 : </label>
				<div class="col-md-6">
					<input name="password" value="${memberDetailBean.age }" 
					class="form-control" placeholder="비밀번호 입력">
				</div>
				<div class="col-md-2">
					<form:errors path="password" cssClass="error"/>	
				</div>
			</div>
			<div class="form-group">
				<div class=" col-md-offset-3 col-md-6 ">
					<button type="submit" class="form-control btn btn-primary">내 정보 삭제</button>
				</div>
			</div>
		</form:form>
		</div>
	</div>	

<%@include file="/WEB-INF/top_bottom/main_bottom.jsp" %>