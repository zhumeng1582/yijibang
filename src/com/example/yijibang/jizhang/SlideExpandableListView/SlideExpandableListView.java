package com.example.yijibang.jizhang.SlideExpandableListView;

import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Scroller;
import android.content.Context;

/**
 * Simple subclass of listview which does nothing more than wrap
 * any ListAdapter in a SlideExpandalbeListAdapter
 */
class SlideExpandableListView extends ListView {
	private SlideExpandableListAdapter adapter;
	private Scroller mScroller = null ; //Scroller对象实例
	private int expandableToggleView;

	public SlideExpandableListView(Context context) {
		super(context);
		 mScroller = new Scroller(context);  
	        //初始化一个最小滑动距离  
	     mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();  
	}

	public SlideExpandableListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SlideExpandableListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * Collapses the currently open view.
	 *
	 * @return true if a view was collapsed, false if there was no open view.
	 */
	public boolean collapse() {
		if(adapter!=null) {
			return adapter.collapseLastOpen();
		}
		return false;
	}

	public void setAdapter(ListAdapter adapter,int expandableToggleView, int expandable) {
		this.expandableToggleView = expandableToggleView;
		this.adapter = new SlideExpandableListAdapter(adapter,expandableToggleView,expandable);
		super.setAdapter(this.adapter);
	}


	/**
	 * Registers a OnItemClickListener for this listview which will
	 * expand the item by default. Any other OnItemClickListener will be overriden.
	 *
	 * To undo call setOnItemClickListener(null)
	 *
	 * Important: This method call setOnItemClickListener, so the value will be reset
	 */
//	public void enableExpandOnItemClick() {
//		this.setOnItemClickListener(new OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//				SlideExpandableListAdapter adapter = (SlideExpandableListAdapter)getAdapter();
//				adapter.getExpandToggleButton(view).performClick();
//			}
//		});
//	}


	@Override
	public Parcelable onSaveInstanceState() {
		return adapter.onSaveInstanceState(super.onSaveInstanceState());
	}

	@Override
	public void onRestoreInstanceState(Parcelable state) {
		if(!(state instanceof AbstractSlideExpandableListAdapter.SavedState)) {
			super.onRestoreInstanceState(state);
			return;
		}

		AbstractSlideExpandableListAdapter.SavedState ss = (AbstractSlideExpandableListAdapter.SavedState)state;
		super.onRestoreInstanceState(ss.getSuperState());

		adapter.onRestoreInstanceState(ss);
	}
	
	private static final int TOUCH_STATE_REST = 0;  
    private static final int TOUCH_STATE_HORIZONTAL_SCROLLING = 1;  
    private static final int TOUCH_STATE_VERTICAL_SCROLLING = -1;  
    private int mTouchSlop;  
    private int mTouchState = TOUCH_STATE_REST;  
    private float mLastMotionX;  
    private float mLastMotionY;
////    
//	public boolean onInterceptTouchEvent(MotionEvent ev)   {
//		  
//		final int action = ev.getAction();  
//        boolean intercept = false;
//        switch (action) {  
//        case MotionEvent.ACTION_MOVE:  
//              
//            /* 
//             * If we're in a horizontal scroll event, take it (intercept further events). But if 
//             * we're mid-vertical-scroll, don't even try; let the children deal with it. If we 
//             * haven't found a scroll event yet, check for one. 
//             */  
//            if (mTouchState == TOUCH_STATE_HORIZONTAL_SCROLLING) {  
//                // Let children handle the events for the duration of the scroll event.  
//                intercept = false;  
//            } else if (mTouchState == TOUCH_STATE_VERTICAL_SCROLLING) {  
//                   /* 
//                 * We've already started a horizontal scroll; set intercept to true so we can 
//                 * take the remainder of all touch events in onTouchEvent. 
//                 */  
//                intercept = true;  
//            } else { // We haven't picked up a scroll event yet; check for one.  
//
//                /* 
//                 * If we detected a horizontal scroll event, start stealing touch events (mark 
//                 * as scrolling). Otherwise, see if we had a vertical scroll event -- if so, let 
//                 * the children handle it and don't look to intercept again until the motion is 
//                 * done. 
//                 */  
//
//                final float x = ev.getX();  
//                final int xDiff = (int) Math.abs(x - mLastMotionX);  
//                boolean xMoved = xDiff > mTouchSlop;  
//                  
//                final float y = ev.getY();  
//                final int yDiff = (int) Math.abs(y - mLastMotionY);  
//                boolean yMoved = yDiff > mTouchSlop;  
//
//                  
//                if (xMoved) {  
//                    if(xDiff>=yDiff)  
//                    mTouchState = TOUCH_STATE_HORIZONTAL_SCROLLING;  
//                    //mLastMotionX = x;  
//                }  
//
//                if (yMoved) {  
//                    if(yDiff>xDiff)  
//                    mTouchState = TOUCH_STATE_VERTICAL_SCROLLING;  
//                    //mLastMotionY = y;  
//                }  
//            }  
//
//            break;  
//        case MotionEvent.ACTION_CANCEL:  
//        case MotionEvent.ACTION_UP:  
//            mTouchState = TOUCH_STATE_REST;  
//            intercept = false;  
//            break;  
//        case MotionEvent.ACTION_DOWN:  
//
//             mTouchState = TOUCH_STATE_REST;  
//            mLastMotionY = ev.getY();  
//            mLastMotionX = ev.getX();  
//            break;  
//        default:  
//            break;  
//        }  
//	  
//	    
//        return true;
//	}
}