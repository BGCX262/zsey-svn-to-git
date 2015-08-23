package cn.com.kington.dao.system;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;

import cn.com.kington.bean.basic.Area;
import cn.com.kington.bean.system.SysConfig;
import cn.com.kington.bean.system.SysConfigSO;
import cn.com.kington.dao.BaseDAOImpl;

public class SysConfigDAOImpl extends BaseDAOImpl<SysConfig, SysConfigSO>
		implements SysConfigDAO {

	@Override
	public void switchVO2PO(SysConfig po, SysConfigSO so) {
		if(StringUtils.isNotEmpty(so.getName())){
			po.setName(StringUtils.trim(so.getName()));
		}
		
		if(StringUtils.isNotEmpty(so.getWeb())){
			po.setWeb(StringUtils.trim(so.getWeb()));
		}
		
		if(so.getProvince()!=null && so.getProvince().getId()!=null){
			Area area=findById(Area.class, so.getProvince().getId());
			po.setProvince(area);
		}
		
		if(so.getCity()!=null && so.getCity().getId()!=null){
			Area area=findById(Area.class, so.getCity().getId());
			po.setCity(area);
		}
		
		if(StringUtils.isNotEmpty(so.getAddress())){
			po.setAddress(StringUtils.trim(so.getAddress()));
		}
		
		if(StringUtils.isNotEmpty(so.getPostcode())){
			po.setPostcode(StringUtils.trim(so.getPostcode()));
		}
		
		if(StringUtils.isNotEmpty(so.getPhone1())){
			po.setPhone1(StringUtils.trim(so.getPhone1()));
		}
		
		if(StringUtils.isNotEmpty(so.getPhone2())){
			po.setPhone2(StringUtils.trim(so.getPhone2()));
		}
		
		if(StringUtils.isNotEmpty(so.getFax1())){
			po.setFax1(StringUtils.trim(so.getFax1()));
		}
		
		if(StringUtils.isNotEmpty(so.getFax2())){
			po.setFax2(StringUtils.trim(so.getFax2()));
		}
		
		if(StringUtils.isNotEmpty(so.getQq1())){
			po.setQq1(StringUtils.trim(so.getQq1()));
		}
		
		if(StringUtils.isNotEmpty(so.getQq2())){
			po.setQq2(StringUtils.trim(so.getQq2()));
		}
		
		if(StringUtils.isNotEmpty(so.getEmail1())){
			po.setEmail1(StringUtils.trim(so.getEmail1()));
		}
		
		if(StringUtils.isNotEmpty(so.getEmail2())){			
			po.setEmail2(StringUtils.trim(so.getEmail2()));
		}
		
		if(StringUtils.isNotEmpty(so.getLinkman1())){
			po.setLinkman1(StringUtils.trim(so.getLinkman1()));
		}
		
		if(StringUtils.isNotEmpty(so.getLinkman2())){
			po.setLinkman2(StringUtils.trim(so.getLinkman2()));
		}
		
		if(StringUtils.isNotEmpty(so.getTel1())){
			po.setTel1(StringUtils.trim(so.getTel1()));
		}
		
		if(StringUtils.isNotEmpty(so.getTel2())){
			po.setTel2(StringUtils.trim(so.getTel2()));
		}
		
		if(StringUtils.isNotEmpty(so.getMobile1())){
			po.setMobile1(StringUtils.trim(so.getMobile1()));
		}
		
		if(StringUtils.isNotEmpty(so.getMobile2())){
			po.setMobile2(StringUtils.trim(so.getMobile2()));
		}
		
		if(StringUtils.isNotEmpty(so.getBcode1())){
			po.setBcode1(StringUtils.trim(so.getBcode1()));
		}
		
		if(StringUtils.isNotEmpty(so.getBcode2())){
			po.setBcode2(StringUtils.trim(so.getBcode2()));
		}
		
		if(StringUtils.isNotEmpty(so.getBname1())){
			po.setBname1(StringUtils.trim(so.getBname1()));
		}
		
		if(StringUtils.isNotEmpty(so.getBname2())){
			po.setBname2(StringUtils.trim(so.getBname2()));
		}
		
		if(StringUtils.isNotEmpty(so.getBman1())){
			po.setBman1(StringUtils.trim(so.getBman1()));
		}
		
		if(StringUtils.isNotEmpty(so.getBman2())){
			po.setBman2(StringUtils.trim(so.getBman2()));
		}
		
		if(StringUtils.isNotEmpty(so.getBadd1())){
			po.setBadd1(StringUtils.trim(so.getBadd1()));
		}
		
		if(StringUtils.isNotEmpty(so.getBadd2())){
			po.setBadd2(StringUtils.trim(so.getBadd2()));
		}
	}

	@Override
	public void setCriteriaParams(Criteria criteria, SysConfigSO so) {

	}

	@Override
	public void setQueryParams(Query query, SysConfigSO so) {

	}

	@Override
	public String getHqlWhere(SysConfigSO so) {
		return null;
	}

}
