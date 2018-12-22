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
<link rel="stylesheet" type="text/css" href="dashboard.css">
<title>Print Request</title>
</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">Dashboard</h1>
					<hr />
				</div>
			</div>
			<div class="main-login main-center">
				<div class="col-xs-3 col-xs-offset-9">
					<button type="button" id="logout"
						class="btn btn-secondary">
						<span class="glyphicon glyphicon-log-out"></span> Log out
					</button>
				</div>
				<div class="form-group">
					<label for="username" class="cols-sm-2 control-label">Date
						of retrieval </label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-calendar"
								aria-hidden="true"></i></span> <input type="date" class="form-control"
								name="date" id="date" placeholder="Date and Time of retrieval"
								required="required" />
						</div>
					</div>
				</div>
				<table class="table" style="margin-top: 4rem;">
					<thead>
						<tr>
							<th>#</th>
							<th>Professor</th>
							<th>Subject</th>
							<th>Retrieval Time</th>
							<th>File</th>
							<th>Copies</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="tableBody">

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://momentjs.com/downloads/moment.min.js"></script>
	<script src="dashboard.js"></script>
</body>
</html>