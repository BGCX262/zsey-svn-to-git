<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>员工管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">详情</h3>
    
    <fieldset class="tableBox">
    	<legend><strong>基本信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right" >编号：</td>
                <td>${vo.code }</td>
                <td class="gray" width="80" height="40" align="right">姓名：</td>
                <td>${vo.name }</td>
                <td class="gray" width="80" height="40" align="right">&nbsp;</td>
                <td>&nbsp;</td>
			</tr>
			<tr>
               <td class="gray" height="40" align="right" >证件类型：</td>
                <td>${vo.idtype.name}</td>
                <td class="gray" height="40" align="right" >证件编号：</td>
                <td>${vo.idcard }</td>
                <td rowspan="4" class="gray" width="80" height="40" align="right">相片：</td>
                <td rowspan="4">
                	<c:if test="${not empty vo.photo}">
                		<img alt="${vo.name }的相片" src="<c:url value='${vo.photo }'/>" width="80" height="100" />
                	</c:if>
                </td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right" >性别：</td>
                <td>${vo.sex.text }</td>
                <td class="gray" height="40" align="right" >出生日期：</td>
                <td>${vo.born }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >部门：</td>
                <td>${vo.department.name }</td>
                <td class="gray" height="40" align="right" >职务：</td>
                <td>${vo.duty.name}</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >民族：</td>
                <td>${vo.nation.name}</td>
                <td class="gray" height="40" align="right" >政治面貌：</td>
                <td>${vo.polity.name}</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >血型：</td>
                <td>${vo.blood.text}</td>
                <td class="gray" height="40" align="right" >学历</td>
                <td>${vo.degree.text}</td> 
                <td class="gray" height="40" align="right" >毕业学校</td>
                <td>${vo.school }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >身高：</td>
                <td>${vo.height }</td>
                <td class="gray" height="40" align="right" >体重：</td>
                <td>${vo.weight }</td>
                <td class="gray" height="40" align="right" >爱好：</td>
                <td>${vo.love }</td>
            </tr>
        </table>
	</fieldset>
	
    <fieldset class="tableBox">
    	<legend><strong>联系方式</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" height="40" align="right" >电话：</td>
                <td>${vo.phone }</td>
                <td class="gray" height="40" align="right" >手机：</td>
                <td colspan="3">${vo.mobile }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >QQ：</td>
                <td>${vo.qq }</td>
                <td class="gray" height="40" align="right" >邮箱：</td>
                <td>${vo.email }</td>
                <td class="gray" height="40" align="right" >邮编：</td>
                <td>${vo.postcode }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >省：</td>
                <td>${vo.province.name }</td>
                <td class="gray" height="40" align="right" >市：</td>
                <td>${vo.city.name}</td>
                <td class="gray" height="40" align="right" >地址：</td>
                <td>${vo.address }</td>
            </tr>
        </table>
	</fieldset>
	
    <fieldset class="tableBox">
    	<legend><strong>银行卡信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" height="40" align="right" >银行账号：</td>
                <td>${vo.bcode }</td>
                <td class="gray" height="40" align="right" >银行名称：</td>
                <td>${vo.bname }</td>
                <td class="gray" height="40" align="right" >开户人：</td>
                <td>${vo.bman }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >开户地址：</td>
                <td colspan="5">${vo.badd }</td>
            </tr>
        </table>
	</fieldset>
</div>
</body>
</html>

