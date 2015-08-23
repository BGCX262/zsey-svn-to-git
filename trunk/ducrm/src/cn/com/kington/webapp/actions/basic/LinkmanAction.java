package cn.com.kington.webapp.actions.basic;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import cn.com.kington.bean.model.LinkmanSO;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.ManSort;
import cn.com.kington.common.PublicType.Sex;
import cn.com.kington.dao.basic.LinkmanDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 联系人
 * 
 * @author 杜永生
 * 
 */
public class LinkmanAction extends BaseActionSupport {
	public String index(){
		if(vo==null){
			vo=new LinkmanSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=linkmanDAO.findPage(vo);		
		return Constants.INDEX;
	}
	
	public String single(){
		index();
		return "single";
	}
	
	public String edit(){
		if(id!=null){
			vo=linkmanDAO.getSOById(id);
		}else{
			if(vo==null){
				vo=new LinkmanSO();
			}
		}
		return Constants.EDIT;
	}
	
	public String details(){
		if(id!=null){
			vo=linkmanDAO.getSOById(id);
		}
		return Constants.DETAILS;
	}
	
	public String delete(){
		if(id!=null){
			linkmanDAO.deleteById(id);
		}
		String url="/basic/linkman/index.jhtml?vo.sort="+vo.getSort()+"&vo.dataId="+vo.getDataId()+"&rnd="+Math.random();
		return redirectSuccess(url, "数据删除成功");
	}
	
	public String save(){
		linkmanDAO.saveOrUpdate(vo);
		String url="/basic/linkman/index.jhtml?vo.sort="+vo.getSort()+"&vo.dataId="+vo.getDataId()+"&rnd="+Math.random();
		return redirectSuccess(url, "数据保存成功");
	}
	
	public void validateSave(){
		if(vo==null){
			addFieldError("vo", "无效的对象");
		}else{
			if(vo.getSort()==null){
				addFieldError("vo.sort", "分类不能为空");
			}
			
			if(vo.getDataId()==null){
				addFieldError("vo.dataId", "分类记录不能为空");
			}
			
			if(StringUtils.isEmpty(vo.getName())){
				addFieldError("vo.name", "姓名不能为空");
			}
			
		}
		setInputResult(Constants.EDIT);
	}
	
	
	public LinkmanSO getVo() {
		return vo;
	}

	public void setVo(LinkmanSO vo) {
		this.vo = vo;
	}

	public LinkmanDAO getLinkmanDAO() {
		return linkmanDAO;
	}

	public void setLinkmanDAO(LinkmanDAO linkmanDAO) {
		this.linkmanDAO = linkmanDAO;
	}
	
	public ManSort[] getSorts() {
		return sorts;
	}

	public void setSorts(ManSort[] sorts) {
		this.sorts = sorts;
	}
	
	public Sex[] getSexs() {
		return sexs;
	}

	public void setSexs(Sex[] sexs) {
		this.sexs = sexs;
	}

	private ManSort[] sorts=ManSort.values();
	private Sex[] sexs=Sex.values();
	private LinkmanSO vo;
	@Resource
	private LinkmanDAO linkmanDAO;
	private static final long serialVersionUID = 8657339553932082922L;
}
