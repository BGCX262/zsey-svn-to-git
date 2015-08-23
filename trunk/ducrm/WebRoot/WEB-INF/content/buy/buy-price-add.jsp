<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料询价管理</title>
<script type="text/javascript" language="javascript">
$(document).ready(function(){
	countCostTots();
});

/**
 * 总数和总额的汇总
 */
function countCostTots(){
	var total=0.0;
	var payment=0.0;
	var amounts=$(":input[type='text'][name='amounts']").toArray();
	var prices=$(":input[type='text'][name='prices']").toArray();
	var sums=$(":input[type='text'][name='sums']").toArray();
	var payfor=$("input[type='text'][name='vo.payfor']").val();
	
	if((amounts!=null && amounts.length>0) && (prices!=null && prices.length>0)){
		for(var i=0;i<amounts.length;i++){
			var amount=($.trim(amounts[i].value)==""?0:parseFloat($.trim(amounts[i].value)));
			var price=($.trim(prices[i].value)==""?0.00:parseFloat($.trim(prices[i].value)));
			var sum=amount*price;
			sums[i].value=sum.toFixed(2);
			total+=amount;
			payment+=sum;
		}
	}
	
	$(":input[type='text'][name='vo.total']").val(total);
	$("input[type='text'][name='vo.payment']").val(payment.toFixed(2));
	$("input[type='text'][name='vo.nopay']").val((payment-payfor).toFixed(2));
}

</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>物料询价管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">生成采购单</h3>
<form name="form1" action="<c:url value='/buy/buy-order/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10">
        <table width="100%" class="nt_table">
			<tr>
                <td class="gray" width="100" height="40" align="right"><font color="red">*</font>供应商：</td>
                <td>
                	<input id="providerName" name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="35" dataType="Require" msg="请选择客户" />
                	<input id="providerId" name="vo.clientId" type="hidden" value="${vo.clientId }" />
                </td>
                <td class="gray" width="100" height="40" align="right"><font color="red">*</font>单位电话：</td>
                <td><input id="phone" name="vo.phone" type="text" class="ntext_01" value="${vo.phone }" size="35" dataType="Phone" msg="请输入电话" /></td>
                <td class="gray" width="100" height="40" align="right">单位传真：</td>
                <td><input id="fax" name="vo.fax" type="text" class="ntext_01" value="${vo.fax }" size="35" require="false" dataType="Phone" msg="传真号码格式不正确" /></td>
            </tr>
			<tr>
                <td class="gray"  height="40" align="right">联系人：</td>
                <td><input id="linkman" name="vo.linkman" type="text" class="ntext_01" value="${vo.linkman }" size="35" maxlength="20" /></td>
                <td class="gray"  height="40" align="right">联系人电话：</td>
                <td><input id="tel" name="vo.tel" type="text" class="ntext_01" value="${vo.tel }" size="35" require="false" dataType="Phone" msg="请输入联系人电话" /></td>
                <td class="gray"  height="40" align="right">联系人手机：</td>
                <td><input id="mobile" name="vo.mobile" type="text" class="ntext_01" value="${vo.mobile }" size="35" require="false" dataType="Mobile" msg="请输入联系人手机" /></td>
            </tr>
			<tr>
                <td class="gray"  height="40" align="right"><font color="red">*</font>地址：</td>
                <td><input id="address" name="vo.address" type="text" class="ntext_01" value="${vo.address }" size="35" dataType="Require" msg="请输入详细地址" /></td>
                <td class="gray"  height="40" align="right">邮编：</td>
                <td colspan="3"><input id="postcode" name="vo.postcode" type="text" class="ntext_01" value="${vo.postcode }" size="35" require="false" dataType="Zip" msg="邮政编码格式不正确" /></td>
            </tr>
            <tr>
                <td class="gray"  height="40" align="right">采购单号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="" readonly="readonly" size="35" /></td>
                <td class="gray"  height="40" align="right">总数：</td>
                <td colspan="3"><input name="vo.total" type="text" class="ntext_01" value="${vo.total }" readonly="readonly" size="35" /></td>
			</tr>
			<tr>
                <td class="gray"  height="40" align="right">应付金额：</td>
                <td><input name="vo.payment" type="text" class="ntext_01" value="${vo.payment }" readonly="readonly" size="35" /></td>
                <td class="gray"  height="40" align="right">已付金额：</td>
                <td><input name="vo.payfor" type="text" class="ntext_01" value="0.00" size="35" onblur="countCostTots();" /></td>
                <td class="gray"  height="40" align="right">未付金额：</td>
                <td><input name="vo.nopay" type="text" class="ntext_01" value="${vo.payment }" size="35"  readonly="readonly" /></td>
			</tr>
        </table>
    </div>
	
    <fieldset class="tableBox">
    	<legend><strong>采购明细</strong></legend>
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
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="detailsTbody">
				<c:forEach var="details" items="${orderList}" varStatus="status">
				<tr id="tr${details.id }" align="center">
					<td width="30">${status.count }<input name="mateIds" type="hidden" value="${details.mateId }" /></td>
					<td><input name="names" type="text" class="ntext_01" value="${details.name }" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input name="specs" type="text" class="ntext_01" value="${details.spec }" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input name="units" type="text" class="ntext_01" value="${details.unit }" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input name="amounts" type="text" class="ntext_01" value="${details.amount }" onblur="countCostTots();" dataType="Double" msg="请输入数量" style="width: 98%;" /></td>
					<td width="50"><input name="prices" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber>" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input name="sums" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.price*details.amount }</fmt:parseNumber>" readonly="readonly" style="width: 98%;" /></td>
					<td width="150"><input name="remarks" type="text" class="ntext_01" value="${details.remark }" style="width: 98%;" /></td>
					<td width="50">
						<span class="caozuo">
							<a href="javascript:void(null);" onclick="deleteTr('tr${details.id }');" class="del">删除</a>
						</span>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>	
	
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.state" value="CGGL_WLCG_CGSH" />
        <input type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/buy/buy-price/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

