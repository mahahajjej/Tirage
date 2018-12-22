$(document).ready(function() {
	
	$("form").on('submit', function(e){
		e.preventDefault();
		
		let data = {
			login: $('input[name="login"]').val(),
			password: $('input[name="password"]').val(),
		};
		
		$.ajax({
			url:'http://localhost:8080/TirageREST/authentification',
			type: 'POST',
			data: data,
		}).done(function (data){
			localStorage.setItem('isAgent', data.isAgent);
			localStorage.setItem('id', data.id);
			if(data.isAgent){
				window.location.replace("http://localhost:8080/TirageClient/Agent/dashboard.jsp");
			}else{
				window.location.replace("http://localhost:8080/TirageClient/Enseignant/addtask.jsp");
			}
		}).fail(function (){
			alert("Login failed");
		});
	});
	
});