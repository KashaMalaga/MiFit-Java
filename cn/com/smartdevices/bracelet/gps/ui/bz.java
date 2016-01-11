package cn.com.smartdevices.bracelet.gps.ui;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import cn.com.smartdevices.bracelet.gps.h.m;
import com.xiaomi.hm.health.b.a.h;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class bz implements OnTouchListener {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    final /* synthetic */ WatermarkFragment g;

    bz(WatermarkFragment watermarkFragment) {
        this.g = watermarkFragment;
    }

    private void a(MotionEvent motionEvent) {
        this.g.A.a(true);
        this.a = (int) motionEvent.getRawX();
        this.b = (int) motionEvent.getRawY();
        LayoutParams layoutParams = (LayoutParams) this.g.l.getLayoutParams();
        layoutParams.removeRule(14);
        layoutParams.leftMargin = this.c;
        layoutParams.topMargin = this.d;
        this.g.l.setLayoutParams(layoutParams);
        if (!this.g.C) {
            this.g.l.setBackgroundColor(Color.parseColor("#00000000"));
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case a.i /*0*/:
                this.a = (int) motionEvent.getRawX();
                this.b = (int) motionEvent.getRawY();
                if (this.g.C) {
                    this.g.m.setBackgroundColor(Color.parseColor("#00000000"));
                    this.g.H.setVisibility(8);
                    this.g.l.setBackgroundResource(h.watermark_dotted_line_gray);
                    m.a(this.g.d, m.a, false);
                    this.g.C = false;
                }
                if (!this.g.C) {
                    this.g.l.setBackgroundResource(h.watermark_dotted_line_gray);
                    break;
                }
                break;
            case l.a /*1*/:
                a(motionEvent);
                break;
            case a.k /*2*/:
                break;
            case a.l /*3*/:
                a(motionEvent);
                break;
        }
        int rawX = ((int) motionEvent.getRawX()) - this.a;
        int rawY = ((int) motionEvent.getRawY()) - this.b;
        this.c = view.getLeft() + rawX;
        this.d = view.getTop() + rawY;
        this.e = rawX + view.getRight();
        this.f = view.getBottom() + rawY;
        if (this.c < 0) {
            this.c = 0;
            this.e = this.c + view.getWidth();
        }
        if (this.e > this.g.o) {
            this.e = this.g.o;
            this.c = this.e - view.getWidth();
        }
        if (this.d < 0) {
            this.d = 0;
            this.f = this.d + view.getHeight();
        }
        if (this.f > this.g.p) {
            this.f = this.g.p;
            this.d = this.f - view.getHeight();
        }
        if (!this.g.C) {
            view.layout(this.c, this.d, this.e, this.f);
        }
        this.a = (int) motionEvent.getRawX();
        this.b = (int) motionEvent.getRawY();
        return false;
    }
}
