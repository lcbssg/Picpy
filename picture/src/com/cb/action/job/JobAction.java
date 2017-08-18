package com.cb.action.job;

import java.util.List;

import com.cb.action.BaseAction;
import com.cb.common.exception.BusinessException;
import com.cb.model.job.SysJob;
import com.cb.service.job.JobService;

public class JobAction extends BaseAction {
	private static final long serialVersionUID = -7620461886418007560L;
	private SysJob sysJob;
	private JobService jobService;
	public SysJob getSysJob() {
		return sysJob;
	}
	public void setSysJob(SysJob sysJob) {
		this.sysJob = sysJob;
	}
	
	public JobService getJobService() {
		return jobService;
	}
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	//-------------------------------------
	public String findAll() {
		List<SysJob> jobs = jobService.findAll();
		getRequest().put("sysJobs", jobs);
		return "findAll";
	}
	
	public String delete() {
		try {
			jobService.delete(sysJob);
		} catch (BusinessException e) {
			getRequest().put("message", e.getBusMessage());
		}
		return "find";
	}
	
	public String save() {
		try {
			sysJob.setLastModify(getCurTime());
			jobService.save(sysJob);
			return "find";
		} catch (BusinessException e) {
			getRequest().put("message", e.getMessage());
			return "saveInput";
		}
	}
	
	public String update() {
		try {
			sysJob.setLastModify(getCurTime());
			jobService.update(sysJob);
		} catch (BusinessException e) {
			getRequest().put("message", e.getMessage());
			return "updateInput";
		}
		return "find";
	}
	
	public String findById() {
		SysJob job = jobService.findByID(sysJob.getJobId());
		this.sysJob = job;
		return "update";
	}
}
