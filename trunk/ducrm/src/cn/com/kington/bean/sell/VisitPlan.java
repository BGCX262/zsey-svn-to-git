package cn.com.kington.bean.sell;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.bean.basic.Category;
import cn.com.kington.bean.model.Employee;
import cn.com.kington.common.PublicType.ManSort;

/**
 * 客户供应商商务联系日程
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "xm_visit_plan")
public class VisitPlan extends EntitySupport {
	private static final long serialVersionUID = 2674639110311078668L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_employee_id")
	private Employee employee;// 添加人
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_ploy_id")
	private Category ploy;// 活动类型
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_contact_id")
	private Category contact;// 联系方式
	@Enumerated(EnumType.STRING)
	private ManSort sort;// 分类
	private Long comId;// 单位ID
	private Long comName;// 单位ID
	private String title;// 主题
	@Column(nullable = false)
	@Basic(fetch = FetchType.LAZY)
	private String context;// 内容

	public VisitPlan() {
		super();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Category getPloy() {
		return ploy;
	}

	public void setPloy(Category ploy) {
		this.ploy = ploy;
	}

	public Category getContact() {
		return contact;
	}

	public void setContact(Category contact) {
		this.contact = contact;
	}

	public ManSort getSort() {
		return sort;
	}

	public void setSort(ManSort sort) {
		this.sort = sort;
	}

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public Long getComName() {
		return comName;
	}

	public void setComName(Long comName) {
		this.comName = comName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
