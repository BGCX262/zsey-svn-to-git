package excel;


import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 执行对Excel文件的读写操作
 */
public class ExcelDemo {
	
	/**
	 * 读
	 * @param file 欲读取的Excel文件的路径
	 * @return
	 */
	public static String read(File file) throws Exception {
		StringBuffer sb = new StringBuffer();
		
		Workbook wb = null;
		try {
			// 获取工作簿对象
			wb = Workbook.getWorkbook(file);
			if (wb != null) {
				// 获取工作簿对象就可以获取工作簿内的工作表对象
				Sheet[] sheets = wb.getSheets();
				if (sheets != null && sheets.length != 0) {
					// 遍历工作簿内所有工作表
					for (int i=0;i<sheets.length;i++) {
						// 获取该工作表内的行数
						int rows = sheets[i].getRows();
						// 遍历行
						for (int j=0;j<rows;j++) {
							// 获取当前行的所有单元格
							Cell[] cells = sheets[i].getRow(j);
							if (cells != null && cells.length != 0) {
								// 遍历单元格
								for (int k=0;k<cells.length;k++) {
									// 获取当前单元格的值
									String cell = cells[k].getContents();
									// 缩进
									sb.append(cell + "\t");
								}
								sb.append("\t\n");
							}
						}
						sb.append("\t\n");
					}
				}
				System.out.println("成功读取了：" + file + "\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			wb.close();
		}
		return sb.toString();
	}
	
	/**
	 * 写
	 * @param fileName 被写入的Excel文件的路径
	 * @param sheetName 被写入的Excel文件的工作表
	 * @param location 被写入的Excel文件的工作表位于工作簿的位置
	 * @throws Exception
	 */
	public static void write(String fileName, String sheetName, int location) throws Exception {
		WritableWorkbook wwb = null;
		Label label = null;
		
		try {
			// 创建可写入的工作簿对象
			wwb = Workbook.createWorkbook(new File(fileName));
			if (wwb != null) {
				// 在工作簿里创建可写入的工作表，第一个参数为工作表名，第二个参数为该工作表的所在位置
				WritableSheet ws = wwb.createSheet(sheetName, location);
				if (ws != null) {
					/* 添加表结构 */
					// 行
					for (int i=0;i<5;i++) {
						// 列
						for (int j=0;j<5;j++) {
							// Label构造器中有三个参数，第一个为列，第二个为行，第三个则为单元格填充的内容
							label = new Label(j, i, "第"+(i+1)+"行，" + "第"+(j+1)+"列");
							// 将被写入数据的单元格添加到工作表
							ws.addCell(label);
						}
					}
					// 从内存中写入到文件
					wwb.write();
				}
				System.out.println("路径为：" + fileName + "的工作簿写入数据成功！");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			wwb.close();
		}
	}
	
	public static void main(String[] args) {
		/* 测试读取（注意：文件路径中的盘符D:/，注意斜杠不要写成反斜杠"\"） */
		/*File file = new File("E:/testRead.xls");
		try {
			System.out.println(read(file));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		/* 测试写入（注意：如果进程中正在运行被写入的文件，将抛出异常） */
		try {
			write("E:/testWrite.xls", "Sheet1", 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}