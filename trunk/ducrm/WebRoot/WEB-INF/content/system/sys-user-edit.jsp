<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统用户管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/employee/employeeSelector.js' />" charset="utf-8"></script>
<script type="text/javascript">
$(document).ready(function(){
	var id = $("input[type='hidden'][name='vo.id']").val();
	if($.trim(id)!=""){
		$("input[type='text'][name='vo.username']").attr("disabled",true);
	}
});

function ajaxCheckCode(){
	var username =$("input[type='text'][name='vo.username']").val();
	var id = $("input[type='hidden'][name='vo.id']").val();
	if($.trim(username)!=""){
		$.ajax({
	        type:"post",
	        url:"<c:url value='/system/sys-user/ajaxCheckCode.json' />",
	        cache:false,
	        data:{"vo.id":id,"vo.username":username,"rnd":Math.random()},
	        dataType:"json",
			success:function(msg){
				var obj = eval(msg);
				if(obj.isok){
					$("#msgFont").text("该代码已存在");
				}else{
					$("#msgFont").text("该代码不存在");
				}
	        }
		});
	}
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>系统用户管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty id}">添&nbsp;&nbsp;&nbsp;&nbsp;加</c:if><c:if test="${not empty id}">修&nbsp;&nbsp;&nbsp;&nbsp;改</c:if></h3>
<form name="form1" action="<c:url value='/system/sys-user/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td width="80" class="gray" height="40" align="right" ><font color="red">*</font>用户名：</td>
                <td width="25%"><input name="vo.username" type="text" class="ntext_01" value="${vo.username }" size="30" onblur="ajaxCheckCode()" dataType="Require" msg="请输入代码" /><font id="msgFont" color="red"></font></td>
                <td width="80" class="gray" height="40" align="right" >密码：</td>
                <td colspan="3"><input name="vo.password" type="password" class="ntext_01" value="" size="30" /></td>
            </tr>
            <tr>
                <td width="80" class="gray" height="40" align="right" ><font color="red">*</font>角色：</td>
                <td width="25%"  colspan="5">
                	<c:forEach var="sysRole" items="${roleList}">
                		<c:set var="checked" value="0"></c:set>
                		<c:forEach var="sysRoleUser" items="${roleUserList}">
                			<c:if test="${sysRole.id==sysRoleUser.role.id}">
	                			<c:set var="checked" value="1" />
                			</c:if>
                		</c:forEach>
               			<label><input name="ids" type="checkbox" value="${sysRole.id }" <c:if test="${checked==1}">checked="checked"</c:if>/>${sysRole.name }</label>&nbsp;&nbsp;
                	</c:forEach>
                </td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" ><font color="red">*</font>编号：</td>
                <td width="25%">
                	<input id="employeeId" name="vo.employee.id" type="hidden" value="${vo.employee.id }" />
                	<input id="employeeCode" name="employee.code" type="text" class="ntext_01" value="${vo.employee.code }" size="20" disabled="disabled" dataType="Require" msg="请选择员工" />&nbsp;&nbsp;
                	<input type="button" value="选择" onclick="openSelectSingleEmployee('<c:url value='/basic/employee/single.jhtml' />')" />
                </td>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>姓名：</td>
                <td width="25%"><input id="employeeName" type="text" class="ntext_01" value="${vo.employee.name }" size="30" disabled="disabled" /></td>
                <td class="gray" width="80" height="40" align="right" >性别：</td>
                <td width="25%"><input id="employeeSex" type="text" class="ntext_01" value="${vo.employee.sex.text }" size="30" disabled="disabled" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >部门：</td>
                <td><input id="departmentName" type="text" class="ntext_01" value="${vo.employee.department.name }" size="30" /></td>
                <td class="gray" height="40" align="right" >职务：</td>
                <td colspan="3"><input id="dutyName" type="text" class="ntext_01" value="${vo.employee.duty.name }" size="30" disabled="disabled" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >电话：</td>
                <td><input id="employeePhone" type="text" class="ntext_01" value="${vo.employee.phone }" size="30" /></td>
                <td class="gray" height="40" align="right" >手机：</td>
                <td colspan="3"><input id="employeeMobile" type="text" class="ntext_01" value="${vo.employee.mobile }" size="30" disabled="disabled" /></td>
            </tr>
        </table>
    </div>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${vo.id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回"  onclick="location.href='<c:url value='/system/sys-user/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

