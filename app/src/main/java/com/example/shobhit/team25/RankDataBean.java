package com.example.shobhit.team25;


import java.io.Serializable;

public class RankDataBean implements Serializable {
	String payGrade;
	String abbr;
	String title;
	String imgLink;
	String imgLinkHD;




    public RankDataBean() {
		// TODO Auto-generated constructor stub
	}
	
	public RankDataBean(String payGrade, String abbr, String title, String imgLink, String imgLinkHD){
		super();
		this.payGrade = payGrade;
		this.abbr = abbr;
		this.title = title;
		this.imgLink = imgLink;
		this.imgLinkHD = imgLinkHD;
	}
	
	
	public String getPayGrade() {
		return payGrade;
	}
	public void setPayGrade(String payGrade) {
		this.payGrade = payGrade;
	}
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgLink() {
		return imgLink;
	}
	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
	public String getImgLinkHD() {
		return imgLinkHD;
	}
	public void setImgLinkHD(String imgLinkHD) {
		this.imgLinkHD = imgLinkHD;
	}
	
	
	
	
}
