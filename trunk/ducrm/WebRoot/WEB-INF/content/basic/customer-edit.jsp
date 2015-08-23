<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/area/area.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript" src="<c:url value='/js/linkman/linkman.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript">
function addTemplet(){
	var date = new Date();
	var ms=(date.getMinutes()+""+date.getSeconds()+""+date.getMilliseconds());
	var html="";
	html+="<br />附件：<input name=\"templets\" type=\"file\" class=\"formText\" />";
	$("#templetsDiv").append(html);
}

function addTr(){
	var date = new Date();
	var ms=(date.getMinutes()+""+date.getSeconds()+""+date.getMilliseconds());
	var html="";
	html+="<tr id=\"tr"+ms+"\" align=\"center\">";
	html+="<td width=\"30\">&nbsp;</td>";
	html+="<td><input name=\"names\" type=\"text\" class=\"ntext_01\" value=\"\" maxlength=\"10\" dataType=\"Require\" msg=\"请输入姓名\" style=\"width: 98%;\" /></td>";
	html+="<td><input name=\"dutys\" type=\"text\" class=\"ntext_01\" value=\"\"  maxlength=\"10\" style=\"width: 98%;\" /></td>";
	html+="<td><input name=\"companys\" type=\"text\" class=\"ntext_01\" value=\"\" maxlength=\"10\" style=\"width: 98%;\" /></td>";
	html+="<td><input name=\"phones\" type=\"text\" class=\"ntext_01\" value=\"\" maxlength=\"15\" require=\"false\" dataType=\"Phone\" msg=\"手机格式不正确\" style=\"width: 98%;\" /></td>";
	html+="<td><input name=\"mobiles\" type=\"text\" class=\"ntext_01\" value=\"\" maxlength=\"11\" require=\"false\" dataType=\"Mobile\" msg=\"电话格式不正确\" maxlength=\"10\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\">";
	html+="<span class=\"caozuo\">";
	html+="<a href=\"javascript:void(null);\" onclick=\"deleteTr('tr"+ms+"');\" class=\"del\">删除</a>";
	html+="</span>";
	html+="</td>";
	html+="</tr>";
	$("#detailsTbody").append(html);
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>客户管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/basic/customer/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);" enctype="multipart/form-data">
	<fieldset class="tableBox">
    	<legend><strong>基本信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right">编号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="${vo.code }" size="35" disabled="disabled" /></td>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>名称：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="35" dataType="Require" msg="请输入名称" /></td>
                <td class="gray" width="80" height="40" align="right">简称：</td>
                <td><input name="vo.shortName" type="text" class="ntext_01" value="${vo.shortName }" size="35" /></td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>类型：</td>
                <td>
                	<select name="vo.sort.id" dataType="Require" msg="请选择类型">
						<option value="" <c:if test="${empty vo.sort.id }">selected="selected"</c:if>>---请选择---</option>
						<c:forEach var="sort" items="${sortList}">
							<option value="${sort.id }" <c:if test="${vo.sort.id==sort.id }">selected="selected"</c:if>>${sort.name }</option>
						</c:forEach>
					</select>
                </td>
                <td class="gray" height="40" align="right" >联系人：</td>
                <td><input name="vo.linkman" type="text" class="ntext_01" value="${vo.linkman }" maxlength="20" size="35" /></td>
                <td class="gray" height="40" align="right" >QQ：</td>
                <td><input name="vo.qq" type="text" class="ntext_01" value="${vo.qq }" maxlength="20" size="35" require="false" dataType="QQ" msg="QQ格式不正确" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >电话：</td>
                <td><input name="vo.tel" type="text" class="ntext_01" value="${vo.tel }" maxlength="20" size="35" require="false" dataType="Phone" msg="电话格式不正确" /></td>
                <td class="gray" height="40" align="right" >手机：</td>
                <td colspan="3"><input name="vo.mobile" type="text" class="ntext_01" value="${vo.mobile }" maxlength="11" size="35" require="false" dataType="Mobile" msg="手机格式不正确" /></td>
            </tr>
        </table>
	</fieldset>
	
	<fieldset class="tableBox">
    	<legend><strong>联系方式</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right" >电话：</td>
                <td><input name="vo.phone" type="text" class="ntext_01" value="${vo.phone }" maxlength="20" size="35" require="false" dataType="Phone" msg="电话格式不正确" /></td>
                <td class="gray" width="80" height="40" align="right" >传真：</td>
                <td><input name="vo.fax" type="text" class="ntext_01" value="${vo.fax }" maxlength="20" size="35" require="false" dataType="Phone" msg="传真格式不正确" /></td>
                <td class="gray" width="80" height="40" align="right" >邮箱：</td>
                <td><input name="vo.email" type="text" class="ntext_01" value="${vo.email }" maxlength="50" size="35" require="false" dataType="Email" msg="邮箱格式不正确" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >省：</td>
                <td>
                	<select name="vo.province.id" onchange="ajaxFindArea(this.value)">
                		<option value="" <c:if test="">selected="selected"</c:if>>---请选择---</option>
                		<c:forEach var="cate" items="${provinceList}">
                			<option value="${cate.id }" <c:if test="${cate.id==vo.province.id }">selected="selected"</c:if>>${cate.name }</option>
                		</c:forEach>
                	</select>
                </td>
                <td class="gray" height="40" align="right" >市：</td>
                <td>
                	<select id="selectArea" name="vo.city.id">
                		<option value="" <c:if test="">selected="selected"</c:if>>---请选择---</option>
                		<c:forEach var="cate" items="${cityList}">
                			<option value="${cate.id }" <c:if test="${cate.id==vo.city.id }">selected="selected"</c:if>>${cate.name }</option>
                		</c:forEach>
                	</select>
                </td>
                <td class="gray" height="40" align="right" >地址：</td>
                <td><input name="vo.address" type="text" class="ntext_01" value="${vo.address }" maxlength="30" size="35" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >邮编：</td>
                <td><input name="vo.postcode" type="text" class="ntext_01" value="${vo.postcode }" maxlength="6" size="35" require="false" dataType="Zip" msg="邮编格式不正确" /></td>
                <td class="gray" height="40" align="right" >网址：</td>
                <td colspan="3"><input name="vo.web" type="text" class="ntext_01" value="${vo.web }" maxlength="30" size="35" require="false" dataType="Url" msg="网址格式不正确" /></td>
            </tr>
        </table>
	</fieldset>
	
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
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="detailsTbody">
				<c:forEach var="details" items="${manList}" varStatus="status">
				<tr id="tr${details.id }" align="center">
					<td width="30">${status.count }</td>
					<td><input name="names" type="text" class="ntext_01" value="${details.name }" maxlength="10" dataType="Require" msg="请输入姓名" style="width: 98%;" /></td>
					<td><input name="dutys" type="text" class="ntext_01" value="${details.duty }"  maxlength="10" style="width: 98%;" /></td>
					<td><input name="companys" type="text" class="ntext_01" value="${details.company }" maxlength="10" style="width: 98%;" /></td>
					<td><input name="phones" type="text" class="ntext_01" value="${details.phone }" maxlength="15" require="false" dataType="Phone" msg="手机格式不正确" style="width: 98%;" /></td>
					<td><input name="mobiles" type="text" class="ntext_01" value="${details.mobile }" maxlength="11" require="false" dataType="Mobile" msg="电话格式不正确" maxlength="10" style="width: 98%;" /></td>
					<td width="50">
						<span class="caozuo">
							<a href="javascript:void(null);" onclick="deleteTr('tr${details.id }');" class="del">删除</a>
						</span>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
    	<table width="100%" class="nm_table">
			<tr align="center">
				<td class="addRows" colspan="11">
					<a href="javascript:void(null);" onclick="addTr();">添加联系人</a>
				</td>
			</tr>
		</table>
	</fieldset>
	
	<fieldset class="tableBox">
    	<legend><strong>银行卡信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td width="80" class="gray" height="40" align="right">银行账号：</td>
                <td><input name="vo.bcode" type="text" class="ntext_01" value="${vo.bcode }" maxlength="20" size="55" /></td>
                <td width="80" class="gray" height="40" align="right" >银行名称：</td>
                <td><input name="vo.bname" type="text" class="ntext_01" value="${vo.bname }" maxlength="20" size="55" /></td>
            </tr>
            <tr>
                <td width="80" class="gray" height="40" align="right" >开户人：</td>
                <td><input name="vo.bman" type="text" class="ntext_01" value="${vo.bman }" maxlength="20" size="55" /></td>
                <td width="80" class="gray" height="40" align="right" >开户地址：</td>
                <td><input name="vo.badd" type="text" class="ntext_01" value="${vo.badd }" maxlength="30" size="55" /></td>
            </tr>
        </table>
	</fieldset>
	
	<fieldset class="tableBox">
    	<legend><strong>附件明细</strong></legend>
	    <c:if test="${not empty accessList}">
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
        </c:if>
		<div id="templetsDiv">附件：<input name="templets" type="file" class="formText" /></div>
    	<table width="100%" class="nm_table">
			<tr align="center"><td class="addRows"><a href="javascript:void(null);" onclick="addTemplet();">添加</a></td></tr>
		</table>
	</fieldset>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
		<input type="hidden" name="manSort" value="CUSTOMER" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/basic/customer/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

