package cn.com.kington.dao.system;

import cn.com.kington.bean.system.SysRoleUser;
import cn.com.kington.bean.system.SysRoleUserSO;
import cn.com.kington.dao.BaseDAO;

/**
 * ϵͳ�û�дϵͳ��ɫ�Ĺ�ϵDAO�����ӿ�
 * @author ������
 *
 */
public interface SysRoleUserDAO extends BaseDAO<SysRoleUser, SysRoleUserSO> {
	/**
	 * ����SysRoleUserSO����ɾ������
	 * @param so
	 */
	public void delete(SysRoleUserSO so);

}
