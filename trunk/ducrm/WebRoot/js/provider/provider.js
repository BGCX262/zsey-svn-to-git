/**
 * 供应商选择（单选）
 */
function openSelectSingleProvider() {
	var openUrl="/basic/provider/single.jhtml?rnd="+Math.random();
	
	$.weeboxs.open(openUrl, {
		title:'供应商选择',
		contentType:'iframe', 
		width:800, height:450,
		onok:function(box){
	   	 	var name = "lstItems";
	   		box.find("iframe")[0].id   = name;
	   		box.find("iframe")[0].name = name;
	   		setTimeout(function(){
	   			var data = document.getElementById(name).contentWindow.getSelectProvider();
	   			if(data!=null){
	   				if(document.getElementById("providerId")!=null){
						document.getElementById("providerId").value=data.id;
					}
					
	   				if(document.getElementById("providerCode")!=null){
						document.getElementById("providerCode").value=data.code;
					}
					
	   				if(document.getElementById("providerName")!=null){
						document.getElementById("providerName").value=data.name;
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
		   				var address="";
		   				if(data.province!=""){
		   					address+=data.province;
		   				}
		   				
		   				if(data.city!=""){
		   					address+=data.city;
		   				}
		   				
		   				if(data.address!=""){
		   					address+=data.address;
		   				}		   				
		   				
						document.getElementById("address").value=address;
					}
					
		   			if(document.getElementById("postcode")!=null){
						document.getElementById("postcode").value=data.postcode;
					}
	   			}else{
	   				alert("请选择供应商");
					return;
	   			}
	   			
	   			box.close();
	   		}, 20);
		}
	});
}