package cn.com.kington.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class EntitySupport implements Serializable {
	private static final long serialVersionUID = -482658751353768739L;
	@Id
	@GeneratedValue(generator="custom-id")
	@GenericGenerator(name="custom-id", strategy = "cn.com.kington.utils.MyKeyGenerator")
	@Column(name = "id", unique = true, nullable = false, insertable = true, updatable = true, length = 22)
	private Long id;
	@Column(nullable=false, length=19)
	private String createTime;
	@Column(nullable=false, length=19)
	private String updateTime;
	@Column(nullable=false)
	private Boolean flag;
	@Column(nullable=false)
	private Boolean status;

	public EntitySupport() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
