package cn.com.kington.dao.buy;

import cn.com.kington.bean.buy.BuyPrice;
import cn.com.kington.bean.buy.BuyPriceSO;
import cn.com.kington.dao.BaseDAO;

/**
 * �ɹ������ϣ�ѯ��BuyPriceDAO�����ӿ�
 * 
 * @author ������
 * 
 */
public interface BuyPriceDAO extends BaseDAO<BuyPrice, BuyPriceSO> {
	/**
	 * ����BuyPriceSO����ɾ���ɹ�ѯ����ϸ
	 * @param so
	 */
	public void deleteList(BuyPriceSO so);
}
