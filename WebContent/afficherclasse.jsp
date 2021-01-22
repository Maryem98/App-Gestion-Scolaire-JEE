<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
    
        <%@include file="/menu/menuProf.html" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chercher la classe</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Veuillez choisir la classe consernée</h2>
       <form action="afficherclasse.ab" method="get">
       <div class="form-group">
				  <label for="sel1">Selectionner la classe:</label>
				  <select class="form-control" name="classe" id="sel1">
				    <option>1</option>
				    <option>2</option>
				    <option>3</option>
				    <option>4</option>
				  </select>
		</div>
	             <button class="btn btn-primary center-block" type="submit">Chercher </button>
	             
				</form>
				<br><br><br>
				<div class="container ">
 
            <div class="panel panel-primary">
				<form action='absence.ab' method="post">	
			<table class="table table-condensed">
					    <thead>
					      <tr>
					   		<th>CNE</th>
					        <th>Nom</th>
					        <th>Prenom</th>
					        <th>Absent</th>
					      </tr>
					    </thead>
					    <tbody>
					    <c:forEach items="${list}"  var ="e"> <!-- //chercher dans request l'atribut model la liste employes et pour chaque employe e qui est dans la liste -->
					      <tr>
					        <td><c:out value ="${e.CNE }"/></td>
					        <td><c:out value ="${e.nom }"/></td>
					        <td><c:out value ="${e.prenom }"/></td>
					        <td><div class="checkbox">
  							<input type="checkbox" name="cne" value="${e.CNE }">
							</div></td>
					      </tr> 
					      </c:forEach>
					    </tbody>			    
		</table>
		  <button class="btn center-block" type="submit">Enregistrer les absences </button>
		</form>
		</div>
		</div>
				
</div>
</body>
</html>