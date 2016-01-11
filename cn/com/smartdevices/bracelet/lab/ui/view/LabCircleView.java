package cn.com.smartdevices.bracelet.lab.ui.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import com.xiaomi.hm.health.i;
import com.xiaomi.hm.health.l;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.t;

public class LabCircleView extends FrameLayout implements ViewFactory {
    private static final String a = "Lab";
    private final CircleView b;
    private final TextView c;
    private Animator d;
    private Animator e;
    private int f;
    private c g;
    private int h;
    private ImageView i;

    public class CircleView extends View {
        private Paint a;
        private Paint b;
        private float c;
        private float d;
        private float e;
        private float f;

        public CircleView(Context context) {
            this(context, null, 0);
        }

        public CircleView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public CircleView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.e = 0.0f;
            this.f = 0.0f;
        }

        public float a() {
            return this.e;
        }

        public void a(float f) {
            this.f = f;
        }

        public void a(int i) {
            this.b.setAlpha(i);
        }

        public void a(Context context, boolean z, float f) {
            this.a = new Paint();
            this.a.setAntiAlias(true);
            if (z) {
                this.a.setStyle(Style.STROKE);
                this.a.setStrokeWidth(f);
                this.a.setColor(context.getResources().getColor(17170443));
            } else {
                this.a.setStyle(Style.FILL);
                this.a.setColor(context.getResources().getColor(17170444));
            }
            this.b = new Paint();
            this.b.setColor(context.getResources().getColor(i.lab_circle_dynamic_color));
            this.b.setStyle(Style.FILL);
            this.b.setAlpha(90);
        }

        public float b() {
            return this.f;
        }

        protected void onDraw(Canvas canvas) {
            if (this.f > 0.0f) {
                canvas.drawCircle(this.c, this.d, this.f, this.a);
            }
            if (this.e > 0.0f) {
                canvas.drawCircle(this.c, this.d, this.e, this.b);
            }
            if (this.e == this.f) {
                this.e = 0.0f;
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            int i5 = i4 - i2;
            this.c = ((float) (i3 - i)) / 2.0f;
            this.d = ((float) i5) / 2.0f;
        }
    }

    public LabCircleView(Context context) {
        this(context, null, 0);
    }

    public LabCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LabCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0;
        this.g = null;
        this.h = 1;
        this.i = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.LabCircleView);
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        boolean z = obtainStyledAttributes.getBoolean(5, true);
        float f = obtainStyledAttributes.getFloat(6, 1.0f);
        inflate(context, n.layout_lab_circle_view, this);
        this.b = (CircleView) findViewById(l.sport_progresscircle_view);
        this.c = (TextView) findViewById(l.circle_view_sport_progress_state);
        this.i = (ImageView) findViewById(l.bracelet_offline);
        this.b.a(dimension / 2.0f);
        this.b.a(context, z, f);
        obtainStyledAttributes.recycle();
    }

    private Animator a(float f, float f2) {
        return a(new b(this, f, f2), f);
    }

    private static Animator a(AnimatorUpdateListener animatorUpdateListener, float f) {
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, f});
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addUpdateListener(animatorUpdateListener);
        return ofFloat;
    }

    private Animator b(float f) {
        return a(new a(this, f), f);
    }

    private void f(int i) {
        if (i >= this.h) {
            this.b.a(30);
        } else if (i >= 4) {
            this.b.a(40);
        } else if (i >= 3) {
            this.b.a(60);
        } else if (i >= 2) {
            this.b.a(70);
        }
    }

    public void a() {
        if (this.g != null) {
            this.g.a();
        }
        if (this.d != null) {
            this.d.cancel();
        }
        if (this.d != null) {
            this.e.cancel();
        }
    }

    public void a(float f) {
        if (this.c != null) {
            this.c.setTextSize(f);
        }
    }

    public void a(int i) {
        if (this.c != null) {
            this.c.setText(i);
        }
    }

    public void a(Animation animation) {
        this.c.startAnimation(animation);
    }

    public void a(String str) {
        if (this.c != null) {
            this.c.setText(str);
        }
    }

    public void a(boolean z) {
        int i = 8;
        if (this.i != null) {
            this.i.setVisibility(z ? 0 : 8);
            TextView textView = this.c;
            if (!z) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    public void b(int i) {
        if (this.c != null) {
            this.c.setTextColor(i);
        }
    }

    public void c(int i) {
        this.g = new c();
        this.h = i;
    }

    public void d(int i) {
        if (i <= this.h) {
            this.f = i;
            this.g.sendEmptyMessage(2);
        }
    }

    public void e(int i) {
        this.g.removeMessages(1);
        Message obtainMessage = this.g.obtainMessage(1);
        obtainMessage.arg1 = i;
        this.g.sendMessage(obtainMessage);
    }

    public View makeView() {
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
