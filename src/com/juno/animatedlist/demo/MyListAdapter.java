package com.juno.animatedlist.demo;

import com.juno.listsample.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyListAdapter extends ArrayAdapter<MyListItem> {
	
	private LayoutInflater mLayoutInflater;
	private BitmapDrawable icon01;
	private View.OnClickListener mButtonListener;
	private int mViewResourceId;

	public MyListAdapter(Context context, int viewResourceId) {
		super(context, viewResourceId);
		mViewResourceId = viewResourceId;
		
		mLayoutInflater = ((Activity)context).getLayoutInflater();
		icon01 = (BitmapDrawable)context.getResources().getDrawable(R.drawable.icon01);
		setButtonListener();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		
		if(convertView == null) {
			convertView = mLayoutInflater.inflate(mViewResourceId, parent, false);
			
			viewHolder = new ViewHolder();
			viewHolder.top = (TextView)convertView.findViewById(R.id.txt_top);
			viewHolder.bottom = (TextView)convertView.findViewById(R.id.txt_bottom);
			viewHolder.main_icon = (ImageView)convertView.findViewById(R.id.main_icon);
			viewHolder.btn01 = (Button)convertView.findViewById(R.id.button01);
			viewHolder.btn02 = (Button)convertView.findViewById(R.id.button02);
			convertView.setTag(viewHolder);
		} 
		else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.btn01.setTag(position);
		viewHolder.btn01.setOnClickListener(mButtonListener);
		viewHolder.btn02.setTag(position);
		viewHolder.btn02.setOnClickListener(mButtonListener);
		
		MyListItem item = getItem(position);

		if(item != null) {
			viewHolder.main_icon.setImageDrawable(icon01);
			viewHolder.top.setText(item.strTop);
			viewHolder.top.setSelected(true); 
			viewHolder.bottom.setText(item.strBottom);
		}
		return convertView;
	}

	private void setButtonListener() {
		mButtonListener = new View.OnClickListener() {
			public void onClick(View v) {
				int viewId = v.getId();
				int iPosition = Integer.parseInt(v.getTag().toString());
				switch (viewId) {
				case R.id.button01:
					Toast.makeText(v.getContext(), "Position : " + iPosition + " / Button 1 Clicked !!", Toast.LENGTH_SHORT).show();
					break;
				case R.id.button02:
					Toast.makeText(v.getContext(), "Position : " + iPosition + " / Button 2 Clicked !!", Toast.LENGTH_SHORT).show();
					break;
				default:
					break;
				}
			}
		};
	}
	
	private class ViewHolder {
		TextView top;
		TextView bottom;
		ImageView main_icon;
		Button btn01;
		Button btn02;
	}
}
