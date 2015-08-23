/**
 * 打开产品单选列表页面
 */
function openSingleProductDialog() {
	var url="/basic/product/single.jhtml?rnd="+Math.random();
	$.weeboxs.open(url, {
   	    title:'产品选择',
   	    contentType:'iframe', 
   	 	width:900, height:500,
   	 	onok:function(box){
	   	 	var name = "lstItems";
	   		box.find("iframe")[0].id   = name;
	   		box.find("iframe")[0].name = name;
	   		setTimeout(function(){
	   			var data = document.getElementById(name).contentWindow.getSelect();
	   			if(data!=null){
		   			if(document.getElementById("proId")!=null){
						document.getElementById("proId").value=data.id;
					}
					
		   			if(document.getElementById("proCode")!=null){
						document.getElementById("proCode").value=data.code;
					}
					
		   			if(document.getElementById("proName")!=null){
						document.getElementById("proName").value=data.name;
					}
	   			}
	   			box.close();
	   		}, 20);
		}
	});
}