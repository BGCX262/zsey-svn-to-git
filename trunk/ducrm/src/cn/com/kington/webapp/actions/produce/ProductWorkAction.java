package cn.com.kington.webapp.actions.produce;

import javax.annotation.Resource;

import cn.com.kington.bean.produce.ProductWorkSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.produce.ProductWorkDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

public class ProductWorkAction extends BaseActionSupport {

	public String index() {
		if (vo == null) {
			vo = new ProductWorkSO();
		}
		vo.setPageNumber(page);
		vo.setObjectsPerPage(Constants.PAGE_SIZE);
		pageList = productWorkDAO.findPage(vo);
		return Constants.INDEX;
	}

	public String single() {
		index();
		return Constants.SINGLE;
	}

	public ProductWorkSO getVo() {
		return vo;
	}

	public void setVo(ProductWorkSO vo) {
		this.vo = vo;
	}

	private ProductWorkSO vo;
	@Resource
	private ProductWorkDAO productWorkDAO;
	private static final long serialVersionUID = 6842489886133884293L;
}
