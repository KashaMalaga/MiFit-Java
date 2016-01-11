package cn.com.smartdevices.bracelet.gps.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.support.v4.e.a.a;
import android.util.AttributeSet;
import android.view.View;
import cn.com.smartdevices.bracelet.C0596r;
import java.util.List;

public class SimpleTrackView extends View {
    private Paint a = null;
    private float b = 4.0f;
    private List<Path> c = null;

    public SimpleTrackView(Context context) {
        super(context);
        this.b = context.getResources().getDisplayMetrics().density * this.b;
        this.a = a(this.b);
        C0596r.e("Track", "SimpleTrackView one mDensity = " + this.b);
    }

    public SimpleTrackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context.getResources().getDisplayMetrics().density * this.b;
        this.a = a(this.b);
        C0596r.e("Track", "SimpleTrackView two mDensity= " + this.b);
    }

    private Paint a(float f) {
        Paint paint = new Paint();
        paint.setColor(a.c);
        paint.setStyle(Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f);
        return paint;
    }

    public void a() {
        if (this.c != null) {
            for (Path reset : this.c) {
                reset.reset();
            }
        }
    }

    public void a(int i) {
        this.a.setColor(i);
    }

    public void a(Context context, float f) {
        this.b = context.getResources().getDisplayMetrics().density * f;
        this.a.setStrokeWidth(this.b);
    }

    public void a(List<Path> list) {
        this.c = list;
    }

    public void b() {
        a();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        C0596r.e("Track", "onDraw");
        if (this.c != null) {
            for (Path drawPath : this.c) {
                canvas.drawPath(drawPath, this.a);
            }
        }
    }
}
