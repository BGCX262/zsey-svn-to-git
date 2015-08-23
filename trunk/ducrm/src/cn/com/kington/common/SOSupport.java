package cn.com.kington.common;


/**
 * 查询搜索对象基类
 * @author 杜永生
 *
 */
public class SOSupport extends Pagination {
	private static final long serialVersionUID = -7800856537473769280L;
	private Long id;// ID
	private String createTime;// 创建时间
	private String updateTime;// 更新时间
	private Boolean flag;// 标记
	private Boolean status;// 状态
	private String operate;// 操作（init：初始化，edit：编辑，view：查看）
	private String keywords;// 关键字
	private Boolean islike;// 是否模糊查询
	private String startTime;// 开始时间
	private String endTime;// 结束时间

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
