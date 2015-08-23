package cn.com.kington.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class ResourceManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2710885387480135565L;

	/**
	 * 以指定的名称下载指定的服务器资源文件，以文件流的形式直接下载。
	 * 
	 * @param filepath
	 *            要下载的资源文件路径（相对web根路径而言）
	 */
	public static void download(String filepath) {
		download(filepath, null, null);
	}

	/**
	 * 以指定的名称下载指定的服务器资源文件，以文件流的形式直接下载。
	 * 
	 * @param filepath
	 *            要下载的资源文件路径（相对web根路径而言）
	 * @param name
	 *            下载文件显示给客户端的名称
	 */
	public static void download(String filepath, String name) {
		download(filepath, name, null);
	}

	/**
	 * 下载指定的服务器资源文件，指定下载文件显示的名称和下载类型。
	 * 
	 * @param filepath
	 *            要下载的资源文件路径（相对web根路径而言）
	 * @param name
	 *            下载文件显示给客户端的名称，不指定将使用默认的文件名称
	 * @param contentType
	 *            下载文件的类型，不指定将使用默认的application/octet-stream流
	 */
	public static void download(String filepath, String name, String contentType) {
		OutputStream os = null;
		InputStream is = null;
		try {
			ResourceVO vo = getResource(filepath);
			if (vo == null)
				return;
			HttpServletResponse resp = ServletActionContext.getResponse();
			// resp.reset();
			if (name == null)
				name = vo.getFile().getName();
			String filename = new String(name.getBytes("GBK"), "ISO8859-1");
			resp.setHeader("Content-Disposition", "attachment;filename="
					+ filename);
			resp.setHeader("Content-Length", vo.getFile().length() + "");
			resp.setContentType(contentType == null ? "application/octet-stream" : contentType);
			os = new BufferedOutputStream(resp.getOutputStream());
			is = new BufferedInputStream(new FileInputStream(vo.getFile()));
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = is.read(buf)) > 0) {
				os.write(buf, 0, len);
			}
			os.flush();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (Exception ex) {
			}
			try {
				if (os != null)
					os.close();
			} catch (Exception ex) {
			}
		}
	}

	/**
	 * 添加已上传的文件到默认的文件上传目录(参见web-common.properties配置信息)。
	 * 
	 * @param file
	 *            已上传的文件
	 * @param filename
	 *            上传文件的原始名称
	 * @return
	 */
	public static ResourceVO addResource(File file, String filename) {
		String destFolder = "/upload/"+ generatePath();
		return copy(file, filename, destFolder);
	}

	/**
	 * 添加已上传的文件到指定的根目录（相对web根目录）。
	 * 
	 * @param path
	 *            文件存储根目录，相对web根目录的路径
	 * @param file
	 *            已上传的文件
	 * @param filename
	 *            上传文件的原始名称
	 * @return
	 */
	public static ResourceVO addResource(String path, File file, String filename) {
		String destFolder = path + generatePath();
		return copy(file, filename, destFolder);
	}

	/**
	 * 根据给定的路径获取该文件的信息，不存在文件则返回Null
	 * 
	 * @param filepath
	 *            相对web服务器根路径
	 * @return
	 */
	public static ResourceVO getResource(String filepath) {
		String realpath = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
		File file = new File(realpath + filepath);
		if (!file.isFile())
			return null;
		ResourceVO vo = new ResourceVO();
		vo.setFile(file);
		vo.setFilepath(filepath);
		vo.setSuffix(getSuffix(file.getName()));
		return vo;
	}

	/**
	 * 生成路径信息,根据年月日.
	 * 
	 * @return
	 */
	private static String generatePath() {
		String pattern = "yyyy/MM/dd";
		return new SimpleDateFormat(pattern).format(new Date());
	}

	/**
	 * 复制给定的文件到指定的目录下
	 * 
	 * @param file
	 * @param destFolder
	 */
	private static ResourceVO copy(File file, String filename, String destFolder) {
		FileChannel input = null, output = null;
		try {
			input = new FileInputStream(file).getChannel();
			String realpath = ServletActionContext.getRequest().getSession()
					.getServletContext().getRealPath("/");
			String destFile = destFolder + "/" + System.currentTimeMillis();
			String suffix = getSuffix(filename).intern();
			if (suffix != "")
				destFile += "." + suffix;
			File dest = new File(realpath + "/" + destFile);
			if (!dest.getParentFile().isDirectory())
				dest.getParentFile().mkdirs();
			if (!dest.isFile())
				dest.createNewFile();
			output = new FileOutputStream(dest).getChannel();
			output.transferFrom(input, 0, input.size());
			ResourceVO vo = new ResourceVO();
			vo.setFilepath(destFile);
			vo.setSuffix(suffix);
			vo.setFile(dest);
			return vo;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				if (input != null)
					input.close();
			} catch (Exception ex) {
			}
			try {
				if (output != null)
					output.close();
			} catch (Exception ex) {
			}
		}
	}

	/**
	 * 获取文件名的后缀
	 * 
	 * @param filename
	 * @return
	 */
	private static String getSuffix(String filename) {
		int index = filename.lastIndexOf(".");
		if (index == -1)
			return "";
		return filename.substring(index + 1);
	}

}
