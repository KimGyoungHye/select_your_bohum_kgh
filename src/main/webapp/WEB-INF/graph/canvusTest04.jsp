<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
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
		drawRect01(canvas,canvasCtx,'${graphDataAgeNBohum}');
		
	    //canvasCtx.fillRect(0, 0, 50, 50);

	    
		new Chart(document.getElementById("bar-chart"), {
		    type: 'bar',
		    data: {
		      labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
		      datasets: [
		        {
		          label: "Population (millions)",
		          backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
		          data: [2478,5267,734,784,433]
		        }
		      ]
		    },
		    options: {
		      legend: { display: false },
		      title: {
		        display: true,
		        text: 'Predicted world population (millions) in 2050'
		      }
		    }
		});
		
	}
	
	function resetCanvas() {
		$('#cartDiv').html("<canvas id='bar-chart' width='900' height='380'></canvas>");
	}
	
	function canvasRenew() {
		
		new Chart(document.getElementById("bar-chart"), {
		    type: 'bar',
		    data: {
		      labels: ["가", "나", "다", "라", "마","바","사"],
		      datasets: [
		        {
		          label: "보험갯수",
		          backgroundColor: ["#00ff00", "#ff0000","0000ff","#ff00ff","#00ffff","ffff00","00000"],
		          data: [4,5,8,4,6,4]
		        }
		      ]
		    },
		    options: {
		      legend: { display: false },
		      title: {
		        display: true,
		        text: '나이 별 보험 갯수' 
		      },
		      scales: {
					yAxes: [{
						ticks: {
							beginAtZero: true
						}
					}]
				},
		    }
		});
		
	}
	
	
	
	function drawRect(canvas,canvasCtx){
		canvasCtx.fillStyle = 'red';
		for(var i=0;i<9;i++){
			
		    canvasCtx.fillRect(i*60, 380-50*(i+1), 50, 50*(i+1));
		}
	}
	
	function drawRect01(canvas,canvasCtx,list){
		canvasCtx.fillStyle = 'blue';
		alert("list"+list);
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
	
	<div id="cartDiv">
		<canvas id="bar-chart" width="900" height="380"></canvas>
	</div>
	
<input type="button" value="그리기" onclick="canvasRenew()"><br>
<input type="button" value="리셋" onclick="resetCanvas()">
	
<%@ include file="/WEB-INF/company/bottom.jsp"%>

<%@include file="/WEB-INF/top_bottom/main_bottom.jsp"%>
