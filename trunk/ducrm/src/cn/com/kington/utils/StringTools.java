package cn.com.kington.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * String����������
 * @author ������
 *
 */
public class StringTools {
	/**
	 * ����㣨��������50��0��
	 * @param num
	 * @param digit
	 * @return
	 */
	public static String fillZero(String num,int digit){
		if(num.length()<digit){
			String zero = "00000000000000000000000000000000000000000000000000";//�����ô50λ
			String str=zero.substring(0,digit-num.length())+num;
			return str;
		}
		return num;
	}
	
	/**   
     * ����ת��λ����ƴ������ĸ��Ӣ���ַ�����   
     * @param chines ����   
     * @return ƴ��   
     */     
    public static String converterToFirstSpell(String chines){             
         String pinyinName = "";      
        char[] nameChar = chines.toCharArray();      
         HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();      
         defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);      
         defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);      
        for (int i = 0; i < nameChar.length; i++) {      
            if (nameChar[i] > 128) {      
                try {  
                	String[] str = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
                	if(str != null)
                		pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(0);      
                 } catch (BadHanyuPinyinOutputFormatCombination e) {      
                     e.printStackTrace();      
                 }      
             }else{      
                 pinyinName += nameChar[i];
             }      
         }      
        return pinyinName;      
     }      
       
    /**   
     * ����ת��λ����ƴ����Ӣ���ַ�����   
     * @param chines ����   
     * @return ƴ��   
     */     
    public static String converterToSpell(String chines){              
         String pinyinName = "";      
        char[] nameChar = chines.toCharArray();      
         HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();      
         defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);      
         defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);      
        for (int i = 0; i < nameChar.length; i++) {      
            if (nameChar[i] > 128) {      
                try {      
                     pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];      
                 } catch (BadHanyuPinyinOutputFormatCombination e) {      
                     e.printStackTrace();      
                 }      
             }else{      
                 pinyinName += nameChar[i];      
             }      
         }      
        return pinyinName;      
     } 
}
