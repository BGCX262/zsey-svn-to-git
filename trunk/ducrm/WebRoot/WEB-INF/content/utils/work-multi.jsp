<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工序管理</title>
<script type="text/javascript" language="javascript">
function setResult(chk,id,code,name,price){
	var result = {"id":"","code":"","name":"","price":""};
	result.id=id;
	result.code=code;
	result.name=name;
	result.price=price;
	parent.kt_chk(chk, id, name, result);
}
</script>
</head>
<body>
	<div class="main">
	    <div class="subTitle">
	        <h2><strong>物料管理</strong></h2>
	    </div>
	    
		<form name="form1" action="<c:url value='/utils/work/multi.jhtml'/>" method="post">
		    <div class="frmBar mT5">
				编&nbsp;&nbsp;&nbsp;&nbsp;号: <input class="input" type="text" name=vo.code value="${vo.code}"  maxlength="9"/>&nbsp;&nbsp;
				名&nbsp;&nbsp;&nbsp;&nbsp;称: <input class="input" type="text" name="vo.name" value="${vo.name}" maxlength="10"/>
				<input type="submit" class="btn" value="搜索" />
			</div>
		</form>
	
	    <div class="ntable_mid mT5">
			<display:table name="pageList" id="vo" class="nm_table" style="width:100%" cellspacing="0" requestURI="multi.jhtml">
	            <display:column media="html" title="<input name='selectAll' id='selectAll' type='checkbox' onclick='selectCheckbox()' />" style="width:15px">
	       			<input type="checkbox" name="cid" id="cid_${vo.id}" value="${vo.id}" onclick="setResult(this,${vo.id},'${vo.code}','${vo.name}',${vo.price});"  />
	      		</display:column>
	            <display:column title="序号" style="width:30px;">${pageList.startIndex + vo_rowNum}</display:column>
				<display:column title="编号" style="width:80px;">${vo.code}</display:column>
				<display:column title="名称">${vo.name}</display:column>
				<display:column title="价格" style="width:100px;"><fmt:parseNumber type="number" pattern="##0.00">${vo.price}</fmt:parseNumber></display:column>
				<display:setProperty name="paging.banner.item_name">工序</display:setProperty>
				<display:setProperty name="paging.banner.items_name">工序</display:setProperty>
			</display:table>
		</div>
	</div>
</body>
</html>