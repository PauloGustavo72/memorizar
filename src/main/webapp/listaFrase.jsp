<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Frase</title>
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

	<c:forEach items="${frases}" var="f">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title" data-toggle="collapse"
						data-target="#${f.id }" data-parent="#paineis-sobre">${f.fraseIngles}</h3>
				</div>
				<div id="${f.id }" class="collapse">
					<div class="panel-body">
						<div class="container">
							<div class="row">
								<div class="col-sm-4">
									<form>
										<div class="form-group">
											<label for="fraseIngles">Frase em Inglês</label> <input type="text"
												class="form-control" id="fraseIngles${f.id }" value="${f.fraseIngles }" />
											
											<label for="frasePortugues">Frase em Português</label> <input type="text"
												class="form-control" id="frasePortugues${f.id }" value="${f.frasePortugues }" >
										</div>
										<button onclick="editarFrase(${f.id});" type="submit"
											class="btn btn-primary">Editar</button>
										<button onclick="excluirFrase(${f.id});" type="submit"
											class="btn btn-primary">Excluir</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>



	</body>
	<script type="text/javascript">
	function editarFrase(id){
		
		var json = {
				"id"		  : id,	
				"fraseIngles" : $("#fraseIngles" + id).val(),
				"frasePortugues" : $("#frasePortugues" + id).val()
		}
		$.ajax({
			url: "/frase/editarFrase",
			  method: "PUT",
			  data: JSON.stringify(json),
			  dataType: "json",
			  contentType: 'application/json; charset=utf-8',
			  mimeType: 'application/json; charset=utf-8',
			  async   : false,
			  success : function(data) {
				  alert (data);
			  },
			  error : function() {
				  alert ("Não editou");
			  }

		});
	}
	
	function excluirFrase(id){
		
		$.ajax({
			url: "/frase/excluirFrase/" + id,
			  method: "DELETE",
			  dataType: "json",
			  contentType: 'application/json; charset=utf-8',
			  mimeType: 'application/json; charset=utf-8',
			  async   : false,
			  success : function(data) {
				  alert (data);
			  },
			  error : function() {
				  alert ("Não editou");
			  }

		});
	}
	</script>
</html>