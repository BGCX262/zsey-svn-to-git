<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品报价管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>产品报价管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">详情</h3>
	<div class="ntable_mid mT10">
        <table width="100%" class="nt_table">
			<tr>
                <td class="gray" width="80" height="40" align="right">客户名称：</td>
                <td>${vo.name }</td>
                <td class="gray" width="80" height="40" align="right">单位电话：</td>
                <td>${vo.phone }</td>
                <td class="gray" width="80" height="40" align="right">单位传真：</td>
                <td>${vo.fax }</td>
            </tr>
			<tr>
                <td class="gray"  height="40" align="right">联系人：</td>
                <td>${vo.linkman }</td>
                <td class="gray"  height="40" align="right">联系人电话：</td>
                <td>${vo.phone }</td>
                <td class="gray"  height="40" align="right">联系人手机：</td>
                <td>${vo.mobile }</td>
            </tr>
			<tr>
                <td class="gray"  height="40" align="right">地址：</td>
                <td>${vo.address }</td>
                <td class="gray"  height="40" align="right">邮编：</td>
                <td>${vo.postcode }</td>
            </tr>
             <tr>
                <td class="gray"  height="40" align="right">报价单号：</td>
                <td>${vo.code }</td>
                <td class="gray"  height="40" align="right">报价方式：</td>
                <td colspan="3">${vo.style.text}</td>
			</tr>
            <tr>
                <td class="gray"  height="40" align="right">总数：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.total }</fmt:parseNumber></td>
                <td class="gray"  height="40" align="right">总额：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.payment }</fmt:parseNumber></td>
			</tr>
        </table>
        <c:if test="${not empty orderList}">
	        <table width="100%" class="nm_table">
				<thead>
					<tr class="gray" align="center">
						<th>序号</th>
						<th>编号</th>
						<th>名称</th>
						<th>码数</th>
						<th>单位</th>
						<th>数量</th>
						<th>单价</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody id="detailsTbody">
					<c:forEach var="details" items="${orderList}" varStatus="status">
					<tr align="center">
						<td width="30">${status.count }</td>
						<td width="50">${details.code }</td>
						<td>${details.name }</td>
						<td width="50">${details.size }</td>
						<td width="50">${details.unit }</td>
						<td width="50">${details.amount }</td>
						<td width="50">${details.price }</td>
						<td width="150">${details.remark }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
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
	
    <c:if test="${not empty askList}">
	    <fieldset class="tableBox">
	    	<legend><strong>报价确认记录</strong></legend>
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
					<c:forEach var="audit" items="${askList}" varStatus="status">
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
						<th>下载</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="access" items="${accessList}" varStatus="status">
					<tr align="center">
						<td width="30">${status.count }</td>
						<td>${access.name }</td>
						<td width="80"><a href="<c:url value='${access.path }'/>" target="_blank"><img src="<c:url value='${access.path }' />" height="50" width="50" alt="${access.name }" /></a></td>
						<td width="80">${access.realname }</td>
						<td width="80"><span class="caozuo"><a href="<c:url value='/utils/accessory/download.jhtml?id=${access.id}'/>" class="edit">下载</a></span></td>
					</tr>
					</c:forEach>
	            </tbody>
	        </table>
		</fieldset>
	</c:if>
</div>
</body>
</html>

