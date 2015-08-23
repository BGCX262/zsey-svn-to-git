<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料管理</title>
<script language="javascript" type="text/javascript">
/**
 * 返回选中的产品信息
 */
function getSelect(){
	var obj={"id":"","code":"","name":"","price":""};
	var data=$("input[type='radio'][name='items']:checked").val();
	var array=data.split("|");
	obj.id=array[0];
	obj.code=array[1];
	obj.name=array[2];
	obj.price=array[3];
	return obj;
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>物料管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/basic/material/single.jhtml'/>" method="post">
    <div class="frmBar mT5">
		编&nbsp;&nbsp;&nbsp;&nbsp;号: <input class="input" type="text" name=vo.code value="${vo.code}"  maxlength="9" />&nbsp;&nbsp;
		名&nbsp;&nbsp;&nbsp;&nbsp;称: <input class="input" type="text" name="vo.name" value="${vo.name}" />&nbsp;&nbsp;
		供应商: <input class="input" type="text" name="vo.provider.name" value="${vo.provider.name}" />&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />
	</div>
	</form>

    <div class="ntable_mid mT5">
		<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="single.jhtml">
			<display:column title="" style="width:30px;">
       			<input name="items" type="radio" value="${vo.id}|${vo.code}|${vo.name}|${vo.price}" />
      		</display:column>
			<display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
			<display:column title="编号" style="width:80px;">${vo.code}</display:column>
			<display:column title="供应商" style="width:200px;">${vo.provider.name}</display:column>
			<display:column title="名称">${vo.name}</display:column>
			<display:column title="规格" style="width:80px;">${vo.spec}</display:column>
			<display:setProperty name="paging.banner.item_name">物料</display:setProperty>
			<display:setProperty name="paging.banner.items_name">物料</display:setProperty>
		</display:table>
	</div>
</div>
</body>
</html>

