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
	 * ��ָ������������ָ���ķ�������Դ�ļ������ļ�������ʽֱ�����ء�
	 * 
	 * @param filepath
	 *            Ҫ���ص���Դ�ļ�·�������web��·�����ԣ�
	 */
	public static void download(String filepath) {
		download(filepath, null, null);
	}

	/**
	 * ��ָ������������ָ���ķ�������Դ�ļ������ļ�������ʽֱ�����ء�
	 * 
	 * @param filepath
	 *            Ҫ���ص���Դ�ļ�·�������web��·�����ԣ�
	 * @param name
	 *            �����ļ���ʾ���ͻ��˵�����
	 */
	public static void download(String filepath, String name) {
		download(filepath, name, null);
	}

	/**
	 * ����ָ���ķ�������Դ�ļ���ָ�������ļ���ʾ�����ƺ��������͡�
	 * 
	 * @param filepath
	 *            Ҫ���ص���Դ�ļ�·�������web��·�����ԣ�
	 * @param name
	 *            �����ļ���ʾ���ͻ��˵����ƣ���ָ����ʹ��Ĭ�ϵ��ļ�����
	 * @param contentType
	 *            �����ļ������ͣ���ָ����ʹ��Ĭ�ϵ�application/octet-stream��
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
	 * ������ϴ����ļ���Ĭ�ϵ��ļ��ϴ�Ŀ¼(�μ�web-common.properties������Ϣ)��
	 * 
	 * @param file
	 *            ���ϴ����ļ�
	 * @param filename
	 *            �ϴ��ļ���ԭʼ����
	 * @return
	 */
	public static ResourceVO addResource(File file, String filename) {
		String destFolder = "/upload/"+ generatePath();
		return copy(file, filename, destFolder);
	}

	/**
	 * ������ϴ����ļ���ָ���ĸ�Ŀ¼�����web��Ŀ¼����
	 * 
	 * @param path
	 *            �ļ��洢��Ŀ¼�����web��Ŀ¼��·��
	 * @param file
	 *            ���ϴ����ļ�
	 * @param filename
	 *            �ϴ��ļ���ԭʼ����
	 * @return
	 */
	public static ResourceVO addResource(String path, File file, String filename) {
		String destFolder = path + generatePath();
		return copy(file, filename, destFolder);
	}

	/**
	 * ���ݸ�����·����ȡ���ļ�����Ϣ���������ļ��򷵻�Null
	 * 
	 * @param filepath
	 *            ���web��������·��
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
	 * ����·����Ϣ,����������.
	 * 
	 * @return
	 */
	private static String generatePath() {
		String pattern = "yyyy/MM/dd";
		return new SimpleDateFormat(pattern).format(new Date());
	}

	/**
	 * ���Ƹ������ļ���ָ����Ŀ¼��
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
	 * ��ȡ�ļ����ĺ�׺
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
