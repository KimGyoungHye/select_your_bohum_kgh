<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>

<%@ include file="/WEB-INF/company/top.jsp"%>

<%@include file="/WEB-INF/common/common_graph.jsp"%>

<script>
	function getAgeData() {
		alert(1);
		$.ajax({
			url : "test.gp",
		    dataType : "json", //서버에서 html타입을 반환받는다.
		    contentType: "application/json; charset=utf-8",
		    success : function(data) {
		    	$.each(data, function(index, item) { // 데이터 =item
					alert('in');
					alert(item.myLabels);
					alert(item.myLabel);
					alert(item.myData);
					alert(item.myText);
					
					myLabels = item.myLabels;
					myLabel = item.myLabel;
					myData = item.myData;
					myText = item.myText;
					alert('last');

drawBarGraph(myLabels, myLabel, myData,myText);
				});
				alert('out');
				
		    },//success
			error : function(data) {
				alert('error! : ' + data.value);
			}//success
		});
/* 		$.ajax({
			url : "test.gp",
			dataType : 'json',
            contentType: 'application/json; charset=utf-8',
			success : function(data) {
				alert("success : " + data);
				$.each(data, function(index, item) { // 데이터 =item
					alert('in');
					drawBarGraph(item.myLabels, item.myLabel, item.myData,
							item.myText);
				});
				alert('out');
			},//success
			error : function(data) {
				alert('error! : ' + data.value);
			}//success
		});//ajax */
		alert(4);
	}
</script>

<h1>바 그래프</h1>
<div id="barDiv">
	<canvas id="bar-chart" width="900" height="380"></canvas>
</div>

<input type="button" value="그리기01" onclick="drawBarGraph01()">
<br>
<input type="button" value="그리기" onclick="getAgeData()">
<br>

<%@ include file="/WEB-INF/company/bottom.jsp"%>

<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>
