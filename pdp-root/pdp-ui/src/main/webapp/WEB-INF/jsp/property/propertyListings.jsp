<%--
  Created by IntelliJ IDEA.
  User: mcoletti
  Date: 5/28/13
  Time: 8:54 AM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.codeitek.pdp.model.*" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.math.BigDecimal" %>
<%@ include file="/WEB-INF/views/layouts/taglibs.jsp" %>
<%@ include file="/WEB-INF/views/layouts/includes.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script type="text/javascript" src="<c:url value="/resources/js/app/propertyHandler.js" />"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui-1.10.2.custom.css" />" type="text/css">

<%

    PropertyDataDetailList listings = (PropertyDataDetailList) request.getAttribute("listings");
    Customer customer = (Customer) request.getAttribute("customer");
    List<StateCity> scvl = (List<StateCity>) request.getAttribute("stateCity");
    StateCity sc = scvl.get(0);
    List<PropertyImageData> imageDataList = null;
    PropertyImageData propImageData = null;

%>

<script type="text/javascript">
    $(document).ready(function () {

//            $('.fancybox').fancybox();
        $(".fancybox-effects-c").fancybox({
            wrapCSS: 'fancybox-custom',
            closeClick: true,

            openEffect: 'fade',
            openSpeed: 200,
            closeEffect: 'fade',
            closeSpeed: 200,

            helpers: {
                title: {
                    type: 'inside'
                },
                overlay: {
                    css: {
                        'background': 'rgba(238,238,238,0.85)'
                    }
                }
            }
        });
    });
</script>
<div class="page">
<section class="con">
    <header class="pageHeader">
        <h2 class="conTitle"><%=customer.getFullName()%>
        </h2>
    </header>
</section>
<div class="conBody" style="margin-top: 0">
    <div style="margin-left: 20px;margin-right: 20px;width: 100%">
        <img src="../resources/images/assets/listingsHeader.jpg">
    </div>
</div>
<section class="con">
    <header class="conTitle">
        <div class="shadowBox ui-corner-all">
            <p class="text2xlrg fontfGA"><%=String.format("%s, %s", sc.getCity(), sc.getState())%>
            </p>
        </div>
    </header>
    <div class="conBody">
        <div>
            <p><img class="alignright" src="../resources/images/assets/<%=sc.getImageUrl()%>"></p>

            <p class="textlrg fontfGA textAlgn"><%=sc.getSummary()%>
            </p>

        </div>
    </div>
</section>
<section class="con">
    <header class="conTitle">
        <div class="shadowBox ui-corner-all">
            <p class="text2xlrg fontfGA bold">Listings</p>
        </div>

    </header>
    <div class="conBody">
        <%

            for (PropertyDataDetail feed : listings.getList()) {

        %>

        <div class="listing ui-widget-content ui-helper-clearfix">
            <div class="lstBody">
                <%


                    imageDataList = feed.getImageDataList();
                    if (imageDataList != null) {
                        propImageData = imageDataList.get(0);

                %>

                <div class="lstImg ui-corner-all">
                    <a class="fancybox-effects-c" href="<%=propImageData.getImageUrl()%>"
                       title="<%=feed.getPropName()%>">
                        <img class="w100px h100px ui-corner-all" style="margin-left: 5px"
                             src="<%=propImageData.getImageUrl()%>" alt=""/></a>
                </div>
                <%
                } else {

                %>
                <div class="lstImg ui-corner-all">
                    <a href="#" title="Image Not-Found">
                        <img class="ui-corner-all" style="margin-left: 5px;width: 75px;height: 75px"
                             src="../resources/images/assets/not-found.jpg" alt=""/></a>
                </div>
                <%

                    }
                %>

            </div>

            <div style="margin-left:112px;margin-top: 20px" class="ui-helper-clearfix">

                <table class="table table480">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>

                    <tr>
                        <td><a class="text2xlrg bold" style="color: #003366"
                               href="loadProperty?propUId=<%=feed.getUuid()%>"><%=feed.getPropName()%>
                        </a><span style="font-size: 12px">&nbsp;(<%=feed.getStatus()%>)</span></td>
                        <td>
                            <div style="margin-top: 10px;" class="ui-helper-clearfix">
                                <%
                                    String street = feed.getPropName();
                                    String cityName = feed.getCity();
                                    String stateName = feed.getState();
                                    int zip = feed.getZip();
                                %>
                                <div style="float: left">
                                    <a class="ui-button"
                                       onclick="loadGoogleMap('<%=street%>','<%=cityName%>','<%=stateName%>','<%=feed.getId()%>')"><img
                                            src="../resources/images/map.jpg"/></a>
                                </div>
                                <div id="divMap_<%=feed.getId()%>"
                                     class="popUp lrg ui-widget-content ui-corner-all ui-helper-clearfix">
                                    <div style="float: right">
                                        <a id="btnMapClose_<%=feed.getId()%>"
                                           onclick="closeGoogleMap('<%=feed.getId()%>')"
                                           class="ui-button ui-stateName-default ui-corner-all">
                                            <span class="ui-icon ui-icon-close"></span></a>
                                    </div>
                                    <iframe id="ifMap_<%=feed.getId()%>"
                                            style="width: 95%;height: 95%;overflow: auto;margin-top: 10px;margin-left: 20px"
                                            frameBorder="0" scrolling="no"></iframe>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div style="height: 20px" class="ui-helper-clearfix">
                                <div style="float: left">
                                    <img src="../resources/images/assets/phone_icon_small.png"/>
                                </div>
                                <div style="margin-left: 30px;">
                                    <div style="vertical-align: middle">
                                        <spring:message code="global.contact.number"/>
                                    </div>
                                </div>
                            </div>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <table class="table table320">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    NumberFormat fPercent = NumberFormat.getPercentInstance(Locale.US);
                                    NumberFormat fCurrency = NumberFormat.getCurrencyInstance(Locale.US);
                                    for (PropertyFinancialView pf : feed.getFinancialViews()) {
                                        if ("cash_net_yield__c".equals(pf.getFinancialKey())) {

                                            BigDecimal value = pf.getValue().divide(BigDecimal.valueOf(100));
                                %>
                                <tr>
                                    <td>
                                        <%=pf.getDisplayName()%>
                                    </td>
                                    <td>
                                        <%=fPercent.format(value)%>
                                    </td>
                                </tr>
                                <%
                                } else if ("financed_net_yield_1__c".equals(pf.getFinancialKey())) {


                                    BigDecimal value = pf.getValue().divide(BigDecimal.valueOf(100));


                                %>
                                <tr>
                                    <td>
                                        <%=pf.getDisplayName()%>
                                    </td>
                                    <td>
                                        <%=fPercent.format(value)%>
                                    </td>
                                </tr>
                                <%
                                } else if ("monthlyrent__c".equals(pf.getFinancialKey())) {
                                %>
                                <tr>
                                    <td>
                                        <%=pf.getDisplayName()%>
                                    </td>
                                    <td>
                                        <%=fCurrency.format(pf.getValue())%>
                                    </td>
                                </tr>
                                <%
                                        }
                                    }
                                %>
                                <tr>
                                    <td>
                                        Beds:
                                    </td>
                                    <td>
                                        <%=feed.getNumBeds()%>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Baths:
                                    </td>
                                    <td>
                                        <%=feed.getNumBaths()%>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Sqft:
                                    </td>
                                    <td>
                                        <%=feed.getSqft()%>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <%
            }
        %>
    </div>
</section>
</div>