<%
    String lang = request.getParameter("lang");
    if( lang == null ){
        String accLang  = request.getHeader("accept-language");
        if ( accLang!= null && accLang.length()>0) {
            lang = accLang.split(",")[0];
            lang = lang.substring(0,2);
        }
    }
%>

<!--
<%="request language: "+lang %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!--
PetClinic :: a Spring Framework demonstration
-->

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>pdp Enterprise Property Listings Portal</title>


    <spring:url value="/resources/css/header.css" var="headerCss"/>
    <spring:url value="/resources/css/button.css" var="buttonCss" />
    <spring:url value="/resources/css/main.css" var="mainCss"/>
    <spring:url value="/resources/css/form.css" var="formCss" />
    <spring:url value="/resources/css/grid.css" var="gridCss"/>
    <spring:url value="/resources/css/panel.css" var="panelCss"/>
    <spring:url value="/resources/css/template.css" var="templateCss"/>
    <spring:url value="/resources/css/table.css" var="tableCss"/>
    <spring:url value="/resources/css/ui.jqgrid.css" var="jqgridCss"/>
    <spring:url value="/resources/thirdParty/fb/jquery.fancybox.css?v=2.1.4" var="fbCss"/>
    <spring:url value="/resources/css/fbox.css" var="fboxCss" />
    <spring:url value="/resources/css/container.css" var="containerCss"/>
    <spring:url value="/resources/css/jquery-ui-1.10.2.custom.css" var="jqueryCustomCss"/>
    <link href="${headerCss}" rel="stylesheet"/>
    <link href="${buttonCss}" rel="stylesheet"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <link href="${formCss}" rel="stylesheet"/>
    <link href="${gridCss}" rel="stylesheet"/>
    <link href="${panelCss}" rel="stylesheet"/>
    <link href="${templateCss}" rel="stylesheet"/>
    <link href="${tableCss}" rel="stylesheet"/>
    <link href="${fbCss}" rel="stylesheet"/>
    <link href="${fboxCss}" rel="stylesheet"/>
    <link href="${containerCss}" rel="stylesheet"/>
    <link href="${jqueryCustomCss}" rel="stylesheet"/>

    <%-- Java Script Include References--%>

    <spring:url value="/resources/js/jquery-1.9.1.js" var="jQuery"/>
    <spring:url value="/resources/js/i18n/grid.locale-en.js" var="jQgrid"/>
    <spring:url value="/resources/js/jquery.jqGrid.min.js" var="jQgridMin"/>
    <spring:url value="/resources/js/jquery-ui-1.10.2.custom.js" var="jQueryUi"/>
    <spring:url value="/resources/js/jquery.cookie.js" var="jQueryUi"/>
    <spring:url value="/resources/js/tabs.js" var="tabs"/>
    <spring:url value="/resources/js/purl.js" var="purl"/>
    <spring:url value="/resources/thirdParty/fb/jquery.fancybox.js?v=2.1.4" var="fBox"/>
    <script src="${jQuery}"></script>
    <script src="${jQgrid}"></script>
    <script src="${jQgridMin}"></script>
    <script src="${jQueryUi}"></script>
    <script src="${tabs}"></script>
    <script src="${purl}"></script>
    <script src="${fBox}"></script>




    <%--<spring:url value="/webjars/bootstrap/2.3.0/css/bootstrap.min.css" var="bootstrapCss"/>--%>
    <%--<link href="${bootstrapCss}" rel="stylesheet"/>--%>

    <%--<spring:url value="/resources/css/petclinic.css" var="petclinicCss"/>--%>
    <%--<link href="${petclinicCss}" rel="stylesheet"/>--%>

    <%--<spring:url value="/webjars/jquery/1.9.0/jquery.js" var="jQuery"/>--%>
    <%--<script src="${jQuery}"></script>--%>

    <%--<spring:url value="/webjars/jquery-ui/1.9.2/js/jquery-ui-1.9.2.custom.js" var="jQueryUi"/>--%>
    <%--<script src="${jQueryUi}"></script>--%>

    <%--<spring:url value="/webjars/jquery-ui/1.9.2/css/smoothness/jquery-ui-1.9.2.custom.css" var="jQueryUiCss"/>--%>
    <%--<link href="${jQueryUiCss}" rel="stylesheet"></link>--%>
</head>


