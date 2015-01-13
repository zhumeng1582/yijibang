package com.example.yijibang.jizhang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.yijibang.R;
import com.example.yijibang.jizhang.KeyboardUtil.OnKeyClickListener;
import com.example.yijibang.jizhang.biaoqian.AppAdapter;
import com.example.yijibang.jizhang.biaoqian.PageControlView;
import com.example.yijibang.jizhang.biaoqian.ScrollLayout;
import com.example.yijibang.jizhang.biaoqian.ScrollLayout.OnScreenChangeListener;
import com.example.yijibang.jizhang.biaoqian.ScrollLayout.OnScreenChangeListenerDataLoad;
import com.example.yijibang.sqliteDataBase.Model.BiaoQian;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class tianjiajizhangActivity extends Activity {

	private ScrollLayout mScrollLayout;
	private static final float APP_PAGE_SIZE = 8.0f;
	private Context mContext;
	private PageControlView pageControl;
	public MyHandler myHandler;
	private DataLoading dataLoad;
	private EditText editTextJine;
	
	private View viewSave,viewReturn;
	private List<GridView> listAppPage;
	private List<AppAdapter> listAppAdapter;
	
	private KeyboardUtil keyboardUtil;

	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		setContentView(R.layout.activity_jizhangmingxi);
		
		listAppPage = new ArrayList<GridView>();
		listAppAdapter = new ArrayList<AppAdapter>();
		
		viewSave = findViewById(R.id.viewSave);
		viewSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		
		viewReturn = findViewById(R.id.viewReturn);
		viewReturn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		
		mContext = this;
		editTextJine = (EditText) findViewById(R.id.editTextJine);
		
		keyboardUtil =  new KeyboardUtil(this, mContext, editTextJine);

		keyboardUtil.showKeyboard();
		
		keyboardUtil.setOnKeyClickListener(new OnKeyClickListener() {
			
			@Override
			public void onKeyClick(int keyCode) {
				if(keyCode==0)
					finish();
				
			}
		});
		
		
		editTextJine.setSelection(1);

		editTextJine.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
				if (s.toString().contains(".")) {
					
					String value = s.toString().substring(s.toString().indexOf(".")+1, s.length());
					if(value.contains(".")){
						s = s.toString().subSequence(0,s.length()-1);
						editTextJine.setText(s); 
						editTextJine.setSelection(s.length());
					}else if (s.length() - 1 - s.toString().indexOf(".") > 2) {
						s = s.toString().subSequence(0,s.toString().indexOf(".") + 3);
						editTextJine.setText(s); 
						editTextJine.setSelection(s.length());
					}
				}

				
				if (s.toString().startsWith("0") && s.toString().trim().length() > 1) {
					if (!s.toString().substring(1, 2).equals(".")) {
						editTextJine.setText(s.subSequence(1, 2));
						editTextJine.setSelection(1);
					}
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
                    int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
				String value = editTextJine.getText().toString(); 
				if(value.length()==0){
					editTextJine.setText("0");
					editTextJine.setSelection(1);
				}
			}
		});
		
		dataLoad = new DataLoading();
		mScrollLayout = (ScrollLayout)findViewById(R.id.ScrollLayoutTest);
		pageControl = (PageControlView) findViewById(R.id.pageControl);
		
		myHandler = new MyHandler(this,1);
		
		MyThread m = new MyThread();
		new Thread(m).start();

	}

	
	// 更新后台数据
	class MyThread implements Runnable {
		public void run() {
			try {
				Thread.sleep(10*3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String msglist = "1";
			Message msg = new Message();
			Bundle b = new Bundle();// 存放数据
			b.putString("BiaoQianMing", msglist);
			msg.setData(b);
			tianjiajizhangActivity.this.myHandler.sendMessage(msg); // 向Handler发送消息,更新UI

		}
	}
	
	private List<BiaoQian> getData(int selPage,int selPosition){
		List<BiaoQian> list = new ArrayList<BiaoQian>();
		 
		for(int i=0;i<14;i++){
			if(i == selPage*8+selPosition)
				 list.add(new BiaoQian(R.drawable.biaoqian_border_red, "吃饭"));
			else
				list.add(new BiaoQian(R.drawable.biaoqian_border, "吃饭"));
		}
	     return list;
	}

	class MyHandler extends Handler {
		private tianjiajizhangActivity mContext;
		public MyHandler(Context conn,int a) {
			mContext = (tianjiajizhangActivity)conn;
		}

		public MyHandler(Looper L) {
			super(L);
		}

		// 子类必须重写此方法,接受数据
		@SuppressLint("NewApi")
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			Bundle b = msg.getData();
			String rmsg = b.getString("BiaoQianMing");
			if ("1".equals(rmsg)) {

				List<BiaoQian> list = getData(0,0);
				
				int pageNo = (int)Math.ceil( list.size()/APP_PAGE_SIZE);
				for (int i = 0; i < pageNo; i++) {
					listAppPage.add(new GridView(mContext));
					//GridView appPage = ;
					List<BiaoQian> mList = new ArrayList<BiaoQian>();
					int iStart = (int) (i * APP_PAGE_SIZE);
					int iEnd = (int) (iStart+APP_PAGE_SIZE);
					while ((iStart<list.size()) && (iStart<iEnd)) {
						mList.add(list.get(iStart));
						iStart++;
					}
					
					
					listAppAdapter.add(new AppAdapter(mContext, mList));
					
					
					listAppPage.get(i).setAdapter(listAppAdapter.get(i));

					listAppPage.get(i).setNumColumns(4);
					listAppPage.get(i).setColumnWidth(14);
					listAppPage.get(i).setHorizontalSpacing(16);
					
					listAppPage.get(i).setVerticalSpacing(16);
					listAppPage.get(i).setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1,
								int position, long arg3) {
							
							int page = mScrollLayout.getCurScreen();
							List<BiaoQian> list = getData(page,position);
							
							int pageNo = (int)Math.ceil( list.size()/APP_PAGE_SIZE);
							listAppAdapter = new ArrayList<AppAdapter>();
							for (int i = 0; i < pageNo; i++){
								List<BiaoQian> mList = new ArrayList<BiaoQian>();
								int iStart = (int) (i * APP_PAGE_SIZE);
								int iEnd = (int) (iStart+APP_PAGE_SIZE);
								while ((iStart<list.size()) && (iStart<iEnd)) {
									mList.add(list.get(iStart));
									iStart++;
								}
								
//								listAppAdapter.add(new AppAdapter(mContext, mList));
//								listAppAdapter.get(i).notifyDataSetChanged();
								listAppPage.get(i).setAdapter(new AppAdapter(mContext, mList));
							}
						}
					});
					
					mScrollLayout.addView(listAppPage.get(i));
				}
				
				//加载分页数据
				dataLoad.bindScrollViewGroup(mScrollLayout);
				//加载分页
				pageControl.bindScrollViewGroup(mScrollLayout);
					
				}
			}

		}
	
	
	//分页数据
	class DataLoading {
		private int count;
		private int currentIndex;
		public void bindScrollViewGroup(ScrollLayout scrollViewGroup) {
			this.setCount(scrollViewGroup.getChildCount());
			
			scrollViewGroup.setOnScreenChangeListenerDataLoad(new OnScreenChangeListenerDataLoad() {
				public void onScreenChange(int currentIndex) {
					// TODO Auto-generated method stub
					generatePageControl(currentIndex);
					
				}
			});

		}
		
		private void generatePageControl(int currentIndex){
			
			//如果到最后一页，就加载16条记录
//			if(count==currentIndex+1){
//				MyThread m = new MyThread();
//				new Thread(m).start();
//			}
		}


		public int getCurrentIndex() {
			return currentIndex;
		}
		
		public void setCount(int count) {
			this.count = count;
		}
	}
	
}
