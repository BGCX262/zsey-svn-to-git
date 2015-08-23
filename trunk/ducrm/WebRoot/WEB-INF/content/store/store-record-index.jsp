<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>仓库管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/store/store-record/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		名称：<input class="input" type="text" name="vo.name" value="${vo.name}" size="20"/>&nbsp;&nbsp;
		仓库：<select name="vo.storeId">
			<option value="" <c:if test="${empty vo.storeId}">selected="selected"</c:if>>---请选择---</option>
			<c:forEach var="store" items="${storeList }">
				<option value="${store.id }" <c:if test="${store.id==vo.storeId}">selected="selected"</c:if>>${store.name }</option>
			</c:forEach>
		</select>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
	</div>
	</form>

    <div class="ntable_mid mT5">
			<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
                <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
				<display:column title="仓库" style="width:100px;">${vo.storeName}</display:column>
				<display:column title="名称及规格">${vo.name}</display:column>
				<display:column title="数量" style="width:100px;">${vo.amount}</display:column>
				<display:column title="操作节点" style="width:100px;">${vo.sort.text}</display:column>
				<display:column title="操作人" style="width:80px;">${vo.addName}</display:column>
				<display:column title="操作时间" style="width:120px;">${vo.createTime}</display:column>
				<display:column title="操作" style="width:50px;">
					<span class="caozuo">
						<a href="delete.jhtml?id=${vo.id}'" class="del">删除</a>
					</span>
				</display:column>
				<display:setProperty name="paging.banner.item_name">仓库</display:setProperty>
				<display:setProperty name="paging.banner.items_name">仓库</display:setProperty>
			</display:table>
	</div>

</div>
</body>
</html>

