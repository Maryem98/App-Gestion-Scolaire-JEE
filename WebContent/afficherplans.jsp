<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
    
        <%@include file="/menu/menuEleve.html" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>valider planning</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head>

<body>
<div class="container">
  <h2>Voici les plannings validés</h2>
       
				<br><br><br>
				<div class="container ">
 
            <div class="panel panel-primary">
				
			<table class="table table-condensed">
					    <thead>
					      <tr>
					   		<th>Id planning</th>
					        <th>Description</th>
					        <th>Planning</th>
					        
					      </tr>
					    </thead>
					    <tbody>
					    <c:forEach items="${plans}"  var ="e"> <!-- //chercher dans request l'atribut model la liste employes et pour chaque employe e qui est dans la liste -->
					      <tr>
					       <td><c:out value ="${e.id }"/></td>
					       <td><c:out value ="${e.comment}"/></td>
					       <td><a href="getplan.plan?id=${e.id }">Voir le planning </a></td>
					      </tr> 
					      </c:forEach>
					    </tbody>			    
		</table>
		  
		</div>
		</div>			
</div>
 
</body>
</html>