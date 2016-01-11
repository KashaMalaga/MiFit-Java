package cn.com.smartdevices.bracelet.gps.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class C0533o implements OnTouchListener {
    final /* synthetic */ C0530l a;

    C0533o(C0530l c0530l) {
        this.a = c0530l;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case a.i /*0*/:
                this.a.a.start();
                break;
            case l.a /*1*/:
                if (this.a.g.isRunning()) {
                    this.a.g.cancel();
                    this.a.a.cancel();
                    break;
                }
                break;
        }
        return true;
    }
}
