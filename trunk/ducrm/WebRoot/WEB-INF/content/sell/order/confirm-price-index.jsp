<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>报价确认管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>报价确认管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/sell/order/confirm-price/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		编号: <input class="input" type="text" name=vo.code value="${vo.code}"/>&nbsp;&nbsp;
		客户名称: <input class="input" type="text" name="vo.name" value="${vo.name}"/>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
	</div>
	</form>

    <div class="ntable_mid mT5">
		<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
			<display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
			<display:column title="编号" style="width:100px;">${vo.code}</display:column>
			<display:column title="客户名称">${vo.name}</display:column>
			<display:column title="联系人" style="width:80px;">${vo.linkman}</display:column>
			<display:column title="总额" style="width:80px;"><fmt:parseNumber type="number" pattern="##0.00">${vo.payment}</fmt:parseNumber></display:column>
			<display:column title="操作" style="width:100px;">
				<span class="caozuo">
					<a href="javascript:void(null);" onclick="openDialog('<c:url value="/sell/order/product-price/details.jhtml?id=${vo.id}"/>','${vo.code }产品报价详情');" class="show">详情</a>
					&nbsp;|&nbsp;<a href="edit.jhtml?id=${vo.id}" class="edit">确认</a>
				</span>
			</display:column>
			<display:setProperty name="paging.banner.item_name">报价确认</display:setProperty>
			<display:setProperty name="paging.banner.items_name">报价确认</display:setProperty>
		</display:table>
	</div>

</div>
</body>
</html>

