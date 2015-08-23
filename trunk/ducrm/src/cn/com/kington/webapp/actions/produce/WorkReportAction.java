package cn.com.kington.webapp.actions.produce;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import cn.com.kington.bean.produce.WorkReportSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.produce.WorkReportDAO;
import cn.com.kington.utils.DateTools;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 工作报告
 * @author 杜永生
 *
 */
public class WorkReportAction extends BaseActionSupport {
	public String index(){
		if(vo==null){
			vo=new WorkReportSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=workReportDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	public String edit(){
		if(id!=null){
			vo=workReportDAO.getSOById(id);
		}else{
			vo=new WorkReportSO();
//			vo.setState(StateType.BALANCE_WAIT);
			vo.setAddDate(DateTools.formatDate(new Date(), "yyyy-MM-dd"));
		}
		return Constants.EDIT;
	}
	
	public String details(){
		if(id!=null){
			vo=workReportDAO.getSOById(id);
		}
		return Constants.DETAILS;
	}
	
	public String delete(){
		if(id!=null){
			workReportDAO.deleteById(id);
		}
		return redirectSuccess("/produce/work-report/index.jhtml", "数据删除成功");
	}
	
	public String save(){
		workReportDAO.saveOrUpdate(vo);
		return redirectSuccess("/produce/work-report/index.jhtml", "数据保存成功");
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave() {
		if (vo == null) {
			this.addFieldError("vo", "对象无效");
		} else {
			if(vo.getEmployee()==null && vo.getEmployee().getId()==null){
				addFieldError("vo.employee.id", "所属员工不能为空");
				
			}
			
			if(vo.getProduct()==null && vo.getProduct().getId()==null){
				addFieldError("proId", "产品ID不能为空");
			}
			
			if(vo.getWorkId()==null){
				addFieldError("proId", "工序ID不能为空");
			}
			
			if(StringUtils.isEmpty(vo.getAddDate())){
				addFieldError("addDate", "日期不能为空");
			}
		}
		
		setInputResult(Constants.EDIT);
	}
	
	public WorkReportSO getVo() {
		return vo;
	}

	public void setVo(WorkReportSO vo) {
		this.vo = vo;
	}

	private WorkReportSO vo;
	@Resource
	private WorkReportDAO workReportDAO;
	private static final long serialVersionUID = -3812769998945311851L;

}
