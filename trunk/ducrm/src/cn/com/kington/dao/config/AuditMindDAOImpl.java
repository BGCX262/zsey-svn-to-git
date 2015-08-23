package cn.com.kington.dao.config;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.config.AuditMind;
import cn.com.kington.bean.config.AuditMindSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * ������DAO�����ӿ�ʵ����
 * @author ������
 *
 */
public class AuditMindDAOImpl extends BaseDAOImpl<AuditMind, AuditMindSO> implements AuditMindDAO {

	@Override
	public String getHqlWhere(AuditMindSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, AuditMindSO so) {
		criteria.add(Restrictions.eq("dataId", so.getDataId()));
		criteria.add(Restrictions.eq("sort", so.getSort()));
	}

	@Override
	public void setQueryParams(Query query, AuditMindSO so) {
		
	}

	@Override
	public void switchVO2PO(AuditMind po, AuditMindSO so) {
		po.setDataId(so.getDataId());
		po.setSort(so.getSort());
		po.setMind(StringUtils.trim(so.getMind()));
		po.setRealname(StringUtils.trim(so.getRealname()));
		po.setState(so.getState());
		po.setAuditDate(StringUtils.trim(so.getAuditDate()));
	}


}
