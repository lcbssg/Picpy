package com.cb.model.job;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.cb.model.user.SysUser;

public class SysJob {
	private int jobId;
	private String jobName;
	private String jobDesc;
	private Timestamp lastModify;
	private Set<SysUser> sysUsers = new HashSet<SysUser>();
	public Set<SysUser> getSysUsers() {
		return sysUsers;
	}
	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public Timestamp getLastModify() {
		return lastModify;
	}
	public void setLastModify(Timestamp lastModify) {
		this.lastModify = lastModify;
	}
}
