package cn.com.kington.dao.finance;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.finance.OrderBudget;
import cn.com.kington.bean.finance.OrderBudgetSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 订单预算OrderBudgetDAO操作接口
 * @author 杜永生
 *
 */
public class OrderBudgetDAOImpl extends BaseDAOImpl<OrderBudget, OrderBudgetSO> implements OrderBudgetDAO {

	@Override
	public String getHqlWhere(OrderBudgetSO so) {
		StringBuffer hql=new StringBuffer("");
		
		if(StringUtils.isNotEmpty(so.getCode())){
			hql.append(" and code=:code");
		}
		
		if(so.getDataId()!=null){
			hql.append(" and dataId=:dataId");
		}
		
		if(so.getSort()!=null){
			hql.append(" and sort=:sort");
		}
		return hql.toString();
	}

	@Override
	public void setCriteriaParams(Criteria criteria, OrderBudgetSO so) {
		if(so.getSort()!=null){
			criteria.add(Restrictions.eq("sort", so.getSort()));
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.eq("code", StringUtils.trim(so.getCode())));
		}
		
		if(so.getDataId()!=null){
			criteria.add(Restrictions.eq("dataId", so.getDataId()));
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
	}

	@Override
	public void setQueryParams(Query query, OrderBudgetSO so) {
		if(StringUtils.isNotEmpty(so.getCode())){
			query.setParameter("code", StringUtils.trim(so.getCode()));
		}
		
		if(so.getDataId()!=null){
			query.setParameter("dataId", so.getDataId());
		}
		
		if(so.getSort()!=null){
			query.setParameter("sort", so.getSort());
		}
	}

	@Override
	public void switchVO2PO(OrderBudget po, OrderBudgetSO so) {
		if (so.getFlag() != null) {
			po.setFlag(so.getFlag());
		}

		if (so.getStatus() != null) {
			po.setStatus(so.getStatus());
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(so.getSort()!=null){
			po.setSort(so.getSort());
		}
		
		if(so.getDataId()!=null){
			po.setDataId(so.getDataId());
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getUnit())){
			po.setUnit(StringUtils.trim(so.getUnit()));
		}
		
		if(so.getPrice()!=null){
			po.setPrice(so.getPrice());
		}
		
		if(so.getAmount()!=null){
			po.setAmount(so.getAmount());
		}
		
		if(StringUtils.isNotEmpty(so.getRemark())){
			po.setRemark(so.getRemark());
		}
	}
	
	public void updateBudget(String code, Long id){
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		String sql="update xm_sell_order_list set budget=(select sum(amount*price) budget from xm_order_budget where dataId=:dataId) where id=:id";
		Query query=session.createSQLQuery(sql);
		query.setParameter("dataId", id);
		query.setParameter("id", id);
		query.executeUpdate();
		
		sql="update xm_sell_order s set s.budget=(select sum(l.amount*l.budget) budget from xm_sell_order_list l where l.fk_order_id=s.id) where s.code=:code";
		query=session.createSQLQuery(sql);
		query.setParameter("code", code);
		query.executeUpdate();
		
		transaction.commit();
	}
	
	public void delete(OrderBudgetSO so){
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		
		String hql="delete from OrderBudget where 1=1"+getHqlWhere(so);
		
		Query query=session.createQuery(hql.toString());
		setQueryParams(query, so);
		query.executeUpdate();
		
		transaction.commit();
		
	}

}
