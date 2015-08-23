package cn.com.kington.dao.sell;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.sell.ProductPrice;
import cn.com.kington.bean.sell.ProductPriceSO;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 产品报价ProductPriceDAO操作接口实现类
 * 
 * @author 杜永生
 * 
 */
public class ProductPriceDAOImpl extends
		BaseDAOImpl<ProductPrice, ProductPriceSO> implements ProductPriceDAO {

	@Override
	public String getHqlWhere(ProductPriceSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, ProductPriceSO so) {
		if (so.getClientId() != null) {
			criteria.add(Restrictions.eq("clientId", so.getClientId()));
		}

		if (StringUtils.isNotEmpty(so.getCode())) {
			criteria.add(Restrictions.eq("code", StringUtils.trim(so.getCode())));
		}

		if (StringUtils.isNotEmpty(so.getName())) {
			criteria.add(Restrictions.like("name", "%" + StringUtils.trim(so.getName()) + "%"));
		}

		if (so.getAudit() != null) {
			criteria.add(Restrictions.eq("audit", so.getAudit()));
		}

		if (so.getAsk() != null) {
			criteria.add(Restrictions.eq("ask", so.getAsk()));
		}

		if (so.getStyle() != null) {
			criteria.add(Restrictions.eq("style", so.getStyle()));
		}

	}

	@Override
	public void setQueryParams(Query query, ProductPriceSO so) {

	}

	@Override
	public void switchVO2PO(ProductPrice po, ProductPriceSO so) {
		if (so.getClientId() != null) {
			po.setClientId(so.getClientId());
		}

		if (StringUtils.isNotEmpty(so.getName())) {
			po.setName(StringUtils.trim(so.getName()));
		}

		if (StringUtils.isNotEmpty(so.getLinkman())) {
			po.setLinkman(StringUtils.trim(so.getLinkman()));
		}

		if (StringUtils.isNotEmpty(so.getFax())) {
			po.setFax(StringUtils.trim(so.getFax()));
		}

		if (StringUtils.isNotEmpty(so.getPhone())) {
			po.setPhone(StringUtils.trim(so.getPhone()));
		}

		if (StringUtils.isNotEmpty(so.getTel())) {
			po.setTel(StringUtils.trim(so.getTel()));
		}

		if (StringUtils.isNotEmpty(so.getMobile())) {
			po.setMobile(StringUtils.trim(so.getMobile()));
		}

		if (StringUtils.isNotEmpty(so.getAddress())) {
			po.setAddress(StringUtils.trim(so.getAddress()));
		}

		if (StringUtils.isNotEmpty(so.getPostcode())) {
			po.setPostcode(StringUtils.trim(so.getPostcode()));
		}

		if (StringUtils.isNotEmpty(so.getCode())) {
			po.setCode(StringUtils.trim(so.getCode()));
		}

		if (so.getTotal() != null) {
			po.setTotal(so.getTotal());
		}

		if (so.getPayment() != null) {
			po.setPayment(so.getPayment());
		}

		if (so.getPayfor() != null) {
			po.setPayfor(so.getPayfor());
		}

		if (so.getNopay() != null) {
			po.setNopay(so.getNopay());
		}

		if (so.getAddId() != null) {
			po.setAddId(so.getAddId());
		}

		if (StringUtils.isNotEmpty(so.getAddName())) {
			po.setAddName(StringUtils.trim(so.getAddName()));
		}

		if (StringUtils.isNotEmpty(so.getAddDate())) {
			po.setAddDate(StringUtils.trim(so.getAddDate()));
		}

		if (so.getAudit() != null) {
			po.setAudit(so.getAudit());
		}

		if (so.getStyle() != null) {
			po.setStyle(so.getStyle());
		}

		if (so.getAsk() != null) {
			po.setAsk(so.getAsk());
		}

	}

	@Override
	public void deleteById(Serializable id) {
		Session session = getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		// 删除附件
		String hql = "delete from Accessory where sort=:sort and dataId=:dataId";
		Query query = session.createQuery(hql);
		query.setParameter("sort", OrderState.XSGL_BJGL);
		query.setParameter("dataId", id);
		query.executeUpdate();

		// 删除明细
		hql = "delete from ProductPriceList where order.id=:orderId";
		query = session.createQuery(hql);
		query.setParameter("orderId", id);
		query.executeUpdate();

		// 删除审核信息
		hql = "delete from AuditMind where sort=:sort and dataId=:dataId";
		query = session.createQuery(hql);
		query.setParameter("sort", OrderState.XSGL_BJGL);
		query.setParameter("dataId", id);
		query.executeUpdate();

		// 删除订单
		hql = "delete from ProductPrice where id=:id";
		query = session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();

		transaction.commit();
	}

	public void deleteDetails(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String hql = "delete from ProductPriceList where order.id=:orderId";
		Query query = session.createQuery(hql);
		query.setParameter("orderId", id);
		query.executeUpdate();
		transaction.commit();
	}
}
