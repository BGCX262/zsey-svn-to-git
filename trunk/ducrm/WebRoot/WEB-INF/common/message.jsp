<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="taglibs.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%-- action message --%>
<c:if test="${not empty actionMessages}">
<div id="actionMessages" class="msg_common msg_info">
	<div class="msg_content">
		<s:actionmessage />
	</div>
</div>
</c:if>

<%-- action errors --%>
<c:if test="${not empty actionErrors}">
<div id="actionErrors" class="msg_common msg_error">
	<div class="msg_content">
		<s:actionerror />
	</div>
</div>
</c:if>

<%-- filed errors --%>
<c:if test="${not empty fieldErrors}">
<div id="fieldErrors" class="msg_common msg_error">
	<div class="msg_content" style="color:red;">
		<s:fielderror />
	</div>
</div>
</c:if>
<script>
$(document).ready(function() {
	var sf1 = function() { this.style.border = "1px solid #FFFFE5"; };
	var sf2 = function() { this.style.border = "1px solid #FFCC7F"; };
	$("#actionMessages").animate({opacity:0.3},200,sf1).animate({opacity:1.0},200,sf2)
		.animate({opacity:0.3},200,sf1).animate({opacity:1.0},200,sf2);
	$("#fieldErrors").animate({opacity:0.3},200,sf1).animate({opacity:1.0},200,sf2)
	.animate({opacity:0.3},200,sf1).animate({opacity:1.0},200,sf2);
});
</script>