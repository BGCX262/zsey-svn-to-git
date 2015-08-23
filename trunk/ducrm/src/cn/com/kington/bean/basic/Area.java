package cn.com.kington.bean.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;

/**
 * ����
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "base_area")
public class Area extends EntitySupport {
	private static final long serialVersionUID = -4467553772555025237L;
	@Column(nullable = false, length = 4)
	private String code;// ���
	@Column(nullable = false, length = 20)
	private String name;// ����
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_area_id")
	private Area area;// ��������

	public Area() {
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
