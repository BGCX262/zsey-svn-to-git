package cn.com.kington.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PageList;
import cn.com.kington.common.SOSupport;
import cn.com.kington.utils.DateTools;
import cn.com.kington.utils.ObjectTools;

/**
 * BaseDAOImpl实现类
 * @author 杜永生
 * @param <T>
 *
 */
public abstract class BaseDAOImpl<PO extends EntitySupport, SO extends SOSupport> 
		extends HibernateDaoSupport implements BaseDAO<PO,SO> {
	private Class<PO> poclass;
	private Class<SO> soclass;
	
	public abstract void switchVO2PO(PO po,SO so);
	
	/**
	 * 根据PO对象给Criteria对象设置参数
	 * @param criteria
	 * @param so
	 */
	public abstract void setCriteriaParams(Criteria criteria,SO so);
	
	/**
	 * 根据PO对象给Query对象设置参数
	 * @param query
	 * @param so
	 */
	public abstract void setQueryParams(Query query,SO so);
	
	/**
	 * 根据PO对象拼写出HQL语句的Where条件语句
	 * @param so
	 * @return
	 */
	public abstract String getHqlWhere(SO so);
	

	@SuppressWarnings({ "unchecked"})
	public BaseDAOImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		poclass=(Class<PO>) params[0];
		soclass=(Class<SO>) params[1];
	}

	public <T> Integer clear(Class<T> clazz, Object[] ids) {
		if(ids!=null && ids.length>0){
			String str=StringUtils.join(ids, ",");
			String hql="delete from "+clazz.getSimpleName()+" where id in ("+str+")";
			Session session=getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			int count= query.executeUpdate();
			transaction.commit();
			return count;
		}
		return 0;
	}

	public <T> Integer clear(Object[] ids) {
		return clear(poclass, ids);
	}

	public <T> void deleteById(Class<T> t, Serializable id) {
		String hql="delete from "+t.getSimpleName()+" where id=:id";
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		System.out.println(query.executeUpdate());;
		transaction.commit();
	}
	
	public <T> void deleteById(Serializable id){
		deleteById(poclass, id);
	}
	
	public <T> void delete(T t){
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.delete(t);
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> find(String hql) {
		Session session=getSessionFactory().getCurrentSession();
		Query query=session.createQuery(hql);
		return query.list();
	}

	public <T> List<T> find(String hql, Object[] objects) {
		return find(hql, objects);
	}

	@SuppressWarnings("unchecked")
	public <T> T findById(Class<T> t, Serializable id) {
		Session session=getSessionFactory().getCurrentSession();
		return (T) session.get(t, id);
	}

	@SuppressWarnings("unchecked")
	public PO findById(Serializable id) {
		Session session=getSessionFactory().getCurrentSession();
		return (PO) session.get(poclass, id);
	}

	@SuppressWarnings("unchecked")
	public <T> T merge(T t) {
		String date=DateTools.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		if (t instanceof EntitySupport) {
			EntitySupport e = (EntitySupport) t;
			if (e.getId() == null || e.getId() <= 0L) {
				e.setCreateTime(date);
				e.setUpdateTime(date);
				e.setFlag(true);
				e.setStatus(true);
			}else{
				e.setUpdateTime(date);
			}
			
		}
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		t=(T)session.merge(t);
		transaction.commit();
		return t;
	}

	public void save(Object t) {
		String date=DateTools.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		if (t instanceof EntitySupport) {
			EntitySupport e = (EntitySupport) t;
			if (e.getId() == null || e.getId() <= 0L) {
				e.setCreateTime(date);
				e.setUpdateTime(date);
				e.setFlag(true);
				e.setStatus(true);
			}else{
				e.setUpdateTime(date);
			}
		}
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(t);
		transaction.commit();
	}

	public PO saveOrUpdate(SO so) {
		PO po=null;
		try {
			if(so.getId()!=null && so.getId()>0L){
				po=findById(poclass, so.getId());
			}else{
				po=poclass.newInstance();
			}
			switchVO2PO(po, so);
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merge(po);
	}
	
	public SO getSOById(Serializable id){
		PO po=findById(id);
		return ObjectTools.copy(po, soclass);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getList(SO so){
		Session session=getSessionFactory().getCurrentSession();
		Criteria criteria=session.createCriteria(poclass);
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
		setCriteriaParams(criteria, so);
		criteria.addOrder(Order.desc("id"));
		criteria.setFirstResult(so.getStartIndex());
		criteria.setMaxResults(so.getObjectsPerPage());
		return criteria.list();
	}
	
	public <T> Integer getCount(SO so){
		Session session=getSessionFactory().getCurrentSession();
		Criteria criteria=session.createCriteria(poclass);
		criteria.setProjection(Projections.count("id"));
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
		setCriteriaParams(criteria, so);
		return ((Long)criteria.uniqueResult()).intValue();
	}
	
	public <T> PageList<T> findPage(SO so){
		PageList<T> pageList=new PageList<T>();
		pageList.setPageNumber(so.getPageNumber());
		pageList.setObjectsPerPage(so.getObjectsPerPage());
		pageList.setFullListSize(getCount(so));
		pageList.setList(getList(so));
		return pageList;
	}
}
