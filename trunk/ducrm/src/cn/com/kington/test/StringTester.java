package cn.com.kington.test;

import org.junit.Test;

import cn.com.kington.utils.StringTools;

public class StringTester {
	@Test
	public void testMerge(){
		System.out.println(StringTools.converterToFirstSpell("XTGL_�ֵ������").toUpperCase());
	}
}
