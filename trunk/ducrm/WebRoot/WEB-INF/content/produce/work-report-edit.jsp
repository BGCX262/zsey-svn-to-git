<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工作报告管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/employee/employeeSelector.js' />" charset="utf-8"></script>
<script type="text/javascript" language="javascript">
/**
 * 产品工序选择（单选）
 */
function openSelectSingleWork() {
	var openUrl="<c:url value='/produce/product-work/single.jhtml'/>?rnd="+Math.random();
	
	$.weeboxs.open(openUrl, {
		title:'工序选择',
		contentType:'iframe', 
		width:800, height:450,
		onok:function(box){
	   	 	var name = "lstItems";
	   		box.find("iframe")[0].id   = name;
	   		box.find("iframe")[0].name = name;
	   		setTimeout(function(){
	   			var obj = document.getElementById(name).contentWindow.getSelectWork();
	   			if(obj!=null){
	   				$(":input[type='hidden'][name='vo.product.id']").val(obj.proId);
	   				$(":input[type='text'][name='vo.product.code']").val(obj.proCode);
	   				$(":input[type='text'][name='vo.product.name']").val(obj.proName);
	   				$(":input[type='text'][name='vo.code']").val(obj.code);
	   				$(":input[type='text'][name='vo.name']").val(obj.name);
	   				$(":input[type='hidden'][name='vo.workId']").val(obj.workId);
	   				$(":input[type='text'][name='vo.price']").val(obj.price);
	   				$(":input[type='text'][name='vo.amount']").val(1);
	   				$(":input[type='text'][name='vo.total']").val(obj.price);
	   			}else{
	   				alert("请选择工序");
	   			}
	   			box.close();
	   		}, 20);
		}
	});
}

function countTotal(){
	var amount=$(":input[type='text'][name='vo.amount']").val();
	var price=$(":input[type='text'][name='vo.price']").val();
	$(":input[type='text'][name='vo.total']").val((amount*price).toFixed(2));
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>工作报告管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">工作报告</h3>
<form name="form1" action="<c:url value='/produce/work-report/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);" enctype="multipart/form-data">
<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" height="40" align="right" ><font color="red">*</font>员工编号：</td>
                <td>
                	<input id="employeeId" name="vo.employee.id" type="hidden" value="${vo.employee.id }" />
                	<input id="employeeCode" name="employee.code" type="text" class="ntext_01" value="${vo.employee.code }" size="35" disabled="disabled" dataType="Require" msg="请选择员工" />&nbsp;&nbsp;
                	<input type="button" value="选择" onclick="openSelectSingleEmployee('<c:url value='/basic/employee/single.jhtml' />')" />
                </td>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>姓名：</td>
                <td><input id="employeeName" type="text" class="ntext_01" value="${vo.employee.name }" size="35" readonly="readonly" /></td>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>部门：</td>
                <td><input id="departmentName" type="text" class="ntext_01" value="${vo.employee.department.name }" size="35" readonly="readonly" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" ><font color="red">*</font>产品编号：</td>
                <td>
                	<input name="vo.product.id" type="hidden" value="${vo.product.id }" />
                	<input name="vo.product.code" type="text" class="ntext_01" value="${vo.product.code }" size="35" readonly="readonly" dataType="Require" msg="请选择产品工序" />&nbsp;&nbsp;
                	<input type="button" value="选择" onclick="openSelectSingleWork();" />
                </td>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>产品名称：</td>
                <td colspan="3"><input name="vo.product.name" type="text" class="ntext_01" value="${vo.product.name }" size="35" disabled="disabled" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" ><font color="red">*</font>工序编号：</td>
                <td>
                	<input name="vo.workId" type="hidden" value="${vo.workId }" />
                	<input name="vo.code" type="text" class="ntext_01" value="${vo.code }" size="35" readonly="readonly" />
                </td>
                <td class="gray" height="40" align="right" ><font color="red">*</font>工序名称：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="35" readonly="readonly" /></td>
                <td class="gray" height="40" align="right" ><font color="red">*</font>日期：</td>
                <td><input class="input" type="text" name=vo.addDate value="${vo.addDate}" readonly="readonly" onclick="WdatePicker()" dataType="Date" msg="请输入日期" /></td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>工价：</td>
                <td><input name="vo.price" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0">${vo.price }</fmt:parseNumber>" size="35" readonly="readonly" /></td>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>数量：</td>
                <td><input name="vo.amount" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.amount }</fmt:parseNumber>" size="35" onblur="countTotal();" dataType="Integer" msg="请输入数量" /></td>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>金额：</td>
                <td><input name="vo.total" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.total }</fmt:parseNumber>" size="35" readonly="readonly" /></td>
            </tr>
        </table>
    </div>
	
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
		<input type="hidden" name="vo.state" value="${vo.state}" />
        <input type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/produce/work-report/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

