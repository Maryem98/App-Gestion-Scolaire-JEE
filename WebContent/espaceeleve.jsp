<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/menu/menuEleve.jsp" %> 
     <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Espace élève</title>
</head>
<body>
 <h2>welcome ${CNE} </h2>
</body>
</html> --%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>

<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Espace Eleve</title>
		<meta name="description" content="Blueprint: Horizontal Slide Out Menu" />
		<meta name="keywords" content="horizontal, slide out, menu, navigation, responsive, javascript, images, grid" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico">
		<link rel="stylesheet" type="text/css" href="menu/css/default.css" />
		<link rel="stylesheet" type="text/css" href="menu/css/component.css" />
		<script src="menu/js/modernizr.custom.js"></script>
	</head>
	<body>
		<div class="container">
			<header class="clearfix">
				<span>Bienvenue <br/> dans l'espace d'eleve<span class="bp-icon bp-icon-about" data-content="The Blueprints are a collection of basic and minimal website concepts, components, plugins and layouts with minimal style for easy adaption and usage, or simply for inspiration."></span></span>
				
				<nav>
					<a href="index.html" class="bp-icon bp-icon-prev" data-info="Deconnexion"><span>Deconnexion</span></a>
					
				</nav>
			</header>	
			<div class="main">
				<nav class="cbp-hsmenu-wrapper" id="cbp-hsmenu-wrapper">
					<div class="cbp-hsinner">
						<ul class="cbp-hsmenu">
						
							<li>
								<a href="chercherabsEleve.ab?CNE=${CNE}">Consulter mes absences</a>		
							</li>
							<li>
								<a href="deposerplan.jsp">Consulter les plannings</a>	
							</li>
							
							
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<script src="menu/js/cbpHorizontalSlideOutMenu.min.js"></script>
		<script>
			var menu = new cbpHorizontalSlideOutMenu( document.getElementById( 'cbp-hsmenu-wrapper' ) );
		</script>
		
		<h1>Bienvenue ${nom} </h1>
	</body>
</html>
