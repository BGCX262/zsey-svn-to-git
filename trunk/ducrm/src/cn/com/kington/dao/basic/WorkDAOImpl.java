package cn.com.kington.dao.basic;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Work;
import cn.com.kington.bean.basic.WorkSO;
import cn.com.kington.dao.BaseDAOImpl;

public class WorkDAOImpl extends BaseDAOImpl<Work, WorkSO> implements WorkDAO {

	@Override
	public String getHqlWhere(WorkSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, WorkSO so) {
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.eq("code",StringUtils.trim(so.getCode())));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.ilike("name","%"+StringUtils.trim(so.getName())+"%"));
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
		
	}

	@Override
	public void setQueryParams(Query query, WorkSO so) {
		
	}

	@Override
	public void switchVO2PO(Work po, WorkSO so) {
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getRemark())){
			po.setRemark(StringUtils.trim(so.getRemark()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(so.getPrice()!=null){
			po.setPrice(so.getPrice());
		}
		
		if(so.getFlag()!=null){
			po.setFlag(so.getFlag());
		}
		
		if(so.getStatus()!=null){
			po.setStatus(so.getStatus());
		}
		
	}
}
