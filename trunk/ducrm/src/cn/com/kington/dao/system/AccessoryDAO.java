package cn.com.kington.dao.system;

import cn.com.kington.bean.model.Accessory;
import cn.com.kington.bean.model.AccessorySO;
import cn.com.kington.dao.BaseDAO;

/**
 * ����DAO�����ӿ�
 * @author ������
 *
 */
public interface AccessoryDAO extends BaseDAO<Accessory, AccessorySO> {
	/**
	 * ����AccessorySO����ɾ��Accessory����ע�⣺dataId��sort���Ա��븳ֵ
	 * @param so
	 */
	public void delete(AccessorySO so);
}
