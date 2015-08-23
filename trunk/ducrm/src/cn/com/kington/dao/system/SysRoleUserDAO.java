package cn.com.kington.dao.system;

import cn.com.kington.bean.system.SysRoleUser;
import cn.com.kington.bean.system.SysRoleUserSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 系统用户写系统角色的关系DAO操作接口
 * @author 杜永生
 *
 */
public interface SysRoleUserDAO extends BaseDAO<SysRoleUser, SysRoleUserSO> {
	/**
	 * 根据SysRoleUserSO对象删除数据
	 * @param so
	 */
	public void delete(SysRoleUserSO so);

}
