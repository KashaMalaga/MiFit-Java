package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;

final class b implements AnimatorListener {
    final /* synthetic */ TextView a;
    final /* synthetic */ String b;
    final /* synthetic */ TextView c;
    final /* synthetic */ String d;

    b(TextView textView, String str, TextView textView2, String str2) {
        this.a = textView;
        this.b = str;
        this.c = textView2;
        this.d = str2;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.setText(this.b);
        this.a.setAlpha(0.9f);
        this.a.setScaleX(0.9f);
        this.a.setScaleY(0.9f);
        this.c.setText(this.d);
        this.c.setAlpha(0.5f);
        this.c.setScaleX(0.5f);
        this.c.setScaleY(0.5f);
    }
}
