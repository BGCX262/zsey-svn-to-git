<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="taglibs.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<link href="<c:url value='/js/uploadify/uploadify.css'/>" rel="stylesheet" type="text/css" />
<script language="javascript" src="<c:url value='/js/uploadify/swfobject.js'/>"></script>
<script language="javascript" src="<c:url value='/js/uploadify/jquery.uploadify.v2.1.4.min.js'/>"></script>
<style type="text/css">
#custom-demo .uploadifyQueueItem {
	background-color: #FFFFFF;
	border: none;
	border-bottom: 1px solid #E5E5E5;
	font: 11px Verdana, Geneva, sans-serif;
	height: 26px;
	margin-top: 0;
	padding: 10px;
	width: 630px;
}
#custom-demo .uploadifyError {
	background-color: #FDE5DD !important;
	border: none !important;
	border-bottom: 1px solid #FBCBBC !important;
}
#custom-demo .uploadifyQueueItem .cancel {
	float: right;
}
#custom-demo .uploadifyQueue .completed {
	color: #C5C5C5;
}
#custom-demo .uploadifyProgress {
	background-color: #E5E5E5;
	margin-top: 10px;
	width: 100%;
}
#custom-demo .uploadifyProgressBar {
	background-color: #0099FF;
	height: 3px;
	width: 1px;
}
#custom-demo #custom-queue {
	border: 1px solid #E5E5E5;
	height: 213px;
	margin-bottom: 10px;
	width: 670px;
	overflow:auto;
}
</style>
<div id="custom-demo" class="demo">
<script type="text/javascript">
function delRes(id){
	var url =  '<c:url value='/attachment/delete.jhtml'/>?id=' + id;
	document.getElementById("downfile").src = url;
}
function getItemHTML(id,fileName, fileSaveName) {
	var str = '<div id="fileupload' + id + '" class="uploadifyQueueItem completed">';
	str += '<div class="cancel">';
	str += '<a href="#" onclick="jQuery(\'#fileupload\').uploadifyCancel(\'' + id + '\')">';
	str += '<img border="0" src="<c:url value='/js/uploadify/cancel.png'/>">';
	str += '</a>';
	str += '</div>';
	str += '<span class="fileName"><a target="downfile" href="<c:url value='/res/file.jhtml' />?name=' + fileSaveName + '">' + fileName + '</a></span>';
	str += '<span class="percentage"> - Completed</span>';
	str += '</div>';
	return str;
}
function getItemCount(){
	var count = $('#multiFileIds').val().split(',').length;
	return count == 0 ? 0 : count - 1;
}
function getMsg(err) {
	var count = getItemCount();
	var msg = "";
	if (count>0){
		msg = '已上传<font color="red"> ' +  getItemCount()  + ' </font>个文件 ';
	} else {
		msg = '请选择文件 ';
	}
	
	if (err !=null && err > 0) {
		msg += ', 发生  ' + err + ' 个 错误 ';
	}
	msg += '. ';
	
	return msg;
}
$(function() {
$('#fileupload').uploadify({
'uploader'       : '<c:url value='/js/uploadify/uploadify.swf'/>',
'script'         : '<c:url value='/attachment/up.jhtml'/>?query=${dataId},${sort}', <%-- 注意, 插件仅能传一个QueryString ~_~; --%>
'cancelImg'      : '<c:url value='/js/uploadify/cancel.png'/>',
'multi'          : true,
'auto'           : true,
'fileDataName'   : 'res',<%-- 要与表单 <input type="file"> 里的 name 相同 --%>
'fileExt'        : '*.jpg;*.gif;*.png;*.doc;*.docx;*.xls;*.xlsx;*.ppt;*.pptx;',
'fileDesc'       : '*.jpg;*.gif;*.png;*.doc;*.docx;*.xls;*.xlsx;*.ppt;*.pptx;',
'queueID'        : 'custom-queue',
'buttonText'     : '',
'buttonImg'		 : '<c:url value='/js/uploadify/upload.png'/>',
'width'			 : 80,
'queueSizeLimit' : 3,
'simUploadLimit' : 3,
'sizeLimit'      : 19871202, 
'removeCompleted': false,
'onSelectOnce'  : function(event,data) {
    $('#status-message').html('成功添加  ' + data.filesSelected + ' 个 文件到队列  .');
},
'onAllComplete'	: function(event,data) {
	$('#status-message').html(getMsg(data.errors));
},
'onComplete'	: onComplete,
'onCancel'		: onCancel,
'onInit'		: onInit
});});
function onInit(){
	setTimeout(function(){
		var dataId	= '${dataId}';
		var sort	= '${sort}';
		
		if (sort == ""){
			alert("出错! 必须指定附件分类 sort");
		}
		
		if (dataId == ""){
			alert("出错! 必须指定附件 dataId");
		}
		
		if (nodeCode != "" && nodeId != ""){
			var url = "<c:url value='/attachment/list.jhtml'/>?";
			$.get(url, function(data){
				var ids = eval(data);
				var obj = $('#custom-queue');
				for (var i=0; i<ids.length; i++){
					obj.append(getItemHTML(ids[i].id, ids[i].name, ids[i].saveName));
				}
			});
		}
		
		$('#status-message').html(getMsg());
	},20);
}

function onComplete (event, queueID, fileObj, response, data) {
	eval("var obj=" + response);
	var item = document.getElementById("fileupload" + queueID); <%-- 列表新加项 --%>
	item.childNodes[1].innerHTML = 
		'<a target="downfile" href="<c:url value='/res/file.jhtml' />?name=' + obj.saveName + '">' + item.childNodes[1].innerHTML + '</a>';
  	var saveId 			= response ;<%-- 服务器返回的信息 --%>
   	var multiFileIds	= $('#multiFileIds');
   	multiFileIds.val(multiFileIds.val() + obj.id + ",");
}

function onCancel(event, queueId){
	var lst = document.getElementById("custom-queue").childNodes;
	for (var i=0; i<lst.length; i++){
		if (lst[i].id == "fileupload" + queueId){
			var result = "";
			var multiFileIds	= document.getElementById('multiFileIds').value.split(",");
			for (var j=0; j<multiFileIds.length; j++){
				if (multiFileIds[j]=="") continue;
				if (i == j) {
					delRes(multiFileIds[j]);
					continue;
				}
				result += multiFileIds[j] + ",";
			}
			document.getElementById('multiFileIds').value = result;
			break;
		}
	}
}
</script>
<div class="demo-box">
<div id="custom-queue"></div>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
	<tr>
		<td width="90px" style="border:0px;"><input type="file" id="fileupload" name="res" /></td>
		<td valign="middle" style="border:0px;"><div id="status-message"></div></td>
	</tr>
</table>
</div>
<input type="hidden" id="multiFileIds" name="multiFileIds" /><%-- 已保存发附件id列表 --%>
</div>
<iframe id="downfile" name="downfile" style="display:none"></iframe>