<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>
    
bohumChoochun<br>
일단 나이를 31로 고정했어요!!!!!!!!!!!!!!!!!!!!!!!!!!!범위지정하게요!!<br>
아직 유병자인지 아닌지는 안적용했어요!!!!!!!!!!!!!!!!!!!!!!!!!!!<br>
보험료는 등록된 사람의 성별로 분류!!!!!!!!!!!!!!!!!!!!!!!!!!!!<br>


<% 
	String[] whatColumnArr = {"전체 검색","회사이름","보험이름","특약정보"};
	String[] whatColumnValArr = {"all","id","userState","companyInfo"};
%>
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
<table border="1">
	<tr>
		<td>회사코드</td>
		<td>회사이름</td>
		<td>유병자인ㄷ지 아닌지</td>
		<td>보험이름</td>
		<td>보험료</td>
		<td>특약 갯수</td>
	</tr>

<c:forEach items="${bohumTestInfoArr }" varStatus="status" var="test">
	<tr>
		<td>${test.cmpyCd }</td>
		<td>${test.cmpyNm }</td>
		<td>${test.ptrn }</td>
		<td>
			<a href="bohumDataDetail.bh?cmpyNm=${test.cmpyNm }&ptrn=${test.ptrn }&prdNm=${test.prdNm }&age=${test.age }">
				${test.prdNm }
			</a>
		</td>
		<td>${test.priceSum }</td>
		<td>${test.mogCount }</td>
	</tr>
</c:forEach>
</table>


		<br> ${pageInfo.pagingHtml}
<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>


	String basDt;
	String cmpyCd;
	String cmpyNm;
	String ptrn;
	String mog; 	 
	String prdNm;
	String mlInsRt;
	String fmlInsRt; 
	String priceSum;	//여자/남자 보험료 더한거
	String mogCount;	//특약 갯수
