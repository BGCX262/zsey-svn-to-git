package cn.com.kington.bean.store;

import javax.persistence.Column;

import cn.com.kington.common.PublicType.StateType;
import cn.com.kington.common.SOSupport;

/**
 * 项目，采购，退货，出货订单的基本信息
 * 
 * @author 杜永生
 * 
 */
public abstract class AbsBaseOrderSO extends SOSupport {
	private static final long serialVersionUID = 300738258947631907L;
	// 客户基本信息
	private Long clientId;// 客户ID
	private String name;// 单位名称
	private String fax;// 单位传真
	private String phone;// 单位电话
	private String linkman;// 联系人
	private String tel;// 联系人电话
	private String mobile;// 联系人手机
	private String address;// 地址
	private String postcode;// 邮编

	// 订单基本信息
	@Column(nullable = false, unique = true, length = 15)
	private String code;// 编号
	private Double total;// 总数
	private Double payment;// 应付/应收金额
	private Double payfor;// 已付/应付金额
	private Double nopay;// 未付金额

	private Long addId;// 添加人ID
	private String addName;// 添加人
	private String addDate;// 订单日期
	private StateType audit;// 审核状态

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Double getPayfor() {
		return payfor;
	}

	public void setPayfor(Double payfor) {
		this.payfor = payfor;
	}

	public Double getNopay() {
		return nopay;
	}

	public void setNopay(Double nopay) {
		this.nopay = nopay;
	}

	public Long getAddId() {
		return addId;
	}

	public void setAddId(Long addId) {
		this.addId = addId;
	}

	public String getAddName() {
		return addName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public StateType getAudit() {
		return audit;
	}

	public void setAudit(StateType audit) {
		this.audit = audit;
	}

}
