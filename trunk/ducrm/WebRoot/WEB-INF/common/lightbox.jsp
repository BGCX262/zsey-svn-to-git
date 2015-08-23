<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery-lightbox/css/jquery.lightbox-0.5.css'/>" media="screen" charset="utf-8" />
<script language="javascript" type="text/javascript" src="<c:url value='/js/jquery-lightbox/js/jquery.lightbox-0.5.js' />" charset="utf-8"></script>
<script language="javascript" type="text/javascript">
$(function() {$('#lightBoxTbody img').lightBox();});
</script>