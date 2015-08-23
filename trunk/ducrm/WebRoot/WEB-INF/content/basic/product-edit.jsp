<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品管理</title>
<script type="text/javascript" language="javascript" src="<c:url value='/js/customer/customer.js'/>" charset="utf-8"></script>
<script language="javascript" type="text/javascript">
function openSingleCategoryDialog() {
	var url="<c:url value='/basic/category/single.jhtml?vo.sort=PRODUCT&rnd='/>"+Math.random();
	$.weeboxs.open(url, {
   	    title:'分类选择',
   	    contentType:'iframe', 
   	 	width:800, height:400,
   	 	onok:function(box){
	   	 	var name = "lstItems";
	   		box.find("iframe")[0].id   = name;
	   		box.find("iframe")[0].name = name;
	   		setTimeout(function(){
	   			var data = document.getElementById(name).contentWindow.getSelectCategory();
	   			if(data!=null){
		   			if(document.getElementById("categoryId")!=null){
						document.getElementById("categoryId").value=data.id;
					}
					
		   			if(document.getElementById("categoryName")!=null){
						document.getElementById("categoryName").value=data.name;
					}
	   			}
	   			box.close();
	   		}, 20);
		}
	});
}

/**
 * 删除附件
 */
function deleteAccessory(id) {
	if($.trim(id)!=""){
		$.ajax({
	        type:"post",
	        url:"<c:url value='/utils/accessory/delete.json'/>",
	        cache:false,
	        data:{"id":id,"rnd":Math.random()},
	        dataType:"json",
			success:function(msg){
				var obj = eval(msg);
				if(obj.isok){
					$("#tr"+id).remove();
				}
	        }
		});
	}
	
}

function kt_init_data(){ 
	var proIds=$(":input[type='hidden'][name='mateIds']").toArray();
	var names=$(":input[type='text'][name='mateNames']").toArray();
	var data = {"keys":"","names":""};
	
	for(var i=0; i<proIds.length; i++){
		if($.trim(proIds[i].value)!=""){
			data.keys += proIds[i].value + ",";
			data.names += names[i].value + ",";
		}
	}
	return data;
}

/**
 * 功能打开工序多项选择页面
 */
function openSelectMultiWork() {
	var url="<c:url value='/utils/work/check.jhtml'/>?rnd="+Math.random();
	$.weeboxs.open(url, {
		title:'工序选择',
		contentType:'iframe', 
		width:800, height:400,
		onok:function(box){
			var name = "lstItems";
			box.find("iframe")[0].id   = name;
			box.find("iframe")[0].name = name;
			setTimeout(function(){
				var data = document.getElementById(name).contentWindow.kt_getResult();
				for(var i=0; i<data.length; i++){
					appendWorkDetails(data[i]);
					countCost();
				}
				box.close();
			}, 20);
		}
	});
}


function kt_init_work_datas(){ 
	var proIds=$(":input[type='hidden'][name='workIds']").toArray();
	var names=$(":input[type='text'][name='workNames']").toArray();
	var data = {"keys":"","names":""};
	
	for(var i=0; i<proIds.length; i++){
		if($.trim(proIds[i].value)!=""){
			data.keys += proIds[i].value + ",";
			data.names += names[i].value + ",";
		}
	}
	return data;
}

/**
 * 功能：打开物料多项选择页面
 */
function openSelectMultiMaterial() {
	var url="<c:url value='/basic/material/check.jhtml'/>?rnd="+Math.random();
	$.weeboxs.open(url, {
		title:'物料选择',
		contentType:'iframe', 
		width:800, height:400,
		onok:function(box){
			var name = "lstItems";
			box.find("iframe")[0].id   = name;
			box.find("iframe")[0].name = name;
			setTimeout(function(){
				var data = document.getElementById(name).contentWindow.kt_getResult();
				for(var i=0; i<data.length; i++){
					appendMateDetails(data[i]);
				}
				countCost();
				box.close();
			}, 20);
		}
	});
}

/**
 * 功能：添加工序的明细
 */
function appendWorkDetails(data){
	var html="";
	html+="<tr id=\"tr2"+data.id+"\" align=\"center\">";
	html+="<td width=\"30\"><input name=\"workIds\" type=\"hidden\" value=\""+data.id+"\" /></td>";
	html+="<td width=\"50\"><input name=\"workCodes\" type=\"text\" class=\"ntext_01\" value=\""+data.code+"\" readonly=\"readonly\" /></td>";
	html+="<td><input name=\"workNames\" type=\"text\" class=\"ntext_01\" value=\""+data.name+"\" readonly=\"readonly\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"workAmounts\" type=\"text\" class=\"ntext_01\" value=\"1\" dataType=\"Double\" msg=\"请输入数量\" style=\"width: 98%;\" onblur=\"countWorkTots();\" /></td>";
	html+="<td width=\"50\"><input name=\"workPrices\" type=\"text\" class=\"ntext_01\" value=\""+data.price+"\"  dataType=\"Double\" msg=\"请输入价格\" style=\"width: 98%;\" onblur=\"countWorkTots();\" /></td>";
	html+="<td width=\"50\"><input name=\"workTotals\" type=\"text\" class=\"ntext_01\" value=\""+data.price+"\" readonly=\"readonly\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\">";
	html+="<span class=\"caozuo\">";
	html+="<a href=\"javascript:void(null);\" onclick=\"deleteTr('tr2"+data.id+"');\" class=\"del\">删除</a>";
	html+="</span>";
	html+="</td>";
	html+="</tr>";
	$("#workDetails").append(html);
}

/**
 * 功能：添加物料明细
 */
function appendMateDetails(data){
	var html="";
	html+="<tr id=\"tr11"+data.id+"\" align=\"center\">";
	html+="<td width=\"30\"><input name=\"mateIds\" type=\"hidden\" value=\""+data.id+"\" /></td>";
	html+="<td width=\"50\"><input name=\"mateCodes\" type=\"text\" class=\"ntext_01\" value=\""+data.code+"\" readonly=\"readonly\" /></td>";
	html+="<td><input name=\"mateNames\" type=\"text\" class=\"ntext_01\" value=\""+data.name+"\" readonly=\"readonly\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"mateAmounts\" type=\"text\" class=\"ntext_01\" value=\"1\" dataType=\"Double\" msg=\"请输入数量\" style=\"width: 98%;\" onblur=\"countMateTots();\" /></td>";
	html+="<td width=\"50\"><input name=\"matePrices\" type=\"text\" class=\"ntext_01\" value=\""+data.price+"\"  dataType=\"Double\" msg=\"请输入价格\" style=\"width: 98%;\" onblur=\"countMateTots();\" /></td>";
	html+="<td width=\"50\"><input name=\"mateTotals\" type=\"text\" class=\"ntext_01\" value=\""+data.price+"\" readonly=\"readonly\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"mateUnits\" type=\"text\" class=\"ntext_01\" value=\""+data.unit+"\" readonly=\"readonly\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\">";
	html+="<span class=\"caozuo\">";
	html+="<a href=\"javascript:void(null);\" onclick=\"deleteTr('tr11"+data.id+"');\" class=\"del\">删除</a>";
	html+="</span>";
	html+="</td>";
	html+="</tr>";
	$("#mateDetails").append(html);
}

/**
 * 统计物料的成本
 */
function countMateTots(){
	var total=0;
	var payment=0.0;
	var amounts=$(":input[type='text'][name='mateAmounts']").toArray();
	var prices=$(":input[type='text'][name='matePrices']").toArray();
	var total=$(":input[type='text'][name='mateTotals']").toArray();
	
	if((amounts!=null && amounts.length>0) && (prices!=null && prices.length>0)){
		for(var i=0;i<amounts.length;i++){
			try{  
				var amount=($.trim(amounts[i].value)==""?0:parseFloat($.trim(amounts[i].value)));
				var price=($.trim(prices[i].value)==""?0.00:parseFloat($.trim(prices[i].value)));
				var sum=amount*price;
				total[i].value=sum.toFixed(2);
			}catch(err){
			}  
		}
	}
	countCost();
}

/**
 * 统计工序的成本
 */
function countWorkTots(){
	var total=0;
	var payment=0.0;
	var amounts=$(":input[type='text'][name='workAmounts']").toArray();
	var prices=$(":input[type='text'][name='workPrices']").toArray();
	var total=$(":input[type='text'][name='workTotals']").toArray();
	
	if((amounts!=null && amounts.length>0) && (prices!=null && prices.length>0)){
		for(var i=0;i<amounts.length;i++){
			try{  
				var amount=($.trim(amounts[i].value)==""?0:parseFloat($.trim(amounts[i].value)));
				var price=($.trim(prices[i].value)==""?0.00:parseFloat($.trim(prices[i].value)));
				var sum=amount*price;
				total[i].value=sum.toFixed(2);
			}catch(err){
			}  
		}
	}
	countCost();
}

/**
 * 计算产品的成本
 */
function countCost(){
	var mate=0.00;
	var mateTotals=$(":input[type='text'][name='mateTotals']").toArray();
	var workTotals=$(":input[type='text'][name='workTotals']").toArray();
	
	if(mateTotals!=null && mateTotals.length>0){
		for(var i=0;i<mateTotals.length;i++){
			try{  
				var cost=($.trim(mateTotals[i].value)==""?0.00:parseFloat($.trim(mateTotals[i].value)));
				mate+=cost;
			}catch(err){
			}  
		}
	}
	
	if(workTotals!=null && workTotals.length>0){
		for(var i=0;i<workTotals.length;i++){
			try{  
				var cost=($.trim(workTotals[i].value)==""?0.00:parseFloat($.trim(workTotals[i].value)));
				mate+=cost;
			}catch(err){
			}  
		}
	}
	
	$(":input[type='text'][name='vo.cost']").val(mate.toFixed(2));
}

/**
 * 删除行
 */
function deleteTr(trId){
	$("#"+trId).remove();
	countCost();
}
</script>
</head>
<body>
<div class="main">
    <div class="subTitle">
        <h2><strong>产品管理</strong></h2>
    </div>
	<h3 class="subBoxTitle mT5"><c:if test="${empty vo.id}">添加</c:if><c:if test="${not empty vo.id}">修改</c:if></h3>
<form name="form1" action="<c:url value='/basic/product/save.jhtml' />" method="post" onsubmit="return Validator.Validate(this,3);" enctype="multipart/form-data">
	<div class="ntable_mid mT10" >
        <table width="100%" class="nt_table">
            <tr>
                <td class="gray" width="80" height="40" align="right">编号：</td>
                <td><input name="vo.code" type="text" class="ntext_01" value="${vo.code }" size="35" disabled="disabled" /></td>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>名称：</td>
                <td><input name="vo.name" type="text" class="ntext_01" value="${vo.name }" maxlength="50" size="35" dataType="Require" msg="请输入名称" /></td>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>分类：</td>
                <td>
                	<input id="categoryName" name="vo.category.name" type="text" class="ntext_01" value="${vo.category.name }" readonly="readonly" size="35" dataType="Require" msg="请选择分类" />&nbsp;&nbsp;
					<input id="categoryId" type="hidden" name="vo.category.id" value="${vo.category.id}" />
					<input type="button" value="选择" onclick="openSingleCategoryDialog()" />
                </td>
            </tr>
            <tr>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>价格：</td>
                <td><input name="vo.price" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.price}</fmt:parseNumber>" size="35" dataType="Double" msg="请输入价格" /></td>
                <td class="gray" width="80" height="40" align="right">成本：</td>
                <td><input name="vo.cost" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${vo.cost}</fmt:parseNumber>" size="35" readonly="readonly" /></td>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>单位：</td>
                <td>
                	<select name="vo.unit.id" dataType="Require" msg="请选择单位">
               			<option value="" <c:if test="${empty vo.unit.id }">selected="selected"</c:if>>---请选择---</option>
                		<c:forEach var="unit" items="${units}">
                			<option value="${unit.id }" <c:if test="${unit.id==vo.unit.id }">selected="selected"</c:if>>${unit.name }</option>
                		</c:forEach>
                	</select>
                </td>
            </tr>
             <tr>
                <td class="gray" width="80" height="40" align="right"><font color="red">*</font>类型：</td>
                <td>
                	<select name="vo.type" dataType="Require" msg="请选择类型">
			   			<option value="" <c:if test="${empty vo.type }">selected="selected"</c:if>>---请选择---</option>
			    		<c:forEach var="type" items="${types}">
			    			<option value="${type }" <c:if test="${type==vo.type }">selected="selected"</c:if>>${type.text }</option>
			    		</c:forEach>
			    	</select>
                </td>
                <td class="gray" width="80" height="40" align="right">所属客户：</td>
                <td colspan="3">
                	<input id="clientName" name="vo.customer.name" type="text" class="ntext_01" value="${vo.customer.name }" size="35"  />
                	<input id="clientId" name="vo.customer.id" type="hidden" value="${vo.customer.id }" />
                	<input type="button" value="选择" onclick="openSingleDialog();" />
                </td>
            </tr>
        </table>
    </div>
    
    <fieldset class="tableBox">
    	<legend><strong>物料明细</strong></legend>
    	<table width="100%" class="nm_table">
			<thead>
				<tr class="gray" align="center">
					<th>序号</th>
					<th>编号</th>
					<th>名称及规格</th>
					<th>数量</th>
					<th>单价</th>
					<th>金额</th>
					<th>单位</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="mateDetails">
				<c:forEach var="details" items="${mateList}" varStatus="status">
				<tr id="tr1${details.id }" align="center">
					<td width="30">${status.count }<input name="mateIds" type="hidden" value="${details.mateId }" /></td>
					<td width="50"><input name="mateCodes" type="text" class="ntext_01" value="${details.code }" readonly="readonly" /></td>
					<td><input name="mateNames" type="text" class="ntext_01" value="${details.name }" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input name="mateAmounts" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.amount }</fmt:parseNumber>" dataType="Double" msg="请输入数量" style="width: 98%;" onblur="countMateTots();" /></td>
					<td width="50"><input name="matePrices" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber>"  dataType="Double" msg="请输入价格" style="width: 98%;" onblur="countMateTots();" /></td>
					<td width="50"><input name="mateTotals" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.total }</fmt:parseNumber>" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input name="mateUnits" type="text" class="ntext_01" value="${details.unit }" readonly="readonly" style="width: 98%;" /></td>
					<td width="50">
						<span class="caozuo">
							<a href="javascript:void(null);" onclick="deleteTr('tr1${details.id }');" class="del">删除</a>
						</span>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
    	<table width="100%" class="nm_table">
			<tr align="center">
				<td class="addRows">
					<a href="javascript:void(null);" onclick="openSelectMultiMaterial();">添加明细</a>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</fieldset>
	
	<fieldset class="tableBox">
    	<legend><strong>工序明细</strong></legend>
    	<table width="100%" class="nm_table">
			<thead>
				<tr class="gray" align="center">
					<th>序号</th>
					<th>编号</th>
					<th>名称</th>
					<th>数量</th>
					<th>单价</th>
					<th>金额</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="workDetails">
				<c:forEach var="details" items="${workList}" varStatus="status">
				<tr id="tr2${details.id }" align="center">
					<td width="30">${status.count }<input name="workIds" type="hidden" value="${details.workId }" /></td>
					<td width="50"><input name="workCodes" type="text" class="ntext_01" value="${details.code }" readonly="readonly" /></td>
					<td><input name="workNames" type="text" class="ntext_01" value="${details.name }" readonly="readonly" style="width: 98%;" /></td>
					<td width="50"><input name="workAmounts" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.amount }</fmt:parseNumber>" dataType="Double" msg="请输入数量" style="width: 98%;" onblur="countWorkTots();" /></td>
					<td width="50"><input name="workPrices" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.price }</fmt:parseNumber>"  dataType="Double" msg="请输入价格" style="width: 98%;" onblur="countWorkTots();" /></td>
					<td width="50"><input name="workTotals" type="text" class="ntext_01" value="<fmt:parseNumber type="number" pattern="##0.00">${details.total }</fmt:parseNumber>" readonly="readonly" style="width: 98%;" /></td>
					<td width="50">
						<span class="caozuo">
							<a href="javascript:void(null);" onclick="deleteTr('tr2${details.id }');" class="del">删除</a>
						</span>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
    	<table width="100%" class="nm_table">
			<tr align="center">
				<td class="addRows">
					<a href="javascript:void(null);" onclick="openSelectMultiWork();">添加明细</a>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	</fieldset>
	
	<fieldset class="tableBox">
    	<legend><strong>产品图片</strong></legend>
    	<div id="templetsDiv">图片：<input name="templets" type="file" class="formText" /></div>
		<table width="100%" class="nm_table">
			<tr align="center"><td class="addRows"><a href="javascript:void(null);" onclick="addTemplet();">添加</a></td></tr>
		</table>
		
		<c:if test="${not empty accessList}">
	    	<table width="100%" class="nm_table">
	            <thead>
					<tr class="gray" align="center">
						<th>序号</th>
						<th>名称</th>
						<th>图片</th>
						<th>上传人</th>
						<th>上传时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="lightBoxTbody">
					<c:forEach var="access" items="${accessList}" varStatus="status">
					<tr id="tr${access.id}" align="center">
						<td width="30">${status.count }</td>
						<td>${access.name }</td>
						<td width="80"><a href="<c:url value='${access.path }'/>" target="_blank"><img src="<c:url value='${access.path }'/>" height="50" width="50" alt="${access.name }" /></a></td>
						<td width="80">${access.realname }</td>
						<td width="120">${access.createTime }</td>
						<td width="100">
							<span class="caozuo">
								<a href="<c:url value="/utils/accessory/download.jhtml?id=${access.id}" />" class="edit">下载</a>&nbsp;|&nbsp;
								<a href="#" onclick="deleteAccessory(${access.id});" class="del">删除</a>
							</span>
						</td>
					</tr>
					</c:forEach>
	            </tbody>
	        </table>
		</c:if>
	</fieldset>
    
	<div class="nbot_control mT10">
		<input type="hidden" name="vo.id" value="${vo.id}" />
        <input id="save" type="submit" class="formBtn01" value="保 存" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="back" type="button" class="formBtn02" value="返 回" onclick="location.href='<c:url value='/basic/product/index.jhtml' />';" />
    </div>
</form>
</div>
</body>
</html>