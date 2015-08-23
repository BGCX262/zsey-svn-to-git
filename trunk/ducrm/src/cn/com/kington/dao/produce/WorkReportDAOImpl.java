package cn.com.kington.dao.produce;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Product;
import cn.com.kington.bean.model.Employee;
import cn.com.kington.bean.produce.WorkReport;
import cn.com.kington.bean.produce.WorkReportSO;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 工作报告WorkReportDAO接任接口实现类
 * @author 杜永生
 *
 */
public class WorkReportDAOImpl extends BaseDAOImpl<WorkReport, WorkReportSO>
		implements WorkReportDAO {

	@Override
	public void switchVO2PO(WorkReport po, WorkReportSO so) {
		if(so.getEmployee()!=null && so.getEmployee().getId()!=null){
			Employee employee=findById(Employee.class, so.getEmployee().getId());
			po.setEmployee(employee);
		}
		
		if(so.getProduct()!=null && so.getProduct().getId()!=null){
			Product product=findById(Product.class, so.getProduct().getId());
			po.setProduct(product);
		}
		
		if(so.getWorkId()!=null){
			po.setWorkId(so.getWorkId());
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(so.getAmount()!=null){
			po.setAmount(so.getAmount());
		}
		
		if(so.getPrice()!=null){
			po.setPrice(so.getPrice());
		}
		
		if(so.getTotal()!=null){
			po.setTotal(so.getTotal());
		}
		
		if(StringUtils.isNotEmpty(so.getAddDate())){
			po.setAddDate(StringUtils.trim(so.getAddDate()));
		}
		
		if(so.getState()!=null){
			po.setState(so.getState());
		}
	}

	@Override
	public void setCriteriaParams(Criteria criteria, WorkReportSO so) {
		if(so.getEmployee()!=null){
			criteria.createAlias("employee", "e");
			
			if(so.getEmployee().getId()!=null){
				criteria.add(Restrictions.eq("e.id", so.getEmployee().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getEmployee().getCode())){
				criteria.add(Restrictions.eq("e.code", StringUtils.trim(so.getEmployee().getCode())));
			}
			
			if(StringUtils.isNotEmpty(so.getEmployee().getName())){
				criteria.add(Restrictions.ilike("e.name", "%"+StringUtils.trim(so.getEmployee().getName())+"%"));
			}
		}
		
		if(so.getProduct()!=null){
			criteria.createAlias("product", "p");
			
			if(so.getProduct().getId()!=null){
				criteria.add(Restrictions.eq("p.id", so.getProduct().getId()));
			}
			
			if(StringUtils.isNotEmpty(so.getProduct().getCode())){
				criteria.add(Restrictions.eq("p.code", StringUtils.trim(so.getProduct().getCode())));
			}
			
			if(StringUtils.isNotEmpty(so.getProduct().getName())){
				criteria.add(Restrictions.ilike("p.name", "%"+StringUtils.trim(so.getProduct().getName())+"%"));
			}
		}
		
		if(so.getWorkId()!=null){
			criteria.add(Restrictions.eq("workId", so.getWorkId()));
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.eq("code", StringUtils.trim(so.getCode())));;
		}
		
		if(so.getState()!=null){
			criteria.add(Restrictions.eq("state", so.getState()));
		}
		
		if(StringUtils.isNotEmpty(so.getStartTime())){
			criteria.add(Restrictions.ge("addDate", StringUtils.trim(so.getStartTime())));;
		}
		
		if(StringUtils.isNotEmpty(so.getEndTime())){
			criteria.add(Restrictions.le("addDate", StringUtils.trim(so.getEndTime())));;
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
		
	}

	@Override
	public void setQueryParams(Query query, WorkReportSO so) {
		
	}

	@Override
	public String getHqlWhere(WorkReportSO so) {
		return null;
	}


}
