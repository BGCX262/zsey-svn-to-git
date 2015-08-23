package cn.com.kington.dao.basic;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Department;
import cn.com.kington.bean.basic.DepartmentSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 部门DepartmentDAO操作接口实现灰
 * @author 杜永生
 *
 */
public class DepartmentDAOImpl extends BaseDAOImpl<Department, DepartmentSO> implements
		DepartmentDAO {

	@Override
	public void switchVO2PO(Department po, DepartmentSO so) {
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(so.getDepartment()!=null && so.getDepartment().getId()!=null){
			Department department=findById(Department.class, so.getDepartment().getId());
			po.setDepartment(department);
		}
		
		if(so.getManagerId()!=null){
			po.setManagerId(so.getManagerId());
		}
		
		if(StringUtils.isNotEmpty(so.getManager())){
			po.setManager(StringUtils.trim(so.getManager()));
		}
		
		if(StringUtils.isNotEmpty(so.getPhone())){
			po.setPhone(StringUtils.trim(so.getPhone()));
		}
		
		if(StringUtils.isNotEmpty(so.getFax())){
			po.setFax(StringUtils.trim(so.getFax()));
		}
		
	}

	@Override
	public void setCriteriaParams(Criteria criteria, DepartmentSO so) {
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.ilike("code", StringUtils.trim(so.getCode())+"%"));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.ilike("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
	}

	@Override
	public void setQueryParams(Query query, DepartmentSO so) {
		
	}

	@Override
	public String getHqlWhere(DepartmentSO so) {
		return null;
	}


}
