<%--
  Created by IntelliJ IDEA.
  User: mcoletti
  Date: 4/23/13
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page import="com.codeitek.pdp.model.*" %>
<%@ page import="java.util.List" %>
<%@ include file="/WEB-INF/views/layouts/taglibs.jsp" %>
<%@ include file="/WEB-INF/views/layouts/includes.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="<c:url value="/resources/js/app/propertyHandler.js" />"></script>
<%
    PropertyDataDetailList dataFeedList = (PropertyDataDetailList) request.getAttribute("propertyDataFeed");

//    Integer offSet = (Integer) request.getAttribute("offSet");
//    Integer totalProperties = (Integer) request.getAttribute("totalProperties");
//    Integer currentPage = (Integer) request.getAttribute("currentPage");
//    currentPage++;
//    int totalPages = totalProperties/10;
//    offSet = offSet+10;

%>
<script type="text/javascript"
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBLU5vU3ooUhJXOFBoofxRT_-_MmGxmnKs&sensor=false">
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#divPopUpImage").hide();
        $("#nextPage").button({
            text: false,
            icons: {
                primary: "ui-icon-seek-next"
            }
        });
        $("#nextPage").click(function(){

//            var offSet = $("#hidOffSet").val();
//            var currentPage = $("#hidCurrentPage").val();
//
//            loadNextPage(offSet,currentPage);
        });
    });

</script>
<%--<input type="hidden" id="hidOffSet" value="<%=offSet%>">--%>
<%--<input type="hidden" id="hidCurrentPage" value="<%=currentPage%>">--%>
<%--<div id="divPager" style="width: 500px;">--%>
    <%--<div id="toolbar" class="ui-widget-header ui-corner-all">--%>
        <%--<button id="nextPage">Next Page</button>--%>
        <%--<label>Page <%=currentPage%> of <%=totalPages%></label>--%>
    <%--</div>--%>

<%--</div>--%>
<div id="divListings" class="page">
    <%
    for (PropertyDataDetail feed : dataFeedList.getList()) {


    %>
    <div class="ui-widget-content ui-corner-all ui-helper-clearfix"
         style="width: 500px;margin-top: 10px;margin-bottom: 10px">
        <div style="width:112px; float:left;">
            <div>
                <%
                    List<PropertyImageData> images = feed.getImageDataList();
                    if (images != null) {
                        if (images.size() != 0) {
                            PropertyImageData propertyImageData = images.get(0);
                %>
                <div id="divImg_<%=propertyImageData.getId()%>" class="ui-widget-content ui-corner-all"
                     style="width: 680px;height: 500px;position: absolute;left: 20%;top: 40%;display: none">
                    <div style="float: right">
                        <a id="btnImgClose_<%=propertyImageData.getId()%>" onclick="closeImagePopUp('<%=propertyImageData.getId()%>')"
                           class="ui-button ui-stateName-default ui-corner-all">
                            <span class="ui-icon ui-icon-close"></span></a>
                    </div>
                    <div style="width: 95%;height: 95%;margin-top: 20px;margin-left: 20px">
                        <img class="ui-corner-all" width="95%" height="95%" src="<%=propertyImageData.getImageUrl()%>">
                    </div>

                </div>
                <a title="<%=feed.getPropName()%>" onclick="loadPopUpImage('<%=propertyImageData.getId()%>')">
                    <img width="100" height="100" alt="<%=feed.getPropName()%>" src="<%=propertyImageData.getImageUrl()%>">
                </a>

                <%
                } else {
                %>
                <a title="<%=feed.getPropName()%>">
                    <img width="100" height="100" alt="<%=feed.getPropName()%>" src="">
                </a>
                <%
                    }
                } else {
                %>
                <a title="<%=feed.getPropName()%>">
                    <img width="100" height="100" alt="<%=feed.getPropName()%>" src="">
                </a>
                <%
                    }
                %>


            </div>
        </div>
        <div style="margin-left:112px;" class="ui-helper-clearfix">
            <div>
                <a href="loadProperty?propUId=<%=feed.getUuid()%>"><%=feed.getPropName()%>
                </a><span style="font-size: 12px">&nbsp;(<%=feed.getStatus()%>)</span>
            </div>
            <div>
                <div style="float: left">
                    <img src="../resources/images/phone_Icon.jpg"/>
                </div>
                <div style="margin-left: 30px;">
                    <div style="padding-top: 10px;padding-left: 10px">
                        <spring:message code="global.contact.number"/>
                    </div>
                </div>
            </div>
            <div>
                <%

                    String street = feed.getPropName();
                    String cityName = feed.getCity();
                    String stateName = feed.getState();
                    int zip = feed.getZip();

                %>
                <div style="float: left">
                    <img src="../resources/images/map.jpg"/>
                </div>
                <div style="margin-left: 30px;">
                    <div style="padding-top: 10px;padding-left: 10px;" class="ui-button">
                        <a onclick="loadGoogleMap('<%=street%>','<%=cityName%>','<%=stateName%>','<%=feed.getId()%>')"><%=feed.getPropName()%>
                        </a>
                    </div>
                </div>
                <div id="divMap_<%=feed.getId()%>" class="ui-widget-content ui-corner-all ui-helper-clearfix"
                     style="width: 800px; height: 800px;display: none;position: absolute;z-index: 1">
                    <div style="float: right">
                        <a id="btnMapClose_<%=feed.getId()%>" onclick="closeGoogleMap('<%=feed.getId()%>')"
                           class="ui-button ui-stateName-default ui-corner-all">
                            <span class="ui-icon ui-icon-close"></span></a>
                    </div>
                    <iframe id="ifMap_<%=feed.getId()%>" style="width: 95%;height: 95%;overflow: auto;margin-top: 10px;margin-left: 20px" frameBorder="0" scrolling="no"></iframe>
                    <%--<div id="divMapContent_<%=feed.getId()%>" class="ui-widget-content" style="width: 95%; height: 95%;margin-top: 10px;margin-left: 20px"></div>--%>
                    <%--<div id="map-canvas_<%=feed.getId()%>"--%>
                         <%--style="width: 95%; height: 95%;margin-top: 10px;margin-left: 20px"></div>--%>
                </div>
            </div>
        </div>
    </div>
    <%
        }
    %>


</div>

<div id="divPopUpImage" class="ui-widget-content ui-corner-all"
     style="width: 700px;height: 500px;position: relative;left: 20%;top: 40%">
    <img id="popUpImg" width="98%" height="98%">
</div>