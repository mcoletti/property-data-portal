<%--
  Created by IntelliJ IDEA.
  User: mcoletti
  Date: 4/23/13
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/views/layouts/taglibs.jsp" %>
<%@ include file="/WEB-INF/views/layouts/includes.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="<c:url value="/resources/js/app/propertyHandler.js" />"></script>
    <script type="text/javascript">
        $(document).ready(function () {
//    var custUUid = $.cookie("pdp-cust-id", { path: '/pdp' });
            loadProperties();

        });

    </script>
</head>
<body>

</body>
</html>