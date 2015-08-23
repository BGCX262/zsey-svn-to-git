package cn.com.kington.webapp.actions.produce;

import java.util.List;

import javax.annotation.Resource;

import cn.com.kington.bean.sell.SellOrder;
import cn.com.kington.bean.sell.SellOrderList;
import cn.com.kington.bean.sell.SellOrderListSO;
import cn.com.kington.bean.sell.SellOrderSO;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.OrderState;
import cn.com.kington.common.PublicType.StateType;
import cn.com.kington.dao.sell.SellOrderDAO;
import cn.com.kington.dao.sell.SellOrderListDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 订单生产
 * 
 * @author 杜永生
 * 
 */
public class OrderMakeAction extends BaseActionSupport {
	/**
	 * 首页
	 */
	public String index(){
		if(vo==null){
			vo=new SellOrderSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
//		vo.setState(OrderState.SCGL_DDSC);
//		vo.setSignState(StateType.SIGN_OK);
//		vo.setAuditState(StateType.AUDIT_YES);
		pageList=sellOrderDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=sellOrderDAO.getSOById(id);
			initDetails();
		}
		return Constants.EDIT;
	}
	
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		sellOrderDAO.saveOrUpdate(vo);
		return redirectSuccess("/produce/order-make/index.jhtml", "数据保存成功");
	}
	
	private void initDetails(){
		SellOrder order=new SellOrder();
		order.setId(id);
		SellOrderListSO so=new SellOrderListSO();
		so.setOrder(order);
		orderList=sellOrderListDAO.getList(so);
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

//	public StateType[] getStates() {
//		return states;
//	}
//
//	public void setStates(StateType[] states) {
//		this.states = states;
//	}

	private SellOrderSO vo;
	private List<SellOrderList> orderList;
//	private StateType[] states = { StateType.MAKE_WAIT, StateType.MAKE_YES,
//			StateType.MAKE_NO, StateType.MAKE_PROCESS, StateType.MAKE_OK };
	@Resource
	private SellOrderDAO sellOrderDAO;
	@Resource
	private SellOrderListDAO sellOrderListDAO;
	private static final long serialVersionUID = -8418854057905969566L;

}
