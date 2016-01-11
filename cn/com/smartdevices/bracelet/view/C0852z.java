package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

class C0852z extends View {
    final /* synthetic */ RippleBackground a;
    private float b;

    public C0852z(RippleBackground rippleBackground, Context context) {
        this.a = rippleBackground;
        super(context);
        setVisibility(4);
    }

    private float a() {
        return this.b;
    }

    private void a(float f) {
        this.b = f;
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(this.a.s, this.a.t, a() - this.a.l, this.a.v);
    }
}
