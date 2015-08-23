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
import cn.com.kington.bean.basic.Customer;
import cn.com.kington.bean.basic.CustomerSO;
import cn.com.kington.bean.model.Accessory;
import cn.com.kington.bean.model.AccessorySO;
import cn.com.kington.bean.model.Linkman;
import cn.com.kington.bean.model.LinkmanSO;
import cn.com.kington.bean.system.SysDict;
import cn.com.kington.bean.system.SysDictSO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.ManSort;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.dao.SysAppSequenceDAO;
import cn.com.kington.dao.basic.AreaDAO;
import cn.com.kington.dao.basic.CustomerDAO;
import cn.com.kington.dao.basic.LinkmanDAO;
import cn.com.kington.dao.system.AccessoryDAO;
import cn.com.kington.dao.system.SysDictDAO;
import cn.com.kington.utils.ResourceManager;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 客户管理
 * @author 杜永生
 *
 */
public class CustomerAction extends BaseActionSupport {
	public String index(){
		if(vo==null){
			vo=new CustomerSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=customerDAO.findPage(vo);
		init();		
		return Constants.INDEX;
	}
	
	public String edit(){
		if(id!=null){
			vo=customerDAO.getSOById(id);
			initAccess();
			initMan();
		}
		init();
		return Constants.EDIT;
	}
	
	public String details(){
		if(id!=null){
			vo=customerDAO.getSOById(id);
			initAccess();
			initMan();
		}
		return Constants.DETAILS;
	}
	
	public String delete(){
		customerDAO.deleteById(id);
		return redirectSuccess("/basic/customer/index.jhtml?rnd="+Math.random(), "数据删除成功");
	}
	
	public String save(){
		if(vo.getId()==null){
			String code=sysAppSequenceDAO.getYearSeqVal("customer", 5, "客户编号");
			vo.setCode(code);
		}
		Customer customer=customerDAO.saveOrUpdate(vo);
		
		//保存联系人
		if(names!=null && names.length>0){
			LinkmanSO so=new LinkmanSO();
			so.setSort(ManSort.CUSTOMER);
			so.setDataId(customer.getId());
			linkmanDAO.delete(so);
			int index=0;
			for (String name : names) {
				Linkman man=new Linkman();
				man.setDataId(customer.getId());
				man.setSort(ManSort.CUSTOMER);
				man.setName(name);
				man.setCompany(companys[index]);
				man.setDuty(dutys[index]);
				man.setPhone(phones[index]);
				man.setMobile(mobiles[index]);
				linkmanDAO.save(man);
				index++;
			}
		}
		
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
					accessory.setDataId(customer.getId());
					accessory.setSort(OrderState.JCXXGL_KHGL);
					accessory.setPath(path);
					accessory.setName(str);
					accessory.setUserid(user.getEmployee().getId());
					accessory.setRealname(user.getEmployee().getName());
					accessoryDAO.save(accessory);
				}
				index++;
			}
		}
		
		return redirectSuccess("/basic/customer/index.jhtml?rnd="+Math.random(), "数据保存成功");
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
				addFieldError("vo.name", "客户名称不能为空");
				check=true;
			}
		}
		
		if(check){
			init();
		}
		
		setInputResult(Constants.EDIT);
	}
	
	private void init(){
		//客户类型
		SysDictSO so=new SysDictSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		so.setSort(Sort.CUSTOMER);
		sortList=sysDictDAO.getList(so);
		
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
		accSO.setSort(OrderState.JCXXGL_KHGL);
		accSO.setDataId(id);
		accessList=accessoryDAO.getList(accSO);
	}
	
	private void initMan(){
		LinkmanSO so=new LinkmanSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		so.setSort(ManSort.CUSTOMER);
		so.setDataId(id);
		manList=linkmanDAO.getList(so);
	}
	
	public String single(){
		index();
		return Constants.SINGLE;
	}
	
	public CustomerSO getVo() {
		return vo;
	}

	public void setVo(CustomerSO vo) {
		this.vo = vo;
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

	public List<SysDict> getSortList() {
		return sortList;
	}

	public void setSortList(List<SysDict> sortList) {
		this.sortList = sortList;
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

	public List<Linkman> getManList() {
		return manList;
	}

	public void setManList(List<Linkman> manList) {
		this.manList = manList;
	}
	
	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String[] getDutys() {
		return dutys;
	}

	public void setDutys(String[] dutys) {
		this.dutys = dutys;
	}

	public String[] getCompanys() {
		return companys;
	}

	public void setCompanys(String[] companys) {
		this.companys = companys;
	}

	public String[] getPhones() {
		return phones;
	}

	public void setPhones(String[] phones) {
		this.phones = phones;
	}

	public String[] getMobiles() {
		return mobiles;
	}

	public void setMobiles(String[] mobiles) {
		this.mobiles = mobiles;
	}

	private CustomerSO vo;
	private List<Area> provinceList;
	private List<Area> cityList;
	private List<SysDict> sortList;
	private List<Accessory> accessList;
	private List<Linkman> manList;
	private String[] names;
	private String[] dutys;
	private String[] companys;
	private String[] phones;
	private String[] mobiles;
	private File[] templets;
	private String[] templetsFileName;
	@Resource
	private AreaDAO areaDAO;
	@Resource
	private SysDictDAO sysDictDAO;
	@Resource
	private CustomerDAO customerDAO;
	@Resource
	private AccessoryDAO accessoryDAO;
	@Resource
	private LinkmanDAO linkmanDAO;
	@Resource
	private SysAppSequenceDAO sysAppSequenceDAO;
	public static final String RES_ARTICLE_PATH = "/resource/manual/customer/";
	public static final String RES_PIC_PATH = "/resource/picture/customer/";
	public static final Long MAXSIZE = 10 * 1024 * 1024L;;
	public static final String EXTENSION = "jpg,png,jpeg,gif,bmp,docx,doc,xlsx,xls,pptx,ppt,dps,et,wps,txt,pdf,zip,rar";
	public static final String PICTUREEXTENSION="jpg,png,jpeg,gif,bmp,docx,doc,xlsx,xls,pptx,ppt,dps,et,wps,txt,pdf,zip,rar";
	private static final long serialVersionUID = -2670203684882672922L;
}
