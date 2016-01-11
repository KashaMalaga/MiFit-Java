package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class W implements Callback {
    final /* synthetic */ T a;

    W(T t) {
        this.a = t;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.a.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.a.unscheduleSelf(runnable);
    }
}
