package cn.com.kington.webapp.actions.buy;

import cn.com.kington.webapp.actions.sell.OrderAction;

/**
 * 物料采购ACTION
 * 
 * @author 杜永生
 * 
 */
public class BuyOrderAction extends OrderAction {
//	/**
//	 * 首页
//	 */
//	public String index(){
//		if(vo==null){
//			vo=new BuyOrderSO();
//		}
//		vo.setPageNumber(page);
//		vo.setObjectsPerPage(Constants.PAGE_SIZE);
//		pageList=buyOrderDAO.findPage(vo);
//		return Constants.INDEX;
//	}
//	
//	/**
//	 * 编辑
//	 * @return
//	 */
//	public String edit(){
//		if(id!=null){
//			vo=buyOrderDAO.getSOById(id);
//			initDetails();
//			auditList=getAuditMindList(id, OrderState.CGGL_WLCG);
//			initAccess(id, OrderState.CGGL_WLCG);
//		}
//		return Constants.EDIT;
//	}
//	
//	/**
//	 * 详情
//	 * @return
//	 */
//	public String details(){
//		if(id!=null){
//			vo=buyOrderDAO.getSOById(id);
//			initDetails();
//			auditList=getAuditMindList(id, OrderState.CGGL_WLCG);
//			initAccess(id, OrderState.CGGL_WLCG);
//		}
//		return Constants.DETAILS;
//	}
//	
//	/**
//	 * 打印
//	 * @return
//	 */
//	public String print(){
//		if(id!=null){
//			vo=buyOrderDAO.getSOById(id);
//			initDetails();
//			auditList=getAuditMindList(id, OrderState.CGGL_WLCG);
//		}
//		return "print";
//	}
//	
//	/**
//	 * 保存
//	 * @return
//	 */
//	public String save(){
//		if(id==null){
//			HttpSession session=ServletActionContext.getRequest().getSession();
//			SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
//			vo.setAddId(user.getId());
//			vo.setAddName(user.getEmployee().getName());
//			vo.setAddDate(DateTools.formatDate(new Date(), "yyyy-MM-dd"));
//			vo.setCode(generateCode("CG", "BuyOrder", "采购单编号"));
//			
//			if(vo.getState()==null){
//				vo.setState(OrderState.CGGL_WLCG_CGSQ);
//			}
//		}
//		vo.setAuditState(StateType.AUDIT_WAIT);
//		
//		BuyOrder order=buyOrderDAO.saveOrUpdate(vo);
//		
//		if(getNames()!=null && getNames().length>0){
//			buyOrderDAO.deleteList(vo);
//			int index=0;
//			for (String name : getNames()) {
//				BuyOrderList list=new BuyOrderList();
//				list.setOrder(order);
//				list.setName(name);
//				list.setMateId(getMateIds()[index]);
//				list.setAmount(getAmounts()[index]);
//				list.setInAmount(0.0);
//				list.setUnit(getUnits()[index]);
//				list.setSpec(getSpecs()[index]);
//				list.setPrice(getPrices()[index]);
//				list.setRemark(getRemarks()[index]);
//				buyOrderListDAO.save(list);
//				index++;
//			}
//		}
//		
//		return redirectSuccess("/buy/buy-order/index.jhtml", "数据保存成功");
//	}
//	
//	public void validateSave(){
//		if(vo==null){
//			addFieldError("对象无效", "vo");
//		}else{
//			if(StringUtils.isEmpty(vo.getName())){
//				addFieldError("vo.name", "供应商名称不能为空");
//			}
//			
//			if(StringUtils.isEmpty(vo.getPhone())){
//				addFieldError("vo.phone", "供应商电话不能为空");
//			}
//			
//			if(StringUtils.isEmpty(vo.getAddress())){
//				addFieldError("vo.address", "供应商地址不能为空");
//			}
//			
//			if(StringUtils.isEmpty(vo.getLinkman())){
//				addFieldError("vo.linkman", "联系人不能为空");
//			}
//			
//		}
//		inputResult=Constants.EDIT;
//	}
//	
//	/**
//	 * 删除
//	 * @return
//	 */
//	public String delete(){
//		if(id!=null){
//			buyOrderDAO.deleteById(id);
//		}
//		return redirectSuccess("/buy/buy-order/index.jhtml?rnd="+Math.random(), "数据删除成功");
//	}
//	
//	/**
//	 * 初始化采购明细和审核记录
//	 */
//	private void initDetails(){
//		//采购明细
//		BuyOrder order=new BuyOrder();
//		order.setId(id);
//		BuyOrderListSO so=new BuyOrderListSO();
//		so.setOrder(order);
//		so.setPageNumber(1);
//		so.setObjectsPerPage(Integer.MAX_VALUE);
//		orderList=buyOrderListDAO.getList(so);
//	}
//	
//	public BuyOrderSO getVo() {
//		return vo;
//	}
//
//	public void setVo(BuyOrderSO vo) {
//		this.vo = vo;
//	}
//
//	public List<BuyOrderList> getOrderList() {
//		return orderList;
//	}
//
//	public void setOrderList(List<BuyOrderList> orderList) {
//		this.orderList = orderList;
//	}
//
//	public List<AuditMind> getAuditList() {
//		return auditList;
//	}
//
//	public void setAuditList(List<AuditMind> auditList) {
//		this.auditList = auditList;
//	}
//	
//	private BuyOrderSO vo;
//	private List<BuyOrderList> orderList;
//	private List<AuditMind> auditList;
//	@Resource
//	private BuyOrderDAO buyOrderDAO;
//	@Resource
//	private BuyOrderListDAO buyOrderListDAO;
	private static final long serialVersionUID = -2832815650494978767L;
}
