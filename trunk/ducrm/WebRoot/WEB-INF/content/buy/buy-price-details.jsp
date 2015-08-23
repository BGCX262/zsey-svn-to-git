<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料询价管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>物料询价管理</strong></h2>
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
                <td class="gray"  height="40" align="right">地址：</td>
                <td colspan="3">${vo.address }</td>
                <td class="gray" height="40" align="right">邮编：</td>
                <td>${vo.postcode }</td>
            </tr>
            <tr>
                <td class="gray"  height="40" align="right">询价单号：</td>
                <td>${vo.code }</td>
                <td class="gray"  height="40" align="right">询价方式：</td>
                <td colspan="3">${vo.askType.text}</td>
			</tr>
            <tr>
                <td class="gray"  height="40" align="right">询价总数：</td>
                <td>${vo.total }</td>
                <td class="gray"  height="40" align="right">询价总额：</td>
                <td>${vo.payment }</td>
                <td class="gray"  height="40" align="right">询价状态：</td>
                <td>${vo.auditState.text}</td>
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
    
    <c:if test="${not empty accessList}">
	    <fieldset class="tableBox">
	    	<legend><strong>附件</strong></legend>
	    	<table width="100%" class="nm_table">
	            <thead>
					<tr class="gray" align="center">
						<th>序号</th>
						<th>名称</th>
						<th>图片</th>
						<th>上传人</th>
						<th>上传时间</th>
						<th>下载</th>
					</tr>
				</thead>
				<tbody id="lightBoxTbody">
					<c:forEach var="access" items="${accessList}" varStatus="status">
						<tr align="center">
							<td width="30">${status.count }</td>
							<td>${access.name }</td>
							<td width="80"><a href="<c:url value='${access.path }'/>" target="_blank"><img src="<c:url value='${access.path }'/>" height="50" width="50" alt="${access.name }" /></a></td>
							<td width="80">${access.realname }</td>
							<td width="120">${access.createTime }</td>
							<td width="80"><span class="caozuo"><a href="<c:url value="/utils/accessory/download.jhtml?id=${access.id}" />" class="edit">下载</a></span></td>
						</tr>
					</c:forEach>
	            </tbody>
	        </table>
		</fieldset>
	</c:if>
</div>
</body>
</html>

