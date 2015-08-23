package cn.com.kington.webapp.actions.basic;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.com.kington.bean.basic.Product;
import cn.com.kington.bean.basic.ProductSO;
import cn.com.kington.bean.model.Accessory;
import cn.com.kington.bean.model.AccessorySO;
import cn.com.kington.bean.produce.ProductMaterial;
import cn.com.kington.bean.produce.ProductMaterialSO;
import cn.com.kington.bean.produce.ProductWork;
import cn.com.kington.bean.produce.ProductWorkSO;
import cn.com.kington.bean.system.SysDict;
import cn.com.kington.bean.system.SysDictSO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.PublicType.ProductType;
import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.dao.SysAppSequenceDAO;
import cn.com.kington.dao.basic.ProductDAO;
import cn.com.kington.dao.produce.ProductMaterialDAO;
import cn.com.kington.dao.produce.ProductWorkDAO;
import cn.com.kington.dao.system.AccessoryDAO;
import cn.com.kington.dao.system.SysDictDAO;
import cn.com.kington.utils.ResourceManager;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 产品管理ACTION
 * 
 * @author 杜永生
 * 
 */
public class ProductAction extends BaseActionSupport {
	/**
	 * 首页
	 */
	public String index(){
		if(vo==null){
			vo=new ProductSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=productDAO.findPage(vo);
		init();
		return Constants.INDEX;
	}
	
	/**
	 * 产品单项选择页面
	 */
	public String single(){
		index();
		return "single";
	}
	
	/**
	 * 产品多项选择
	 */
	public String multi(){
		if(vo==null){
			vo=new ProductSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=productDAO.findPage(vo);
		init();
		return Constants.MULTI;
	}
	
	/**
	 * 产品多项选择页面
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
			vo=productDAO.getSOById(id);
			initAccess();
			initMate();
			initWork();
		}
		init();
		return Constants.EDIT;
	}
	
	/**
	 * 详情
	 * @return
	 */
	public String details(){
		vo=productDAO.getSOById(id);
		initAccess();
		initMate();
		initWork();
		return Constants.DETAILS;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		if(id!=null){
			productDAO.deleteById(id);
		}
		return redirectSuccess("/basic/product/index.jhtml?rnd="+Math.random(), "数据删除成功");
	}
	
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		if(vo.getId()==null){
			String code=sysAppSequenceDAO.getYearSeqVal("Product", 5, "产品编号");
			vo.setCode(code);
		}
		
		Product po=productDAO.saveOrUpdate(vo);
		
		//保存物料明细
		if(mateIds!=null && mateIds.length>0){
			productDAO.deleteMates(po.getId());
			int index=0;
			for (Long mateId : mateIds) {
				ProductMaterial pm=new ProductMaterial();
				pm.setProId(po.getId());
				pm.setMateId(mateId);
				pm.setAmount(mateAmounts[index]);
				pm.setPrice(matePrices[index]);
				pm.setTotal(pm.getAmount()*pm.getPrice());
				pm.setName(mateNames[index]);
				pm.setCode(mateCodes[index]);
				pm.setUnit(mateUnits[index]);
				productMaterialDAO.save(pm);
				index++;
			}
		}
		
		//保存工序明细
		if(workIds!=null && workIds.length>0){
			productDAO.deleteWorks(po.getId());
			int index=0;
			for (Long workId : workIds) {
				ProductWork pw=new ProductWork();
				pw.setProduct(po);
				pw.setWorkId(workId);
				pw.setAmount(workAmounts[index]);
				pw.setPrice(workPrices[index]);
				pw.setTotal(pw.getAmount()*pw.getPrice());
				pw.setName(workNames[index]);
				pw.setCode(workCodes[index]);
				productWorkDAO.save(pw);
				index++;
			}
		}
		
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
					accessory.setDataId(po.getId());
					accessory.setSort(OrderState.JCXXGL_CPGL);
					accessory.setPath(path);
					accessory.setName(str);
					accessory.setUserid(user.getEmployee().getId());
					accessory.setRealname(user.getEmployee().getName());
					accessoryDAO.save(accessory);
				}
				index++;
			}
		}
		
		return redirectSuccess("/basic/product/index.jhtml?rnd="+Math.random(), "数据保存成功");
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave() {
		if (vo == null) {
			this.addFieldError("vo", "对象无效");
		} else {
			boolean check=false;
			if(StringUtils.isEmpty(vo.getName())){
				check=true;
				this.addFieldError("vo.name", "名称不能为空");
			}
			
			if(vo.getPrice()==null){
				check=true;
				this.addFieldError("vo.price", "价格不能为空");
			}
			
			if(vo.getType()==null){
				check=true;
				this.addFieldError("vo.type", "类型不能为空");
			}
			
			if(vo.getUnit()==null){
				check=true;
				this.addFieldError("vo.unit", "单位不能为空");
			}else{
				if(vo.getUnit().getId()==null){
					check=true;
					this.addFieldError("vo.unit.id", "单位不能为空");
				}
			}
			
			if(vo.getCategory()==null){
				check=true;
				this.addFieldError("vo.sort", "所属分类不能为空");
			}else{
				if(vo.getCategory().getId()==null){
					check=true;
					this.addFieldError("vo.sort.id", "所属分类不能为空");
				}
			}			
			
			if(check){
				init();
			}
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
		accSO.setSort(OrderState.JCXXGL_CPGL);
		accSO.setDataId(id);
		accessList=accessoryDAO.getList(accSO);
	}
	
	private void initMate(){
		ProductMaterialSO so=new ProductMaterialSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		so.setProId(id);
		mateList=productMaterialDAO.getList(so);
	}
	
	private void initWork(){
		Product p=new Product();
		p.setId(id);
		
		ProductWorkSO so=new ProductWorkSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		so.setProduct(p);
		workList=productWorkDAO.getList(so);
	}
	
	public ProductSO getVo() {
		return vo;
	}

	public void setVo(ProductSO vo) {
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

	public List<ProductMaterial> getMateList() {
		return mateList;
	}

	public void setMateList(List<ProductMaterial> mateList) {
		this.mateList = mateList;
	}

	public ProductType[] getTypes() {
		return types;
	}

	public void setTypes(ProductType[] types) {
		this.types = types;
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

	public Long[] getMateIds() {
		return mateIds;
	}

	public void setMateIds(Long[] mateIds) {
		this.mateIds = mateIds;
	}

	public String[] getMateNames() {
		return mateNames;
	}

	public void setMateNames(String[] mateNames) {
		this.mateNames = mateNames;
	}

	public String[] getMateCodes() {
		return mateCodes;
	}

	public void setMateCodes(String[] mateCodes) {
		this.mateCodes = mateCodes;
	}

	public Double[] getMateAmounts() {
		return mateAmounts;
	}

	public void setMateAmounts(Double[] mateAmounts) {
		this.mateAmounts = mateAmounts;
	}

	public Double[] getMatePrices() {
		return matePrices;
	}

	public void setMatePrices(Double[] matePrices) {
		this.matePrices = matePrices;
	}

	public String[] getMateUnits() {
		return mateUnits;
	}

	public void setMateUnits(String[] mateUnits) {
		this.mateUnits = mateUnits;
	}

	public List<ProductWork> getWorkList() {
		return workList;
	}

	public void setWorkList(List<ProductWork> workList) {
		this.workList = workList;
	}

	public Long[] getWorkIds() {
		return workIds;
	}

	public void setWorkIds(Long[] workIds) {
		this.workIds = workIds;
	}

	public String[] getWorkNames() {
		return workNames;
	}

	public void setWorkNames(String[] workNames) {
		this.workNames = workNames;
	}

	public String[] getWorkCodes() {
		return workCodes;
	}

	public void setWorkCodes(String[] workCodes) {
		this.workCodes = workCodes;
	}

	public Double[] getWorkAmounts() {
		return workAmounts;
	}

	public void setWorkAmounts(Double[] workAmounts) {
		this.workAmounts = workAmounts;
	}

	public Double[] getWorkPrices() {
		return workPrices;
	}

	public void setWorkPrices(Double[] workPrices) {
		this.workPrices = workPrices;
	}

	private ProductSO vo;
	private List<SysDict> units;
	private List<Accessory> accessList;
	private List<ProductMaterial> mateList;
	private List<ProductWork> workList;
	private ProductType[] types=ProductType.values();
	private File[] templets;
	private String[] templetsFileName;
	private Long[] mateIds;
	private String[] mateNames;
	private String[] mateCodes;
	private Double[] mateAmounts;
	private Double[] matePrices;
	private String[] mateUnits;
	private Long[] workIds;
	private String[] workNames;
	private String[] workCodes;
	private Double[] workAmounts;
	private Double[] workPrices;
	@Resource
	private ProductDAO productDAO;
	@Resource
	private SysDictDAO sysDictDAO;
	@Resource
	private AccessoryDAO accessoryDAO;
	@Resource
	private ProductMaterialDAO productMaterialDAO;
	@Resource
	private ProductWorkDAO productWorkDAO;
	@Resource
	private SysAppSequenceDAO sysAppSequenceDAO;
	public static final String RES_ARTICLE_PATH = "/resource/manual/product/";
	public static final String RES_PIC_PATH = "/resource/picture/product/";
	public static final Long MAXSIZE = 5 * 1024 * 1024L;;
	public static final String EXTENSION = "jpg,png,jpeg,gif,bmp";
	public static final String PICTUREEXTENSION="jpg,png,jpeg,gif,bmp";
	private static final long serialVersionUID = 1029640442002951751L;

}
