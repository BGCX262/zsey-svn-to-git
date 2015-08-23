package cn.com.kington.webapp.actions.sell.order;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.com.kington.bean.config.AuditMind;
import cn.com.kington.bean.sell.ProductPrice;
import cn.com.kington.bean.sell.ProductPriceList;
import cn.com.kington.bean.sell.ProductPriceListSO;
import cn.com.kington.bean.sell.ProductPriceSO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.AskStyle;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.PublicType.StateType;
import cn.com.kington.dao.sell.ProductPriceDAO;
import cn.com.kington.dao.sell.ProductPriceListDAO;
import cn.com.kington.utils.DateTools;
import cn.com.kington.webapp.actions.sell.OrderAction;

/**
 * ��Ʒ���۹���
 * 
 * @author Administrator
 * 
 */
public class ProductPriceAction extends OrderAction {
	/**
	 * ��ҳ
	 */
	public String index(){
		if(vo==null){
			vo=new ProductPriceSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=productPriceDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	
	/**
	 * �༭
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=productPriceDAO.getSOById(id);
			initDetails();
			initAccess(id, OrderState.XSGL_BJGL);
			setAuditList(getAuditMindList(id, OrderState.XSGL_BJGL_BJSH));
			setAskList(getAuditMindList(id, OrderState.XSGL_BJGL_BJQR));
		}
		return Constants.EDIT;
	}
	
	/**
	 * ��ת�����ɶ���ҳ��
	 * @return
	 */
	public String add(){
		if(id!=null){
			vo=productPriceDAO.getSOById(id);
			initDetails();
			initAccess(id,OrderState.XSGL_BJGL);
		}
		return Constants.ADD;
	}
	
	/**
	 * ����
	 * @return
	 */
	public String details(){
		if(id!=null){
			vo=productPriceDAO.getSOById(id);
			initDetails();
			initAccess(id,OrderState.XSGL_BJGL);
			setAuditList(getAuditMindList(id, OrderState.XSGL_BJGL_BJSH));
			setAskList(getAuditMindList(id, OrderState.XSGL_BJGL_BJQR));
		}
		return Constants.DETAILS;
	}
	
	/**
	 * ��ӡ
	 * @return
	 */
	public String print(){
		if(id!=null){
			vo=productPriceDAO.getSOById(id);
			initDetails();
		}
		return "print";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete(){
		if(id!=null){
			productPriceDAO.deleteById(id);
		}
		return redirectSuccess("/sell/order/product-price/index.jhtml", "����ɾ���ɹ�");
	}
	
	/**
	 * ���涩��
	 * @return
	 */
	public String save(){
		if(vo.getId()==null){
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
			vo.setCode(generateCode("BJ", "ProductPrice", "��Ʒ���۵���"));
			vo.setAddId(user.getId());
			vo.setAddName(user.getEmployee().getName());
			vo.setAddDate(DateTools.formatDate(new Date(), "yyyy-MM-dd"));
		}
		
		//���涩��
		vo.setNopay(vo.getPayment());
		vo.setAudit(StateType.AUDIT_WAIT);
		ProductPrice order=productPriceDAO.saveOrUpdate(vo);
		
		//���涩����ϸ
		if(getNames()!=null && getNames().length>0){
			productPriceDAO.deleteDetails(order.getId());
			int index=0;
			for (String  name : getNames()) {
				ProductPriceList list=new ProductPriceList();
				list.setOrder(order);
				list.setName(name);
				list.setProId(getProIds()[index]);
				list.setCode(getCodes()[index]);
				list.setSize(getSizes()[index].toUpperCase());
				list.setUnit(getUnits()[index].toUpperCase());
				list.setPrice(getPrices()[index]);
				list.setAmount(getAmounts()[index]);
				list.setTotal(list.getPrice()*list.getAmount());
				list.setRemark(getRemarks()[index]);
				productPriceListDAO.save(list);
				index++;
			}
			//�ϴ�����
			uploadAccess(order.getId(), OrderState.XSGL_BJGL);
		}
		return redirectSuccess("/sell/order/product-price/index.jhtml", "���ݱ���ɹ�");
	}
	
	/**
	 * ������֤
	 */
	public void validateSave(){
		boolean isok=false;
		if(vo==null){
			addFieldError("vo", "��Ч�Ķ���");
			isok=true;
		}else{
			if(StringUtils.isEmpty(vo.getName())){
				addFieldError("vo.name", "�ͻ����Ʋ���Ϊ��");
				isok=true;
			}
			
			if(StringUtils.isEmpty(vo.getPhone())){
				addFieldError("vo.phone", "�ͻ��绰����Ϊ��");
				isok=true;
			}
			
			if(StringUtils.isEmpty(vo.getAddress())){
				addFieldError("vo.phone", "�ͻ���ַ����Ϊ��");
				isok=true;
			}
			
		}
		if(isok){
			initDetails();
			initAccess(id, OrderState.XSGL_BJGL);
		}
		inputResult=Constants.EDIT;
	}
	
	public String submit(){
		if(id!=null){
			vo=productPriceDAO.getSOById(id);
			vo.setAudit(StateType.AUDIT_PRO);
			vo.setAsk(StateType.PRICE_PRO);
			productPriceDAO.saveOrUpdate(vo);
		}
		return redirectSuccess("/sell/order/product-price/index.jhtml", "���ݱ���ɹ�");
	}	
	/**
	 * ��ʼ��������ϸ
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

	public AskStyle[] getTypes() {
		return types;
	}

	public void setTypes(AskStyle[] types) {
		this.types = types;
	}

	private ProductPriceSO vo;
	private List<ProductPriceList> orderList;
	private List<AuditMind> auditList;
	private List<AuditMind> askList;
	private AskStyle[] types=AskStyle.values();
	@Resource
	private ProductPriceDAO productPriceDAO;
	@Resource
	private ProductPriceListDAO productPriceListDAO;
	private static final long serialVersionUID = 2632686749496827450L;

}
