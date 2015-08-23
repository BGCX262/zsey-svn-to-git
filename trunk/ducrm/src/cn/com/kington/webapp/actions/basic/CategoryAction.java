package cn.com.kington.webapp.actions.basic;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import cn.com.kington.bean.basic.Category;
import cn.com.kington.bean.basic.CategorySO;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.dao.SysAppSequenceDAO;
import cn.com.kington.dao.basic.CategoryDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

public class CategoryAction extends BaseActionSupport {
	/**
	 * 首页
	 */
	public String index(){
		if(vo==null){
			vo=new CategorySO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=categoryDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	/**
	 * 单选
	 */
	public String single(){
		vo.setPageNumber(1);
		vo.setObjectsPerPage(Integer.MAX_VALUE);
		List<Category> list=categoryDAO.getList(vo);
		
		if(list!=null && list.size()>0){
			JSONArray array=new JSONArray();
			for (Category category : list) {
				JSONObject json=new JSONObject();
				json.put("id", category.getId());
				
				if(category.getCategory()==null){
					json.put("pId", 0);
				}else{
					json.put("pId", category.getCategory().getId());
					json.put("open", true);
				}
				
				json.put("name", category.getName());
				
				if(id!=null){
					if(id.equals(category.getId())){
						json.put("checked", true);
					}
				}
				
				array.add(json);
			}
			nodes=array.toString();
		}
		return Constants.SINGLE;
	}
	
	/**
	 * 编辑页面
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=categoryDAO.getSOById(id);
		}
		return Constants.EDIT;
	}
	
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		if(vo.getId()==null){
			String seqname=("Category_"+vo.getSort().name()).toUpperCase();
			
			if(vo.getCategory()!=null && vo.getCategory().getId()!=null){
				Category parent=categoryDAO.findById(Category.class, vo.getCategory().getId());
				String code=sysAppSequenceDAO.getNotPrefixSeqVal(seqname+"_"+parent.getCode(), 2, "分类编号");
				vo.setCode(parent.getCode()+code);
			}else{
				String code=sysAppSequenceDAO.getNotPrefixSeqVal(seqname, 2, "分类编号");
				vo.setCode(code);
			}
			
		}
		categoryDAO.saveOrUpdate(vo);
		return redirectSuccess("/basic/category/index.jhtml?rnd="+Math.random(), "数据保存成功");
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave() {
		if (vo == null) {
			this.addFieldError("vo", "对象无效");
		} else {
			if(StringUtils.isEmpty(vo.getName())){
				this.addFieldError("vo.name", "分类名称不能为空");
			}
		}
		this.setInputResult(Constants.EDIT);
	}
	
	/**
	 * 数据删除<br />
	 * <font style="color:red;">注意：这里删除是逻辑删除，如果需要物理删除请手工到数据库进行删除或清理无效的数据。</font>
	 * @return
	 */
	public String delete(){
		if(id!=null){
			categoryDAO.deleteById(id);
		}
		return redirectSuccess("/basic/category/index.jhtml?rnd="+Math.random(), "数据删除成功");
	}
	
	public Sort[] getSorts() {
		return sorts;
	}

	public void setSorts(Sort[] sorts) {
		this.sorts = sorts;
	}

	public CategorySO getVo() {
		return vo;
	}

	public void setVo(CategorySO vo) {
		this.vo = vo;
	}
	
	public String getNodes() {
		return nodes;
	}

	public void setNodes(String nodes) {
		this.nodes = nodes;
	}
	
	private String nodes;
	private Sort[] sorts={Sort.WORK,Sort.PRODUCT,Sort.MATERIAL};
	private CategorySO vo;
	@Resource
	private CategoryDAO categoryDAO;
	@Resource
	private SysAppSequenceDAO sysAppSequenceDAO;
	private static final long serialVersionUID = 7941562727732368179L;
}
