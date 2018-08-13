<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>

	<script src="../webjars/jquery/1.9.1/jquery.min.js"></script>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" 	rel="stylesheet" />
	<link href="/assets/css/login.css" 	rel="stylesheet" />
<body>

	<div class="login">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<form>
						<div class="form-group">
							<label for="login">Email address</label> <input
								type="email" class="form-control" id="login"
								aria-describedby="emailHelp" placeholder="Enter email"/>
						</div>
						<div class="form-group">
							<label for="senha">Password</label> <input
								type="password" class="form-control" id="senha"
								placeholder="Password">
						</div>
						<button onclick="logar();" type="submit" class="btn btn-primary">Login</button>
						<a href="cadastroUsuario.jsp">Cadastre-se</a>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

	<script type="text/javascript">
		function logar(){
			var json = {
					"id"	: "0",
					"login" : $("#login").val(),
					"senha" : $("#senha").val()
			}
			$.ajax({
				url: "/logar",
				  method: "POST",
				  data: JSON.stringify(json),
				  dataType: "json",
				  contentType: 'application/json; charset=utf-8',
				  mimeType: 'application/json; charset=utf-8',
				  async   : false,
				  success : function(data) {
					  parent.location.href=data;
				  },
				  error : function() {
					  alert ("Usuario ou senha invalidos");
				  }

			});
		}
	</script>
</html>