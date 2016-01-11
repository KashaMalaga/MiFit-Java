package cn.com.smartdevices.bracelet.lab.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Message;

class a implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ LabCircleView b;

    a(LabCircleView labCircleView, float f) {
        this.b = labCircleView;
        this.a = f;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int b = (int) (this.b.b.b() * floatValue);
        int b2 = (int) ((this.b.b.b() * ((float) this.b.f)) / ((float) this.b.h));
        if (b <= b2) {
            this.b.b.e = (float) b;
        } else {
            this.b.b.e = (float) b2;
        }
        this.b.f(this.b.f);
        if (floatValue == this.a && this.b.b.e < ((float) ((int) this.b.b.b())) && this.b.f < this.b.h) {
            this.b.g.removeMessages(1);
            Message obtainMessage = this.b.g.obtainMessage(1);
            obtainMessage.arg1 = this.b.f;
            this.b.g.sendMessage(obtainMessage);
        }
        if (floatValue == this.a) {
            this.b.g.sendEmptyMessage(4);
        }
        cn.com.smartdevices.bracelet.chart.a.a.a(this.b.b);
    }
}
