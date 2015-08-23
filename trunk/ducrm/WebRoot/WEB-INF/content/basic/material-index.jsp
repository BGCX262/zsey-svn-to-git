<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料管理</title>
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
	<form name="form1" action="<c:url value='/basic/material/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		编&nbsp;&nbsp;&nbsp;&nbsp;号: <input class="input" type="text" name=vo.code value="${vo.code}"  maxlength="9" style="width: 192px;"/>&nbsp;&nbsp;
		名&nbsp;&nbsp;&nbsp;&nbsp;称: <input class="input" type="text" name="vo.name" value="${vo.name}" style="width: 192px;"/><br />
		供应商: <input class="input" type="text" name="vo.provider.name" value="${vo.provider.name}" style="width: 192px;"/>&nbsp;&nbsp;
		分&nbsp;&nbsp;&nbsp;&nbsp;类: <input id="categoryName" name="vo.category.name" type="text" value="${vo.category.name }" class="input" style="width: 192px;" onclick="openSingleCategoryDialog()" readonly="readonly" />
			<input id="categoryId" type="hidden" name="vo.category.id" value="${vo.category.id}" />&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
		<input type="button" class="btn" value="添加" onclick="location.href='<c:url value='/basic/material/edit.jhtml'/>'"/>
	</div>
	</form>

    <div class="ntable_mid mT5">
		<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
			<display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
			<display:column title="编号" style="width:80px;">${vo.code}</display:column>
			<display:column title="供应商" style="width:200px;">${vo.provider.name}</display:column>
			<display:column title="名称">${vo.name}</display:column>
			<display:column title="规格" style="width:80px;">${vo.spec}</display:column>
			<display:column title="价格" style="width:100px;"><fmt:parseNumber type="number" pattern="##0.00">${vo.price}</fmt:parseNumber></display:column>
			<display:column title="分类" style="width:100px;">${vo.category.name}</display:column>
			<display:column title="操作" style="width:150px;">
				<span class="caozuo">
					<a href="#" onclick="openDialog('details.jhtml?id=${vo.id}','${vo.name}的详情');" class="show">详情</a>&nbsp;|&nbsp;
					<a href="edit.jhtml?id=${vo.id}" class="edit">编辑</a>&nbsp;|&nbsp;
					<a href="delete.jhtml?id=${vo.id}" class="del">删除</a>
				</span>
			</display:column>
			<display:setProperty name="paging.banner.item_name">物料</display:setProperty>
			<display:setProperty name="paging.banner.items_name">物料</display:setProperty>
		</display:table>
	</div>

</div>
</body>
</html>

