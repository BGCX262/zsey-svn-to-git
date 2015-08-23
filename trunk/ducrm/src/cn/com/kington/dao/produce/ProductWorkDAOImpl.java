package cn.com.kington.dao.produce;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Product;
import cn.com.kington.bean.produce.ProductWork;
import cn.com.kington.bean.produce.ProductWorkSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 产品工序ProductWorkDAO操作接口实现类
 * @author 杜永生
 *
 */
public class ProductWorkDAOImpl extends BaseDAOImpl<ProductWork, ProductWorkSO> implements
		ProductWorkDAO {

	@Override
	public void switchVO2PO(ProductWork po, ProductWorkSO so) {
		if(so.getProduct()!=null && so.getProduct().getId()!=null){
			Product product=findById(Product.class, so.getProduct().getId());
			so.setProduct(product);
		}
		
		if(so.getWorkId()!=null){
			po.setWorkId(so.getWorkId());
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(so.getAmount()!=null){
			po.setAmount(so.getAmount());
		}
		
		if(so.getPrice()!=null){
			po.setPrice(so.getPrice());
		}
		
		if(so.getTotal()!=null){
			po.setTotal(so.getTotal());
		}
		
	}

	@Override
	public void setCriteriaParams(Criteria criteria, ProductWorkSO so) {
		if(so.getProduct()!=null){
			criteria.createAlias("product", "p");
			
			if(so.getProduct().getId()!=null){
				criteria.add(Restrictions.eq("p.id", so.getProduct().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getProduct().getCode())){
				criteria.add(Restrictions.eq("p.code", StringUtils.trim(so.getProduct().getCode())));
			}
			
			if(StringUtils.isNotEmpty(so.getProduct().getName())){
				criteria.add(Restrictions.ilike("p.name", "%"+StringUtils.trim(so.getProduct().getName())+"%"));
			}
		}
		
		if(so.getWorkId()!=null){
			criteria.add(Restrictions.eq("workId", so.getWorkId()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.ilike("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
	}

	@Override
	public void setQueryParams(Query query, ProductWorkSO so) {
		
	}

	@Override
	public String getHqlWhere(ProductWorkSO so) {
		return null;
	}


}
