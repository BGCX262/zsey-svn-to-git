package cn.com.kington.dao.system;

import cn.com.kington.bean.system.SysMenu;
import cn.com.kington.bean.system.SysMenuSO;
import cn.com.kington.dao.BaseDAO;

/**
 * ϵͳ���ܲ˵�DAO�����ӿ�
 * @author ������
 *
 */
public interface SysMenuDAO extends BaseDAO<SysMenu, SysMenuSO> {
	/**
	 * �жϲ˵������Ƿ����
	 * @param so
	 * @return true:�Ѵ��ڣ�false������
	 */
	public boolean checkEnName(SysMenuSO so);
	

}
