package cn.com.kington.dao.system;

import java.util.List;

import cn.com.kington.bean.system.SysMenu;
import cn.com.kington.bean.system.SysRoleMenu;
import cn.com.kington.bean.system.SysRoleMenuSO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.dao.BaseDAO;

/**
 * 角色与系统功能菜单的关系操作接口
 * @author 杜永生
 *
 */
public interface SysRoleMenuDAO extends BaseDAO<SysRoleMenu, SysRoleMenuSO> {
	/**
	 * 根据SysRoleMenuSO删除记录
	 * @param so
	 */
	public void delete(SysRoleMenuSO so);
	
	/**
	 * 系统登录时查询该用户授权的功能菜单列表
	 * @param user
	 * @return
	 */
	public List<SysMenu> findMenuByUser(SysUser user);
}
