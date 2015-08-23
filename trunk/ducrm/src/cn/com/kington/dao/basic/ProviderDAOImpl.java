package cn.com.kington.dao.basic;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.Provider;
import cn.com.kington.bean.basic.ProviderSO;
import cn.com.kington.common.PublicType.ManSort;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 供应商ProviderDAO操作接口实现类
 * @author 杜永生
 *
 */
public class ProviderDAOImpl extends BaseDAOImpl<Provider, ProviderSO> implements ProviderDAO {

	@Override
	public String getHqlWhere(ProviderSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, ProviderSO so) {
		if(so.getProvince()!=null){
			criteria.createAlias("province", "p");
			
			if(so.getProvince().getId()!=null){
				criteria.add(Restrictions.eq("p.id", so.getProvince().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getProvince().getCode())){
				criteria.add(Restrictions.eq("p.code", StringUtils.trim(so.getProvince().getCode())));
			}
		}
		
		if(so.getCity()!=null){
			criteria.createAlias("city", "c");
			
			if(so.getCity().getId()!=null){
				criteria.add(Restrictions.eq("c.id", so.getCity().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getCity().getCode())){
				criteria.add(Restrictions.eq("c.code", StringUtils.trim(so.getCity().getCode())));
			}
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.eq("code", StringUtils.trim(so.getCode())));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.ilike("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
		
	}

	@Override
	public void setQueryParams(Query query, ProviderSO so) {
		
	}

	@Override
	public void switchVO2PO(Provider po, ProviderSO so) {
		if(so.getProvince()!=null && so.getProvince().getId()!=null){
			Area area=findById(Area.class, so.getProvince().getId());
			po.setProvince(area);
		}
		
		if(so.getCity()!=null && so.getCity().getId()!=null){
			Area area=findById(Area.class, so.getCity().getId());
			po.setCity(area);
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getShortName())){
			po.setShortName(StringUtils.trim(so.getShortName()));
		}
		
		if(StringUtils.isNotEmpty(so.getWeb())){
			po.setWeb(StringUtils.trim(so.getWeb()));
		}
		
		if(StringUtils.isNotEmpty(so.getTel())){
			po.setTel(StringUtils.trim(so.getTel()));
		}
		
		if(StringUtils.isNotEmpty(so.getPhone())){
			po.setPhone(StringUtils.trim(so.getPhone()));
		}
		
		if(StringUtils.isNotEmpty(so.getFax())){
			po.setFax(StringUtils.trim(so.getFax()));
		}
		
		if(StringUtils.isNotEmpty(so.getQq())){
			po.setQq(StringUtils.trim(so.getQq()));
		}
		
		if(StringUtils.isNotEmpty(so.getLinkman())){
			po.setLinkman(StringUtils.trim(so.getLinkman()));
		}
		
		if(StringUtils.isNotEmpty(so.getEmail())){
			po.setEmail(StringUtils.trim(so.getEmail()));
		}
		
		if(StringUtils.isNotEmpty(so.getMobile())){
			po.setMobile(StringUtils.trim(so.getMobile()));
		}
		
		if(StringUtils.isNotEmpty(so.getAddress())){
			po.setAddress(StringUtils.trim(so.getAddress()));
		}
		
		if(StringUtils.isNotEmpty(so.getPostcode())){
			po.setPostcode(StringUtils.trim(so.getPostcode()));
		}
		
		if(StringUtils.isNotEmpty(so.getBname())){
			po.setBname(StringUtils.trim(so.getBname()));
		}
		
		if(StringUtils.isNotEmpty(so.getBcode())){
			po.setBcode(StringUtils.trim(so.getBcode()));
		}
		
		if(StringUtils.isNotEmpty(so.getBadd())){
			po.setBadd(StringUtils.trim(so.getBadd()));
		}
		
		if(StringUtils.isNotEmpty(so.getBman())){
			po.setBman(StringUtils.trim(so.getBman()));
		}
	}
	
	public void deleteById(Serializable id){
		//删除联系人
		String hql="delete from Linkman where dataId=:dataId and sort=:sort";
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter("dataId", id);
		query.setParameter("sort", ManSort.PROVIDER);
		query.executeUpdate();
		
		//删除供应商信息
		hql="delete from Provider where id=:id";
		query=session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
	}

}
