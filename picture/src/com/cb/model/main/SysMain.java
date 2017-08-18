package com.cb.model.main;
public class SysMain implements java.io.Serializable {
	private static final long serialVersionUID = 5219818492513812888L;
	private int mainId;
	private String imageName;
	private String imageUrl;
	public int getMainId() {
		return mainId;
	}
	public void setMainId(int mainId) {
		this.mainId = mainId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}