package cn.com.kington.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class ObjectTools {
	/**
	 * ����source��������Ե�target�����ϲ�����target����
	 * @param <T>
	 * @param source
	 * @param target
	 * @return
	 */
	public static <T> T copy(Object source, T target) {
		try {
			BeanUtils.copyProperties(target, source);
			return target;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * ����source��������Ե�target�����ϲ�����target����
	 * @param <T>
	 * @param source
	 * @param target
	 * @return
	 */
	public static <T> T copy(Object source, Class<T> target) {
		try {
			if (source == null) return null;
			T t = target.newInstance();
			BeanUtils.copyProperties(t, source);
			return t;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * ������list�б��еĶ������Ը��Ƶ�������class�����в����η��ض��󼯺ϡ�
	 * ������class��������޲ι��췽����
	 * 
	 * @param <T>
	 * @param list
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> copy(List<?> list, Class<T> clazz) {
		if (list == null) return null;
		List<T> result = new ArrayList<T>();
		try {
			for (Object source : list) {
				result.add(copy(source, clazz.newInstance()));
			}
			return result;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
