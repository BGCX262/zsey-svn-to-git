package cn.com.kington.bean.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.kington.bean.EntitySupport;

/**
 * 系统流水号
 * 
 * @author 杜永生
 * 
 */
@Entity
@Table(name = "sys_app_sequence")
public class SysAppSequence extends EntitySupport {
	private static final long serialVersionUID = -7016232977221949245L;
	@Column(name = "enSeqName",nullable=false, unique = true)
	private String enSeqName;// 流水号名称
	@Column(name = "cnSeqName", nullable=false)
	private String cnSeqName;// 流水号备注
	@Column(name = "seqValue", nullable=false, length = 22)
	private String seqValue;// 流水号值

	public SysAppSequence() {
		super();
	}

	public SysAppSequence(String enSeqName, String cnSeqName, String seqValue) {
		super();
		this.enSeqName = enSeqName;
		this.cnSeqName = cnSeqName;
		this.seqValue = seqValue;
	}

	public String getEnSeqName() {
		return enSeqName;
	}

	public void setEnSeqName(String enSeqName) {
		this.enSeqName = enSeqName;
	}

	public String getCnSeqName() {
		return cnSeqName;
	}

	public void setCnSeqName(String cnSeqName) {
		this.cnSeqName = cnSeqName;
	}

	public String getSeqValue() {
		return seqValue;
	}

	public void setSeqValue(String seqValue) {
		this.seqValue = seqValue;
	}
}
