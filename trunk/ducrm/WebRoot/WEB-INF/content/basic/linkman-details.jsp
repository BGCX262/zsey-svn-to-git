<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>联系人管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>联系人管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5">查看</h3>
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right">姓名：</td>
                <td>${vo.name }</td>
                <td class="gray" width="80" height="40" align="right">性别：</td>
                <td>${vo.sex.text }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right">电话：</td>
                <td>${vo.phone }</td>
                <td class="gray" height="40" align="right">手机：</td>
                <td>${vo.mobile }</td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right">QQ：</td>
                <td>${vo.qq }</td>
                <td class="gray" height="40" align="right">邮箱：</td>
                <td>${vo.email }</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>

