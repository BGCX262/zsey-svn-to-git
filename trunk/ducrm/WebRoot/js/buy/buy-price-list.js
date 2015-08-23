/**
 * 打开添加订单明细页面
 */
function openEditBuyPriceListDialog(id,orderId){
	var url=""
	if(id==0){
		url="/buy/buy-price-list/edit.jhtml?vo.order.id="+orderId+"&rnd="+Math.random();
	}else{
		url="/buy/buy-price-list/edit.jhtml?id="+id+"&vo.order.id="+orderId+"&rnd="+Math.random();
	}
	
	$.weeboxs.open(url,{
		title:'物料明细',
		contentType:'iframe',
		showButton:false,
		width:700, height:480
	});
}

/**
 * 提交采购询价
 */
function orderSubmit(){
	$(":input[type='hidden'][name='vo.state']").val("CGGL_WLZX_XJSH");
	document.form1.submit();
}