<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>产品管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">详情</h3>
	
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right">编号：</td>
                <td>${vo.code }</td>
                <td class="gray" width="80" height="40" align="right">名称：</td>
                <td colspan="3">${vo.name }</td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right">价格：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.price}</fmt:parseNumber></td>
                <td class="gray" width="80" height="40" align="right">成本：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.cost}</fmt:parseNumber></td>
                <td class="gray" width="80" height="40" align="right">单位：</td>
                <td>${vo.unit.name }</td>
            </tr>
             <tr>
                <td class="gray" width="80" height="40" align="right">分类：</td>
                <td>${vo.category.name }</td>
                <td class="gray" width="80" height="40" align="right">类型：</td>
                <td>${vo.type.text }</td>
                <td class="gray" width="80" height="40" align="right">所属客户：</td>
                <td>${vo.customer.name }</td>
            </tr>
        </table>
    </div>
    
    <c:if test="${not empty mateList }">
    <fieldset class="tableBox">
    	<legend><strong>物料明细</strong></legend>
    	<table width="100%" class="nm_table">
			<thead>
				<tr class="gray" align="center">
					<th>序号</th>
					<th>编号</th>
					<th>名称及规格</th>
					<th>数量</th>
					<th>单价</th>
					<th>金额</th>
					<th>单位</th>
				</tr>
			</thead>
			<tbody id="mateDetails">
				<c:forEach var="details" items="${mateList}" varStatus="status">
				<tr id="tr1${details.id }" align="center">
					<td width="30">${status.count }</td>
					<td width="50">${details.code }</td>
					<td>${details.name }</td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.amount }</fmt:parseNumber></td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber></td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.total }</fmt:parseNumber></td>
					<td width="50">${details.unit }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
	</c:if>
	
	<c:if test="${not empty workList }">
	<fieldset class="tableBox">
    	<legend><strong>工序明细</strong></legend>
    	<table width="100%" class="nm_table">
			<thead>
				<tr class="gray" align="center">
					<th>序号</th>
					<th>编号</th>
					<th>名称</th>
					<th>数量</th>
					<th>单价</th>
					<th>金额</th>
				</tr>
			</thead>
			<tbody id="workDetails">
				<c:forEach var="details" items="${workList}" varStatus="status">
				<tr id="tr2${details.id }" align="center">
					<td width="30">${status.count }</td>
					<td width="50">${details.code }</td>
					<td>${details.name }</td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.amount }</fmt:parseNumber></td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber></td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.total }</fmt:parseNumber></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
	</c:if>
	
	<c:if test="${not empty accessList}">
	<fieldset class="tableBox">
    	<legend><strong>产品图片</strong></legend>
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
				<tbody>
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