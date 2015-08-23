package cn.com.kington.dao.system;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.system.SysRole;
import cn.com.kington.bean.system.SysRoleUser;
import cn.com.kington.bean.system.SysRoleUserSO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 系统用户写系统角色的关系DAO操作接口实现类
 * @author 杜永生
 *
 */
public class SysRoleUserDAOImpl extends BaseDAOImpl<SysRoleUser, SysRoleUserSO> implements SysRoleUserDAO {

	@Override
	public String getHqlWhere(SysRoleUserSO so) {
		StringBuffer hql=new StringBuffer();
		if(so.getRole()!=null && so.getRole().getId()!=null){
			hql.append(" and role.id=:roleId");
		}
		
		if(so.getUser()!=null && so.getUser().getId()!=null){
			hql.append(" and user.id=:userId");
		}
		return hql.toString();
	}

	@Override
	public void setCriteriaParams(Criteria criteria, SysRoleUserSO so) {
		if(so.getFlag()!=null){
			criteria.add(Restrictions.eq("flag", so.getFlag()));
		}
		
		if(so.getStatus()!=null){
			criteria.add(Restrictions.eq("status", so.getStatus()));
		}
		
		if(so.getRole()!=null && so.getRole().getId()!=null){
			criteria.add(Restrictions.eq("role.id", so.getRole().getId()));
		}
		
		if(so.getUser()!=null && so.getUser().getId()!=null){
			criteria.add(Restrictions.eq("user.id", so.getUser().getId()));
		}
		
	}

	@Override
	public void setQueryParams(Query query, SysRoleUserSO so) {
		if(so.getRole()!=null && so.getRole().getId()!=null){
			query.setParameter("roleId", so.getRole().getId());
		}
		
		if(so.getUser()!=null && so.getUser().getId()!=null){
			query.setParameter("userId", so.getUser().getId());
		}
		
	}

	@Override
	public void switchVO2PO(SysRoleUser po, SysRoleUserSO so) {
		if(so.getRole()!=null && so.getRole().getId()!=null){
			SysRole role=findById(SysRole.class, so.getRole().getId());
			po.setRole(role);
		}
		
		if(so.getUser()!=null && so.getUser().getId()!=null){
			SysUser user=findById(SysUser.class, so.getUser().getId());
			po.setUser(user);
		}
	}

	public void delete(SysRoleUserSO so) {
		StringBuffer hql=new StringBuffer();
		hql.append("delete from SysRoleUser where 1=1"+getHqlWhere(so));
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query=session.createQuery(hql.toString());
		query.executeUpdate();
	}

}
