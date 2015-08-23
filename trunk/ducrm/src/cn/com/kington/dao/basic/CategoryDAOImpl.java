package cn.com.kington.dao.basic;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Category;
import cn.com.kington.bean.basic.CategorySO;
import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 分类管理DAO实现类
 * @author 杜永生
 *
 */
public class CategoryDAOImpl extends BaseDAOImpl<Category, CategorySO> implements CategoryDAO {

	@Override
	public String getHqlWhere(CategorySO so) {
		StringBuffer where=new StringBuffer();
		
		if(so.getFlag()!=null){
			where.append(" and flag=:flag");
		}
		
		if(so.getStatus()!=null){
			where.append(" and status=:status");
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			where.append(" and code=:code");
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			where.append(" and name like :name");
		}
		
		if(so.getSort()!=null){
			where.append(" and sort=:sort");
		}
		
		if(so.getCategory()!=null){
			if(so.getCategory().getId()!=null){
				where.append(" and category.id=:cid");
			}
		}else{
			where.append(" and category.id is null");
		}
		
		return where.toString();
	}

	@Override
	public void setCriteriaParams(Criteria criteria, CategorySO so) {
		if(so.getCategory()!=null){
			criteria.createAlias("category", "c");
			
			if(so.getCategory().getId()!=null){
				criteria.add(Restrictions.eq("c.id", so.getCategory().getId()));
			}
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.eq("code", StringUtils.trim(so.getCode())));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.ilike("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		
		if(so.getSort()!=null){
			criteria.add(Restrictions.eq("sort", so.getSort()));
		}
		
		if(so.getFlag()!=null){
			criteria.add(Restrictions.eq("flag", so.getFlag()));
		}
		
		if(so.getStatus()!=null){
			criteria.add(Restrictions.eq("status", so.getStatus()));
		}
	}

	@Override
	public void setQueryParams(Query query, CategorySO so) {
		if(so.getFlag()!=null){
			query.setParameter("flag", so.getFlag());
		}
		
		if(so.getStatus()!=null){
			query.setParameter("status", so.getStatus());
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			query.setParameter("code", StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			query.setParameter("name", StringUtils.trim(so.getName()));
		}
		
		if(so.getSort()!=null){
			query.setParameter("sort", so.getSort());
		}
		
		if(so.getCategory()!=null){
			if(so.getCategory().getId()!=null){
				query.setParameter("cid", so.getCategory().getId());
			}
		}
	}

	@Override
	public void switchVO2PO(Category po, CategorySO so) {
		if(so.getCategory()!=null){
			
			if(so.getCategory().getId()!=null){
				Category category=findById(so.getCategory().getId());
				po.setCategory(category);
			}
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(so.getSort()!=null){
			po.setSort(so.getSort());
		}
		
		if(so.getFlag()!=null){
			so.setFlag(so.getFlag());
		}
		
		if(so.getStatus()!=null){
			so.setStatus(so.getStatus());
		}
	}
	
	public <T> void deleteById(Serializable id){
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		
		String hql="delete from Category where category.id=:categoryId";
		Query query=session.createQuery(hql);
		query.setParameter("categoryId", id);
		query.executeUpdate();
		
		hql="delete from Category where id=:id";
		query=session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		
		transaction.commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findByCategory(CategorySO so){
		Session session=getSessionFactory().getCurrentSession();
		String hql="from Category where 1=1"+getHqlWhere(so);
		
		Query query=session.createQuery(hql);
		setQueryParams(query, so);
		List<Category> list=query.list();
		
		return list;
	}
	
	public Category getOnlyCategory(String code, Sort sort){
		Object obj=null;
		if(StringUtils.isNotEmpty(code) && sort!=null){
			try{
				Session session=getSessionFactory().getCurrentSession();
				String hql="from Category where code=:code and sort=:sort";
				Query query=session.createQuery(hql);
				query.setParameter("code", code);
				query.setParameter("sort", sort);
				obj=query.uniqueResult();
				if(obj!=null){
					return (Category)obj;
				}
			}catch (Exception e) {
				return null;
			}
		}
		return null;
		
	}


}
