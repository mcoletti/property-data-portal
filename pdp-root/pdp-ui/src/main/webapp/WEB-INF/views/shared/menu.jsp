<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/layouts/taglibs.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<c:url value="/resources/js/app/menu.js" />"></script>


<div id="floatMenu" style="width: 175px" class="ui-widget ui-widget-content ui-corner-all ui-helper-clearfix">
    <div class="menuHeader">
        <h2 class="menuTitle"><spring:message code="menu.title"/></h2>
    </div>
    <div style="border-bottom: 1px dotted #c3be7f;">&nbsp;</div>
    <ul id="mainMenu" class="menu1 w80" style="margin-top: 5px;">

        <%--<li><button id="propertyVault" >Property Vault</button></li>--%>
        <%--<li><a id="btnReloadStack" class="ancBtn brown sml"><span>Reload Config</span></a></li>--%>
        <%--@*                <li><a href="#" onclick=" return false; "> Home </a></li>*@--%>
    </ul>
    <%--@*            <ul class="menu2">*@--%>
    <%--@*                <li><a href="#" onclick=" return false; "> Table of content </a></li>*@--%>
    <%--@*                <li><a href="#" onclick=" return false; "> Exam </a></li>*@--%>
    <%--@*                <li><a href="#" onclick=" return false; "> Wiki </a></li>*@--%>
    <%--@*            </ul>*@--%>
    <%--@*            <ul class="menu3">*@--%>
    <%--@*                <li><a href="#" onclick=" return false; "> Technical support </a></li>*@--%>
    <%--@*            </ul>*@--%>
</div>