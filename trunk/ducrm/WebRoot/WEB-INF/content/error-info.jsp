<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统异常</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/css/iso.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/displaytag/default.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/css/nform.css' />" />
</head>
<body>

<div id="tip_wrapper">
<div id="tipbox">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="100" rowspan="3" align="center"><img src="<c:url value='/style/images/icon_error.png'/>" /></td>
    <td><h2 id="error_title">ERROR</h2></td>
  </tr>
  <tr>
    <td><p><s:actionmessage /></p></td>
  </tr>
  <tr>
    <td>
    <div class="tip_control">
</div>
    </td>
  </tr>
</table>

</div>
</div>
</body>
</html>