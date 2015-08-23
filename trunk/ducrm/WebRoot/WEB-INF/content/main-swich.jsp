<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value='/style/css/iso.css'/>" rel="stylesheet" type="text/css" />
<script language="javascript">
function switchSysBar(){
 if (parent.document.getElementById('attachucp').cols=="214,10,*"){
 document.getElementById('leftbar').style.display="";
 parent.document.getElementById('attachucp').cols="0,10,*";
 }
 else{
 parent.document.getElementById('attachucp').cols="214,10,*";
 document.getElementById('leftbar').style.display="none"
 }
}
function load(){
 if (parent.document.getElementById('attachucp').cols=="0,10,*"){
 document.getElementById('leftbar').style.display="";
 }
}

</script>
</head>
<body onLoad="load()" id="swichbg">
<div id="swich" style="padding-top:20px;">
  <table height="100%" cellspacing="0" cellpadding="0" border="0" width="100%">
    <tbody>
      <tr>
        <td height="100%"  id="leftbar" bgcolor="#dfdfdf" style="display: none;"><a onClick="switchSysBar()" href="javascript:void(0);"> <img height="90" border="0" width="9" alt="展开左侧菜单" src="<c:url value='/style/images/swich_r.gif'/>"/> </a></td>
        <td height="100%"  valign="middle" bgcolor="#dfdfdf" id="rightbar"><a onClick="switchSysBar()" href="javascript:void(0);"> <img height="90" border="0" width="9" alt="隐藏左侧菜单" src="<c:url value='/style/images/swich_l.gif'/>"/> </a></td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>