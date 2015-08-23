package cn.com.kington.dao.sell;

import cn.com.kington.bean.sell.ProductPrice;
import cn.com.kington.bean.sell.ProductPriceSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 产品报价ProductPriceDAO操作接口
 * @author 杜永生
 *
 */
public interface ProductPriceDAO extends BaseDAO<ProductPrice, ProductPriceSO> {
	/**
	 * 删除明细
	 * @param id：订单ID
	 */
	public void deleteDetails(Long id);
}
