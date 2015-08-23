<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>分类管理选择</title>
<link rel="stylesheet" href="<c:url value='/js/ztree/css/zTreeStyle/zTreeStyle.css'/>" type="text/css" charset="utf-8" />
<script type="text/javascript" language="javascript" src="<c:url value='/js/ztree/jquery.ztree.core-3.3.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript" src="<c:url value='/js/ztree/jquery.ztree.excheck-3.3.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript">
var setting = {check: {enable: true,chkStyle: "radio", radioType: "all"}, data: {simpleData: {enable: true}}};
var zNodes=<c:if test="${empty nodes}">[]</c:if><c:if test="${not empty nodes}">${nodes}</c:if>;
var code;

$(document).ready(function(){
	$.fn.zTree.init($("#treeMenu"), setting, zNodes);
});


function getSelectCategory(){
	var zTree = $.fn.zTree.getZTreeObj("treeMenu");
	var nodes=zTree.getCheckedNodes(true);
	if(nodes.length>0){
		var data={"id":"","name":""};
		data.id=nodes[0].id;
		data.name=nodes[0].name;
		return data;
	}else{
		alert("请选择分类");
		return false;
	}
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>分类管理列表</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"></h3>
	<div class="ntable_mid mT10" >
	    <ul id="treeMenu" class="ztree"></ul>
    </div>
</div>
</body>
</html>

