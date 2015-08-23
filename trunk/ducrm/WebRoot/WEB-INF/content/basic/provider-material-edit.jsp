<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料管理</title>
<script type="text/javascript" language="javascript">
function ajaxCheckCode(){
	var code = $("input[type='text'][name='vo.code']").val();
	var id = $("input[type='text'][name='vo.id']").val();
	if($.trim(code)!=""){
		$.ajax({
	        type:"post",
	        url:"<c:url value='/basic/material/ajaxCheckCode.json' />",
	        cache:false,
	        data:{"vo.id":id,"vo.code":code,"rnd":Math.random()},
	        dataType:"json",
			success:function(msg){
				var obj = eval(msg);
				if(obj.isok){
					$("#msgFont").text("该编号已存在");
				}else{
					$("#msgFont").text("该编号不存在");
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
        <h2><strong>物料管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/basic/material/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>编号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="${vo.code }" size="55" onblur="ajaxCheckCode()" dataType="Require" msg="请输入编号" /><font id="msgFont" color="red"></font></td>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>名称：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="55" dataType="Require" msg="请输入名称" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right"><font color="red">*</font>型号：</td>
                <td><input name="vo.model" type="text" class="ntext_01" value="${vo.model }" size="55" dataType="Require" msg="请输入型号" /></td>
                <td class="gray" height="40" align="right">规格：</td>
                <td><input name="vo.spec" type="text" class="ntext_01" value="${vo.spec }" size="55" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right"><font color="red">*</font>单位：</td>
                <td>
                	<select name="vo.unit.id" dataType="Require" msg="请选择单位">
               			<option value="" <c:if test="${empty vo.unit.id }">selected="selected"</c:if>>---请选择---</option>
                		<c:forEach var="unit" items="${units}">
                			<option value="${unit.id }" <c:if test="${unit.id==vo.unit.id }">selected="selected"</c:if>>${unit.name }</option>
                		</c:forEach>
                	</select>
                </td>
                <td class="gray" height="40" align="right"><font color="red">*</font>价格：</td>
                <td><input name="vo.price" type="text" class="ntext_01" value="${vo.price }" size="55" dataType="Double" msg="请输入价格" /></td>
            </tr>
        </table>
    </div>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/basic/material/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

