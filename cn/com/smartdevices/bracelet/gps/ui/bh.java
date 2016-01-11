package cn.com.smartdevices.bracelet.gps.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.xiaomi.hm.health.b.a.i;

class bh implements OnTouchListener {
    final /* synthetic */ WatermarkActivity a;
    private float b;

    bh(WatermarkActivity watermarkActivity) {
        this.a = watermarkActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view != null && i.vp_mark_pager == view.getId()) {
            if (motionEvent.getAction() == 0) {
                this.b = motionEvent.getRawX();
            }
            if (this.a.F && this.a.s != null && motionEvent.getAction() == 1 && this.b == motionEvent.getRawX()) {
                this.a.s.b();
            }
        }
        return false;
    }
}
