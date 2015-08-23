package cn.com.kington.dao.system;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.system.SysDict;
import cn.com.kington.bean.system.SysDictSO;
import cn.com.kington.dao.BaseDAOImpl;

public class SysDictDAOImpl extends BaseDAOImpl<SysDict, SysDictSO> implements SysDictDAO {

	@Override
	public void switchVO2PO(SysDict po, SysDictSO so) {
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(so.getSort()!=null){
			po.setSort(so.getSort());
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getCaption())){
			po.setCaption(StringUtils.trim(so.getCaption()));
		}
	}

	@Override
	public void setCriteriaParams(Criteria criteria, SysDictSO so) {
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.eq("code", StringUtils.trim(so.getCode())));
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
	public void setQueryParams(Query query, SysDictSO so) {
		
	}

	@Override
	public String getHqlWhere(SysDictSO so) {
		return null;
	}


}
