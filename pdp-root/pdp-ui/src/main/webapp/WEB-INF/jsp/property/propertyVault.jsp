<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="../fragments/headTag.jsp"/>
<body>


<div class="page" style="clear: both">
    <section class="con">
        <header class="pageHeader">
                <h2 class="conTitle"><spring:message code="property.propertyVaultPage.title"/></h2>
        </header>
    </section>
    <div class="conBody">
        <%--<c:set var="iCnt" scope="session" value="${0}"/>--%>
        <%--<c:forEach var="stateCity" items="${stateCityList}">--%>
            <%--<c:if test="${iCnt['0']}">--%>

                <%--<div class="talGrid talGridNoGutters full768" style="margin-left: 30px;margin-top: 20px">--%>

            <%--</c:if>--%>

            <%--<c:if test="${iCnt['<3']}">--%>
                <%--<div class="talCol w33" style="text-align: center;">--%>
                    <%--<div class="w70" style="box-shadow: 10px 5px 5px #888888;background-color: #fff;">--%>
                        <%--<a href="loadPropertyList?cityId=${stateCity.getCityId()}"><img style="padding-top: 5px" src="../resources/images/assets/${stateCity.getImageUrl()}"></a>--%>
                    <%--</div>--%>
                    <%--<div class="w70">--%>
                        <%--<h3>${stateCity.getCityName()}</h3>--%>
                    <%--</div>--%>

                <%--</div>--%>
            <%--</c:if>--%>
            <%--<c--%>
            <%--<c:if test="${iCnt['3']}">--%>
                <%--</div>--%>
                <%--<c:set target="iCnt" value="${0}"></c:set>--%>
            <%--</c:if>--%>
            <%--<c:set target="iCnt" value="${iCnt + iCnt +1}"/>--%>
        <%--</c:forEach>--%>
        <%--<%--%>
<%--//            int iCnt = 0;--%>
            <%--int iPerRow = 3;--%>
            <%--for (StateCity stateCity : scl) {--%>

                <%--if(iCnt ==0){--%>
                    <%--// Create DIV--%>
        <%--%><div class="talGrid talGridNoGutters full768" style="margin-left: 30px;margin-top: 20px"><%--%>
        <%--}--%>
        <%--if (iCnt <= 3) {--%>
        <%--%>--%>

        <%--<%--%>
                <%--iCnt++;--%>
            <%--}--%>
            <%--if(iCnt ==3){--%>
        <%--%></div><%--%>
        <%--iCnt = 0;--%>
    <%--}else if(iCnt == scl.size()){--%>
    <%--%></div><%--%>
        <%--}--%>

    <%--}--%>
<%--%>--%>


    </div>
    <footer class="conFooter">

    </footer>
    </div>


</body>
</html>