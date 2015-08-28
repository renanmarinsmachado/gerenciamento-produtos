<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <p><fmt:message key="${tes}"/></p> --%>
<c:out value="${teste}"/>

<p>${teste}</p>


<%-- JSTL foreach tag example to loop an array in jsp --%>
<%--         <c:forEach var="product" items="${products}">  --%>
<%--             <c:out value="${product.id}"/>  --%>
<%--         </c:forEach> --%>
</body>
</html>