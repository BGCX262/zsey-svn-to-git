package cn.com.kington.webapp.actions.buy;

import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * �ɹ����ACTION
 * 
 * @author ������
 * 
 */
public class BuyOrderAuditAction extends BaseActionSupport {
//	/**
//	 * ��ҳ
//	 */
//	public String index(){
//		if(vo==null){
//			vo=new BuyOrderSO();
//		}
//		vo.setPageNumber(page);
//		vo.setAuditState(StateType.AUDIT_WAIT);
//		vo.setState(OrderState.CGGL_WLCG_CGSH);
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
//		vo = buyOrderDAO.getSOById(id);
//		HttpSession session=ServletActionContext.getRequest().getSession();
//		SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
//		mindSO=new AuditMindSO();
//		mindSO.setDataId(id);
//		mindSO.setSort(OrderState.CGGL_WLCG);
//		mindSO.setAuditDate(DateTools.formatDate(new Date(), "yyyy-MM-dd"));
//		mindSO.setRealname(user.getEmployee().getName());
//		initDetails();
//		
//		//��˼�¼
//		auditList=auditMindDAO.getList(mindSO);
//		return Constants.EDIT;
//	}
//	
//	/**
//	 * ����
//	 * @return
//	 */
//	public String save(){
//		//����������
//		mindSO.setSort(OrderState.CGGL_WLCG);
//		mindSO.setDataId(vo.getId());
//		auditMindDAO.saveOrUpdate(mindSO);
//		
//		HttpSession session=ServletActionContext.getRequest().getSession();
//		SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
//		
//		vo.setAuditId(user.getId());
//		vo.setAuditName(user.getEmployee().getName());
//		vo.setAuditDate(DateTools.formatDate(new Date(), "yyyy-MM-dd"));
//
//		// ���涩��
//		if (mindSO.getState().equals(StateType.AUDIT_YES)) {
//			vo.setAuditState(StateType.AUDIT_YES);// ���״̬
//			vo.setState(OrderState.CGGL_WLCG_CGRK);
//			vo.setInState(StateType.IN_WAIT);
//			vo.setBalanceState(StateType.BALANCE_WAIT);
//			
//		} else {
//			vo.setAuditState(StateType.AUDIT_NO);// ���״̬
//			vo.setState(OrderState.CGGL_WLCG_CGSQ);
//		}
//		buyOrderDAO.saveOrUpdate(vo);
//		
//		return redirectSuccess("/buy/buy-order-audit/index.jhtml", "���ݱ���ɹ�");
//	}
//	
//	/**
//	 * ������֤
//	 */
//	public void validateSave(){
//		if(vo==null){
//			addFieldError("������Ч", "vo");
//		}
//		inputResult=Constants.EDIT;
//	}
//	
//	/**
//	 * ��ʼ���ɹ���ϸ
//	 */
//	private void initDetails(){
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
//	public StateType[] getStates() {
//		return states;
//	}
//
//	public void setStates(StateType[] states) {
//		this.states = states;
//	}
//	
//	public AuditMindSO getMindSO() {
//		return mindSO;
//	}
//
//	public void setMindSO(AuditMindSO mindSO) {
//		this.mindSO = mindSO;
//	}
//	
//	private BuyOrderSO vo;
//	private AuditMindSO mindSO;
//	private List<BuyOrderList> orderList;
//	private List<AuditMind> auditList;
//	private StateType[] states={StateType.AUDIT_YES,StateType.AUDIT_NO};
//	@Resource
//	private AuditMindDAO auditMindDAO;
//	@Resource
//	private BuyOrderDAO buyOrderDAO;
//	@Resource
//	private BuyOrderListDAO buyOrderListDAO;
//	private static final long serialVersionUID = 4487473641127157151L;
}
