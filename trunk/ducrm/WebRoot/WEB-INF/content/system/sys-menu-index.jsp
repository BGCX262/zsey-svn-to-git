<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>功能菜单管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>功能菜单管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/system/sys-menu/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		菜单名称: <input class="input" type="text" name="vo.enName" value="${vo.enName}" size="20"/>&nbsp;&nbsp;
		显示名称: <input class="input" type="text" name="vo.chName" value="${vo.chName}" size="20"/>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
		<input type="button" class="btn" value="添加" onclick="location.href='<c:url value='/system/sys-menu/edit.jhtml'/>'"/>
	</div>
	</form>

    <div class="ntable_mid mT5">
			<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
                <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
				<display:column title="菜单名称" style="width:200px;">${vo.enName}</display:column>
				<display:column title="显示名称" style="width:150px;">${vo.chName}</display:column>
				<display:column title="所属菜单" style="width:150px;">${vo.parentMenu.chName}</display:column>
				<display:column title="链接地址">${vo.href}</display:column>
				<display:column title="操作" style="width:100px;">
					<span class="caozuo">
						<a href="<c:url value='/system/sys-menu/edit.jhtml?id=${vo.id}' />" class="edit">编辑</a>&nbsp;|&nbsp;
						<a href="<c:url value='/system/sys-menu/delete.jhtml?id=${vo.id}' />" class="del">删除</a>
					</span>
				</display:column>
				<display:setProperty name="paging.banner.item_name">功能菜单</display:setProperty>
				<display:setProperty name="paging.banner.items_name">功能菜单</display:setProperty>
			</display:table>
	</div>

</div>
</body>
</html>

