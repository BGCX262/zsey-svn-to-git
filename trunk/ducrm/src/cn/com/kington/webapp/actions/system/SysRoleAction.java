package cn.com.kington.webapp.actions.system;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import cc.mzone.struts2.coc.annotation.JSONResult;
import cn.com.kington.bean.system.SysRoleSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.system.SysRoleDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 系统角色
 * 
 * @author 杜永生
 * 
 */
public class SysRoleAction extends BaseActionSupport {
	/**
	 * 首页
	 */
	public String index() {
		if(vo==null){
			vo=new SysRoleSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);

		pageList = sysRoleDAO.findPage(vo);
		return Constants.INDEX;
	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	public String edit() {
		if (id != null) {
			vo = sysRoleDAO.getSOById(id);
		}else{
			vo=new SysRoleSO();
		}
		return Constants.EDIT;
	}

	/**
	 * 保存
	 * 
	 * @return
	 */
	public String save() {
		sysRoleDAO.saveOrUpdate(vo);
		return redirectSuccess("/system/sys-role/index.jhtml?rnd=" + Math.random(), "数据保存成功");
	}

	/**
	 * 保存验证
	 */
	public void validateSave() {
		if(vo==null){
			addFieldError("vo", "无效的对象");
		}else{
			if (StringUtils.isEmpty(vo.getCode())) {
				addFieldError("vo.code", "代码不能为空");
			}else{
				ajaxCheckCode();
				if(isok){
					addFieldError("vo.code", "代码已存在");
				}
			}
			
			if (StringUtils.isEmpty(vo.getName())) {
				addFieldError("vo.name", "名称不能为空");
			}
		}
		
		
		
		this.setInputResult(Constants.EDIT);
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		if(id!=null){
			sysRoleDAO.delete(id);
		}
		return redirectSuccess("/system/sys-role/index.jhtml?rnd=" + Math.random(), "数据删除成功");
	}
	
	@JSONResult(values = { "isok" })
	public void ajaxCheckCode(){
		isok=sysRoleDAO.checkCode(vo);
	}
	
	public SysRoleSO getVo() {
		return vo;
	}

	public void setVo(SysRoleSO vo) {
		this.vo = vo;
	}
	
	public Boolean getIsok() {
		return isok;
	}

	public void setIsok(Boolean isok) {
		this.isok = isok;
	}

	private Boolean isok;
	private SysRoleSO vo;
	@Resource
	private SysRoleDAO sysRoleDAO;
	private static final long serialVersionUID = 5152153277422843838L;
	
}
