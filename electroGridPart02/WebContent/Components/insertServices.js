$(document).ready(function()
{
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
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}


	// If valid------------------------
	var type = ($("#hidIDSave").val() == "") ? "POST" : "PUT";
	$.ajax({
		url : "serviceApi",
		type : type,
		data : $("#formService").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
		}
	});

});



function onItemSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidIDSave").val("");
	$("#formService")[0].reset();
}




// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) {
			$("#hidIDSave").val( $(this).closest("tr").find('#hidIDUpdate').val());
			$("#insert_Id").val($(this).closest("tr").find('td:eq(0)').text());
			$("#insert_type").val($(this).closest("tr").find('td:eq(1)').text());
			$("#insert_unitPrice").val($(this).closest("tr").find('td:eq(2)').text());
			$("#insert_Instruction").val($(this).closest("tr").find('td:eq(3)').text());
			$("#insert_services").val($(this).closest("tr").find('td:eq(3)').text());
		});


// Delete============================================
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "serviceApi",
		type : "DELETE",
		data : "insert_Id=" + $(this).data("email"),
		dataType : "text",
		complete : function(response, status) {
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







//CLIENTMODEL=========================================================================
function validateItemForm()
{

//ID
if ($("#insert_Id").val().trim() == "")
 {
 return "Insert package ID";
 }

//Type
if ($("#insert_type").val().trim() == "")
 {
 return "Insert package Type";
 }

//unit Price
if ($("#insert_unitPrice").val().trim() == "")
 {
 return "Insert package unit Price";
 }

//Instruction
if ($("#insert_Instruction").val().trim() == "")
 {
 return "Insert package instruction";
 } 
//Services
if ($("#insert_services").val().trim() == "")
 {
 return "Insert services details";
 } 
return true;
}