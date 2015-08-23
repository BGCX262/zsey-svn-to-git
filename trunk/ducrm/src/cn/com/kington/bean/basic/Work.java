package cn.com.kington.bean.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;

/**
 * 工序
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "base_work")
public class Work extends EntitySupport {
	private static final long serialVersionUID = 959153147479097240L;
	@Column(nullable = false, unique = true, length = 10)
	private String code;// 编号
	@Column(nullable = false, length = 50)
	private String name;// 名称
	@Column(nullable = false, scale = 2, precision = 10)
	private Double price;// 单价
	@Column(length = 50)
	private String remark;// 备注

	public Work() {
		super();
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
