package cn.com.kington.webapp.actions.utils;

import java.util.List;

import cc.mzone.struts2.coc.annotation.JSONResult;
import cn.com.kington.vo.MaterialSortVO;
import cn.com.kington.webapp.actions.BaseActionSupport;

public class MaterialSortToolsAction extends BaseActionSupport {
	@JSONResult(values = { "sorts" })
	public void ajaxFindMaterialSort() {
	}

	public List<MaterialSortVO> getSorts() {
		return sorts;
	}

	public void setSorts(List<MaterialSortVO> sorts) {
		this.sorts = sorts;
	}


	private List<MaterialSortVO> sorts;
	private static final long serialVersionUID = -3758333643945485212L;
}
