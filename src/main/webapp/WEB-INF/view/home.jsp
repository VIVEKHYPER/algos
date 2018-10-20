<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="https://storage.googleapis.com/code.getmdl.io/1.0.6/material.indigo-pink.min.css">
<script
	src="https://storage.googleapis.com/code.getmdl.io/1.0.6/material.min.js">
    
</script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">



<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/home.js">
    
</script>
<title>Home</title>
</head>
<body>
	<div class="split left" id="left_side">
		<div class="centered">
			<div id="wrapper">
					<h5>Select Data Type</h5>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label getmdl-select getmdl-select__fix-height">
						<input type="text" value="" class="mdl-textfield__input"
							id="sample6" readonly> <input type="hidden" value=""
							name="sample6"> <i
							class="mdl-icon-toggle__label material-icons">keyboard_arrow_down</i>
						<label for="sample6" style="color: white; font-family: serif;"mdl-textfield__label">Country</label>
						<ul for="sample6"
							class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
							<li class="mdl-menu__item" data-selected="true"
								data-val="integer">Integer</li>
							<li class="mdl-menu__item" data-val="float">Floating Point</li>
							<li class="mdl-menu__item" data-val="date">Date</li>
							<li class="mdl-menu__item" data-val="string">String</li>
						</ul>
					</div>
					<br> <br> <br> <br>
					<div>
						<button id="addButton" type="button"
							class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab mdl-button--colored">
							<i class="material-icons">add</i>
						</button>
						<button
							class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab mdl-button--colored"
							type='button' value='Remove Button' id='removeButton'>
							<i class="material-icons">remove</i>
						</button>
					</div>
					<hr />
					<div class="container">
						<div class="row">
							<div class="form-group">
								<input type="text" class="mdl-textfield__input" name="size[]"
									placeholder="Number" />
							</div>
							<br>
						</div>
					</div>
					<button id="submit" value="Submit"
						class="mdl-button mdl-js-button mdl-button--accent">
						Submit</button>
			</div>
		</div>

	</div>
	<div class="split right" id="right_side">
		<div class="centered">
			<h2>Results</h2>
			<p>Some text here too.</p>
			<ul class="rolldown-list" id="myList" style="display: inline;">
				
			</ul>
		</div>
	</div>
	<br>
	<br>
	<input type="hidden" id="counter" value=1>
</body>
</html>