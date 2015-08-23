/**
 * 打开窗口
 * @param url
 * @param title
 */
function openDialog(url,title){
	if(url.indexOf('?')>0){
		url=url+"&rnd="+Math.random();
	}else{
		url=url+"?rnd="+Math.random();
	}
	
	$.weeboxs.open(url,
	{
		title:title,
		contentType:'iframe',
		width:750, height:500,
		onok:function(box){		
			box.close();
		}
	});
}

//js获取项目根路径，如： http://localhost:8080/jxproject
function getRootPath(){
	//获取当前网址，如： http://localhost:8080/jxproject/share/meun.jsp
	var curWwwPath=window.document.location.href;
	//获取主机地址之后的目录，如： jxproject/share/meun.jsp
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	//获取主机地址，如： http://localhost:8080
	var localhostPaht=curWwwPath.substring(0,pos);
	//获取带"/"的项目名，如：/jxproject
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	return (localhostPaht+projectName);
}

/**
 * 添加附件<br />
 * 注意：必须定义ID为templetsDiv的div
 */
function addTemplet(){
	var date = new Date();
	var ms=(date.getMinutes()+""+date.getSeconds()+""+date.getMilliseconds());
	var html="";
	html+="<br /><input id=\"templets"+ms+"\" name=\"templets\" type=\"file\" class=\"formText\" /><input id=\"buttons"+ms+"\" type=\"button\" value=\"删除\" onclick=\"deleteTemplet("+ms+");\" />";
	$("#templetsDiv").append(html);
}

/**
 * 删除行
 */
function deleteTemplet(id){
	$("#templets"+id).remove();
	$("#buttons"+id).remove();
}

/**
 * 删除行
 */
function deleteTr(trId){
	$("#"+trId).remove();
}

/**
 * 删除附件
 * 参数：
 * id:附件ID
 */
function deleteAccess(id){
	if(confirm("确实要删除吗?")){
		if($.trim(id)!=""){
			$.ajax({
		        type:"post",
		        url:"/utils/accessory/delete.json",
		        cache:false,
		        data:{"id":id,"rnd":Math.random()},
		        dataType:"json",
				success:function(msg){
					var obj = eval(msg);
					alert(obj.isok);
					if(obj.isok){
						$("#access"+id).remove();
					}else{
						alert("删除失败");
					}
		        }
			});
		}
	}
}