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
-->

<script>
    var language="<%=lang%>";
</script>

<%-- Style Sheet Include Referances--%>
<link rel="stylesheet" href="<c:url value="/resources/css/header.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/button.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/grid.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/panel.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/template.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/table.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/ui.jqgrid.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/container.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/theme/dark-hive/jquery-ui-1.10.3.custom.min.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/thirdParty/fb/jquery.fancybox.css?v=2.1.4" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/fbox.css" />" type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/menu.css" />" type="text/css">


<%-- Java Script Include References--%>

<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-1.9.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-ui-1.10.3.custom.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/i18n/grid.locale-en.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.jqGrid.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-ui-1.10.2.custom.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery.cookie.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/tabs.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/purl.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/thirdParty/fb/jquery.fancybox.js?v=2.1.4" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/app/propView.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/app/pageGenerator.js" />"></script>

