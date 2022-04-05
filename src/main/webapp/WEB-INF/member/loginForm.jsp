<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>
<%@include file="/WEB-INF/common/common_kakaoLog.jsp"%>
<!-- 나중에 타입 password로 변경  -->

<div class="row">
	<div class="col-md-offset-1 col-md-10 checkContainer">
		<h3>Login</h3>
	</div>
</div>
<div class="row">
	<div class="col-md-offset-1 col-md-5 checkContainer">
		<form:form role="form" method="post" commandName="memberBean"
			action="login.mem" class="form-horizontal">
			<div class="form-group">
				<label for="id" class="col-md-3 control-label"> 아이디 : </label>
				<div class="col-md-6">
					<input name="id" id="id" value="${memberBean.id }"
						class="form-control" placeholder="아이디">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-md-3 control-label">
					비밀번호 : </label>
				<div class="col-md-6">
					<input name="password" id="password"
						value="${memberBean.password }" class="form-control"
						placeholder="비밀번호">
				</div>
			</div>
			<div class="form-group">
				<div class=" col-md-offset-3 col-md-6 ">
					<button type="submit" class="form-control btn btn-primary">LOGIN</button>
				</div>
			</div>
			<div class="form-group">
				<div class=" col-md-offset-3 col-md-2 ">
					<a href="findid.mem">ID찾기</a>
				</div>
				<div class="col-md-2 ">
					<a href="findpw.mem">PW찾기</a>
				</div>
			</div>
		</form:form>
	</div>
	<div class="col-md-5 checkContainer">
		<div class="row">
			<div class="col-md-12">
				<a id="custom-login-btn" href="javascript:kakaoLogin()">
				  <img
				    src="//k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
				    width="222"
				    alt="카카오 로그인 버튼"
				  />
				</a>
				 <form method="post" action="kakaoLogin.mem" id="myForm">
				 	 <input type="text" id="userinfo" name="userinfo" value="" /> <!-- 유저정보를 저장할 input 엘리먼트 -->
				 </form>
				<!-- <a href="kakaoTest.mem">로그인테스트</a> -->
				
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h3>부트스트랩으로 높이 설정하는거 모름</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<input type="button" class="form-control btn btn-primary" value="회사 등록">
			</div>
		</div>
	</div>
</div>
	<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>