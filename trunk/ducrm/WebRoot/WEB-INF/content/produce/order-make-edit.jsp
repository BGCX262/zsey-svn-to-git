<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单生成管理</title>
<script type="text/javascript" language="javascript">
function orderSubmit(){
	var makeState=$("select[name=vo.makeState]").find("option:selected").val();
	if($.trim(makeState)=="MAKE_YES"){
		if(window.confirm('你确定要提交吗？')){
			$(":input[type='hidden'][name='vo.state']").val("SCGL_SCRK");
			document.form1.submit();
		}
	}else{
		alert("生成状态为“已生产”方可提交。")
	}
	
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>订单生成管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">订单生成</h3>
<form name="form1" action="<c:url value='/produce/order-make/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);" enctype="multipart/form-data">
    <fieldset class="tableBox">
    	<legend><strong>客户及订单信息</strong></legend>
    	<table width="100%" class="nt_table">
			<tr>
                <td class="gray" width="100" height="40" align="right">客户名称：</td>
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
                <td>${vo.phone }</td>
                <td class="gray"  height="40" align="right">联系人手机：</td>
                <td>${vo.mobile }</td>
            </tr>
			<tr>
                <td class="gray"  height="40" align="right">地址：</td>
                <td colspan="3">${vo.address }</td>
                <td class="gray"  height="40" align="right">邮编：</td>
                <td>${vo.postcode }</td>
            </tr>
            <tr>
                <td class="gray"  height="40" align="right">订单编号：</td>
                <td>${vo.code }</td>
                <td class="gray"  height="40" align="right">紧急度：</td>
                <td colspan="3">${vo.grade.text }</td>
			</tr>
			<tr>
                <td class="gray"  height="40" align="right">应收金额：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.payment }</fmt:parseNumber></td>
                <td class="gray"  height="40" align="right">已收金额：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.payfor }</fmt:parseNumber></td>
                <td class="gray"  height="40" align="right">未收金额：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.payment-vo.payfor }</fmt:parseNumber></td>
			</tr>
			<tr>
                <td class="gray"  height="40" align="right">总数：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.total }</fmt:parseNumber></td>
                <td class="gray" height="40" align="right">生产状态：</td>
                <td colspan="3">
                	<select name="vo.makeState" dataType="Require" msg="请选择生成状态">
						<option value="" <c:if test="${empty vo.makeState }">selected="selected"</c:if>>---请选择---</option>
						<c:forEach var="state" items="${states}">
							<option value="${state }" <c:if test="${vo.makeState==state }">selected="selected"</c:if>>${state.text }</option>
						</c:forEach>
					</select>
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
					<th>名称</th>
					<th>码数</th>
					<th>单位</th>
					<th>数量</th>
					<th>单价</th>
					<th>金额</th>
					<th>备注</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="details" items="${orderList}" varStatus="status">
				<tr align="center">
					<td width="30">${status.count }</td>
					<td>${details.name }</td>
					<td width="50">${details.size }</td>
					<td width="50">${details.unit }</td>
					<td width="60"><fmt:parseNumber type="number" pattern="##0.00">${details.amount }</fmt:parseNumber></td>
					<td width="60"><fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber></td>
					<td width="60"><fmt:parseNumber type="number" pattern="##0.00">${details.price*details.amount }</fmt:parseNumber></td>
					<td width="150">${details.remark }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
	
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
		<input type="hidden" name="vo.state" value="${vo.state }" />
        <input type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" class="formBtn01" value="提 交" onclick="orderSubmit();" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/produce/order-make/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

