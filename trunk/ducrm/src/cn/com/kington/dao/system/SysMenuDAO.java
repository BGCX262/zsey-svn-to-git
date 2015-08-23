package cn.com.kington.dao.system;

import cn.com.kington.bean.system.SysMenu;
import cn.com.kington.bean.system.SysMenuSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 系统功能菜单DAO操作接口
 * @author 杜永生
 *
 */
public interface SysMenuDAO extends BaseDAO<SysMenu, SysMenuSO> {
	/**
	 * 判断菜单名称是否存在
	 * @param so
	 * @return true:已存在，false不存在
	 */
	public boolean checkEnName(SysMenuSO so);
	

}
