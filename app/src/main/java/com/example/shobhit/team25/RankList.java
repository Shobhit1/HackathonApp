package com.example.shobhit.team25;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;


public class RankList extends Activity {
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_list);

        final ListView listView = (ListView) findViewById(R.id.rankList);


        Integer position = (Integer) getIntent().getSerializableExtra("position");
        System.out.println(position);
        ArrayList<BranchDataBean> data = new ArrayList<BranchDataBean>(new Json().populateData(this));

        ArrayList<RankDataBean> bean = data.get(position).getRanks();
//        String title = bean.getTitle();

         adapter = new MyAdapter(this, bean);

        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rank_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


class MyAdapter extends BaseAdapter {

    private Context mContext;
    ArrayList<RankDataBean> data;


    public MyAdapter() {
        // TODO Auto-generated constructor stub
    }

    public MyAdapter(Context context, ArrayList<RankDataBean> dataForDisplay) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_ranks, parent, false);

        }

        RankDataBean rank = data.get(position);

        TextView txtViewRankTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtViewPayGrade = (TextView) convertView.findViewById(R.id.payGrade);
        TextView txtViewAbbr = (TextView) convertView.findViewById(R.id.abbr);

        ImageView imageOfEachRank = (ImageView) convertView.findViewById(R.id.image);

        Picasso.with(mContext).load(rank.getImgLinkHD()).into(imageOfEachRank);

        txtViewRankTitle.setText(rank.getTitle());
        txtViewAbbr.setText(rank.getAbbr());
        txtViewPayGrade.setText(rank.getPayGrade());


        return convertView;
    }
}