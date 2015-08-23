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
		<center><h2>报&nbsp;&nbsp;价&nbsp;&nbsp;单</h2></center><br />
		<div class="m1">
			<table  width="100%" border="0" cellspacing="0" cellpadding="0" class="tb1">
				<tbody>
					<tr>
						<td width="40" align="right">编号：</td>
						<td width="100">${vo.code }</td>
						<td width="40" align="right">名称：</td>
						<td>${vo.name }</td>
						<td width="50" align="right">联系人：</td>
						<td width="100">${vo.linkman }</td>
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
						<th>名称</th>
						<th>码数</th>
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
						<td>${details.name }</td>
						<td width="60">${details.size }</td>
						<td width="60">${details.unit }</td>
						<td width="60">${details.amount }</td>
						<td width="60"><fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber></td>
						<td width="60"><fmt:parseNumber type="number" pattern="##0.00">${details.price*details.amount }</fmt:parseNumber></td>
						<td width="60">${details.remark }</td>
					</tr>
				</c:forEach>
				<tr align="center">	
					<td colspan="3" width="60">&nbsp;</td>				
					<td width="60">总数</td>
					<td width="60"><fmt:parseNumber type="number" pattern="##0.00">${vo.total }</fmt:parseNumber></td>
					<td width="60">合计</td>
					<td width="60"><fmt:parseNumber type="number" pattern="##0.00">${vo.payment }</fmt:parseNumber></td>
					<td width="60">&nbsp;</td>
				</tr>
				<tr align="center">	
					<td colspan="8" align="left">备注：按照双方所确认的样品规格、颜色、款式、制做、生产制作。</td>	
				</tr>					
				</tbody>
			</table>
		</div>
		<div class="m1">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tb1">
				<tbody>
					<tr>
						<td>
						一、付款方式：预付30%货款，货到验收合格后付完总款，开支票/转帐。<br />
						二、原材料协议：按照甲乙双方所确认好的款式、样品、颜色等细节要求生产制做。<br />
						三、以上是按贵公司所需求的产品款式、材料、颜色及要求给予价格，以便贵公司按实际情况参考，确认和选购。
						</td>
					</tr>
				</tbody>
			</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="tb1">
				<tbody>
					<tr>
						<td width="50%" valign="top">
							采购商确认（盖章）:_____________________________<br />
							地址:___________________________________________<br />
							联系人:_________________________________________<br />
							电话:___________________________________________<br />
							传真：_________________________________________
						</td>
						<td width="50%" valign="top">
							供应商确认（盖章）：中山市耀祥服装有限公司<br />
							地址： 中山市东区孙文东路160号四楼<br />
							开户行: 广发银行中山石岐支行<br />
							公司帐号:138088516010000833<br />
							联系人：曾志繁<br />
							手机：18688111292<br />
							电话: 0760-88791516 88791519<br />
							传真: 0760-87601518<br />
							邮箱: zengzf2007@163.com<br />
							网址：www.yaoxiang.com<br />
							邮编: 528403
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>