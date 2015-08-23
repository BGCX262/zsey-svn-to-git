<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>供应商管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/area/area.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript" src="<c:url value='/js/linkman/linkman.js'/>" charset="utf-8"></script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>供应商管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/basic/provider/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		编号: <input class="input" type="text" name=vo.code value="${vo.code}"/>&nbsp;&nbsp;
		名称: <input class="input" type="text" name="vo.name" value="${vo.name}"/>&nbsp;&nbsp;
		省份: <select name="vo.province.id" onchange="ajaxFindArea(this.value)">
			<option value="" <c:if test="${empty vo.province.id }">selected="selected"</c:if>>---请选择---</option>
			<c:forEach var="province" items="${provinceList}">
				<option value="${province.id }" <c:if test="${vo.province.id==province.id }">selected="selected"</c:if>>${province.name }</option>
			</c:forEach>
		</select>&nbsp;&nbsp;
		城市: <select id="selectArea" name="vo.city.id">
			<option value="" <c:if test="${empty vo.city.id }">selected="selected"</c:if>>---请选择---</option>
			<c:forEach var="city" items="${cityList}">
				<option value="${city.id }" <c:if test="${vo.city.id==city.id }">selected="selected"</c:if>>${city.name }</option>
			</c:forEach>
		</select>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
		<input type="button" class="btn" value="添加" onclick="location.href='<c:url value='/basic/provider/edit.jhtml'/>'"/>
	</div>
	</form>

    <div class="ntable_mid mT5">
			<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
                <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
				<display:column title="编号" style="width:80px;">${vo.code}</display:column>
				<display:column title="名称">${vo.name}</display:column>
				<display:column title="联系人" style="width:100px;">${vo.linkman}</display:column>
				<display:column title="电话" style="width:100px;">${vo.phone}</display:column>
				<display:column title="传真" style="width:100px;">${vo.fax}</display:column>
				<display:column title="操作" style="width:200px;">
					<span class="caozuo">
						<a href="#" onclick="openDialog('details.jhtml?id=${vo.id}','供应商详情');" class="show">详情</a>&nbsp;|&nbsp;
						<a href="edit.jhtml?id=${vo.id}" class="edit">编辑</a>&nbsp;|&nbsp;
						<a href="delete.jhtml?id=${vo.id}" class="del">删除</a>&nbsp;|&nbsp;
						<a href="#" onclick="openLinkManAdminDialog('<c:url value='/basic/linkman/index.jhtml?vo.sort=PROVIDER&vo.dataId=${vo.id}'/>');" class="edit">联系人</a>
					</span>
				</display:column>
				<display:setProperty name="paging.banner.item_name">供应商</display:setProperty>
				<display:setProperty name="paging.banner.items_name">供应商</display:setProperty>
			</display:table>
	</div>

</div>
</body>
</html>

