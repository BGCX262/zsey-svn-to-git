package cn.com.kington.dao.basic;

import java.util.List;

import cn.com.kington.bean.basic.Category;
import cn.com.kington.bean.basic.CategorySO;
import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.dao.BaseDAO;

/**
 * �������DAO�����ӿ�
 * @author ������
 *
 */
public interface CategoryDAO extends BaseDAO<Category, CategorySO> {
	/**
	 * ����CategorySO�����б�
	 * @param CategorySO
	 * @return
	 */
	public List<Category> findByCategory(CategorySO so);
	
	/**
	 * ����code��sort��ȡ������Category��
	 * @param code
	 * @param sort
	 * @return
	 */
	public Category getOnlyCategory(String code, Sort sort);

}
