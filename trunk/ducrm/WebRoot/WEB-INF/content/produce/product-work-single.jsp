<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品工序列表</title>
<script type="text/javascript" language="javascript">
function getSelectWork(){
	var obj={"id":"","proId":"","proCode":"","proName":"","workId":"","code":"","name":"","amount":"","price":"","total":""};
	var data=$("input[type='radio'][name='items']:checked").val();
	var array=data.split("|");
	obj.id=array[0];
	obj.proId=array[1];
	obj.proCode=array[2];
	obj.proName=array[3];
	obj.workId=array[4];
	obj.code=array[5];
	obj.name=array[6];
	obj.amount=array[7];
	obj.price=array[8];
	obj.total=array[9];
	return obj;
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>产品工序列表</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/produce/product-work/single.jhtml'/>" method="post">
	    <div class="frmBar mT5">
			产品编号: <input class="input" type="text" name="vo.product.code" value="${vo.product.code}" />&nbsp;&nbsp;
			产品名称: <input class="input" type="text" name="vo.product.name" value="${vo.product.name}" />&nbsp;&nbsp;
			工序编号: <input class="input" type="text" name="vo.code" value="${vo.code}" />&nbsp;&nbsp;
			工序名称: <input class="input" type="text" name="vo.name" value="${vo.name}" />&nbsp;&nbsp;
			<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
		</div>
	</form>

    <div class="ntable_mid mT5">
		<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="single.jhtml">
			<display:column title="" style="width:30px;">
               	<input name="items" type="radio" value="${vo.id}|${vo.product.id}|${vo.product.code}|${vo.product.name}|${vo.workId}|${vo.code}|${vo.name}|${vo.amount}|${vo.price}|${vo.total}" />
			</display:column>
			<display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
			<display:column title="编号" style="width:80px;">${vo.code}</display:column>
			<display:column title="名称">${vo.name}</display:column>
			<display:column title="价格" style="width:80px;">${vo.price}</display:column>
			<display:column title="所属产品">${vo.product.name}</display:column>
			<display:setProperty name="paging.banner.item_name">产品工序</display:setProperty>
			<display:setProperty name="paging.banner.items_name">产品工序</display:setProperty>
		</display:table>
	</div>
</div>
</body>
</html>

