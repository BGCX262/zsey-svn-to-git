<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工序管理</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/style/css/selectDiv.css'/>" charset="utf-8" />
<script type="text/javascript" language="javascript" src="<c:url value='/js/selectCheckBox.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript">
window.onload = function(){
	var data = parent.kt_init_work_datas();
	kt_init(data);
};
</script>
</head>
<body>
<div style="height:400px !important;overflow:hidden;">
	<div id="formbody" style="padding:0px;">
		<div id="kt_lstItems" style="min-height:70px;max-height:70px;border:1px grey solid;overflow-y:auto;background-color: white;margin-bottom: 8px;"></div>
		<iframe id="listframe" name="listframe"  src="<c:url value='/utils/work/multi.jhtml'/>" width="100%" height="300px" frameborder="none" scrolling-y="none"></iframe>
	</div>
</div>
</body>
</html>

