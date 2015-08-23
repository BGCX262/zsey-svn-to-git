package cn.com.kington.dao.basic;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.Department;
import cn.com.kington.bean.model.Employee;
import cn.com.kington.bean.model.EmployeeSO;
import cn.com.kington.bean.system.SysDict;
import cn.com.kington.dao.BaseDAOImpl;

/**
 * 员工EmployeeDAO操作接口实现类
 * @author 杜永生
 *
 */
public class EmployeeDAOImpl extends BaseDAOImpl<Employee, EmployeeSO> implements EmployeeDAO {
	public boolean checkCode(EmployeeSO so) {
		int count=getCount(so);
		if(count>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 根据员工的ID删除<br />
	 * 第一步：删除该员工的系统授权信息<br />
	 * 第二步：删除该员工的系统用户信息<br />
	 * 第三步：删除该员工信息<br />
	 */
	@Override
	public void deleteById(Serializable id){
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		
		//删除该员工的系统授权信息
		String sql="delete from sys_role_user where exists(select distinct u.id from sys_user u where fk_user_id=u.id and u.fk_employee_id=:employeeId)";
		Query query=session.createSQLQuery(sql);
		query.setParameter("employeeId", id);
		query.executeUpdate();
		
		//删除该员工的系统用户信息
		sql="delete from sys_user where fk_employee_id=:employeeId";
		query=session.createSQLQuery(sql);
		query.setParameter("employeeId", id);
		query.executeUpdate();
		
		//删除该员工信息
		sql="delete from base_employee where id=:employeeId";
		query=session.createSQLQuery(sql);
		query.setParameter("employeeId", id);
		query.executeUpdate();
		
		transaction.commit();
	}
	
	@Override
	public String getHqlWhere(EmployeeSO so) {
		return null;
	}

	@Override
	public void setCriteriaParams(Criteria criteria, EmployeeSO so) {
		if(so.getDepartment()!=null){
			criteria.createAlias("department", "dep");
			
			if(so.getDepartment().getId()!=null){
				criteria.add(Restrictions.eq("dep.id", so.getDepartment().getId()));
			}
		}
		
		if(so.getDuty()!=null){
			criteria.createAlias("duty", "dut");
			
			if(so.getDuty().getId()!=null){
				criteria.add(Restrictions.eq("dut.id", so.getDuty().getId()));
			}
		}
		
		if(so.getId()!=null){
			criteria.add(Restrictions.or(Restrictions.ge("id", so.getId()+1L), Restrictions.le("id", so.getId()-1L)));
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			criteria.add(Restrictions.like("name", "%"+StringUtils.trim(so.getName())+"%"));
		}
		
		if(StringUtils.isNotEmpty(so.getIdcard())){
			criteria.add(Restrictions.eq("idcard", StringUtils.trim(so.getIdcard())));
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			criteria.add(Restrictions.eq("code", StringUtils.trim(so.getCode())));
		}
		
		if(so.getSex()!=null){
			criteria.add(Restrictions.eq("sex", so.getSex()));
		}
		
		criteria.add(Restrictions.eq("flag", true));
		criteria.add(Restrictions.eq("status", true));
	}

	@Override
	public void setQueryParams(Query query, EmployeeSO so) {
		
	}

	@Override
	public void switchVO2PO(Employee po, EmployeeSO so) {
		if(so.getDepartment()!=null && so.getDepartment().getId()!=null){
			Department department=findById(Department.class, so.getDepartment().getId());
			po.setDepartment(department);
		}
		
		if(so.getIdtype()!=null && so.getIdtype().getId()!=null){
			SysDict category=findById(SysDict.class, so.getIdtype().getId());
			po.setIdtype(category);
		}
		
		if(so.getDuty()!=null && so.getDuty().getId()!=null){
			SysDict category=findById(SysDict.class, so.getDuty().getId());
			po.setDuty(category);
		}
		
		if(so.getNation()!=null && so.getNation().getId()!=null){
			SysDict category=findById(SysDict.class, so.getNation().getId());
			po.setNation(category);
		}
		
		if(so.getPolity()!=null && so.getPolity().getId()!=null){
			SysDict category=findById(SysDict.class, so.getPolity().getId());
			po.setPolity(category);
		}
		
		if(so.getProvince()!=null && so.getProvince().getId()!=null){
			Area category=findById(Area.class, so.getProvince().getId());
			po.setProvince(category);
		}
		
		if(so.getCity()!=null && so.getCity().getId()!=null){
			Area category=findById(Area.class, so.getCity().getId());
			po.setCity(category);
		}
		
		if(so.getSex()!=null){
			po.setSex(so.getSex());
		}
		
		if(so.getBlood()!=null){
			po.setBlood(so.getBlood());
		}
		
		if(so.getDegree()!=null){
			po.setDegree(so.getDegree());
		}
		
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getIdcard())){
			po.setIdcard(StringUtils.trim(so.getIdcard().toUpperCase()));
		}
		
		if(StringUtils.isNotEmpty(so.getCode())){
			po.setCode(StringUtils.trim(so.getCode()));
		}
		
		if(StringUtils.isNotEmpty(so.getBorn())){
			po.setBorn(StringUtils.trim(so.getBorn()));
		}
		
		if(StringUtils.isNotEmpty(so.getHeight())){
			po.setHeight(StringUtils.trim(so.getHeight()));
		}
		
		if(StringUtils.isNotEmpty(so.getLove())){
			po.setLove(StringUtils.trim(so.getLove()));
		}
		
		if(StringUtils.isNotEmpty(so.getWeight())){
			po.setWeight(StringUtils.trim(so.getWeight()));
		}
		
		if(StringUtils.isNotEmpty(so.getPhoto())){
			po.setPhoto(StringUtils.trim(so.getPhoto()));
		}
		
		if(StringUtils.isNotEmpty(so.getPhone())){
			po.setPhone(StringUtils.trim(so.getPhone()));
		}
		
		if(StringUtils.isNotEmpty(so.getMobile())){
			po.setMobile(StringUtils.trim(so.getMobile()));
		}
		
		if(StringUtils.isNotEmpty(so.getQq())){
			po.setQq(StringUtils.trim(so.getQq()));
		}
		
		if(StringUtils.isNotEmpty(so.getEmail())){
			po.setEmail(StringUtils.trim(so.getEmail()));
		}
		
		if(StringUtils.isNotEmpty(so.getPostcode())){
			po.setPostcode(StringUtils.trim(so.getPostcode()));
		}
		
		if(StringUtils.isNotEmpty(so.getAddress())){
			po.setAddress(StringUtils.trim(so.getAddress()));
		}
		
		if(StringUtils.isNotEmpty(so.getBname())){
			po.setBname(StringUtils.trim(so.getBname()));
		}
		
		if(StringUtils.isNotEmpty(so.getBcode())){
			po.setBcode(StringUtils.trim(so.getBcode()));
		}
		
		if(StringUtils.isNotEmpty(so.getBman())){
			po.setBman(StringUtils.trim(so.getBman()));
		}
		
		if(StringUtils.isNotEmpty(so.getBadd())){
			po.setBadd(StringUtils.trim(so.getBadd()));
		}
		
		if(StringUtils.isNotEmpty(so.getSchool())){
			po.setSchool(StringUtils.trim(so.getSchool()));
		}
		
		if(StringUtils.isNotEmpty(so.getSpecialty())){
			po.setSpecialty(StringUtils.trim(so.getSpecialty()));
		}
	}
}
