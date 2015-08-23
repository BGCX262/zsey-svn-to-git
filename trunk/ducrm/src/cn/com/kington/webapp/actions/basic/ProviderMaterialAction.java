package cn.com.kington.webapp.actions.basic;

import javax.annotation.Resource;

import cn.com.kington.bean.basic.Material;
import cn.com.kington.bean.basic.ProviderMaterialSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.basic.ProviderMaterialDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

public class ProviderMaterialAction extends BaseActionSupport {
	public String index(){
		if(vo==null){
			vo=new ProviderMaterialSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=providerMaterialDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	
	/**
	 * ��ת��ѡ��ҳ��
	 * @return
	 */
	public String select(){
		return "select";
	}
	
	/**
	 * ��ѡ
	 * @return
	 */
	public String multi(){
		index();
		return Constants.MULTI;
	}
	
	public String save(){
		if(ids!=null && ids.length>0){
			providerMaterialDAO.delete(vo);
			for (Long mateid : ids) {
				ProviderMaterialSO so=new ProviderMaterialSO();
				Material material=new Material();
				material.setId(mateid);
				so.setMaterial(material);
				so.setProvider(vo.getProvider());
				providerMaterialDAO.saveOrUpdate(so);
			}
		}
		return "/basic/provider-material/index.jhtml?vo.provider.id="+vo.getProvider().getId()+"&rnd="+Math.random();
	}
	
	public void validateSave() {
		if (vo == null) {
			this.addFieldError("vo", "������Ч");
		} else {
			if(vo.getProvider()==null || vo.getProvider().getId()==null){
				addFieldError("vo.provider", "��Ӧ�̲���Ϊ��");
			}
			
			if(ids==null || ids.length==0){
				addFieldError("vo.ids", "���ϲ���Ϊ��");
			}
		}
		this.setInputResult(Constants.EDIT);
	}
	
	public String delete(){
		if(id!=null){
			providerMaterialDAO.deleteById(id);
		}
		return "/basic/provider-material/index.jhtml?vo.provider.id="+vo.getProvider().getId()+"&rnd="+Math.random();
	}
	
	private ProviderMaterialSO vo;
	@Resource
	private ProviderMaterialDAO providerMaterialDAO;
	private static final long serialVersionUID = -9045008292512151149L;

}
