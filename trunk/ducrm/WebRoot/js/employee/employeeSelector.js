/**
 * 员工选择（单选）
 */
function openSelectSingleEmployee(url) {
	var openUrl=url+"?rnd="+Math.random();
	
	$.weeboxs.open(openUrl, {
		title:'员工选择',
		contentType:'iframe', 
		width:800, height:450,
		onok:function(box){
	   	 	var name = "lstItems";
	   		box.find("iframe")[0].id   = name;
	   		box.find("iframe")[0].name = name;
	   		setTimeout(function(){
	   			var employee = document.getElementById(name).contentWindow.getSelectEmployee();
	   			if(employee!=null){
	   				if(document.getElementById("employeeId")!=null){
						document.getElementById("employeeId").value=employee.id;
					}
					
	   				if(document.getElementById("employeeCode")!=null){
						document.getElementById("employeeCode").value=employee.code;
					}
					
					
	   				if(document.getElementById("employeeName")!=null){
						document.getElementById("employeeName").value=employee.name;
					}
					
	   				if(document.getElementById("employeeSex")!=null){
						document.getElementById("employeeSex").value=employee.sex;
					}
					
					
	   				if(document.getElementById("departmentName")!=null){
	   					document.getElementById("departmentName").value=employee.departName;
	   				}
	   				
	   				if(document.getElementById("departmentId")!=null){
						document.getElementById("departmentId").value=employee.departId;
					}
					
	   				if(document.getElementById("dutyName")!=null){
						document.getElementById("dutyName").value=employee.dutyName;
					}
					
					if(document.getElementById("employeePhone")!=null){
						document.getElementById("employeePhone").value=employee.phone;
					}
					
	   				if(document.getElementById("employeeMobile")!=null){
						document.getElementById("employeeMobile").value=employee.mobile;
					}
	   			}else{
	   				alert("请选择员工");
					return;
	   			}
	   			
	   			box.close();
	   		}, 20);
		}
	});
}