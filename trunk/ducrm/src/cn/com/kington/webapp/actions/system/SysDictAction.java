package cn.com.kington.webapp.actions.system;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import cn.com.kington.bean.system.SysDictSO;
import cn.com.kington.common.Constants;
import cn.com.kington.common.PublicType.Sort;
import cn.com.kington.dao.SysAppSequenceDAO;
import cn.com.kington.dao.system.SysDictDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * ϵͳ�ֵ������
 * 
 * @author ������
 * 
 */
public class SysDictAction extends BaseActionSupport {
	/**
	 * ��ҳ
	 */
	public String index() {
		if (vo == null) {
			vo = new SysDictSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);

		pageList = sysDictDAO.findPage(vo);
		return Constants.INDEX;
	}

	/**
	 * �༭
	 * 
	 * @return
	 */
	public String edit() {
		if (id != null) {
			vo = sysDictDAO.getSOById(id);
		}
		return Constants.EDIT;
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public String save() {
		if(vo.getId()==null){
			String name="sysdict_"+vo.getSort();
			String code=sysAppSequenceDAO.getNotPrefixSeqVal(name, 2, "�ֵ�����");
			vo.setCode(code);
		}
		sysDictDAO.saveOrUpdate(vo);
		return redirectSuccess("/system/sys-dict/index.jhtml", "���ݱ���ɹ�");
	}

	/**
	 * ������֤
	 */
	public void validateSave() {
		if (vo == null) {
			addFieldError("vo", "��Ч�Ķ���");
		} else {
			if(StringUtils.isEmpty(vo.getName())){
				addFieldError("vo.name", "���Ʋ���Ϊ��");
			}
			
			if(vo.getId()==null){
				if(vo.getSort()==null){
					addFieldError("vo.sort", "���Ͳ���Ϊ��");
				}
			}
		}

		setInputResult(Constants.EDIT);
	}

	/**
	 * ɾ��
	 * 
	 * @return
	 */
	public String delete() {
		if (id != null) {
			sysDictDAO.deleteById(id);
		}
		return redirectSuccess("/system/sys-dict/index.jhtml", "����ɾ���ɹ�");
	}

	public SysDictSO getVo() {
		return vo;
	}

	public void setVo(SysDictSO vo) {
		this.vo = vo;
	}

	public Sort[] getSorts() {
		return sorts;
	}

	public void setSorts(Sort[] sorts) {
		this.sorts = sorts;
	}

	private SysDictSO vo;
	private Sort[] sorts={Sort.UNIT,Sort.CUSTOMER,Sort.CERTIFICATE,Sort.DUTY,Sort.NATION,Sort.POLITY};
	@Resource
	private SysDictDAO sysDictDAO;
	@Resource
	private SysAppSequenceDAO sysAppSequenceDAO;
	private static final long serialVersionUID = -5100029310687791972L;
}
