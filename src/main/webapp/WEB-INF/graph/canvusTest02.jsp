<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>

<%@ include file="/WEB-INF/company/top.jsp"%>

<script type="text/javascript">

/* 	alert(2);
	const canvas = $('#myCanvas');
	alert("canvas.id\n\n"+canvas.attr('id')); */
	
	function Click() {
		
		var c = document.getElementById("myCanvas");
		var ctx = c.getContext("2d");
		var grd = ctx.createLinearGradient(0, 0, 175, 50);
		grd.addColorStop(0, "#FF0000");
		grd.addColorStop(1, "#00FF00");
		ctx.fillStyle = grd;
		ctx.fillRect(0, 0, 175, 50);
	}
	
	
$(document).ready(convasSet);
	
	function convasSet() {
		
		var c = document.getElementById("myCanvas");
		var ctx = c.getContext("2d");
		var grd = ctx.createLinearGradient(0, 0, 175, 50);
		grd.addColorStop(0, "#FF0000");
		grd.addColorStop(1, "#00FF00");
		ctx.fillStyle = grd;
		ctx.fillRect(0, 0, 175, 50);
		
		
		var canvas = document.getElementById("myChart");
		var canvasCtx = canvas.getContext('2d');
		canvasCtx.fillStyle = 'red';
	    alert(3);
	    canvasCtx.fillRect(10, 10, 100, 100);
		
	}
	
</script>




<canvas id="myCanvas" width="150" height="150"></canvas>
<input id="hi" name="hi" value="하이!" onclick="Click(this)">
	<h1>여기가 그래프 시작</h1>
	<div>
		<canvas id="myChart" width="900" height="380"></canvas>
	</div>
	<h1>여기가 그래프 끝</h1>
	
	
	
<canvas id="myCanvas" style="display:none;" width="200" height="15" style="border:3px solid #c3c3c3;">
Your browser does not support the HTML5 canvas tag.
</canvas>
<br>

<canvas id="myChart" style="display:none;" width="200" height="15" style="border:3px solid #c3c3c3;">
</canvas>

<input type="button" value="show" onclick="return show();" />

<script type="text/javascript">
function show()
{
	alert('show');
 document.getElementById("myCanvas").style.display = "block";
 return false;
}
</script>
	
	
<%@ include file="/WEB-INF/company/bottom.jsp"%>

<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>
