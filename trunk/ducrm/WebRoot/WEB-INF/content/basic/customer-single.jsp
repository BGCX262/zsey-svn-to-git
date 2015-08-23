<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/area/area.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript">
function getSelectSingleCustomer(){
	var result={"id":"","code":"","name":"","shortName":"","fax":"","phone":"","linkman":"","tel":"","mobile":"","province":"","city":"","address":"","postcode":"","email":"","qq":""};
	var data=$("input[type='radio'][name='cid']:checked").val();
	var vals=data.split("|");
	result.id=vals[0];
	result.code=vals[1];
	result.name=vals[2];
	result.phone=vals[3];
	result.fax=vals[4];
	result.linkman=vals[5];
	result.tel=vals[6];
	result.mobile=vals[7];
	result.province=vals[8];
	result.city=vals[9];
	result.address=vals[10];
	result.postcode=vals[11];
	return result;
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>客户管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/basic/customer/single.jhtml'/>" method="post">
    <div class="frmBar mT5">
		编号: <input class="input" type="text" name=vo.code value="${vo.code}" style="width: 192px;"/>&nbsp;&nbsp;
		名称: <input class="input" type="text" name="vo.name" value="${vo.name}" style="width: 192px;"/><br />
		省份: <select name="vo.province.id" onchange="ajaxFindArea(this.value)" style="width: 200px;">
			<option value="" <c:if test="${empty vo.province.id }">selected="selected"</c:if>>---请选择---</option>
			<c:forEach var="province" items="${provinceList}">
				<option value="${province.id }" <c:if test="${vo.province.id==province.id }">selected="selected"</c:if>>${province.name }</option>
			</c:forEach>
		</select>&nbsp;&nbsp;
		城市: <select id="selectArea" name="vo.city.id" style="width: 200px;">
			<option value="" <c:if test="${empty vo.city.id }">selected="selected"</c:if>>---请选择---</option>
			<c:forEach var="city" items="${cityList}">
				<option value="${city.id }" <c:if test="${vo.city.id==city.id }">selected="selected"</c:if>>${city.name }</option>
			</c:forEach>
		</select>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />
	</div>
	</form>

    <div class="ntable_mid mT5">
		<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="single.jhtml">
			<display:column media="html" title="" style="width:20px">
				<input type="radio" name="cid" value="${vo.id}|${vo.code}|${vo.name}|${vo.phone}|${vo.fax}|${vo.linkman}|${vo.tel}|${vo.mobile}|${vo.province.name}|${vo.city.name}|${vo.address}|${vo.postcode}"/>
			</display:column>
			<display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
			<display:column title="编号" style="width:80px;">${vo.code}</display:column>
			<display:column title="名称">${vo.name}</display:column>
			<display:column title="联系人" style="width:100px;">${vo.linkman}</display:column>
			<display:column title="电话" style="width:100px;">${vo.phone}</display:column>
			<display:column title="传真" style="width:100px;">${vo.fax}</display:column>
			<display:setProperty name="paging.banner.item_name">客户</display:setProperty>
			<display:setProperty name="paging.banner.items_name">客户</display:setProperty>
		</display:table>
	</div>
</div>
</body>
</html>

