package cn.com.kington.bean.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.basic.AbsBaseClient;

/**
 * 公司信息
 * 
 * @author sheng
 * 
 */
@Entity
@Table(name = "base_company")
public class Company extends AbsBaseClient {
	private static final long serialVersionUID = -1736123282160051806L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_company_id")
	private Company company;// 所属公司

	public Company() {
		super();
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
