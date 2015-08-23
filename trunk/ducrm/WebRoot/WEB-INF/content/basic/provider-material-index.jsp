<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/area/area.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript" src="<c:url value='/js/linkman/linkman.js'/>" charset="utf-8"></script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>物料管理</strong></h2>
    </div>
    
    <form name="form1" action="<c:url value='/basic/provider/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		名称: ${vo.name}&nbsp;&nbsp;
		<input type="button" class="btn" value="添加" onclick="location.href='<c:url value='/basic/provider/edit.jhtml'/>'"/>
	</div>
	</form>

    <div class="ntable_mid mT5">
		<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
               <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
			<display:column title="编号" style="width:80px;">${vo.material.code}</display:column>
			<display:column title="名称">${vo.material.name}</display:column>
			<display:column title="型号">${vo.material.model}</display:column>
			<display:column title="规格">${vo.material.spec}</display:column>
			<display:column title="单位">${vo.material.unit.name}</display:column>
			<display:column title="价格"><fmt:parseNumber type="number" pattern="##0.00">${vo.material.price}</fmt:parseNumber></display:column>
			<display:column title="操作" style="width:100px;">
				<span class="caozuo">
					<a href="edit.jhtml?id=${vo.id}" class="edit">编辑</a>&nbsp;|&nbsp;
					<a href="delete.jhtml?id=${vo.id}" class="del">删除</a>&nbsp;|&nbsp;
				</span>
			</display:column>
			<display:setProperty name="paging.banner.item_name">物料</display:setProperty>
			<display:setProperty name="paging.banner.items_name">物料</display:setProperty>
		</display:table>
	</div>

</div>
</body>
</html>

