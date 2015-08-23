<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="javascript" type="text/javascript">
function openSingleDepartmentDialog() {
	var url="<c:url value='/basic/category/single.jhtml?vo.sort=DEPARTMENT&rnd='/>"+Math.random();
	$.weeboxs.open(url, {
   	    title:'部门选择',
   	    contentType:'iframe', 
   	 	width:800, height:400,
   	 	onok:function(box){
	   	 	var name = "lstItems";
	   		box.find("iframe")[0].id   = name;
	   		box.find("iframe")[0].name = name;
	   		setTimeout(function(){
	   			var data = document.getElementById(name).contentWindow.getSelectCategory();
	   			if(data!=null){
		   			if(document.getElementById("departmentId")!=null){
						document.getElementById("departmentId").value=data.id;
					}
					
		   			if(document.getElementById("departmentName")!=null){
						document.getElementById("departmentName").value=data.name;
					}
	   			}
	   			box.close();
	   		}, 20);
		}
	});
}
</script>
<title>员工管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>员工管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/basic/employee/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		编号: <input class="input" type="text" name=vo.code value="${vo.code}" size="35"/>&nbsp;&nbsp;
		姓名: <input class="input" type="text" name="vo.name" value="${vo.name}" size="35"/>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
		<input type="button" class="btn" value="添加" onclick="location.href='<c:url value='/basic/employee/edit.jhtml'/>'"/>
	</div>
	</form>

    <div class="ntable_mid mT5">
			<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
                <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
				<display:column title="编号" style="width:80px;">${vo.code}</display:column>
				<display:column title="姓名" style="width:200px;">${vo.name}</display:column>
				<display:column title="职务" style="width:100px;">${vo.duty.name}</display:column>
				<display:column title="部门" style="width:100px;">${vo.department.name}</display:column>
				<display:column title="电话" style="width:100px;">${vo.phone}</display:column>
				<display:column title="手机" style="width:100px;">${vo.mobile}</display:column>
				<display:column title="操作" style="width:150px;">
					<span class="caozuo">
						<a href="#" onclick="openDialog('details.jhtml?id=${vo.id}','${vo.name }的详情');" class="show">详情</a>&nbsp;|&nbsp;
						<a href="edit.jhtml?id=${vo.id}" class="edit">编辑</a>&nbsp;|&nbsp;
						<a href="delete.jhtml?id=${vo.id}" class="del">删除</a>
					</span>
				</display:column>
				<display:setProperty name="paging.banner.item_name">员工</display:setProperty>
				<display:setProperty name="paging.banner.items_name">员工</display:setProperty>
			</display:table>
	</div>

</div>
</body>
</html>

