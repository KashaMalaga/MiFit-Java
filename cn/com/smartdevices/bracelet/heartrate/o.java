package cn.com.smartdevices.bracelet.heartrate;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class o implements OnTouchListener {
    final /* synthetic */ HeartRateMainActivity a;

    o(HeartRateMainActivity heartRateMainActivity) {
        this.a = heartRateMainActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
