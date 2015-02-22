package com.example.shobhit.team25;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends Activity {


	CustomAdapter myAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ListView listView = (ListView) findViewById(R.id.mainList);
		
		ArrayList<BranchDataBean> data = new ArrayList<BranchDataBean>(new Json().populateData(this));
		myAdapter = new CustomAdapter(this, data);
		
		listView.setAdapter(myAdapter);
		
//		getActionBar().show();
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}


class CustomAdapter extends BaseAdapter{

	private Context mContext;
	ArrayList<BranchDataBean> data;


	public CustomAdapter() {
		// TODO Auto-generated constructor stub
	}

	public CustomAdapter(Context context, ArrayList<BranchDataBean> dataForDisplay){
		this.mContext = context;
		data = dataForDisplay;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent){
		
		
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_item,parent, false);

		}

		BranchDataBean br = data.get(position);
		
		TextView txtViewNameOfBranch = (TextView) convertView.findViewById(R.id.nameOfBranchInMain);


                ImageView imageOfBranch = (ImageView) convertView.findViewById(R.id.imageMain);

                txtViewNameOfBranch.setText(br.getTitle());


        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                BranchDataBean cb = data.get(position);
                Intent intent = new Intent(mContext, RankList.class);


                intent.putExtra("position" , position);
                mContext.startActivity(intent);

            }
        });

		return convertView;
	}

}