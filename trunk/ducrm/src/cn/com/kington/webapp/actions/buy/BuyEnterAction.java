package cn.com.kington.webapp.actions.buy;

import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * �ɹ����ACTION
 * 
 * @author ������
 * 
 */
public class BuyEnterAction extends BaseActionSupport {
//	/**
//	 * ��ҳ
//	 */
//	public String index(){
//		if(vo==null){
//			vo=new BuyOrderSO();
//		}
//		vo.setPageNumber(page);
//		vo.setObjectsPerPage(Constants.PAGE_SIZE);
//		vo.setState(OrderState.CGGL_WLCG_CGRK);
//		vo.setAuditState(StateType.AUDIT_YES);
//		vo.setInState(StateType.IN_WAIT);
//		pageList=buyOrderDAO.findPage(vo);
//		return Constants.INDEX;
//	}
//	
//	/**
//	 * �༭
//	 * @return
//	 */
//	public String edit(){
//		vo=buyOrderDAO.getSOById(id);
//		initStore();
//		initDetails();
//		return Constants.EDIT;
//	}
//	
//	
//	/**
//	 * ����
//	 * @return
//	 */
//	public String save(){
//		if(amounts!=null && amounts.length>0){
//			int index=0;
//			for (Double amount : amounts) {
//				BuyOrderList ol=buyOrderListDAO.findById(ids[index]);
//				
//				//���浽���
//				StorageSO so=new StorageSO(storeId,Sort.MATERIAL,ol.getMateId(),null);
//				List<Storage> list=storageDAO.getList(so);
//				Storage storage=null;
//				if(list!=null && list.size()>0){
//					storage=list.get(0);
//					storage.setAmount(storage.getAmount()+amount);
//				}else{
//					storage=new Storage();
//					storage.setAmount(amount);
//					storage.setSort(Sort.MATERIAL);
//					storage.setStoreId(storeId);
//					storage.setName(ol.getName()+ol.getSpec());
//					storage.setDataId(ol.getMateId());
//				}
//				storageDAO.save(storage);
//				
//				//�޸Ĳɹ���ϸ���������
//				ol.setInAmount(ol.getInAmount()+amount);
//				buyOrderListDAO.save(ol);
//				
//				index++;
//			}
//			
//			//�������״̬
//			buyOrderDAO.updateInState(vo);
//		}
//		return redirectSuccess("/buy/buy-enter/index.jhtml", "���ݱ���ɹ�");
//	}
//	
//	/**
//	 * ������֤
//	 */
//	public void validateSave(){
//		boolean isok=false;
//		if(vo==null){
//			addFieldError("������Ч", "vo");
//			isok=true;
//		}else{
//			if(storeId==null){
//				addFieldError("storeId", "�����ֿⲻ��Ϊ��");
//				isok=true;
//			}
//			
//			if(amounts!=null && amounts.length>0){
//				int index=0;
//				for (Double amount : amounts) {
//					BuyOrderList ol=buyOrderListDAO.findById(ids[index]);
//					//�ж���������Ƿ���ڲɹ���������������ڲɹ������������ʧ��
//					if(amount>ol.getAmount()){
//						addFieldError("amounts", "��"+ol.getName()+" "+ol.getSpec()+"��������������ڲɹ�����");
//						isok=true;
//						break;
//					}
//					
//					//�ж������Ƿ���ڲɹ�ѯ�ۣ�������ڲɹ�ѯ�������ʧ�ܣ�����������Ͽ�ĵ���
//					int i=prices[index].compareTo(ol.getPrice());
//					if(i!=0){
//						addFieldError("prices", "��"+ol.getName()+" "+ol.getSpec()+"���Ĳɹ��������۲�ƥ��");
//						isok=true;
//						break;
//					}else{
//						Material material=buyOrderListDAO.findById(Material.class, ol.getMateId());
//						material.setPrice(prices[index]);
//						buyOrderListDAO.save(material);
//					}
//					index++;
//				}
//			}else{
//				addFieldError("amounts", "�����������Ϊ��");
//				isok=true;
//			}
//		}
//		
//		if(isok){
//			initStore();
//			initDetails();
//		}
//		inputResult=Constants.EDIT;
//	}
//	
//	
//	private void initStore(){
//		StoreSO so=new StoreSO();
//		so.setPageNumber(1);
//		so.setObjectsPerPage(Integer.MAX_VALUE);
//		storeList=storeDAO.getList(so);
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
//	
//	public List<BuyOrderList> getOrderList() {
//		return orderList;
//	}
//
//	public void setOrderList(List<BuyOrderList> orderList) {
//		this.orderList = orderList;
//	}
//	
//	public List<Store> getStoreList() {
//		return storeList;
//	}
//
//	public void setStoreList(List<Store> storeList) {
//		this.storeList = storeList;
//	}
//
//	public Double[] getAmounts() {
//		return amounts;
//	}
//
//	public void setAmounts(Double[] amounts) {
//		this.amounts = amounts;
//	}
//
//	public Double[] getPrices() {
//		return prices;
//	}
//
//	public void setPrices(Double[] prices) {
//		this.prices = prices;
//	}
//
//	public Long getStoreId() {
//		return storeId;
//	}
//
//	public void setStoreId(Long storeId) {
//		this.storeId = storeId;
//	}
//
//	private BuyOrderSO vo;
//	private Long storeId;
//	private List<BuyOrderList> orderList;
//	private List<Store> storeList;
//	private Double[] amounts;
//	private Double[] prices;
//	@Resource
//	private BuyOrderDAO buyOrderDAO;
//	@Resource
//	private BuyOrderListDAO buyOrderListDAO;
//	@Resource
//	private StoreDAO storeDAO;
//	@Resource
//	private StorageDAO storageDAO;
//	private static final long serialVersionUID = -2832815650494978767L;
}
