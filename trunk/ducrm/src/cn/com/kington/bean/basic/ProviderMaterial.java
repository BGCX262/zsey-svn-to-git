package cn.com.kington.bean.basic;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import cn.com.kington.bean.EntitySupport;

/**
 * 供应商和物料的关系
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "base_prov_mate", uniqueConstraints = @UniqueConstraint(columnNames = {
		"fk_provider_id", "fk_material_id" }))
public class ProviderMaterial extends EntitySupport {
	private static final long serialVersionUID = -4579806762254012569L;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_provider_id")
	private Provider provider;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_material_id")
	private Material material;

	public ProviderMaterial() {
		super();
	}

	public ProviderMaterial(Provider provider, Material material) {
		super();
		this.provider = provider;
		this.material = material;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}
