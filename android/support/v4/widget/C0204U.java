package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class C0204U extends Animation {
    final /* synthetic */ Z a;
    final /* synthetic */ T b;

    C0204U(T t, Z z) {
        this.b = t;
        this.a = z;
    }

    public void applyTransformation(float f, Transformation transformation) {
        if (this.b.c) {
            this.b.a(f, this.a);
            return;
        }
        float toRadians = (float) Math.toRadians(((double) this.a.c()) / (6.283185307179586d * this.a.j()));
        float f2 = this.a.f();
        float e = this.a.e();
        float k = this.a.k();
        this.a.c(((0.8f - toRadians) * T.f.getInterpolation(f)) + f2);
        this.a.b((T.e.getInterpolation(f) * 0.8f) + e);
        this.a.d((0.25f * f) + k);
        this.b.c((144.0f * f) + (720.0f * (this.b.C / 5.0f)));
    }
}
