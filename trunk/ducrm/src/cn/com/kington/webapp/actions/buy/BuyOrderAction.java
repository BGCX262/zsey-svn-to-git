package cn.com.kington.webapp.actions.buy;

import cn.com.kington.webapp.actions.sell.OrderAction;

/**
 * ���ϲɹ�ACTION
 * 
 * @author ������
 * 
 */
public class BuyOrderAction extends OrderAction {
//	/**
//	 * ��ҳ
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
//	 * �༭
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
//	 * ����
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
//	 * ��ӡ
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
//	 * ����
//	 * @return
//	 */
//	public String save(){
//		if(id==null){
//			HttpSession session=ServletActionContext.getRequest().getSession();
//			SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
//			vo.setAddId(user.getId());
//			vo.setAddName(user.getEmployee().getName());
//			vo.setAddDate(DateTools.formatDate(new Date(), "yyyy-MM-dd"));
//			vo.setCode(generateCode("CG", "BuyOrder", "�ɹ������"));
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
//		return redirectSuccess("/buy/buy-order/index.jhtml", "���ݱ���ɹ�");
//	}
//	
//	public void validateSave(){
//		if(vo==null){
//			addFieldError("������Ч", "vo");
//		}else{
//			if(StringUtils.isEmpty(vo.getName())){
//				addFieldError("vo.name", "��Ӧ�����Ʋ���Ϊ��");
//			}
//			
//			if(StringUtils.isEmpty(vo.getPhone())){
//				addFieldError("vo.phone", "��Ӧ�̵绰����Ϊ��");
//			}
//			
//			if(StringUtils.isEmpty(vo.getAddress())){
//				addFieldError("vo.address", "��Ӧ�̵�ַ����Ϊ��");
//			}
//			
//			if(StringUtils.isEmpty(vo.getLinkman())){
//				addFieldError("vo.linkman", "��ϵ�˲���Ϊ��");
//			}
//			
//		}
//		inputResult=Constants.EDIT;
//	}
//	
//	/**
//	 * ɾ��
//	 * @return
//	 */
//	public String delete(){
//		if(id!=null){
//			buyOrderDAO.deleteById(id);
//		}
//		return redirectSuccess("/buy/buy-order/index.jhtml?rnd="+Math.random(), "����ɾ���ɹ�");
//	}
//	
//	/**
//	 * ��ʼ���ɹ���ϸ����˼�¼
//	 */
//	private void initDetails(){
//		//�ɹ���ϸ
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
