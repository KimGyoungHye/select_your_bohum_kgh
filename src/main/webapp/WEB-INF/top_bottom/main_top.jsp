<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 공통으로 쓰일 거 import 모아 놓은 거 -->
<%@include file="/WEB-INF/common/common_top.jsp" %>

<!-- 이거 css랑 script따로 빼서 하기! -->
<style type="text/css">
	.checkContainer{
		border: 1px solid red;
		padding: 10px;
	}

	.dropdown:hover .dropdown-menu {
	    display: block;
	    margin-top: 0;
	}
</style>

<script type="text/javascript">
	$(document).ready(abc);
	
	function abc() {
		alert(1);
	}
</script>

  <div class="container"> 
     <div class="row"> 
   
      <div class="col-md-offset-1 col-md-3 checkContainer">
      	<h2>
      		<a href="main.isp">MAIN PAGE TOP</a>
      	</h2>
      	  	loginInfo.id : ${loginInfo.id }<br>
      	 <%--  	id1 : ${id }<br>
      	  	id1 : ${param.id }<br>
      	  	id1 : <%=request.getParameter("id") %><br>
      	  	id1 : ${requestScope.id}<br>
      	  	id1 : ${param["id"]}<br>
       --%>
       </div>
      <div class="col-md-3 checkContainer">
      	<form>
      	     <input name="search">
      	     <input type="submit" value="검색">
      	</form>
      </div>
      <div class="col-md-2 checkContainer">
		<a>키워드1</a>
		<a>키워드2</a>
		<a>키워드3</a>
	  </div>
      <div class="col-md-2 checkContainer">
	     <h2>연락처</h2>
	     <c:if test="${loginInfo.id==null }">
	     	<a href="login.mem">로그인</a>
	  	 </c:if>
	  	 <c:if test="${loginInfo.id!=null }">
	  	 	<a href="myPage.mem">마이페이지</a>
	     	<a href="logout.mem">로그아웃</a>
	  	 </c:if>
	  </div>
    </div>

	<div class="row"> 
      <div class="col-md-offset-1 col-md-2 checkContainer dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">드롭다운 <b class="caret"></b></a>
            <ul class=" dropdown-menu">
              <li><input type="button" value="서브메뉴 1"></li>
              <li><input type="button" value="서브메뉴 2"></li>
              <li><input type="button" value="서브메뉴 3"></li>
            </ul>
      </div>
      <div class="col-md-2 checkContainer">
      	<a>링크1</a>
      </div>
      <div class="col-md-2 checkContainer">
		<a>링크2</a>
	  </div>
      <div class="col-md-2 checkContainer dropdown">
            <a href="#1" class="dropdown-toggle" data-toggle="dropdown">드롭다운 <b class="caret"></b></a>
            <ul class=" dropdown-menu">
              <li><a href="list.qa">게시판</a></li>
              <li><a href="memberList.mem">유저 리스트 보기</a></li>
              <li><a href="#">서브메뉴 3</a></li>
            </ul>
      </div>
      <div class="col-md-2 checkContainer">
	     <input type="button" value="나의 라이프 플래너">
	  </div>
    </div>

	<div class="row"> 
	  <div class="col-md-offset-1 col-md-10 checkContainer dropdown">
            <div class="container"> 
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">드롭다운 <b class="caret"></b></a>
	            <div class="row">
		            <ul class=" dropdown-menu col-md-12">
		              <li>
		              	<div class="col-md-2">
		              		<input type="button" value="서브메뉴 1">
		              	</div>
		              </li>
		              <li>
		              	<div class="col-md-2">
		              		<input type="button" value="서브메뉴 2">
		              	</div>
		              </li>
		              <li>
		              	<div class="col-md-2">
		              		<input type="button" value="서브메뉴 3">
		              	</div>
		              </li>
		            </ul>
	            </div>
	         </div>
      </div>
	</div>
	
