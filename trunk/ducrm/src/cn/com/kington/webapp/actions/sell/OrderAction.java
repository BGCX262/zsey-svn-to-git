package cn.com.kington.webapp.actions.sell;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.com.kington.bean.config.AuditMind;
import cn.com.kington.bean.config.AuditMindSO;
import cn.com.kington.bean.model.Accessory;
import cn.com.kington.bean.model.AccessorySO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.OrderGrade;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.dao.SysAppSequenceDAO;
import cn.com.kington.dao.config.AuditMindDAO;
import cn.com.kington.dao.system.AccessoryDAO;
import cn.com.kington.utils.ResourceManager;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 订单管理ACTION基类
 * @author 杜永生
 *
 */
public class OrderAction extends BaseActionSupport {
	/**
	 * 初始化附件明细
	 * @param sort
	 */
	public void initAccess(Long id, OrderState sort){
		AccessorySO accSO=new AccessorySO();
		accSO.setPageNumber(1);
		accSO.setObjectsPerPage(Integer.MAX_VALUE);
		accSO.setSort(sort);
		accSO.setDataId(id);
		accessList=accessoryDAO.getList(accSO);
	}
	
	/**
	 * 获取审核日志
	 * @param id
	 * @param sort
	 * @return
	 */
	public List<AuditMind> getAuditMindList(Long id,OrderState sort){
		AuditMindSO so=new AuditMindSO();
		so.setSort(sort);
		so.setDataId(id);
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		return auditMindDAO.getList(so);
	}
	
	/**
	 * 生成5位数的订单编号
	 * @param prefix：前缀
	 * @param name：名字
	 * @param caption：备注
	 * @return
	 */
	public String generateCode(String prefix, String name, String caption){
		String code=prefix+sysAppSequenceDAO.getPrefixSeqVal(name, 5, caption);
		return code;
	}
	
	/**
	 * 上传附件
	 * @param id
	 * @param sort
	 */
	public void uploadAccess(Long id, OrderState sort){
		if(templetsFileName!=null && templetsFileName.length>0){
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
			
			int index=0;
			for (String str : templetsFileName) {
				if(StringUtils.isNotEmpty(str)){
					String path=ResourceManager.addResource(RES_ARTICLE_PATH, templets[index],str).getFilepath();
					Accessory accessory=new Accessory();
					accessory.setDataId(id);
					accessory.setSort(sort);
					accessory.setPath(path);
					accessory.setName(str);
					accessory.setUserid(user.getEmployee().getId());
					accessory.setRealname(user.getEmployee().getName());
					accessoryDAO.save(accessory);
				}
				index++;
			}
		}
	}
	
	public List<Accessory> getAccessList() {
		return accessList;
	}

	public void setAccessList(List<Accessory> accessList) {
		this.accessList = accessList;
	}
	
	public Long[] getProIds() {
		return proIds;
	}

	public void setProIds(Long[] proIds) {
		this.proIds = proIds;
	}

	public String[] getCodes() {
		return codes;
	}

	public void setCodes(String[] codes) {
		this.codes = codes;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String[] getSizes() {
		return sizes;
	}

	public void setSizes(String[] sizes) {
		this.sizes = sizes;
	}

	public Double[] getPrices() {
		return prices;
	}

	public void setPrices(Double[] prices) {
		this.prices = prices;
	}

	public String[] getUnits() {
		return units;
	}

	public void setUnits(String[] units) {
		this.units = units;
	}

	public Double[] getAmounts() {
		return amounts;
	}

	public void setAmounts(Double[] amounts) {
		this.amounts = amounts;
	}

	public String[] getRemarks() {
		return remarks;
	}

	public void setRemarks(String[] remarks) {
		this.remarks = remarks;
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
	
	public OrderGrade[] getGrades() {
		return grades;
	}

	public void setGrades(OrderGrade[] grades) {
		this.grades = grades;
	}
	
	public Long[] getMateIds() {
		return mateIds;
	}

	public void setMateIds(Long[] mateIds) {
		this.mateIds = mateIds;
	}

	public String[] getSpecs() {
		return specs;
	}

	public void setSpecs(String[] specs) {
		this.specs = specs;
	}

	private List<Accessory> accessList;
	private OrderGrade[] grades=OrderGrade.values();
	private Long[] mateIds;// 物料ID
	private Long[] proIds;// 产品ID
	private String[] codes;// 产品编号
	private String[] names;// 产品名称
	private String[] sizes;// 码数
	private String[] specs;// 规格
	private Double[] prices;// 单价
	private String[] units;// 单位
	private Double[] amounts;// 数量
	private String[] remarks;// 备注
	private File[] templets;
	private String[] templetsFileName;
	@Resource
	private AccessoryDAO accessoryDAO;
	@Resource
	private AuditMindDAO auditMindDAO;
	@Resource
	private SysAppSequenceDAO sysAppSequenceDAO;
	public static final String RES_ARTICLE_PATH = "/resource/manual/sell/";
	public static final String RES_PIC_PATH = "/resource/picture/sell/";
	public static final Long MAXSIZE = 10 * 1024 * 1024L;;
	public static final String EXTENSION = "jpg,png,jpeg,gif,bmp,docx,doc,xlsx,xls,pptx,ppt,dps,et,wps,txt,pdf,zip,rar";
	public static final String PICTUREEXTENSION="jpg,png,jpeg,gif,bmp,docx,doc,xlsx,xls,pptx,ppt,dps,et,wps,txt,pdf,zip,rar";
	private static final long serialVersionUID = 6919578247720918186L;
}
