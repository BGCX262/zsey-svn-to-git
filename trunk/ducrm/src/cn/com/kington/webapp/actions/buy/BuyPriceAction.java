package cn.com.kington.webapp.actions.buy;

import cn.com.kington.webapp.actions.sell.OrderAction;

/**
 * �ɹ�ѯ��ACTION
 * 
 * @author ������
 * 
 */
public class BuyPriceAction extends OrderAction {
//	/**
//	 * ��ҳ
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
//	 * �༭
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
//	 * ����
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
//	 * ���ɲɹ���
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
//	 * ��ӡ
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
//	 * ����
//	 * @return
//	 */
//	public String save(){
//		if(vo.getId()==null){
//			HttpSession session=ServletActionContext.getRequest().getSession();
//			SysUser user=(SysUser)session.getAttribute(Constants.DEFAULT_USER_LOGIN);
//			
//			vo.setCode(generateCode("XJ", "BuyPrice", "����ѯ�۱��"));
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
//		return redirectSuccess("/buy/buy-price/index.jhtml", "���ݱ���ɹ�");
//	}
//	
//	public void validateSave(){
//		if(vo==null){
//			addFieldError("������Ч", "vo");
//		}else{
//			
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
//			buyPriceDAO.deleteById(id);
//		}
//		return redirectSuccess("/buy/buy-price/index.jhtml", "����ɾ���ɹ�");
//	}
//	
//	/**
//	 * ��ʼ��������ϸ
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
