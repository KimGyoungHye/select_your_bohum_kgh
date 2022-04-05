<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>
<div class="row">
	<div class="col-md-offset-1 col-md-10 checkContainer">
		<h3>Email로 비번 찾기</h3>
	</div>
</div>
<div class="row">
	<div class="col-md-offset-1 col-md-5 checkContainer">
		<form:form role="form" method="post" commandName="memberBean"
			action="findPwEmail.mem" class="form-horizontal">
			<div class="form-group">
				<label for="id" class="col-md-3 control-label"> 아이디 : </label>
				<div class="col-md-6">
					<input name="id" id="id" value="${memberBean.id }"
						class="form-control" placeholder="아이디">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-md-3 control-label">
					이름 : </label>
				<div class="col-md-6">
					<input name="name" id="name"
						value="${memberBean.name }" class="form-control"
						placeholder="사용자 이름">
				</div>
			</div>
			<div class="form-group">
				<div class=" col-md-offset-3 col-md-6 ">
					<button type="submit" class="form-control btn btn-primary">비번 찾기</button>
				</div>
			</div>
		</form:form>
	</div>
</div>
<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>