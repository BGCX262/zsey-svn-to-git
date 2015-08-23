/**
 * 打开添加订单明细页面
 */
function openEditSellOrderListDialog(id,orderId){
	var url="";
	if(id==0){
		url="/sell/sell-order-list/edit.jhtml?vo.order.id="+orderId+"&rnd="+Math.random();
	}else{
		url="/sell/sell-order-list/edit.jhtml?id="+id+"&vo.order.id="+orderId+"&rnd="+Math.random();
	}
	
	$.weeboxs.open(url,{
		title:'订单明细',
		contentType:'iframe',
		showButton:false,
		width:900, height:500
	});
}

/**
 * 功能：删除行
 * @param trId
 */
function deleteTr(trId){
	$("#"+trId).remove();
	countCostTots();
}

/**
 * 复制行的内容
 */
function copyTr(trId){
	var a=$("#"+trId).clone();
	$("#detailsTbody").append(a);
	countCostTots();
}


/**
 * 功能：添加订单明细
 * @param data
 */
function appendDetails(data){
	var html="";
	html+="<tr id=\"tr"+data.id+"\" align=\"center\">";
	html+="<td width=\"30\">&nbsp;<input name=\"proIds\" type=\"hidden\" value=\""+data.id+"\" /></td>";
	html+="<td width=\"50\"><input name=\"codes\" type=\"text\" class=\"ntext_01\" value=\""+data.code+"\" maxlength=\"10\" style=\"width: 98%;\" /></td>";
	html+="<td><input name=\"names\" type=\"text\" class=\"ntext_01\" value=\""+data.name+"\" readonly=\"readonly\" maxlength=\"100\" dataType=\"Require\" msg=\"请输入名称\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"sizes\" type=\"text\" class=\"ntext_01\" value=\"\" maxlength=\"10\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"units\" type=\"text\" class=\"ntext_01\" value=\""+data.unit+"\" readonly=\"readonly\" maxlength=\"10\" style=\"width: 98%;\" /></td>";
	html+="<td width=\"50\"><input name=\"amounts\" type=\"text\" class=\"ntext_01\" value=\"\" dataType=\"Double\" msg=\"请输入数量\" style=\"width: 98%;\" onblur=\"countCostTots();\" /></td>";
	html+="<td width=\"50\"><input name=\"prices\" type=\"text\" class=\"ntext_01\" value=\""+data.price+"\" readonly=\"readonly\" dataType=\"Double\" msg=\"请输入价格\" style=\"width: 98%;\" onblur=\"countCostTots();\" /></td>";
	html+="<td width=\"150\"><input name=\"remarks\" type=\"text\" class=\"ntext_01\" value=\"\" style=\"width: 98%;\"  maxlength=\"50\" /></td>";
	html+="<td width=\"100\">";
	html+="<span class=\"caozuo\">";
	html+="<a href=\"javascript:void(null);\" onclick=\"copyTr('tr"+data.id+"');\" class=\"edit\">复制</a>&nbsp;|&nbsp;";
	html+="<a href=\"javascript:void(null);\" onclick=\"deleteTr('tr"+data.id+"');\" class=\"del\">删除</a>";
	html+="</span></td></tr>";
	$("#detailsTbody").append(html);
}

function kt_init_data(){ 
	var proIds=$(":input[type='hidden'][name='proIds']").toArray();
	var names=$(":input[type='text'][name='names']").toArray();
	var data = {"keys":"","names":""};
	
	for(var i=0; i<proIds.length; i++){
		if($.trim(proIds[i].value)!=""){
			data.keys += proIds[i].value + ",";
			data.names += names[i].value + ",";
		}
	}
	
	return data;
}