var tasks;

function validate(id){
	$.ajax({
		url:'http://localhost:8080/TirageREST/tache/'+id,
		type:'DELETE'
	}).done((data)=>{
		$("#task-"+id).remove();
		tasks = tasks.filter((task)=>{
			return task.id != id;
		});
	}).fail(()=>{
		alert("Failure validating tasks");
	});
};

$(document).ready(function () {
	
	if(localStorage.length == 0){
		window.location.replace("http://localhost:8080/TirageClient/Authentification/authentification.jsp");
		throw new error("Session expired");
	}
	
	function populateTable(date){
		let filtered = tasks.filter((task)=>{
			return moment(task.dateTirage).format("YYYY-MM-DD") == date;
		})
		
		$("#tableBody").empty();
		
		$.each(filtered, (i, t)=>{
			let tr = $('<tr id="task-'+ t.id +'"></tr>');
			tr.append('<td>'+ (i+1) +'</td>');
			tr.append('<td>'+ t.enseignant.nomComplet +'</td>');
			tr.append('<td>'+ t.matiere.nomMatiere +'</td>');
			tr.append('<td>'+ moment(t.dateTirage).format("HH:mm") +'</td>');
			tr.append('<td>'+ t.nomFichier +'</td>');
			tr.append('<td>'+ t.nombreCopies +'</td>');
			tr.append('<td><a class="btn btn-success" onclick=validate('+ t.id +')>Validate</a></td>');
			$("#tableBody").append(tr);
		});
		
	};
	
	$(function(){
		
		let today = moment(new Date()).format("YYYY-MM-DD");
		$('input[type="date"]').val(today);
		
		$.ajax({
			url:'http://localhost:8080/TirageREST/tache',
			type:'GET'
		}).done((data)=>{
			tasks = data;
			populateTable(today);
		}).fail(()=>{
			alert("Failure getting tasks");
		});
		
	});
	
	$('input[type="date"]').on('change', ()=>{
		date = $('input[type="date"]').val();
		populateTable(date);
	});
	
	$("#logout").on('click', ()=>{
		localStorage.clear();
		window.location.replace("http://localhost:8080/TirageClient/Authentification/authentification.jsp");
	});
	
});