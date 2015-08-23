package cn.com.kington.bean.system;

import cn.com.kington.common.SOSupport;

public class SysAppSequenceSO extends SOSupport {
	private static final long serialVersionUID = -1220706710102132700L;
	private String enSeqName;// ��ˮ������
	private String cnSeqName;// ��ˮ�ű�ע
	private String seqValue;// ��ˮ��ֵ

	public SysAppSequenceSO() {
		super();
	}

	public SysAppSequenceSO(String enSeqName, String cnSeqName, String seqValue) {
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
