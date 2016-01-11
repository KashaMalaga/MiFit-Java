package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.View;

final class o implements AnimatorUpdateListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ View[] g;
    final /* synthetic */ p h;

    o(int i, int i2, int i3, int i4, int i5, int i6, View[] viewArr, p pVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = viewArr;
        this.h = pVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int rgb = Color.rgb((int) ((((float) this.a) * floatValue) + (((float) this.b) * (1.0f - floatValue))), (int) ((((float) this.c) * floatValue) + (((float) this.d) * (1.0f - floatValue))), (int) (((1.0f - floatValue) * ((float) this.f)) + (((float) this.e) * floatValue)));
        for (View backgroundColor : this.g) {
            backgroundColor.setBackgroundColor(rgb);
        }
        if (this.h != null) {
            this.h.a(rgb);
        }
    }
}
