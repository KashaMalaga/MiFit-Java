package android.support.v4.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.C0151az;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class C0237f extends ImageView {
    private static final int a = 503316480;
    private static final int b = 1023410176;
    private static final float c = 0.0f;
    private static final float d = 1.75f;
    private static final float e = 3.5f;
    private static final int f = 4;
    private AnimationListener g;
    private int h;

    public C0237f(Context context, int i, float f) {
        Drawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) ((f * f2) * 2.0f);
        int i3 = (int) (d * f2);
        int i4 = (int) (c * f2);
        this.h = (int) (e * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            C0151az.m(this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new C0238g(this, this.h, i2));
            C0151az.a((View) this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.h, (float) i4, (float) i3, a);
            int i5 = this.h;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    private boolean a() {
        return VERSION.SDK_INT >= 21;
    }

    public void a(AnimationListener animationListener) {
        this.g = animationListener;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.g != null) {
            this.g.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.g != null) {
            this.g.onAnimationStart(getAnimation());
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.h * 2), getMeasuredHeight() + (this.h * 2));
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(getResources().getColor(i));
        }
    }
}
