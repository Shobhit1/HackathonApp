package com.example.shobhit.team25;

import android.app.Activity;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Json extends Activity {


	public String loadJSONFromAsset(Context context) {
	    String json = null;
	    try {

	        InputStream is = context.getResources().getAssets().open("ranks.json");

	        int size = is.available();

	        byte[] buffer = new byte[size];

	        is.read(buffer);

	        is.close();

	        json = new String(buffer, "UTF-8");


	    } catch (IOException ex) {
	        ex.printStackTrace();
	        return null;
	    }
	    return json;

	}


    

	public ArrayList<BranchDataBean> populateData(Context context){

		ArrayList<BranchDataBean> branchesList = new ArrayList<BranchDataBean>();
		
		try {

			JSONObject jsonObject  = (JSONObject) new JSONObject(loadJSONFromAsset(context));

			String[] branches = {"army", "marines", "airForce", "navy", "coastGuard"};

			for(String branch: branches){


				JSONObject branchJSON = (JSONObject) jsonObject.get(branch);
				String logo = (String) branchJSON.get("logo");

				JSONArray ranks = (JSONArray) branchJSON.get("ranks");

				ArrayList<RankDataBean> rankData = new ArrayList<RankDataBean>();

				/*
				 * Populating the rank data array list here
				 */
				for(int i=0; i<ranks.length(); i++){
					String imgLink = "";
					String imagelinkHD = "";

					JSONObject information = (JSONObject) ranks.get(i);

					String pg = information.get("payGrade").toString();
					String abbr = information.get("abbreviation").toString();
					String title =  information.get("title").toString();

					if(information.get("insigniaImage") != null){
						imgLink = information.get("insigniaImage").toString();
					}
					if(information.get("insigniaImageHD") != null){
						imagelinkHD = information.get("insigniaImageHD").toString();
					}
					RankDataBean rankOb = new RankDataBean(pg,abbr,title,imgLink, imagelinkHD);
					rankData.add(rankOb);

				}


				BranchDataBean branchData = new BranchDataBean(logo,branch,rankData);
				branchesList.add(branchData);

			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		return branchesList;
		
	}

	public static void main(String[] args) {

	}
}