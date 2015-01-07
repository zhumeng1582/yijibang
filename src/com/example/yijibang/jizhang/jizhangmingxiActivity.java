package com.example.yijibang.jizhang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;






import com.example.yijibang.R;
import com.example.yijibang.jizhang.biaoqian.AppAdapter;
import com.example.yijibang.jizhang.biaoqian.PageControlView;
import com.example.yijibang.jizhang.biaoqian.ScrollLayout;
import com.example.yijibang.jizhang.biaoqian.ScrollLayout.OnScreenChangeListenerDataLoad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

public class jizhangmingxiActivity extends Activity {

	private ScrollLayout mScrollLayout;
	private static final float APP_PAGE_SIZE = 8.0f;
	private Context mContext;
	private PageControlView pageControl;
	public MyHandler myHandler;
	public int n=0;
	private DataLoading dataLoad;
	private EditText editTextJine;

	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		setContentView(R.layout.activity_jizhangmingxi);
		
		mContext = this;
		editTextJine = (EditText) findViewById(R.id.editTextJine);
		
		new KeyboardUtil(this, mContext, editTextJine).showKeyboard();
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
				
//				if (s.toString().trim().substring(0).equals(".")) {
//					s = "0" + s;
//					editTextJine.setText(s);
//					editTextJine.setSelection(s.length());
//				}
				
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
//				
			}
		});
		
		dataLoad = new DataLoading();
		mScrollLayout = (ScrollLayout)findViewById(R.id.ScrollLayoutTest);
		myHandler = new MyHandler(this,1);
		
		//��һ���̸߳�������
		MyThread m = new MyThread();
		new Thread(m).start();
		
	}
	/**
	 * gridView ��onItemLick��Ӧ�¼�
	 */
	public OnItemClickListener listener = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			System.out.println("position="+position);
		}
		
	};
	
	// ���º�̨����
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
			Bundle b = new Bundle();// �������
			b.putString("rmsg", msglist);
			msg.setData(b);
			jizhangmingxiActivity.this.myHandler.sendMessage(msg); // ��Handler������Ϣ,����UI

		}
	}

	class MyHandler extends Handler {
		private jizhangmingxiActivity mContext;
		public MyHandler(Context conn,int a) {
			mContext = (jizhangmingxiActivity)conn;
		}

		public MyHandler(Looper L) {
			super(L);
		}

		// ���������д�˷���,��������
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			Bundle b = msg.getData();
			String rmsg = b.getString("rmsg");
			if ("1".equals(rmsg)) {
				// do nothing
				 List<Map> list = new ArrayList<Map>();
				 for(int i =0;i<14;i++){
					 n++;
					 Map map = new HashMap();
				        map.put("name", n);
				        list.add(map);
				 }
			        
				int pageNo = (int)Math.ceil( list.size()/APP_PAGE_SIZE);
				for (int i = 0; i < pageNo; i++) {
					GridView appPage = new GridView(mContext);
					// get the "i" page data
					appPage.setAdapter(new AppAdapter(mContext, list, i));
					appPage.setNumColumns(4);
					appPage.setColumnWidth(14);
					appPage.setVerticalSpacing(16);
					appPage.setOnItemClickListener(listener);
					mScrollLayout.addView(appPage);
				}
				//���ط�ҳ
				pageControl = (PageControlView) findViewById(R.id.pageControl);
				pageControl.bindScrollViewGroup(mScrollLayout);
				//���ط�ҳ����
				dataLoad.bindScrollViewGroup(mScrollLayout);
					
				}
			}

		}
	
	
	//��ҳ����
	class DataLoading {
		private int count;
		public void bindScrollViewGroup(ScrollLayout scrollViewGroup) {
			this.count=scrollViewGroup.getChildCount();
			scrollViewGroup.setOnScreenChangeListenerDataLoad(new OnScreenChangeListenerDataLoad() {
				public void onScreenChange(int currentIndex) {
					// TODO Auto-generated method stub
					generatePageControl(currentIndex);
				}
			});
		}
		
		private void generatePageControl(int currentIndex){
			//��������һҳ���ͼ���16����¼
//			if(count==currentIndex+1){
//				MyThread m = new MyThread();
//				new Thread(m).start();
//			}
		}
	}
}
