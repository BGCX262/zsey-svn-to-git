package cn.com.kington.dao.basic;

import cn.com.kington.bean.basic.Product;
import cn.com.kington.bean.basic.ProductSO;
import cn.com.kington.dao.BaseDAO;

/**
 * ��Ʒ����DAO�����ӿ�
 * @author ������
 *
 */
public interface ProductDAO extends BaseDAO<Product, ProductSO> {
	/**
	 * ����IDɾ����Ʒ������д��Ʒ��ص���Ϣ
	 * @param id
	 */
	public void deleteById(Long id);
	
	/**
	 * ɾ���ò�Ʒ��������ϸ
	 * @param id
	 */
	public void deleteMates(Long id);
	
	/**
	 * ɾ���ò�Ʒ��������ϸ
	 * @param id
	 */
	public void deleteWorks(Long id);

}
