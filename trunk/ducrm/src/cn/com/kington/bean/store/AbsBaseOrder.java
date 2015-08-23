package cn.com.kington.bean.store;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import cn.com.kington.bean.EntitySupport;
import cn.com.kington.common.PublicType.StateType;

/**
 * 项目，采购，退货，出货订单的基本信息
 * 
 * @author 杜永生
 * 
 */
@MappedSuperclass
public abstract class AbsBaseOrder extends EntitySupport {
	private static final long serialVersionUID = -5452449981224410923L;
	// 客户基本信息
	private Long clientId;// 客户ID
	@Column(length = 50)
	private String name;// 单位名称
	@Column(length = 20)
	private String fax;// 单位传真
	@Column(length = 20)
	private String phone;// 单位电话
	@Column(length = 10)
	private String linkman;// 联系人
	@Column(length = 20)
	private String tel;// 联系人电话
	@Column(length = 20)
	private String mobile;// 联系人手机
	@Column(length = 50)
	private String address;// 地址
	@Column(length = 6)
	private String postcode;// 邮编

	// 订单基本信息
	@Column(nullable = false, unique = true, length = 15)
	private String code;// 编号
	@Column(scale = 2, precision = 22)
	private Double total;// 总数
	@Column(scale = 2, precision = 22)
	private Double payment;// 应付/应收金额
	@Column(scale = 2, precision = 22)
	private Double payfor;// 已付/应付金额
	@Column(scale = 2, precision = 22)
	private Double nopay;// 未付金额

	private Long addId;// 添加人ID
	@Column(length = 20)
	private String addName;// 添加人
	@Column(length = 10)
	private String addDate;// 订单日期
	@Column(length = 12)
	@Enumerated(EnumType.STRING)
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
