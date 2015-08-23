package cn.com.kington.webapp.actions.basic;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.com.kington.bean.basic.Material;
import cn.com.kington.bean.basic.MaterialSO;
import cn.com.kington.bean.model.Accessory;
import cn.com.kington.bean.model.AccessorySO;
import cn.com.kington.bean.system.SysDict;
import cn.com.kington.bean.system.SysDictSO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.dao.SysAppSequenceDAO;
import cn.com.kington.dao.basic.MaterialDAO;
import cn.com.kington.dao.system.AccessoryDAO;
import cn.com.kington.dao.system.SysDictDAO;
import cn.com.kington.utils.ResourceManager;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 物料管理
 * 
 * @author 杜永生
 * 
 */
public class MaterialAction extends BaseActionSupport {
	/**
	 * 首页
	 */
	public String index(){
		if(vo==null){
			vo=new MaterialSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=materialDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	/**
	 * 单选物料
	 * @return
	 */
	public String single(){
		index();
		return Constants.SINGLE;
	}
	
	/**
	 * 跳转到选择页面
	 * @return
	 */
	public String select(){
		return "select";
	}
	
	/**
	 * 多选
	 * @return
	 */
	public String multi(){
		index();
		return Constants.MULTI;
	}
	
	/**
	 * 多选
	 * @return
	 */
	public String check(){
		return "check";
	}
	
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=materialDAO.getSOById(id);
			initAccess();
		}
		init();
		return Constants.EDIT;
	}
	
	/**
	 * 详情
	 * @return
	 */
	public String details(){
		if(id!=null){
			vo=materialDAO.getSOById(id);
			initAccess();
		}
		return Constants.DETAILS;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		if(id!=null){
			materialDAO.deleteById(id);
		}
		return redirectSuccess("/basic/material/index.jhtml?rnd="+Math.random(), "数据删除成功");
	}
	
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		if(vo.getId()==null){
			String code=sysAppSequenceDAO.getYearSeqVal("material", 5, "物料编号");
			vo.setCode(code);
		}
		
		Material material=materialDAO.saveOrUpdate(vo);
		
		//保存图片
		if(templetsFileName!=null && templetsFileName.length>0){
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
			
			int index=0;
			for (String str : templetsFileName) {
				if(StringUtils.isNotEmpty(str)){
					String path=ResourceManager.addResource(RES_ARTICLE_PATH, templets[index],str).getFilepath();
					
					Accessory accessory=new Accessory();
					accessory.setDataId(material.getId());
					accessory.setSort(OrderState.JCXXGL_WLGL);
					accessory.setPath(path);
					accessory.setName(str);
					accessory.setUserid(user.getEmployee().getId());
					accessory.setRealname(user.getEmployee().getName());
					accessoryDAO.save(accessory);
				}
				index++;
			}
		}
		return redirectSuccess("/basic/material/index.jhtml?rnd="+Math.random(), "数据保存成功");
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave() {
		boolean ok=false;
		if (vo == null) {
			this.addFieldError("vo", "对象无效");
			ok=true;
		} else {
			if(StringUtils.isEmpty(vo.getName())){
				this.addFieldError("vo.name", "材料名称不能为空");
				ok=true;
			}
			
			if(vo.getUnit()==null || vo.getUnit().getId()==null){
				addFieldError("vo.unit.id", "材料单位不能为空");
				ok=true;
			}
			
			if(vo.getPrice()==null){
				addFieldError("vo.price", "材料价格不能为空");
				ok=true;
			}
		}
		
		if(ok){
			init();
		}
		
		this.setInputResult(Constants.EDIT);
	}
	
	private void init(){
		SysDictSO so=new SysDictSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		so.setSort(Sort.UNIT);
		units=sysDictDAO.getList(so);
	}
	
	private void initAccess(){
		AccessorySO accSO=new AccessorySO();
		accSO.setPageNumber(1);
		accSO.setObjectsPerPage(Integer.MAX_VALUE);
		accSO.setSort(OrderState.JCXXGL_WLGL);
		accSO.setDataId(id);
		accessList=accessoryDAO.getList(accSO);
	}
	
	public MaterialSO getVo() {
		return vo;
	}

	public void setVo(MaterialSO vo) {
		this.vo = vo;
	}

	public List<SysDict> getUnits() {
		return units;
	}

	public void setUnits(List<SysDict> units) {
		this.units = units;
	}
	
	public List<Accessory> getAccessList() {
		return accessList;
	}

	public void setAccessList(List<Accessory> accessList) {
		this.accessList = accessList;
	}
	
	public File[] getTemplets() {
		return templets;
	}

	public void setTemplets(File[] templets) {
		this.templets = templets;
	}

	public String[] getTempletsFileName() {
		return templetsFileName;
	}

	public void setTempletsFileName(String[] templetsFileName) {
		this.templetsFileName = templetsFileName;
	}
	
	private MaterialSO vo;
	private List<SysDict> units;
	private List<Accessory> accessList;
	private File[] templets;
	private String[] templetsFileName;
	@Resource
	private MaterialDAO materialDAO;
	@Resource
	private SysDictDAO sysDictDAO;
	@Resource
	private AccessoryDAO accessoryDAO;
	@Resource
	private SysAppSequenceDAO sysAppSequenceDAO;
	public static final String RES_ARTICLE_PATH = "/resource/manual/material/";
	public static final String RES_PIC_PATH = "/resource/picture/material/";
	public static final Long MAXSIZE = 5 * 1024 * 1024L;;
	public static final String EXTENSION = "jpg,png,jpeg,gif,bmp";
	public static final String PICTUREEXTENSION="jpg,png,jpeg,gif,bmp";
	private static final long serialVersionUID = 4197529148326046333L;
	
}
