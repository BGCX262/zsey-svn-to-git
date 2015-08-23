/**
 * Title  : CKEditor编辑器的图片上传插件
 * Author : 马必强
 * Date   : 2010-03-17
 *
 * 图片上传插件，在初始化CKEditor实例的时可以在config中指定如下的参数来控制上传信息：
 * kt_image : {
 *    uploadURL : '/upload.do',   // 执行上传的URL地址，必须指定
 *    fileName  : 'ktImage',      // 上传表单文件域的名称，默认是ktImage，可选
 *    host      : 'http://www.a.com'  // 当前应用的域名信息,可以选，如果指定将被加在返回的路径前面插入到编辑器中
 * }
 * 
 * 使用示例如下，其中toolbar、width、height为CKEditor的控制参数，后面的kt_image是本插件的控制参数：
 * <script>
 * CKEDITOR.replace("myEditor", {
 *     toolbar  : 'Basic',
 *     width    : 300,
 *     height   : 200,
 *     kt_image : {
 *         uploadURL : '/app/upload.do',
 *         fileName  : 'myImage'
 *     }
 * }
 * </script>
 *
 * 选择文件点击上传时，插件将调用指定的URL地址进行文件上传，同时服务器必须返回如下的JS代码：
 * parent.kt_image_callback(success, filepath);
 * 其中kt_image_callback是回调方法的名称，其参数意义说明如下：
 * success   是否成功 true-成功 false-失败
 * filepath  成功是图片上传成功后在服务器端的路径（相对web根目录）；失败是失败原因
 **/

// kt_image is the path of plugin in the plugins directory
CKEDITOR.plugins.add('kt_image', {
	lang:['zh-cn'],
    init: function(editor) {
        var pluginName = 'kt_image';
        CKEDITOR.dialog.add(pluginName, this.path + 'dialogs/kt_image.js');
        editor.addCommand(pluginName, new CKEDITOR.dialogCommand(pluginName));
        editor.ui.addButton('KT_Image', {
			label: editor.lang.title,
			command: pluginName,
			icon:this.path+'upload.png'
        });
    }
});