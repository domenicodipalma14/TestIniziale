<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!-- nome variabile id scope livello di persistenza della variabile: request variabile locale  -->
<jsp:useBean id="loginBean" scope="request" class="bean.LogInBean" />

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="loginBean" property="*"/>
<html>
<head>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
<title>Home</title>
</head>
<body>
	<div class="container-fluid">
		<div class="rows">
			<div class="col-sm-offset-2 col-sm-2 txt">
				<h1 style="color: yellow"><b>Il Decimo</b></h1>
				<p>Il Decimo ti aiuta a rimanere in contatto con gli amanti dello sport. Organizza o partecipa agli eventi con i tuoi amici e non</p>
			</div>
			
			<div class="col-sm-5 logincont">
				<div class="col-sm-11">
					<p><b>Welcome back</b></p>
				</div>
				<form action="index.jsp" name="loginform" method="POST">
					<div class="rows">
						<div class="col-sm-12">
							<label for="username">Username</label>
							<input type="text" id="username" name="username">
						</div>
					</div> 
				
					<div class="rows">
						<div class="col-sm-12">
							<label for="password">Password</label>
							<input type="password" id="password" name="password">
						</div>
					</div>
					
					<div class="rows">
						<div class="col-sm-offset-8 col-sm-4">
							<input type="submit" name="login" value="Log In" class="loginbtn">
						</div>

					</div>
					
<%
	if(request.getParameter("login")!=null){
		if(loginBean.validate()){
%>
			<jsp:forward page="home.jsp"/>
<%
		}
		else{
%>
			<p style="color: red">Dati errati</p>
<% 
	}
}		
%>

					</form>
				<div class="rows">
					<div class="col-sm-12 registrati">
						<p>Non hai un account?</p>
						<a class="btn btn-default text-center loginbtn btnbar" href="signin.jsp" role="button">SignIn</a>
					</div>
				</div>
				</div>
			</div>
		</div>
</body>
</html>