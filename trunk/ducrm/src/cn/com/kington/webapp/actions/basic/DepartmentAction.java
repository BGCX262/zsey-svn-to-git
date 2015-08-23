package cn.com.kington.webapp.actions.basic;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import cn.com.kington.bean.basic.Department;
import cn.com.kington.bean.basic.DepartmentSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.SysAppSequenceDAO;
import cn.com.kington.dao.basic.DepartmentDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 部门管理
 * @author 杜永生
 *
 */
public class DepartmentAction extends BaseActionSupport {
	/**
	 * 首页
	 */
	public String index() {
		if(vo==null){
			vo=new DepartmentSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=departmentDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	/**
	 * 单选
	 * @return
	 */
	public String single(){
		if(vo==null){
			vo=new DepartmentSO();
		}
		vo.setPageNumber(1);
		vo.setObjectsPerPage(Integer.MAX_VALUE);
		List<Department> list=departmentDAO.getList(vo);
		
		if(list!=null && list.size()>0){
			JSONArray array=new JSONArray();
			for (Department dep : list) {
				JSONObject json=new JSONObject();
				json.put("id", dep.getId());
				
				if(dep.getDepartment()==null){
					json.put("pId", 0);
				}else{
					json.put("pId", dep.getDepartment().getId());
					json.put("open", true);
				}
				
				json.put("name", dep.getName());
				
				if(id!=null){
					if(id.equals(dep.getId())){
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
	 * 编辑
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=departmentDAO.getSOById(id);
		}
		return Constants.EDIT;
	}
	
	/**
	 * 详情
	 * @return
	 */
	public String details(){
		if(id!=null){
			vo=departmentDAO.getSOById(id);
		}
		return Constants.DETAILS;
	}
	
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		if(vo.getId()==null){
			if(vo.getId()==null){
				String seqname=("DEPARTMENT");
				
				if(vo.getDepartment()!=null && vo.getDepartment().getId()!=null){
					Department parent=departmentDAO.findById(Department.class, vo.getDepartment().getId());
					String code=sysAppSequenceDAO.getNotPrefixSeqVal(seqname+"_"+parent.getCode(), 2, "部门编号");
					vo.setCode(parent.getCode()+code);
				}else{
					String code=sysAppSequenceDAO.getNotPrefixSeqVal(seqname, 2, "部门编号");
					vo.setCode(code);
				}
				
			}
		}
		
		departmentDAO.saveOrUpdate(vo);
		return redirectSuccess("/basic/department/index.jhtml", "数据保存成功");
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave() {
		if (vo == null) {
			this.addFieldError("vo", "对象无效");
		} else {
			if (StringUtils.isEmpty(vo.getName())) {
				addFieldError("vo.name", "名称不能为空");
			}
		}
		this.setInputResult(Constants.EDIT);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		if(id!=null){
			departmentDAO.deleteById(id);
		}
		return redirectSuccess("/basic/department/index.jhtml", "数据删除成功");
	}
	
	public DepartmentSO getVo() {
		return vo;
	}

	public void setVo(DepartmentSO vo) {
		this.vo = vo;
	}

	public String getNodes() {
		return nodes;
	}

	public void setNodes(String nodes) {
		this.nodes = nodes;
	}

	private DepartmentSO vo;
	private String nodes;
	@Resource
	private DepartmentDAO departmentDAO;
	@Resource
	private SysAppSequenceDAO sysAppSequenceDAO;
	private static final long serialVersionUID = 6161405053984683801L;

}
