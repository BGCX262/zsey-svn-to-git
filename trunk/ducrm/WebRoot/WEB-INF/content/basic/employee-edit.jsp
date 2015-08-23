<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" language="javascript" src="<c:url value='/js/area/area.js'/>" charset="utf-8"></script>
<script type="text/javascript" language="javascript" src="<c:url value='/js/base/department.js' />" charset="utf-8"></script>
<script language="javascript" type="text/javascript">
</script>
<title>员工管理</title>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>员工管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/basic/employee/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);" enctype="multipart/form-data">
    
    <fieldset class="tableBox">
    	<legend><strong>基本信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right" >编号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="${vo.code }" size="35" disabled="disabled" /></td>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>姓名：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" size="35" dataType="Require" msg="请输入姓名" /></td>
                <td class="gray" width="80" height="40" align="right">相片：</td>
                <td><input name="uploadImage" type="file" class="ntext_01" size="35" /></td>
			</tr>
			<tr>
               <td class="gray" height="40" align="right" ><font color="red">*</font>证件类型：</td>
                <td>
                	<select name="vo.idtype.id" dataType="Require" msg="请输入姓名">
						<option value="" <c:if test="${empty vo.idtype }">selected="selected"</c:if>>---请选择---</option>
						<c:forEach var="type" items="${idtypeList}">
							<option value="${type.id }" <c:if test="${vo.idtype.id==type.id }">selected="selected"</c:if>>${type.name }</option>
						</c:forEach>
					</select>
                </td>
                <td class="gray" height="40" align="right" ><font color="red">*</font>证件编号：</td>
                <td><input name="vo.idcard" type="text" class="ntext_01" value="${vo.idcard }" size="35" dataType="Require" msg="请输入姓名" /></td> 
                <td rowspan="4" class="gray" height="40" align="right" >&nbsp;</td>
                <td rowspan="4">
                	<c:if test="${not empty vo.photo}">
                		<img alt="${vo.name }的相片" src="<c:url value='${vo.photo }'/>" width="80" height="100" />
                	</c:if>
                </td> 
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right" ><font color="red">*</font>性别：</td>
                <td>
	                <select name="vo.sex" dataType="Require" msg="请选择性别">
						<option value="" <c:if test="${empty vo.sex }">selected="selected"</c:if>>---请选择---</option>
						<c:forEach var="xb" items="${sexs}">
							<option value="${xb }" <c:if test="${vo.sex==xb }">selected="selected"</c:if>>${xb.text }</option>
						</c:forEach>
					</select>
                </td>
                <td class="gray" height="40" align="right" >出生日期：</td>
                <td><input name="vo.born" type="text" class="ntext_01" value="${vo.born }" size="35" readonly="readonly" onclick="WdatePicker()" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" ><font color="red">*</font>部门：</td>
                <td>
                	<input id="departName" name="vo.department.name" type="text" class="ntext_01" value="${vo.department.name }" size="35" disabled="disabled" />
                	<input id="departId" type="hidden" name="vo.department.id" value="${vo.department.id}" />
                	<input type="button" value="选择" onclick="openSingleDepartmentDialog()" />
                </td>
                <td class="gray" height="40" align="right" ><font color="red">*</font>职务：</td>
                <td>
                	<select name="vo.duty.id" dataType="Require" msg="请选择职务">
						<option value="" <c:if test="${empty vo.duty.id }">selected="selected"</c:if>>---请选择---</option>
						<c:forEach var="zw" items="${dutyList}">
							<option value="${zw.id }" <c:if test="${vo.duty.id==zw.id }">selected="selected"</c:if>>${zw.name }</option>
						</c:forEach>
					</select>
                </td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >民族：</td>
                <td>
                	<select name="vo.nation.id">
                		<option value="" <c:if test="">selected="selected"</c:if>>---请选择---</option>
                		<c:forEach var="cate" items="${nationList}">
                			<option value="${cate.id }" <c:if test="${cate.id==vo.province.id }">selected="selected"</c:if>>${cate.name }</option>
                		</c:forEach>
                	</select>
                </td>
                <td class="gray" height="40" align="right" >政治面貌：</td>
                <td>
                	<select name="vo.polity.id">
                		<option value="" <c:if test="">selected="selected"</c:if>>---请选择---</option>
                		<c:forEach var="cate" items="${polityList}">
                			<option value="${cate.id }" <c:if test="${cate.id==vo.province.id }">selected="selected"</c:if>>${cate.name }</option>
                		</c:forEach>
                	</select>
                </td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >血型：</td>
                <td>
                	<select name="vo.blood">
						<option value="" <c:if test="${empty vo.blood }">selected="selected"</c:if>>---请选择---</option>
						<c:forEach var="xx" items="${bloods}">
							<option value="${xx }" <c:if test="${vo.blood==xx }">selected="selected"</c:if>>${xx.text }</option>
						</c:forEach>
					</select>
                </td>
                <td class="gray" height="40" align="right" >学历</td>
                <td>
                	<select name="vo.degree">
						<option value="" <c:if test="${empty vo.degree }">selected="selected"</c:if>>---请选择---</option>
						<c:forEach var="degree" items="${degrees}">
							<option value="${degree }" <c:if test="${vo.degree==degree }">selected="selected"</c:if>>${degree.text }</option>
						</c:forEach>
					</select>
                </td> 
                <td class="gray" height="40" align="right" >毕业学校</td>
                <td><input name="vo.school" type="text" class="ntext_01" value="${vo.school }" maxlength="20" size="35" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >身高：</td>
                <td><input name="vo.height" type="text" class="ntext_01" value="${vo.height }" maxlength="3" size="35" require="false" dataType="Double" msg="输入身高" /></td>
                <td class="gray" height="40" align="right" >体重：</td>
                <td><input name="vo.weight" type="text" class="ntext_01" value="${vo.weight }" maxlength="3" size="35" require="false" dataType="Double" msg="输入体重" /></td>
                <td class="gray" height="40" align="right" >爱好：</td>
                <td><input name="vo.love" type="text" class="ntext_01" value="${vo.love }" maxlength="30" size="35" /></td>
            </tr>
        </table>
	</fieldset>
	
    <fieldset class="tableBox">
    	<legend><strong>联系方式</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" height="40" align="right" >电话：</td>
                <td><input name="vo.phone" type="text" class="ntext_01" value="${vo.phone }" maxlength="20" size="35" require="false" dataType="Phone" msg="电话格式不正确" /></td>
                <td class="gray" height="40" align="right" >手机：</td>
                <td colspan="3"><input name="vo.mobile" type="text" class="ntext_01" value="${vo.mobile }" maxlength="11" size="35" require="false" dataType="Mobile" msg="手机格式不正确" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >QQ：</td>
                <td><input name="vo.qq" type="text" class="ntext_01" value="${vo.qq }" maxlength="20" size="35" require="false" dataType="QQ" msg="QQ格式不正确" /></td>
                <td class="gray" height="40" align="right" >邮箱：</td>
                <td><input name="vo.email" type="text" class="ntext_01" value="${vo.email }" maxlength="50" size="35" require="false" dataType="Email" msg="邮箱格式不正确" /></td>
                <td class="gray" height="40" align="right" >邮编：</td>
                <td><input name="vo.postcode" type="text" class="ntext_01" value="${vo.postcode }" maxlength="6" size="35" require="false" dataType="Zip" msg="邮编格式不正确" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >省：</td>
                <td>
                	<select name="vo.province.id" onchange="ajaxFindArea(this.value)">
                		<option value="" <c:if test="">selected="selected"</c:if>>---请选择---</option>
                		<c:forEach var="cate" items="${provinceList}">
                			<option value="${cate.id }" <c:if test="${cate.id==vo.province.id }">selected="selected"</c:if>>${cate.name }</option>
                		</c:forEach>
                	</select>
                </td>
                <td class="gray" height="40" align="right" >市：</td>
                <td>
                	<select id="selectArea" name="vo.city.id">
                		<option value="" <c:if test="">selected="selected"</c:if>>---请选择---</option>
                		<c:forEach var="cate" items="${cityList}">
                			<option value="${cate.id }" <c:if test="${cate.id==vo.city.id }">selected="selected"</c:if>>${cate.name }</option>
                		</c:forEach>
                	</select>
                </td>
                <td class="gray" height="40" align="right" >地址：</td>
                <td><input name="vo.address" type="text" class="ntext_01" value="${vo.address }" maxlength="30" size="35" /></td>
            </tr>
        </table>
	</fieldset>
	
    <fieldset class="tableBox">
    	<legend><strong>银行卡信息</strong></legend>
    	<table width="100%" class="nt_table">
            <tr>
                <td class="gray" height="40" align="right" >银行账号：</td>
                <td><input name="vo.bcode" type="text" class="ntext_01" value="${vo.bcode }" maxlength="20" size="35" /></td>
                <td class="gray" height="40" align="right" >银行名称：</td>
                <td><input name="vo.bname" type="text" class="ntext_01" value="${vo.bname }" maxlength="20" size="35" /></td>
                <td class="gray" height="40" align="right" >开户人：</td>
                <td><input name="vo.bman" type="text" class="ntext_01" value="${vo.bman }" maxlength="10" size="35" /></td>
            </tr>
            <tr>
                <td class="gray" height="40" align="right" >开户地址：</td>
                <td colspan="5"><input name="vo.badd" type="text" class="ntext_01" value="${vo.badd }" maxlength="30" size="35" /></td>
            </tr>
        </table>
	</fieldset>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/basic/employee/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>

