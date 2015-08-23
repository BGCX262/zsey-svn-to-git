<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>功能菜单授权</title>
<link rel="stylesheet" href="<c:url value='/js/ztree/css/zTreeStyle/zTreeStyle.css'/>" type="text/css" charset="utf-8" />
<script type="text/javascript" src="<c:url value='/js/ztree/jquery.ztree.core-3.3.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ztree/jquery.ztree.excheck-3.3.js'/>"></script>
<script type="text/javascript" language="javascript">
var setting = {check: {enable: true},data: {simpleData: {enable: true}}};
var zNodes=<c:if test="${empty nodes}">[]</c:if><c:if test="${not empty nodes}">${nodes}</c:if>;
var code;

$(document).ready(function(){
	$.fn.zTree.init($("#treeMenu"), setting, zNodes);
});

function selectAll(){
	$.fn.zTree.getZTreeObj("treeMenu").checkAllNodes(true);
}

function selectCancel(){
	$.fn.zTree.getZTreeObj("treeMenu").checkAllNodes(false);
}

function grantFormSubmit(){
	var zTree = $.fn.zTree.getZTreeObj("treeMenu");
	var nodes=zTree.getCheckedNodes(true);
	
	if(nodes.length>0){
		var menus="";
		for(var i=0;i<nodes.length;i++){
			if($.trim(nodes[i].id)!=""){
				menus+=($.trim(nodes[i].id)+",");
			}
		}
		$("#menus").val(menus);
		document.form1.submit();
	}else{
		alert("请选择要授权的功能菜单");
		return false;
	}
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>功能菜单授权</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"></h3>
<form name="form1" action="<c:url value='/system/sys-menu/saveGrant.jhtml' />" method="post">
	<div class="ntable_mid mT10" >
		<input type="button" onclick="selectAll()" value="全选" />
	    <input type="button" onclick="selectCancel()" value="取消" />
	    <input id="menus" name="menus" type="hidden" value="" />
	    <input name="id" type="hidden" value="${id }" />
	    <ul id="treeMenu" class="ztree"></ul>
    </div>
</form>
</div>
</body>
</html>

