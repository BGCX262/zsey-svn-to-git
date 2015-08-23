<%@ page language="java" errorPage="/WEB-INF/common/exception.jsp" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<%@ include file="/WEB-INF/common/meta.jsp" %>
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/message/message.css'/>" charset="utf-8" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/css/iso.css'/>" charset="utf-8" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/displaytag/default.css'/>" charset="utf-8" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/css/nform.css' />" charset="utf-8" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/style/css/wbox/wbox.css'/>" charset="utf-8" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/js/weebox-0.4/src/weebox.css'/>" charset="utf-8" />
	<script type="text/javascript" language="javascript" src="<c:url value='/js/jquery-1.4.4.min.js'/>" charset="utf-8"></script>
	<script type="text/javascript" language="javascript" src="<c:url value='/js/Validator.js'/>" charset="utf-8"></script>
	<script type="text/javascript" language="javascript" src="<c:url value='/js/wbox.js'/>" charset="utf-8"></script>
	<script type="text/javascript" language="javascript" src="<c:url value='/js/common.js'/>" charset="utf-8"></script>
	<script type="text/javascript" language="javascript" src="<c:url value='/js/pubfunction.js'/>" charset="utf-8"></script>
	<script type="text/javascript" language="javascript" src="<c:url value='/js/weebox-0.4/src/bgiframe.js'/>" charset="utf-8"></script>
	<script type="text/javascript" language="javascript" src="<c:url value='/js/weebox-0.4/src/weebox.js'/>" charset="utf-8"></script>
	<script type="text/javascript" language="javascript" src="<c:url value='/js/My97DatePicker-4.72/calendar.js'/>" charset="utf-8"></script>
	<script type="text/javascript" language="javascript" src="<c:url value='/js/My97DatePicker-4.72/WdatePicker.js'/>" charset="utf-8"></script>

	<script type="text/javascript">
	// table 表格的鼠标停靠高亮
	$(document).ready(function(){
		$(".nm_table tr:even").addClass("alt");
		$(".nm_table tr").mouseover(function(){
			$(this).addClass("over");}).mouseout(function(){
			$(this).removeClass("over");}).click(function(){
			$(this).toggleClass("tr_chouse");
			
			})
	});
	
	//全选，全不选
	function selectCheckbox(){
		var chk_ss = document.getElementsByName('cid');
		for(var i=0; i<chk_ss.length; i++){
			if(chk_ss[i].type == 'checkbox' ){
				chk_ss[i].checked = document.getElementById('selectAll').checked;
				
				if (chk_ss[i].onclick != null)
					chk_ss[i].onclick();
			}

		}
	}

	function getCheckBox(){
		var obj=document.getElementsByName('cid');
		var ids='';
		for(var i=0; i<obj.length; i++){
			if(obj[i].checked==true){
				ids += obj[i].value + ',';
			}
		}
		return ids;
	}
	
	function clears(){
		var ids = getCheckBox();
		if(ids==''){
			alert('请选择要删除的信息');
			return;
		}
		if (!confirm('确定要删除您勾选的记录？')) return;
		window.location.href = 'clear.jhtml?ids=' + ids;
	}

	function lockPage(){
		$("input").attr("disabled",true);
		$("select").attr("disabled",true);
		$("textarea").attr("disabled",true);
		$("#save").hide();
		$("#back").attr("disabled",false);
	}
	
	$(function(){
        $(".tableBox legend").toggle(
            function(){
				var $this=$(this);
				if($this.parent().hasClass("closetablebox")){
					$(this).next().slideDown(200);
					$(this).find("strong").addClass("fold");
				}else{
					$this.next().slideUp(200);
					$this.find("strong").addClass("fold");
				}
            },
            function(){
				var $this=$(this);
				if($this.parent().hasClass("closetablebox")){
					$this.next().slideUp(200);
					$this.find("strong").removeClass("fold");
				}else{
					$this.next().slideDown(200);
					$this.find("strong").removeClass("fold");
				}
            }
        )
    })
	
	</script>
	<decorator:head/>
	<title><decorator:title /></title>
</head>
<body>
	<!-- 这里是操作信息提示区域 -->
	<div style="width:98%;margin:auto;"><%@ include file="/WEB-INF/common/message.jsp" %></div>
	
	<!-- 这里是功能的内容区域 -->
	<div><decorator:body/></div>
</body>
</html>
