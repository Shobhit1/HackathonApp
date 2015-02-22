package com.example.shobhit.team25;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class BranchDataBean implements Serializable{

    private static final long serialVersionUID = 1L;
	String logoLink;
	String title;
	ArrayList<RankDataBean> ranks;
	
	public BranchDataBean() {
	}
	
	public BranchDataBean(String logoLink, String title, ArrayList<RankDataBean> ranks){
		super();
		this.logoLink = logoLink;
		this.title = title;
		this.ranks = ranks;
	}
	
	
	
	public String getLogoLink() {
		return logoLink;
	}
	public void setLogoLink(String logoLink) {
		this.logoLink = logoLink;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<RankDataBean> getRanks() {
		return ranks;
	}
	public void setRanks(ArrayList<RankDataBean> ranks) {
		this.ranks = ranks;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.title;
	}
	
}
