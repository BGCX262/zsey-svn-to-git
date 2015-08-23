/**
 *	打开联系人管理页面
 */
function openLinkManAdminDialog(url){
	var linkurl="";
	if(url.indexOf('?')>0){
		linkurl=url+"&rnd="+Math.random();
	}else{
		linkurl=url+"?rnd="+Math.random();
	}
	
	$.weeboxs.open(linkurl, {
	    title:'联系人',
	    contentType:'iframe',
	 	width:800, height:600,
		onok:function(box){		
			box.close();
		}
	}); 
}

/**
 * 获取单个联系人的信息
 * 返回值：json对象（编号id，姓名name，性别sex，电话phone，手机mobile，QQ，邮箱email）
 */
function getSingleLinkMan(){
	var man=$("input[type='radio'][name='man']:checked").val();
	if($.trim(man)!=null){
		var data={"id":"","name":"","sex":"","phone":"","mobile":"","qq":"","email":""};
		var fields=man.split("|");
		data.id=fields[0];
		data.name=fields[1];
		data.sex=fields[2];
		data.phone=fields[3];
		data.mobile=fields[4];
		data.qq=fields[5];
		data.email=fields[6];
		return data;
	}
	return null;
}

/**
 * 打开单选联系人页面
 * 使用方法：
 * 在页面添加表单ID为：manId，manName，manSex，manPhone，manMobile，manQq，manEmail
 * 自动把选择的联系填充到表单中
 * 返回值：json对象（编号id，姓名name，性别sex，电话phone，手机mobile，QQ，邮箱email）
 */
function openSingleDialog() {
	var sort = $("input[type='hidden'][name='manSort']").val();
	var dataId = $("input[type='hidden'][name='vo.id']").val();
	
	if($.trim(sort)!="" && $.trim(dataId)!=""){
		var url="/basic/linkman/single.jhtml?vo.dataId="+dataId+"&vo.sort="+sort+"&rnd="+Math.random();
		$.weeboxs.open(url, {
	   	    title:'员工选择',
	   	    contentType:'iframe', 
	   	 	width:800, height:400,
	   	 	onok:function(box){
		   	 	var name = "lstItems";
		   		box.find("iframe")[0].id   = name;
		   		box.find("iframe")[0].name = name;
		   		setTimeout(function(){
		   			var data = document.getElementById(name).contentWindow.getSingleLinkMan();
		   			if(data!=null){
			   			if(document.getElementById("manId")!=null){
							document.getElementById("manId").value=data.id;
						}
						
			   			if(document.getElementById("manName")!=null){
							document.getElementById("manName").value=data.name;
						}
						
			   			if(document.getElementById("manSex")!=null){
							document.getElementById("manSex").value=data.sex;
						}
						
			   			if(document.getElementById("manPhone")!=null){
							document.getElementById("manPhone").value=data.phone;
						}
						
			   			if(document.getElementById("manMobile")!=null){
							document.getElementById("manMobile").value=data.mobile;
						}
						
			   			if(document.getElementById("manQq")!=null){
							document.getElementById("manQq").value=data.qq;
						}
						
			   			if(document.getElementById("manEmail")!=null){
							document.getElementById("manEmail").value=data.email;
						}
		   			}
		   			box.close();
		   		}, 20);
			}
		});
	}else{
		alert("请先保存客户信息，然后在管理列表的“联系人”添加联系人后，方可在此选择联系人");
	}
	
}