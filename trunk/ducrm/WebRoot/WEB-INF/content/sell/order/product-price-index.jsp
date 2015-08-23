<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品报价管理</title>
<script type="text/javascript" language="javascript">
/**
 * 功能：订单提交
 */
function orderSubmit(){
	var id=$("input[type='radio'][name='id']:checked").val();
	if($.trim(id)!=""){
		if(window.confirm('你确定要提交吗？')){
			location.href="<c:url value='/sell/order/product-price/submit.jhtml'/>?id="+id+"&rnd="+Math.random();
		}
	}
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>产品报价管理</strong></h2>
    </div>
	<form name="form1" action="<c:url value='/sell/order/product-price/index.jhtml'/>" method="post">
    <div class="frmBar mT5">
		编号: <input class="input" type="text" name=vo.code value="${vo.code}"/>&nbsp;&nbsp;
		客户名称: <input class="input" type="text" name="vo.name" value="${vo.name}"/>&nbsp;&nbsp;
		<input type="submit" class="btn" value="搜索" />&nbsp;&nbsp;
		<input type="button" class="btn" value="添加" onclick="location.href='<c:url value='/sell/order/product-price/edit.jhtml'/>'"/>&nbsp;&nbsp;
		<input type="button" class="btn" value="提交" onclick="orderSubmit()"/>
	</div>
	</form>

    <div class="ntable_mid mT5">
		<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="index.jhtml">
			<display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
			<display:column title="选择" style="width:30px;">
				<c:if test="${vo.audit=='AUDIT_WAIT'}"><input name="id" type="radio" value="${vo.id}" /></c:if>
			</display:column>
			<display:column title="编号" style="width:100px;">${vo.code}</display:column>
			<display:column title="客户名称">${vo.name}</display:column>
			<display:column title="总额" style="width:80px;"><fmt:parseNumber type="number" pattern="##0.00">${vo.payment}</fmt:parseNumber></display:column>
			<display:column title="操作" style="width:150px;">
				<span class="caozuo">
					<a href="javascript:void(null);" onclick="openDialog('details.jhtml?id=${vo.id}','${vo.code }产品报价详情');" class="show">详情</a>
					<c:if test="${vo.audit=='AUDIT_WAIT'}">
						&nbsp;|&nbsp;<a href="edit.jhtml?id=${vo.id}" class="edit">编辑</a>
						&nbsp;|&nbsp;<a href="delete.jhtml?id=${vo.id}" class="del">删除</a>
					</c:if>
					<c:if test="${vo.audit=='AUDIT_YES'}">
						&nbsp;|&nbsp;<a href="print.jhtml?id=${vo.id}" target="_blank" class="show">打印</a>
						<c:if test="${vo.ask=='PRICE_YES'}">
							&nbsp;|&nbsp;<a href="add.jhtml?id=${vo.id}" class="edit">生成订单</a>
						</c:if>
					</c:if>
				</span>
			</display:column>
			<display:setProperty name="paging.banner.item_name">产品报价</display:setProperty>
			<display:setProperty name="paging.banner.items_name">产品报价</display:setProperty>
		</display:table>
	</div>

</div>
</body>
</html>

