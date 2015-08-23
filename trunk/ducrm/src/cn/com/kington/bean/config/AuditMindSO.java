package cn.com.kington.bean.config;

import cn.com.kington.common.SOSupport;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.PublicType.StateType;

/**
 * 审核意见
 * 
 * @author 杜永生
 * 
 */
public class AuditMindSO extends SOSupport {
	private static final long serialVersionUID = 2458287096504001960L;
	private Long dataId;// 记录ID
	private OrderState sort;// 类型
	private String mind;// 文件名
	private StateType state;// 审核结果
	private String realname;// 审核人
	private String auditDate;// 审核日期

	public AuditMindSO() {
		super();
	}

	public AuditMindSO(Long dataId, OrderState sort, String mind,
			StateType state, String realname, String auditDate) {
		super();
		this.dataId = dataId;
		this.sort = sort;
		this.mind = mind;
		this.state = state;
		this.realname = realname;
		this.auditDate = auditDate;
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
