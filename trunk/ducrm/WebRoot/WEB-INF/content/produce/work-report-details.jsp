<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工作报告管理</title>
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>工作报告管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">工作报告</h3>
<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" height="40" align="right" >员工编号：</td>
                <td>${vo.employee.code }</td>
                <td class="gray" width="80" height="40" align="right" >姓名：</td>
                <td>${vo.employee.name }</td>
                <td class="gray" width="80" height="40" align="right" >部门：</td>
                <td>${vo.employee.department.name }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >产品编号：</td>
                <td>${vo.product.code }</td>
                <td class="gray" width="80" height="40" align="right" >产品名称：</td>
                <td colspan="3">${vo.product.name }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >工序编号：</td>
                <td>${vo.code }</td>
                <td class="gray" height="40" align="right" >工序名称：</td>
                <td>${vo.name }</td>
                <td class="gray" height="40" align="right" >日期：</td>
                <td>${vo.addDate}</td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right" >工价：</td>
                <td><fmt:parseNumber type="number" pattern="##0">${vo.price }</fmt:parseNumber></td>
                <td class="gray" width="80" height="40" align="right" >数量：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.amount }</fmt:parseNumber></td>
                <td class="gray" width="80" height="40" align="right" >金额：</td>
                <td><fmt:parseNumber type="number" pattern="##0.00">${vo.total }</fmt:parseNumber></td>
            </tr>
        </table>
    </div>
	
</div>
</body>
</html>

