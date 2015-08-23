<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>供应商管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/area/area.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript" src="<c:url value='/js/linkman/linkman.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript">
/**
 * 功能：返回选中的供应商信息（用英文的竖枉“|”分隔）
 * 返回：ID0|编号1|姓名2|电话3|传真4|联系人5|联系人电话6|联系人手机7
 */
function getSelectProvider(){
	var provider={"id":"","code":"","name":"","phone":"","fax":"","linkman":"","tel":"","mobile":"","province":"","city":"","address":"","postcode":""};
	var data=$("input[type='radio'][name='items']:checked").val();
	var array=data.split("|");
	provider.id=array[0];
	provider.code=array[1];
	provider.name=array[2];
	provider.phone=array[3];
	provider.fax=array[4];
	provider.linkman=array[5];
	provider.tel=array[6];
	provider.mobile=array[7];
	provider.province=array[8];
	provider.city=array[9];
	provider.address=array[10];
	provider.postcode=array[11];
	return provider;
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>供应商管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/basic/provider/single.jhtml'/>" method="post">
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
	</div>
	</form>

    <div class="ntable_mid mT5">
		<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
            <display:column title="" style="width:30px;">
            	<input name="items" type="radio" value="${vo.id}|${vo.code}|${vo.name}|${vo.phone}|${vo.fax}|${vo.linkman}|${vo.tel}|${vo.mobile}|${vo.province.name}|${vo.city.name}|${vo.address}|${vo.postcode}" />
            </display:column>
            <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
			<display:column title="编号" style="width:80px;">${vo.code}</display:column>
			<display:column title="名称">${vo.name}</display:column>
			<display:column title="联系人" style="width:100px;">${vo.linkman}</display:column>
			<display:column title="电话" style="width:100px;">${vo.phone}</display:column>
			<display:setProperty name="paging.banner.item_name">供应商</display:setProperty>
			<display:setProperty name="paging.banner.items_name">供应商</display:setProperty>
		</display:table>
	</div>
</div>
</body>
</html>

