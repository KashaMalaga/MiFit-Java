package cn.com.smartdevices.bracelet.tag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.hm.health.j;

public class ThirdRingView extends View {
    private final Paint a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;

    public ThirdRingView(Context context) {
        this(context, null);
    }

    public ThirdRingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.a.setAntiAlias(true);
        this.a.setStyle(Style.STROKE);
        this.b = (float) getResources().getDimensionPixelSize(j.tag_third_ring_radius);
        this.e = (float) getResources().getDimensionPixelSize(j.tag_third_ring_padding);
        this.c = this.b - this.e;
        this.d = this.c - this.e;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        this.a.setColor(Color.parseColor("#50ffffff"));
        this.a.setStrokeWidth(2.0f);
        canvas.drawCircle((float) width, (float) width, this.d, this.a);
        this.a.setColor(Color.parseColor("#30ffffff"));
        this.a.setStrokeWidth(2.0f);
        canvas.drawCircle((float) width, (float) width, this.c, this.a);
        this.a.setColor(Color.parseColor("#10ffffff"));
        this.a.setStrokeWidth(2.0f);
        canvas.drawCircle((float) width, (float) width, this.b, this.a);
    }
}
