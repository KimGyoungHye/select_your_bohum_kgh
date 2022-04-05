<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>

<style type="text/css">
.err {
	color: red;
	font-weight: bold;
}
</style>

<% 	String[] categoryArr = {"보험질문","고객의소리","답변"};
%>
<c:set value="<%=categoryArr %>" var="categoryArr"/>
<div class="row">
	<div class="col-md-offset-1 col-md-10 checkContainer">

		<form:form method="post" commandName="QA_BoardBean"
		 action="reply.qa">
			<input type="text" name="ref" value="${ref }" />
			<input type="text" name="re_step" value="${re_step }" />
			<input type="text" name="re_level" value="${re_level }" />

			<table class="table table-bordered">
				<tr>
					<td colspan="2" align="right"><a href="list.bd">글목록</a></td>
					<td align="center">에러여부</td>
				</tr>
				<tr>
				<td align="center">작성자</td>
					<td><input type="text" name="writer" class="form-control" 
						value="${ loginInfo.id }" readonly></td>
					<td><form:errors path="writer" cssClass="err" /></td>
				</tr>
				<tr>
					<td align="center">카테고리</td>
					<td>
						<select name="category" class="form-control">
						<c:forEach var="category" items="${categoryArr }" varStatus="status">
							<option value="${category }"
							<c:if test="${category==QA_BoardBean.category }">
								selected
							</c:if>
							>${category }</option>
						</c:forEach>
					</select>
					</td>
					<td><form:errors path="category" cssClass="err" /></td>
				</tr>
				<tr>
					<td align="center">보험사</td>
					<td>
						<select name="company" class="form-control">
							<option value="">보험사 선택</option>
							<c:forEach var="company" items="${companyList }" varStatus="status">
								<option value="${company.cnum }"
								<c:if test="${company.cnum==QA_BoardBean.company }">
									selected
								</c:if>
								>${company.cname }</option>
							</c:forEach>
						</select>
					</td>
					<td><form:errors path="company" cssClass="err" /></td>
				</tr>
				<tr>
					<td align="center">제목</td>
					<td><input type="text" name="title" class="form-control"
					value="${QA_BoardBean.title }" ></td>
					<td><form:errors path="title" cssClass="err" /></td>
				</tr>

				<tr>
					<td align="center">내용</td>
					<td><textarea name="content" class="form-control"  rows="15" cols="50">${QA_BoardBean.content }</textarea></td>
					<td><form:errors path="content" cssClass="err" /></td>
				</tr>
				
				<tr>
					<td align="center">이미지 첨부</td>
					<td><input type="file" name="image"></td>
				</tr>

				<tr>
					<td align="center">비밀번호</td>
					<td><input type="password" name="password" class="form-control"></td>
					<td><form:errors path="password" cssClass="err" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="답글쓰기" class="btn btn-primary" onClick="return check()"> 
					<input type="reset"value="다시작성" class="btn btn-primary"> 
					<input type="button" value="목록보기" class="btn btn-primary" onClick="location.href='list.qa'"></td>
				</tr>
			</table>
		</form:form>
	</div>
</div>
