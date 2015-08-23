package cn.com.kington.webapp.actions;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.com.kington.bean.system.SysMenu;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.system.SysRoleMenuDAO;

public class MainAction extends BaseActionSupport {
	private static final long serialVersionUID = 3782229038250383916L;

	public String index() {
		return "index";
	}

	public String head() {
		return "head";
	}

	public String welcome() {
		return "welcome";
	}

	public String left() {
		HttpSession session=ServletActionContext.getRequest().getSession();
		SysUser user=(SysUser) session.getAttribute(Constants.DEFAULT_USER_LOGIN);
		if(user!=null){
			menuList=sysRoleMenuDAO.findMenuByUser(user);
		}
		return "left";
	}

	public String swich() {
		return "swich";
	}

	public String foot() {
		return "foot";
	}

	public List<SysMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}
	
	private List<SysMenu> menuList;
	@Resource
	private SysRoleMenuDAO sysRoleMenuDAO;

}
