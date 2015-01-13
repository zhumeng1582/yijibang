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
 * ��iphone�����ȵĽ��������̰߳�ȫ��View����ֱ�����߳��и��½���
 * @author xiaanming
 *
 */
public class RoundProgressBar extends View {
	/**
	 * ���ʶ��������
	 */
	private Paint paint;
	
	/**
	 * Բ������ɫ
	 */
	private int roundColor;
	
	/**
	 * Բ�����ȵ���ɫ
	 */
	private int roundProgressColor;
	/**
	 * �м���Ȱٷֱȵ��ַ�������ɫ
	 */
	private String title;
	private int textColor;
	
	/**
	 * �м���Ȱٷֱȵ��ַ���������
	 */
	private float textSize;
	
	/**
	 * Բ���Ŀ��
	 */
	private float roundWidth;
	
	/**
	 * ������
	 */
	private float max=0;
	
	/**
	 * ��ǰ����
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
		
		//��ȡ�Զ������Ժ�Ĭ��ֵ
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
		
		//�������Ĵ�Բ��
		int centre = (int) getWidth()/2; //��ȡԲ�ĵ�x����
		int radius = (int) (centre -roundWidth-roundWidth/2); //Բ���İ뾶
		paint.setColor(roundColor); //����Բ������ɫ
		//paint.setStyle(Paint.Style.STROKE); //���ÿ���
		//paint.setStrokeWidth(roundWidth); //����Բ���Ŀ��
		paint.setAntiAlias(true);  //������� 
		//canvas.drawCircle(centre, centre, radius, paint); //����Բ��
		
		//���Ϊʵ��
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		RectF oval = new RectF(centre - radius, centre - radius, centre
				+ radius, centre + radius);
		canvas.drawArc(oval, 0, 360 , true, paint);  
		Log.e("log", centre + "");
		
		
		paint.setStrokeWidth(0); 
		paint.setColor(textColor);
		paint.setTextSize(textSize);
		paint.setTypeface(Typeface.DEFAULT); //��������
		
		float textWidth = paint.measureText(title);   //���������ȣ�������Ҫ��������Ŀ��������Բ���м�
		canvas.drawText(title, centre - textWidth / 2, centre-textSize/2, paint); 
		
		DecimalFormat df = new DecimalFormat("######0.00"); 
		String value = df.format(progress) ;
		textWidth = paint.measureText(value); 
		canvas.drawText(value, centre - textWidth / 2, centre + textSize, paint);
		
		//����Բ���Ľ���

		oval = new RectF(centre - radius-roundWidth, centre - radius-roundWidth, centre
				+ radius+roundWidth, centre + radius+roundWidth);
		
		paint.setStrokeWidth(roundWidth); //����Բ���Ŀ��
		paint.setColor(roundProgressColor);  //���ý��ȵ���ɫ
		paint.setStyle(Paint.Style.STROKE);
		if(max==progress)
			canvas.drawArc(oval, 270,360, false, paint);  //���ݽ��Ȼ�Բ��
		else if(title.equals("֧��"))
			canvas.drawArc(oval, 270,-(int)( 360.0 * progress / max), false, paint);  //���ݽ��Ȼ�Բ��
		else if(title.equals("����"))
			canvas.drawArc(oval, 270,(int)( 360.0 * progress / max), false, paint);  //���ݽ��Ȼ�Բ��
	}
	
	
	public synchronized float getMax() {
		return max;
	}

	/**
	 * ���ý��ȵ����ֵ
	 * @param max
	 */
	public synchronized void setMax(float max) {
		if(max < 0){
			throw new IllegalArgumentException("max not less than 0");
		}
		this.max = max;
	}

	/**
	 * ��ȡ����.��Ҫͬ��
	 * @return
	 */
	public synchronized float getProgress() {
		return progress;
	}

	/**
	 * ���ý��ȣ���Ϊ�̰߳�ȫ�ؼ������ڿ��Ƕ��ߵ����⣬��Ҫͬ��
	 * ˢ�½������postInvalidate()���ڷ�UI�߳�ˢ��
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
