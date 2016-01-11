package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;

class ao extends A {
    final /* synthetic */ StaggeredGridLayoutManager a;

    ao(StaggeredGridLayoutManager staggeredGridLayoutManager, Context context) {
        this.a = staggeredGridLayoutManager;
        super(context);
    }

    public PointF a(int i) {
        int a = this.a.s(i);
        return a == 0 ? null : this.a.q == 0 ? new PointF((float) a, 0.0f) : new PointF(0.0f, (float) a);
    }
}
