<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="addtask.css">
<title>Print Request</title>
</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">Print Request</h1>
					<hr />
				</div>
			</div>
			<div class="main-login main-center">
				<form class="form-horizontal" method="post" action="#">
					<div class="form-group">
						<label class="cols-sm-2 control-label">Subject name </label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-edit"
									aria-hidden="true"></i></span> <select class="form-control"
									id="selectSubject">
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Date
							of retrieval </label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"
									aria-hidden="true"></i></span> <input type="date" class="form-control"
									name="date" id="date" placeholder="Date and Time of retrieval" required="required"/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Time
							of retrieval </label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-clock-o"
									aria-hidden="true"></i></span> <input type="time" class="form-control"
									name="time" id="time" placeholder="Date and Time of retrieval" required="required"/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Copies</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-file"
									aria-hidden="true"></i></span> <input type="number"
									class="form-control" name="numberOfCopies" id="numberOfCopies"
									placeholder="number of copies" required="required" min="1"/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="confirm" class="cols-sm-2 control-label">Document
							to print</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><input type="file"
									name="file" accept="application/pdf"/> </span>
							</div>
						</div>
					</div>
					<div class="form-group ">
						<button type="submit"
							class="btn btn-primary btn-lg btn-block login-button">Submit</button>
						<button type="reset"
							class="btn btn-link  btn-lg btn-block login-button">Reset</button>
						<button type="button" id="logout" class="btn btn-default btn-lg btn-block">
							<span class="glyphicon glyphicon-log-out"></span> Log out
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="addtask.js"></script>
</body>
</html>