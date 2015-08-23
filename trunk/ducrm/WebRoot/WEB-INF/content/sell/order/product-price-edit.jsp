<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品报价管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/customer/customer.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript" src="<c:url value='/js/base/product.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript" src="<c:url value='/js/sell/sell-order-list.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript">
/**
 * 总数和总额的汇总
 */
function countCostTots(){
	var total=0;
	var payment=0.0;
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
	
	$(":input[type='text'][name='vo.total']").val(total);
	$(":input[type='text'][name='vo.payment']").val(payment.toFixed(2));
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>产品报价管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/sell/order/product-price/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);" enctype="multipart/form-data">
    <fieldset class="tableBox">
    	<legend><strong>客户及订单信息</strong></legend>
    	<table width="100%" class="nt_table">
			<tr>
                <td class="gray" width="100" height="40" align="right"><font color="red">*</font>客户名称：</td>
                <td>
                	<input id="clientName" name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="35" dataType="Require" msg="请选择客户" />
                	<input id="clientId" name="vo.clientId" type="hidden" value="${vo.clientId }" />
                	<input type="button" value="选择" onclick="openSingleDialog();" />
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
                <td ><input id="postcode" name="vo.postcode" type="text" class="ntext_01" value="${vo.postcode }" size="35" require="false" dataType="Zip" msg="邮政编码格式不正确" /></td>
            </tr>
            <tr>
                <td class="gray"  height="40" align="right">订单编号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="${vo.code }" size="35" readonly="readonly"/></td>
                <td class="gray"  height="40" align="right"><font color="red">*</font>报价方式：</td>
                <td colspan="3">
                	<select name="vo.style" dataType="Require" msg="请选择报价方式">
						<option value="" <c:if test="${empty vo.style }">selected="selected"</c:if>>---请选择---</option>
						<c:forEach var="style" items="${types}">
							<option value="${style}" <c:if test="${vo.style==style }">selected="selected"</c:if>>${style.text }</option>
						</c:forEach>
					</select>
                </td>
			</tr>
            <tr>
                <td class="gray" height="40" align="right">总数：</td>
                <td><input name="vo.total" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.total }</fmt:parseNumber>" size="35" readonly="readonly" /></td>
                <td class="gray" height="40" align="right">总额：</td>
                <td colspan="3">
                	<input name="vo.payment" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.payment }</fmt:parseNumber>" size="35" readonly="readonly" />
                	<input name="vo.payfor" type="hidden" value="0.00" />
                	<input name="vo.nopay" type="hidden" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.payment }</fmt:parseNumber>" />
                </td>
			</tr>
        </table>
	</fieldset>
	
    <fieldset class="tableBox">
    	<legend><strong>订单明细</strong></legend>
    	<table width="100%" class="nm_table">
			<thead>
				<tr class="gray" align="center">
					<th>序号</th>
					<th>编号</th>
					<th>名称</th>
					<th>码数</th>
					<th>单位</th>
					<th>数量</th>
					<th>单价</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="detailsTbody">
				<c:forEach var="details" items="${orderList}" varStatus="status">
				<tr id="tr${details.id }" align="center">
					<td width="30">${status.count }<input name="proIds" type="hidden" value="${details.proId }" /></td>
					<td width="50"><input name="codes" type="text" class="ntext_01" value="${details.code }" maxlength="10" style="width: 98%;" /></td>
					<td><input name="names" type="text" class="ntext_01" value="${details.name }" maxlength="100" readonly="readonly" dataType="Require" msg="请输入名称" style="width: 98%;" /></td>
					<td width="50"><input name="sizes" type="text" class="ntext_01" value="${details.size }" maxlength="10" style="width: 98%;" /></td>
					<td width="50"><input name="units" type="text" class="ntext_01" value="${details.unit }" maxlength="10" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input name="amounts" type="text" class="ntext_01" value="${details.amount }" dataType="Double" msg="请输入数量" style="width: 98%;" onblur="countCostTots();" /></td>
					<td width="50"><input name="prices" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber>" readonly="readonly" dataType="Double" msg="请输入价格" style="width: 98%;" onblur="countCostTots();" /></td>
					<td width="150"><input name="remarks" type="text" class="ntext_01" value="${details.remark }" style="width: 98%;" maxlength="50" /></td>
					<td width="100">
						<span class="caozuo">
							<a href="javascript:void(null);" onclick="copyTr('tr${details.id }');" class="edit">复制</a>&nbsp;|&nbsp;
							<a href="javascript:void(null);" onclick="deleteTr('tr${details.id }');" class="del">删除</a>
						</span>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
    	<table width="100%" class="nm_table">
			<tr align="center">
				<td class="addRows">
					<a href="javascript:void(null);" onclick="openSelectMultiProduct();">添加明细</a>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</fieldset>
	
	<c:if test="${not empty auditList}">
	    <fieldset class="tableBox">
	    	<legend><strong>审核记录</strong></legend>
	    	<table width="100%" class="nm_table">
	            <thead>
					<tr class="gray" align="center">
						<th>序号</th>
						<th>审核人</th>
						<th>日期</th>
						<th>状态</th>
						<th>意见</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="audit" items="${auditList}" varStatus="status">
					<tr align="center">
						<td width="30">${status.count }</td>
						<td width="100">${audit.realname }</td>
						<td width="100">${audit.auditDate }</td>
						<td width="100">${audit.state.text }</td>
						<td>${audit.mind }</td>
					</tr>
					</c:forEach>
	            </tbody>
	        </table>
		</fieldset>
	</c:if>
	
    <c:if test="${not empty askList}">
	    <fieldset class="tableBox">
	    	<legend><strong>报价确认记录</strong></legend>
	    	<table width="100%" class="nm_table">
	            <thead>
					<tr class="gray" align="center">
						<th>序号</th>
						<th>审核人</th>
						<th>日期</th>
						<th>状态</th>
						<th>意见</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="audit" items="${askList}" varStatus="status">
					<tr align="center">
						<td width="30">${status.count }</td>
						<td width="100">${audit.realname }</td>
						<td width="100">${audit.auditDate }</td>
						<td width="100">${audit.state.text }</td>
						<td>${audit.mind }</td>
					</tr>
					</c:forEach>
	            </tbody>
	        </table>
		</fieldset>
	</c:if>
	
    <fieldset class="tableBox">
    	<legend><strong>附件明细</strong></legend>
	    <c:if test="${not empty accessList}">
	    	<table width="100%" class="nm_table">
	            <thead>
					<tr class="gray" align="center">
						<th>序号</th>
						<th>名称</th>
						<th>图片</th>
						<th>上传人</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="access" items="${accessList}" varStatus="status">
						<tr align="center">
							<td width="30">${status.count }</td>
							<td>${access.name }</td>
							<td width="80"><a href="<c:url value='${access.path }'/>" target="_blank"><img src="<c:url value='${access.path }' />" height="50" width="50" alt="${access.name }" /></a></td>
							<td width="80">${access.realname }</td>
							<td width="100">
								<span class="caozuo">
									<a href="<c:url value="/utils/accessory/download.jhtml?id=${access.id}" />" class="show">下载</a>&nbsp;|&nbsp;
									<a href="#" onclick="deleteAccess(${access.id});" class="del">删除</a>
								</span>
							</td>
						</tr>
					</c:forEach>
	            </tbody>
	        </table>
        </c:if>
		<div id="templetsDiv">
			附件：<input id="templets1" name="templets" type="file" class="formText" />
			<input id="buttons1" type="button" value="删除" onclick="deleteTemplet(1);" />
		</div>
    	<table width="100%" class="nm_table">
			<tr align="center"><td class="addRows"><a href="javascript:void(null);" onclick="addTemplet();">添加</a></td></tr>
		</table>
	</fieldset>
	
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
        <input type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/sell/order/product-price/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

