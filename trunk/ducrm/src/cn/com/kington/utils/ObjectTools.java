package cn.com.kington.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

public class ObjectTools {
	/**
	 * 复制source对象的属性到target对象上并返回target对象
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
	 * 复制source对象的属性到target对象上并返回target对象
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
	 * 将给定list列表集中的对象属性复制到给定的class对象中并依次返回对象集合。
	 * 给定的class必须具有无参构造方法。
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
