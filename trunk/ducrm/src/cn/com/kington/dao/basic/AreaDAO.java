package cn.com.kington.dao.basic;

import java.util.List;

import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.AreaSO;
import cn.com.kington.dao.BaseDAO;

/**
 * ����AreaDAO�����ӿ�
 * @author ������
 *
 */
public interface AreaDAO extends BaseDAO<Area, AreaSO> {
	public List<Area> find(AreaSO so);

}
