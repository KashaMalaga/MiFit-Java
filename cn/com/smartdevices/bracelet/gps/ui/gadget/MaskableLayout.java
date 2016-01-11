package cn.com.smartdevices.bracelet.gps.ui.gadget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class MaskableLayout extends RelativeLayout {
    private final Path a = new Path();
    private float b = 0.0f;
    private float c = 0.0f;
    private float d = 0.0f;

    public MaskableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a() {
        this.a.reset();
        this.a.addOval(new RectF(this.c - this.b, this.d - this.b, this.c + this.b, this.d + this.b), Direction.CCW);
    }

    public void a(float f, float f2, float f3) {
        this.c = f;
        this.d = f2;
        this.b = f3;
        invalidate();
    }

    protected void dispatchDraw(Canvas canvas) {
        a();
        canvas.clipPath(this.a, Op.DIFFERENCE);
        super.dispatchDraw(canvas);
    }
}
