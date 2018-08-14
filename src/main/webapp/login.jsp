<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>

	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<body>

	<div class="login">
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<form>
						<div class="form-group">
							<label for="login">Email address</label> <input
								type="text" class="form-control" id="login"
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
// 				  success : function(data) {
// 					  parent.location.href = data;
// 				  },
// 				  error : function() {
// 					  alert ("Usuario ou senha invalidos");
// 				  }

			});
		}
	</script>
</html>