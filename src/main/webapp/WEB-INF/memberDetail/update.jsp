<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp" %>
<%@include file="/WEB-INF/common/common_memberDetail_value.jsp" %>
<script type="text/javascript">
 	$(function(){ // 혹시 j쿼리 없으 실 수 있음 
		alert(2);
		$("#diseaseElse").toggle();
		$("#family_historyElse").toggle();
		alert(3);

		$("input[name='disease2']").click(function() { 
			alert(3);
		    $("#diseaseElse").toggle();
		});
		
		$("input[name='family_history2']").click(function() { 
			alert(3);
		    $("#family_historyElse").toggle();
		});
	}); 

</script>
<c:if test="${memberDetailBean==null and loginInfo.regi_number1!=0}">
	<c:set var="infoAge" value="${100+todayYear-(loginInfo.regi_number1/10000) }"/>
</c:if>
infoAge : ${infoAge }
	<div class="row">
		<div class=" col-md-offset-1 col-md-7 checkContainer"><h1>Insert</h1></div>
		<div class="col-md-3 checkContainer">.col-md-3</div>
	</div>
	<div class="row">
		<div class="col-md-offset-1 col-md-10 checkContainer">
		<form:form role="form" method="post" commandName="memberDetailBean"
			action="update.md" class="form-horizontal">
			
			<input name="num" value="${loginInfo.userDetail }">
			<div class="form-group">
				<label for="age " class="col-md-3 control-label"> 나이 : </label>
				<div class="col-md-6">
					<input name="age" value="${memberDetailBean.age }" 
					class="form-control" placeholder="만 나이입력">
				</div>
				<div class="col-md-2">
					<form:errors path="age" cssClass="error"/>	
				</div>
			</div>
			<div class="form-group">
				<label for="gender" class="col-md-3 control-label">
					성별 : </label>
				<div class="col-md-6">
					<c:forEach var="gender" items="${genderArr }" varStatus="status" >
						<label class="radio-inline"> 
						<input type="radio" name="gender" value="${gender}" 
						<c:if test="${gender==memberDetailBean.gender}">
							checked
						</c:if>>
						${gender }&nbsp&nbsp</label>
					</c:forEach>
					gender : ${memberDetailBean.gender}
				</div>
				<div class="col-md-2">
					<form:errors path="gender" cssClass="error"/>	
				</div>
			</div>
			<div class="form-group">
				<label for="job" class="col-md-3 control-label">
					직업 : </label>
				<div class="col-md-6">
					<select name="job" class="form-control" >
						<c:forEach var="job" items="${jobArr }" varStatus="status" >
							<option value="${job }"
								<c:if test="${job==memberDetailBean.job }">
								selected
								</c:if>
							>${job }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-2">
					<form:errors path="job" cssClass="error"/>	
				</div>
			</div>
			<div class="form-group">
				<label for="salary" class="col-md-3 control-label">
				 연봉 : 
				</label>
				<div class="col-md-6">
					<input name="salary" value="${memberDetailBean.salary }" 
						class="form-control" placeholder="연봉 입력">
				</div>
				<div class="col-md-2">
					<form:errors path="salary" cssClass="error"/>	
				</div>
			</div>
			<div class="form-group">
				<label for="marriage" class="col-md-3 control-label">
					결혼 유무 : </label>
				<div class="col-md-6">
					<c:forEach var="marriage" items="${marriageArr }" varStatus="status" >
						<label class="radio-inline"> 
						<input type="radio" name="marriage" value="${marriage}" 
						<c:if test="${marriage==memberDetailBean.marriage}">
							checked
						</c:if>>
						${marriage }&nbsp&nbsp</label>
					</c:forEach>
				</div>
				<div class="col-md-2">
					<form:errors path="marriage" cssClass="error"/>	
				</div>
			</div>
			<div class="form-group">
				<label for="height" class="col-md-3 control-label">
				 키 : 
				</label>
				<div class="col-md-6">
					<input name="height" value="${memberDetailBean.height }" 
						class="form-control" placeholder="키">
				</div>
				<div class="col-md-2">
					<form:errors path="height" cssClass="error"/>	
				</div>
			</div>
			<div class="form-group">
				<label for="weight" class="col-md-3 control-label">
				 몸무게 : 
				</label>
				<div class="col-md-6">
					<input name="weight" value="${memberDetailBean.weight }" 
						class="form-control" placeholder="몸무게 입력">
				</div>
				<div class="col-md-2">
					<form:errors path="weight" cssClass="error"/>	
				</div>
			</div>
			<div class="form-group">
				<label for="disease" class="col-md-3 control-label">
					질병여부 : </label>
				<div class="col-md-6">
					<c:forEach var="disease" items="${diseaseArr }" varStatus="status" >
						<label class="checkbox-inline"> 
						<input type="checkbox" name="disease" value="${disease}" 
						<c:if test="${fn:contains(memberDetailBean.disease,disease) }">
							checked
						</c:if>>
						${disease }&nbsp&nbsp</label>
					</c:forEach>
					<br>
					<input type="checkbox" name="disease2" onClick="checkDisable(this.form)">
						기타 &nbsp
					<div class="checkbox-inline" id="diseaseElse" >
						 * 기타를 선택하신 분들은 병명을 적어주세요 &nbsp
						<input type="text" name="disease">
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="disease" cssClass="error"/>	
				</div>
			</div>
			<div class="form-group">
				<label for="family_history" class="col-md-3 control-label">
					가족력 : </label>
				<div class="col-md-6">
					<c:forEach var="family_history" items="${family_historyArr }" varStatus="status" >
						<label class="checkbox-inline"> 
						<input type="checkbox" name="family_history" value="${family_history}" 
						<c:if test="${fn:contains(memberDetailBean.family_history,family_history) }">
							checked
						</c:if>>
						${family_history }&nbsp&nbsp</label>
					</c:forEach>
					<br>
					<input type="checkbox" name="family_history2" >
					기타 &nbsp
					<div class="checkbox-inline" id="family_historyElse" >
						 * 기타를 선택하신 분들은 가족력을 적어주세요 &nbsp
						<input type="text" name="family_history">
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="family_history" cssClass="error"/>	
				</div>
			</div>
			<div class="form-group">
				<div class=" col-md-offset-3 col-md-6 ">
					<button type="submit" class="form-control btn btn-primary">내 정보 추가</button>
				</div>
			</div>
		</form:form>
		</div>
	</div>	

<%@include file="/WEB-INF/top_bottom/main_bottom.jsp" %>