package cn.com.kington.dao.system;

import cn.com.kington.bean.system.SysRole;
import cn.com.kington.bean.system.SysRoleSO;
import cn.com.kington.dao.BaseDAO;

/**
 * ��ɫSysRoleDAO�����ӿ�
 * @author ������
 *
 */
public interface SysRoleDAO extends BaseDAO<SysRole, SysRoleSO> {
	/**
	 * ����SysRoleSO�����ѯcode����Ƿ����
	 * @param so
	 * @return true:�Ѵ��ڣ�false��������
	 */
	public boolean checkCode(SysRoleSO so);
	
	/**
	 * ����IDɾ������
	 * @param id
	 */
	public void delete(Long id);

}
