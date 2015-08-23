<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>提示信息</title>
		<link rel="stylesheet" type="text/css" href="<c:url value='/style/css/iso.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/style/displaytag/default.css'/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value='/style/css/nform.css' />" />
		<script type="text/javascript">
		function goBack() {
			location.href = "<c:url value='/system/main/studentmain.jhtml'/>";
		}
	</script>
	</head>
	<body>
		<div id="tip_wrapper">
			<div id="tipbox">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="100" rowspan="3" align="center"><img src="<c:url value='/style/images/icon_se.png'/>" /></td>
						<td><h2 id="tip_title">提示信息</h2></td>
					</tr>
					<tr><td><p><s:actionmessage /></p></td></tr>
					<tr><td><div class="tip_control"><input type="button" class="nbtn_01" value="返回" onClick="goBack()" /></div></td></tr>
				</table>
			</div>
		</div>
	</body>
</html>