package cn.com.kington.webapp.actions.system;

import java.util.List;

import javax.annotation.Resource;

import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.basic.AreaSO;
import cn.com.kington.bean.system.SysConfig;
import cn.com.kington.bean.system.SysConfigSO;
import cn.com.kington.common.Constants;
import cn.com.kington.dao.basic.AreaDAO;
import cn.com.kington.dao.system.SysConfigDAO;
import cn.com.kington.webapp.actions.BaseActionSupport;

public class SysConfigAction extends BaseActionSupport {
	public String index() {
		vo = sysConfigDAO.getSOById(1L);
		initArea();
		return Constants.INDEX;
	}

	public String save() {
		SysConfig cfg = sysConfigDAO.saveOrUpdate(vo);
		return redirectSuccess("/system/sys-config/index.jhtml?id=" + cfg.getId(), "���ݱ���ɹ�");
	}
	
	private void initArea(){
		//ʡ��
		AreaSO so=new AreaSO();
		so.setPageNumber(1);
		so.setObjectsPerPage(Integer.MAX_VALUE);
		provinceList=areaDAO.find(so);
		
		//����
		if(provinceList!=null && provinceList.size()>0){
			if(vo!=null && vo.getCity()!=null && vo.getCity().getId()!=null){
				so.setArea(vo.getProvince());
			}else{
				so.setArea(provinceList.get(0));
			}
			
			cityList=areaDAO.find(so);
		}
	}

	public SysConfigSO getVo() {
		return vo;
	}

	public void setVo(SysConfigSO vo) {
		this.vo = vo;
	}
	
	public List<Area> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<Area> provinceList) {
		this.provinceList = provinceList;
	}

	public List<Area> getCityList() {
		return cityList;
	}

	public void setCityList(List<Area> cityList) {
		this.cityList = cityList;
	}

	private List<Area> provinceList;//ʡ
	private List<Area> cityList;//��
	private SysConfigSO vo;
	@Resource
	private AreaDAO areaDAO;
	@Resource
	private SysConfigDAO sysConfigDAO;
	private static final long serialVersionUID = 5646654221633962774L;
}
