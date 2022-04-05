<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/common/common_top.jsp" %>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<style>
.col-xs-1, .col-sm-1, .col-md-1, .col-lg-1, .col-xs-2, .col-sm-2,
	.col-md-2, .col-lg-2, .col-xs-3, .col-sm-3, .col-md-3, .col-lg-3,
	.col-xs-4, .col-sm-4, .col-md-4, .col-lg-4, .col-xs-5, .col-sm-5,
	.col-md-5, .col-lg-5, .col-xs-6, .col-sm-6, .col-md-6, .col-lg-6,
	.col-xs-7, .col-sm-7, .col-md-7, .col-lg-7, .col-xs-8, .col-sm-8,
	.col-md-8, .col-lg-8, .col-xs-9, .col-sm-9, .col-md-9, .col-lg-9,
	.col-xs-10, .col-sm-10, .col-md-10, .col-lg-10, .col-xs-11, .col-sm-11,
	.col-md-11, .col-lg-11, .col-xs-12, .col-sm-12, .col-md-12, .col-lg-12
	{
	border: 1px solid red;
	padding: 10px;
}

.row {
	margin-bottom: 4px;
	margin-top: 4px;
}
</style>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<%
	String main = request.getContextPath()+"/main.isp";

 	//insuredPerson : 피보험자
%>

  <div class="container"> 
    <div class="row"> 
      <div class="col-md-6"><a href="<%=main%>">피보험자 메인 홈페이지<!-- (홈 아직 진행 중) --></a></div>
      <div class="col-md-6"><a href="myPage.mem">내 정보로 바로가기<!-- (유저디테일완료,기본정보는아직) --></a></div>
    </div>
    <div class="row">
      <div class="col-md-6"><a href="list.qa">Q&A 게시판 바로 가기<!-- (완료) --></a></div>
      <div class="col-md-6"><a href="list.bd">공지사항 게시판 바로 가기<!-- (아직 안 함) --></a></div>
    </div>
    <div class="row">
      <div class="col-md-6"><a href="memberList.mem">유저 리스트 보기(관리자만 가능)</a></div>
      <div class="col-md-6"><a href="findid.mem">ID찾기<!-- (id불러오는거성공//어디로?가요?여쭈어보기) --></a></div>
    </div>
    <div class="row">  
      <div class="col-md-6"><a href="findpw.mem">PW찾기<!-- (불러오는거성공//어디로?가요?여쭈어보기) --></a></div>
      <div class="col-md-6"><a href="memberList.mem">유저 리스트 보기(정렬 아직 미완성)</a></div>
    </div>
    <div class="row">
      <div class="col-md-6"><a href="companyInsert.cp">회사 추가</a></div>
      <div class="col-md-6"><a href="companyRegister.mem">회사 멤버 추가</a></div>
    </div>
    <div class="row">
      <div class="col-md-6">.col-md-6</div>
      <div class="col-md-6">.col-md-6</div>
    </div>
  </div>
  
  <%@include file="/WEB-INF/common/common_bottom.jsp" %>
  
