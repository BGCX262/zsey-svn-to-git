<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统设置管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/area/area.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript">
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>系统设置管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">系统设置</h3>
<form name="form1" action="<c:url value='/system/sys-config/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>名称：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="30" maxlength="30" dataType="Require" msg="请输入名称" /></td>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>联系人：</td>
                <td><input name="vo.linkman1" type="text" class="ntext_01" value="${vo.linkman1 }" size="30" maxlength="10" dataType="Require" msg="请输入联系人" /></td>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>手机：</td>
                <td><input name="vo.mobile1" type="text" class="ntext_01" value="${vo.mobile1 }" size="30" maxlength="11" dataType="Mobile" msg="请输入手机" /></td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>电话：</td>
                <td><input name="vo.phone1" type="text" class="ntext_01" value="${vo.phone1 }" size="30" maxlength="20" dataType="Phone" msg="请输入电话" /></td>
                <td class="gray" width="80" height="40" align="right" >传真：</td>
                <td><input name="vo.fax1" type="text" class="ntext_01" value="${vo.fax1 }" size="30" maxlength="20" require="false" dataType="Phone" msg="传真格式不正确" /></td>
                <td class="gray" width="80" height="40" align="right" >网址：</td>
                <td><input name="vo.web" type="text" class="ntext_01" value="${vo.web }" size="30" maxlength="50" require="false" dataType="Url" msg="网址格式不正确" /></td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right" >邮箱：</td>
                <td><input name="vo.email1" type="text" class="ntext_01" value="${vo.email1 }" size="30" maxlength="50" require="false" dataType="Email" msg="邮箱格式不正确" /></td>
                <td class="gray" width="80" height="40" align="right" >QQ：</td>
                <td><input name="vo.qq1" type="text" class="ntext_01" value="${vo.qq1 }" size="30" maxlength="20" require="false" dataType="Qq" msg="QQ格式不正确" /></td>
                <td class="gray" width="80" height="40" align="right" >邮编：</td>
                <td><input name="vo.postcode" type="text" class="ntext_01" value="${vo.postcode }" size="30" maxlength="6" require="false" dataType="Zip" msg="邮编格式不正确" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" ><font color="red">*</font>省：</td>
                <td>
                	<select name="vo.province.id" onchange="ajaxFindArea(this.value)" dataType="Require" msg="请输入选择省份">
                		<option value="" <c:if test="">selected="selected"</c:if>>---请选择---</option>
                		<c:forEach var="cate" items="${provinceList}">
                			<option value="${cate.id }" <c:if test="${cate.id==vo.province.id }">selected="selected"</c:if>>${cate.name }</option>
                		</c:forEach>
                	</select>
                </td>
                <td class="gray" height="40" align="right" ><font color="red">*</font>市：</td>
                <td>
                	<select id="selectArea" name="vo.city.id" dataType="Require" msg="请选择城市">
                		<option value="" <c:if test="">selected="selected"</c:if>>---请选择---</option>
                		<c:forEach var="cate" items="${cityList}">
                			<option value="${cate.id }" <c:if test="${cate.id==vo.city.id }">selected="selected"</c:if>>${cate.name }</option>
                		</c:forEach>
                	</select>
                </td>
                <td class="gray" height="40" align="right" ><font color="red">*</font>地址：</td>
                <td><input name="vo.address" type="text" class="ntext_01" value="${vo.address }" maxlength="30" size="30" dataType="Require" msg="请输入地址" /></td>
            </tr>
            <tr>
                <td width="80" class="gray" height="40" align="right">银行账号：</td>
                <td><input name="vo.bcode1" type="text" class="ntext_01" value="${vo.bcode1 }" maxlength="20" size="35" /></td>
                <td width="80" class="gray" height="40" align="right" >银行名称：</td>
                <td><input name="vo.bname1" type="text" class="ntext_01" value="${vo.bname1 }" maxlength="20" size="35" /></td>
                <td width="80" class="gray" height="40" align="right" >开户人：</td>
                <td><input name="vo.bman1" type="text" class="ntext_01" value="${vo.bman1 }" maxlength="20" size="35" /></td>
            </tr>
            <tr>
                <td width="80" class="gray" height="40" align="right" >开户地址：</td>
                <td><input name="vo.badd1" type="text" class="ntext_01" value="${vo.badd1 }" maxlength="30" size="35" /></td>
            </tr>
        </table>
    </div>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${vo.id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
    </div>
</form>
</div>
</body>
</html>

