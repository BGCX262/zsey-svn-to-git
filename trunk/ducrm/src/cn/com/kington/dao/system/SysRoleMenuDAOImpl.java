package cn.com.kington.dao.system;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.system.SysMenu;
import cn.com.kington.bean.system.SysRole;
import cn.com.kington.bean.system.SysRoleMenu;
import cn.com.kington.bean.system.SysRoleMenuSO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 角色与系统功能菜单的关系操作接口实现类
 * @author 杜永生
 *
 */
public class SysRoleMenuDAOImpl extends BaseDAOImpl<SysRoleMenu ,SysRoleMenuSO> implements SysRoleMenuDAO {

	@Override
	public String getHqlWhere(SysRoleMenuSO so) {
		StringBuffer where=new StringBuffer();
		
		if(so.getFlag()!=null){
			where.append(" and flag=:flag");
		}
		
		if(so.getStatus()!=null){
			where.append(" and status=:status");
		}
		
		if(so.getRole()!=null && so.getRole().getId()!=null){
			where.append(" and role.id=:roleId");
		}
		
		if(so.getMenu()!=null && so.getMenu().getId()!=null){
			where.append(" and menu.id=:menuId");
		}
		return where.toString();
	}

	@Override
	public void setCriteriaParams(Criteria criteria, SysRoleMenuSO so) {
		if(so.getFlag()!=null){
			criteria.add(Restrictions.eq("flag", so.getFlag()));
		}
		
		if(so.getStatus()!=null){
			criteria.add(Restrictions.eq("status", so.getStatus()));
		}
		
		if(so.getRole()!=null && so.getRole().getId()!=null){
			criteria.add(Restrictions.eq("role.id", so.getRole().getId()));
		}
		
		if(so.getMenu()!=null && so.getMenu().getId()!=null){
			criteria.add(Restrictions.eq("menu.id", so.getMenu().getId()));
		}
	}

	@Override
	public void setQueryParams(Query query, SysRoleMenuSO so) {
		if(so.getFlag()!=null){
			query.setParameter("flag", so.getFlag());
		}
		
		if(so.getStatus()!=null){
			query.setParameter("status", so.getStatus());
		}
		
		if(so.getRole()!=null && so.getRole().getId()!=null){
			query.setParameter("roleId", so.getRole().getId());
		}
		
		if(so.getMenu()!=null && so.getMenu().getId()!=null){
			query.setParameter("menuId", so.getMenu().getId());
		}
		
	}

	@Override
	public void switchVO2PO(SysRoleMenu po, SysRoleMenuSO so) {
		if(so.getMenu()!=null && so.getMenu().getId()!=null){
			SysMenu menu=findById(SysMenu.class,so.getMenu().getId());
			po.setMenu(menu);
		}
		
		if(so.getRole()!=null && so.getRole().getId()!=null){
			SysRole role=findById(SysRole.class, so.getRole().getId());
			po.setRole(role);
		}
	}

	public void delete(SysRoleMenuSO so) {
		String hql="delete from SysRoleMenu where 1=1"+getHqlWhere(so);
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query=session.createQuery(hql);
		setQueryParams(query, so);
		query.executeUpdate();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<SysMenu> findMenuByUser(SysUser user){
		if(user!=null){
			StringBuffer sql=new StringBuffer();
			sql.append("select id, chName, enName, href, parentId from sys_menu m ");
			sql.append("where exists(select distinct fk_menu_id from sys_role_menu rm ");
			sql.append("where exists(select distinct fk_role_id from sys_role_user ru ");
			sql.append("where ru.fk_role_id=rm.fk_role_id and ru.fk_user_id=:fkUserId) ");
			sql.append("and m.id= rm.fk_menu_id) order by m.sort asc,m.id asc");
			Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
			Query query=session.createSQLQuery(sql.toString());
			query.setParameter("fkUserId", user.getId());
			List<Object[]> list=query.list();
			if(list!=null && list.size()>0){
				List<SysMenu> menuList=new ArrayList<SysMenu>();
				for (Iterator<Object[]> iterator = list.iterator(); iterator.hasNext();) {
					Object[] objs = iterator.next();
					SysMenu menu=new SysMenu();
					menu.setId(((BigInteger)objs[0]).longValue());
					menu.setEnName((String)objs[2]);
					menu.setChName((String)objs[1]);
					if(objs[3]!=null){
						menu.setHref((String)objs[3]);
					}
					if(objs[4]!=null){
						SysMenu pm=new SysMenu();
						pm.setId(((BigInteger)objs[4]).longValue());
						menu.setParentMenu(pm);
					}					
					menuList.add(menu);
				}
				return menuList;
			}
			
		}
		return null;
	}
}