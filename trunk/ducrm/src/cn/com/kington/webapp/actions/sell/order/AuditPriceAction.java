package cn.com.kington.webapp.actions.sell.order;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.com.kington.bean.config.AuditMind;
import cn.com.kington.bean.config.AuditMindSO;
import cn.com.kington.bean.sell.ProductPrice;
import cn.com.kington.bean.sell.ProductPriceList;
import cn.com.kington.bean.sell.ProductPriceListSO;
import cn.com.kington.bean.sell.ProductPriceSO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.PublicType.StateType;
import cn.com.kington.dao.config.AuditMindDAO;
import cn.com.kington.dao.sell.ProductPriceDAO;
import cn.com.kington.dao.sell.ProductPriceListDAO;
import cn.com.kington.utils.DateTools;
import cn.com.kington.webapp.actions.sell.OrderAction;

/**
 * 产品报价管理
 * 
 * @author Administrator
 * 
 */
public class AuditPriceAction extends OrderAction {
	/**
	 * 首页
	 */
	public String index(){
		if(vo==null){
			vo=new ProductPriceSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		vo.setAudit(StateType.AUDIT_PRO);
		pageList=productPriceDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=productPriceDAO.getSOById(id);
			
			HttpSession session=ServletActionContext.getRequest().getSession();
			SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
			mindSO=new AuditMindSO();
			mindSO.setDataId(id);
			mindSO.setSort(OrderState.XSGL_BJGL_BJSH);
			mindSO.setAuditDate(DateTools.formatDate(new Date(), "yyyy-MM-dd"));
			mindSO.setRealname(user.getEmployee().getName());
			
			initDetails();
			setAuditList(getAuditMindList(id, OrderState.XSGL_BJGL_BJSH));
			setAskList(getAuditMindList(id, OrderState.XSGL_BJGL_BJQR));
		}
		return Constants.EDIT;
	}
	
	
	/**
	 * 保存订单
	 * @return
	 */
	public String save(){
		//保存审核意见
		mindSO.setSort(OrderState.XSGL_BJGL_BJSH);
		mindSO.setDataId(vo.getId());
		auditMindDAO.saveOrUpdate(mindSO);

		if (mindSO.getState().equals(StateType.AUDIT_YES)) {
			vo.setAudit(StateType.PRICE_YES);
		} else {
			vo.setAudit(StateType.AUDIT_WAIT);
		}
		productPriceDAO.saveOrUpdate(vo);
		
		return redirectSuccess("/sell/order/audit-price/index.jhtml", "数据保存成功");
		
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave(){
		if(vo==null){
			addFieldError("vo", "无效的对象");
		}
		inputResult=Constants.EDIT;
	}
	
	/**
	 * 初始化订单明细
	 */
	private void initDetails(){
		ProductPriceListSO listSO=new ProductPriceListSO();
		listSO.setPageNumber(1);
		listSO.setObjectsPerPage(Integer.MAX_VALUE);
		ProductPrice order=new ProductPrice();
		order.setId(id);
		listSO.setOrder(order);
		orderList=productPriceListDAO.getList(listSO);
	}

	public ProductPriceSO getVo() {
		return vo;
	}

	public void setVo(ProductPriceSO vo) {
		this.vo = vo;
	}

	public List<ProductPriceList> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ProductPriceList> orderList) {
		this.orderList = orderList;
	}

	public List<AuditMind> getAuditList() {
		return auditList;
	}

	public void setAuditList(List<AuditMind> auditList) {
		this.auditList = auditList;
	}

	public List<AuditMind> getAskList() {
		return askList;
	}

	public void setAskList(List<AuditMind> askList) {
		this.askList = askList;
	}

	public AuditMindSO getMindSO() {
		return mindSO;
	}

	public void setMindSO(AuditMindSO mindSO) {
		this.mindSO = mindSO;
	}

	public StateType[] getStates() {
		return states;
	}

	public void setStates(StateType[] states) {
		this.states = states;
	}

	private AuditMindSO mindSO;
	private ProductPriceSO vo;
	private List<ProductPriceList> orderList;
	private List<AuditMind> auditList;
	private List<AuditMind> askList;
	private StateType[] states={StateType.AUDIT_YES,StateType.AUDIT_NO};
	@Resource
	private ProductPriceDAO productPriceDAO;
	@Resource
	private ProductPriceListDAO productPriceListDAO;
	@Resource
	private AuditMindDAO auditMindDAO;
	private static final long serialVersionUID = 2632686749496827450L;

}
