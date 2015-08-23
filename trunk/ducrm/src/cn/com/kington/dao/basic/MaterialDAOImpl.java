package cn.com.kington.dao.basic;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Category;
import cn.com.kington.bean.basic.Material;
import cn.com.kington.bean.basic.MaterialSO;
import cn.com.kington.bean.basic.Provider;
import cn.com.kington.bean.system.SysDict;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 物料MaterialDAO操作接口实现类
 * @author 杜永生
 *
 */
public class MaterialDAOImpl extends BaseDAOImpl<Material,MaterialSO> implements MaterialDAO {

	@Override
	public String getHqlWhere(MaterialSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, MaterialSO so) {
		if(so.getProvider()!=null){
			criteria.createAlias("provider", "p");
			
			if(so.getProvider().getId()!=null){
				criteria.add(Restrictions.eq("p.id", so.getProvider().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getProvider().getName())){
				criteria.add(Restrictions.ilike("p.name", "%"+StringUtils.trim(so.getProvider().getName())+"%"));
			}
		}
		
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
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
	}

	@Override
	public void setQueryParams(Query query, MaterialSO so) {
		
	}

	@Override
	public void switchVO2PO(Material po, MaterialSO so) {
		if(so.getFlag()!=null){
			po.setFlag(so.getFlag());
		}
		
		if(so.getStatus()!=null){
			po.setStatus(so.getStatus());
		}
		
		if(so.getProvider()!=null && so.getProvider().getId()!=null){
			Provider provider=findById(Provider.class, so.getProvider().getId());
			po.setProvider(provider);
		}
		
		if(so.getCategory()!=null && so.getCategory().getId()!=null){
			Category category=findById(Category.class, so.getCategory().getId());
			po.setCategory(category);
		}
		
		if(so.getUnit()!=null && so.getUnit().getId()!=null){
			SysDict dict=findById(SysDict.class, so.getUnit().getId());
			po.setUnit(dict);
		}
		
		if(so.getPrice()!=null){
			po.setPrice(so.getPrice());
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getSpec())){
			po.setSpec(StringUtils.trim(so.getSpec()));
		}
		
		if(StringUtils.isNotEmpty(so.getCaption())){
			po.setCaption(StringUtils.trim(so.getCaption()));
		}
	}
	
	/**
	 * 根据ID删除物料Material信息<br />
	 * 第一步：删除Accessory的sort属性值为{@link #OrderState.JCXXGL_WLGL}和dataId属性值为id的附件信息，<br />
	 * 第二步：删除ID为id值的物料Material的记录。
	 */
	public void deleteById(Serializable id){
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		String hql="delete from Accessory where dataId=:dataId and sort=:sort";
		Query query=session.createQuery(hql);
		query.setParameter("dataId", id);
		query.setParameter("sort", OrderState.JCXXGL_WLGL);
		query.executeUpdate();
		
		hql="delete from Material where id=:id";
		query=session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		
		transaction.commit();
	}
}
