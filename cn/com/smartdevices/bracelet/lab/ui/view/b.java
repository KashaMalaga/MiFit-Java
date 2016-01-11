package cn.com.smartdevices.bracelet.lab.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import cn.com.smartdevices.bracelet.chart.a.a;

class b implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ LabCircleView c;

    b(LabCircleView labCircleView, float f, float f2) {
        this.c = labCircleView;
        this.a = f;
        this.b = f2;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = this.a - ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.c.b.e = (float) ((int) ((1.0f * floatValue) * this.b));
        a.a(this.c.b);
        if (floatValue == this.a) {
            this.c.g.sendEmptyMessage(3);
        }
    }
}
