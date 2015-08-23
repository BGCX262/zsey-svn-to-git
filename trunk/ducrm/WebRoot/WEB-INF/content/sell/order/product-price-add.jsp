<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品报价管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/customer/customer.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript" src="<c:url value='/js/sell/sell-order-list.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript">
function deleteTr(trId){
	$("#"+trId).remove();
	countCostTots();
}

/**
 * 复制行的内容
 */
function copyTr(trId){
	var a=$("#"+trId).clone();
	$("#detailsTbody").append(a);
	countCostTots();
}

/**
 * 总数和总额的汇总
 */
function countCostTots(){
	var total=0;
	var payment=0.0;
	var payfor=$(":input[type='text'][name='vo.payfor']").val();
	var amounts=$(":input[type='text'][name='amounts']").toArray();
	var prices=$(":input[type='text'][name='prices']").toArray();
	
	if((amounts!=null && amounts.length>0) && (prices!=null && prices.length>0)){
		for(var i=0;i<amounts.length;i++){
			var amount=($.trim(amounts[i].value)==""?0:parseInt($.trim(amounts[i].value)));
			var price=($.trim(prices[i].value)==""?0.00:parseFloat($.trim(prices[i].value)));
			total+=amount;
			payment+=(amount*price);
		}
	}
	
	$(":input[type='text'][name='vo.total']").val(total.toFixed(2));
	$(":input[type='text'][name='vo.payment']").val(payment.toFixed(2));
	$(":input[type='text'][name='vo.nopay']").val((payment-payfor).toFixed(2));
}



function appendDetails(data){
	var html="";
	html+="<tr id=\"tr"+data.id+"\" align=\"center\">";
	html+="<td width=\"30\">&nbsp;<input name=\"proIds\" type=\"hidden\" value=\""+data.id+"\" /></td>";
	html+="<td><input name=\"names\" type=\"text\" class=\"ntext_01\" value=\""+data.name+"\" readonly=\"readonly\" maxlength=\"100\" dataType=\"Require\" msg=\"请输入名称\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"sizes\" type=\"text\" class=\"ntext_01\" value=\"\" maxlength=\"10\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"units\" type=\"text\" class=\"ntext_01\" value=\""+data.unit+"\" readonly=\"readonly\" maxlength=\"10\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"amounts\" type=\"text\" class=\"ntext_01\" value=\"\" dataType=\"Number\" msg=\"请输入数量\" style=\"width: 98%;\" onblur=\"countCostTots();\" /></td>";
	html+="<td width=\"50\"><input name=\"prices\" type=\"text\" class=\"ntext_01\" value=\""+data.price+"\" dataType=\"Double\" msg=\"请输入价格\" style=\"width: 98%;\" onblur=\"countCostTots();\" /></td>";
	html+="<td width=\"150\"><input name=\"remarks\" type=\"text\" class=\"ntext_01\" value=\"\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"100\">";
	html+="<span class=\"caozuo\">";
	html+="<a href=\"javascript:void(null);\" onclick=\"copyTr('tr"+data.id+"');\" class=\"edit\">复制</a>&nbsp;|&nbsp;";
	html+="<a href=\"javascript:void(null);\" onclick=\"deleteTr('tr"+data.id+"');\" class=\"del\">删除</a>";
	html+="</span></td></tr>";
	$("#detailsTbody").append(html);
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>产品报价管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">生成订单</h3>
<form name="form1" action="<c:url value='/sell/order/sell-order/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);" enctype="multipart/form-data">
    <fieldset class="tableBox">
    	<legend><strong>客户及订单信息</strong></legend>
    	<table width="100%" class="nt_table">
			<tr>
                <td class="gray" width="100" height="40" align="right"><font color="red">*</font>客户名称：</td>
                <td>
                	<input id="clientName" name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="35" dataType="Require" msg="请选择客户" />
                	<input id="clientId" name="vo.clientId" type="hidden" value="${vo.clientId }" />
                </td>
                <td class="gray" width="100" height="40" align="right"><font color="red">*</font>单位电话：</td>
                <td><input id="phone" name="vo.phone" type="text" class="ntext_01" value="${vo.phone }" size="35" dataType="Phone" msg="请输入电话" /></td>
                <td class="gray" width="100" height="40" align="right">单位传真：</td>
                <td><input id="fax" name="vo.fax" type="text" class="ntext_01" value="${vo.fax }" size="35" require="false" dataType="Phone" msg="传真号码格式不正确" /></td>
            </tr>
			<tr>
                <td class="gray"  height="40" align="right">联系人：</td>
                <td><input id="linkman" name="vo.linkman" type="text" class="ntext_01" value="${vo.linkman }" size="35" /></td>
                <td class="gray"  height="40" align="right">联系人电话：</td>
                <td><input id="tel" name="vo.tel" type="text" class="ntext_01" value="${vo.phone }" size="35" require="false" dataType="Phone" msg="请输入联系人电话" /></td>
                <td class="gray"  height="40" align="right">联系人手机：</td>
                <td><input id="mobile" name="vo.mobile" type="text" class="ntext_01" value="${vo.mobile }" size="35" require="false" dataType="Mobile" msg="请输入联系人手机" /></td>
            </tr>
			<tr>
                <td class="gray"  height="40" align="right"><font color="red">*</font>地址：</td>
                <td><input id="address" name="vo.address" type="text" class="ntext_01" value="${vo.address }" size="35" dataType="Require" msg="请输入详细地址" /></td>
                <td class="gray"  height="40" align="right">邮编：</td>
                <td><input id="postcode" name="vo.postcode" type="text" class="ntext_01" value="${vo.postcode }" size="35" require="false" dataType="Zip" msg="邮政编码格式不正确" /></td>
                <td class="gray"  height="40" align="right"><font color="red">*</font>交付日期：</td>
                <td><input name="vo.deliver" type="text" class="ntext_01" value="" size="35" readonly="readonly" onclick="WdatePicker();"  dataType="Require" msg="请选择输入交付日期" /></td>
            </tr>
            <tr>
                <td class="gray"  height="40" align="right">订单编号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="" size="35" readonly="readonly"/></td>
                <td class="gray"  height="40" align="right"><font color="red">*</font>紧急度：</td>
                <td>
                	<select name="vo.grade" dataType="Require" msg="请选择订单紧急度">
						<option value="">---请选择---</option>
						<c:forEach var="grade" items="${grades}">
							<option value="${grade}">${grade.text }</option>
						</c:forEach>
					</select>
                </td>
                <td class="gray" height="40" align="right">总数：</td>
                <td><input name="vo.total" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.total }</fmt:parseNumber>" size="35" readonly="readonly" /></td>
			</tr>
            <tr>
                <td class="gray" height="40" align="right">应收金额：</td>
                <td><input name="vo.payment" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.payment }</fmt:parseNumber>" size="35" readonly="readonly" /></td>
                <td class="gray" height="40" align="right">已收金额：</td>
                <td><input name="vo.payfor" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.payfor }</fmt:parseNumber>" size="35" onblur="countCostTots();" /></td>
                <td class="gray" height="40" align="right">未收金额：</td>
                <td><input name="vo.nopay" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.payment-vo.payfor }</fmt:parseNumber>" size="35" readonly="readonly" /></td>
			</tr>
        </table>
	</fieldset>
	
    <fieldset class="tableBox">
    	<legend><strong>订单明细</strong></legend>
    	<table width="100%" class="nm_table">
			<thead>
				<tr class="gray" align="center">
					<th>序号</th>
					<th>名称</th>
					<th>码数</th>
					<th>单位</th>
					<th>数量</th>
					<th>单价</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody id="detailsTbody">
				<c:forEach var="details" items="${orderList}" varStatus="status">
				<tr id="tr${details.id }" align="center">
					<td width="30">${status.count }<input name="proIds" type="hidden" value="${details.proId }" /></td>
					<td><input name="names" type="text" class="ntext_01" value="${details.name }" maxlength="100" readonly="readonly" dataType="Require" msg="请输入名称" style="width: 98%;" /></td>
					<td width="50"><input name="sizes" type="text" class="ntext_01" value="${details.size }" readonly="readonly" maxlength="10" style="width: 98%;" /></td>
					<td width="50"><input name="units" type="text" class="ntext_01" value="${details.unit }" readonly="readonly" maxlength="10" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input name="amounts" type="text" class="ntext_01" value="${details.amount }" dataType="Double" msg="请输入数量" style="width: 98%;" onblur="countCostTots();" /></td>
					<td width="50"><input name="prices" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber>" readonly="readonly" dataType="Double" msg="请输入价格" style="width: 98%;" onblur="countCostTots();" /></td>
					<td width="150"><input name="remarks" type="text" class="ntext_01" value="${details.remark }" style="width: 98%;" /></td>
					<!-- 
					<td width="100">
						<span class="caozuo">
							<a href="javascript:void(null);" onclick="copyTr('tr${details.id }');" class="edit">复制</a>&nbsp;|&nbsp;
							<a href="javascript:void(null);" onclick="deleteTr('tr${details.id }');" class="del">删除</a>
						</span>
					</td>
					-->
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
	
	
	
	
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="" />
		<input type="hidden" name="vo.state" value="XSGL_DDGL_DDGL" />
        <input type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/sell/order/product-price/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

