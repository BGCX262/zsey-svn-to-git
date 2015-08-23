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
 * Ա������
 * @author ������
 *
 */
public class EmployeeAction extends BaseActionSupport {
	/**
	 * ��ҳ
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
	 * ��ѡ
	 * @return
	 */
	public String single(){
		index();
		return Constants.SINGLE;
	}
	
	/**
	 * ��ѡ
	 * @return
	 */
	public String multi(){
		index();
		return Constants.MULTI;
	}
	
	/**
	 * �༭
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
	 * ����
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
	 * ����
	 * @return
	 */
	public String save(){
		if(vo.getId()==null){
			String code=sysAppSequenceDAO.getYearSeqVal("employee", 5, "Ա�����");
			vo.setCode(code);
		}
		
		//������Ƭ
		if(StringUtils.isNotEmpty(uploadImageFileName)){
			String path=ResourceManager.addResource(RES_ARTICLE_PATH, uploadImage,uploadImageFileName).getFilepath();
			vo.setPhoto(path);
		}
		
		employeeDAO.saveOrUpdate(vo);
		return redirectSuccess("/basic/employee/index.jhtml?rnd="+Math.random(), "���ݱ���ɹ�");
	}
	
	/**
	 * ������֤
	 */
	public void validateSave() {
		if (vo == null) {
			this.addFieldError("vo", "������Ч");
		} else {
			boolean check=false;
			if (StringUtils.isEmpty(vo.getName())) {
				check=true;
				addFieldError("vo.name", "Ա����������Ϊ��");
			}
			
			if(vo.getDepartment()==null){
				check=true;
				addFieldError("vo.department", "���Ų���Ϊ��");
			}else{
				if(vo.getDepartment().getId()==null){
					check=true;
					addFieldError("vo.department.id", "���Ų���Ϊ��");
				}
			}
			
			if(vo.getDuty()==null && vo.getDuty().getId()==null){
				check=true;
				addFieldError("vo.duty", "Ա��ְ����Ϊ��");
			}else{
				if(vo.getDuty().getId()==null){
					check=true;
					addFieldError("vo.duty.id", "Ա��ְ����Ϊ��");
				}
			}
			
			if(vo.getSex()==null){
				check=true;
				addFieldError("vo.sex", "Ա���Ա���Ϊ��");
			}
			
			if(check){
				initList();
			}
		}
		this.setInputResult(Constants.EDIT);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete(){
		if(id!=null){
			employeeDAO.deleteById(id);
		}
		return redirectSuccess("/basic/employee/index.jhtml?rnd="+Math.random(), "����ɾ���ɹ�");
	}
	
	private void initArea(){
		//ʡ��
		AreaSO so=new AreaSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		provinceList=areaDAO.find(so);
		
		//����
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
		//֤������
		so.setSort(Sort.CERTIFICATE);
		idtypeList=sysDictDAO.getList(so);
		
		//ְ��
		so.setSort(Sort.DUTY);
		dutyList=sysDictDAO.getList(so);
		
		//����
		so.setSort(Sort.NATION);
		nationList=sysDictDAO.getList(so);
		
		//����ҳ��
		so.setSort(Sort.POLITY);
		polityList=sysDictDAO.getList(so);
		
		initArea();
	}
	
	/**
	 * ��ʼ����ϵ��
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
	private List<SysDict> dutyList;// ְ���б�
	private List<SysDict> idtypeList;// ֤���б�
	private List<SysDict> nationList;// �����б�
	private List<SysDict> polityList;// ������ò�б�
	private List<Area> provinceList;//ʡ
	private List<Area> cityList;//��
	private List<Linkman> manList;//��ϵ���б�
	private Sex[] sexs = Sex.values();// �Ա�
	private BloodSort[] bloods = BloodSort.values();// Ѫ��
	private Degree[] degrees = Degree.values();// ѧ��
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
