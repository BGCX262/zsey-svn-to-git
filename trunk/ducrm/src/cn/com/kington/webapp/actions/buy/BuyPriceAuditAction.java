package cn.com.kington.webapp.actions.buy;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.com.kington.bean.buy.BuyPrice;
import cn.com.kington.bean.buy.BuyPriceList;
import cn.com.kington.bean.buy.BuyPriceListSO;
import cn.com.kington.bean.buy.BuyPriceSO;
import cn.com.kington.bean.model.Accessory;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.PublicType.StateType;
import cn.com.kington.dao.buy.BuyPriceDAO;
import cn.com.kington.dao.buy.BuyPriceListDAO;
import cn.com.kington.utils.ResourceManager;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 询价审核ACTION
 * 
 * @author 杜永生
 * 
 */
public class BuyPriceAuditAction extends BaseActionSupport {
	
//	/**
//	 * 首页
//	 */
//	public String index(){
//		if(vo==null){
//			vo=new BuyPriceSO();
//		}
//		vo.setPageNumber(page);
//		vo.setAuditState(StateType.ASK_WAIT);
//		vo.setState(OrderState.CGGL_WLZX_XJQR);
//		vo.setObjectsPerPage(Constants.PAGE_SIZE);
//		pageList=buyPriceDAO.findPage(vo);
//		return Constants.INDEX;
//	}
//	
//	/**
//	 * 编辑
//	 * @return
//	 */
//	public String edit(){
//		if(id!=null){
//			vo=buyPriceDAO.getSOById(id);
//			initDetails();
//		}
//		return Constants.EDIT;
//	}
//	
//	/**
//	 * 保存
//	 * @return
//	 */
//	public String save(){
//		vo.setAuditState(StateType.ASK_OK);
//		vo.setState(OrderState.CGGL_WLZX_XJGL);
//		buyPriceDAO.saveOrUpdate(vo);
//		
//		if(ids!=null && ids.length>0){
//			int index=0;
//			for (Long  listId: ids) {
//				BuyPriceList list=buyPriceListDAO.findById(listId);
//				list.setPrice(prices[index]);
//				list.setRemark(remarks[index]);
//				buyPriceListDAO.save(list);
//				index++;
//			}
//		}
//		
//		if(StringUtils.isNotEmpty(uploadImageFileName)){
//			HttpSession session=ServletActionContext.getRequest().getSession();
//			SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
//			String path=ResourceManager.addResource(RES_ARTICLE_PATH, uploadImage,uploadImageFileName).getFilepath();
//			
//			Accessory accessory=new Accessory();
//			accessory.setDataId(vo.getId());
//			accessory.setSort(OrderState.CGGL_WLZX);
//			accessory.setPath(path);
//			accessory.setName(uploadImageFileName);
//			accessory.setUserid(user.getEmployee().getId());
//			accessory.setRealname(user.getEmployee().getName());
//			buyPriceDAO.save(accessory);
//		}
//		
//		return redirectSuccess("/buy/buy-price-audit/index.jhtml", "数据保存成功");
//	}
//	
//	/**
//	 * 保存验证
//	 */
//	public void validateSave(){
//		if(vo==null){
//			addFieldError("对象无效", "vo");
//		}
//		inputResult=Constants.EDIT;
//	}
//	
//	/**
//	 * 初始化询价明细
//	 */
//	private void initDetails(){
//		BuyPrice order=new BuyPrice();
//		order.setId(id);
//		BuyPriceListSO so=new BuyPriceListSO();
//		so.setOrder(order);
//		so.setPageNumber(1);
//		so.setObjectsPerPage(Integer.MAX_VALUE);
//		orderList=buyPriceListDAO.getList(so);
//	}
//	
//	public BuyPriceSO getVo() {
//		return vo;
//	}
//
//	public void setVo(BuyPriceSO vo) {
//		this.vo = vo;
//	}
//	
//	public File getUploadImage() {
//		return uploadImage;
//	}
//
//	public void setUploadImage(File uploadImage) {
//		this.uploadImage = uploadImage;
//	}
//
//	public String getUploadImageFileName() {
//		return uploadImageFileName;
//	}
//
//	public void setUploadImageFileName(String uploadImageFileName) {
//		this.uploadImageFileName = uploadImageFileName;
//	}
//	
//	public List<BuyPriceList> getOrderList() {
//		return orderList;
//	}
//
//	public void setOrderList(List<BuyPriceList> orderList) {
//		this.orderList = orderList;
//	}
//
//	public Double[] getPrices() {
//		return prices;
//	}
//
//	public void setPrices(Double[] prices) {
//		this.prices = prices;
//	}
//
//	public String[] getRemarks() {
//		return remarks;
//	}
//
//	public void setRemarks(String[] remarks) {
//		this.remarks = remarks;
//	}
//	
//	private BuyPriceSO vo;
//	private File uploadImage;
//	private String uploadImageFileName;
//	private List<BuyPriceList> orderList;
//	private Double[] prices;// 单价
//	private String[] remarks;// 备注
//	@Resource
//	private BuyPriceDAO buyPriceDAO;
//	@Resource
//	private BuyPriceListDAO buyPriceListDAO;
//	public static final String RES_ARTICLE_PATH = "/resource/manual/BuyPrice/";
//	public static final String RES_PIC_PATH = "/resource/picture/BuyPrice/";
//	public static final Long MAXSIZE = 10 * 1024 * 1024L;;
//	public static final String EXTENSION = "jpg,png,jpeg,gif,bmp,docx,doc,xlsx,xls,pptx,ppt,dps,et,wps,txt,pdf,zip,rar";
//	public static final String PICTUREEXTENSION="jpg,png,jpeg,gif,bmp,docx,doc,xlsx,xls,pptx,ppt,dps,et,wps,txt,pdf,zip,rar";
	private static final long serialVersionUID = -8315168942571050915L;
}
