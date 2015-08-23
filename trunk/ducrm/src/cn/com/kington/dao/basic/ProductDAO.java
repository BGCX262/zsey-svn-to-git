package cn.com.kington.dao.basic;

import cn.com.kington.bean.basic.Product;
import cn.com.kington.bean.basic.ProductSO;
import cn.com.kington.dao.BaseDAO;

/**
 * 产品管理DAO操作接口
 * @author 杜永生
 *
 */
public interface ProductDAO extends BaseDAO<Product, ProductSO> {
	/**
	 * 根据ID删除产品及其他写产品相关的信息
	 * @param id
	 */
	public void deleteById(Long id);
	
	/**
	 * 删除该产品的物料明细
	 * @param id
	 */
	public void deleteMates(Long id);
	
	/**
	 * 删除该产品的物料明细
	 * @param id
	 */
	public void deleteWorks(Long id);

}
