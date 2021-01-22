<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
    
        <%@include file="/menu/menuParent.html" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulter les absences</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Taper le CNE de votre fils pour voir ses absences</h2>
       <form action="chercherabsParent.ab" method="get">
       
			 <div class="form-group">
				  <label for="usr">CNE:</label>
				  <input type="text" class="form-control" id="usr" name="CNE">
			</div>
	             <button class="btn btn-primary center-block" type="submit"> Chercher </button>
	             
				</form>
				<br><br><br>
				<div class="container ">
 
            <div class="panel panel-primary">
				
			<table class="table table-condensed">
					    <thead>
					      <tr>
					   		<th>CNE</th>
					        <th>Date Absence </th>
					        <th>Absent</th>
					      </tr>
					    </thead>
					    <tbody>
					    <c:forEach items="${list}"  var ="e"> <!-- //chercher dans request l'atribut model la liste employes et pour chaque employe e qui est dans la liste -->
					      <tr>
					        <td><c:out value ="${e.CNE }"/></td>
					        <td><c:out value ="${e.date}"/></td>
					        <td><c:out value ="${e.absent}"/></td>
					      </tr> 
					      </c:forEach>
					    </tbody>			    
		</table>
		  
		</div>
		</div>
				
</div>
</body>
</html>