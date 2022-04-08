<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>
<%-- <h1>pageNumber : ${pageNumber}</h1> --%>
<div class="row">
	<div class="col-md-offset-1 col-md-10 checkContainer">

		<form:form method="post" commandName="QA_BoardBean" enctype="multipart/form-data" 
			action="update.qa">
			<input type="text" name="pageNumber" value="${pageNumber}">
			<input type="text" name="no" value="${QA_BoardBean.no}">
			<input type="text" name="company" value="${QA_BoardBean.company}">
			<input type="text" name="category" value="${QA_BoardBean.category}">
			<input type="text" name="writer" value="${QA_BoardBean.writer}">
			
			<table class="table table-bordered">
				<tr>
					<td colspan="2" align="right"><a href="list.qa">글목록</a></td>
					<td align="center">에러여부</td>
				</tr>
				<tr>
					<td><form:errors path="no" cssClass="err" /></td>
					<td><form:errors path="company" cssClass="err" /></td>
					<td><form:errors path="category" cssClass="err" /></td>
					<td><form:errors path="writer" cssClass="err" /></td>
				</tr>

				<tr>
					<td align="center">제목</td>
					<td><input type="text" name="title" class="form-control" 
						value="${ QA_BoardBean.title }"></td>
					<td><form:errors path="title" cssClass="err" /></td>
				</tr>

				<tr>
					<td align="center">내용</td>
					<td>
						<textarea name="content" class="form-control"
						 rows="15" cols="50">${ QA_BoardBean.content }</textarea>
					</td>
					<td><form:errors path="content" cssClass="err" /></td>
				</tr>
				
				<tr>
					<td align="center">첨부파일</td>
					<td><input type="file" name="upload"
						class="form-control"></td>
					<td>파일 삭제<input type="checkbox" name="imageFlag" value="noImage"><form:errors path="image" cssClass="err" /></td>
				</tr>

				<tr>
					<td align="center">비밀번호</td>
					<td><input type="password" name="password" class="form-control"></td>
					<td><form:errors path="password" cssClass="err" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="글쓰기" class="btn btn-primary"> 
					<input type="reset" value="다시작성" class="btn btn-primary"> 
					<input type="button" value="목록보기" class="btn btn-primary" onClick="location.href='list.qa'">
					</td>
				</tr>
			</table>

		</form:form>
	</div>
</div>
<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>
