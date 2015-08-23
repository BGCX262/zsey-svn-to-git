package cn.com.kington.dao.buy;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Category;
import cn.com.kington.bean.buy.BuyPrice;
import cn.com.kington.bean.buy.BuyPriceSO;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 采购（物料）询价BuyPriceDAO操作接口实现类
 * @author 杜永生
 *
 */
public class BuyPriceDAOImpl extends BaseDAOImpl<BuyPrice, BuyPriceSO>
		implements BuyPriceDAO {

	@Override
	public String getHqlWhere(BuyPriceSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, BuyPriceSO so) {
		if(so.getClientId()!=null){
			criteria.add(Restrictions.eq("clientId", so.getClientId()));
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.eq("code", StringUtils.trim(so.getCode())));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.like("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		
	}

	@Override
	public void setQueryParams(Query query, BuyPriceSO so) {

	}

	@Override
	public void switchVO2PO(BuyPrice po, BuyPriceSO so) {
		
	}
	
	public void deleteById(Serializable id){
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		//删除采购询价明细
		String hql="delete from BuyPriceList where order.id=:orderId";
		Query query=session.createQuery(hql);
		query.setParameter("orderId", id);
		query.executeUpdate();

		//删除附件
		hql="delete from Accessory where sort=:sort and dataId=:dataId";
		query=session.createQuery(hql);
		query.setParameter("sort", OrderState.CGGL_WLZX);
		query.setParameter("dataId", id);
		query.executeUpdate();
		
		//删除采购询价单
		hql="delete from BuyPrice where id=:id";
		query=session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		
		transaction.commit();
	}
	
	public void deleteList(BuyPriceSO so) {
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		//删除采购询价明细
		String hql="delete from BuyPriceList where order.id=:orderId";
		Query query=session.createQuery(hql);
		query.setParameter("orderId", so.getId());
		query.executeUpdate();
		transaction.commit();
	}

}
