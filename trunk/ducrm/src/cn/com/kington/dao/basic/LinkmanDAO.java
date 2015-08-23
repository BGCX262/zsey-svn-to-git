package cn.com.kington.dao.basic;

import cn.com.kington.bean.model.Linkman;
import cn.com.kington.bean.model.LinkmanSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 联系人LinkmanDAO操作接口
 * @author 杜永生
 *
 */
public interface LinkmanDAO extends BaseDAO<Linkman, LinkmanSO> {
	/**
	 * 根据LinkmanSO对象删除联系人<br />
	 * <span style="color:red;">注意：so对象的dataId和sort属性必须赋值<span>
	 * @param so
	 */
	public void delete(LinkmanSO so);
	

}
