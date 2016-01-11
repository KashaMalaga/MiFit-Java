package cn.com.smartdevices.bracelet.gps.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout.LayoutParams;
import com.xiaomi.hm.health.b.a.g;

class bB implements OnGlobalLayoutListener {
    final /* synthetic */ WatermarkFragment a;

    bB(WatermarkFragment watermarkFragment) {
        this.a = watermarkFragment;
    }

    public void onGlobalLayout() {
        this.a.l.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.a.q = this.a.l.getHeight();
        this.a.r = this.a.B.getDimensionPixelSize(g.watermark_drag_line_margin_bottom);
        this.a.s = (this.a.p - this.a.q) - this.a.r;
        this.a.n = (LayoutParams) this.a.l.getLayoutParams();
        this.a.n.topMargin = this.a.s;
        this.a.n.addRule(14);
        this.a.l.setLayoutParams(this.a.n);
        this.a.l.setVisibility(0);
        this.a.l.setId(900000);
        this.a.l.setOnTouchListener(this.a.I);
        this.a.l.setClickable(true);
        this.a.d();
        this.a.e();
    }
}
