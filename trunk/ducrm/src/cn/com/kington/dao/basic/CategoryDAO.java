package cn.com.kington.dao.basic;

import java.util.List;

import cn.com.kington.bean.basic.Category;
import cn.com.kington.bean.basic.CategorySO;
import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.dao.BaseDAO;

/**
 * 分类管理DAO操作接口
 * @author 杜永生
 *
 */
public interface CategoryDAO extends BaseDAO<Category, CategorySO> {
	/**
	 * 根据CategorySO对象列表
	 * @param CategorySO
	 * @return
	 */
	public List<Category> findByCategory(CategorySO so);
	
	/**
	 * 根据code和sort获取独立的Category类
	 * @param code
	 * @param sort
	 * @return
	 */
	public Category getOnlyCategory(String code, Sort sort);

}
