<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>联系人管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>联系人管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/basic/linkman/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>姓名：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="35" dataType="Require" msg="请输入姓名" /></td>
                <td class="gray" width="80" height="40" align="right">职务：</td>
                <td><input name="vo.duty" type="text" class="ntext_01" value="${vo.duty }" size="35" /></td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right">部门：</td>
                <td><input name="vo.company" type="text" class="ntext_01" value="${vo.company }" size="35" /></td>
                <td class="gray" height="40" align="right">QQ：</td>
                <td><input name="vo.qq" type="text" class="ntext_01" value="${vo.qq }" size="35" maxlength="15" require="false" dataType="Qq"  msg="请QQ号码格式不正确" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right">电话：</td>
                <td><input name="vo.phone" type="text" class="ntext_01" value="${vo.phone }" size="35" maxlength="15" require="false" dataType="Phone"  msg="请电话号码格式不正确" /></td>
                <td class="gray" height="40" align="right">手机：</td>
                <td><input name="vo.mobile" type="text" class="ntext_01" value="${vo.mobile }" size="35" maxlength="11" require="false" dataType="Mobile" msg="请手机号码格式不正确" /></td>
            </tr>
        </table>
    </div>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
		<input type="hidden" name="vo.sort" value="${vo.sort}"/>
		<input type="hidden" name="vo.dataId" value="${vo.dataId}"/>
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/basic/linkman/index.jhtml?vo.sort=${vo.sort}&vo.dataId=${vo.dataId}' />';" />
    </div>
</form>
</div>
</body>
</html>

