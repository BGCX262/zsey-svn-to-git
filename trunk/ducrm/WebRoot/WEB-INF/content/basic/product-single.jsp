<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品管理</title>
<script type="text/javascript" language="javascript">
/**
 * 返回选中的产品信息
 */
function getSelect(){
	var obj={"id":"","code":"","name":"","price":""};
	var data=$("input[type='radio'][name='items']:checked").val();
	var array=data.split("|");
	obj.id=array[0];
	obj.code=array[1];
	obj.name=array[2];
	obj.price=array[3];
	return obj;
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>产品管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/basic/product/single.jhtml'/>" method="post">
    <div class="frmBar mT5">
		编号: <input class="input" type="text" name=vo.code value="${vo.code}" maxlength="9"/>&nbsp;&nbsp;
		名称: <input class="input" type="text" name="vo.name" value="${vo.name}"/>&nbsp;&nbsp;
		类型：<select name="vo.type">
   			<option value="" <c:if test="${empty vo.type }">selected="selected"</c:if>>---请选择---</option>
    		<c:forEach var="type" items="${types}">
    			<option value="${type }" <c:if test="${type==vo.type }">selected="selected"</c:if>>${type.text }</option>
    		</c:forEach>
    	</select>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />
	</div>
	</form>

    <div class="ntable_mid mT5">
		<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="single.jhtml">
            <display:column title="" style="width:30px;">
       			<input name="items" type="radio" value="${vo.id}|${vo.code}|${vo.name}|${vo.price}" />
      		</display:column>
           <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
			<display:column title="编号" style="width:100px;">${vo.code}</display:column>
			<display:column title="名称">${vo.name}</display:column>
			<display:column title="分类" style="width:100px;">${vo.category.name}</display:column>
			<display:column title="类型" style="width:60px;">${vo.type.text}</display:column>
			<display:setProperty name="paging.banner.item_name">产品</display:setProperty>
			<display:setProperty name="paging.banner.items_name">产品</display:setProperty>
		</display:table>
	</div>

</div>
</body>
</html>

