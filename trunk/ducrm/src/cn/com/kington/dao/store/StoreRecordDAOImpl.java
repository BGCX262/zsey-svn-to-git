package cn.com.kington.dao.store;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.store.StoreRecord;
import cn.com.kington.bean.store.StoreRecordSO;
import cn.com.kington.dao.BaseDAOImpl;

public class StoreRecordDAOImpl extends BaseDAOImpl<StoreRecord, StoreRecordSO> implements StoreRecordDAO {

	@Override
	public void switchVO2PO(StoreRecord po, StoreRecordSO so) {
		if(so.getStoreId()!=null){
			po.setStoreId(so.getStoreId());
		}
		
		if(so.getAddId()!=null){
			po.setAddId(so.getAddId());
		}
		
		if(so.getSort()!=null){
			po.setSort(so.getSort());
		}
		
		if(so.getAmount()!=null){
			po.setAmount(so.getAmount());
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getStoreName())){
			po.setName(StringUtils.trim(so.getStoreName()));
		}
		
		if(StringUtils.isNotEmpty(so.getAddName())){
			po.setAddName(StringUtils.trim(so.getAddName()));
		}
	}

	@Override
	public void setCriteriaParams(Criteria criteria, StoreRecordSO so) {
		if(so.getStoreId()!=null){
			criteria.add(Restrictions.eq("storeId", so.getStoreId()));
		}
		
		if(so.getSort()!=null){
			criteria.add(Restrictions.eq("sort", so.getSort()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.ilike("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
	}

	@Override
	public void setQueryParams(Query query, StoreRecordSO so) {
		
	}

	@Override
	public String getHqlWhere(StoreRecordSO so) {
		return null;
	}

	
}
