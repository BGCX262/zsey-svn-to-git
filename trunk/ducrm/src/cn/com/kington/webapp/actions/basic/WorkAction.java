package cn.com.kington.webapp.actions.basic;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import cn.com.kington.bean.basic.WorkSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.SysAppSequenceDAO;
import cn.com.kington.dao.basic.WorkDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * ����ACTION����
 * @author ������
 *
 */
public class WorkAction extends BaseActionSupport {
	/**
	 * ��ҳ
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
	 * �༭
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
	 * ɾ��
	 * @return
	 */
	public String delete(){
		if(id!=null){
			workDAO.deleteById(id);
		}
		return redirectSuccess("/basic/work/index.jhtml?rnd="+Math.random(), "����ɾ���ɹ�");
	}
	
	/**
	 * ����
	 * @return
	 */
	public String save(){
		if(vo.getId()==null){
			String code=sysAppSequenceDAO.getYearSeqVal("Work", 5, "��Ʒ������");
			vo.setCode(code);
		}
		workDAO.saveOrUpdate(vo);
		return redirectSuccess("/basic/work/index.jhtml?rnd="+Math.random(), "���ݱ���ɹ�");
	}
	
	/**
	 * ������֤
	 */
	public void validateSave() {
		if(vo==null){
			addFieldError("vo", "������Ч");
		}else{
			if(StringUtils.isEmpty(vo.getName())){
				addFieldError("vo.name", "���Ʋ���Ϊ��");
			}
			
			if(vo.getPrice()==null){
				addFieldError("vo.price", "�۸���Ϊ��");
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
