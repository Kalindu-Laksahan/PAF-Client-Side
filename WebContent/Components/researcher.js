$(document).ready(function() {
	if ($("#alertSuccess").text().trim() == "") 
	{
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	// Form validation-------------------
	var status = validateformResearcher();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	//IF Valid================================================================

	var type = ($("#hidResearcherIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
			{ 
			 url : "researcherAPI", 
			 type : type, 
			 data : $("#formResearcher").serialize(), 
			 dataType : "text", 
			 complete : function(response, status) 
			 { 
			 onItemSaveComplete(response.responseText, status); 
			 } 
			});
});

function onItemSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") 
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") 
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") 
	{
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else 
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidResearcherIDSave").val("");
	$("#formResearcher")[0].reset();
}

// UPDATE==========================================
$(document).on("click",".btnUpdate",function(event) {
			$("#hidResearcherIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
			$("#ResearcherName").val($(this).closest("tr").find('td:eq(0)').text());
			$("#ResearcherEmail").val($(this).closest("tr").find('td:eq(1)').text());
			$("#AboutResearcher").val($(this).closest("tr").find('td:eq(2)').text());
			$("#ProjectName").val($(this).closest("tr").find('td:eq(3)').text());
			$("#ProjectDescription").val($(this).closest("tr").find('td:eq(4)').text());
			$("#ProjectPrice").val($(this).closest("tr").find('td:eq(5)').text());
});

//REMOVE=============
$(document).on("click", ".btnRemove", function(event)
		{ 
		 $.ajax( 
		 { 
		 url : "researcherAPI", 
		 type : "DELETE", 
		 data : "ResearcherID=" + $(this).data("rid"),
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onItemDeleteComplete(response.responseText, status); 
		 } 
	}); 
});

function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	} 
}


// CLIENT-MODEL================================================================
function validateformResearcher() {
	// Researcher Name
	if ($("#ResearcherName").val().trim() == "") {
		return "Insert Researcher Name.";
	}
	// Researcher Email
	if ($("#ResearcherEmail").val().trim() == "") {
		return "Insert Researcher Email.";
	}
	// About Researcher 
	if ($("#AboutResearcher").val().trim() == "") {
		return "Insert a short description About Researcher.";
	}
	// Project Name 
	if ($("#ProjectName").val().trim() == "") {
		return "Insert Project Name.";
	}
	// Project description
	if ($("#ProjectDescription").val().trim() == "") {
		return "Insert a short description About Project.";
	}
	
	// Project value
	if ($("#ProjectPrice").val().trim() == "") {
		return "Insert  Project Price.";
	}
	 
	 
	return true;
}








