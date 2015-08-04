<%@ include file="/WEB-INF/views/layouts/taglibs.jsp" %>
<%@ include file="/WEB-INF/views/layouts/includes.jsp" %>
<html>
    <link rel="stylesheet" href="<c:url value="resources/css/jquery-ui-1.10.2.custom.css" />" type="text/css">
    <link rel="stylesheet" href="<c:url value="resources/css/main.css" /> " type="text/css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

    <script type="text/javascript">

        $(document).ready(function () {

            $('body').bind('ajaxSuccess', function (event, request, settings) {

                if (request.status == 0) {
                    // lets clean up some cookies
                    $.cookie("pdp-custId", null, { path:'/' });
                    $.cookie("pdp-sessionId", null, { path:'/' });
                    $('#alert-msg').html('<spring:message code="error.sessionTimeout"/>');
                    $('#alertDiv').dialog('open');
                    setTimeout("window.location.href='index'", 4000);
                    $("#appActions").css("display","block");
                }

            });

            $("#alertDiv").dialog({
                autoOpen:false,
                resizable:false,
                height:160,
                modal:true,
                title:'<spring:message code="dialog.alert.title"/>',
                buttons:{
                    "<spring:message code="dialog.alert.close"/>":function () {
                        $(this).dialog("close");
                    }
                }
            });

            $("#appActions a").click(function() {
                // we need to load up the homeController index page
                alert("test");
                location = "home";
                return false;
            });


        });
    </script>
<body>
<div id="alertDiv" style="display:none">
    <p id="alert-msg"></p>
</div>
<div id="appActions" style="display: block;">
    <p style="margin-bottom: 5px;margin-top: 5px;">
        <a id="nodeStartActionLink" class="link_btn  ui-button ui-stateName-default ui-corner-all">
            <span class="ui-icon ui-icon-play"></span>Login</a>
    </p>
</div>
</body>
</html>
