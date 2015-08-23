package cn.com.kington.dao.system;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.model.Accessory;
import cn.com.kington.bean.model.AccessorySO;
import cn.com.kington.dao.BaseDAOImpl;

public class AccessoryDAOImpl extends BaseDAOImpl<Accessory, AccessorySO> implements AccessoryDAO {

	@Override
	public String getHqlWhere(AccessorySO so) {
		StringBuffer where=new StringBuffer();
		if(so.getDataId()!=null){
			where.append(" and dataId=:dataId");
		}
		
		if(so.getSort()!=null){
			where.append(" and sort=:sort");
		}
		
		if(so.getUserid()!=null){
			where.append(" and userid=:userid");
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			where.append(" and name like :name");
		}
		return where.toString();
	}

	@Override
	public void setCriteriaParams(Criteria criteria, AccessorySO so) {
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
		criteria.add(Restrictions.eq("dataId", so.getDataId()));
		criteria.add(Restrictions.eq("sort", so.getSort()));
	}

	@Override
	public void setQueryParams(Query query, AccessorySO so) {
		if(so.getDataId()!=null){
			query.setParameter("dataId", so.getDataId());
		}
		
		if(so.getSort()!=null){
			query.setParameter("sort", so.getSort());
		}
		
		if(so.getUserid()!=null){
			query.setParameter("userid", so.getUserid());
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			query.setParameter("name", "%"+StringUtils.trim(so.getName())+"%");
		}
	}

	@Override
	public void switchVO2PO(Accessory po, AccessorySO so) {
		if(so.getDataId()!=null){
			po.setDataId(so.getDataId());
		}
		
		if(so.getSort()!=null){
			po.setSort(so.getSort());
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getPath())){
			po.setPath(StringUtils.trim(so.getPath()));
		}
		
		if(StringUtils.isNotEmpty(so.getRealname())){
			po.setRealname(StringUtils.trim(so.getRealname()));
		}
		
		if(so.getUserid()!=null){
			po.setUserid(so.getUserid());
		}
	}
	
	public void delete(AccessorySO so){
		if(so.getDataId()!=null && so.getSort()!=null){
			Session session=getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			String hql="delete from Accessory where dataId=:dataId and sort=:sort";
			Query query=session.createQuery(hql);
			setQueryParams(query, so);
			transaction.commit();
		}
	}


}
