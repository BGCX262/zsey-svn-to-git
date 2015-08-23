package cn.com.kington.bean.store;

import javax.persistence.Column;

import cn.com.kington.common.PublicType.StateType;
import cn.com.kington.common.SOSupport;

/**
 * ��Ŀ���ɹ����˻������������Ļ�����Ϣ
 * 
 * @author ������
 * 
 */
public abstract class AbsBaseOrderSO extends SOSupport {
	private static final long serialVersionUID = 300738258947631907L;
	// �ͻ�������Ϣ
	private Long clientId;// �ͻ�ID
	private String name;// ��λ����
	private String fax;// ��λ����
	private String phone;// ��λ�绰
	private String linkman;// ��ϵ��
	private String tel;// ��ϵ�˵绰
	private String mobile;// ��ϵ���ֻ�
	private String address;// ��ַ
	private String postcode;// �ʱ�

	// ����������Ϣ
	@Column(nullable = false, unique = true, length = 15)
	private String code;// ���
	private Double total;// ����
	private Double payment;// Ӧ��/Ӧ�ս��
	private Double payfor;// �Ѹ�/Ӧ�����
	private Double nopay;// δ�����

	private Long addId;// �����ID
	private String addName;// �����
	private String addDate;// ��������
	private StateType audit;// ���״̬

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
