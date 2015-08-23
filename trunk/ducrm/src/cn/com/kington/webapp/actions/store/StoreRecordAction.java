package cn.com.kington.webapp.actions.store;

import java.util.List;

import javax.annotation.Resource;

import cn.com.kington.bean.store.Store;
import cn.com.kington.bean.store.StoreRecordSO;
import cn.com.kington.bean.store.StoreSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.store.StoreDAO;
import cn.com.kington.dao.store.StoreRecordDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 库存操作日志管理ACTION
 * 
 * @author 杜永生
 * 
 */
public class StoreRecordAction extends BaseActionSupport {
	
	/**
	 * 首页
	 */
	public String index(){
		if(vo==null){
			vo=new StoreRecordSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=storeRecordDAO.findPage(vo);
		initStore();
		return Constants.INDEX;
	}
	
	
	/**
	 * 删除成功
	 * @return
	 */
	public String delete(){
		if(id!=null){
			storeDAO.deleteById(id);
		}
		return redirectSuccess("/store/store-recor/index.jhtml", "数据删除成功");
	}
	
	private void initStore(){
		StoreSO so=new StoreSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		storeList=storeDAO.getList(so);
	}
	
	public StoreRecordSO getVo() {
		return vo;
	}

	public void setVo(StoreRecordSO vo) {
		this.vo = vo;
	}

	public List<Store> getStoreList() {
		return storeList;
	}


	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}

	private StoreRecordSO vo;
	private List<Store> storeList;
	@Resource
	private StoreDAO storeDAO;
	@Resource
	private StoreRecordDAO storeRecordDAO;
	private static final long serialVersionUID = 3420818652270318781L;
}
