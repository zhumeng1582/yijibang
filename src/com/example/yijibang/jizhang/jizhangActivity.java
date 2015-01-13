package com.example.yijibang.jizhang;

import java.util.ArrayList;
import java.util.List;

import com.example.yijibang.R;
import com.example.yijibang.SlideView.MessageItem;
import com.example.yijibang.jizhang.SlideExpandableListView.ActionSlideExpandableListView;
import com.example.yijibang.jizhang.SlideExpandableListView.ListViewAdapter;
import com.example.yijibang.jizhang.SlideExpandableListView.SeletorDataInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ListView;
import android.widget.RelativeLayout;


public class jizhangActivity extends Activity {

	private RelativeLayout relativieLayout3;
	private RoundProgressBar roundProgressBarShouRu;
	private RoundProgressBar roundProgressBarZhiChu;
	private RoundProgressBar roundProgressBarJieYu;
	
	private List<SeletorDataInfo> roomList = new  ArrayList<SeletorDataInfo>(); 
	private List<MessageItem> subList = new  ArrayList<MessageItem>(); 
	private List<List<MessageItem>> allList = new  ArrayList<List<MessageItem>>();
	
	private ActionSlideExpandableListView list;
	
	
	@SuppressWarnings("unused")
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_jizhang);
		
		
		View emptyView = findViewById(R.id.empty);
		
		relativieLayout3 = (RelativeLayout) findViewById(R.id.relativieLayout3);
		
		relativieLayout3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent();
				i.setClass(jizhangActivity.this,tianjiajizhangActivity.class);
				startActivity(i);
			}
		});
		
		roundProgressBarShouRu = (RoundProgressBar) findViewById(R.id.roundProgressBarShouRu);
		roundProgressBarShouRu.setMax(8800);
		roundProgressBarShouRu.setProgress(8800);
		
		roundProgressBarZhiChu = (RoundProgressBar) findViewById(R.id.roundProgressBarZhiChu);
		roundProgressBarZhiChu.setMax(8800);
		roundProgressBarZhiChu.setProgress(2200);
		
		roundProgressBarJieYu = (RoundProgressBar) findViewById(R.id.roundProgressBarJieYu);
		roundProgressBarJieYu.setMax(8800);
		roundProgressBarJieYu.setProgress(6600);
		
		list = (ActionSlideExpandableListView)this.findViewById(R.id.list);
//		
//
		roomList.add(new SeletorDataInfo("11.00"));
		for (int i = 0; i <3; i++) {
            MessageItem item = new MessageItem();
            if (i % 3 == 0) {
                
                item.tvTitle1 = "ÂòÒÂ·þ";
                item.listview_item_name = "-11.00";
                
            } else {
                item.tvTitle1 = "³Ô·¹";
                
                item.listview_item_name = "-11.00";
            }
            subList.add(item);
        }
		allList.add(subList);
		
		
		roomList.add(new SeletorDataInfo("11.00"));
		subList =new  ArrayList<MessageItem>(); 
		for (int i = 0; i < 5; i++) {
            MessageItem item = new MessageItem();
            if (i % 3 == 0) {
                
                item.tvTitle1 = "ÂòÒÂ·þ";
                item.listview_item_name = "-11.00";
                
            } else {
                item.tvTitle1 = "³Ô·¹";
                
                item.listview_item_name = "-11.00";
            }
            subList.add(item);
        }
		allList.add(subList);

		ListViewAdapter mListViewAdapter = new ListViewAdapter(this, roomList, allList);
	
		list.setEmptyView(emptyView);
	
		if(mListViewAdapter==null)
			mListViewAdapter = new ListViewAdapter(this, null, null);
		
		list.setAdapter(mListViewAdapter);

	}
}
