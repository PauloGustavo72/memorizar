<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastro de frases</title>
	
</head>
	<script src="../webjars/jquery/1.9.1/jquery.min.js"></script>	
	<link href="../webjars/bootstrap/3.3.6/css/bootstrap.min.css" 	rel="stylesheet" />
<body>
	
	<div>
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<form >
						<div class="form-group">
							<label for="fraseIngles">Frase Inglês: </label> <input
								type="text" class="form-control" id="fraseIngles"
								placeholder="Digite uma frase em inglês">
						</div>
						<div class="form-group">
							<label for="frasePortugues">Frase Português: </label> <input
								type="text" class="form-control" id="frasePortugues"
								placeholder="Digite a tradução da frase em inglês">
						</div>
						
						<button onclick="salvarFrases();" type="submit" class="btn btn-success">Salvar</button>
						<button type="button" class="btn btn-primary">Voltar</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

	<script type="text/javascript">
		function salvarFrases(){
			
			var json = {
					"fraseIngles" : $("#fraseIngles").val(),
					"frasePortugues" : $("#frasePortugues").val()
			}
			$.ajax({
				url: "/frase",
				  method: "POST",
				  data: JSON.stringify(json),
				  dataType: "json",
				  contentType: 'application/json; charset=utf-8',
				  mimeType: 'application/json; charset=utf-8',
				  async   : false,
				  success : function(data) {
					  alert (data);
				  },
				  error : function() {
					  alert ("Não cadastrou");
				  }

			});
		}
	</script>
</html>