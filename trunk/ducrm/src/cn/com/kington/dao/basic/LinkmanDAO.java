package cn.com.kington.dao.basic;

import cn.com.kington.bean.model.Linkman;
import cn.com.kington.bean.model.LinkmanSO;
import cn.com.kington.dao.BaseDAO;

/**
 * ��ϵ��LinkmanDAO�����ӿ�
 * @author ������
 *
 */
public interface LinkmanDAO extends BaseDAO<Linkman, LinkmanSO> {
	/**
	 * ����LinkmanSO����ɾ����ϵ��<br />
	 * <span style="color:red;">ע�⣺so�����dataId��sort���Ա��븳ֵ<span>
	 * @param so
	 */
	public void delete(LinkmanSO so);
	

}
