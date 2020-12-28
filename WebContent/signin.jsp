<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>

<jsp:useBean id="signinBean" scope="request" class="bean.SignInBean" />

<!-- mappare gli attributi di un oggetto sui campi della form -->
<jsp:setProperty name="signinBean" property="*"/>

<html>
<head>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/style.css" rel="stylesheet">
	<title>SignIn</title>
</head>
<body>
	
	<div class="conteiner-fluid">
		<nav class="navbar navbar-dark bg-dark" style="background-color: black">
 			<a class="navbar-brand" style="color: yellow" href="index.jsp"><img src="img/home.png" class="img-responsive" style="fill: yellow ;margin-top: -23%;"></a>
			<p class="text-center" style="color: yellow; font-size: 209%">Il Decimo</p>
		</nav>
		<div class="rows">
			<div class="col-sm-offset-3 col-sm-6 signincont ">
				<div class="col-sm-11 text-center">
					<p><b>Sign In</b></p>
				</div>
				<form action="signin.jsp" name="signform" method="POST">
						<div class="rows">
							<div class="col-sm-4">
								<label for="nome">Nome</label>
							</div>
							
							<div class="col-sm-8">
								<input type="text" id="nome" name="nome" required>
							</div>
						</div> 
						
						<div class="rows">
							<div class="col-sm-4">
								<label for="cognome">Cognome</label>
							</div>
							
							<div class="col-sm-8">
								<input type="text" id="cognome" name="cognome" required>
							</div>
						</div>
						
						<div class="rows">
							<div class="col-sm-4">
								<label for="username">Username</label>
							</div>
							
							<div class="col-sm-8">
								<input type="text" id="username" name="username" required>
							</div>
						</div>
						
						<div class="rows">
							<div class="col-sm-4">
								<label for="email">email</label>
							</div>
							
							<div class="col-sm-8">
								<input type="text" id="email" name="email" required>
							</div>
						</div>
						
						<div class="rows">
							<div class="col-sm-4">
								<label for="confEmail">Conferma email</label>
							</div>
							
							<div class="col-sm-8">
								<input type="text" id="confEmail" name="confEmail" required>
							</div>
						</div>
						
						<div class="rows">
							<div class="col-sm-4">
								<label for="password">Password</label>
							</div>
							
							<div class="col-sm-8">
								<input type="password" id="password" name="password" required>
							</div>
						</div>
						
						<div class="rows">
							<div class="col-sm-4">
								<label for="confPass">Conferma password</label>
							</div>
							
							<div class="col-sm-8">
								<input type="password" id="confPass" name="confPass" required>
							</div>
						</div>
						
						<div class="rows">
							<div class="col-sm-offset-8 col-sm-4">
								<input type="submit" name="signin" value="SignIn" class="loginbtn">
							</div>
	
						</div>
					
<%
	if(request.getParameter("signin")!=null){
		int c = signinBean.validate();
		if(c == 0){
%>
			<jsp:forward page="home.jsp"/>
<%
		}
		else if (c == -1){
%>
			<div class="rows">
				<div class="col-sm-12 signinerr">
					<p style="color: red">Email non Valida</p>
				</div>
			</div>
<% 
		}
		else if (c == 1){
%>
			<div class="rows">
					<div class="col-sm-12 signinerr">
						<p style="color: red">Le Password inserite non corrispondono</p>
				</div>
			</div>
<% 	
		}
		else if(c == 2){
%>
			<div class="rows">
				<div class="col-sm-12 signinerr">
						<p style="color: red"> Le email inserite non corrispodono</p>
				</div>
			</div>
<%
		}
		else {
%>
			<div class="rows">
					<div class="col-sm-12 signinerr">
						<p style="color: red"> Nome utente non disponibile</p>
				</div>
			</div>
<%
		}
	}	
%>

				</form>
			</div>
		</div>
	</div>	

</body>
</html>