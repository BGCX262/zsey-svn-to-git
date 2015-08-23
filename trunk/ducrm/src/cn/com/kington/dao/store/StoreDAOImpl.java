package cn.com.kington.dao.store;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.store.Store;
import cn.com.kington.bean.store.StoreSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 仓库StoreDAO操作接口实现类
 * @author 杜永生
 *
 */
public class StoreDAOImpl extends BaseDAOImpl<Store, StoreSO> implements StoreDAO {

	@Override
	public void switchVO2PO(Store po, StoreSO so) {
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
	}

	@Override
	public void setCriteriaParams(Criteria criteria, StoreSO so) {
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.ilike("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
	}
	
	public <T> void deleteById(Serializable id){
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		String hql="delete from Store where id=:id";
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		transaction.commit();
	}

	@Override
	public void setQueryParams(Query query, StoreSO so) {
	}

	@Override
	public String getHqlWhere(StoreSO so) {
		return null;
	}

	

}
