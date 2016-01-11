package cn.com.smartdevices.bracelet.gps.ui;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import cn.com.smartdevices.bracelet.gps.ui.WatermarkFragment.WatermarkTag;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class bD implements OnTouchListener {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    final /* synthetic */ WatermarkTag g;

    bD(WatermarkTag watermarkTag) {
        this.g = watermarkTag;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case a.i /*0*/:
                this.a = (int) motionEvent.getRawX();
                this.b = (int) motionEvent.getRawY();
                this.c = (int) motionEvent.getRawX();
                this.d = (int) motionEvent.getRawY();
                return false;
            case l.a /*1*/:
                this.e = (int) motionEvent.getRawX();
                this.f = (int) motionEvent.getRawY();
                if (this.c == this.e && this.d == this.f) {
                    Log.d("WatermarkTag", "ONclick...");
                }
                return true;
            case a.k /*2*/:
                int rawX = ((int) motionEvent.getRawX()) - this.a;
                int rawY = ((int) motionEvent.getRawY()) - this.b;
                this.g.g = view.getLeft() + rawX;
                this.g.h = view.getTop() + rawY;
                this.g.i = rawX + view.getRight();
                this.g.j = rawY + view.getBottom();
                if (view.getTag() instanceof bC) {
                    this.g.k.a(this.g.g, this.g.h, this.g.i, this.g.j);
                }
                view.layout(this.g.g, this.g.h, this.g.i, this.g.j);
                view.setTag(this.g.k);
                this.a = (int) motionEvent.getRawX();
                this.b = (int) motionEvent.getRawY();
                return false;
            default:
                return false;
        }
    }
}
