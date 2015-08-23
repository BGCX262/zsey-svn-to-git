package cn.com.kington.utils;

import java.io.File;
import java.io.Serializable;

/**
 * ��ʾһ���������ϵ���Դ�ļ���Ϣ
 * 
 * @author ������
 * 
 */
public class ResourceVO implements Serializable {
	private static final long serialVersionUID = 8487393907198135318L;
	private String filepath;
	private String suffix;
	private File file;

	/**
	 * ��ȡ���ļ������·�������web�������ĸ�·������
	 * 
	 * @return
	 */
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * ��ȡ���ļ��ĺ�׺�����û�к�׺�򷵻ؿմ�
	 * 
	 * @return
	 */
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * ��ʾ���ļ����ļ�����
	 * 
	 * @return
	 */
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * ��ȡ�ļ���С��������Ϣ����1MB��200KB��100B
	 * 
	 * @return
	 */
	public String getSizeDesc() {
		if (file == null)
			return "0";
		long size = file.length();
		if (size < 1024)
			return size + "B";
		String fs = null, unit = "KB";
		if (size < 1024 * 1024)
			fs = String.valueOf(size * 1f / 1024);
		else {
			fs = String.valueOf(size * 1f / (1024 * 1024));
			unit = "MB";
		}
		int point = fs.indexOf(".");
		if (point == -1 || point >= fs.length() - 3)
			return fs + unit;
		return fs.substring(0, point + 2) + unit;
	}
}
