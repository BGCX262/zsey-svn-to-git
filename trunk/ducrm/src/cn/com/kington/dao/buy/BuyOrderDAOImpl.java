package cn.com.kington.dao.buy;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.kington.bean.buy.BuyOrder;
import cn.com.kington.bean.buy.BuyOrderSO;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * ���ϲɹ�����BuyOrderDAO�����ӿ�ʵ����
 * @author ������
 *
 */
public class BuyOrderDAOImpl extends BaseDAOImpl<BuyOrder, BuyOrderSO>
		implements BuyOrderDAO {

	@Override
	public String getHqlWhere(BuyOrderSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, BuyOrderSO so) {
	}

	@Override
	public void setQueryParams(Query query, BuyOrderSO so) {

	}

	@Override
	public void switchVO2PO(BuyOrder po, BuyOrderSO so) {
	}
	
	public void deleteById(Serializable id){
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		
		//ɾ���ɹ�ѯ����ϸ
		String hql="delete from BuyOrderList where order.id=:orderId";
		Query query=session.createQuery(hql);
		query.setParameter("orderId", id);
		query.executeUpdate();

		//ɾ������
		hql="delete from Accessory where sort=:sort and dataId=:dataId";
		query=session.createQuery(hql);
		query.setParameter("sort", OrderState.CGGL_WLCG);
		query.setParameter("dataId", id);
		query.executeUpdate();
		
		//��˼�¼
		hql="delete from AuditMind where sort=:sort and dataId=:dataId";
		query=session.createQuery(hql);
		query.setParameter("sort", OrderState.CGGL_WLCG);
		query.setParameter("dataId", id);
		query.executeUpdate();
		
		//ɾ�����ϲɹ���
		hql="delete from BuyOrder where id=:id";
		query=session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		
		transaction.commit();
	}
	
	public void deleteList(BuyOrderSO so){
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		
		//ɾ���ɹ�ѯ����ϸ
		String hql="delete from BuyOrderList where order.id=:orderId";
		Query query=session.createQuery(hql);
		query.setParameter("orderId", so.getId());
		query.executeUpdate();

		transaction.commit();
	}
	

}
