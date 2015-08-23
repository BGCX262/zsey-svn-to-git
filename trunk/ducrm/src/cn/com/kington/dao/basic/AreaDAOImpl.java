package cn.com.kington.dao.basic;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.AreaSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 部门DepartmentDAO操作接口实现灰
 * @author 杜永生
 *
 */
public class AreaDAOImpl extends BaseDAOImpl<Area, AreaSO> implements
		AreaDAO {

	@Override
	public void switchVO2PO(Area po, AreaSO so) {
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(so.getArea()!=null && so.getArea().getId()!=null){
			Area area=findById(Area.class, so.getArea().getId());
			po.setArea(area);
		}
		
		
	}

	@Override
	public void setCriteriaParams(Criteria criteria, AreaSO so) {
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.ilike("code", StringUtils.trim(so.getCode())+"%"));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.ilike("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		
		if(so.getArea()!=null){
			criteria.createAlias("area", "a");
			
			if(so.getArea().getId()!=null){
				criteria.add(Restrictions.eq("a.id", so.getArea().getId()));
			}
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
	}

	@Override
	public void setQueryParams(Query query, AreaSO so) {
		if(so.getArea()!=null && so.getArea().getId()!=null){
			query.setParameter("areaId", so.getArea().getId());
		}
		
	}

	@Override
	public String getHqlWhere(AreaSO so) {
		StringBuffer where=new StringBuffer();
		if(so.getArea()!=null && so.getArea().getId()!=null){
			where.append(" and area.id=:areaId");
		}else{
			where.append(" and area.id is null");
		}
		return where.toString();
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> find(AreaSO so){
		String hql="From Area where flag=true and status=true"+getHqlWhere(so);
		Session session=getSessionFactory().getCurrentSession();
		Query query=session.createQuery(hql);
		setQueryParams(query, so);
		return query.list();
	}


}
