package cn.com.kington.webapp.actions.utils;

import javax.annotation.Resource;

import cc.mzone.struts2.coc.annotation.JSONResult;
import cn.com.kington.bean.model.AccessorySO;
import cn.com.kington.dao.system.AccessoryDAO;
import cn.com.kington.utils.ResourceManager;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * �����ϴ�����
 * 
 * @author ������
 * 
 */
public class AccessoryAction extends BaseActionSupport {
	/**
	 * ɾ��
	 * @return
	 */
	@JSONResult(values={"isok"})
	public void delete(){
		if(id!=null){
			accessoryDAO.deleteById(id);
			isok=true;
		}
	}
	
	/**
	 * ��������
	 */
	public void download(){
		if(id!=null){
			AccessorySO accessory=accessoryDAO.getSOById(id);
			ResourceManager.download(accessory.getPath(), accessory.getName());
		}
	}
	
	public AccessorySO getVo() {
		return vo;
	}

	public void setVo(AccessorySO vo) {
		this.vo = vo;
	}
	
	public Boolean getIsok() {
		return isok;
	}

	public void setIsok(Boolean isok) {
		this.isok = isok;
	}

	private AccessorySO vo;
	private Boolean isok;
	@Resource
	private AccessoryDAO accessoryDAO;
	private static final long serialVersionUID = 473798270446845578L;
}
