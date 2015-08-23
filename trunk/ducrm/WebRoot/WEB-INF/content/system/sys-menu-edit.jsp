<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>功能菜单管理</title>
<script type="text/javascript">
$(document).ready(function(){
	var id = $("input[type='hidden'][name='vo.id']").val();
	if($.trim(id)!=""){
		$("input[type='text'][name='vo.enName']").attr("disabled",true);
	}
});

function ajaxCheckCode(){
	var enName =$("input[type='text'][name='vo.enName']").val();
	var id = $("input[type='hidden'][name='vo.id']").val();
	if($.trim(enName)!=""){
		$.ajax({
	        type:"post",
	        url:"<c:url value='/system/sys-menu/ajaxCheckCode.json' />",
	        cache:false,
	        data:{"vo.id":id,"vo.enName":enName,"rnd":Math.random()},
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

/**
 * 所属功能菜单选择
 */
function openSelectSingleMenu() {
	var pid = $("input[type='hidden'][name='vo.parentMenu.id']").val();
	var url="/system/sys-menu/single.jhtml?id="+pid+"&rnd="+Math.random();
	
	$.weeboxs.open(url, {
		title:'系统功能菜单',
		contentType:'iframe', 
		width:800, height:400,
		onok:function(box){
	   	 	var name = "lstItems";
	   		box.find("iframe")[0].id   = name;
	   		box.find("iframe")[0].name = name;
	   		setTimeout(function(){
	   			var data = document.getElementById(name).contentWindow.getSelectMenu();
	   			if(data!=""){
	   				
	   				if(document.getElementById("parentMenuId")!=null){
						document.getElementById("parentMenuId").value=data.id;
					}
					
	   				if(document.getElementById("parentMenuName")!=null){
						document.getElementById("parentMenuName").value=data.name;
					}
	   			}else{
	   				alert("请选择所属菜单");
					return;
	   			}
	   			
	   			box.close();
	   		}, 20);
		}
	});
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>功能菜单管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty id}">添&nbsp;&nbsp;&nbsp;&nbsp;加</c:if><c:if test="${not empty id}">修&nbsp;&nbsp;&nbsp;&nbsp;改</c:if></h3>
<form name="form1" action="<c:url value='/system/sys-menu/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td width="80" class="gray" height="40" align="right" ><font color="red">*</font>菜单名称：</td>
                <td><input name="vo.enName" type="text" class="ntext_01" value="${vo.enName }" size="55" onblur="ajaxCheckCode()" dataType="Require" msg="请输入菜单名称" /><font id="msgFont" color="red"></font></td>
                <td width="80" class="gray" height="40" align="right" ><font color="red">*</font>显示名称：</td>
                <td><input name="vo.chName" type="text" class="ntext_01" value="${vo.chName }" size="55" dataType="Require" msg="请输入显示名称" /></td>
            </tr>
			<tr>
                <td class="gray" height="40" align="right" >所属菜单：</td>
                <td>
                	<input id="parentMenuName" name="vo.parentMenu.chName" type="text" class="ntext_01" value="${vo.parentMenu.chName }" size="35" readonly="readonly" />
                	<input type="button" class="btn" value="选择" onclick="openSelectSingleMenu();"/>
                	<input id="parentMenuId" name="vo.parentMenu.id" type="hidden" value="${vo.parentMenu.id }" />
                </td>
                <td class="gray" height="40" align="right" >排序：</td>
                <td><input name="vo.sort" type="text" class="ntext_01" value="${vo.sort }" size="55" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >链接地址：</td>
                <td colspan="3"><input name="vo.href" type="text" class="ntext_01" value="${vo.href }" size="55" /></td>
            </tr>
        </table>
    </div>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回"  onclick="location.href='<c:url value='/system/sys-menu/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

