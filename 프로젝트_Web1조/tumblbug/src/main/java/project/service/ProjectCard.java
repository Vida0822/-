package project.service;

import file.model.File;
import member.model.Member;
import project.model.DetailCategory;
import project.model.Project;

public class ProjectCard {
	

	private File file ; 
	private DetailCategory detailCategory ; 
	private Member member ; 
	private Project project ; 
	private int ach_rate;
	private int paySum;
	private int left_days;
	
	
	public ProjectCard(File file, DetailCategory detailCategory, Member member, Project project, int ach_rate, int paySum, int left_days) {
		super();
		this.file = file;
		this.detailCategory = detailCategory;
		this.member = member;
		this.project = project;
		this.ach_rate = ach_rate;
		this.paySum = paySum;
		this.left_days = left_days;
	}



	public File getFile() {
		return file;
	}



	public void setFile(File file) {
		this.file = file;
	}



	public DetailCategory getDetailCategory() {
		return detailCategory;
	}



	public void setDetailCategory(DetailCategory detailCategory) {
		this.detailCategory = detailCategory;
	}



	public Member getMember() {
		return member;
	}



	public void setMember(Member member) {
		this.member = member;
	}



	public Project getProject() {
		return project;
	}



	public void setProject(Project project) {
		this.project = project;
	}

	public int getAch_rate() {
		return ach_rate;
	}

	public void setAch_rate(int ach_rate) {
		this.ach_rate = ach_rate;
	}



	public int getPaySum() {
		return paySum;
	}



	public void setPaySum(int paySum) {
		this.paySum = paySum;
	}



	public int getLeft_days() {
		return left_days;
	}



	public void setLeft_days(int left_days) {
		this.left_days = left_days;
	}



	




	
	
}
