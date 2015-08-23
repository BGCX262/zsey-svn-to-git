package cn.com.kington.utils;

import java.io.File;
import java.io.Serializable;

/**
 * 表示一个服务器上的资源文件信息
 * 
 * @author 杜永生
 * 
 */
public class ResourceVO implements Serializable {
	private static final long serialVersionUID = 8487393907198135318L;
	private String filepath;
	private String suffix;
	private File file;

	/**
	 * 获取该文件的相对路径，相对web服务器的根路径而言
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
	 * 获取该文件的后缀，如果没有后缀则返回空串
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
	 * 表示该文件的文件对象
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
	 * 获取文件大小的描述信息，如1MB、200KB、100B
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
