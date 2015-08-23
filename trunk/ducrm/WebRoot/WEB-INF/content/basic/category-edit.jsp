<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>分类管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/category/category.js'/>" charset="utf-8"></script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>分类管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/basic/category/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>编号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="${vo.code }" size="55" readonly="readonly" /></td>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>名称：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="55" dataType="Require" msg="请输入名称" /></td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>类型：</td>
                <td>
	                <select id="categorySort" name="vo.sort" dataType="Require" msg="请选择类型">
						<option value="" <c:if test="${empty vo.sort}">selected="selected"</c:if>>---请选择---</option>
						<c:forEach var="sort" items="${sorts}">
							<option value="${sort }" <c:if test="${vo.sort== sort}">selected="selected"</c:if>>${sort.text }</option>
						</c:forEach>
					</select>
                </td>
                <td class="gray" width="80" height="40" align="right">所属分类：</td>
                <td>
                	<input id="categoryName" name="vo.category.name" type="text" class="ntext_01" value="${vo.category.name }" size="35" disabled="disabled" />
                	<input id="categoryId" type="hidden" name="vo.category.id" value="${vo.category.id}" />
                	<input type="button" value="选择" onclick="openSingleCategoryDialog()" />
                </td>
            </tr>
        </table>
    </div>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/basic/category/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

