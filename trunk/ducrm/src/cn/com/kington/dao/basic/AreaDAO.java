package cn.com.kington.dao.basic;

import java.util.List;

import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.AreaSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 地区AreaDAO操作接口
 * @author 杜永生
 *
 */
public interface AreaDAO extends BaseDAO<Area, AreaSO> {
	public List<Area> find(AreaSO so);

}
