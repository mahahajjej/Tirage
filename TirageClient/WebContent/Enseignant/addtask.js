$(document).ready(function () {
	
	if(localStorage.length == 0){
		window.location.replace("http://localhost:8080/TirageClient/Authentification/authentification.jsp");
		throw new error("Session expired");
	}
	
	$.ajax({
		url:'http://localhost:8080/TirageREST/enseignant/'+localStorage.getItem("id"),
		type:'GET',
	}).done(function (data){
		$.each(data.matieres, function(i, matiere){
			$("#selectSubject").append('<option value="'+ matiere.id_matiere +'">'+matiere.nomMatiere+'</option>')
		});
	}).fail(() => {
		alert('Something went wrong!');
	});
	
	$("#logout").on('click', function(){
		localStorage.clear();
		window.location.replace("http://localhost:8080/TirageClient/Authentification/authentification.jsp");
	});
	
	$('form').on('submit', function(e){
		e.preventDefault();
		
		let dr = $('#date').val();
		let tr = $('#time').val();
		let sid = $('#selectSubject').val();
		let nbc = $('#numberOfCopies').val();
		let path = $('input[name="file"]').val();
		let filename;
		if(path != ""){
			filename = path.replace(/^.*[\\\/]/, '');
		}else{
			filename = null;
		}
		
		let data = {
				nomFichier: filename,
				nombreCopies: nbc,
				dateTirage: dr + "T" + tr + ":00",
				}
		
		$.ajax({
			url:'http://localhost:8080/TirageREST/tache/enseignant/'+localStorage.getItem("id")+'/matiere/'+sid,
			type:'POST',
			contentType:'application/json',
			dataType:'json',
			data: JSON.stringify(data),
		}).done((data)=>{
			console.log(data);
		}).fail(()=>{
			alert("Failure to add task");
		});
	});
	
});