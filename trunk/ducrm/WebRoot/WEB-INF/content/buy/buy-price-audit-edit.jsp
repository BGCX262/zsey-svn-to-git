<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料询价管理</title>
<script type="text/javascript" language="javascript">
/**
 * 总数和总额的汇总
 */
function countCostTots(){
	var total=0;
	var payment=0.0;
	var amounts=$(":input[type='text'][name='amounts']").toArray();
	var prices=$(":input[type='text'][name='prices']").toArray();
	var sums=$(":input[type='text'][name='sums']").toArray();
	
	if((amounts!=null && amounts.length>0) && (prices!=null && prices.length>0)){
		for(var i=0;i<amounts.length;i++){
			var amount=($.trim(amounts[i].value)==""?0:parseInt($.trim(amounts[i].value)));
			var price=($.trim(prices[i].value)==""?0.00:parseFloat($.trim(prices[i].value)));
			var sum=amount*price;
			sums[i].value=sum.toFixed(2);
			total+=amount;
			payment+=sum;
		}
	}
	
	$(":input[type='hidden'][name='vo.total']").val(total);
	$(":input[type='hidden'][name='vo.payment']").val(payment.toFixed(2));
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>物料询价管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/buy/buy-price-audit/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);" enctype="multipart/form-data">
	<div class="ntable_mid mT10">
        <table width="100%" class="nt_table">
			<tr>
                <td class="gray" width="100" height="40" align="right">供应商：</td>
                <td>${vo.name }</td>
                <td class="gray" width="100" height="40" align="right">单位电话：</td>
                <td>${vo.phone }</td>
                <td class="gray" width="100" height="40" align="right">单位传真：</td>
                <td>${vo.fax }</td>
            </tr>
			<tr>
                <td class="gray"  height="40" align="right">联系人：</td>
                <td>${vo.linkman }</td>
                <td class="gray"  height="40" align="right">联系人电话：</td>
                <td>${vo.tel }</td>
                <td class="gray"  height="40" align="right">联系人手机：</td>
                <td>${vo.mobile }</td>
            </tr>
			<tr>
                <td class="gray" height="40" align="right">邮编：</td>
                <td>${vo.postcode }</td>
                <td class="gray"  height="40" align="right">地址：</td>
                <td colspan="3">${vo.address }</td>
            </tr>
            <tr>
                <td class="gray"  height="40" align="right">询价单号：</td>
                <td>${vo.code }</td>
                <td class="gray"  height="40" align="right">询价方式：</td>
                <td>${vo.askType.text}</td>
			</tr>
        </table>
    </div>
	
    <fieldset class="tableBox">
    	<legend><strong>询价明细</strong></legend>
    	<table width="100%" class="nm_table">
			<thead>
				<tr class="gray" align="center">
					<th>序号</th>
					<th>名称</th>
					<th>规格</th>
					<th>单位</th>
					<th>数量</th>
					<th>单价</th>
					<th>金额</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody id="detailsTbody">
				<c:forEach var="details" items="${orderList}" varStatus="status">
				<tr align="center">
					<td width="30">${status.count }<input name="ids" type="hidden" value="${details.id }" /></td>
					<td><input type="text" class="ntext_01" value="${details.name }" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input type="text" class="ntext_01" value="${details.spec }" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input type="text" class="ntext_01" value="${details.unit }" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input name="amounts" type="text" class="ntext_01" value="${details.amount }" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input name="prices" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber>" dataType="Double" msg="请输入单价" style="width: 98%;" onblur="countCostTots();" /></td>
					<td width="50"><input name="sums" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.price*details.amount }</fmt:parseNumber>" style="width: 98%;" /></td>
					<td width="150"><input name="remarks" type="text" class="ntext_01" value="${details.remark }" style="width: 98%;" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
	
	<fieldset class="tableBox">
    	<legend><strong>附件</strong></legend>
       <font color="red">*</font> 附件：<input name="uploadImage" type="file" class="formText" size="45" dataType="Require" msg="附件不能为空" />
	</fieldset>
	
	
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
		<input type="hidden" name="vo.state" value="${vo.state }" />
		<input type="hidden" name="vo.payment" value="${vo.payment }" />
		<input type="hidden" name="vo.total" value="${vo.total }" />
        <input type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/buy/buy-price-audit/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

