<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<%@ include file="/WEB-INF/views/layouts/taglibs.jsp" %>
<%@ include file="/WEB-INF/views/layouts/includes.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="property.propertyVaultPage.title"/></title>


    <%
        List<StateCity> scl = (List<StateCity>) request.getAttribute("stateCityList");

    %>


</head>
<body>


<div class="page" style="clear: both">
    <section class="con">
        <header class="pageHeader">
                <h2 class="conTitle"><spring:message code="property.propertyVaultPage.title"/></h2>
        </header>
    </section>
    <div class="conBody">

        <%
            int iCnt = 0;
            int iPerRow = 3;
            for (StateCity stateCity : scl) {

                if(iCnt ==0){
                    // Create DIV
        %><div class="talGrid talGridNoGutters full768" style="margin-left: 30px;margin-top: 20px"><%
        }
        if (iCnt <= 3) {
    %>
        <div class="talCol w33" style="text-align: center;">
            <div class="w70" style="box-shadow: 10px 5px 5px #888888;background-color: #fff;">
                <a href="loadPropertyList?cityId=<%=stateCity.getCityId()%>"><img style="padding-top: 5px" src="../resources/images/assets/<%=stateCity.getImageUrl()%>"></a>
            </div>
            <div class="w70">
                <h3><%=stateCity.getCity()%></h3>
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
<footer class="conFooter">

</footer>
</div>


</body>
</html>