<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>采购入库管理</title>
<script type="text/javascript" language="javascript">
/**
 * 保存验证
 */
function checkSave(){
	var isok=false;
	var msg="";
	var names=$(":input[type='hidden'][name='names']").toArray();//物料名称
	var buyAmounts=$(":input[type='hidden'][name='buyAmounts']").toArray();//采购数量
	var inAmounts=$(":input[type='hidden'][name='inAmounts']").toArray();//已进数量
	var buyPrices=$(":input[type='hidden'][name='buyPrices']").toArray();//采购价
	var amounts=$(":input[type='text'][name='amounts']").toArray();//入库数量
	var prices=$(":input[type='text'][name='prices']").toArray();//入库价
	
	if((amounts!=null && amounts.length>0) && (prices!=null && prices.length>0)){
		for(var i=0;i<amounts.length;i++){
			var amount=parseFloat(amounts[i].value);
			var buy=$.trim(buyAmounts[i].value)==""?0.0:parseFloat($.trim(buyAmounts[i].value));
			var input=parseFloat(inAmounts[i].value);
			var bp=parseFloat(buyPrices[i].value);
			var price=$.trim(prices[i].value)==""?0.0:parseFloat($.trim(prices[i].value));
			
			if(amount>buy){
				amounts[i].value=buy;
				msg+=names[i].value+"的进库数量大于采购数量\n";
				isok=true;
			}else if((amount+input)>buy){
				amounts[i].value=buy-input;
				msg+=names[i].value+"的进库数量大于采购数量\n";
				isok=true;
			}else if(bp!=price){
				prices[i].value=bp;
				msg+=names[i].value+"的采购价与入库价不匹配\n";
				isok=true;
			}
		}
	}
	
	if(isok){
		alert(msg);
	}
}

/**
 * 采购退回
 */
function buyBack(){
	if(window.confirm('你确定要退回此采购订单吗？')){
		location.href="<c:url value='/buy/buy-back/add.jhtml?id=${vo.id}'/>";
	}
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>采购入库管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/buy/buy-enter/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
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
                <td class="gray"  height="40" align="right">地址：</td>
                <td>${vo.address }</td>
                <td class="gray"  height="40" align="right">邮编：</td>
                <td colspan="3">${vo.postcode }</td>
            </tr>
            <tr>
                <td class="gray"  height="40" align="right">采购单号：</td>
                <td>${vo.code }</td>
                <td class="gray"  height="40" align="right"><font color="red">*</font>仓库：</td>
                <td colspan="3">
                	<select name="storeId" dataType="Require" msg="请选择仓库">
                		<option value="" <c:if test="${empty storeId}">selected="selected"</c:if>>---请选择---</option>
                		<c:forEach var="store" items="${storeList }">
                			<option value="${store.id }" <c:if test="${store.id==storeId}">selected="selected"</c:if>>${store.name }</option>
                		</c:forEach>
                	</select>
                </td>
			</tr>
        </table>
    </div>
	
    <fieldset class="tableBox">
    	<legend><strong>入库明细</strong></legend>
    	<table width="100%" class="nm_table">
			<thead>
				<tr class="gray" align="center">
					<th>序号</th>
					<th>名称及规格</th>
					<th>单位</th>
					<th>采购数量</th>
					<th>已进数量</th>
					<th>采购价</th>
					<th>采购金额</th>
					<th>未进数量</th>
					<th>入库价</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="details" items="${orderList}" varStatus="status">
				<tr id="tr" align="center">
					<td width="30">${status.count }<input name="ids" type="hidden" value="${details.id }" /></td>
					<td>
						<c:if test="${not empty details.name }">${details.name }</c:if><c:if test="${not empty details.spec }">${details.spec }</c:if>
						<input name="names" type="hidden" value="<c:if test="${not empty details.name }">${details.name }</c:if><c:if test="${not empty details.spec }">${details.spec }</c:if>" />
					</td>
					<td width="50">${details.unit }</td>
					<td width="50">
						<fmt:parseNumber type="number" pattern="##0.00">${details.amount }</fmt:parseNumber>
						<input name="buyAmounts" type="hidden" value="<fmt:parseNumber type="number" pattern="##0.00">${details.amount }</fmt:parseNumber>" />
					</td>
					<td width="50">
						<fmt:parseNumber type="number" pattern="##0.00">${details.inAmount }</fmt:parseNumber>
						<input name="inAmounts" type="hidden" value="<fmt:parseNumber type="number" pattern="##0.00">${details.inAmount }</fmt:parseNumber>" />
					</td>
					<td width="50">
						<fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber>
						<input name="buyPrices" type="hidden" value="<fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber>" />
					</td>
					<td width="50"><fmt:parseNumber type="number" pattern="##0.00">${details.price*details.amount }</fmt:parseNumber></td>
					<td width="50"><input name="amounts" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.amount-details.inAmount }</fmt:parseNumber>" dataType="Double" msg="请输入入库数量" onblur="checkSave();" style="width: 98%;" /></td>
					<td width="50"><input name="prices" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber>" dataType="Double" msg="请输入入库价" style="width: 98%;" onblur="checkSave();" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
	
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
        <input type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" class="formBtn01" value="退 回" onclick="buyBack();" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/buy/buy-enter/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>