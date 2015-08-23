
// first parameter is the name of plugin
CKEDITOR.dialog.add('kt_image',function(editor) {
	var result = {
		title:editor.lang.title,
		minWidth:350,
		minHeight:120,
		resizable:CKEDITOR.DIALOG_RESIZE_BOTH,
		buttons : [CKEDITOR.dialog.okButton],
		onOk:function() {
			
		},
		contents:[{
			elements:[{
				type:'html',
				html:'<p>' + editor.lang.label + '</p><br/>'
					+ '<input type="text" readOnly id="ktImage_selectedFile" style="width:180px;background-color:#FFFFFF;border:1px solid #000000;height:18px;" />'
					+ '&nbsp;<input type="button" value="' + editor.lang.sltFile + '" onclick="javascript:ktImageParent.selectFile();" style="border:1px solid #000000;"/>'
					+ '&nbsp;<input type="button" value="' + editor.lang.upload + '" onclick="javascript:ktImageParent.upload();" style="border:1px solid #000000;"/><br/>'
					+ '<br/><span id="ktImageTip" style="display:none;"></span>'
					+ '<iframe id="kt_image_iframe" src="' + CKEDITOR.plugins.getPath('kt_image')
					+ 'upload.html?rand=' + Math.random() + '" style="display:none;"></iframe>'
			}]
		}]
	};
	window.kt_image_config = editor.config.kt_image ? editor.config.kt_image : {};
	window.kt_image_callback = function(success, filepath, filename) {
		document.getElementById('kt_image_iframe').src= CKEDITOR.plugins.getPath('kt_image') + 'upload.html?rand=' + Math.random();
		ktImageParent.tip(false);
		document.getElementById("ktImage_selectedFile").value = "";
		//alert("success=" + success + "\nfilepath=" + filepath + "\nfilename=" + filename);
		if (success) {
			var host = window.kt_image_config.host ? window.kt_image_config.host : '';
			var link = host + filepath;
			if (ktImageParent.isImage(filepath)) { // if attachment is image
				editor.insertHtml("<img border='0' src='" + link + "'/>");
			} else { // if attachment is not image
				editor.insertHtml("<a href='" + link + "' target='_blank'>" + filename + "</a>");
			}
			alert(editor.lang.success);
		} else {
			alert(editor.lang.failed + '\n' + filepath);
		}
	};
	return result;
});

var ktImageParent = {
	tip : function(show, message) {
		var tip = document.getElementById("ktImageTip");
		tip.style.display = show ? "" : "none";
		tip.innerHTML = message || "";
	},

	selectFile : function() {
		var doc = this.getUploadDocument();
		doc.getElementById("ktImage").click();
	},
	
	setFile : function(file) {
		document.getElementById("ktImage_selectedFile").value = file;
	},
	
	upload : function() {
		var doc = this.getUploadDocument();
		doc.getElementById("kt_submit").click();
	},
	
	getUploadDocument : function() {
		var id = "kt_image_iframe";
		return document.getElementById(id).contentDocument || document.frames[id].document;
	},
	
	isImage : function(file) {
		if (!file || file.lastIndexOf('.') == -1) return false;
		var image_suffixs = [".jpg", ".jpeg", ".png", ".gif", ".bmp"];
		var suffix = file.substring(file.lastIndexOf('.')).toLowerCase();
		//alert(suffix);
		for (var i = 0; i < image_suffixs.length; i ++) {
			if (suffix == image_suffixs[i]) return true;
		}
		return false;
	}
};