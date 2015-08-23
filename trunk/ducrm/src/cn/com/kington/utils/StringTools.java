package cn.com.kington.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * String操作工具类
 * @author 杜永生
 *
 */
public class StringTools {
	/**
	 * 填充零（最多能填充50个0）
	 * @param num
	 * @param digit
	 * @return
	 */
	public static String fillZero(String num,int digit){
		if(num.length()<digit){
			String zero = "00000000000000000000000000000000000000000000000000";//最多这么50位
			String str=zero.substring(0,digit-num.length())+num;
			return str;
		}
		return num;
	}
	
	/**   
     * 汉字转换位汉语拼音首字母，英文字符不变   
     * @param chines 汉字   
     * @return 拼音   
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
     * 汉字转换位汉语拼音，英文字符不变   
     * @param chines 汉字   
     * @return 拼音   
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
