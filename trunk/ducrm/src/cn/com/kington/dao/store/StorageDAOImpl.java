package cn.com.kington.dao.store;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.store.Storage;
import cn.com.kington.bean.store.StorageSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 库存StorageDAO操作接口实现类
 * @author 杜永生
 *
 */
public class StorageDAOImpl extends BaseDAOImpl<Storage, StorageSO> implements StorageDAO {

	@Override
	public void switchVO2PO(Storage po, StorageSO so) {
		if(so.getStoreId()!=null){
			po.setStoreId(so.getStoreId());
		}
		
		if(so.getSort()!=null){
			po.setSort(so.getSort());
		}
		
		if(so.getDataId()!=null){
			po.setDataId(so.getDataId());
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getSize())){
			po.setSize(StringUtils.trim(so.getSize().toUpperCase()));
		}
		
		if(so.getAmount()!=null){
			po.setAmount(so.getAmount());
		}
		
		if(so.getDown()!=null){
			po.setDown(so.getDown());
		}
		
		if(so.getUp()!=null){
			po.setUp(so.getUp());
		}
		
		if(so.getState()!=null){
			po.setState(so.getState());
		}
		
	}

	@Override
	public void setCriteriaParams(Criteria criteria, StorageSO so) {
		if(so.getStoreId()!=null){
			criteria.add(Restrictions.eq("storeId", so.getStoreId()));
		}
		
		if(so.getSort()!=null){
			criteria.add(Restrictions.eq("sort", so.getSort()));
			
			if(StringUtils.isNotEmpty(so.getSize())){
				criteria.add(Restrictions.eq("size", StringUtils.trim(so.getSize().toUpperCase())));
			}else{
				criteria.add(Restrictions.isNull("size"));
			}
		}
		
		if(so.getDataId()!=null){
			criteria.add(Restrictions.eq("dataId", so.getDataId()));
		}
		
		if(so.getState()!=null){
			criteria.add(Restrictions.eq("state", so.getState()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.ilike("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		
		if(so.getUp()!=null){
			criteria.add(Restrictions.ge("up", so.getUp()));
		}
		
		if(so.getDown()!=null){
			criteria.add(Restrictions.le("down", so.getDown()));
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
		
	}

	@Override
	public void setQueryParams(Query query, StorageSO so) {
		
	}

	@Override
	public String getHqlWhere(StorageSO so) {
		return null;
	}
}
