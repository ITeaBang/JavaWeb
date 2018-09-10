<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피보나치 수열</title>
</head>
<body>
<%
	// 20번째 피보나치 수열의 값 구하기 (1,1,2,3,5,8,13,21,34,55,......) , 1번째와 2번째는 값이 1, 3번째부터는 앞의 2개의 
	int a=1;
	int b=1;
	int fibo=1;
	int idx=3;
	
	while(idx <= 20){
		
		fibo = a + b;
		a = b;
		b = fibo;
		idx = idx+1;
		
	}

%>
20번째 피보나치 수열의 값은 <%= fibo %>입니다.
</body>
</html>