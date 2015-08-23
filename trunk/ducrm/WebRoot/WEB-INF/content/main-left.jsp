<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜单</title>
<link href="<c:url value='/style/css/iso.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/js/jquery-1.4.4.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.treeview.pack.js'/>"></script>
<script type="text/javascript">
$(document).ready(function(){
	<c:forEach var="fun" items="${menuList}" varStatus="idx">
		dealTree('${fun.id}','${fun.parentMenu.id}','${fun.chName}','<c:url value="${fun.href}"/>');
    </c:forEach>

	$("#tree1").treeview({
		persist: "location",
		collapsed: true,
		unique: true
	});
	$("#tree1>li").click(function(){
		$("#tree1>li").removeClass("open");
		$(this).addClass("open");
	});

	$("#tree1 ul>li").click(function(){
		$("#tree1 ul li").removeClass("curr");
		$(this).addClass("curr");
	});

	$("#tree1 ul ul li").click(function(){
		$("#tree1 ul ul li").find("a").removeClass("curr");
		$(this).find("a").addClass("curr");
	});
});

var content = "";
function dealTree(id,par,funcName,link){
	if(par == ''){
		$("#tree1").append("<li id='li"+id+"'><span class='side_li'>"+funcName+"</span></li>");
	}else{
		if($("#ul"+par).size()==0){
			$("#li"+par).append("<ul id='ul"+par+"'></ul>");
		}
		if(link.length == 0)content = funcName;
		else content = "<a href='"+link+"'  target='mainFrame'>"+funcName+"</a>";
		$("#ul"+par).append("<li id='li"+id+"'><span>"+content+"</span></li>");
	}
}
</script>
</head>
<body id="sidebg">
<div id="sidebar">
    <div id="sidebar_t"> <img src="<c:url value='/style/images/menu.gif'/>" /></div>
    <div id="sidebar_m">
        <ul id="tree1" class="treeview">

		</ul>
	</div>
    <div id="sidebar_b"></div>
</div>
</body>


</html>
