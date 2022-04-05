<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>
<div class="row">
	<div class="col-md-offset-1 col-md-10 checkContainer">
		<table class="table table-bordered">
			<tr>
				<td align="center">글번호</td>
				<td align="center">${ qA_BoardBean.no }</td>
				<td align="center">조회수</td>
				<td align="center">${ qA_BoardBean.readcount }</td>
			</tr>
			<tr>
				<td align="center">작성자</td>
				<td align="center">${ qA_BoardBean.getWriter() }</td>
				<td align="center">작성일</td>
				<td align="center">${ qA_BoardBean.reg_date  }</td>
			</tr>
			<tr>
				<td align="center">카테고리</td>
				<td align="center">${ qA_BoardBean.category  }</td>
				<td align="center">보험사</td>
				<td align="center">${ qA_BoardBean.company  }</td>
			</tr>
			<tr>
				<td align="center">글제목</td>
				<td align="center" colspan="3">${ qA_BoardBean.title }</td>
			</tr>
			<tr height="50">
				<td align="center">글내용</td>
				<td align="center" colspan="3">${ qA_BoardBean.content }</td>
			</tr>
			<tr height="50">
				<td align="center">첨부파일</td>
				<td align="center" colspan="3">
					<c:if test="${qA_BoardBean.image==null }">
						첨부파일 없음
					</c:if>
					${qA_BoardBean.image}
				</td>
			</tr>
			<tr align="center" height="30">
				<td colspan="4"><input type="button" value="글수정" class="btn btn-primary"
					onclick="location.href='update.qa?no=${ qA_BoardBean.no }&pageNumber=${ pageNumber}'">
					<input type="button" value="글삭제" class="btn btn-primary"
					onClick="location.href='delete.qa?no=${ qA_BoardBean.no}&pageNumber=${ pageNumber}'">
					<input type="button" value="답글쓰기" class="btn btn-primary"
					onClick="location.href='reply.qa?ref=${ qA_BoardBean.getRef()}&re_step=${ qA_BoardBean.getRe_step()}&re_level=${ qA_BoardBean.getRe_level()}'">
					<input type="button" value="글목록" class="btn btn-primary"
					onClick="location.href='list.qa?pageNumber=${ pageNumber}'">
				</td>
			</tr>
		</table>
	</div>
</div>
<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>
