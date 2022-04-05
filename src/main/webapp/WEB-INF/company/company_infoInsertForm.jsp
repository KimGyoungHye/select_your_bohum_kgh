<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- company/comapny_infoInsertForm.jsp -->

<h2>보험사 정보 입력</h2>


<form action="companyInsert.cp" method="post" enctype="multipart/form-data" >
	회사 이름 .: <input name="cname"><br>
	관리자 아이디 : <input name="cadmin"><br>
	<input type="file" name="upload"><br>
	<input type="submit" value="등록">
</form>