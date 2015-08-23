package cn.com.kington.dao.system;

import cn.com.kington.bean.system.SysUser;
import cn.com.kington.bean.system.SysUserSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 系统用户DAO操作接口
 * @author 杜永生
 *
 */
public interface SysUserDAO extends BaseDAO<SysUser, SysUserSO> {
	/**
	 * 判断系统用户是否存在
	 * @param so
	 * @return 存在返回SysUser对象，否则返回null
	 */
	public SysUser checkUser(SysUserSO so);
	
	/**
	 * 根据ID删除SysUser对象
	 * @param id
	 */
	public void delete(Long id);
}
