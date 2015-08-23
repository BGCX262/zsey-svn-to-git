<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工作报告管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>工作报告管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/produce/work-report/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		员工编号: <input class="input" type="text" name=vo.employee.code value="${vo.employee.code}" />&nbsp;&nbsp;
		姓名: <input class="input" type="text" name=vo.employee.name value="${vo.employee.name}" />&nbsp;&nbsp;
		日期从: <input class="input" type="text" name=vo.startTime value="${vo.startTime}" readonly="readonly" onclick="WdatePicker()" />&nbsp;&nbsp;
		日期到: <input class="input" type="text" name=vo.endTime value="${vo.endTime}" readonly="readonly" onclick="WdatePicker()" />&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
		<input type="button" class="btn" value="添加" onclick="location.href='<c:url value='/produce/work-report/edit.jhtml'/>'"/>
	</div>
	</form>

    <div class="ntable_mid mT5">
		<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
			<display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
			<display:column title="员工编号" style="width:80px;">${vo.employee.code}</display:column>
			<display:column title="姓名" style="width:80px;">${vo.employee.name}</display:column>
			<display:column title="名称">${vo.name}</display:column>
			<display:column title="价格" style="width:80px;"><fmt:parseNumber type="number" pattern="##0">${vo.amount}</fmt:parseNumber></display:column>
			<display:column title="数量" style="width:80px;"><fmt:parseNumber type="number" pattern="##0.00">${vo.price}</fmt:parseNumber></display:column>
			<display:column title="金额" style="width:80px;"><fmt:parseNumber type="number" pattern="##0.00">${vo.total}</fmt:parseNumber></display:column>
			<display:column title="日期" style="width:80px;">${vo.addDate}</display:column>
			<display:column title="操作" style="width:150px;">
				<span class="caozuo">
					<a href="javascript:void(null);" onclick="openDialog('details.jhtml?id=${vo.id}','${vo.employee.name }的工序报告');" class="show">详情</a>
					&nbsp;|&nbsp;<a href="edit.jhtml?id=${vo.id}" class="edit">编辑</a>
					&nbsp;|&nbsp;<a href="delete.jhtml?id=${vo.id}" class="del">删除</a>
				</span>
			</display:column>
			<display:setProperty name="paging.banner.item_name">工作报告</display:setProperty>
			<display:setProperty name="paging.banner.items_name">工作报告</display:setProperty>
		</display:table>
	</div>

</div>
</body>
</html>

