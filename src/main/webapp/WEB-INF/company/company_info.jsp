<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- company/company_infoList.jsp -->

<h2>우리 보험사 정보</h2>
<table border="1">
	<tr>
		<td rowspan="3"><img
			src="<%=request.getContextPath() %>/resources/${bean.cimage}"
			width=100 height=100></td>
	</tr>

	<tr>
		<td>회사명</td>
		<td>${bean.cname }</td>
	</tr>

	<tr>
		<td colspan="2"><a href="">보험 리스트</a></td>
	</tr>

</table>
<a href="companyInsert.cp">정보 추가</a>
