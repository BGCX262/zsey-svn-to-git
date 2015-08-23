/**
 * 打开客户单选列表页面
 */
function openSingleDialog() {
	var url="/basic/customer/single.jhtml?rnd="+Math.random();
	$.weeboxs.open(url, {
   	    title:'客户选择',
   	    contentType:'iframe', 
   	 	width:900, height:500,
   	 	onok:function(box){
	   	 	var name = "lstItems";
	   		box.find("iframe")[0].id   = name;
	   		box.find("iframe")[0].name = name;
	   		setTimeout(function(){
	   			var data = document.getElementById(name).contentWindow.getSelectSingleCustomer();
	   			if(data!=null){
		   			if(document.getElementById("clientId")!=null){
						document.getElementById("clientId").value=data.id;
					}
					
		   			if(document.getElementById("clientCode")!=null){
						document.getElementById("clientCode").value=data.dode;
					}
					
		   			if(document.getElementById("clientName")!=null){
						document.getElementById("clientName").value=data.name;
					}
					
		   			if(document.getElementById("phone")!=null){
						document.getElementById("phone").value=data.phone;
					}
					
		   			if(document.getElementById("fax")!=null){
						document.getElementById("fax").value=data.fax;
					}
					
		   			if(document.getElementById("linkman")!=null){
						document.getElementById("linkman").value=data.linkman;
					}
					
		   			if(document.getElementById("tel")!=null){
						document.getElementById("tel").value=data.tel;
					}
					
		   			if(document.getElementById("mobile")!=null){
						document.getElementById("mobile").value=data.mobile;
					}
					
		   			if(document.getElementById("address")!=null){
						document.getElementById("address").value=data.province+data.city+data.address;
					}
					
		   			if(document.getElementById("postcode")!=null){
						document.getElementById("postcode").value=data.postcode;
					}
	   			}
	   			box.close();
	   		}, 20);
		}
	});
}