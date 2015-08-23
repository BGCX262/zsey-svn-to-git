package cn.com.kington.bean.config;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.PublicType.StateType;

/**
 * 审核意见
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "xm_audit_mind")
public class AuditMind extends EntitySupport {
	private static final long serialVersionUID = 2813417466074294040L;
	@Column(nullable = false)
	private Long dataId;// 记录ID
	@Column(nullable = false, length=20)
	@Enumerated(EnumType.STRING)
	private OrderState sort;// 类型
	@Column(nullable = false, length = 255)
	@Basic(fetch = FetchType.LAZY)
	private String mind;// 审核意见
	@Column(nullable = false, length=15)
	@Enumerated(EnumType.STRING)
	private StateType state;
	@Column(nullable = false)
	private String realname;
	@Column(nullable = false)
	private String auditDate;//审核日期

	public AuditMind() {
		super();
	}

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	public OrderState getSort() {
		return sort;
	}

	public void setSort(OrderState sort) {
		this.sort = sort;
	}

	public String getMind() {
		return mind;
	}

	public void setMind(String mind) {
		this.mind = mind;
	}

	public StateType getState() {
		return state;
	}

	public void setState(StateType state) {
		this.state = state;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

}
