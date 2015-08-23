package cn.com.kington.webapp.actions.buy;

import cn.com.kington.webapp.actions.sell.OrderAction;

/**
 * 采购询价ACTION
 * 
 * @author 杜永生
 * 
 */
public class BuyPriceAction extends OrderAction {
//	/**
//	 * 首页
//	 */
//	public String index(){
//		if(vo==null){
//			vo=new BuyPriceSO();
//		}
//		vo.setPageNumber(page);
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
//			vo=buyPriceDAO.getSOById(id);
//			initDetails();
//			initAccess(id, OrderState.CGGL_WLCG);
//		}
//		return Constants.DETAILS;
//	}
//	
//	/**
//	 * 生成采购单
//	 * @return
//	 */
//	public String add(){
//		if(id!=null){
//			vo=buyPriceDAO.getSOById(id);
//			initDetails();
//		}
//		return Constants.ADD;
//	}
//	
//	/**
//	 * 打印
//	 * @return
//	 */
//	public String print(){
//		if(id!=null){
//			vo=buyPriceDAO.getSOById(id);
//			initDetails();
//		}
//		return "print";
//	}
//	
//	/**
//	 * 保存
//	 * @return
//	 */
//	public String save(){
//		if(vo.getId()==null){
//			HttpSession session=ServletActionContext.getRequest().getSession();
//			SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
//			
//			vo.setCode(generateCode("XJ", "BuyPrice", "物料询价编号"));
//			vo.setAddId(user.getId());
//			vo.setAddName(user.getEmployee().getName());
//			vo.setAddDate(DateTools.formatDate(new Date(), "yyyy-MM-dd"));
//			vo.setState(OrderState.CGGL_WLZX_XJZX);
//		}
//		
//		if(vo.getState().equals(OrderState.CGGL_WLZX_XJQR)){
//			vo.setAuditState(StateType.ASK_WAIT);
//		}
//		
//		BuyPrice order=buyPriceDAO.saveOrUpdate(vo);
//		
//		if(getNames()!=null && getNames().length>0){
//			buyPriceDAO.deleteList(vo);
//			int index=0;
//			for (String name : getNames()) {
//				BuyPriceList list=new BuyPriceList();
//				list.setOrder(order);
//				list.setName(name);
//				list.setMateId(getMateIds()[index]);
//				list.setUnit(getUnits()[index]);
//				list.setSpec(getSpecs()[index]);
//				list.setPrice(getPrices()[index]);
//				list.setAmount(getAmounts()[index]);
//				list.setRemark(getRemarks()[index]);
//				buyPriceListDAO.save(list);
//				index++;
//			}
//		}
//		
//		return redirectSuccess("/buy/buy-price/index.jhtml", "数据保存成功");
//	}
//	
//	public void validateSave(){
//		if(vo==null){
//			addFieldError("对象无效", "vo");
//		}else{
//			
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
//			buyPriceDAO.deleteById(id);
//		}
//		return redirectSuccess("/buy/buy-price/index.jhtml", "数据删除成功");
//	}
//	
//	/**
//	 * 初始化订单明细
//	 */
//	private void initDetails(){
//		BuyPriceListSO listSO=new BuyPriceListSO();
//		listSO.setPageNumber(1);
//		listSO.setObjectsPerPage(Integer.MAX_VALUE);
//		BuyPrice order=new BuyPrice();
//		order.setId(id);
//		listSO.setOrder(order);
//		orderList=buyPriceListDAO.getList(listSO);
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
//	public List<BuyPriceList> getOrderList() {
//		return orderList;
//	}
//
//	public void setOrderList(List<BuyPriceList> orderList) {
//		this.orderList = orderList;
//	}
//
//	public AskType[] getTypes() {
//		return types;
//	}
//
//	public void setTypes(AskType[] types) {
//		this.types = types;
//	}
//
//	private BuyPriceSO vo;
//	private List<BuyPriceList> orderList;
//	private AskType[] types=AskType.values();
//	@Resource
//	private BuyPriceDAO buyPriceDAO;
//	@Resource
//	private BuyPriceListDAO buyPriceListDAO;
	private static final long serialVersionUID = -2832815650494978767L;
}
