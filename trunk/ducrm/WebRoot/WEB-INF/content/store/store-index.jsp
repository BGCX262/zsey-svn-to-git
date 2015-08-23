<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库管理</title>
<script type="text/javascript" language="javascript">
/**
 * 打开添加页面
 */
function openAddStoreDialog(id){
	var url="<c:url value='/store/store/edit.jhtml'/>?id="+id+"&rnd="+Math.random();
	
	$.weeboxs.open(url,{
		title:'仓库管理',
		contentType:'iframe',
		width:750, height:450,
		showButton:false,
		onok:function(box){
			var name = "lstItems";
			box.find("iframe")[0].id   = name;
			box.find("iframe")[0].name = name;
			setTimeout(function(){
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
        <h2><strong>仓库管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/store/store/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		名称: <input class="input" type="text" name="vo.name" value="${vo.name}" size="20"/>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
		<input type="button" class="btn" value="添加" onclick="openAddStoreDialog('');"/>
	</div>
	</form>

    <div class="ntable_mid mT5">
			<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
                <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
				<display:column title="名称">${vo.name}</display:column>
				<display:column title="操作" style="width:100px;">
					<span class="caozuo">
						<a href="javascript:void(null);" onclick="openAddStoreDialog(${vo.id});" class="edit">编辑</a>&nbsp;|&nbsp;
						<a href="delete.jhtml?id=${vo.id}'" class="del">删除</a>
					</span>
				</display:column>
				<display:setProperty name="paging.banner.item_name">仓库</display:setProperty>
				<display:setProperty name="paging.banner.items_name">仓库</display:setProperty>
			</display:table>
	</div>

</div>
</body>
</html>

