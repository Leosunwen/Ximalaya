package com.leo.xmly.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 绘制标题下面的下划线
 * 
 * @author Leo
 *
 */
public class MyTextView extends TextView {

	public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initPaint();
	}

	public MyTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyTextView(Context context) {
		this(context, null, 0);
	}

	private Paint pa = null;
	private boolean flag = false;

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
		invalidate();
	}

	private void initPaint() {
		pa = new Paint();
		pa.setStrokeWidth(5);
		pa.setColor(0xfff86442);
		pa.setAntiAlias(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		if (flag) {
			canvas.drawLine(0, getHeight() - 5, getWidth(),
					getHeight() - 5, pa);
		}

	}

}
