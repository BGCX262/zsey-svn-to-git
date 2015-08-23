<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>head</title>
<link href="<c:url value='/style/css/iso.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function doLoginOut(){
	if(confirm('确定要退出吗？')){
		location.href="<c:url value='/login/logout.jhtml'/>?rnd="+Math.random();
	}
}
</script>
</head>
<body>
<div id="head">
    <table width="100%" height="51">
        <tr>
            <td><div id="head_logo"><a href="#"><img src="<c:url value='/style/images/head_logo.png'/>" /></a></div></td>
            <td><dl id="topinfo">
            		<dd><p>在线人员：<b class="n_03">1</b>| <a href="#">修改密码</a> | <span><a href="#" onclick="doLoginOut();" class="n_03">退出</a></span></p></dd>
                </dl></td>
        </tr>
    </table>
    <div id="msbar">
        <table width="100%">
            <tr>
                <td><div id="msbar_user"><b><c:if test="${not empty session.default_user_login.employee }">${session.default_user_login.employee.name}</c:if><c:if test="${empty session.default_user_login.employee }">${session.default_user_login.username}</c:if></b>，您好！欢迎登陆系统，您有一条信息。</div></td>
                <td><div id="main_nav"><span class="nav_dq" >当前位置：</span><a href="#">京信内部项目管理系统</a> &lt; <span  class="nav_sz">项目管理</span></div></td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>
