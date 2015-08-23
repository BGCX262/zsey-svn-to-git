package cn.com.kington.dao.buy;

import cn.com.kington.bean.buy.BuyPrice;
import cn.com.kington.bean.buy.BuyPriceSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 采购（物料）询价BuyPriceDAO操作接口
 * 
 * @author 杜永生
 * 
 */
public interface BuyPriceDAO extends BaseDAO<BuyPrice, BuyPriceSO> {
	/**
	 * 根据BuyPriceSO对象删除采购询价明细
	 * @param so
	 */
	public void deleteList(BuyPriceSO so);
}
