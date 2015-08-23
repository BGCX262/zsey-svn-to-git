package cn.com.kington.dao.sell;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.sell.SellOrder;
import cn.com.kington.bean.sell.SellOrderList;
import cn.com.kington.bean.sell.SellOrderListSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 销售项目订单明细操作接口实现类
 * @author 杜永生
 *
 */
public class SellOrderListDAOImpl extends BaseDAOImpl<SellOrderList, SellOrderListSO> implements
		SellOrderListDAO {
	
	public void updateOrderAmountAndPriceByOrderId(Long orderId){
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		StringBuffer hql=new StringBuffer();
		hql.append("update xm_sell_order set");
		hql.append(" payment=(select sum(price*amount) from xm_sell_order_list where fk_order_id="+orderId+"),");
		hql.append(" total=(select sum(amount) from xm_sell_order_list where fk_order_id="+orderId+")");
		hql.append(" where id="+orderId);
		Query query=session.createSQLQuery(hql.toString());
		query.executeUpdate();
		transaction.commit();
	}

	@Override
	public String getHqlWhere(SellOrderListSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, SellOrderListSO so) {
		if(so.getOrder()!=null){
			criteria.createAlias("order", "o");
			
			if(so.getOrder().getId()!=null){
				criteria.add(Restrictions.eq("o.id", so.getOrder().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getOrder().getCode())){
				criteria.add(Restrictions.eq("o.code", so.getOrder().getCode()));
			}
		}
	}

	@Override
	public void setQueryParams(Query query, SellOrderListSO so) {
	}

	@Override
	public void switchVO2PO(SellOrderList po, SellOrderListSO so) {
		if(so.getOrder()!=null && so.getOrder().getId()!=null){
			SellOrder order=findById(SellOrder.class, so.getOrder().getId());
			po.setOrder(order);
		}
		
		if(so.getProId()!=null){
			po.setProId(so.getProId());
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getSize())){
			po.setSize(StringUtils.trim(so.getSize().toUpperCase()));
		}
		
		if(StringUtils.isNotEmpty(so.getUnit())){
			po.setUnit(StringUtils.trim(so.getUnit().toUpperCase()));
		}
		
		if(StringUtils.isNotEmpty(so.getRemark())){
			po.setRemark(StringUtils.trim(so.getRemark()));
		}
		
		if(so.getPrice()!=null){
			po.setPrice(so.getPrice());
		}
		
		if(so.getAmount()!=null){
			po.setAmount(so.getAmount());
		}
		
		if(so.getTotal()!=null){
			po.setTotal(so.getTotal());
		}
	}
}
