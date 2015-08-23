/**
 * 打开分类单选列表页面
 */
function openSingleCategoryDialog() {
	var pid=$("select[name=vo.sort]").find("option:selected").val();
	if($.trim(pid)!=""){
		var url="/basic/category/single.jhtml?vo.sort="+$.trim(pid)+"&rnd="+Math.random();
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
	}else{
		alert("请选择类型");
		return;
	}
}