package cn.com.kington.webapp.actions.basic;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.AreaSO;
import cn.com.kington.bean.model.EmployeeSO;
import cn.com.kington.bean.model.Linkman;
import cn.com.kington.bean.model.LinkmanSO;
import cn.com.kington.bean.system.SysDict;
import cn.com.kington.bean.system.SysDictSO;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.BloodSort;
import cn.com.kington.common.PublicType.Degree;
import cn.com.kington.common.PublicType.ManSort;
import cn.com.kington.common.PublicType.Sex;
import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.dao.SysAppSequenceDAO;
import cn.com.kington.dao.basic.AreaDAO;
import cn.com.kington.dao.basic.EmployeeDAO;
import cn.com.kington.dao.basic.LinkmanDAO;
import cn.com.kington.dao.system.SysDictDAO;
import cn.com.kington.utils.ResourceManager;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 员工管理
 * @author 杜永生
 *
 */
public class EmployeeAction extends BaseActionSupport {
	/**
	 * 首页
	 */
	public String index() {
		if(vo==null){
			vo=new EmployeeSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=employeeDAO.findPage(vo);
		initArea();
		return Constants.INDEX;
	}
	
	/**
	 * 单选
	 * @return
	 */
	public String single(){
		index();
		return Constants.SINGLE;
	}
	
	/**
	 * 单选
	 * @return
	 */
	public String multi(){
		index();
		return Constants.MULTI;
	}
	
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=employeeDAO.getSOById(id);
			initMan();
		}
		initList();
		return Constants.EDIT;
	}
	
	/**
	 * 详情
	 * @return
	 */
	public String details(){
		if(id!=null){
			vo=employeeDAO.getSOById(id);
			initMan();
		}
		return Constants.DETAILS;
	}
	
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		if(vo.getId()==null){
			String code=sysAppSequenceDAO.getYearSeqVal("employee", 5, "员工编号");
			vo.setCode(code);
		}
		
		//保存相片
		if(StringUtils.isNotEmpty(uploadImageFileName)){
			String path=ResourceManager.addResource(RES_ARTICLE_PATH, uploadImage,uploadImageFileName).getFilepath();
			vo.setPhoto(path);
		}
		
		employeeDAO.saveOrUpdate(vo);
		return redirectSuccess("/basic/employee/index.jhtml?rnd="+Math.random(), "数据保存成功");
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave() {
		if (vo == null) {
			this.addFieldError("vo", "对象无效");
		} else {
			boolean check=false;
			if (StringUtils.isEmpty(vo.getName())) {
				check=true;
				addFieldError("vo.name", "员工姓名不能为空");
			}
			
			if(vo.getDepartment()==null){
				check=true;
				addFieldError("vo.department", "部门不能为空");
			}else{
				if(vo.getDepartment().getId()==null){
					check=true;
					addFieldError("vo.department.id", "部门不能为空");
				}
			}
			
			if(vo.getDuty()==null && vo.getDuty().getId()==null){
				check=true;
				addFieldError("vo.duty", "员工职务不能为空");
			}else{
				if(vo.getDuty().getId()==null){
					check=true;
					addFieldError("vo.duty.id", "员工职务不能为空");
				}
			}
			
			if(vo.getSex()==null){
				check=true;
				addFieldError("vo.sex", "员工性别不能为空");
			}
			
			if(check){
				initList();
			}
		}
		this.setInputResult(Constants.EDIT);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		if(id!=null){
			employeeDAO.deleteById(id);
		}
		return redirectSuccess("/basic/employee/index.jhtml?rnd="+Math.random(), "数据删除成功");
	}
	
	private void initArea(){
		//省份
		AreaSO so=new AreaSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		provinceList=areaDAO.find(so);
		
		//城市
		if(provinceList!=null && provinceList.size()>0){
			if(vo!=null && vo.getCity()!=null && vo.getCity().getId()!=null){
				so.setArea(vo.getProvince());
			}else{
				so.setArea(provinceList.get(0));
			}
			
			cityList=areaDAO.find(so);
		}
	}
	
	private void initList(){
		SysDictSO so=new SysDictSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		//证件类型
		so.setSort(Sort.CERTIFICATE);
		idtypeList=sysDictDAO.getList(so);
		
		//职务
		so.setSort(Sort.DUTY);
		dutyList=sysDictDAO.getList(so);
		
		//民族
		so.setSort(Sort.NATION);
		nationList=sysDictDAO.getList(so);
		
		//政治页面
		so.setSort(Sort.POLITY);
		polityList=sysDictDAO.getList(so);
		
		initArea();
	}
	
	/**
	 * 初始化联系人
	 */
	private void initMan(){
		LinkmanSO so=new LinkmanSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		so.setSort(ManSort.CUSTOMER);
		so.setDataId(id);
		manList=linkmanDAO.getList(so);
	}
	
	public EmployeeSO getVo() {
		return vo;
	}

	public void setVo(EmployeeSO vo) {
		this.vo = vo;
	}

	public List<SysDict> getDutyList() {
		return dutyList;
	}

	public void setDutyList(List<SysDict> dutyList) {
		this.dutyList = dutyList;
	}

	public List<SysDict> getIdtypeList() {
		return idtypeList;
	}

	public void setIdtypeList(List<SysDict> idtypeList) {
		this.idtypeList = idtypeList;
	}

	public Sex[] getSexs() {
		return sexs;
	}

	public void setSexs(Sex[] sexs) {
		this.sexs = sexs;
	}

	public BloodSort[] getBloods() {
		return bloods;
	}

	public void setBloods(BloodSort[] bloods) {
		this.bloods = bloods;
	}

	public Degree[] getDegrees() {
		return degrees;
	}

	public void setDegrees(Degree[] degrees) {
		this.degrees = degrees;
	}

	public List<SysDict> getNationList() {
		return nationList;
	}

	public void setNationList(List<SysDict> nationList) {
		this.nationList = nationList;
	}

	public List<SysDict> getPolityList() {
		return polityList;
	}

	public void setPolityList(List<SysDict> polityList) {
		this.polityList = polityList;
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
	
	public List<Linkman> getManList() {
		return manList;
	}

	public void setManList(List<Linkman> manList) {
		this.manList = manList;
	}

	public File getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}

	public String getUploadImageFileName() {
		return uploadImageFileName;
	}

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}
	
	private EmployeeSO vo;
	private List<SysDict> dutyList;// 职务列表
	private List<SysDict> idtypeList;// 证件列表
	private List<SysDict> nationList;// 民族列表
	private List<SysDict> polityList;// 政治面貌列表
	private List<Area> provinceList;//省
	private List<Area> cityList;//市
	private List<Linkman> manList;//联系人列表
	private Sex[] sexs = Sex.values();// 性别
	private BloodSort[] bloods = BloodSort.values();// 血型
	private Degree[] degrees = Degree.values();// 学历
	private File uploadImage;
	private String uploadImageFileName;
	@Resource
	private EmployeeDAO employeeDAO;
	@Resource
	private LinkmanDAO linkmanDAO;
	@Resource
	private SysDictDAO sysDictDAO;
	@Resource
	private AreaDAO areaDAO;
	@Resource
	private SysAppSequenceDAO sysAppSequenceDAO;
	public static final String RES_ARTICLE_PATH = "/resource/manual/employee/";
	public static final String RES_PIC_PATH = "/resource/picture/employee/";
	public static final Long MAXSIZE = 5 * 1024 * 1024L;
	public static final String EXTENSION = "jpg,png,jpeg,gif,bmp";
	public static final String PICTUREEXTENSION="jpg,png,jpeg,gif,bmp";
	private static final long serialVersionUID = -4552506341989939333L;	
}
