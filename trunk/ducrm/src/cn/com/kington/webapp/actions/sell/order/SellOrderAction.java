package cn.com.kington.webapp.actions.sell.order;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.com.kington.bean.sell.SellOrder;
import cn.com.kington.bean.sell.SellOrderList;
import cn.com.kington.bean.sell.SellOrderListSO;
import cn.com.kington.bean.sell.SellOrderSO;
import cn.com.kington.bean.system.SysUser;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.OrderSort;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.PublicType.StateType;
import cn.com.kington.dao.sell.SellOrderDAO;
import cn.com.kington.dao.sell.SellOrderListDAO;
import cn.com.kington.utils.DateTools;
import cn.com.kington.webapp.actions.sell.OrderAction;

/**
 * ������Ŀ��������
 * @author ������
 *
 */
public class SellOrderAction extends OrderAction {
	/**
	 * ��ҳ
	 */
	public String index(){
		if(vo==null){
			vo=new SellOrderSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=sellOrderDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	/**
	 * �༭
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=sellOrderDAO.getSOById(id);
			initDetails();
			initAccess(id, OrderState.XSGL_DDGL);
		}
		return Constants.EDIT;
	}
	
	/**
	 * ����
	 * @return
	 */
	public String details(){
		if(id!=null){
			vo=sellOrderDAO.getSOById(id);
			initDetails();
			initAccess(id,OrderState.XSGL_DDGL);
		}
		return Constants.DETAILS;
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete(){
		if(id!=null){
			sellOrderDAO.deleteById(id);
		}
		return redirectSuccess("/sell/order/sell-order/index.jhtml", "����ɾ���ɹ�");
	}
	
	/**
	 * ���涩��
	 * @return
	 */
	public String save(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
		
		if(vo.getId()==null){
			vo.setCode(generateCode("DD", "SellOrder", "�������"));
			vo.setAddId(user.getId());
			vo.setAddName(user.getEmployee().getName());
			vo.setAddDate(DateTools.formatDate(new Date(), "yyyy-MM-dd"));
			vo.setSort(OrderSort.SELL);
		}
		
		//���涩��
		vo.setAudit(StateType.AUDIT_WAIT);
		SellOrder order=sellOrderDAO.saveOrUpdate(vo);
		
		//���涩����ϸ
		if(getNames()!=null && getNames().length>0){
			sellOrderDAO.deleteDetails(order.getId());
			int index=0;
			for (String  name : getNames()) {
				SellOrderList list=new SellOrderList();
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
				sellOrderListDAO.save(list);
				index++;
			}
			//�ϴ�����
			uploadAccess(order.getId(), OrderState.XSGL_DDGL);
		}
		return redirectSuccess("/sell/order/sell-order/index.jhtml", "���ݱ���ɹ�");
	}
	
	/**
	 * �ύ
	 * @return
	 */
	public String submit(){
		if(id!=null){
			vo=sellOrderDAO.getSOById(id);
			vo.setAudit(StateType.AUDIT_PRO);
			vo.setMake(StateType.MAKE_WAIT);
			sellOrderDAO.saveOrUpdate(vo);
		}
		return redirectSuccess("/sell/order/sell-order/index.jhtml", "���ݱ���ɹ�");
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
			initAccess(id, OrderState.XSGL_DDGL);
		}
		inputResult=Constants.EDIT;
	}
	
	/**
	 * ��ʼ��������ϸ
	 */
	private void initDetails(){
		SellOrderListSO listSO=new SellOrderListSO();
		listSO.setPageNumber(1);
		listSO.setObjectsPerPage(Integer.MAX_VALUE);
		SellOrder order=new SellOrder();
		order.setId(id);
		listSO.setOrder(order);
		orderList=sellOrderListDAO.getList(listSO);
	}
	
	public SellOrderSO getVo() {
		return vo;
	}

	public void setVo(SellOrderSO vo) {
		this.vo = vo;
	}

	public List<SellOrderList> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<SellOrderList> orderList) {
		this.orderList = orderList;
	}

	private SellOrderSO vo;
	private List<SellOrderList> orderList;
	@Resource
	private SellOrderDAO sellOrderDAO;
	@Resource
	private SellOrderListDAO sellOrderListDAO;
	private static final long serialVersionUID = 7215081674398551994L;
}
