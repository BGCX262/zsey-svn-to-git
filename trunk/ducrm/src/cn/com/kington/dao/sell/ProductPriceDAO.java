package cn.com.kington.dao.sell;

import cn.com.kington.bean.sell.ProductPrice;
import cn.com.kington.bean.sell.ProductPriceSO;
import cn.com.kington.dao.BaseDAO;

/**
 * ��Ʒ����ProductPriceDAO�����ӿ�
 * @author ������
 *
 */
public interface ProductPriceDAO extends BaseDAO<ProductPrice, ProductPriceSO> {
	/**
	 * ɾ����ϸ
	 * @param id������ID
	 */
	public void deleteDetails(Long id);
}
