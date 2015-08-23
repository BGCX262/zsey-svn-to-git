package cn.com.kington.dao.buy;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.buy.BuyOrder;
import cn.com.kington.bean.buy.BuyOrderList;
import cn.com.kington.bean.buy.BuyOrderListSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 物料采购明细DAO实现类
 * @author 杜永生
 *
 */
public class BuyOrderListDAOImpl extends BaseDAOImpl<BuyOrderList, BuyOrderListSO> implements BuyOrderListDAO {

	@Override
	public String getHqlWhere(BuyOrderListSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, BuyOrderListSO so) {
		if(so.getOrder()!=null){
			criteria.createAlias("order", "o");
			if(so.getOrder().getId()!=null){
				criteria.add(Restrictions.eq("o.id", so.getOrder().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getOrder().getCode())){
				criteria.add(Restrictions.eq("o.code", StringUtils.trim(so.getOrder().getCode())));
			}
			
		}
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
	}

	@Override
	public void setQueryParams(Query query, BuyOrderListSO so) {
		
	}

	@Override
	public void switchVO2PO(BuyOrderList po, BuyOrderListSO so) {
		if(so.getFlag()!=null){
			po.setFlag(so.getFlag());
		}
		
		if(so.getStatus()!=null){
			po.setStatus(so.getStatus());
		}
		
		if(so.getOrder()!=null && so.getOrder().getId()!=null){
			BuyOrder order=findById(BuyOrder.class, so.getOrder().getId());
			po.setOrder(order);
		}
		
		if(so.getMateId()!=null){
			po.setMateId(so.getMateId());
		}
		
		if(so.getAmount()!=null){
			po.setAmount(so.getAmount());
		}else{
			po.setAmount(0.0);
		}
		
		if(so.getInAmount()!=null){
			po.setInAmount(so.getInAmount());
		}
		
		if(so.getPrice()!=null){
			po.setPrice(so.getPrice());
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		
		if(StringUtils.isNotEmpty(so.getSpec())){
			po.setSpec(StringUtils.trim(so.getSpec()));
		}
		
		if(StringUtils.isNotEmpty(so.getUnit())){
			po.setUnit(StringUtils.trim(so.getUnit()));
		}
		
		if(StringUtils.isNotEmpty(so.getRemark())){
			po.setRemark(StringUtils.trim(so.getRemark()));
		}
	}
}
