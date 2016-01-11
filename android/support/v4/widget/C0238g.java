package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

class C0238g extends OvalShape {
    final /* synthetic */ C0237f a;
    private RadialGradient b;
    private int c;
    private Paint d = new Paint();
    private int e;

    public C0238g(C0237f c0237f, int i, int i2) {
        this.a = c0237f;
        this.c = i;
        this.e = i2;
        this.b = new RadialGradient((float) (this.e / 2), (float) (this.e / 2), (float) this.c, new int[]{1023410176, 0}, null, TileMode.CLAMP);
        this.d.setShader(this.b);
    }

    public void draw(Canvas canvas, Paint paint) {
        int width = this.a.getWidth();
        int height = this.a.getHeight();
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.e / 2) + this.c), this.d);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.e / 2), paint);
    }
}
