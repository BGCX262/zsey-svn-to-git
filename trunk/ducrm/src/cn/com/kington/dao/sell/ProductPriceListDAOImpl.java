package cn.com.kington.dao.sell;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.sell.ProductPrice;
import cn.com.kington.bean.sell.ProductPriceList;
import cn.com.kington.bean.sell.ProductPriceListSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 产品报价ProductPriceListDAO明细操作接口实现类
 * @author 杜永生
 *
 */
public class ProductPriceListDAOImpl extends BaseDAOImpl<ProductPriceList, ProductPriceListSO> implements
		ProductPriceListDAO {

	@Override
	public String getHqlWhere(ProductPriceListSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, ProductPriceListSO so) {
		if(so.getOrder()!=null){
			criteria.createAlias("order", "o");
			
			if(so.getOrder().getId()!=null){
				criteria.add(Restrictions.eq("o.id", so.getOrder().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getOrder().getCode())){
				criteria.add(Restrictions.eq("o.code", so.getOrder().getCode()));
			}
		}
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
	}

	@Override
	public void setQueryParams(Query query, ProductPriceListSO so) {
		
	}

	@Override
	public void switchVO2PO(ProductPriceList po, ProductPriceListSO so) {
		if(so.getOrder()!=null && so.getOrder().getId()!=null){
			ProductPrice order=findById(ProductPrice.class, so.getOrder().getId());
			po.setOrder(order);
		}
		
		if(so.getProId()!=null){
			po.setProId(so.getProId());
		}
		
		if(so.getPrice()!=null){
			po.setPrice(so.getPrice());
		}
		
		if(so.getAmount()!=null){
			po.setAmount(so.getAmount());
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getSize())){
			po.setSize(StringUtils.upperCase(StringUtils.trim(so.getSize())));
		}
		
		if(StringUtils.isNotEmpty(so.getRemark())){
			po.setRemark(StringUtils.trim(so.getRemark()));
		}
		
		if(StringUtils.isNotEmpty(so.getUnit())){
			po.setUnit(StringUtils.trim(so.getUnit()));
		}
	}
}
