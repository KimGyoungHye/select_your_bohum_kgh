<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common_top.jsp"%>
<div class="modal fade" id="myModal${member.id}" tabindex="-1" role="dialog" 
						aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog"><!-- class="modal-dialog"에 modal-lg추가하면 큰모달,  modal-sm추가하면 작은모달, 아무것도 안쓰면 중간크기의 모달이 만들어진다. -->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel"> 회원 아이디 [ ${member.id} ]</h4>
      </div>
      <form method="post" action="userStateUpdate.ha">
      
      <div class="modal-body">
      <p>여기에 뭘 써야 할까?</p>
      	유저 타입 : 
      	<input type="text" name="id" value="${member.id}">
      	<select name="userState">
      		<c:forEach var="userState" items="${userStateArr }" varStatus="status">
      			<option
      			<c:if test="${member.userState==userState }">
      				selected
      			</c:if>
      			>${userState }</option>
      		</c:forEach>	
      	</select>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        <button type="submit" class="btn btn-primary">변경 사항 저장</button>
      </div>
      </form>
      
    </div> <!-- 모달 콘텐츠 -->
  </div> <!-- 모달 다이얼로그 -->
</div> <!-- 모달 전체 윈도우 -->	