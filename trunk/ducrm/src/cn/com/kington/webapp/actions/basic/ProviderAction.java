package cn.com.kington.webapp.actions.basic;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.AreaSO;
import cn.com.kington.bean.basic.Provider;
import cn.com.kington.bean.basic.ProviderSO;
import cn.com.kington.bean.model.Accessory;
import cn.com.kington.bean.model.AccessorySO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.dao.SysAppSequenceDAO;
import cn.com.kington.dao.basic.AreaDAO;
import cn.com.kington.dao.basic.ProviderDAO;
import cn.com.kington.dao.system.AccessoryDAO;
import cn.com.kington.utils.ResourceManager;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 供应商管理
 * @author 杜永生
 *
 */
public class ProviderAction extends BaseActionSupport {
	public String index(){
		if(vo==null){
			vo=new ProviderSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=providerDAO.findPage(vo);
		init();
		return Constants.INDEX;
	}
	
	/**
	 * 单个选择页面
	 * @return
	 */
	public String single(){
		index();
		return Constants.SINGLE;
	}
	
	public String edit(){
		if(id!=null){
			vo=providerDAO.getSOById(id);
			initAccess();
		}else{
			vo=new ProviderSO();
		}
		init();
		return Constants.EDIT;
	}
	
	public String details(){
		if(id!=null){
			vo=providerDAO.getSOById(id);
			initAccess();
		}
		return Constants.DETAILS;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		providerDAO.deleteById(id);
		return redirectSuccess("/basic/provider/index.jhtml?rnd="+Math.random(), "数据删除成功");
	}
	
	public String save(){
		if(vo.getId()==null){
			String code=sysAppSequenceDAO.getYearSeqVal("provider", 5, "供应商编号");
			vo.setCode(code);
		}
		Provider provider=providerDAO.saveOrUpdate(vo);
		
		//附件
		if(templetsFileName!=null && templetsFileName.length>0){
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
			
			int index=0;
			for (String str : templetsFileName) {
				if(StringUtils.isNotEmpty(str)){
					String path=ResourceManager.addResource(RES_ARTICLE_PATH, templets[index],str).getFilepath();
					
					Accessory accessory=new Accessory();
					accessory.setDataId(provider.getId());
					accessory.setSort(OrderState.JCXXGL_GYSGL);
					accessory.setPath(path);
					accessory.setName(str);
					accessory.setUserid(user.getEmployee().getId());
					accessory.setRealname(user.getEmployee().getName());
					accessoryDAO.save(accessory);
				}
				index++;
			}
		}
		
		return redirectSuccess("/basic/provider/index.jhtml?rnd="+Math.random(), "数据保存成功");
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave() {
		boolean check=false;
		if (vo == null) {
			this.addFieldError("vo", "对象无效");
			check=true;
		} else {
			if(StringUtils.isEmpty(vo.getName())){
				addFieldError("vo.name", "供应商名称不能为空");
				check=true;
			}
		}
		
		if(check){
			init();
		}
		
		setInputResult(Constants.EDIT);
	}
	
	/**
	 * 初始化列表
	 */
	private void init(){
		//省份
		AreaSO s=new AreaSO();
		s.setPageNumber(1);
		s.setObjectsPerPage(Integer.MAX_VALUE);
		s.setArea(null);
		provinceList=areaDAO.find(s);
		
		//城市
		if(provinceList!=null && provinceList.size()>0){
			if(vo!=null){
				if(vo.getCity()!=null && vo.getCity().getId()!=null){
					s.setArea(vo.getProvince());
				}else{
					s.setArea(provinceList.get(0));
				}
			}else{
				s.setArea(provinceList.get(0));
			}
			
			cityList=areaDAO.find(s);
		}
	}
	
	private void initAccess(){
		AccessorySO accSO=new AccessorySO();
		accSO.setPageNumber(1);
		accSO.setObjectsPerPage(Integer.MAX_VALUE);
		accSO.setSort(OrderState.JCXXGL_GYSGL);
		accSO.setDataId(id);
		accessList=accessoryDAO.getList(accSO);
	}
	
	public List<Area> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Area> provinceList) {
		this.provinceList = provinceList;
	}

	public List<Area> getCityList() {
		return cityList;
	}

	public void setCityList(List<Area> cityList) {
		this.cityList = cityList;
	}

	public ProviderSO getVo() {
		return vo;
	}
	
	public void setVo(ProviderSO vo) {
		this.vo = vo;
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

	public List<Accessory> getAccessList() {
		return accessList;
	}

	public void setAccessList(List<Accessory> accessList) {
		this.accessList = accessList;
	}
	
	private List<Area> provinceList;
	private List<Area> cityList;
	private List<Accessory> accessList;
	private File[] templets;
	private String[] templetsFileName;
	private ProviderSO vo;
	@Resource
	private ProviderDAO providerDAO;
	@Resource
	private AreaDAO areaDAO;
	@Resource
	private AccessoryDAO accessoryDAO;
	@Resource
	private SysAppSequenceDAO sysAppSequenceDAO;
	public static final String RES_ARTICLE_PATH = "/resource/manual/provider/";
	public static final String RES_PIC_PATH = "/resource/picture/provider/";
	public static final Long MAXSIZE = 10 * 1024 * 1024L;;
	public static final String EXTENSION = "jpg,png,jpeg,gif,bmp,docx,doc,xlsx,xls,pptx,ppt,dps,et,wps,txt,pdf,zip,rar";
	public static final String PICTUREEXTENSION="jpg,png,jpeg,gif,bmp,docx,doc,xlsx,xls,pptx,ppt,dps,et,wps,txt,pdf,zip,rar";
	private static final long serialVersionUID = 704733693151890011L;

}
