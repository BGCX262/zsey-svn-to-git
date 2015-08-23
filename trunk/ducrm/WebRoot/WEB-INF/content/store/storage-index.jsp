<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>库存管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>库存管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/store/storage/index.jhtml'/>" method="post">
	    <div class="frmBar mT5">
			名称: <input class="input" type="text" name="vo.name" value="${vo.name}" size="20"/>&nbsp;&nbsp;
			<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
			<input type="button" class="btn" value="添加" onclick="location.href='<c:url value='/store/storage/edit.jhtml'/>'"/>
		</div>
	</form>

    <div class="ntable_mid mT5">
			<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
                <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
				<display:column title="名称">${vo.name}<c:if test="${vo.sort=='PRODUCT' }">&nbsp;&nbsp;${vo.size}</c:if></display:column>
				<display:column title="数量" style="width:100px;"><fmt:parseNumber type="number" pattern="##0.00">${vo.amount}</fmt:parseNumber></display:column>
				<display:column title="上限" style="width:100px;"><fmt:parseNumber type="number" pattern="##0.00">${vo.up}</fmt:parseNumber></display:column>
				<display:column title="下限" style="width:100px;"><fmt:parseNumber type="number" pattern="##0.00">${vo.down}</fmt:parseNumber></display:column>
				<display:column title="操作" style="width:100px;">
					<span class="caozuo">
						<a href="edit.jhtml?id=${vo.id}" class="edit">编辑</a>&nbsp;|&nbsp;
						<a href="delete.jhtml?id=${vo.id}" class="del">删除</a>
					</span>
				</display:column>
				<display:setProperty name="paging.banner.item_name">库存</display:setProperty>
				<display:setProperty name="paging.banner.items_name">库存</display:setProperty>
			</display:table>
	</div>

</div>
</body>
</html>