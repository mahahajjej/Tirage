<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="authentification.css">
</head>
<body id="LoginForm">
	<div class="container">
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Authentication</h2>
					<p>Please enter your Login and password</p>
				</div>
				<form id="Login" autocomplete="off">
					<div class="form-group">
						<input type="text" class="form-control" id="login"
							placeholder="Login" name="login">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="pssword"
							placeholder="Password" name="password">
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>
	</div>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="authentification.js"></script>
</body>
</html>
