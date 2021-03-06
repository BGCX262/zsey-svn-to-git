<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物料询价管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/provider/provider.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript">
function openSelectMultiMaterial() {
	var clientId=$(":input[type='hidden'][name='vo.clientId']").val();
	if($.trim(clientId)!=""){
		var url="<c:url value='/basic/material/check.jhtml'/>?vo.provider.id="+clientId+"&rnd="+Math.random();
		$.weeboxs.open(url, {
			title:'物料选择',
			contentType:'iframe', 
			width:800, height:400,
			onok:function(box){
				var name = "lstItems";
				box.find("iframe")[0].id   = name;
				box.find("iframe")[0].name = name;
				setTimeout(function(){
					var data = document.getElementById(name).contentWindow.kt_getResult();
					for(var i=0; i<data.length; i++){
						appendDetails(data[i]);
					}
					box.close();
				}, 20);
			}
		});
	}else{
		alert("请先选择供应商");
	}
}

function kt_init_data(){ 
	var proIds=$(":input[type='hidden'][name='mateIds']").toArray();
	var names=$(":input[type='text'][name='names']").toArray();
	var data = {"keys":"","names":""};
	
	for(var i=0; i<proIds.length; i++){
		if($.trim(proIds[i].value)!=""){
			data.keys += proIds[i].value + ",";
			data.names += names[i].value + ",";
		}
	}
	return data;
}

function appendDetails(data){
	var html="";
	html+="<tr id=\"tr"+data.id+"\" align=\"center\">";
	html+="<td width=\"30\">&nbsp;<input name=\"mateIds\" type=\"hidden\" value=\""+data.id+"\" /></td>";
	html+="<td><input name=\"names\" type=\"text\" class=\"ntext_01\" value=\""+data.name+"\" readonly=\"readonly\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"specs\" type=\"text\" class=\"ntext_01\" value=\""+data.spec+"\" readonly=\"readonly\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"units\" type=\"text\" class=\"ntext_01\" value=\""+data.unit+"\" readonly=\"readonly\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"amounts\" type=\"text\" class=\"ntext_01\" value=\"\" dataType=\"Double\" msg=\"请输入数量\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"prices\" type=\"text\" class=\"ntext_01\" value=\""+data.price+"\" readonly=\"readonly\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"150\"><input name=\"remarks\" type=\"text\" class=\"ntext_01\" value=\"\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\">";
	html+="<span class=\"caozuo\">";
	html+="<a href=\"javascript:void(null);\" onclick=\"deleteTr('tr"+data.id+"');\" class=\"del\">删除</a>";
	html+="</span>";
	html+="</td>";
	html+="</tr>";
	$("#detailsTbody").append(html);
}

function orderSubmit(){
	$(":input[type='hidden'][name='vo.state']").val("CGGL_WLZX_XJQR");
	document.form1.submit();
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>物料询价管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/buy/buy-price/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);">
	<div class="ntable_mid mT10">
        <table width="100%" class="nt_table">
			<tr>
                <td class="gray" width="100" height="40" align="right"><font color="red">*</font>供应商：</td>
                <td>
                	<input id="providerName" name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="35" dataType="Require" msg="请选择客户" />
                	<input id="providerId" name="vo.clientId" type="hidden" value="${vo.clientId }" />
                	<input type="button" value="选择" onclick="openSelectSingleProvider();" />
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
                <td class="gray"  height="40" align="right">询价单号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="${vo.code }" readonly="readonly" size="35" /></td>
                <td class="gray"  height="40" align="right"><font color="red">*</font>询价方式：</td>
                <td colspan="3">
                	<select name="vo.askType" dataType="Require" msg="请选择询价方式">
						<option value="" <c:if test="${empty vo.askType }">selected="selected"</c:if>>---请选择---</option>
						<c:forEach var="askType" items="${types}">
							<option value="${askType }" <c:if test="${vo.askType==askType }">selected="selected"</c:if>>${askType.text }</option>
						</c:forEach>
					</select>
                </td>
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
					<td width="50"><input name="amounts" type="text" class="ntext_01" value="${details.amount }" dataType="Double" msg="请输入数量" style="width: 98%;" /></td>
					<td width="50"><input name="prices" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber>" readonly="readonly" style="width: 98%;" /></td>
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
    	<table width="100%" class="nm_table">
			<tr align="center">
				<td class="addRows" colspan="11"><a href="javascript:void(null);" onclick="openSelectMultiMaterial();">添加明细</a></td>
			</tr>
		</table>
	</fieldset>	
	
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
		<input type="hidden" name="vo.state" value="${vo.state }" />
        <input type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
        <c:if test="${not empty vo.id && vo.state=='CGGL_WLZX_XJZX'}">
        	<input type="button" class="formBtn01" value="提 交" onclick="orderSubmit();" />&nbsp;&nbsp;&nbsp;&nbsp;
        </c:if>
		<input type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/buy/buy-price/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

