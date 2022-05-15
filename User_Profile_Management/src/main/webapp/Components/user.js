





//SAVE
$(document).on("click", "#btnSave", function(event)
{ 
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
// Form validation-------------------
var status = validateItemForm(); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
// If valid------------------------
var type = ($("#hidCustomerIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "userAPI", 
 type : type, 
 data : $("#formItem").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onItemSaveComplete(response.responseText, status); 
 } 
 }); 
});

function onItemSaveComplete(response, status)
{ 
if (status == "success") 
 { 
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
$("#hidCustomerIDSave").val(""); 
$("#formItem")[0].reset(); 
}


// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
		{ 
		$("#hidCustomerIDSave").val($(this).data("customerid")); 
		 $("#CustomerfName").val($(this).closest("tr").find('td:eq(0)').text()); 
		 $("#CustomerlName").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#AccountNumber").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#CustomerNIC").val($(this).closest("tr").find('td:eq(3)').text());
		$("#CustomerEmail").val($(this).closest("tr").find('td:eq(3)').text());
		$("#CustomerPhone").val($(this).closest("tr").find('td:eq(3)').text()); 
		});




$(document).on("click", ".btnRemove", function(event)
		{ 
		 $.ajax( 
		 { 
		 url : "userAPI", 
		 type : "DELETE", 
		 data : "CustomerID=" + $(this).data("customerid"),
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onItemDeleteComplete(response.responseText, status); 
		 } 
		 }); 
		});
		
function onItemDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 } 
}


// CLIENT-MODEL================================================================
function validateItemForm()
{
	// CODE
	if ($("#CustomerfName").val().trim() == "")
	{
	return "Insert CustomerfName.";
	}
	// NAME
	if ($("#CustomerlName").val().trim() == "")
	{
	return "Insert CustomerlName.";
}

/*// PRICE-------------------------------
if ($("#itemPrice").val().trim() == ""){
	return "Insert Item Price.";
}
		// is numerical value
		var tmpPrice = $("#itemPrice").val().trim();
		if (!$.isNumeric(tmpPrice))
	{
	return "Insert a numerical value for Item Price.";
	}
		
// convert to decimal price
$("#itemPrice").val(parseFloat(tmpPrice).toFixed(2));*/

// DESCRIPTION------------------------
if ($("#AccountNumber").val().trim() == ""){
	
	return "Insert AccountNumber.";
}
if ($("#CustomerNIC").val().trim() == ""){
	
	return "Insert CustomerNIC.";
}
if ($("#CustomerEmail").val().trim() == ""){
	
	return "Insert CustomerEmail.";
}
if ($("#CustomerPhone").val().trim() == ""){
	
	return "Insert CustomerPhone.";
}

	return true;
}