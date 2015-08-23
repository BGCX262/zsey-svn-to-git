<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>仓库管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty id}">添&nbsp;&nbsp;&nbsp;&nbsp;加</c:if><c:if test="${not empty id}">修&nbsp;&nbsp;&nbsp;&nbsp;改</c:if></h3>
<form name="form1" action="<c:url value='/store/store/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td width="80" class="gray" height="40" align="right" ><font color="red">*</font>名称：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="55" dataType="Require" msg="请输入名称" /></td>
            </tr>
        </table>
    </div>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="formBtn02" value="关 闭" onclick="parent.window.$.weeboxs.close();" />
    </div>
</form>
</div>
</body>
</html>

