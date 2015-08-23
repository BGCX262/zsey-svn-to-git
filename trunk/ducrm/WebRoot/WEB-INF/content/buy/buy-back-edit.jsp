<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>退回审核管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>退回审核管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">退回审核</h3>
<form name="form1" action="<c:url value='/buy/buy-back/audit.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10">
        <table width="100%" class="nt_table">
			<tr>
                <td class="gray" width="100" height="40" align="right">供应商：</td>
                <td>${vo.name }</td>
                <td class="gray" width="100" height="40" align="right">单位电话：</td>
                <td>${vo.phone }</td>
                <td class="gray" width="100" height="40" align="right">单位传真：</td>
                <td>${vo.fax }</td>
            </tr>
			<tr>
                <td class="gray"  height="40" align="right">联系人：</td>
                <td>${vo.linkman }</td>
                <td class="gray"  height="40" align="right">联系人电话：</td>
                <td>${vo.tel }</td>
                <td class="gray"  height="40" align="right">联系人手机：</td>
                <td>${vo.mobile }</td>
            </tr>
			<tr>
                <td class="gray"  height="40" align="right">地址：</td>
                <td>${vo.address }</td>
                <td class="gray"  height="40" align="right">邮编：</td>
                <td colspan="3">${vo.postcode }</td>
            </tr>
            <tr>
                <td class="gray"  height="40" align="right">采购单号：</td>
                <td colspan="5">${vo.code }</td>
			</tr>
        </table>
    </div>
	
    <fieldset class="tableBox">
    	<legend><strong>订单明细</strong></legend>
    	<table width="100%" class="nm_table">
			<thead>
				<tr class="gray" align="center">
					<th>序号</th>
					<th>名称及规格</th>
					<th>单位</th>
					<th>数量</th>
					<th>单价</th>
					<th>金额</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="details" items="${orderList}" varStatus="status">
				<tr id="tr" align="center">
					<td width="30">${status.count }<input name="ids" type="hidden" value="${details.id }" /></td>
					<td><c:if test="${not empty details.name }">${details.name }</c:if><c:if test="${not empty details.spec }">${details.spec }</c:if></td>
					<td width="50">${details.unit }</td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.amount }</fmt:parseNumber></td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber></td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.price*details.amount }</fmt:parseNumber></td>
					<td width="100">${details.remark }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
	
    <fieldset class="tableBox">
    	<legend><strong>退回原因</strong></legend>
    	<table width="100%" class="nt_table"><tr><td>${vo.cause }</td></tr></table>
	</fieldset>
	
	<fieldset class="tableBox">
    	<legend><strong>审核意见</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray"  height="40" align="right"><font color="red">*</font>审核人：</td>
                <td><input name="mindSO.realname" type="text" class="ntext_01" value="${mindSO.realname }" size="35" readonly="readonly" /></td>
                <td class="gray"  height="40" align="right"><font color="red">*</font>日期：</td>
                <td><input name="mindSO.auditDate" type="text" class="ntext_01" value="${mindSO.auditDate }" size="35" readonly="readonly" /></td>
                <td class="gray"  height="40" align="right"><font color="red">*</font>状态：</td>
                <td>
                	<select name="mindSO.state" dataType="Require" msg="请选择审核状态">
						<option value="" <c:if test="${empty mindSO.state }">selected="selected"</c:if>>---请选择---</option>
						<c:forEach var="state" items="${states}">
							<option value="${state }" <c:if test="${mindSO.state==state }">selected="selected"</c:if>>${state.text }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
            <tr>
                <td class="gray"  height="40" align="right"><font color="red">*</font>审核意见：</td>
                <td colspan="5"><textarea name="mindSO.mind" cols="50" rows="5" style="width: 100%" dataType="Require" msg="请审核意见不能为空"></textarea></td>
			</tr>
        </table>
	</fieldset>
	
	<c:if test="${not empty auditList}">
	    <fieldset class="tableBox">
	    	<legend><strong>审核记录</strong></legend>
	    	<table width="100%" class="nm_table">
	            <thead>
					<tr class="gray" align="center">
						<th>序号</th>
						<th>审核人</th>
						<th>日期</th>
						<th>状态</th>
						<th>意见</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="audit" items="${auditList}" varStatus="status">
					<tr align="center">
						<td width="30">${status.count }</td>
						<td width="100">${audit.realname }</td>
						<td width="100">${audit.auditDate }</td>
						<td width="100">${audit.state.text }</td>
						<td>${audit.mind }</td>
					</tr>
					</c:forEach>
	            </tbody>
	        </table>
		</fieldset>
	</c:if>
	
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
		<input type="hidden" name="vo.backState" value="${vo.backState}" />
		<input type="hidden" name="vo.state" value="${vo.state}" />
        <input type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/buy/buy-back/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

