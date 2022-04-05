<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
deleteForm.jsp<br>
num : ${num }<br>
<form method="post" action="delete.qa?">
	<input type="hidden" name="pageNumber" value="${pageNumber }">
	<input type="hidden" name="no" value="${no}">
	
	<table border="1" align="center">
		<tr>
			<td align="center">비밀번호를 입력하세요</td>
		</tr>
		<tr>
			<td>비밀번호: <input type="password" name="password"></td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" value="글삭제">
				<input type="button" value="글목록" onclick="location.href='list.qa?pageNumber=${pageNumber}">
			</td>
		</tr>
	</table>
</form>