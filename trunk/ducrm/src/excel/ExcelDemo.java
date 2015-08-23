package excel;


import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * ִ�ж�Excel�ļ��Ķ�д����
 */
public class ExcelDemo {
	
	/**
	 * ��
	 * @param file ����ȡ��Excel�ļ���·��
	 * @return
	 */
	public static String read(File file) throws Exception {
		StringBuffer sb = new StringBuffer();
		
		Workbook wb = null;
		try {
			// ��ȡ����������
			wb = Workbook.getWorkbook(file);
			if (wb != null) {
				// ��ȡ����������Ϳ��Ի�ȡ�������ڵĹ��������
				Sheet[] sheets = wb.getSheets();
				if (sheets != null && sheets.length != 0) {
					// ���������������й�����
					for (int i=0;i<sheets.length;i++) {
						// ��ȡ�ù������ڵ�����
						int rows = sheets[i].getRows();
						// ������
						for (int j=0;j<rows;j++) {
							// ��ȡ��ǰ�е����е�Ԫ��
							Cell[] cells = sheets[i].getRow(j);
							if (cells != null && cells.length != 0) {
								// ������Ԫ��
								for (int k=0;k<cells.length;k++) {
									// ��ȡ��ǰ��Ԫ���ֵ
									String cell = cells[k].getContents();
									// ����
									sb.append(cell + "\t");
								}
								sb.append("\t\n");
							}
						}
						sb.append("\t\n");
					}
				}
				System.out.println("�ɹ���ȡ�ˣ�" + file + "\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			wb.close();
		}
		return sb.toString();
	}
	
	/**
	 * д
	 * @param fileName ��д���Excel�ļ���·��
	 * @param sheetName ��д���Excel�ļ��Ĺ�����
	 * @param location ��д���Excel�ļ��Ĺ�����λ�ڹ�������λ��
	 * @throws Exception
	 */
	public static void write(String fileName, String sheetName, int location) throws Exception {
		WritableWorkbook wwb = null;
		Label label = null;
		
		try {
			// ������д��Ĺ���������
			wwb = Workbook.createWorkbook(new File(fileName));
			if (wwb != null) {
				// �ڹ������ﴴ����д��Ĺ�������һ������Ϊ�����������ڶ�������Ϊ�ù����������λ��
				WritableSheet ws = wwb.createSheet(sheetName, location);
				if (ws != null) {
					/* ��ӱ�ṹ */
					// ��
					for (int i=0;i<5;i++) {
						// ��
						for (int j=0;j<5;j++) {
							// Label����������������������һ��Ϊ�У��ڶ���Ϊ�У���������Ϊ��Ԫ����������
							label = new Label(j, i, "��"+(i+1)+"�У�" + "��"+(j+1)+"��");
							// ����д�����ݵĵ�Ԫ����ӵ�������
							ws.addCell(label);
						}
					}
					// ���ڴ���д�뵽�ļ�
					wwb.write();
				}
				System.out.println("·��Ϊ��" + fileName + "�Ĺ�����д�����ݳɹ���");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			wwb.close();
		}
	}
	
	public static void main(String[] args) {
		/* ���Զ�ȡ��ע�⣺�ļ�·���е��̷�D:/��ע��б�ܲ�Ҫд�ɷ�б��"\"�� */
		/*File file = new File("E:/testRead.xls");
		try {
			System.out.println(read(file));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		/* ����д�루ע�⣺����������������б�д����ļ������׳��쳣�� */
		try {
			write("E:/testWrite.xls", "Sheet1", 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}