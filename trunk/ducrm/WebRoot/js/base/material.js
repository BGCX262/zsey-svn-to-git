/**
 * 物料多选择页面
 */
function openSelectMultiMaterial() {
	var url="<c:url value='/basic/material/check.jhtml'/>?&rnd="+Math.random();
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
					appendDetails(data[i]);
				}
				box.close();
			}, 20);
		}
	});
}
