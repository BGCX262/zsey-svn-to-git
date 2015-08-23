<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>京信内部项目管理系统</title>
</head>
<frameset rows="80,*,30" frameborder="no" border="0" framespacing="0">
  <frame src="head.jhtml" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset id="attachucp" framespacing="0" border="0" frameborder="no" cols="210,*" rows="*">
		<frame src="left.jhtml" name="leftFrame" noresize="noresize" style="overflow: auto; overflow-x:hidden;" />
        <frame id="mainFrame" src="welcome.jhtml" name="mainFrame" scrolling="yes" />
	</frameset>
  <frame src="foot.jhtml" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" title="foot" />
</frameset>
<noframes>
	<body>
	</body>
</noframes>

</html>