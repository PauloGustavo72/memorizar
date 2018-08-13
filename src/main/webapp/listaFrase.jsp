<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Frase</title>
</head>

<script src="../webjars/jquery/1.9.1/jquery.min.js"></script>
<link href="../webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<body>
	<h1>Fora do c:</h1>

	<c:forEach items="${frases}" var="f">
		<h1>Entrou</h1>
		<h2>${f.fraseIngles }</h2>
	</c:forEach>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 data-toggle="collapse" data-target="#1" >Panel heading without title</h3>
		</div>
		<div id="1" class="panel-body">Panel content</div>
	</div>

</body>
</html>