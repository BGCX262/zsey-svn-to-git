<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>分类管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/employee/employeeSelector.js' />" charset="utf-8"></script>
<script type="text/javascript" language="javascript" src="<c:url value='/js/base/department.js' />" charset="utf-8"></script>
<script type="text/javascript" language="javascript">
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>分类管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/basic/department/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right">编号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="${vo.code }" size="50" readonly="readonly" /></td>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>名称：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="50" maxlength="15" dataType="Require" msg="请输入名称" /></td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right">所属部门：</td>
                <td>
                	<input id="departName" name="vo.department.name" type="text" class="ntext_01" value="${vo.department.name }" size="50" disabled="disabled" />
                	<input id="departId" type="hidden" name="vo.department.id" value="${vo.department.id}" />
                	<input type="button" value="选择" onclick="openSingleDepartmentDialog()" />
                </td>
                <td class="gray" height="40" align="right" >部门主管：</td>
                <td>
                	<input id="employeeId" name="vo.managerId" type="hidden" value="${vo.managerId }" />
                	<input id="employeeName" name="vo.manager" type="text" class="ntext_01" value="${vo.manager }" size="50" maxlength="10" readonly="readonly" />&nbsp;&nbsp;
                	<input type="button" value="选择" onclick="openSelectSingleEmployee('<c:url value='/basic/employee/single.jhtml' />')" />
                </td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >电话：</td>
                <td><input name="vo.phone" type="text" class="ntext_01" value="${vo.phone }" maxlength="20" size="50" require="false" dataType="Phone" msg="电话格式不正确" /></td>
                <td class="gray" height="40" align="right" >传真：</td>
                <td><input name="vo.fax" type="text" class="ntext_01" value="${vo.fax }" maxlength="20" size="50" require="false" dataType="Phone" msg="传真格式不正确" /></td>
            </tr>
        </table>
    </div>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/basic/department/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

