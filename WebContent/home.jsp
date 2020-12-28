<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
	<title>HomeUser</title>
</head>
<body>

	<nav class="navbar barra">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="home.jsp"><img src="img/home.png"></a>
	    	</div>
	    	
	    	
	    	<ul class="nav navbar-nav navbar-right dot ">
				<li class="dropdown">
	        		<a class="dropdown-toggle" data-toggle="dropdown"><img src="img/user.png"></a>
	        			<ul class="dropdown-menu menu1" role="menu" aria-labelledby="dropdownMenu">
							<li><a tabindex="-1" href="#">Action</a></li>
							<li><a tabindex="-1" href="#">Another action</a></li>
							<li><a tabindex="-1" href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a tabindex="-1" href="#">Separated link</a></li>
						</ul>
	      		</li>
	    	</ul>
	    	
	   		<ul class="nav navbar-nav navbar-right dot">
				<li class="dropdown">
				<!-- <span class="caret"></span> -->
	        		<a class="dropdown-toggle" data-toggle="dropdown"><img src="img/notifica.png"><span class="badge">3</span></a>
	        		<ul class="dropdown-menu">
	         	 		<li><a href="#">Page 1-1</a></li>
	          			<li><a href="#">Page 1-2</a></li>
	          			<li><a href="#">Page 1-3</a></li>
	        		</ul>
	      		</li>
	    	</ul>
	    	
	    	
	  </div>
	</nav>
	<div class="container-fluid">
	<!--class="navbar navbar-dark bg-dark barra"--> 
		<!--<nav class="navbar-default navbar-fixed-top" style="background-color: black">
 			<a class="navbar-brand" style="color: yellow" href="home.jsp"><img src="img/home.png" class="img-responsive" style="fill: yellow ;margin-top: -23%;"></a>
			<p class="text-center" style="color: yellow; font-size: 209%">Il Decimo</p>
			<a class="navbar-brand" style="color: yellow" href="home.jsp"><img src="img/notifica.png" class="img-responsive" style="fill: yellow ;margin-top: -23%;"></a>
		</nav>-->
	</div>
</body>
</html>