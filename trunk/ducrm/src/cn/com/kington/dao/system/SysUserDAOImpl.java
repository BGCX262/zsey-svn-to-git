package cn.com.kington.dao.system;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.model.Employee;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.bean.system.SysUserSO;
import cn.com.kington.common.MD5;
import cn.com.kington.dao.BaseDAOImpl;

public class SysUserDAOImpl extends BaseDAOImpl<SysUser, SysUserSO> implements SysUserDAO {
	@Override
	public String getHqlWhere(SysUserSO so) {
		StringBuffer where=new StringBuffer();
		
		if(so.getId()!=null){
			where.append(" and (so.id>=:id1 or so.id<=:id2)");
		}
		
		if(so.getFlag()!=null){
			where.append(" and so.flag=:flag");
		}
		
		if(so.getStatus()!=null){
			where.append(" and so.status=:status");
		}
		
		if(StringUtils.isNotEmpty(so.getUsername())){
			where.append(" and so.username=:username");
		}
		
		if(so.getEmployee()!=null){
			if(so.getEmployee().getId()!=null){
				where.append(" and so.employee.id=:employeeId");
			}
			
			if(StringUtils.isNotEmpty(so.getEmployee().getCode())){
				where.append(" and so.employee.code=:employeeCode");
			}
			
			if(StringUtils.isNotEmpty(so.getEmployee().getName())){
				where.append(" and so.employee.name like :employeeName");
			}
			
			if(so.getEmployee().getDepartment()!=null){
				if(so.getEmployee().getDepartment().getId()!=null){
					where.append(" and so.employee.department.id=:departmentId");
				}
			}
		}
		
		return where.toString();
	}

	@Override
	public void setCriteriaParams(Criteria criteria, SysUserSO so) {
		if(so.getId()!=null){
			criteria.add(Restrictions.or(Restrictions.le("id", so.getId()-1L), Restrictions.ge("id", so.getId()+1L)));
		}
		
		if(so.getFlag()!=null){
			criteria.add(Restrictions.eq("flag", so.getFlag()));
		}
		
		if(so.getStatus()!=null){
			criteria.add(Restrictions.eq("status", so.getStatus()));
		}
		
		if(StringUtils.isNotEmpty(so.getUsername())){
			criteria.add(Restrictions.eq("username", StringUtils.trim(so.getUsername())));
		}
		
		if(StringUtils.isNotEmpty(so.getPassword())){
			criteria.add(Restrictions.eq("password", StringUtils.trim(so.getPassword())));
		}
		
		if(so.getEmployee()!=null){
			criteria.createAlias("employee", "emp");
			
			if(so.getEmployee().getId()!=null){
				criteria.add(Restrictions.eq("emp.id", so.getEmployee().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getEmployee().getCode())){
				criteria.add(Restrictions.eq("emp.code", StringUtils.trim(so.getEmployee().getCode())));
			}
			
			if(StringUtils.isNotEmpty(so.getEmployee().getName())){
				criteria.add(Restrictions.ilike("emp.name", "%"+StringUtils.trim(so.getEmployee().getName())+"%"));
			}
			
			if(so.getEmployee().getDepartment()!=null){
				criteria.createAlias("emp.department", "dep");
				
				if(so.getEmployee().getDepartment().getId()!=null){
					criteria.add(Restrictions.eq("dep.id", so.getEmployee().getDepartment().getId()));
				}
			}
		}
	}

	@Override
	public void setQueryParams(Query query, SysUserSO so) {
		if(so.getId()!=null){
			query.setParameter("id1", so.getId()+1);
			query.setParameter("id2", so.getId()-1);
		}
		
		if(so.getFlag()!=null){
			query.setParameter("flag", so.getFlag());
		}
		
		if(so.getStatus()!=null){
			query.setParameter("status", so.getStatus());
		}
		
		if(StringUtils.isNotEmpty(so.getUsername())){
			query.setParameter("username", so.getUsername());
		}
		
		if(so.getEmployee()!=null){
			if(so.getEmployee().getId()!=null){
				query.setParameter("employeeId", so.getEmployee().getId());
			}
			
			if(StringUtils.isNotEmpty(so.getEmployee().getCode())){
				query.setParameter("employeeCode", so.getEmployee().getCode());
			}
			
			if(StringUtils.isNotEmpty(so.getEmployee().getName())){
				query.setParameter("employeeName", "%"+StringUtils.trim(so.getEmployee().getName())+"%");
			}
			
			if(so.getEmployee().getDepartment()!=null){
				if(so.getEmployee().getDepartment().getId()!=null){
					query.setParameter("departmentId", so.getEmployee().getDepartment().getId());
				}
			}
		}
	}

	@Override
	public void switchVO2PO(SysUser po, SysUserSO so) {
		if(StringUtils.isNotEmpty(so.getUsername())){
			po.setUsername(StringUtils.trim(so.getUsername()).toUpperCase());
		}
		
		if(StringUtils.isNotEmpty(so.getPassword())){
			MD5 md5=new MD5();
			String pwd=md5.getMD5ofStr(StringUtils.trim(so.getPassword()));
			po.setPassword(pwd);
		}
		
		if(so.getEmployee()!=null && so.getEmployee().getId()!=null){
			Employee employee=findById(Employee.class, so.getEmployee().getId());
			po.setEmployee(employee);
		}
	}

	@SuppressWarnings("unchecked")
	public SysUser checkUser(SysUserSO so) {
		Session session=getSessionFactory().getCurrentSession();
		Criteria criteria=session.createCriteria(SysUser.class);
		criteria.setFetchMode("employee", FetchMode.JOIN);//关联集合
		setCriteriaParams(criteria, so);
		
		List<SysUser> list=criteria.list();
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public void delete(Long id) {
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		
		//删除角色与用户的关系
		String hql="delete from SysRoleUser where user.id=:userId";
		Query query=session.createQuery(hql);
		query.setParameter("userId", id);
		query.executeUpdate();
		
		//删除角色
		hql="delete from SysUser where id=:id";
		query=session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
		
	}
}
