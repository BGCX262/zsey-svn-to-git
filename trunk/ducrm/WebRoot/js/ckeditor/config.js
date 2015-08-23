/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
	config.language = 'zh-cn';
	config.scayt_autoStartup = false; // 去掉拼写检查
	
	
	config.toolbar_Default = [
		['Bold','Italic','Underline','Strike'],
		['NumberedList','BulletedList','Outdent','Indent','Subscript','Superscript'],
		['TextColor','BGColor'],
		['Font','FontSize']
	];
	
	
	config.toolbar_Simple = [
		['Source','Maximize','Cut','Copy','Paste','PasteText','PasteFromWord'],
		['Bold','Italic','Underline','Strike'],
		['NumberedList','BulletedList','Outdent','Indent','Subscript','Superscript'],
		['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
		'/',['Link','Unlink','Anchor'],
		['Styles','Format','FontSize'],
		['TextColor','BGColor','KT_Image']
	];
	
	
	
	config.toolbar_UpFiles = [
	    ['KT_Image']
	];
	
	
	config.extraPlugins = 'kt_image';
};
