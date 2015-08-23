package cn.com.kington.dao.system;

import cn.com.kington.bean.model.Accessory;
import cn.com.kington.bean.model.AccessorySO;
import cn.com.kington.dao.BaseDAO;

/**
 * 附件DAO操作接口
 * @author 杜永生
 *
 */
public interface AccessoryDAO extends BaseDAO<Accessory, AccessorySO> {
	/**
	 * 根据AccessorySO对象删除Accessory对象，注意：dataId和sort属性必须赋值
	 * @param so
	 */
	public void delete(AccessorySO so);
}
