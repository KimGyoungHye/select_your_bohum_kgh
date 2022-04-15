<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>

<% 
	String[] userStateArr = {"일반","회사","관리자","블랙"};
	String[] whatColumnArr = {"전체 검색","아이디","유저타입","보험사"};
	String[] whatColumnValArr = {"all","id","userState","companyInfo"};
%>
<c:set value="<%=userStateArr%>" var="userStateArr" />
<c:set value="<%=whatColumnArr%>" var="whatColumnArr" />
<c:set value="<%=whatColumnValArr%>" var="whatColumnValArr" />
<div class="row">
	<div class="col-md-offset-1 col-md-10 checkContainer">
		<form action="memberList.mem" method="post">
			<div class="col-md-2 checkContainer">
				<select name="whatColumn" class="form-control">
					<c:forEach var="i" begin="0" end="${fn:length(whatColumnArr)-1}" step="1">
						<option value="${whatColumnValArr[i] }" 
						<c:if test="${whatColumn==whatColumnValArr[i] }">
							selected
						</c:if>
						>${whatColumnArr[i] }
					</c:forEach>
				</select>
			</div>
			<div class="col-md-5 checkContainer">
				<input name="keyword" value="${keyword }" class="form-control">
			</div>
			<div class="col-md-2 checkContainer">
				<input type="submit" value="검색" class="form-control btn btn-primary ">
			</div>
		</form>
	</div>
</div>
<div class="row">
	<div class="col-md-offset-1 col-md-10 checkContainer">
		<table class="table table-hover" >
			<tr>
				<td><h5>유저 관리 게시판</h5></td>
				<td align="right"><a href="#">회원가입</a></td>
			</tr>
		</table>
		<table class="table table-hover">
			<tr>
				<th align="center">유저타입</th>
				<th align="center">아아디</th>
				<th align="center">이름</th>
				<th align="center">보험사</th>
				<th align="center">블랙</th>
			</tr>
			<c:set var="totalCount" value="${totalCount+1 }" />
			<!-- 4=>5 -->

			<c:forEach var="member" items="${memberList }">
				<tr>
					<td align="center">${member.userState }</td>
					<td align="center">${member.id }</td>
					<td align="center">${member.name }</td>
					<td align="center">
						<a href="content.co?cnum=${member.companyInfo }">
							${member.companyInfo }
						</a>
					</td>
					<td>
						<button class="btn btn-primary btn-md" data-toggle="modal" data-target="#myModal${member.id}">
						사용자 정보 변경하기  
						</button>
<%@include file="/WEB-INF/homeAdmin/member/memberUserStateUpdate.jsp"%>
					</td>
				<tr>
			</c:forEach>
		</table>
		<br> ${pageInfo.pagingHtml}
	</div>
</div>







<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>
    