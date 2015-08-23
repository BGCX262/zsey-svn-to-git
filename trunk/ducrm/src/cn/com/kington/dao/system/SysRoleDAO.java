package cn.com.kington.dao.system;

import cn.com.kington.bean.system.SysRole;
import cn.com.kington.bean.system.SysRoleSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 角色SysRoleDAO操作接口
 * @author 杜永生
 *
 */
public interface SysRoleDAO extends BaseDAO<SysRole, SysRoleSO> {
	/**
	 * 根据SysRoleSO对象查询code编号是否存在
	 * @param so
	 * @return true:已存在，false：不存在
	 */
	public boolean checkCode(SysRoleSO so);
	
	/**
	 * 根据ID删除对象
	 * @param id
	 */
	public void delete(Long id);

}
