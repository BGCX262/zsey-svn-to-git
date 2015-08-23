<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统角色管理</title>
<script type="text/javascript">
$(document).ready(function(){
		var id = $("input[type='hidden'][name='vo.id']").val();
		if($.trim(id)!=""){
			$("input[type='text'][name='vo.code']").attr("disabled",true);
		}
});

function ajaxCheckCode(){
	var code =$("input[type='text'][name='vo.code']").val();
	var id = $("input[type='hidden'][name='vo.id']").val();
	alert(code+"|"+id);
	if($.trim(code)!=""){
		$.ajax({
	        type:"post",
	        url:"<c:url value='/system/sys-role/ajaxCheckCode.json' />",
	        cache:false,
	        data:{"vo.id":id,"vo.code":code,"rnd":Math.random()},
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
        <h2><strong>系统角色管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty id}">添加</c:if><c:if test="${not empty id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/system/sys-role/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="10%" height="40" align="right" ><font color="red">*</font>代码：</td>
                <td width="40%"><input name="vo.code" type="text" class="ntext_01" value="${vo.code }" size="55" onblur="ajaxCheckCode()" dataType="Require" msg="请输入代码" /><font id="msgFont" color="red">*</font></td>
                <td class="gray" width="10%" height="40" align="right" ><font color="red">*</font>名称：</td>
                <td width="40%"><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="55" dataType="Require" msg="请输入名称" /></td>
            </tr>
            <tr>
                <td class="gray" width="10%" height="40" align="right" >备注：</td>
                <td colspan="3" width="90%"><textarea name="vo.caption" cols="120" rows="5" style="width: 100%;">${vo.caption }</textarea></td>
            </tr>
        </table>
    </div>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回"  onclick="location.href='<c:url value='/system/sys-role/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

