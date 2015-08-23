/**
 * 地区二级地区显示，页面必须定义ID为selectArea的select表单
 */
function ajaxFindArea(areaId){
	if($.trim(areaId)!=""){
		var areaurl="/utils/area-tools/ajaxFindArea.json?rnd="+Math.random();
		$.ajax({
	        type:"post",
	        url:areaurl,
	        cache:false,
	        data:{"vo.area.id":areaId,"rnd":Math.random()},
	        dataType:"json",
			success:function(msg){
				var obj = eval(msg);
				var areaList=obj.areaList;
				$("#selectArea").empty();
				var html="<option value=''>---请选择---</option>";
				for(var i=0;i<areaList.length;i++){
					html+="<option value='"+areaList[i].id+"' >"+areaList[i].name+"</option>";
				}
				$("#selectArea").append(html);
	        }
		});
	}
}