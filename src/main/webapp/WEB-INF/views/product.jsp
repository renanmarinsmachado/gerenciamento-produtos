<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
</head>
<body>
	${tes}
	<form method="post" action="/product">
		<table>
			<tr>
				<td><label>Descrição:</label></td>
				<td><input type="text" name="description" id="description" /></td>
			</tr>
			<tr>
				<td><label>Preço:</label></td>
				<td><input type="text" name="price" id="price" /></td>
			</tr>
		</table>
		<input type="submit" value="Salvar" />
	</form>

	<br>
	<br>
	<h1>Produtos</h1>
	<br>
	<%-- JSTL foreach tag example to loop an array in jsp --%>
        <c:forEach var="product" items="${products}"> 
        	<br>
            <c:out value="${product.id}"/> - <c:out value="${product.description}"/> 
        </c:forEach>
</body>
</html>
