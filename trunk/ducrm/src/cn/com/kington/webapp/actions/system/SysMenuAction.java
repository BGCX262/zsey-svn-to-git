package cn.com.kington.webapp.actions.system;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cc.mzone.struts2.coc.annotation.JSONResult;
import cn.com.kington.bean.system.SysMenu;
import cn.com.kington.bean.system.SysMenuSO;
import cn.com.kington.bean.system.SysRole;
import cn.com.kington.bean.system.SysRoleMenu;
import cn.com.kington.bean.system.SysRoleMenuSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.system.SysMenuDAO;
import cn.com.kington.dao.system.SysRoleDAO;
import cn.com.kington.dao.system.SysRoleMenuDAO;
import cn.com.kington.utils.FunctionTools;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 系统功能菜单管理
 * @author 杜永生
 *
 */
public class SysMenuAction extends BaseActionSupport {
	/**
	 * 首页
	 */
	public String index() {
		if(vo==null){
			vo=new SysMenuSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);

		pageList = sysMenuDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	/**
	 * 菜单功能单选
	 * @return
	 */
	public String single() {
		SysMenuSO so=new SysMenuSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		List<SysMenu> list=sysMenuDAO.getList(so);
		if(list!=null && list.size()>0){
			JSONArray array=new JSONArray();
			for (SysMenu menu : list) {
				JSONObject json=new JSONObject();
				json.put("id", menu.getId());
				
				if(menu.getParentMenu()==null){
					json.put("pId", 0);
				}else{
					json.put("pId", menu.getParentMenu().getId());
					json.put("open", true);
				}
				
				json.put("name", menu.getChName());
				
				if(id!=null){
					if(id.equals(menu.getId())){
						json.put("checked", true);
					}
				}
				
				array.add(json);
			}
			nodes=array.toString();
		}
		
		return Constants.SINGLE;
	}
	
	/**
	 * 菜单功能多选
	 * @return
	 */
	public String multi() {
		index();
		return Constants.MULTI;
	}
	
	/**
	 * 菜单授权列表
	 * @return
	 */
	public String grant() {
		//查询已经授权的功能菜单 
		SysRole role=sysRoleDAO.findById(id);
		SysRoleMenuSO suso=new SysRoleMenuSO();
		suso.setRole(role);
		suso.setPageNumber(1);
		suso.setObjectsPerPage(Integer.MAX_VALUE);
		List<SysRoleMenu> rulist=sysRoleMenuDAO.getList(suso);
		
		//查询系统所有功能菜单
		SysMenuSO so=new SysMenuSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		List<SysMenu> menuList=sysMenuDAO.getList(so);
		
		if(menuList!=null && menuList.size()>0){
			JSONArray array=new JSONArray();
			
			for (SysMenu menu : menuList) {
				JSONObject json=new JSONObject();
				
				json.put("id", menu.getId());
				json.put("name", menu.getChName());
				
				if(menu.getParentMenu()!=null && menu.getParentMenu().getId()!=null){
					json.put("pId", menu.getParentMenu().getId());
				}else{
					json.put("pId", 0L);
				}
				
				//选中角色授权的功能菜单
				if(rulist!=null && rulist.size()>0){
					for (SysRoleMenu srm : rulist) {
						if(srm.getMenu().getId().equals(menu.getId())){
							json.put("checked", true);
							break;
						}
					}
				}
				array.add(json);
			}
			nodes=array.toString();
		}
		
		return "grant";
	}
	
	public String saveGrant(){
		if(StringUtils.isNotEmpty(menus)){
			String[] grants=menus.split(",");
			if(grants!=null && grants.length>0){
				SysRole role=sysRoleDAO.findById(id);
				SysRoleMenuSO so=new SysRoleMenuSO();
				so.setRole(role);
				sysRoleMenuDAO.delete(so);
				
				for (String mid : grants) {
					if(StringUtils.isNotEmpty(mid)){
						SysMenu menu=new SysMenu();
						menu.setId(Long.parseLong(mid));
						
						SysRoleMenu roleMenu=new SysRoleMenu();
						roleMenu.setRole(role);
						roleMenu.setMenu(menu);
						sysRoleMenuDAO.merge(roleMenu);
					}
				}
			}
		}
		
		StringBuffer js=new StringBuffer();
		js.append("alert('数据保存成功');");
		js.append("window.parent.window.$.weeboxs.close();");
		FunctionTools.executeJavascript(ServletActionContext.getResponse(), js.toString());
		return null;
	}
	
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=sysMenuDAO.getSOById(id);
		}else{
			vo=new SysMenuSO();
		}
		return Constants.EDIT;
	}
	
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		sysMenuDAO.saveOrUpdate(vo);
		return redirectSuccess("/system/sys-menu/index.jhtml?rnd="+Math.random(), "数据保存成功");
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave() {
		if(vo==null){
			addFieldError("vo", "无效的对象");
		}else{
			
			if(vo.getId()==null){
				if(StringUtils.isEmpty(vo.getEnName())){
					addFieldError("vo.enName", "菜单名称不能为空");
				}else{
					ajaxCheckCode();
					if(isok){
						addFieldError("voenName", "菜单名称已存在");
					}
				}
			}
			
			if(StringUtils.isEmpty(vo.getChName())){
				addFieldError("chName", "显示名称不能为空");
			}
			
			if(vo.getId()!=null && vo.getParentMenu()!=null && vo.getParentMenu().getId()!=null){
				if(vo.getId().equals(vo.getParentMenu().getId())){
					addFieldError("vo.parentMenu.id", "不能选择自己");
				}
			}
		}
		
		setInputResult(Constants.EDIT);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		if(id!=null){
			sysMenuDAO.deleteById(id);
		}
		return redirectSuccess("/system/sys-menu/index.jhtml?rnd="+Math.random(), "数据删除成功");
	}
	
	@JSONResult(values={"isok"})
	public void ajaxCheckCode(){
		isok=sysMenuDAO.checkEnName(vo);
	}

	public SysMenuSO getVo() {
		return vo;
	}

	public void setVo(SysMenuSO vo) {
		this.vo = vo;
	}
	
	public Boolean getIsok() {
		return isok;
	}

	public void setIsok(Boolean isok) {
		this.isok = isok;
	}
	
	public String getNodes() {
		return nodes;
	}

	public void setNodes(String nodes) {
		this.nodes = nodes;
	}
	
	public String getMenus() {
		return menus;
	}

	public void setMenus(String menus) {
		this.menus = menus;
	}
	
	private String menus;
	private String nodes;
	private Boolean isok;
	private SysMenuSO vo;
	@Resource
	private SysMenuDAO sysMenuDAO;
	@Resource
	private SysRoleDAO sysRoleDAO;
	@Resource
	private SysRoleMenuDAO sysRoleMenuDAO;
	private static final long serialVersionUID = -5100029310687791972L;
}
