<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>demo dns</title>
</head>
<body>
	
	<form method="get" action="dns">
		<label for="domain">choisissez un nom de domaine : <span class="requis"></span></label> <br>
		 <input type="radio" name="domain" value="www.google.fr" > www.google.fr<br>
		<input type="radio" name="domain" value="www.orange.fr"> www.orange.fr<br>
		<input type="radio" name="domain" value="www.free.fr"> www.free.fr<br>
		<input type="radio" name="domain" value="www.afnic.fr"> www.afnic.fr<br>
		<input type="radio" name="domain" value="www.amazon.fr"> www.amazon.fr<br>
		<input type="submit" value="Valider" />
	</form>
	<p>L'adresse ip de du domaine ${add} est : ${test}</p>
</body>
</html>