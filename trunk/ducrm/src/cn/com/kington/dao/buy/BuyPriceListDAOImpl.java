package cn.com.kington.dao.buy;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.buy.BuyPrice;
import cn.com.kington.bean.buy.BuyPriceList;
import cn.com.kington.bean.buy.BuyPriceListSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 采购询价BuyPriceListDAO操作接口实现类
 * @author 杜永生
 *
 */
public class BuyPriceListDAOImpl extends BaseDAOImpl<BuyPriceList, BuyPriceListSO> implements BuyPriceListDAO {

	@Override
	public String getHqlWhere(BuyPriceListSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, BuyPriceListSO so) {
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
	public void setQueryParams(Query query, BuyPriceListSO so) {
		
	}

	@Override
	public void switchVO2PO(BuyPriceList po, BuyPriceListSO so) {
		if(so.getFlag()!=null){
			po.setFlag(so.getFlag());
		}
		
		if(so.getStatus()!=null){
			po.setStatus(so.getStatus());
		}
		
		if(so.getOrder()!=null && so.getOrder().getId()!=null){
			BuyPrice order=findById(BuyPrice.class, so.getOrder().getId());
			po.setOrder(order);
		}
		
		if(so.getMateId()!=null){
			po.setMateId(so.getMateId());
		}
		
		if(so.getAmount()!=null){
			po.setAmount(so.getAmount());
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
