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
 * 仓库Store管理ACTION
 * 
 * @author 杜永生
 * 
 */
public class StoreAction extends BaseActionSupport {
	/**
	 * 首页
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
	 * 编辑
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=storeDAO.getSOById(id);
		}
		return Constants.EDIT;
	}
	
	/**
	 * 保存
	 */
	public void save(){
		storeDAO.saveOrUpdate(vo);
		
		StringBuffer js=new StringBuffer();
		js.append("alert('数据保存成功');");
		js.append("parent.document.location=\"/store/store/index.jhtml?rnd="+Math.random()+"\";");
		js.append("parent.window.$.weeboxs.close();");
		FunctionTools.executeJavascript(ServletActionContext.getResponse(), js.toString());
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave(){
		if(vo==null){
			addFieldError("vo", "无效的对象");
		}else{
			if(StringUtils.isEmpty(vo.getName())){
				addFieldError("vo.name", "名称不能为空");
			}
		}
		setInputResult(Constants.EDIT);
	}
	
	/**
	 * 删除成功
	 * @return
	 */
	public String delete(){
		if(id!=null){
			storeDAO.deleteById(id);
		}
		return redirectSuccess("/store/store/index.jhtml", "数据删除成功");
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
