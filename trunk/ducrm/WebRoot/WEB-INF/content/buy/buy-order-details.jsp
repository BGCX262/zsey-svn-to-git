<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料采购管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>物料采购管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">详情</h3>
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
                <td class="gray" height="40" align="right">邮编：</td>
                <td>${vo.postcode }</td>
                <td class="gray"  height="40" align="right">地址：</td>
                <td colspan="3">${vo.address }</td>
            </tr>
			<tr>
                <td class="gray"  height="40" align="right">采购单号：</td>
                <td>${vo.code }</td>
                <td class="gray"  height="40" align="right">总数：</td>
                <td colspan="3"><fmt:parseNumber type="number" pattern="##0.00">${vo.total }</fmt:parseNumber></td>
			</tr>
            <tr>
                <td class="gray"  height="40" align="right">应付金额：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.payment }</fmt:parseNumber></td>
                <td class="gray"  height="40" align="right">已付金额：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.payfor }</fmt:parseNumber></td>
                <td class="gray"  height="40" align="right">未付金额：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.payment-vo.payfor }</fmt:parseNumber></td>
			</tr>
        </table>
        
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
			<tbody id="detailsTbody">
				<c:forEach var="details" items="${orderList}" varStatus="status">
				<tr align="center">
					<td width="30">${status.count }</td>
					<td>
						<c:if test="${not empty details.name}">${details.name}&nbsp;</c:if>
						<c:if test="${not empty details.spec}">${details.spec}&nbsp;</c:if>
					</td>
					<td width="50">${details.unit }</td>
					<td width="50">${details.amount }</td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber></td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.price*details.amount }</fmt:parseNumber></td>
					<td width="50">${details.remark }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
    </div>
    
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
	
	<c:if test="${not empty vo.cause}">
		<fieldset class="tableBox">
	    	<legend><strong>退回原因</strong></legend>
	    	<table width="100%" class="nt_table">
				<tr>
	                <td>${vo.cause }</td>
	            </tr>
	        </table>
		</fieldset>
	</c:if>
</div>
</body>
</html>

