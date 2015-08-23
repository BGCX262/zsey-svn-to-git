package cn.com.kington.webapp.actions.store;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import cc.mzone.struts2.coc.annotation.JSONResult;
import cn.com.kington.bean.store.StorageSO;
import cn.com.kington.bean.store.Store;
import cn.com.kington.bean.store.StoreSO;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.dao.store.StorageDAO;
import cn.com.kington.dao.store.StoreDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 库存管理
 * 
 * @author 杜永生
 * 
 */
public class StorageAction extends BaseActionSupport {
	/**
	 * 首页
	 * @return
	 */
	public String index(){
		if(vo==null){
			vo=new StorageSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=storageDAO.findPage(vo);
		initStore();
		return Constants.INDEX;
	}
	
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=storageDAO.getSOById(id);
		}
		initStore();
		return Constants.EDIT;
	}
	
	/**
	 * 保存
	 */
	public String save(){
		storageDAO.saveOrUpdate(vo);
		return redirectSuccess("/store/storage/index.jhtml?rnd="+Math.random(), "数据保存成功");
	}
	
	/**
	 * 删除
	 */
	public String delete(){
		if(id!=null){
			storageDAO.deleteById(id);
		}
		return redirectSuccess("/store/storage/index.jhtml?rnd="+Math.random(), "数据删除成功");
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave(){
		boolean check=false;
		if(vo==null){
			addFieldError("vo", "无效的对象");
			check=true;
		}else{
			
			if(vo.getId()==null){
				if(vo.getStoreId()==null){
					addFieldError("vo.storeId", "仓库不能为空");
					check=true;
				}
				
				if(vo.getDataId()==null){
					addFieldError("vo.dataId", "名称ID不能为空");
					check=true;
				}
				
				if(StringUtils.isEmpty(vo.getName())){
					addFieldError("vo.name", "名称不能为空");
					check=true;
				}
			
				ajaxCheck();
				if(isok){
					check=true;
				}
			}
			
			if(vo.getAmount()==null){
				addFieldError("vo.amount", "数量不能为空");
				check=true;
			}
		}
		if(check){
			initStore();
		}
		setInputResult(Constants.EDIT);
	}
	
	@JSONResult(values = { "isok" })
	public void ajaxCheck(){
		int amount=storageDAO.getCount(vo);
		if(amount>0){
			isok=true;
		}else{
			isok=false;
		}
	}
	
	private void initStore(){
		StoreSO so=new StoreSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		storeList=storeDAO.getList(so);
	}
	
	public StorageSO getVo() {
		return vo;
	}

	public void setVo(StorageSO vo) {
		this.vo = vo;
	}

	public Boolean getIsok() {
		return isok;
	}

	public void setIsok(Boolean isok) {
		this.isok = isok;
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}

	public Sort[] getSorts() {
		return sorts;
	}

	public void setSorts(Sort[] sorts) {
		this.sorts = sorts;
	}

	private StorageSO vo;
	private Boolean isok;
	private List<Store> storeList;
	private Sort[] sorts={Sort.MATERIAL,Sort.PRODUCT};
	@Resource
	private StorageDAO storageDAO;
	@Resource
	private StoreDAO storeDAO;
	private static final long serialVersionUID = -2450272471644657278L;

}
