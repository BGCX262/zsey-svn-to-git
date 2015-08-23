<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户管理</title>
<script type="text/javascript" language="javascript">
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>客户管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">详情</h3>
	
	<fieldset class="tableBox">
    	<legend><strong>基本信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right">编号：</td>
                <td>${vo.code }</td>
                <td class="gray" width="80" height="40" align="right">名称：</td>
                <td>${vo.name }</td>
                <td class="gray" width="80" height="40" align="right">简称：</td>
                <td>${vo.shortName }</td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right">类型：</td>
                <td>${vo.sort.name }</td>
                <td class="gray" height="40" align="right" >联系人：</td>
                <td>${vo.linkman }</td>
                <td class="gray" height="40" align="right" >QQ：</td>
                <td>${vo.qq }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >电话：</td>
                <td>${vo.tel }</td>
                <td class="gray" height="40" align="right" >手机：</td>
                <td colspan="3">${vo.mobile }</td>
            </tr>
        </table>
	</fieldset>
	
	<fieldset class="tableBox">
    	<legend><strong>联系方式</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" height="40" align="right" >电话：</td>
                <td>${vo.phone }</td>
                <td class="gray" height="40" align="right" >传真：</td>
                <td>${vo.fax }</td>
                <td class="gray" height="40" align="right" >邮箱：</td>
                <td>${vo.email }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >省：</td>
                <td>${vo.province.name}</td>
                <td class="gray" height="40" align="right" >市：</td>
                <td>${vo.city.name }</td>
                <td class="gray" height="40" align="right" >地址：</td>
                <td>${vo.address }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >邮编：</td>
                <td>${vo.postcode }</td>
                <td class="gray" height="40" align="right" >网址：</td>
                <td colspan="3">${vo.web }</td>
            </tr>
        </table>
	</fieldset>
	
	<c:if test="${not empty manList}">
	<fieldset class="tableBox">
    	<legend><strong>联系人列表</strong></legend>
    	<table width="100%" class="nm_table">
			<thead>
				<tr class="gray" align="center">
					<th>序号</th>
					<th>姓名</th>
					<th>职务</th>
					<th>部门</th>
					<th>电话</th>
					<th>手机</th>
				</tr>
			</thead>
			<tbody id="detailsTbody">
				<c:forEach var="details" items="${manList}" varStatus="status">
				<tr id="tr${details.id }" align="center">
					<td width="30">${status.count }</td>
					<td>${details.name }</td>
					<td>${details.duty }</td>
					<td>${details.company }</td>
					<td>${details.phone }</td>
					<td>${details.mobile }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
	</c:if>
	
	<fieldset class="tableBox">
    	<legend><strong>银行卡信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" height="40" align="right" >银行账号：</td>
                <td>${vo.bcode }</td>
                <td class="gray" height="40" align="right" >银行名称：</td>
                <td>${vo.bname }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >开户人：</td>
                <td>${vo.bman }</td>
                <td class="gray" height="40" align="right" >开户地址：</td>
                <td>${vo.badd }</td>
            </tr>
        </table>
	</fieldset>
	
	<c:if test="${not empty accessList}">
		<fieldset class="tableBox">
	    	<legend><strong>附件明细</strong></legend>
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
							<td width="80"><span class="caozuo"><a href="download.jhtml?id=${access.id}" class="edit">下载</a></span></td>
						</tr>
					</c:forEach>
	            </tbody>
	        </table>
		</fieldset>
	</c:if>

</div>
</body>
</html>

