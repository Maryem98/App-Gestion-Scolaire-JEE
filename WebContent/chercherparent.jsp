<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@include file="/menu/menuAdmin.html" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion eleves</title>
<link rel="stylesheet"  href="css/bootstrap.min.css" />
<style>
.jumbotron {
    background-color: #3366ff;
    color: #fff;
    padding: 30px 25px;
    font-family: Montserrat, sans-serif;
  }
</style>

</head>
<body>
<div class="jumbotron text-center">
  <p>                                                      </p><br>
  <h3>Ici vous pouvez ajouter , supprimer, modifier, ou  lister les parents</h3> 
 
</div>

 <div class="container ">
 
	<div class="panel panel-primary">
		<div class="panel-body">
			<div class="row">
			<div class="col-sm-9">
			<form action="chercherparent.dot" method="get">			
			<div class="input-group">
            <input type="text" class="form-control" placeholder="Veuillez taper ici le nom que vous cherchez...." name="motCle">
              <div class="input-group-btn">
             <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
             </div>
			</div>
			
			
			</form></div>
			<div class="col-sm-3">
			  <a href="/gestionEcole/saisieparent.dot" class="btn btn-info " role="button">Ajouter un nouveau parent</a>
			
			</div>
			</div>
		    <br><br><br>
			
			<table class="table table-condensed">
					    <thead>
					      <tr>
					   		<th>IDP</th>
					        <th>Nom</th>

					        <th>Prenom</th>
					        <th>Date de naissance</th>
					        <th>Action</th>
					        <th>Action</th>
					        
					      </tr>
					    </thead>
					    <tbody>
					    	<c:forEach items="${model.parents }"  var ="e"> <!-- //chercher dans request l'atribut model la liste employes et pour chaque employe e qui est dans la liste -->
					      <tr>
					        <td>${e.IDP}</td>
					        <td>${e.nom }</td>
					        <td>${e.prenom }</td>
					        <td>${e.dateNaissance }</td>
					        
					        <td><a onclick="return confirm('Etes vous sure de vouloir supprimer ce parent')" href="supprimerparent.dot?IDP=${e.IDP }">Supprimer</a></td>
					       <td><a href="modifierparent.dot?IDP=${e.IDP}">Modifier</a></td>
					        
					      </tr> 
					      </c:forEach>
					    </tbody>			    
		</table>
		
		</div>
	</div>
 </div> 
</body>
</html>