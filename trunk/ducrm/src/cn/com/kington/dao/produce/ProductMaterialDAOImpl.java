package cn.com.kington.dao.produce;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.produce.ProductMaterial;
import cn.com.kington.bean.produce.ProductMaterialSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 产品物料ProductMaterialDAO操作接口实现类
 * @author 杜永生
 *
 */
public class ProductMaterialDAOImpl extends
		BaseDAOImpl<ProductMaterial, ProductMaterialSO> implements
		ProductMaterialDAO {

	@Override
	public void switchVO2PO(ProductMaterial po, ProductMaterialSO so) {
		if (so.getProId() != null) {
			po.setProId(so.getProId());
		}

		if (so.getMateId() != null) {
			po.setMateId(so.getMateId());
		}

		if (so.getAmount() != null) {
			po.setAmount(so.getAmount());
		}
		
		if (so.getPrice() != null) {
			po.setPrice(so.getPrice());
		}
		
		if (so.getTotal() != null) {
			po.setTotal(so.getTotal());
		}

		if (StringUtils.isNotEmpty(so.getCode())) {
			po.setCode(StringUtils.trim(so.getCode()));
		}

		if (StringUtils.isNotEmpty(so.getName())) {
			po.setName(StringUtils.trim(so.getName()));
		}

		if (StringUtils.isNotEmpty(so.getUnit())) {
			po.setUnit(StringUtils.trim(so.getUnit()));
		}
	}

	@Override
	public void setCriteriaParams(Criteria criteria, ProductMaterialSO so) {
		if (so.getProId() != null) {
			criteria.add(Restrictions.eq("proId", so.getProId()));
		}
	}

	@Override
	public void setQueryParams(Query query, ProductMaterialSO so) {

	}

	@Override
	public String getHqlWhere(ProductMaterialSO so) {
		return null;
	}

}
