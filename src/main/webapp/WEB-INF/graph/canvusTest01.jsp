<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/top_bottom/main_top.jsp"%>

<%@ include file="/WEB-INF/company/top.jsp"%>

<script type="text/javascript">

/* 	alert(2);
	const canvas = $('#myCanvas');
	alert("canvas.id\n\n"+canvas.attr('id')); */
	
	function Click(hi11) {
		
		var hi = $('#hi');
		alert("hi\n\n"+hi.val());	
		
		var hi01 = $('input[name=hi]');
		alert("hi01\n\n"+hi01.val());	
		
		var hi02 = $("input[name='hi']");
		alert("hi02\n\n"+hi02.val());	
		
		
		var hi03 = document.getElementById("hi");
		alert("hi03\n\n"+hi03.value);	
		
		
		alert(hi11);
		
		alert("hi\n\n"+hi11.value);	
		alert("hi\n\n"+hi11.getAttribute('id'));	
	}
	
$(document).ready(convasSet);
	
	function convasSet() {
		
		const canvas = $('#myChart');
	    alert(10);
	    alert(canvas.attr('id'));
	    if(canvas.getContext){
		    var ctx = canvas.getContext('2d');
		    ctx.fillStyle = 'red';
		    alert(3);
		    ctx.fillRect(10, 10, 100, 100);
		    alert(4);
		}else{
			alert("canvas.getContext : "+canvas.getContext);
	    }
	    alert(2);
		
	}
	
</script>





<canvas id="myCanvas" width="150" height="150"></canvas>
<input id="hi" name="hi" value="하이!" onclick="Click(this)">
	<h1>여기가 그래프 시작</h1>
	<div>
		<canvas id="myChart" width="900" height="380"></canvas>
	</div>
	<h1>여기가 그래프 끝</h1>
<%@ include file="/WEB-INF/company/bottom.jsp"%>

<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>
