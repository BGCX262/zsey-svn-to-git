<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>字典项管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>字典项管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/system/sys-dict/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		编号: <input class="input" type="text" name="vo.code" value="${vo.code}" maxlength="4" />&nbsp;&nbsp;
		名称: <input class="input" type="text" name="vo.name" value="${vo.name}" maxlength="10" />&nbsp;&nbsp;
		类型：<select name="vo.sort">
			<option value="" <c:if test="${empty vo.sort}">selected="selected"</c:if>>---请选择---</option>
			<c:forEach var="sort" items="${sorts}">
				<option value="${sort }" <c:if test="${vo.sort== sort}">selected="selected"</c:if>>${sort.text }</option>
			</c:forEach>
		</select>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
		<input type="button" class="btn" value="添加" onclick="location.href='<c:url value='/system/sys-dict/edit.jhtml'/>'"/>
	</div>
	</form>

    <div class="ntable_mid mT5">
			<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
                <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
				<display:column title="编号" style="width:100px;">${vo.code}</display:column>
				<display:column title="名称" style="width:250px;">${vo.name}</display:column>
				<display:column title="类型" style="width:100px;">${vo.sort.text}</display:column>
				<display:column title="备注">${vo.caption}</display:column>
				<display:column title="操作" style="width:100px;">
					<span class="caozuo">
						<a href="edit.jhtml?id=${vo.id}" class="edit">编辑</a>&nbsp;|&nbsp;
						<a href="delete.jhtml?id=${vo.id}" class="del">删除</a>
					</span>
				</display:column>
				<display:setProperty name="paging.banner.item_name">字典项</display:setProperty>
				<display:setProperty name="paging.banner.items_name">字典项</display:setProperty>
			</display:table>
	</div>

</div>
</body>
</html>

