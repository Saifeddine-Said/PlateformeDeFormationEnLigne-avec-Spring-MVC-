function loadEspaces() {
	$(".monEspace").click(function(event) {
		//alert(event.target.id);
		$.getJSON("sousEspaces", {
			idEspaceParent : event.target.id,
			ajax : "true"
		}, function(data) {
			if (data.length > 0) {
				$("#shuffle-grid").animate( { "opacity": "remove"} , 1000 );
			}
			var html = "";
			//var html = "<option value=''>Selectionner un module</option>";
			for (var index = 0; index < data.length; index++) {
				html += "<div class='col-lg-4 col-md-4 col-sm-6 col-xs-12 task shuffle-item filtered' data-date-due='2015-11-28' data-priority='3' style='visibility: visible; transition: transform 250ms ease-out, opacity 250ms ease-out; -webkit-transition: transform 250ms ease-out, opacity 250ms ease-out;'>"+
				"<div class='panel panel-default'>"
				+"<div class='panel-heading'>"
				+"<div class='panel-toolbar text-left'>"
				+"<span class='checkbox custom-checkbox custom-checkbox-inverse'> <input type='checkbox' name='customcheckbox1' id='customcheckbox1'> <label for='customcheckbox1'>&nbsp;&nbsp;&nbsp;</label>"
				+"</span>"
				+"</div>"
				+"<h3 class='panel-title ellipsis' style='width: 100%;'>"
				+"<a href='#' class='monEspace' id='"+data[index].idEspace+"'>"+data[index].nomEspace+"</a>"
				+"</h3>"
				+"</div>"
				+"<div class='panel-body'>"
				+"<div class='row mb15'>"
				+"<div class='col-xs-12'>"
				+"<span class='text-muted'>Nom : </span>&nbsp;&nbsp;&nbsp;<strong>"+data[index].nomEspace+"</strong>"
				+"</div>"
				+"</div>"
				+"<div class='row mb15'>"
				+"<div class='col-xs-12'>"
				+"<span class='text-muted'>Description : </span>&nbsp;&nbsp;&nbsp;<strong>"+data[index].descriptionEspace+"</strong>"
				+"</div>"
				+"</div>"
				+"<div class='row'>"
				+"<div class='col-xs-6'>"
				+"<span class='text-muted'>Partage : </span>&nbsp;&nbsp;&nbsp;"
				+"<c:if test='"+data[index].partage+"'>"
				+"<span class='badge badge-success'>Partage</span>"
				+"</c:if>"
				+"<c:if test='!"+data[index].partage+"'>"
				+"<span class='badge badge-warning'>Non partage</span>"
				+"</c:if>"
				+"</div>"
				+"<div class='col-xs-6'>"
				+"<span class='ico-calendar3'></span>&nbsp;&nbsp;<span class='text-muted'></span>&nbsp;&nbsp;&nbsp;<strong>"+data[index].dateCreation+"</strong>"
				+"</div>"
				+"</div>"
				+"</div>"
				+"<div class='panel-footer'>"
				+"<ul class='list-table'>"
				+"<li>"
				+"<div class='img-group img-group-stack'>"
				+"<img src='/elearning/resources/image/avatar/avatar2.jpg' class='img-circle' alt='' title='Ori Duke'> <span class='more img-circle'>5</span>"
				+"</div>"
				+"</li>"
				+"<li class='text-right'>"
				+"<div class='img-group img-group-stack'>"
				+"<img src='/elearning/resources/image/avatar/avatar2.jpg' class='img-circle' alt='' title='Ori Duke'> <span class='more img-circle'>5</span>"
				+"</div>"
				+"</li>"
				+"</ul>"
				+"</div>"
				+"</div>"
				+"</div>";
			}
			$("#shuffle-grid").html(html);
		});
	});
}

$(document).ready(function() {
	loadEspaces();
});
