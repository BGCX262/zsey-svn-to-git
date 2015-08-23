<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>物料管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">详情</h3>

	<fieldset class="tableBox">
    	<legend><strong>供应商信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right">供应商编号：</td>
                <td>${vo.provider.code }</td>
                <td class="gray" width="80" height="40" align="right">供应商名称：</td>
                <td>${vo.provider.name }</td>
                <td class="gray" width="80" height="40" align="right">联系人：</td>
                <td>${vo.provider.linkman }</td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right">联系人电话：</td>
                <td>${vo.provider.tel }</td>
                <td class="gray" width="80" height="40" align="right">联系人手机：</td>
                <td>${vo.provider.mobile }</td>
                <td class="gray" width="80" height="40" align="right">邮编：</td>
                <td>${vo.provider.postcode }</td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right">单位电话：</td>
                <td>${vo.provider.phone }</td>
                <td class="gray" width="80" height="40" align="right">单位传真：</td>
                <td>${vo.provider.fax }</td>
                <td class="gray" width="80" height="40" align="right">单位地址：</td>
                <td>${vo.provider.mobile }</td>
            </tr>
        </table>
	</fieldset>
	
	<fieldset class="tableBox">
    	<legend><strong>物料信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right">编号：</td>
                <td>${vo.code }</td>
                <td class="gray" width="80" height="40" align="right">名称：</td>
                <td>${vo.name }</td>
                <td class="gray" height="40" align="right">规格：</td>
                <td>${vo.spec }</td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right">分类：</td>
                <td>${vo.category.name}</td>
                <td class="gray" height="40" align="right">单位：</td>
                <td>${vo.unit.name }</td>
                <td class="gray" height="40" align="right">价格：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.price}</fmt:parseNumber></td>
            </tr>
        </table>
	</fieldset>
	
	<c:if test="${not empty accessList}">
	<fieldset class="tableBox">
    	<legend><strong>物料图片</strong></legend>
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
				<tr id="tr${access.id}" align="center">
					<td width="30">${status.count }</td>
					<td>${access.name }</td>
					<td width="80"><a href="<c:url value='${access.path }'/>" target="_blank"><img src="<c:url value='${access.path }'/>" height="50" width="50" alt="${access.name }" /></a></td>
					<td width="80">${access.realname }</td>
					<td width="120">${access.createTime }</td>
					<td width="50">
						<span class="caozuo">
							<a href="<c:url value="/utils/accessory/download.jhtml?id=${access.id}" />" class="edit">下载</a>
						</span>
					</td>
				</tr>
				</c:forEach>
            </tbody>
        </table>
	</fieldset>
	</c:if>
    
</div>
</body>
</html>

