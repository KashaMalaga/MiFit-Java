package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import cn.com.smartdevices.bracelet.chart.util.a;

public class CalibrationView extends View {
    private int a = 400;
    private int b = a.d;
    private int c = 0;
    private int d = 100;
    private int e = 1;
    private int f = 5;
    private int g = 0;
    private int h = 50;
    private Paint i = new Paint();
    private Paint j = new Paint();
    private TextPaint k = new TextPaint();

    public CalibrationView(Context context) {
        super(context);
        this.i.setAntiAlias(true);
        this.i.setColor(-11746592);
        this.i.setStrokeWidth(3.0f);
        this.j.setAntiAlias(true);
        this.j.setColor(-3552823);
        this.i.setStrokeWidth(2.0f);
    }

    protected void onDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        canvas.drawLine((float) ((width * 2) / 3), (float) (height / 2), (float) width, (float) (height / 2), this.i);
        height = ((width * 9) / 10) / 2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
