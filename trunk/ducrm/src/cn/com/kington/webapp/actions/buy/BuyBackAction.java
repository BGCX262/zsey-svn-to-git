package cn.com.kington.webapp.actions.buy;

import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 采购退回ACTION
 * 
 * @author 杜永生
 * 
 */
public class BuyBackAction extends BaseActionSupport {
//	/**
//	 * 首页
//	 */
//	public String index(){
//		if(vo==null){
//			vo=new BuyOrderSO();
//		}
//		vo.setPageNumber(page);
//		vo.setObjectsPerPage(Constants.PAGE_SIZE);
//		vo.setState(OrderState.CGGL_WLCG_CGTH);
//		vo.setBackState(StateType.BACK_WAIT);
//		pageList=buyOrderDAO.findPage(vo);
//		return Constants.INDEX;
//	}
//	
//	/**
//	 * 添加
//	 * @return
//	 */
//	public String add(){
//		vo=buyOrderDAO.getSOById(id);
//		initDetails();
//		return Constants.ADD;
//	}
//	
//	/**
//	 * 审核编辑
//	 * @return
//	 */
//	public String edit(){
//		vo=buyOrderDAO.getSOById(id);
//		vo.setState(OrderState.CGGL_WLCG_CGTH);
//		vo.setBackState(StateType.BACK_WAIT);
//		initDetails();
//		
//		HttpSession session=ServletActionContext.getRequest().getSession();
//		SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
//		mindSO=new AuditMindSO();
//		mindSO.setDataId(id);
//		mindSO.setSort(OrderState.CGGL_WLCG_CGTH);
//		mindSO.setAuditDate(DateTools.formatDate(new Date(), "yyyy-MM-dd"));
//		mindSO.setRealname(user.getEmployee().getName());
//		auditList=auditMindDAO.getList(mindSO);
//		
//		return Constants.EDIT;
//	}
//	
//	
//	/**
//	 * 保存
//	 * @return
//	 */
//	public String save(){
//		vo.setState(OrderState.CGGL_WLCG_CGTH);
//		vo.setBackState(StateType.BACK_WAIT);
//		buyOrderDAO.saveOrUpdate(vo);
//		return redirectSuccess("/buy/buy-back/index.jhtml", "数据保存成功");
//	}
//	
//	/**
//	 * 审核保存
//	 * @return
//	 */
//	public String audit(){
//		//保存审核意见
//		mindSO.setSort(OrderState.CGGL_WLCG_CGTH);
//		mindSO.setDataId(vo.getId());
//		auditMindDAO.saveOrUpdate(mindSO);
//
//		// 保存订单
//		if (mindSO.getState().equals(StateType.AUDIT_YES)) {
//			vo.setBackState(StateType.BACK_YES);
//			vo.setInState(StateType.IN_NO);
//			vo.setState(OrderState.CGGL_WLCG_CGTH);
//		} else {
//			vo.setBackState(StateType.BACK_NO);
//			vo.setInState(StateType.IN_WAIT);
//			vo.setState(OrderState.CGGL_WLCG_CGRK);
//		}
//		
//		buyOrderDAO.saveOrUpdate(vo);
//		return redirectSuccess("/buy/buy-back/index.jhtml", "数据保存成功");
//	}
//	
//	/**
//	 * 保存验证
//	 */
//	public void validateSave(){
//		boolean isok=false;
//		if(vo==null){
//			addFieldError("对象无效", "vo");
//			isok=true;
//		}else{
//			if(StringUtils.isEmpty(vo.getCause())){
//				addFieldError("vo.cause", "退回原因不能为空");
//				isok=true;
//			}
//		}
//		
//		if(isok){
//			initDetails();
//		}
//		inputResult=Constants.EDIT;
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
//	private BuyOrderDAO buyOrderDAO;
//	@Resource
//	private BuyOrderListDAO buyOrderListDAO;
//	@Resource
//	private AuditMindDAO auditMindDAO;
	private static final long serialVersionUID = 7494253969677420291L;
}
