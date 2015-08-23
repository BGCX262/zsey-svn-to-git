<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工序管理</title>
<script type="text/javascript" language="javascript">
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>工序管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/basic/work/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right">编号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="${vo.code }" size="35" maxlength="9" readonly="readonly" /></td>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>名称：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="35" maxlength="50" dataType="Require" msg="请输入名称" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right"><font color="red">*</font>价格：</td>
                <td><input name="vo.price" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.price}</fmt:parseNumber>" size="35" maxlength="5" dataType="Double" msg="请输入价格" /></td>
                <td class="gray" height="40" align="right">备注：</td>
                <td><input name="vo.remark" type="text" class="ntext_01" value="${vo.remark }" size="35" maxlength="50" /></td>
            </tr>
        </table>
    </div>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/basic/work/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

