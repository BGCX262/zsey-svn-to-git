<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>库存管理</title>
<script type="text/javascript" language="javascript">
<c:if test="${not empty id}">
$(document).ready(function(){
	$("input[type='button'][name='btnChoose']").attr("disabled",true);
	$("input[type='text'][name='vo.size']").attr("disabled",true);
	$("select[name=vo.storeId]").attr("disabled",true);
	$("select[name=vo.sort]").attr("disabled",true);
});
</c:if>

/**
 * 打开分类单选列表页面
 */
function openChooseDialog() {
	var pid=$("select[name=vo.sort]").find("option:selected").val();
	
	if($.trim(pid)!=""){
		var url="";
		if(pid=="MATERIAL"){
			url="<c:url value='/basic/material/single.jhtml'/>?rnd="+Math.random();
		}else if(pid=="PRODUCT"){
			url="<c:url value='/basic/product/single.jhtml'/>?rnd="+Math.random();
		}
		
		$.weeboxs.open(url, {
	   	    title:'名称选择',
	   	    contentType:'iframe', 
	   	 	width:800, height:400,
	   	 	onok:function(box){
		   	 	var name = "lstItems";
		   		box.find("iframe")[0].id   = name;
		   		box.find("iframe")[0].name = name;
		   		setTimeout(function(){
		   			var data = document.getElementById(name).contentWindow.getSelect();
		   			if(data!=null){
			   			if(document.getElementById("dataId")!=null){
							document.getElementById("dataId").value=data.id;
						}
						
			   			if(document.getElementById("name")!=null){
							document.getElementById("name").value=data.name;
						}
						
						ajaxCheck();
		   			}
		   			box.close();
		   		}, 20);
			}
		});
	}else{
		alert("请选择类型");
		return;
	}
}

function ajaxCheck(){
	var size =$("input[type='text'][name='vo.size']").val();
	var dataId =$("input[type='hidden'][name='vo.dataId']").val();
	var sort=$("select[name=vo.sort]").find("option:selected").val();
	var storeId=$("select[name=vo.storeId]").find("option:selected").val();
	
	if($.trim(dataId)!="" && $.trim(sort)!="" && $.trim(storeId)!=""){
		$.ajax({
	        type:"post",
	        url:"<c:url value='/store/storage/ajaxCheck.json' />",
	        cache:false,
	        data:{"vo.dataId":dataId,"vo.sort":sort,"vo.storeId":storeId,"vo.size":size,"rnd":Math.random()},
	        dataType:"json",
			success:function(msg){
				var obj = eval(msg);
				if(obj.isok){
					$("#msgFont").text("已存在");
					$("#save").attr("disabled",true);
				}else{
					$("#msgFont").text("可添加");
					$("#save").attr("disabled",false);
				}
	        }
		});
	}
}

function clearText(){
	$("input[type='text'][name='vo.name']").val("");
	$("input[type='hidden'][name='vo.dataId']").val("");
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>库存管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty id}">添&nbsp;&nbsp;&nbsp;&nbsp;加</c:if><c:if test="${not empty id}">修&nbsp;&nbsp;&nbsp;&nbsp;改</c:if></h3>
	<form name="form1" action="<c:url value='/store/storage/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
		<div class="ntable_mid mT10" >
	        <table width="100%" class="nt_table">
	            <tr>
	                <td width="80" class="gray" height="40" align="right" ><font color="red">*</font>类型：</td>
	                <td>
	                	<select name="vo.sort" onchange="clearText();ajaxCheck();" dataType="Require" msg="请选择类型">
	               			<option value="" <c:if test="${empty vo.sort }">selected="selected"</c:if>>---请选择---</option>
	                		<c:forEach var="sort" items="${sorts}">
	                			<option value="${sort }" <c:if test="${sort==vo.sort }">selected="selected"</c:if>>${sort.text }</option>
	                		</c:forEach>
	                	</select>
	                </td>
	                <td width="80" class="gray" height="40" align="right" ><font color="red">*</font>名称：</td>
	                <td>
	                	<input id="name" name="vo.name" type="text" class="ntext_01" value="${vo.name }" readonly="readonly" size="35" dataType="Require" msg="请选择" />
	                	<input id="dataId" name="vo.dataId" type="hidden" value="${vo.dataId }" />
	                	<input name="btnChoose" type="button" value="选择" onclick="openChooseDialog();" />
	                	<font id="msgFont" style="color: red;"></font>
	                </td>
	                <td width="80" class="gray" height="40" align="right" >码数：</td>
	                <td><input name="vo.size" type="text" class="ntext_01" value="${vo.size }" onblur="ajaxCheck();" maxlength="10" size="35" /></td>
	            </tr>
	            <tr>
	                <td width="80" class="gray" height="40" align="right" ><font color="red">*</font>仓库：</td>
	                <td>
	                	<select name="vo.storeId" onchange="ajaxCheck();" dataType="Require" msg="请选择仓库">
	                		<option value="" <c:if test="${empty vo.storeId}">selected="selected"</c:if>>---请选择---</option>
	                		<c:forEach var="store" items="${storeList }">
	                			<option value="${store.id }" <c:if test="${store.id==vo.storeId}">selected="selected"</c:if>>${store.name }</option>
	                		</c:forEach>
	                	</select>
	                </td>
	                <td width="80" class="gray" height="40" align="right" ><font color="red">*</font>数量：</td>
	                <td colspan="3"><input name="vo.amount" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.amount}</fmt:parseNumber>" size="35" dataType="Double" msg="请输入数量" /></td>
	            </tr>
	            <tr>
	                <td width="80" class="gray" height="40" align="right" >上限：</td>
	                <td><input name="vo.up" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.up}</fmt:parseNumber>" size="35" require="false" dataType="Double" msg="请输入实数" /></td>
	                <td width="80" class="gray" height="40" align="right" >下限：</td>
	                <td colspan="3"><input name="vo.down" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.down}</fmt:parseNumber>" size="35" require="false" dataType="Double" msg="请输入实数" /></td>
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

