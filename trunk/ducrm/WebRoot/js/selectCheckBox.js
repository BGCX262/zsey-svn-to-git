function kt_addItem(key,name){
	var font = document.getElementById(key);
	if (font == null)  // 再次确定未添加
		document.getElementById("kt_lstItems").innerHTML+='<span href="#"><font id="' + key + '">' + name + '</font><a href="#" onclick="kt_removeItem(\''+ key +'\');return 0;">X</a></span>';
		
	var chk = frames["listframe"].document.getElementById("cid_" + key);
	chk.checked=1;
}

function kt_removeItem(key){
	var font = document.getElementById(key);
	if (font != null)   // 再次确定已添加
		document.getElementById("kt_lstItems").removeChild(font.parentNode);
	
	var chk = frames["listframe"].document.getElementById("cid_" + key);
	if (chk != null)
		chk.checked=0;
}

var newItems = new Array();
function kt_chk(chk,key,name,data){
	newItems.push(data); // 保存选择数据
	chk.checked ? kt_addItem(key,name) : kt_removeItem(key);
}

function kt_getResult(){
	var selected=document.getElementById("kt_lstItems").getElementsByTagName("font");
	var result = new Array(); 
	for (var i=0;i<selected.length;i++){ // 筛选出那些是新增
		for (var j=0;j<newItems.length;j++){
			if (newItems[j].id == selected[i].id){
				result.push(newItems[j]);
			}
		}
	}
	return result;
}

function kt_init(data){
	var lstKeys  =data.keys.split(',');
	var lstNames =data.names.split(',');
	for(var i=0;i<lstKeys.length;i++){
		if (lstKeys[i]==""||lstNames[i]=="")
			continue;
		kt_addItem(lstKeys[i],lstNames[i]);
	};
}