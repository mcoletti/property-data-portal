<%--
  Created by IntelliJ IDEA.
  User: mcoletti
  Date: 6/7/13
  Time: 4:18 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<h2><fmt:message key="welcome"/></h2>
<spring:url value="/resources/images/pets.png" htmlEscape="true" var="petsImage"/>
<img src="${petsImage}"/>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>