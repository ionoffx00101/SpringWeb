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

	var qtum = 0;
	$(function() {
		var $canvas = $('canvas').eq(0);
		ctx = $canvas[0].getContext("2d");

		ctx.beginPath();
		ctx.arc(x1, y1, 20, 0, Math.PI * 2, true);
		ctx.fill();

		var ws = new WebSocket("ws://192.168.8.28:8888/SpringWeb/wsinit");
		$('#canvas').mousemove(
				function(evt) {
					if (ballclick) {
						var x3 = evt.pageX - this.offsetLeft;
						var y3 = evt.pageY - this.offsetTop;
						qtum += 1;
						
						
						ctx.clearRect(0, 0, 500, 500);
						ctx.beginPath();
						ctx.arc(x1, y1, 20, 0, Math.PI * 2, true);
						ctx.fill();
						ctx.lineWidth = 3;
						ctx.beginPath();
						ctx.moveTo(x1, y1);
						ctx.lineTo(x3, y3);
						ctx.stroke();
						ctx.closePath;
						
						if (qtum >= 10) {
							ws.send("{'x':" + x1 + ",'y':" + y1 + ",x3:" + x3
									+ ",'y3':" + y3 + ",q:" + true + "}");
							qtum = 0;
						}

					}

				});

		$('#canvas').click(
				function(evt) {

					if (!ballclick) {

						if ((x1 - 20) <= (evt.pageX - this.offsetLeft)
								&& (evt.pageX - this.offsetLeft) <= (x1 + 20)
								&& (y1 - 20) <= (evt.pageY - this.offsetTop)
								&& (evt.pageX - this.offsetLeft) <= (y1 + 20)) {
							ballclick = true;

						}
					}

					else if (ballclick) {

						ballclick = false;
						if (evt.pageX - this.offsetLeft >= x1) {
							x2 = ((evt.pageX - this.offsetLeft) - x1) / 10;
							xplus = false;
						} else if (evt.pageX - this.offsetLeft < x1) {
							x2 = (x1 - (evt.pageX - this.offsetLeft)) / 10;
							xplus = true;
						}

						if (evt.pageY - this.offsetTop >= y1) {
							y2 = ((evt.pageY - this.offsetTop) - y1) / 10;
							yplus = false;
						} else if (evt.pageY - this.offsetTop < y1) {
							y2 = (y1 - (evt.pageY - this.offsetTop)) / 10;
							yplus = true;
						}

						timer = setInterval(function() {
							timercheck += 1;

							if (timercheck >= 5) {
								if (x2 >= 0.2)
									x2 = x2 - (x2 / 10);

								if (y2 >= 0.2)
									y2 = y2 - (y2 / 10);
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
								xplus = false;
							}
							if (y1 >= 480 && yplus) {
								yplus = false;
							}
							if (x1 <= 20 && !xplus) {
								xplus = true;
							}
							if (y1 <= 20 && !yplus) {
								yplus = true;
							}
							if (y2 <= 0.2 && x2 <= 0.2) {
								clearInterval(timer);

							}
							
							ws.send("{'x':" + x1 + ",'y':" + y1 + ",q:" + false
									+ "}");

						}, 50);
					}
				});

		ws.onopen = function() {
			$('#chatStatus').text('Info: connection opened.');
		};
		ws.onmessage = function(event) {
			var ob = eval("(" + event.data + ")");

			x1 = ob.x;
			y1 = ob.y;
			Draw();
			if(ob.q){
				lineDraw(ob.x3, ob.y3);
			}
			

		};
		ws.onclose = function(event) {
			$('#chatStatus').text('Info: connection closed.');
		};
	});
	function Draw() {

		ctx.clearRect(0, 0, 500, 500);
		ctx.beginPath();
		ctx.arc(x1, y1, 20, 0, Math.PI * 2, true);
		ctx.fill();

	}
	function lineDraw(x, y) {

		ctx.lineWidth = 3;
		ctx.beginPath();
		ctx.moveTo(x1, y1);
		ctx.lineTo(x, y);
		ctx.stroke();
		ctx.closePath;
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