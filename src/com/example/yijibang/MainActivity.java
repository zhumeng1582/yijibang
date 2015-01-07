package com.example.yijibang;



import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yijibang.beiwang.beiwangActivity;
import com.example.yijibang.jizhang.jizhangActivity;
import com.example.yijibang.mima.mimaActivity;
import com.example.yijibang.shezhi.shezhiActivity;

public class MainActivity extends TabActivity {

	private TabHost tabHost;
	
	private String one = "one";
	private String two = "two";
	private String three = "three";
	private String four = "four";
	
	private RelativeLayout main_tab_jizhang, main_tab_beiwang, main_tab_mima,main_tab_shezhi;
	private ImageView img_tab_jizhang ,img_tab_beiwang,img_tab_mima,img_tab_shezhi ;
	private TextView text_tab_jizhang ,text_tab_beiwang,text_tab_mima,text_tab_shezhi;
	
	private Resources  res;
	
	@SuppressWarnings("deprecation")
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
		setContentView(R.layout.activity_main);
		
		res = getResources();
		tabHost=getTabHost();
		
		initTab();
		init();
	}
	
        
	private void init() {
    	//点击底部
    	main_tab_jizhang = (RelativeLayout) findViewById(R.id.main_tab_jizhang);
    	main_tab_beiwang = (RelativeLayout) findViewById(R.id.main_tab_beiwang);
    	main_tab_mima=(RelativeLayout) findViewById(R.id.main_tab_mima);
    	main_tab_shezhi=(RelativeLayout) findViewById(R.id.main_tab_shezhi);
        
    	//底部图片跟换                
    	img_tab_jizhang = (ImageView) findViewById(R.id.img_tab_jizhang) ;
    	img_tab_beiwang = (ImageView) findViewById(R.id.img_tab_beiwang) ;
    	img_tab_mima = (ImageView) findViewById(R.id.img_tab_mima) ;
    	img_tab_shezhi = (ImageView) findViewById(R.id.img_tab_shezhi) ;
    	
    	//底部文字
    	text_tab_jizhang = (TextView) findViewById(R.id.tab_jizhang_text) ;
    	text_tab_beiwang = (TextView) findViewById(R.id.tab_beiwang_text) ;
    	text_tab_mima = (TextView) findViewById(R.id.tab_mima_text) ;
    	text_tab_shezhi = (TextView) findViewById(R.id.tab_shezhi_text) ;
    	
        main_tab_jizhang.setOnClickListener(new OnClickListener() {
        	public void onClick(View arg0) {
        		if(tabHost.getCurrentTabTag().equals(one)){
        			return;
        		}
        		tabHost.setCurrentTabByTag(one);
 
                //图片点亮
                img_tab_jizhang.setImageResource(R.drawable.jizhangsel);
                img_tab_beiwang.setImageResource(R.drawable.beiwang);
                img_tab_mima.setImageResource(R.drawable.mima);
                img_tab_shezhi.setImageResource(R.drawable.shezhi);
                //文字点亮
                text_tab_jizhang.setTextColor(res.getColor(R.color.shen));
                text_tab_beiwang.setTextColor(res.getColor(R.color.qian));
                text_tab_mima.setTextColor(res.getColor(R.color.qian));
                text_tab_shezhi.setTextColor(res.getColor(R.color.qian));
            }
        });
        
        main_tab_beiwang.setOnClickListener(new OnClickListener() {
        	public void onClick(View arg0) {
        		if(tabHost.getCurrentTabTag().equals(two)){
        			return;
        		}
        		
        		tabHost.setCurrentTabByTag(two);
                            	
                //图片点亮
                img_tab_jizhang.setImageResource(R.drawable.jizhang);
                img_tab_beiwang.setImageResource(R.drawable.beiwangsel);
                img_tab_mima.setImageResource(R.drawable.mima);
                img_tab_shezhi.setImageResource(R.drawable.shezhi);
                //文字点亮
                text_tab_jizhang.setTextColor(res.getColor(R.color.qian));
                text_tab_beiwang.setTextColor(res.getColor(R.color.shen));
                text_tab_mima.setTextColor(res.getColor(R.color.qian));
                text_tab_shezhi.setTextColor(res.getColor(R.color.qian));
            }
        });
        
        main_tab_mima.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		if(tabHost.getCurrentTabTag().equals(three)){
        			return;
        		}
        		
        		tabHost.setCurrentTabByTag(three);
    			//图片点亮
    			img_tab_jizhang.setImageResource(R.drawable.jizhang);
    	        img_tab_beiwang.setImageResource(R.drawable.beiwang);
    	        img_tab_mima.setImageResource(R.drawable.mimasel);
    	        img_tab_shezhi.setImageResource(R.drawable.shezhi);
    	        //文字点亮
    	        text_tab_jizhang.setTextColor(res.getColor(R.color.qian));
    	        text_tab_beiwang.setTextColor(res.getColor(R.color.qian));
    	        text_tab_mima.setTextColor(res.getColor(R.color.shen));
    	        text_tab_shezhi.setTextColor(res.getColor(R.color.qian));
        	}
        });
            
        main_tab_shezhi.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		
        		if(tabHost.getCurrentTabTag().equals(four)){
        			return;
        		}
        		tabHost.setCurrentTabByTag(four);
        		//图片点亮
		        img_tab_jizhang.setImageResource(R.drawable.jizhang);
		        img_tab_beiwang.setImageResource(R.drawable.beiwang);
		        img_tab_mima.setImageResource(R.drawable.mima);
		        img_tab_shezhi.setImageResource(R.drawable.shezhisel);
		        //文字点亮
		        text_tab_jizhang.setTextColor(res.getColor(R.color.qian));
		        text_tab_beiwang.setTextColor(res.getColor(R.color.qian));
		        text_tab_mima.setTextColor(res.getColor(R.color.qian));
		        text_tab_shezhi.setTextColor(res.getColor(R.color.shen));
        	}
        });
    }
    private void initTab(){
    	tabHost.addTab(tabHost.newTabSpec(one).setIndicator(one).setContent(
    		new Intent(this, jizhangActivity.class)));
    	tabHost.addTab(tabHost.newTabSpec(two).setIndicator(two).setContent(
    		new Intent(this, beiwangActivity.class)));
    	tabHost.addTab(tabHost.newTabSpec(three).setIndicator(three).setContent(
    		new Intent(this, mimaActivity.class)));
    	tabHost.addTab(tabHost.newTabSpec(four).setIndicator(four).setContent(
    		new Intent(this, shezhiActivity.class)));
    }
   
    
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){   
            if((System.currentTimeMillis()-exitTime) > 2000){  
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();                                
                exitTime = System.currentTimeMillis();   
            } else {
                finish();
                System.exit(0);
            }
            return true;   
        }
        return super.onKeyDown(keyCode, event);
    }
    
    public void SetCurrentTab(int index){
    	if(index==0){
    		main_tab_jizhang.performClick();
    	}else if(index ==1){
    		img_tab_beiwang.performClick();
    	}else if(index == 2){
    		text_tab_mima.performClick();
    	}else if(index ==4){
    		text_tab_shezhi.performClick();
    	}
    }
   
    
}

