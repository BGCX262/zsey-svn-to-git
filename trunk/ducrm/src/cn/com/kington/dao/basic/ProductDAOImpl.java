package cn.com.kington.dao.basic;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Category;
import cn.com.kington.bean.basic.Customer;
import cn.com.kington.bean.basic.Product;
import cn.com.kington.bean.basic.ProductSO;
import cn.com.kington.bean.system.SysDict;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 产品管理DAO操作接口实现类
 * 
 * @author 杜永生
 * 
 */
public class ProductDAOImpl extends BaseDAOImpl<Product, ProductSO> implements
		ProductDAO {

	@Override
	public String getHqlWhere(ProductSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, ProductSO so) {

		if (so.getCategory() != null) {
			criteria.createAlias("category", "c");

			if (so.getCategory().getId() != null) {
				criteria.add(Restrictions.eq("c.id", so.getCategory().getId()));
			}

			if (StringUtils.isNotEmpty(so.getCategory().getCode())) {
				criteria.add(Restrictions.eq("c.code", StringUtils.trim(so
						.getCategory().getCode())));
			}

			if (StringUtils.isNotEmpty(so.getCategory().getName())) {
				criteria.add(Restrictions.ilike("c.name", "%"
						+ StringUtils.trim(so.getCategory().getName()) + "%"));
			}

			if (so.getCategory().getSort() != null) {
				criteria.add(Restrictions.eq("c.sort", so.getCategory()
						.getSort()));
			}
		}

		if (so.getCustomer() != null) {
			criteria.createAlias("customer", "cu");

			if (so.getCustomer().getId() != null) {
				criteria
						.add(Restrictions.eq("cu.id", so.getCustomer().getId()));
			}

			if (StringUtils.isNotEmpty(so.getCustomer().getCode())) {
				criteria.add(Restrictions.eq("cu.code", StringUtils.trim(so
						.getCustomer().getCode())));
			}

			if (StringUtils.isNotEmpty(so.getCustomer().getName())) {
				criteria.add(Restrictions.ilike("cu.name", "%"
						+ StringUtils.trim(so.getCustomer().getName()) + "%"));
			}
		}

		if (StringUtils.isNotEmpty(so.getCode())) {
			criteria.add(Restrictions
					.eq("code", StringUtils.trim(so.getCode())));
			;
		}

		if (StringUtils.isNotEmpty(so.getName())) {
			criteria.add(Restrictions.ilike("name", "%"
					+ StringUtils.trim(so.getName()) + "%"));
		}

		if (so.getType() != null) {
			criteria.add(Restrictions.eq("type", so.getType()));
		}

		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));

	}

	@Override
	public void setQueryParams(Query query, ProductSO so) {

	}

	@Override
	public void switchVO2PO(Product po, ProductSO so) {
		if (so.getCategory() != null && so.getCategory().getId() != null) {
			Category category = findById(Category.class, so.getCategory()
					.getId());
			po.setCategory(category);
		}

		if (so.getUnit() != null && so.getUnit().getId() != null) {
			SysDict dict = findById(SysDict.class, so.getUnit().getId());
			po.setUnit(dict);
		}

		if (so.getCustomer() != null && so.getCustomer().getId() != null) {
			Customer customer = findById(Customer.class, so.getCustomer()
					.getId());
			po.setCustomer(customer);
		}

		if (so.getType() != null) {
			po.setType(so.getType());
		}

		if (so.getPrice() != null) {
			po.setPrice(so.getPrice());
		}
		
		if(so.getCost()!=null){
			po.setCost(so.getCost());
		}

		if (StringUtils.isNotEmpty(so.getName())) {
			po.setName(StringUtils.trim(so.getName()));
		}

		if (StringUtils.isNotEmpty(so.getCode())) {
			po.setCode(StringUtils.trim(so.getCode()));
		}
	}

	public void deleteById(Long id){
		Session session = getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// 删除附件
		String hql = "delete from Accessory where dataId=:dataId and sort=:sort";
		Query query = session.createQuery(hql);
		query.setParameter("dataId", id);
		query.setParameter("sort", OrderState.JCXXGL_CPGL);
		query.executeUpdate();
		
		//删除产品材料
		deleteMates(id);
		
		//删除产品工序
		deleteWorks(id);
		
		// 删除产品
		hql = "delete from Product where id=:id";
		query=session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		
		transaction.commit();
	}
	
	
	public void deleteMates(Long id){
		Session session = getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String hql = "delete from ProductMaterial where proId=:proId";
		Query query = session.createQuery(hql);
		query=session.createQuery(hql);
		query.setParameter("proId", id);
		query.executeUpdate();
		transaction.commit();
	}
	
	public void deleteWorks(Long id){
		Session session = getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String hql = "delete from ProductWork where product.id=:proId";
		Query query = session.createQuery(hql);
		query=session.createQuery(hql);
		query.setParameter("proId", id);
		query.executeUpdate();
		transaction.commit();
	}
}
