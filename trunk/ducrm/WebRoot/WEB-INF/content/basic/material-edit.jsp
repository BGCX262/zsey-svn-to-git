<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/provider/provider.js'/>" charset="utf-8"></script>
<script language="javascript" type="text/javascript">
function openSingleCategoryDialog() {
	var url="<c:url value='/basic/category/single.jhtml?vo.sort=MATERIAL&rnd='/>"+Math.random();
	$.weeboxs.open(url, {
   	    title:'分类选择',
   	    contentType:'iframe', 
   	 	width:800, height:400,
   	 	onok:function(box){
	   	 	var name = "lstItems";
	   		box.find("iframe")[0].id   = name;
	   		box.find("iframe")[0].name = name;
	   		setTimeout(function(){
	   			var data = document.getElementById(name).contentWindow.getSelectCategory();
	   			if(data!=null){
		   			if(document.getElementById("categoryId")!=null){
						document.getElementById("categoryId").value=data.id;
					}
					
		   			if(document.getElementById("categoryName")!=null){
						document.getElementById("categoryName").value=data.name;
					}
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
        <h2><strong>物料管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/basic/material/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);" enctype="multipart/form-data">
	<fieldset class="tableBox">
    	<legend><strong>供应商信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>供应商编号：</td>
                <td>
                	<input id="providerId" name="vo.provider.id" type="hidden" value="${vo.provider.id }" />
                	<input id="providerCode" name="vo.provider.code" type="text" class="ntext_01" value="${vo.provider.code }" readonly="readonly" size="35" dataType="Require" msg="请选择供应商" />&nbsp;&nbsp;
                	<input type="button" value="选择" onclick="openSelectSingleProvider()" />
                </td>
                <td class="gray" width="80" height="40" align="right">供应商名称：</td>
                <td><input id="providerName" name="vo.provider.name" type="text" class="ntext_01" value="${vo.provider.name }" size="35" /></td>
                <td class="gray" width="80" height="40" align="right">联系人：</td>
                <td><input id="linkman" type="text" class="ntext_01" value="${vo.provider.linkman }" size="35" disabled="disabled" /></td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right">联系人电话：</td>
                <td><input id="tel" type="text" class="ntext_01" value="${vo.provider.tel }" size="35" disabled="disabled" /></td>
                <td class="gray" width="80" height="40" align="right">联系人手机：</td>
                <td><input id="mobile" type="text" class="ntext_01" value="${vo.provider.mobile }" size="35" disabled="disabled" /></td>
                <td class="gray" width="80" height="40" align="right">邮编：</td>
                <td><input id="postcode" type="text" class="ntext_01" value="${vo.provider.postcode }" size="35" disabled="disabled" /></td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right">单位电话：</td>
                <td><input id="phone" type="text" class="ntext_01" value="${vo.provider.phone }" size="35" disabled="disabled" /></td>
                <td class="gray" width="80" height="40" align="right">单位传真：</td>
                <td><input id="fax" type="text" class="ntext_01" value="${vo.provider.fax }" size="35" disabled="disabled" /></td>
                <td class="gray" width="80" height="40" align="right">单位地址：</td>
                <td><input id="address" type="text" class="ntext_01" value="${vo.provider.mobile }" size="35" disabled="disabled" /></td>
            </tr>
        </table>
	</fieldset>
	
	<fieldset class="tableBox">
    	<legend><strong>物料信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>编号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="${vo.code }" size="35" maxlength="9" disabled="disabled" /></td>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>名称：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="35" maxlength="50" dataType="Require" msg="请输入名称" /></td>
                <td class="gray" height="40" align="right">规格：</td>
                <td><input name="vo.spec" type="text" class="ntext_01" value="${vo.spec }" size="35" /></td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>分类：</td>
                <td>
					<input id="categoryName" name="vo.category.name" type="text" class="ntext_01" value="${vo.category.name }" readonly="readonly" size="35" dataType="Require" msg="请选择分类" />&nbsp;&nbsp;
					<input id="categoryId" type="hidden" name="vo.category.id" value="${vo.category.id}" />
					<input type="button" value="选择" onclick="openSingleCategoryDialog();" />
                </td>
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
                <td><input name="vo.price" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.price}</fmt:parseNumber>" size="35" dataType="Double" msg="请输入价格" /></td>
            </tr>
        </table>
	</fieldset>
	
	<fieldset class="tableBox">
    	<legend><strong>物料图片</strong></legend>
    	<div id="templetsDiv">图片：<input name="templets" type="file" class="formText" /></div>
		<table width="100%" class="nm_table">
			<tr align="center"><td class="addRows"><a href="javascript:void(null);" onclick="addTemplet();">添加</a></td></tr>
		</table>
		
		<c:if test="${not empty accessList}">
	    	<table width="100%" class="nm_table">
	            <thead>
					<tr class="gray" align="center">
						<th>序号</th>
						<th>名称</th>
						<th>图片</th>
						<th>上传人</th>
						<th>上传时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="lightBoxTbody">
					<c:forEach var="access" items="${accessList}" varStatus="status">
					<tr id="tr${access.id}" align="center">
						<td width="30">${status.count }</td>
						<td>${access.name }</td>
						<td width="80"><a href="<c:url value='${access.path }'/>" target="_blank"><img src="<c:url value='${access.path }'/>" height="50" width="50" alt="${access.name }" /></a></td>
						<td width="80">${access.realname }</td>
						<td width="120">${access.createTime }</td>
						<td width="100">
							<span class="caozuo">
								<a href="<c:url value="/utils/accessory/download.jhtml?id=${access.id}" />" class="edit">下载</a>&nbsp;|&nbsp;
								<a href="#" onclick="deleteAccessory(${access.id});" class="del">删除</a>
							</span>
						</td>
					</tr>
					</c:forEach>
	            </tbody>
	        </table>
		</c:if>
	</fieldset>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/basic/material/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

