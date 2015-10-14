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
	$(function() {
		var $canvas = $('canvas').eq(0);
		ctx = $canvas[0].getContext("2d");

		ctx.beginPath();
		ctx.arc(x1, y1, 10, 0, Math.PI * 2, true);
		ctx.fill();

		var ws = new WebSocket("ws://192.168.8.28:8888/SpringWeb/wsinit");

		$('#canvas').click(
				function() {
					x2 = (Math.floor(Math.random() * 10) + 1);
					y2 = (Math.floor(Math.random() * 10) + 1);
					if (Math.floor(Math.random() * 10) >= 6)
						xplus = false;
					if (Math.floor(Math.random() * 10) >= 6)
						yplus = false;
					timer = setInterval(function() {
						ws.send("{'x':" + x2 + ",'y':" + y2 + ", 'xplus':"
								+ xplus + ",'yplus':" + yplus + "}");

					}, 50);
				});

		ws.onopen = function() {
			$('#chatStatus').text('Info: connection opened.');
		};
		ws.onmessage = function(event) {
			var ob = eval("(" + event.data + ")");
			x2 = ob.x;
			y2 = ob.y;
			xplus = ob.xplus;
			yplus = ob.yplus;
			Draw();
			timercheck+=1;
            if(timercheck>=5){
            	if(x2>=0.2)x2= x2-(x2/10);
            	
            	if(y2>=0.2)y2= y2-(y2/10);
            	 timercheck=0;
            }
		};
		ws.onclose = function(event) {
			$('#chatStatus').text('Info: connection closed.');
		};
	});
	function Draw() {

		ctx.clearRect(0, 0, 500, 500);

		ctx.beginPath();
		ctx.arc(x1, y1, 10, 0, Math.PI * 2, true);
		ctx.fill();

		if (xplus) {
			x1 += x2;
		} else {
			x1 -= x2;
		}

		if (yplus)
			y1 += y2;
		else {
			y1 -= y2;
		}

		if (x1 >= 490 && xplus) {
			xplus = false;
		}
		if (y1 >= 490 && yplus) {
			yplus = false;
		}
		if (x1 <= 10 && !xplus) {
			xplus = true;
		}
		if (y1 <= 10 && !yplus) {
			yplus = true;
		}
		if (y2 <= 0.2 && x2 <= 0.2) {
			clearInterval(timer);
		}
	}
</script>
</head>
<body>
	<p>
	<div id='chatStatus'></div>
	<canvas id="canvas" width="500px" height="500"></canvas>
	<p>
</body>
</html>