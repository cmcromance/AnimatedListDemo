package com.juno.animatedlist.demo;

import com.juno.listsample.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class MyListMain extends ListActivity implements OnClickListener, OnItemClickListener{
	
	private MyListAdapter mListAdapter;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);
        
        getListView().setOnItemClickListener(this);
        mListAdapter = new MyListAdapter(this, R.layout.list_item_layout);
        setListAdapter(mListAdapter);
        
        //> Set Demo Data
        for(int i = 0 ; i < 1000 ; i++) {
        	MyListItem item = new MyListItem();
        	
        	item.strTop = "Top Text.";
        	item.strBottom = "Bottom Text. Index = " + Integer.toString(i);
        	mListAdapter.add(item);
        }
        mListAdapter.notifyDataSetChanged();
    }

	@Override
	public void onClick(View v) {
		Log.d("TAG", "ListSample / id:" + v.getId());
	}

	@Override
	public void onItemClick(AdapterView<?> l, View v, int position, long id) {
		int viewId = l.getId();
		switch (viewId) {
		case android.R.id.list:
			MyListItem item = (MyListItem) l.getItemAtPosition(position);
			Toast.makeText(this, "ListSample / Msg = " + item.strBottom, Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}
 }