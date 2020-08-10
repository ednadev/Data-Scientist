<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrap {
		display: flex;
		justify-content: center;
	}
	#wrap img {
		margin: 5px;
	}
</style>
</head>
<body>
	<h2 align="center">Result of Executing Deep Learning Model</h2>
	<h3 align="center">Model Performance</h3>
	<div id="wrap">
		<img alt="" src="${loss_plot}" width="30%" height="30%" border="1">
		<img alt="" src="${acc_plot}" width="30%" height="30%" border="1">
	</div>
</body>
</html>