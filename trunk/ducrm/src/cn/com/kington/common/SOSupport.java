package cn.com.kington.common;


/**
 * ��ѯ�����������
 * @author ������
 *
 */
public class SOSupport extends Pagination {
	private static final long serialVersionUID = -7800856537473769280L;
	private Long id;// ID
	private String createTime;// ����ʱ��
	private String updateTime;// ����ʱ��
	private Boolean flag;// ���
	private Boolean status;// ״̬
	private String operate;// ������init����ʼ����edit���༭��view���鿴��
	private String keywords;// �ؼ���
	private Boolean islike;// �Ƿ�ģ����ѯ
	private String startTime;// ��ʼʱ��
	private String endTime;// ����ʱ��

	public SOSupport() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Boolean getIslike() {
		return islike;
	}

	public void setIslike(Boolean islike) {
		this.islike = islike;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
