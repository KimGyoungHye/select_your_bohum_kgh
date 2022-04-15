<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>
<script type="text/javascript">
	function downLoad(fileName) {
		alert("+"+fileName+"+");
		if(fileName==""){
			alert('첨부파일이 없습니다.');
			return;
		}
		alert(1);
		filePath = "<%=request.getContextPath() %>";
		alert(filePath);
		$.ajax({
			 url : "test01.qa",
			data : ({
				downloadFileName : fileName,
				downloadFilePath : filePath
			}),
			datatype:"json",
			success : function(data) {
				alert('downLoad!');
			}//success 
		});//ajax
		alert(4);
	}
</script>


<input type="button" onclick="downLoad('memo.txt')" value="ajax!!!">



<a href="bohumDetail.bh">그냥 테스트 용 없어도 됨</a>


<a href="bohumChoochun.bh">내 보험 추천 하러 가기</a>



<a href="bohumJujang.ha">보험 API 저장하러가기</a>
