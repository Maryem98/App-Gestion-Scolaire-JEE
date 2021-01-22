<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>   
 <%@include file="/menu/menuProf.html" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposer planning</title>
<meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
 
</head>
<body>
<div class="container">
<form action ="ServletUpl" method="post" enctype="multipart/form-data">
<div class="form-group">
			 <label for="comment">Commentaire</label>
			 <input type="text" class="form-control" id="comment" name="comment">
</div>
	
 <div class="custom-file mb-3">
      <input type="file" class="custom-file-input" id="customFile" name="photo">
      <label class="custom-file-label" for="customFile">Choose file</label>
 </div>
	<button class="btn btn-primary center-block" type="submit">Upload</button>	
</form>
</div>
<script>
// Add the following code if you want the name of the file appear on select
$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});
</script>
</body>
</html>