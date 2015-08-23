<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/common/meta.jsp" %>
<link href="<c:url value='/style/message/message.css'/>" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>京信内部项目管理系统</title>
<link href="<c:url value='/style/css/iso.css'/>" rel="stylesheet" type="text/css" />
<style>
#login_content { position: relative;}
</style>
<script>
if (top != self) top.location.href = self.location.href;

function bgSelect(){
	if(document.body.clientWidth<1250){
		$(".loginFooter p").width(1000);
	}
	else{
		$(".loginFooter p").width(1280);
	}
}
window.onload=bgSelect;
window.onresize=bgSelect;

function formLogin(form) {
	if (form["username"].value == "") {alert("请输入登陆账号！");form["username"].focus();return false;}
	if (form["password"].value == "") {alert("请输入登陆密码！");form["password"].focus();return false;}
	return true;
}
</script>

</head>
<body class="login_body">
<form name="beanForm" action="<c:url value='/login/login.jhtml'/>" method="post" onsubmit="return formLogin(this);">
<div class="login">
    <div class="loginBox">
        <table width="100%">
            <tr>
                <th>用　户：</th>
                <td><input type="text" name="username" class="user" value="${username }" /></td>
            </tr>
            <tr>
                <th>密　码：</th>
                <td><input type="password" name="password" class="pwd" value="${password }"/></td>
            </tr>
            <tr>
                <th></th>
                <td style="padding-top: 10px;"><input type="submit" value="登 录" class="btn" /></td>
            </tr>
        </table>
		<div style="width:200px;margin:auto;position:relative;top:40px;"><%@ include file="/WEB-INF/common/message.jsp" %></div>
    </div>
</div>
</form>
<div class="loginFooter"><p>广东京通资讯科技有限公司 Copyright © 2010 kington.CN , All rights reserved.Powered by kington</p></div>
</body>

</html>
