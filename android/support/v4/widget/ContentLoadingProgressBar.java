package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private static final int a = 500;
    private static final int b = 500;
    private long c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final Runnable g;
    private final Runnable h;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.c = -1;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = new C0239h(this);
        this.h = new C0240i(this);
    }

    private void c() {
        removeCallbacks(this.g);
        removeCallbacks(this.h);
    }

    public void a() {
        this.f = true;
        removeCallbacks(this.h);
        long currentTimeMillis = System.currentTimeMillis() - this.c;
        if (currentTimeMillis >= 500 || this.c == -1) {
            setVisibility(8);
        } else if (!this.d) {
            postDelayed(this.g, 500 - currentTimeMillis);
            this.d = true;
        }
    }

    public void b() {
        this.c = -1;
        this.f = false;
        removeCallbacks(this.g);
        if (!this.e) {
            postDelayed(this.h, 500);
            this.e = true;
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }
}
