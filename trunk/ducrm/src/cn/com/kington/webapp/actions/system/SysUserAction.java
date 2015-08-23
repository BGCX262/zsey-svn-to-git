package cn.com.kington.webapp.actions.system;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import cc.mzone.struts2.coc.annotation.JSONResult;
import cn.com.kington.bean.system.SysRole;
import cn.com.kington.bean.system.SysRoleSO;
import cn.com.kington.bean.system.SysRoleUser;
import cn.com.kington.bean.system.SysRoleUserSO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.bean.system.SysUserSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.system.SysRoleDAO;
import cn.com.kington.dao.system.SysRoleUserDAO;
import cn.com.kington.dao.system.SysUserDAO;
import cn.com.kington.utils.ObjectTools;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * ϵͳ��ɫ
 * 
 * @author ������
 * 
 */
public class SysUserAction extends BaseActionSupport {
	/**
	 * ��ҳ
	 */
	public String index() {
		if(vo==null){
			vo=new SysUserSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);

		pageList = sysUserDAO.findPage(vo);
		return Constants.INDEX;
	}

	/**
	 * �༭
	 * 
	 * @return
	 */
	public String edit() {
		if (id != null) {
			vo=sysUserDAO.getSOById(id);
			SysUser user=ObjectTools.copy(vo, SysUser.class);
			init(user);
		}else{
			vo=new SysUserSO();
		}
		//��ѯ����ϵͳ��ɫ
		roleList=sysRoleDAO.getList(new SysRoleSO());
		return Constants.EDIT;
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public String save() {
		SysUser po=sysUserDAO.saveOrUpdate(vo); 
		
		if(ids!=null && ids.length>0){
			for (Long rid : ids) {
				SysRole sysRole=sysRoleDAO.findById(SysRole.class, rid);
				SysRoleUser sysRoleUser=new SysRoleUser(sysRole,po);
				sysRoleDAO.merge(sysRoleUser);
			}
		}
		
		return redirectSuccess("/system/sys-user/index.jhtml?rnd=" + Math.random(), "���ݱ���ɹ�");
	}

	/**
	 * ������֤
	 */
	public void validateSave() {
		if(vo==null){
			addFieldError("vo", "��Ч����");
		}else{
			boolean check=false;
			if(vo.getId()==null){
				if (StringUtils.isEmpty(vo.getUsername())) {
					addFieldError("vo.username", "�û�������Ϊ��");
					check=true;
				}else{
					ajaxCheckCode();
					if(isok){
						addFieldError("vo.username", "�û����ѱ�ʹ��");
						check=true;
					}
				}
			}
			
			if(vo.getEmployee()==null){
				addFieldError("vo.employee", "��ѡ��Ա��");
				check=true;
			}else{
				if(vo.getEmployee().getId()==null){
					addFieldError("vo.employee.id", "��ѡ��Ա��");
					check=true;
				}
			}
			
			if(check){
				if(vo.getId()!=null){
					vo=sysUserDAO.getSOById(id);
				}
				SysUser user=ObjectTools.copy(vo, SysUser.class);
				init(user);
			}
		}
		this.setInputResult(Constants.EDIT);
	}

	/**
	 * ɾ��
	 * 
	 * @return
	 */
	public String delete() {
		if(id!=null){
			sysUserDAO.delete(id);
		}
		return redirectSuccess("/system/sys-user/index.jhtml?rnd=" + Math.random(), "����ɾ���ɹ�");
	}
	
	@JSONResult(values = { "isok" })
	public void ajaxCheckCode(){
		SysUser po=sysUserDAO.checkUser(vo);
		
		if(po!=null){
			isok=true;
		}else{
			isok=false;
		}
	}
	
	private void init(SysUser user){
		//��ѯ��ɫ���û��Ĺ�ϵ
		SysRoleUserSO roleUser=new SysRoleUserSO();
		roleUser.setUser(user);
		roleUserList=sysRoleUserDAO.getList(roleUser);
	}
	
	public Boolean getIsok() {
		return isok;
	}

	public void setIsok(Boolean isok) {
		this.isok = isok;
	}

	public SysUserSO getVo() {
		return vo;
	}

	public void setVo(SysUserSO vo) {
		this.vo = vo;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	public List<SysRoleUser> getRoleUserList() {
		return roleUserList;
	}

	public void setRoleUserList(List<SysRoleUser> roleUserList) {
		this.roleUserList = roleUserList;
	}

	private Boolean isok;
	private List<SysRole> roleList;
	private List<SysRoleUser> roleUserList;
	private SysUserSO vo;
	@Resource
	private SysRoleDAO sysRoleDAO;
	@Resource
	private SysRoleUserDAO sysRoleUserDAO;
	@Resource
	private SysUserDAO sysUserDAO;
	private static final long serialVersionUID = 5152153277422843838L;
}
