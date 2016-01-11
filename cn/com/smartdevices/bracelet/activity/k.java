package cn.com.smartdevices.bracelet.activity;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class k implements OnTouchListener {
    final /* synthetic */ LoginActivity a;

    k(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }
}
