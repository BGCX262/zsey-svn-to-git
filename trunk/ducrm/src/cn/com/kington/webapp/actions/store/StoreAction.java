package cn.com.kington.webapp.actions.store;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.com.kington.bean.store.StoreSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.store.StoreDAO;
import cn.com.kington.utils.FunctionTools;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * �ֿ�Store����ACTION
 * 
 * @author ������
 * 
 */
public class StoreAction extends BaseActionSupport {
	/**
	 * ��ҳ
	 */
	public String index(){
		if(vo==null){
			vo=new StoreSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=storeDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	/**
	 * �༭
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=storeDAO.getSOById(id);
		}
		return Constants.EDIT;
	}
	
	/**
	 * ����
	 */
	public void save(){
		storeDAO.saveOrUpdate(vo);
		
		StringBuffer js=new StringBuffer();
		js.append("alert('���ݱ���ɹ�');");
		js.append("parent.document.location=\"/store/store/index.jhtml?rnd="+Math.random()+"\";");
		js.append("parent.window.$.weeboxs.close();");
		FunctionTools.executeJavascript(ServletActionContext.getResponse(), js.toString());
	}
	
	/**
	 * ������֤
	 */
	public void validateSave(){
		if(vo==null){
			addFieldError("vo", "��Ч�Ķ���");
		}else{
			if(StringUtils.isEmpty(vo.getName())){
				addFieldError("vo.name", "���Ʋ���Ϊ��");
			}
		}
		setInputResult(Constants.EDIT);
	}
	
	/**
	 * ɾ���ɹ�
	 * @return
	 */
	public String delete(){
		if(id!=null){
			storeDAO.deleteById(id);
		}
		return redirectSuccess("/store/store/index.jhtml", "����ɾ���ɹ�");
	}
	
	public StoreSO getVo() {
		return vo;
	}

	public void setVo(StoreSO vo) {
		this.vo = vo;
	}

	private StoreSO vo;
	@Resource
	private StoreDAO storeDAO;
	private static final long serialVersionUID = 2213697073889971358L;

}
