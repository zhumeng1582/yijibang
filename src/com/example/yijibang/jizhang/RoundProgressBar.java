package com.example.yijibang.jizhang;

import java.text.DecimalFormat;

import com.example.yijibang.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 仿iphone带进度的进度条，线程安全的View，可直接在线程中更新进度
 * @author xiaanming
 *
 */
public class RoundProgressBar extends View {
	/**
	 * 画笔对象的引用
	 */
	private Paint paint;
	
	/**
	 * 圆环的颜色
	 */
	private int roundColor;
	
	/**
	 * 圆环进度的颜色
	 */
	private int roundProgressColor;
	/**
	 * 中间进度百分比的字符串的颜色
	 */
	private String title;
	private int textColor;
	
	/**
	 * 中间进度百分比的字符串的字体
	 */
	private float textSize;
	
	/**
	 * 圆环的宽度
	 */
	private float roundWidth;
	
	/**
	 * 最大进度
	 */
	private float max=0;
	
	/**
	 * 当前进度
	 */
	private float progress=0;
	
	public static final int STROKE = 0;
	public static final int FILL = 1;
	
	public RoundProgressBar(Context context) {
		this(context, null);
	}

	public RoundProgressBar(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public RoundProgressBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		paint = new Paint();

		
		TypedArray mTypedArray = context.obtainStyledAttributes(attrs,
				R.styleable.RoundProgressBar);
		
		//获取自定义属性和默认值
		roundColor = mTypedArray.getColor(R.styleable.RoundProgressBar_roundColor, Color.RED);
		roundProgressColor = mTypedArray.getColor(R.styleable.RoundProgressBar_roundProgressColor, Color.GREEN);
		textColor = mTypedArray.getColor(R.styleable.RoundProgressBar_textColor, Color.WHITE);
		textSize = mTypedArray.getDimension(R.styleable.RoundProgressBar_textSize, 20);
		roundWidth = mTypedArray.getDimension(R.styleable.RoundProgressBar_roundWidth, 5);
		title = mTypedArray.getNonResourceString(R.styleable.RoundProgressBar_textTitle);
		
		max =  mTypedArray.getFloat(R.styleable.RoundProgressBar_max, 0);
	
		mTypedArray.recycle();
	}
	

	@SuppressLint({ "ResourceAsColor", "DrawAllocation" })
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		//画最外层的大圆环
		int centre = (int) getWidth()/2; //获取圆心的x坐标
		int radius = (int) (centre -roundWidth-roundWidth/2); //圆环的半径
		paint.setColor(roundColor); //设置圆环的颜色
		//paint.setStyle(Paint.Style.STROKE); //设置空心
		//paint.setStrokeWidth(roundWidth); //设置圆环的宽度
		paint.setAntiAlias(true);  //消除锯齿 
		//canvas.drawCircle(centre, centre, radius, paint); //画出圆环
		
		//填充为实心
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		RectF oval = new RectF(centre - radius, centre - radius, centre
				+ radius, centre + radius);
		canvas.drawArc(oval, 0, 360 , true, paint);  
		Log.e("log", centre + "");
		
		
		paint.setStrokeWidth(0); 
		paint.setColor(textColor);
		paint.setTextSize(textSize);
		paint.setTypeface(Typeface.DEFAULT); //设置字体
		
		float textWidth = paint.measureText(title);   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
		canvas.drawText(title, centre - textWidth / 2, centre-textSize/2, paint); 
		
		DecimalFormat df = new DecimalFormat("######0.00"); 
		String value = df.format(progress) ;
		textWidth = paint.measureText(value); 
		canvas.drawText(value, centre - textWidth / 2, centre + textSize, paint);
		
		//画画圆环的进度

		oval = new RectF(centre - radius-roundWidth, centre - radius-roundWidth, centre
				+ radius+roundWidth, centre + radius+roundWidth);
		
		paint.setStrokeWidth(roundWidth); //设置圆环的宽度
		paint.setColor(roundProgressColor);  //设置进度的颜色
		paint.setStyle(Paint.Style.STROKE);
		if(max==progress)
			canvas.drawArc(oval, 270,360, false, paint);  //根据进度画圆弧
		else if(title.equals("支出"))
			canvas.drawArc(oval, 270,-(int)( 360.0 * progress / max), false, paint);  //根据进度画圆弧
		else if(title.equals("结余"))
			canvas.drawArc(oval, 270,(int)( 360.0 * progress / max), false, paint);  //根据进度画圆弧
	}
	
	
	public synchronized float getMax() {
		return max;
	}

	/**
	 * 设置进度的最大值
	 * @param max
	 */
	public synchronized void setMax(float max) {
		if(max < 0){
			throw new IllegalArgumentException("max not less than 0");
		}
		this.max = max;
	}

	/**
	 * 获取进度.需要同步
	 * @return
	 */
	public synchronized float getProgress() {
		return progress;
	}

	/**
	 * 设置进度，此为线程安全控件，由于考虑多线的问题，需要同步
	 * 刷新界面调用postInvalidate()能在非UI线程刷新
	 * @param progress
	 */
	public synchronized void setProgress(float progress) {
		if(progress < 0){
			throw new IllegalArgumentException("progress not less than 0");
		}
		if(progress > max){
			progress = max;
		}
		if(progress <= max){
			this.progress = progress;
			postInvalidate();
		}
		
	}
	
	
	public int getCricleColor() {
		return roundColor;
	}

	public void setCricleColor(int cricleColor) {
		this.roundColor = cricleColor;
	}

	public int getCricleProgressColor() {
		return roundProgressColor;
	}

	public void setCricleProgressColor(int cricleProgressColor) {
		this.roundProgressColor = cricleProgressColor;
	}

	public int getTextColor() {
		return textColor;
	}

	public void setTextColor(int textColor) {
		this.textColor = textColor;
	}

	public float getTextSize() {
		return textSize;
	}

	public void setTextSize(float textSize) {
		this.textSize = textSize;
	}

	public float getRoundWidth() {
		return roundWidth;
	}

	public void setRoundWidth(float roundWidth) {
		this.roundWidth = roundWidth;
	}



}
