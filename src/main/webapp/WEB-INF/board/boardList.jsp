<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>


<h5>${number }</h5>
<div class="row">
	<div class="col-md-offset-1 col-md-10 checkContainer">
		<table class="table table-hover" >
			<tr>
				<td><h5>공지사항 게시판</h5></td>
				<td align="right"><a href="insert.bd">글쓰기</a></td>
			</tr>
		</table>
		<table class="table table-hover">
			<tr>
				<th align="center">번호</th>
				<th align="center">제목</th>
				<th align="center">작성자</th>
				<th align="center">보험사</th>
				<th align="center">작성일</th>
				<th align="center">조회</th>
				<th align="center">IP</th>
			</tr>
			<c:set var="totalCount" value="${totalCount+1 }" />
			<!-- 4=>5 -->

			<c:forEach var="article" items="${boardList }">

				<tr>
					<td align="center"><c:set var="totalCount"
							value="${totalCount-1 }" /> ${totalCount }</td>
					<td><c:if test="${article.re_level > 0 }">
							<c:set var="wid" value="${article.re_level*20 }" />
							<img
								src="<%=request.getContextPath() %>/resources/qa_board/images/level.gif"
								width="${wid }" height="15">
							<img src="<%=request.getContextPath()%>/resources/qa_board/images/re.gif">
						</c:if> <a
						href="content.qa?no=${article.no}&pageNumber=${pageInfo.pageNumber}">${article.title }</a>

						<c:if test="${article.readcount >= 10}">
							<img src="<%=request.getContextPath()%>/resources/qa_board/images/hot.gif"
								height="13">
						</c:if></td>
					<td align="center">${article.writer}</td>
					<td align="center">${article.company}</td>
					<td align="center">${article.reg_date}</td>
					<td align="center">${article.readcount}</td>
					<td align="center">${article.ip}</td>
				<tr>
			</c:forEach>

		</table>

		<br> ${pageInfo.pagingHtml}
	</div>
</div>
<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>
