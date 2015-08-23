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
 * ϵͳ���ܲ˵�����
 * @author ������
 *
 */
public class SysMenuAction extends BaseActionSupport {
	/**
	 * ��ҳ
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
	 * �˵����ܵ�ѡ
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
	 * �˵����ܶ�ѡ
	 * @return
	 */
	public String multi() {
		index();
		return Constants.MULTI;
	}
	
	/**
	 * �˵���Ȩ�б�
	 * @return
	 */
	public String grant() {
		//��ѯ�Ѿ���Ȩ�Ĺ��ܲ˵� 
		SysRole role=sysRoleDAO.findById(id);
		SysRoleMenuSO suso=new SysRoleMenuSO();
		suso.setRole(role);
		suso.setPageNumber(1);
		suso.setObjectsPerPage(Integer.MAX_VALUE);
		List<SysRoleMenu> rulist=sysRoleMenuDAO.getList(suso);
		
		//��ѯϵͳ���й��ܲ˵�
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
				
				//ѡ�н�ɫ��Ȩ�Ĺ��ܲ˵�
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
		js.append("alert('���ݱ���ɹ�');");
		js.append("window.parent.window.$.weeboxs.close();");
		FunctionTools.executeJavascript(ServletActionContext.getResponse(), js.toString());
		return null;
	}
	
	/**
	 * �༭
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
	 * ����
	 * @return
	 */
	public String save(){
		sysMenuDAO.saveOrUpdate(vo);
		return redirectSuccess("/system/sys-menu/index.jhtml?rnd="+Math.random(), "���ݱ���ɹ�");
	}
	
	/**
	 * ������֤
	 */
	public void validateSave() {
		if(vo==null){
			addFieldError("vo", "��Ч�Ķ���");
		}else{
			
			if(vo.getId()==null){
				if(StringUtils.isEmpty(vo.getEnName())){
					addFieldError("vo.enName", "�˵����Ʋ���Ϊ��");
				}else{
					ajaxCheckCode();
					if(isok){
						addFieldError("voenName", "�˵������Ѵ���");
					}
				}
			}
			
			if(StringUtils.isEmpty(vo.getChName())){
				addFieldError("chName", "��ʾ���Ʋ���Ϊ��");
			}
			
			if(vo.getId()!=null && vo.getParentMenu()!=null && vo.getParentMenu().getId()!=null){
				if(vo.getId().equals(vo.getParentMenu().getId())){
					addFieldError("vo.parentMenu.id", "����ѡ���Լ�");
				}
			}
		}
		
		setInputResult(Constants.EDIT);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete(){
		if(id!=null){
			sysMenuDAO.deleteById(id);
		}
		return redirectSuccess("/system/sys-menu/index.jhtml?rnd="+Math.random(), "����ɾ���ɹ�");
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
