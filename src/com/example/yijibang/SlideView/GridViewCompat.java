package com.example.yijibang.SlideView;

import com.example.yijibang.sqliteDataBase.Model.Memo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

public class GridViewCompat extends ListView {

	    private static final String TAG = "GridViewCompat";

	    private boolean mViewTouchMode = false;
	    
	    private SlideView mFocusedItemView;

	    public GridViewCompat(Context context) {
	        super(context);
	         
	    }

	    public GridViewCompat(Context context, AttributeSet attrs) {
	        super(context, attrs);
	    }

	    public GridViewCompat(Context context, AttributeSet attrs, int defStyle) {
	        super(context, attrs, defStyle);
	    }

	    public void shrinkListItem(int position) {
	        View item = getChildAt(position);

	        if (item != null) {
	            try {
	                ((SlideView) item).shrink();
	            } catch (ClassCastException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    
	    
	    @Override
	    public boolean onTouchEvent(MotionEvent event) {
	    	final int action = event.getAction();
	    	
	    	
	        switch (action) {

	        case MotionEvent.ACTION_DOWN: {

	            
	            int x = (int) event.getX();
	            int y = (int) event.getY();
	            int position = pointToPosition(x, y);
	            Log.e(TAG, "postion=" + position);
	            if (position != INVALID_POSITION) {
	                Memo data = (Memo) getItemAtPosition(position);
	                mFocusedItemView = data.slideView;
	                Log.e(TAG, "FocusedItemView=" + mFocusedItemView);
	            }
	        }
	        default:
	            break;
	        }
	        if (mFocusedItemView != null) {
	            mFocusedItemView.onRequireTouchEvent(event);
	        }       
	        return true;

	    }
	    
	}

