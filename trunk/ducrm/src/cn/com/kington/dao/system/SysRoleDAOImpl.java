package cn.com.kington.dao.system;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.system.SysRole;
import cn.com.kington.bean.system.SysRoleSO;
import cn.com.kington.dao.BaseDAOImpl;

public class SysRoleDAOImpl extends BaseDAOImpl<SysRole, SysRoleSO> implements SysRoleDAO {

	@Override
	public String getHqlWhere(SysRoleSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, SysRoleSO so) {
		if(so.getFlag()!=null){
			criteria.add(Restrictions.eq("flag", so.getFlag()));
		}
		
		if(so.getStatus()!=null){
			criteria.add(Restrictions.eq("status", so.getStatus()));
		}
		
		if(so.getId()!=null){
			criteria.add(Restrictions.or(Restrictions.ge("id", so.getId()+1L), Restrictions.le("id", so.getId()-1L)));
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.eq("code", so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.like("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
	}

	@Override
	public void setQueryParams(Query query, SysRoleSO so) {
		
	}

	@Override
	public void switchVO2PO(SysRole po, SysRoleSO so) {
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getCode().toUpperCase())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getCaption())){
			po.setCaption(StringUtils.trim(so.getCaption()));
		}
	}

	public boolean checkCode(SysRoleSO so) {
		int count=getCount(so);
		if(count>0){
			return true;
		}
		return false;
	}

	public void delete(Long id) {
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		transaction.begin();
		
		//删除角色与系统功能的关系
		String hql="delete from SysRoleMenu where role.id=:roleId";
		Query query=session.createQuery(hql);
		query.setParameter("roleId", id);
		query.executeUpdate();
		
		//删除角色与用户的关系
		hql="delete from SysRoleUser where role.id=:roleId";
		query=session.createQuery(hql);
		query.setParameter("roleId", id);
		query.executeUpdate();
		
		//删除角色
		hql="delete from SysRole where id=:id";
		query=session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		
		transaction.commit();
	}

	

}
