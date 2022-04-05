<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>
<div class="row">
	<div class="col-md-offset-1 col-md-10 checkContainer">
		<h3>PW찾기</h3>
	</div>
</div>
<div class="row">
	<div class="col-md-offset-1 col-md-10 checkContainer">
		<form action="findpw.mem" method="post">
			<table class="table">
				<tr>
					<th align="center">아이디</th>
					<td><input type="text" name="id" class="form-control"></td>
				</tr>
				<tr>
					<th align="center">이름</th>
					<td><input type="text" name="name" class="form-control"
						placeholder="이름"></td>
				</tr>
				<tr>
					<th align="center">주민 등록 번호</th>
					<td><input type="text" name="regi_number1" maxlength="6"
						placeholder="주민 번호 앞자리"> 
						- <input type="text"
						name="regi_number2" maxlength="7" 
						placeholder="주민 번호 뒷자리">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit"
						value="비밀번호 찾기" class="form-control btn btn-primary">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>