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
 * ���Ź���
 * @author ������
 *
 */
public class DepartmentAction extends BaseActionSupport {
	/**
	 * ��ҳ
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
	 * ��ѡ
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
	 * �༭
	 * @return
	 */
	public String edit(){
		if(id!=null){
			vo=departmentDAO.getSOById(id);
		}
		return Constants.EDIT;
	}
	
	/**
	 * ����
	 * @return
	 */
	public String details(){
		if(id!=null){
			vo=departmentDAO.getSOById(id);
		}
		return Constants.DETAILS;
	}
	
	/**
	 * ����
	 * @return
	 */
	public String save(){
		if(vo.getId()==null){
			if(vo.getId()==null){
				String seqname=("DEPARTMENT");
				
				if(vo.getDepartment()!=null && vo.getDepartment().getId()!=null){
					Department parent=departmentDAO.findById(Department.class, vo.getDepartment().getId());
					String code=sysAppSequenceDAO.getNotPrefixSeqVal(seqname+"_"+parent.getCode(), 2, "���ű��");
					vo.setCode(parent.getCode()+code);
				}else{
					String code=sysAppSequenceDAO.getNotPrefixSeqVal(seqname, 2, "���ű��");
					vo.setCode(code);
				}
				
			}
		}
		
		departmentDAO.saveOrUpdate(vo);
		return redirectSuccess("/basic/department/index.jhtml", "���ݱ���ɹ�");
	}
	
	/**
	 * ������֤
	 */
	public void validateSave() {
		if (vo == null) {
			this.addFieldError("vo", "������Ч");
		} else {
			if (StringUtils.isEmpty(vo.getName())) {
				addFieldError("vo.name", "���Ʋ���Ϊ��");
			}
		}
		this.setInputResult(Constants.EDIT);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete(){
		if(id!=null){
			departmentDAO.deleteById(id);
		}
		return redirectSuccess("/basic/department/index.jhtml", "����ɾ���ɹ�");
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
