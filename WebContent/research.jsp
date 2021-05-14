<%@page import="model.researcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Young researcher</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/researcher.js"></script>
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div class="col-8">
				<h1 class="m-3">Young Researcher details</h1>
				<form id="formResearcher" name ="formResearcher" >

					
					Researcher Name:-
					<input type="text" id="ResearcherName" name="ResearcherName" class="form-control form-control-sm">
					

					<br>Researcher Email:-
					<input type="text" id="ResearcherEmail" name="ResearcherEmail" class="form-control form-control-sm">
					

					<br>About Researcher:-
						<input type="text" id="AboutResearcher" name="AboutResearcher" class="form-control form-control-sm">
					
					<br> Project Name:-
						<input type="text" id="ProjectName" name="ProjectName" class="form-control form-control-sm">
					
					<br> Project Description:-	
						<input type="text" id="ProjectDescription" name="ProjectDescription" class="form-control form-control-sm">
					
					<br> Project Price:-
						<input type="text" id="ProjectPrice" name="ProjectPrice" class="form-control form-control-sm">
					
					<br>
					<input type="button" id="btnSave" name ="btnSave"value="Save"
						class="btn btn-primary">
						
					<input type="hidden" id="hidResearcherIDSave" name="hidResearcherIDSave" value="">
						
						
					</form>
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					
					<br>
				<div id="divItemsGrid">
					<%
						researcher reObj = new researcher();
						out.print(reObj.readResearcher());
					%>
				</div>

			</div>
		</div>

	</div>



	







</body>
</html>