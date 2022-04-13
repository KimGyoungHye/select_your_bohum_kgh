<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>

<%@ include file="/WEB-INF/company/top.jsp"%>

<script type="text/javascript">

$(document).ready(convasSet);
		
		
		
	function convasSet() {
		
		var list = ["ㄱ","ㄴ","ㄷ","ㄹ","ㅁ","ㅂ","ㅅ"];
		alert("list.length: "+ list.length);
		var canvas = document.getElementById("myChart");
		var canvasCtx = canvas.getContext('2d');
		drawRect(canvas,canvasCtx);
		drawRect01(canvas,canvasCtx,list);
		
	    //canvasCtx.fillRect(0, 0, 50, 50);

	}
	
	
	function drawRect(canvas,canvasCtx){
		canvasCtx.fillStyle = 'red';
		for(var i=0;i<9;i++){
			
		    canvasCtx.fillRect(i*60, 0, 50, 50*(i+1));
		}
	}
	
	function drawRect01(canvas,canvasCtx,list){
		canvasCtx.fillStyle = 'blue';
		for(var i=0;i<list.length;i++){
			
		    canvasCtx.fillRect(i*60, 0, 50, 50*(i+1));
		}
	}
</script>


<input id="hi" name="hi" value="하이!" onclick="Click(this)">
	<h1>여기가 그래프 시작</h1>
	<div>
		<canvas id="myChart" width="900" height="380"></canvas>
	</div>
	<h1>여기가 그래프 끝</h1>
	
	
	
<%@ include file="/WEB-INF/company/bottom.jsp"%>

<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>
