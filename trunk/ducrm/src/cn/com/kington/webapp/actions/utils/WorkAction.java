package cn.com.kington.webapp.actions.utils;

import javax.annotation.Resource;

import cn.com.kington.bean.basic.WorkSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.basic.WorkDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * ���򹫹�ACTION
 * 
 * @author ������
 * 
 */
public class WorkAction extends BaseActionSupport {
	/**
	 * ��ҳ
	 */
	public String index() {
		if (vo == null) {
			vo = new WorkSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList = workDAO.findPage(vo);
		return Constants.INDEX;
	}

	/**
	 * ��ѡ
	 * 
	 * @return
	 */
	public String single() {
		index();
		return Constants.SINGLE;
	}

	/**
	 * ��ת��ѡ��ҳ��
	 * 
	 * @return
	 */
	public String select() {
		return "select";
	}

	/**
	 * ��ѡ
	 * 
	 * @return
	 */
	public String multi() {
		index();
		return Constants.MULTI;
	}

	/**
	 * ��ѡ
	 * 
	 * @return
	 */
	public String check() {
		return "check";
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
	private static final long serialVersionUID = -517303714430606661L;

}
