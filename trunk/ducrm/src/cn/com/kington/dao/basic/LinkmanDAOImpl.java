package cn.com.kington.dao.basic;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Category;
import cn.com.kington.bean.model.Linkman;
import cn.com.kington.bean.model.LinkmanSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 联系人LinkmanDAO操作接口实现类
 * @author 杜永生
 *
 */
public class LinkmanDAOImpl extends BaseDAOImpl<Linkman, LinkmanSO> implements LinkmanDAO {

	@Override
	public String getHqlWhere(LinkmanSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, LinkmanSO so) {
		if(so.getSort()!=null){
			criteria.add(Restrictions.eq("sort", so.getSort()));
		}
		
		if(so.getDataId()!=null){
			criteria.add(Restrictions.eq("dataId", so.getDataId()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.ilike("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		
		if(so.getRelation()!=null){
			criteria.createAlias("relation", "r");
			
			if(so.getRelation().getId()!=null){
				criteria.add(Restrictions.eq("r.id", so.getRelation().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getRelation().getCode())){
				criteria.add(Restrictions.eq("r.code", StringUtils.trim(so.getRelation().getCode())));
			}
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
		
	}

	@Override
	public void setQueryParams(Query query, LinkmanSO so) {
		
	}

	@Override
	public void switchVO2PO(Linkman po, LinkmanSO so) {
		if(so.getSort()!=null){
			po.setSort(so.getSort());
		}
		
		if(so.getDataId()!=null){
			po.setDataId(so.getDataId());
		}
		
		if(so.getRelation()!=null && so.getRelation().getId()!=null){
			Category category=findById(Category.class, so.getRelation().getId());
			po.setRelation(category);
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getPhone())){
			po.setPhone(StringUtils.trim(so.getPhone()));
		}
		
		if(StringUtils.isNotEmpty(so.getMobile())){
			po.setMobile(StringUtils.trim(so.getMobile()));
		}
		
		if(StringUtils.isNotEmpty(so.getQq())){
			po.setQq(StringUtils.trim(so.getQq()));
		}
		
		if(StringUtils.isNotEmpty(so.getEmail())){
			po.setEmail(StringUtils.trim(so.getEmail()));
		}
		
		if(StringUtils.isNotEmpty(so.getCompany())){
			po.setCompany(StringUtils.trim(so.getCompany()));
		}
		
		if(StringUtils.isNotEmpty(so.getDuty())){
			po.setDuty(StringUtils.trim(so.getDuty()));
		}
	}
	
	public void delete(LinkmanSO so){
		if(so.getSort()!=null && so.getDataId()!=null){
			Session session=getSessionFactory().getCurrentSession();
			Transaction transaction=session.beginTransaction();
			
			String hql="delete from Linkman where dataId=:dataId and sort=:sort";
			Query query=session.createQuery(hql);
			query.setParameter("dataId", so.getDataId());
			query.setParameter("sort", so.getSort());
			query.executeUpdate();
			
			transaction.commit();
		}
	}
}
