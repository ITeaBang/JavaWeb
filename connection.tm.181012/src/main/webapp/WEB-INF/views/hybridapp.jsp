<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>하이브리드 앱을 위한 페이지</title>
</head>
<body>
	<h3>네이티브 앱의 메소드 호출</h3>
	메시지<input type="text" id="input" /><br />
	<input type ="button" id="nativecall" value="네이티브 앱 메소드 호출" /><br /><br />

	<h3>네이티브 앱에서 받은 메시지</h3>
	메시지<div id = "nativemessage" style="height:200px; overflow:auto"></div> 
</body>
<script>
	document.getElementById("nativecall").addEventListener("click", function(){
		
		var message = document.getElementById("input").value;
		// 네이티브 앱의 메소드 호출
		MYAPP.showToastMessage(message);
		
	});
	function showDisplayMessage(message){
		document.getElementById("nativemessage").innerHTML += message + "<br />"
	}
</script>
</html>