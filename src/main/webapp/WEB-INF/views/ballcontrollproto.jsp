<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Websocket Client</title>
<style type="text/css">
canvas {
	border: solid 1px black;
}
</style>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-2.1.4.min.js"/>"></script>
<script type="text/javascript">
	var ctx = null;
	var x1 = y1 = 250;
	var x2 = y2 = 0;
	var timer;
	var xplus = true;
	var yplus = true;
	var timercheck = 0;
	var ballclick = false;
	var drawline;
	var x3 = 250;
	var y3 = 350;
	
	var x4 = 0;
	var y4 = 0;
	
	$(function() {
		var $canvas = $('canvas').eq(0);
		ctx = $canvas[0].getContext("2d");

		ctx.beginPath();
		ctx.arc(x1, y1, 20, 0, Math.PI * 2, true);
		ctx.fill();

		ctx.beginPath();
		ctx.fillStyle = "red";
		ctx.arc(x3, y3, 20, 0, Math.PI * 2, true);
		ctx.fill();

		var ws = new WebSocket("ws://192.168.8.28:8888/SpringWeb/wsinit");
		// var ws = new WebSocket("ws://192.168.8.28:8888/SpringWeb/simpleChat?id=${id}");
		$('#canvas').mousemove(
				function(evt) {
					if (ballclick) {
						ctx.clearRect(0, 0, 500, 500);
						ctx.fillStyle = "black";
						ctx.beginPath();
						ctx.arc(x1, y1, 20, 0, Math.PI * 2, true);
						ctx.fill();

						ctx.beginPath();
						ctx.fillStyle = "red";
						ctx.arc(x3, y3, 20, 0, Math.PI * 2, true);
						ctx.fill();

						ctx.lineWidth = 3;
						ctx.fillStyle = "black";
						ctx.beginPath();
						ctx.moveTo(x1, y1);
						ctx.lineTo(evt.pageX - this.offsetLeft, evt.pageY
								- this.offsetTop);
						ctx.stroke();
						ctx.closePath;
					}

				});

		$('#canvas')
				.click(
						function(evt) {
							if (!ballclick) {

								if ((x1 - 20) <= (evt.pageX - this.offsetLeft) <= (x1 + 20)
										&& (y1 - 20) <= (evt.pageY - this.offsetTop) <= (y1 + 20)) {
									ballclick = true;

								}
							}

							else if (ballclick) {

								ballclick = false;
								
								if (evt.pageX - this.offsetLeft >= x1) {
									x2 = ((evt.pageX - this.offsetLeft) - x1) / 20;
									xplus = false;
								} else if (evt.pageX - this.offsetLeft < x1) {
									x2 = (x1 - (evt.pageX - this.offsetLeft)) / 20;
									xplus = true;
								}

								if (evt.pageY - this.offsetTop >= y1) {
									y2 = ((evt.pageY - this.offsetTop) - y1) / 20;
									yplus = false;
								} else if (evt.pageY - this.offsetTop < y1) {
									y2 = (y1 - (evt.pageY - this.offsetTop)) / 20;
									yplus = true;
								}

								timer = setInterval(function() {
									timercheck += 1;

									if (timercheck >= 5) {
										if (x2 >= 0.1)
											x2 = x2 *0.98;

										if (y2 >= 0.1)
											y2 = y2 *0.98;
										timercheck = 0;
									}
									

									
									
									
									
									
									if (xplus) {
										x1 += x2;
									} else if (!xplus) {
										x1 -= x2;
									}

									if (yplus)
										y1 += y2;
									else if (!yplus) {
										y1 -= y2;
									}

									if (x1 >= 480 && xplus) {
										x1=480;
										xplus = false;
									}
									if (y1 >= 480 && yplus) {
										y1=480;
										yplus = false;
									}
									if (x1 <= 20 && !xplus) {
										x1=20;
										xplus = true;
									}
									if (y1 <= 20 && !yplus) {
										y1=20;
										yplus = true;
									}
									if (y2 <= 0.15 && x2 <= 0.15) {
										clearInterval(timer);

									}
									ws.send("{'x':" + x1 + ",'y':" + y1 + "}");
									
									

								}, 10);
							}
						});

		ws.onopen = function() {
			$('#chatStatus').text('Info: connection opened.');
		};
		ws.onmessage = function(event) {
			var ob = eval("(" + event.data + ")");
			x1 = ob.x;
			y1 = ob.y;
			
			if (x1 < x3) {
				x4 = x3 - x1;
			} else if (x1 > x3) {
				x4 = x1 - x3;
			}
			
			if (y1 < y3) {
				y4 = y3 - y1;
			} else if (y1 > y3) {
				y4 = y1 - y3;
			}
			
			if((x4*x4)+(y4*y4)<=(40*40)){
				clearInterval(timer);
			}
			Draw();

		};
		ws.onclose = function(event) {
			$('#chatStatus').text('Info: connection closed.');
		};
	});
	function Draw() {

		ctx.clearRect(0, 0, 500, 500);
		ctx.fillStyle = "black";
		ctx.beginPath();
		ctx.arc(x1, y1, 20, 0, Math.PI * 2, true);
		ctx.fill();

		ctx.beginPath();
		ctx.fillStyle = "red";
		ctx.arc(x3, y3, 20, 0, Math.PI * 2, true);
		ctx.fill();
		
		

	}
</script>
</head>
<body>
	<p>
		<canvas id="canvas" width="500px" height="500"></canvas>
	<div id='chatStatus'></div>
	<p>
</body>
</html>