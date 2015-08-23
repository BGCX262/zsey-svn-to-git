package cn.com.kington.webapp.actions.basic;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import cn.com.kington.bean.basic.WorkSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.SysAppSequenceDAO;
import cn.com.kington.dao.basic.WorkDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 工序ACTION管理
 * @author 杜永生
 *
 */
public class WorkAction extends BaseActionSupport {
	/**
	 * 首页
	 */
	public String index() {
		if(vo==null){
			vo=new WorkSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList=workDAO.findPage(vo);
		return Constants.INDEX;
	}
	
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){
		if(id==null){
			vo=new WorkSO();
		}else{
			vo=workDAO.getSOById(id);
		}
		return Constants.EDIT;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		if(id!=null){
			workDAO.deleteById(id);
		}
		return redirectSuccess("/basic/work/index.jhtml?rnd="+Math.random(), "数据删除成功");
	}
	
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		if(vo.getId()==null){
			String code=sysAppSequenceDAO.getYearSeqVal("Work", 5, "产品工序编号");
			vo.setCode(code);
		}
		workDAO.saveOrUpdate(vo);
		return redirectSuccess("/basic/work/index.jhtml?rnd="+Math.random(), "数据保存成功");
	}
	
	/**
	 * 保存验证
	 */
	public void validateSave() {
		if(vo==null){
			addFieldError("vo", "对象无效");
		}else{
			if(StringUtils.isEmpty(vo.getName())){
				addFieldError("vo.name", "名称不能为空");
			}
			
			if(vo.getPrice()==null){
				addFieldError("vo.price", "价格不能为空");
			}
			
		}
		setInputResult(Constants.EDIT);
	}
	

	public WorkSO getVo() {
		return vo;
	}

	public void setVo(WorkSO vo) {
		this.vo = vo;
	}
	
	private WorkSO vo;
	@Resource
	private WorkDAO workDAO;
	@Resource
	private SysAppSequenceDAO sysAppSequenceDAO;
	private static final long serialVersionUID = 7543308206700345672L;
	

}
