package cn.com.kington.bean.basic;

import cn.com.kington.common.SOSupport;

/**
 * 供应商和物料的关系
 * 
 * @author 杜永生
 * 
 */
public class ProviderMaterialSO extends SOSupport {
	private static final long serialVersionUID = -4579806762254012569L;
	private Provider provider;
	private Material material;

	public ProviderMaterialSO() {
		super();
	}

	public ProviderMaterialSO(Provider provider, Material material) {
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
