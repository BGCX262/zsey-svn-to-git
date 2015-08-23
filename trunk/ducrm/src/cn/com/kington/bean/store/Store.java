package cn.com.kington.bean.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;

/**
 * 仓库信息
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "base_store")
public class Store extends EntitySupport {
	private static final long serialVersionUID = 8037067259629836441L;
	@Column(nullable = false, length = 50)
	private String name;// 名称

	public Store() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
