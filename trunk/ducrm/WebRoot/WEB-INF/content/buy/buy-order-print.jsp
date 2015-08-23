<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
* {margin:0;padding:0}
body {font:12px/1.5  "宋体";color:#333}
h1 {font:18px "宋体";font-size: 18px;color: #000;}
h2 {font:16px "宋体";font-size: 16px;color: #000;}
.w{width:100%}
.m1 td{height:0.6cm;line-height:0.6cm;}
.t3,.t7,.t6{width:1.6cm}
.t1{width:6.8cm}
.t5{width:1.1cm}
.tb4{border-collapse:collapse;border:1px solid #000}
.tb4 th, .tb4 td,.d1{border:1px solid #000}
.tb4 td {padding:1px}
.tb4 th {height:0.6cm;font-weight:normal}
.m1,.m2,.m3{padding-top:10px}
.d1{padding:10px}
.d2{text-align:right;padding:10px 0;font-size:14px}
.logo{border-bottom:1px solid #ccc;padding:10px}
.footer{border-top:1px solid #ccc;text-align:center;padding:10px}
.v-h{ text-align:center}
.m2{padding-left:1px}
</style>
<style type="text/css" media="print">
.v-h {display:none;}
</style>
</head>

<body>
	<div class="w">
		<center><h1>中&nbsp;山&nbsp;市&nbsp;耀&nbsp;祥&nbsp;服&nbsp;装&nbsp;有&nbsp;限&nbsp;公&nbsp;司</h1></center><br />
		<center><h2>采&nbsp;&nbsp;购&nbsp;&nbsp;单</h2></center><br />
		<div class="m1">
			<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="tb1">
				<tbody>
					<tr>
						<td width="40" align="right">编号：</td>
						<td width="100">${vo.code }</td>
						<td width="40" align="right">名称：</td>
						<td>${vo.name }</td>
						<td width="40" align="right">日期：</td>
						<td width="100">${vo.addDate }</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="m2">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tb4">
				<thead>
					<tr align="center">
						<th>序号</th>
						<th>名称及规格</th>
						<th>单位</th>
						<th>数量</th>
						<th>价格</th>
						<th>金额</th>
						<th>备注</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="details" items="${orderList}" varStatus="status">
					<tr align="center">
						<td width="30">${status.count }</td>
						<td>${details.name }<c:if test="${not empty details.spec }">&nbsp;${details.spec }</c:if></td>
						<td width="60">${details.unit }</td>
						<td width="60">${details.amount }</td>
						<td width="60"><fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber></td>
						<td width="60"><fmt:parseNumber type="number" pattern="##0.00">${details.price*details.amount }</fmt:parseNumber></td>
						<td width="60">${details.remark }</td>
					</tr>
					</c:forEach>
					<tr align="center">	
						<td colspan="2" width="60">&nbsp;</td>				
						<td width="60">总数</td>
						<td width="60"><fmt:parseNumber type="number" pattern="##0.00">${vo.total }</fmt:parseNumber></td>
						<td width="60">合计</td>
						<td width="60"><fmt:parseNumber type="number" pattern="##0.00">${vo.payment }</fmt:parseNumber></td>
						<td width="60">&nbsp;</td>
					</tr>
					<tr align="center">	
						<td colspan="7" align="left">备注：</td>				
					</tr>
				</tbody>
			</table>
		</div>
		<div class="m1">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tb1">
				<tbody>
					<tr>
						<td width="50" align="right">联系人：</td>
						<td>曾志繁</td>
						<td width="50" align="right">手机：</td>
						<td>18688111292</td>
						<td width="50" align="right">电话：</td>
						<td>0760-88791516&nbsp;88791519</td>
						<td width="50" align="right">传真：</td>
						<td>0760-87601518</td>
					</tr>
					<tr>
						<td width="50" align="right">地&nbsp;&nbsp;址：</td>
						<td colspan="5">中山市东区孙文东路160号四楼</td>
						<td width="50" align="right">邮编： </td>
						<td>528403</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>