<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工列表</title>
<script type="text/javascript" language="javascript">
/**
 * 功能：返回选中的员工信息（用英文的竖枉“|”分隔）
 * 返回：员工ID0|员工编号1|员工姓名2|性别值3|性别文本4|部门ID5|部门名称6|职务ID7|职务名称8|电话9|手机10
 */
function getSelectEmployee(){
	var employee={"id":"","code":"","name":"","sex":"","dutyId":"","dutyName":"","departId":"","departName":"phone","mobile":"postcode","provId":"provName","cityId":"","cityName":"","address":""};
	var data=$("input[type='radio'][name='items']:checked").val();
	var empArray=data.split("|");
	employee.id=empArray[0];
	employee.code=empArray[1];
	employee.name=empArray[2];
	employee.sex=empArray[4];
	employee.dutyId=empArray[7];
	employee.dutyName=empArray[8];
	employee.departId=empArray[5];
	employee.departName=empArray[6];
	employee.phone=empArray[9];
	employee.mobile=empArray[10];
	employee.postcode="";
	employee.provId="";
	employee.provName="";
	employee.cityId="";
	employee.cityName="";
	employee.address="";
	return employee;
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>员工列表</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/basic/employee/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		编号: <input class="input" type="text" name=vo.code value="${vo.code}" size="20"/>&nbsp;&nbsp;
		姓名: <input class="input" type="text" name="vo.name" value="${vo.name}" size="20"/>&nbsp;&nbsp;
		性别: <select name="vo.sex">
			<option value="" <c:if test="${empty vo.sex }">selected="selected"</c:if>>---请选择---</option>
			<c:forEach var="xb" items="${sexs}">
				<option value="${xb }" <c:if test="${vo.sex==xb }">selected="selected"</c:if>>${xb.text }</option>
			</c:forEach>
		</select><br />
		部门: <select name="vo.department.id">
			<option value="" <c:if test="${empty vo.department.id }">selected="selected"</c:if>>---请选择---</option>
			<c:forEach var="depart" items="${departList}">
				<option value="${depart.id }" <c:if test="${vo.department.id==depart.id }">selected="selected"</c:if>>${depart.name }</option>
			</c:forEach>
		</select>&nbsp;&nbsp;
		职务: <select name="vo.duty.id">
			<option value="" <c:if test="${empty vo.duty.id }">selected="selected"</c:if>>---请选择---</option>
			<c:forEach var="zw" items="${dutyList}">
				<option value="${zw.id }" <c:if test="${vo.duty.id==zw.id }">selected="selected"</c:if>>${zw.name }</option>
			</c:forEach>
		</select>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
	</div>
	</form>

    <div class="ntable_mid mT5">
			<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
                <display:column title="" style="width:30px;">
                	<input name="items" type="radio" value="${vo.id}|${vo.code}|${vo.name}|${vo.sex}|${vo.sex.text}|${vo.department.id}|${vo.department.name}|${vo.duty.id}|${vo.duty.name}|${vo.phone}|${vo.mobile}" />
                </display:column>
                <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
				<display:column title="员工编号" style="width:80px;">${vo.code}</display:column>
				<display:column title="姓名">${vo.name}</display:column>
				<display:column title="性别" style="width:40px;">${vo.sex.text}</display:column>
				<display:column title="职务">${vo.duty.name}</display:column>
				<display:column title="部门">${vo.department.name}</display:column>
				<display:column title="电话">${vo.phone}</display:column>
				<display:column title="手机">${vo.mobile}</display:column>
				<display:setProperty name="paging.banner.item_name">员工</display:setProperty>
				<display:setProperty name="paging.banner.items_name">员工</display:setProperty>
			</display:table>
	</div>
</div>
</body>
</html>

