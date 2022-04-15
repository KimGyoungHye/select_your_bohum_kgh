<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>

<script type="text/javascript">
	
	function removeBarGraph() {
		$('#barDiv').html("<canvas id='bar-chart' width='900' height='380'></canvas>");
	}
	
	function drawBarGraph01() {
		removeBarGraph();
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
	
	function drawBarGraph(myLabels,myLabel,myData,myText) {
		removeBarGraph();
		new Chart(document.getElementById("bar-chart"), {
		    type: 'bar',
		    data: {
		      labels: myLabels,
		      datasets: [
		        {
		          label: myLabel,
		          backgroundColor: "#EEEEEE",
		          data: myData
		        }
		      ]
		    },
		    options: {
		      legend: { display: false },
		      title: {
		        display: true,
		        text: myText
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

	
</script>

