package cn.com.kington.webapp.actions.utils;

import java.util.List;

import javax.annotation.Resource;

import cc.mzone.struts2.coc.annotation.JSONResult;
import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.AreaSO;
import cn.com.kington.dao.basic.AreaDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

/**
 * 地区管理
 * 
 * @author 杜永生
 * 
 */
public class AreaToolsAction extends BaseActionSupport {

	@JSONResult(values = { "areaList" })
	public void ajaxFindArea() {
		if(vo==null){
			vo=new AreaSO();
		}
		vo.setPageNumber(1);
		vo.setObjectsPerPage(Integer.MAX_VALUE);
		areaList = areaDAO.getList(vo);
	}

	public AreaSO getVo() {
		return vo;
	}

	public void setVo(AreaSO vo) {
		this.vo = vo;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	private AreaSO vo;
	private List<Area> areaList;
	@Resource
	private AreaDAO areaDAO;
	private static final long serialVersionUID = 3983579912114180659L;

}
