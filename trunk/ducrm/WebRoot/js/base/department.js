/**
 * 打开部门选择列表
 */
function openSingleDepartmentDialog() {
	var id=$("#departId").val();
	var url="/basic/department/single.jhtml?id="+$.trim(id)+"&rnd="+Math.random();
	$.weeboxs.open(url, {
   	    title:'部门选择',
   	    contentType:'iframe', 
   	 	width:800, height:400,
   	 	onok:function(box){
	   	 	var name = "lstItems";
	   		box.find("iframe")[0].id   = name;
	   		box.find("iframe")[0].name = name;
	   		setTimeout(function(){
	   			var data = document.getElementById(name).contentWindow.getSelectDepartment();
	   			if(data!=null){
		   			if(document.getElementById("departId")!=null){
						document.getElementById("departId").value=data.id;
					}
					
		   			if(document.getElementById("departName")!=null){
						document.getElementById("departName").value=data.name;
					}
	   			}
	   			box.close();
	   		}, 20);
		}
	});
}