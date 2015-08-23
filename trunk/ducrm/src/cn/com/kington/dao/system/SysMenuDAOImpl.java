package cn.com.kington.dao.system;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.system.SysMenu;
import cn.com.kington.bean.system.SysMenuSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 系统功能菜单DAO操作接口实现类
 * @author 杜永生
 *
 */
public class SysMenuDAOImpl extends BaseDAOImpl<SysMenu, SysMenuSO> implements SysMenuDAO {

	@Override
	public String getHqlWhere(SysMenuSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, SysMenuSO so) {
		if(so.getId()!=null){
			criteria.add(Restrictions.or(Restrictions.ge("id", so.getId()+1L), Restrictions.le("id", so.getId()-1L)));
		}
		
		if(StringUtils.isNotEmpty(so.getEnName())){
			criteria.add(Restrictions.ilike("enName", StringUtils.trim(so.getEnName())));
		}
		
		if(StringUtils.isNotEmpty(so.getChName())){
			criteria.add(Restrictions.ilike("chName", "%"+StringUtils.trim(so.getChName())+"%"));
		}
		
		if(so.getParentMenu()!=null && so.getParentMenu().getId()!=null){
			criteria.add(Restrictions.eq("parentMenu.id", so.getParentMenu().getId()));
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
	}

	@Override
	public void setQueryParams(Query query, SysMenuSO so) {
		
	}

	@Override
	public void switchVO2PO(SysMenu po, SysMenuSO so) {
		if(StringUtils.isNotEmpty(so.getEnName())){
			po.setEnName(StringUtils.trim(so.getEnName()).toUpperCase());
		}
		
		if(StringUtils.isNotEmpty(so.getChName())){
			po.setChName(StringUtils.trim(so.getChName()));
		}
		
		if(StringUtils.isNotEmpty(so.getHref())){
			po.setHref(StringUtils.trim(so.getHref()));
		}
		
		if(so.getParentMenu()!=null && so.getParentMenu().getId()!=null){
			SysMenu pm=findById(so.getParentMenu().getId());
			po.setParentMenu(pm);
		}
		
		po.setSort(so.getSort());
	}

	public boolean checkEnName(SysMenuSO so) {
		int count=getCount(so);
		if(count>0){
			return true;
		}
		return false;
	}
	
	public <T> void deleteById(Serializable id){
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		
		//删除授权的菜单
		String sql="delete from sys_role_menu where EXISTS (select id from sys_menu m where m.id=fk_menu_id and (m.parentId=:id1 or m.id=:id2))";
		Query query=session.createSQLQuery(sql);
		query.setParameter("id1", id);
		query.setParameter("id2", id);
		query.executeUpdate();
		
		//删除所属菜单
		sql="delete from sys_menu where parentId=:id";
		query=session.createSQLQuery(sql);
		query.setParameter("id", id);
		query.executeUpdate();
		
		//删除菜单
		sql="delete from sys_menu where id=:id";
		query=session.createSQLQuery(sql);
		query.setParameter("id", id);
		query.executeUpdate();
		
		transaction.commit();
	}

}
