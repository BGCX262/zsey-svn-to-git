<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统用户管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>系统用户管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/system/sys-user/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		用户名: <input class="input" type="text" name="vo.username" value="${vo.username}" size="20"/>&nbsp;&nbsp;
		姓名: <input class="input" type="text" name="vo.employee.name" value="${vo.employee.name}" size="20"/>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
		<input type="button" class="btn" value="添加" onclick="location.href='<c:url value='/system/sys-user/edit.jhtml'/>'"/>
	</div>
	</form>

    <div class="ntable_mid mT5">
			<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
                <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
				<display:column title="用户名" style="width:100px;">${vo.username}</display:column>
				<display:column title="姓名" style="width:120px;">${vo.employee.name}</display:column>
				<display:column title="部门" style="width:120px;">${vo.employee.department.name}</display:column>
				<display:column title="电话" style="width:120px;">${vo.employee.phone}</display:column>
				<display:column title="手机" style="width:120px;">${vo.employee.mobile}</display:column>
				<display:column title="操作" style="width:100px;">
					<span class="caozuo">
						<a href="<c:url value='/system/sys-user/edit.jhtml?id=${vo.id}' />" class="edit">编辑</a>&nbsp;|&nbsp;
						<a href="<c:url value='/system/sys-user/delete.jhtml?id=${vo.id}' />" class="del">删除</a>
					</span>
				</display:column>
				<display:setProperty name="paging.banner.item_name">系统用户</display:setProperty>
				<display:setProperty name="paging.banner.items_name">系统用户</display:setProperty>
			</display:table>
	</div>

</div>
</body>
</html>

