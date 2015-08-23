package cn.com.kington.dao.sell;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.sell.SellOrder;
import cn.com.kington.bean.sell.SellOrderSO;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 销售项目订单操作接口实现类
 * @author 杜永生
 *
 */
public class SellOrderDAOImpl extends BaseDAOImpl<SellOrder, SellOrderSO> implements SellOrderDAO {

	@Override
	public String getHqlWhere(SellOrderSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, SellOrderSO so) {
		if(so.getSort()!=null){
			criteria.add(Restrictions.eq("sort", so.getSort()));
		}
		
		if(so.getClientId()!=null){
			criteria.add(Restrictions.eq("clientId", so.getClientId()));
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.eq("code", StringUtils.trim(so.getCode())));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.like("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		
		if(so.getGrade()!=null){
			criteria.add(Restrictions.eq("grade", so.getGrade()));
		}
		
		if(so.getAudit()!=null){
			criteria.add(Restrictions.eq("audit",so.getAudit()));
		}
		
		if(so.getMake()!=null){
			criteria.add(Restrictions.eq("make",so.getMake()));
		}
	}

	@Override
	public void setQueryParams(Query query, SellOrderSO so) {
		
	}

	@Override
	public void switchVO2PO(SellOrder po, SellOrderSO so) {
		if(so.getClientId()!=null){
			po.setClientId(so.getClientId());
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getLinkman())){
			po.setLinkman(StringUtils.trim(so.getLinkman()));
		}
		
		if(StringUtils.isNotEmpty(so.getFax())){
			po.setFax(StringUtils.trim(so.getFax()));
		}
		
		if(StringUtils.isNotEmpty(so.getPhone())){
			po.setPhone(StringUtils.trim(so.getPhone()));
		}
		
		if(StringUtils.isNotEmpty(so.getTel())){
			po.setTel(StringUtils.trim(so.getTel()));
		}
		
		if(StringUtils.isNotEmpty(so.getMobile())){
			po.setMobile(StringUtils.trim(so.getMobile()));
		}
		
		if(StringUtils.isNotEmpty(so.getAddress())){
			po.setAddress(StringUtils.trim(so.getAddress()));
		}
		
		if(StringUtils.isNotEmpty(so.getPostcode())){
			po.setPostcode(StringUtils.trim(so.getPostcode()));
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(so.getTotal()!=null){
			po.setTotal(so.getTotal());
		}
		
		if(so.getPayment()!=null){
			po.setPayment(so.getPayment());
		}
		
		if(so.getPayfor()!=null){
			po.setPayfor(so.getPayfor());
		}
		
		if(so.getNopay()!=null){
			po.setNopay(so.getNopay());
		}
		
		if(so.getAddId()!=null){
			po.setAddId(so.getAddId());
		}
		
		if(StringUtils.isNotEmpty(so.getAddName())){
			po.setAddName(StringUtils.trim(so.getAddName()));
		}
		
		if(StringUtils.isNotEmpty(so.getAddDate())){
			po.setAddDate(StringUtils.trim(so.getAddDate()));
		}
		
		if(so.getAudit()!=null){
			po.setAudit(so.getAudit());
		}
		
		if(so.getGrade()!=null){
			po.setGrade(so.getGrade());
		}
		
		if(so.getSort()!=null){
			po.setSort(so.getSort());
		}
		
		if(StringUtils.isNotEmpty(so.getDeliver())){
			po.setDeliver(StringUtils.trim(so.getDeliver()));
		}
		
		if(so.getMake()!=null){
			po.setMake(so.getMake());
		}
	}
	
	@Override
	public void deleteById(Serializable id){
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		
		//删除附件
		String hql="delete from Accessory where sort=:sort and dataId=:dataId";
		Query query=session.createQuery(hql);
		query.setParameter("sort", OrderState.XSGL);
		query.setParameter("dataId", id);
		query.executeUpdate();
		
		//删除明细
		hql="delete from SellOrderList where order.id=:orderId";
		query=session.createQuery(hql);
		query.setParameter("orderId", id);
		query.executeUpdate();
		
		//删除审核信息
		hql="delete from AuditMind where sort=:sort and dataId=:dataId";
		query=session.createQuery(hql);
		query.setParameter("sort", OrderState.XSGL_XMGL);
		query.setParameter("dataId", id);
		query.executeUpdate();
		
		//删除订单
		hql="delete from SellOrder where id=:id";
		query=session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		
		transaction.commit();
	}
	
	public void deleteDetails(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		String hql = "delete from SellOrderList where order.id=:orderId";
		Query query = session.createQuery(hql);
		query.setParameter("orderId", id);
		query.executeUpdate();
		transaction.commit();
	}
}
