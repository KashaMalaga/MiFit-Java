package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class ca implements AnimatorUpdateListener {
    final /* synthetic */ cd a;
    final /* synthetic */ View b;

    ca(cd cdVar, View view) {
        this.a = cdVar;
        this.b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a(this.b);
    }
}
