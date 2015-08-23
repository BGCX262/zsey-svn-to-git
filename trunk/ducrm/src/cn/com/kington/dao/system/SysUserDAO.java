package cn.com.kington.dao.system;

import cn.com.kington.bean.system.SysUser;
import cn.com.kington.bean.system.SysUserSO;
import cn.com.kington.dao.BaseDAO;

/**
 * ϵͳ�û�DAO�����ӿ�
 * @author ������
 *
 */
public interface SysUserDAO extends BaseDAO<SysUser, SysUserSO> {
	/**
	 * �ж�ϵͳ�û��Ƿ����
	 * @param so
	 * @return ���ڷ���SysUser���󣬷��򷵻�null
	 */
	public SysUser checkUser(SysUserSO so);
	
	/**
	 * ����IDɾ��SysUser����
	 * @param id
	 */
	public void delete(Long id);
}
