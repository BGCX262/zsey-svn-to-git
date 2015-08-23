package excel;

public class AviatorHealthCheck {
	String id;
	String healthCheckFlightNum;
	String noddeid;
	String startTime;
	String endTime;
	String FollowContext;
	Staff FollowDoctor;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHealthCheckFlightNum() {
		return healthCheckFlightNum;
	}
	public void setHealthCheckFlightNum(String healthCheckFlightNum) {
		this.healthCheckFlightNum = healthCheckFlightNum;
	}
	public String getNoddeid() {
		return noddeid;
	}
	public void setNoddeid(String noddeid) {
		this.noddeid = noddeid;
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
	public String getFollowContext() {
		return FollowContext;
	}
	public void setFollowContext(String followContext) {
		FollowContext = followContext;
	}
	public Staff getFollowDoctor() {
		return FollowDoctor;
	}
	public void setFollowDoctor(Staff followDoctor) {
		FollowDoctor = followDoctor;
	}
    

}
