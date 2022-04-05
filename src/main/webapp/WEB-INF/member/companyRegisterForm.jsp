<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common_top.jsp" %>

companyRegisterForm.jsp<br>
  
<style type="text/css">
	.err{
	font-size: 9pt;
	color: red;
	font-weight: bold;
	}
</style> 

<h2>보험사 회원 가입 화면</h2>

	사업자 정보 입력
	<hr>

여기 첫번째 폼에서 사업자 등록 번호를 넘기기
>>넘긴 사업자 등록 번호로 사업자를 찾아서 사업자 정보(MyCompany(company.model 아래의 CompanyBean))전체 가져오기
>>MyCompany를 세션으로 등록해서 공용으로 쓸 수 있게 하기
>>MyCompany.cname가져와서 회사명에 넣어주기
>>이러면 테이블에 사업자 등록번호 추가 안해도 되고,
>>

<form method="post" action="search_corp_num.mem">
	<div>
		<p>
			<label for="corp_number1">사업자등록번호</label>
			<input type="text" name="corp_num" id="corp_num" value="" size="10">
			<input type="submit" value="조회">
		</p>	
	</div>
</form>	

	
<form:form commandName="member" method="post" action="companyRegister.mem"> 
	<input type="hidden" name="userState" id="userState" value="보험자">

	
	<div>	
		<p>
			<label for="name">회사명</label>
			<input type="text" name="company" id="company" value="조회하면 회사명 자동으로 뜨게?하는거 값을
												 세션으로 넣어야지 페이지 에러나도 그대로 나올 것 같아요..!
												 대신 회원 가입 후에는 지정해서 지워주는 걸로..!">
		</p>
	</div>	
	<hr>
		<p>
			<label for="name">담당자 이름</label>
			<input type="text" name="name" id="name" value="김보험" size="15">
			<form:errors cssClass="err" path="name" />
		</p>	
		
		<p>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" value="lee">
			<form:errors cssClass="err" path="id" />
		</p>
		<p>
			<label for="password">비밀번호</label>
			<input type="text" name="password" id="password" value="1234">
			<form:errors cssClass="err" path="password" />
		</p>
		<p>
			<label for="regi_number1">주민번호</label>
			<input type="text" name="regi_number1" id="regi_number1" value="111111">
			- <input type="text" name="regi_number2" id="regi_number2" value="111111">
			<form:errors cssClass="err" path="regi_number1" />
			<form:errors cssClass="err" path="regi_number2" />
		</p>
		
		<p>
			<label for="phone1">연락처</label>
			<input type="text" name="phone1" id="phone1" value="010" size="3">
			- <input type="text" name="phone2" id="phone2" value="" size="4">
			- <input type="text" name="phone3" id="phone3" value="" size="4">
			<form:errors cssClass="err" path="phone1" />
		</p>	
		<p>
			<label for="email1">이메일</label>
			<input type="text" name="email1" id="email1" size="10" value="bohum">@<input type="text" name="email2" id="email2" value="insurance.com">
				<form:errors cssClass="err" path="email1" />
		</p>	
		
		<p>
			<input type="submit" value="가입하기" >		
		</p>
	</form:form>