<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: mcoletti
  Date: 5/24/13
  Time: 3:39 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page import="com.codeitek.pdp.model.*" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang.WordUtils" %>
<%@ include file="/WEB-INF/views/layouts/taglibs.jsp" %>
<%@ include file="/WEB-INF/views/layouts/includes.jsp" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="<c:url value="/resources/js/app/propertyVault.js" />"></script>
    <title><spring:message code="property.propertyVaultPage.title"/></title>
    <%
        List<StateCity> scl = (List<StateCity>) request.getAttribute("stateCityList");
        Customer customer = (Customer)request.getAttribute("customer");
    %>
</head>
<body>

<%-- ##################  Floating Menu Section ######################--%>
<%@ include file="/WEB-INF/views/shared/menu.jsp" %>

<%--####################################  Header Page ##############################################--%>
<%@ include file="/WEB-INF/views/layouts/_header.jsp" %>
<%-- ################################ Main Page Content Area ##############################################--%>
<div class="page" style="clear: both">
    <section class="con">
        <header class="pageHeader">
                <h2 class="conTitle"><%=customer.getFullName()%> <spring:message code="property.propertyVaultPage.title"/></h2>
        </header>
    </section>
    <section class="con">
        <header class="conHeader">

        </header>
        <div class="conBody">
            <div class="shadowBox ui-corner-all">
                <h2 style="color: #ffffff;padding-left: 5px">Current Active Cities</h2>
            </div>
            <div class="w95" style="border-bottom: 3px dotted #c3be7f;">&nbsp;</div>
            <%
            int iCnt = 0;
            int iPerRow = 3;
            for (StateCity stateCity : scl) {
                String cityName = WordUtils.capitalizeFully(stateCity.getCity());
                if(iCnt ==0){
                    // Create DIV
                    %>
                    <div class="talGrid talGridNoGutters full768" style="margin-left: 30px;margin-top: 20px">
                    <%
                }
                if (iCnt <= 3) {
                    %>
                    <div class="talCol w33" style="text-align: center;">
                        <div class="w70" style="box-shadow: 10px 10px 10px #888888;background-color: #fff;height: 165px">
                            <a href="loadPropertyList?cityId=<%=stateCity.getCityId()%>" title="Click to View Listings"><img src="../resources/images/assets/<%=stateCity.getImageUrl()%>"></a>
                        </div>
                        <div class="w70" style="margin-top: 10px">
                            <h3 class="text2xlrg fontfGA bold" style="color: #592003"><%=cityName%></h3>
                        </div>

                    </div>
                    <%
                  iCnt++;
                }
                if(iCnt ==3){
                    %></div><%
                iCnt = 0;
                }else if(iCnt == scl.size()){
                    %></div><%
                }
            }
        %>

        </div>
        <div class="conSecond">

        </div>
    </section>
<footer class="conFooter">

</footer>
</div>


</body>
</html>