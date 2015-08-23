package cn.com.kington.dao;

import java.io.Serializable;
import java.util.List;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PageList;
import cn.com.kington.common.SOSupport;

/**
 * BaseDAO接口
 * @author 杜永生
 *
 */
public interface BaseDAO<PO extends EntitySupport, SO extends SOSupport> {
	/**
	 * 根据HQL语句查询列表
	 * @param <T>
	 * @param hql
	 * @return
	 */
	public <T> List<T> find(String hql);
	
	/**
	 * 根据HQL语句查询列表
	 * @param <T>
	 * @param hql
	 * @param objects
	 * @return
	 */
	public <T> List<T> find(String hql,Object[] objects);
	
	/**
	 * 根据ID查询对象
	 * @param <T>
	 * @param t
	 * @param id
	 * @return
	 */
	public <T> T findById(Class<T> t,Serializable id);
	
	/**
	 * 根据ID查询对象
	 * @param id
	 * @return
	 */
	public PO findById(Serializable id);
	
	
	/**
	 * 根据ID删除对象
	 * @param <T>
	 * @param t
	 * @param id
	 */
	public <T> void deleteById(Class<T> t,Serializable id);
	
	/**
	 * 根据ID删除对象
	 * @param <T>
	 * @param id
	 */
	public <T> void deleteById(Serializable id);
	
	public SO getSOById(Serializable id);
	
	/**
	 * 删除对象
	 * @param <T>
	 * @param t
	 */
	public <T> void delete(T t);

	/**
	 * 保存对象
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> T merge(T t);
	
	/**
	 * 保存并更新对象
	 * @param so
	 * @return
	 */
	public PO saveOrUpdate(SO so);
	
	/**
	 * 保存对象
	 * @param <T>
	 * @param t
	 * @return
	 */
	public void save(Object t);
	
	/**
	 * 根据SO对象查询列表
	 * @param <T>
	 * @param so
	 * @return
	 */
	public <T> List<T> getList(SO so);
	
	/**
	 * 根据SO对象统计数量
	 * @param <T>
	 * @param so
	 * @return
	 */
	public <T> Integer getCount(SO so);
	
	/**
	 * 根据SO对象分页查询
	 * @param <T>
	 * @param so
	 * @return
	 */
	public <T> PageList<T> findPage(SO so);
	
	/**
	 * 根据clazz对象删除数组ids里的记录
	 * @param <T>
	 * @param clazz
	 * @param ids
	 * @return
	 */
	public <T> Integer clear(Class<T> clazz,Object[] ids);
	
	/**
	 * 删除数组ids里的记录
	 * @param <T>
	 * @param ids
	 * @return
	 */
	public <T> Integer clear(Object[] ids);
	
}
