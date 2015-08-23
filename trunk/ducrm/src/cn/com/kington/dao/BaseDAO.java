package cn.com.kington.dao;

import java.io.Serializable;
import java.util.List;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PageList;
import cn.com.kington.common.SOSupport;

/**
 * BaseDAO�ӿ�
 * @author ������
 *
 */
public interface BaseDAO<PO extends EntitySupport, SO extends SOSupport> {
	/**
	 * ����HQL����ѯ�б�
	 * @param <T>
	 * @param hql
	 * @return
	 */
	public <T> List<T> find(String hql);
	
	/**
	 * ����HQL����ѯ�б�
	 * @param <T>
	 * @param hql
	 * @param objects
	 * @return
	 */
	public <T> List<T> find(String hql,Object[] objects);
	
	/**
	 * ����ID��ѯ����
	 * @param <T>
	 * @param t
	 * @param id
	 * @return
	 */
	public <T> T findById(Class<T> t,Serializable id);
	
	/**
	 * ����ID��ѯ����
	 * @param id
	 * @return
	 */
	public PO findById(Serializable id);
	
	
	/**
	 * ����IDɾ������
	 * @param <T>
	 * @param t
	 * @param id
	 */
	public <T> void deleteById(Class<T> t,Serializable id);
	
	/**
	 * ����IDɾ������
	 * @param <T>
	 * @param id
	 */
	public <T> void deleteById(Serializable id);
	
	public SO getSOById(Serializable id);
	
	/**
	 * ɾ������
	 * @param <T>
	 * @param t
	 */
	public <T> void delete(T t);

	/**
	 * �������
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> T merge(T t);
	
	/**
	 * ���沢���¶���
	 * @param so
	 * @return
	 */
	public PO saveOrUpdate(SO so);
	
	/**
	 * �������
	 * @param <T>
	 * @param t
	 * @return
	 */
	public void save(Object t);
	
	/**
	 * ����SO�����ѯ�б�
	 * @param <T>
	 * @param so
	 * @return
	 */
	public <T> List<T> getList(SO so);
	
	/**
	 * ����SO����ͳ������
	 * @param <T>
	 * @param so
	 * @return
	 */
	public <T> Integer getCount(SO so);
	
	/**
	 * ����SO�����ҳ��ѯ
	 * @param <T>
	 * @param so
	 * @return
	 */
	public <T> PageList<T> findPage(SO so);
	
	/**
	 * ����clazz����ɾ������ids��ļ�¼
	 * @param <T>
	 * @param clazz
	 * @param ids
	 * @return
	 */
	public <T> Integer clear(Class<T> clazz,Object[] ids);
	
	/**
	 * ɾ������ids��ļ�¼
	 * @param <T>
	 * @param ids
	 * @return
	 */
	public <T> Integer clear(Object[] ids);
	
}
