package cn.com.kington.dao.basic;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Material;
import cn.com.kington.bean.basic.Provider;
import cn.com.kington.bean.basic.ProviderMaterial;
import cn.com.kington.bean.basic.ProviderMaterialSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 供应商和物料的关系操作接口实现类
 * @author 杜永生
 *
 */
public class ProviderMaterialDAOImpl extends BaseDAOImpl<ProviderMaterial, ProviderMaterialSO> implements
		ProviderMaterialDAO {

	@Override
	public String getHqlWhere(ProviderMaterialSO so) {
		StringBuffer where=new StringBuffer();
		if(so.getProvider()!=null && so.getProvider().getId()!=null){
			where.append(" and provider.id=:providerId");
		}
		
		if(so.getMaterial()!=null && so.getMaterial().getId()!=null){
			where.append(" and material.id=:materialId");
		}
		
		return where.toString();
	}

	@Override
	public void setCriteriaParams(Criteria criteria, ProviderMaterialSO so) {
		criteria.createAlias("provider", "p");
		criteria.createAlias("material", "m");
		if(so.getFlag()!=null){
			criteria.add(Restrictions.eq("flag", so.getFlag()));
		}
		
		if(so.getStatus()!=null){
			criteria.add(Restrictions.eq("status", so.getStatus()));
		}
		
		if(so.getProvider()!=null){
			if(so.getProvider().getId()!=null){
				criteria.add(Restrictions.eq("p.id", so.getProvider().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getProvider().getName())){
				criteria.add(Restrictions.or(
						Restrictions.ilike("p.name", "%"+StringUtils.trim(so.getProvider().getName())+"%"),
						Restrictions.ilike("p.shortName", "%"+StringUtils.trim(so.getProvider().getShortName())+"%")));
			}
			
		}
		
		if(so.getMaterial()!=null){
			if(so.getMaterial().getId()!=null){
				criteria.add(Restrictions.eq("m.id", so.getMaterial().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getMaterial().getCode())){
				criteria.add(Restrictions.eq("m.code", StringUtils.trim(so.getMaterial().getCode())));
			}
			
			if(StringUtils.isNotEmpty(so.getMaterial().getName())){
				criteria.add(Restrictions.ilike("m.name", "%"+StringUtils.trim(so.getMaterial().getName())+"%"));
			}
		}
	}

	@Override
	public void setQueryParams(Query query, ProviderMaterialSO so) {
		if(so.getProvider()!=null && so.getProvider().getId()!=null){
			query.setParameter("providerId", so.getProvider().getId());
		}
		
		if(so.getMaterial()!=null && so.getMaterial().getId()!=null){
			query.setParameter("materialId", so.getMaterial().getId());
		}
	}

	@Override
	public void switchVO2PO(ProviderMaterial po, ProviderMaterialSO so) {
		if(so.getProvider()!=null && so.getProvider().getId()!=null){
			Provider provider=findById(Provider.class, so.getProvider().getId());
			po.setProvider(provider);
		}
		
		if(so.getMaterial()!=null && so.getMaterial().getId()!=null){
			Material material=findById(Material.class, so.getMaterial().getId());
			po.setMaterial(material);
		}
	}
	
	public void delete(ProviderMaterialSO so){
		String hql="delete from ProviderMaterial where 1=1"+getHqlWhere(so);
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery(hql);
		setQueryParams(query, so);
		query.executeUpdate();
		transaction.commit();
	}


}
