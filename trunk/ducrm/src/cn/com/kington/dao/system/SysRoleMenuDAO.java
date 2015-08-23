package cn.com.kington.dao.system;

import java.util.List;

import cn.com.kington.bean.system.SysMenu;
import cn.com.kington.bean.system.SysRoleMenu;
import cn.com.kington.bean.system.SysRoleMenuSO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.dao.BaseDAO;

/**
 * ��ɫ��ϵͳ���ܲ˵��Ĺ�ϵ�����ӿ�
 * @author ������
 *
 */
public interface SysRoleMenuDAO extends BaseDAO<SysRoleMenu, SysRoleMenuSO> {
	/**
	 * ����SysRoleMenuSOɾ����¼
	 * @param so
	 */
	public void delete(SysRoleMenuSO so);
	
	/**
	 * ϵͳ��¼ʱ��ѯ���û���Ȩ�Ĺ��ܲ˵��б�
	 * @param user
	 * @return
	 */
	public List<SysMenu> findMenuByUser(SysUser user);
}
