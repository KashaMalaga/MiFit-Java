package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public abstract class U {
    @Deprecated
    public void a(Canvas canvas, RecyclerView recyclerView) {
    }

    public void a(Canvas canvas, RecyclerView recyclerView, ag agVar) {
        a(canvas, recyclerView);
    }

    @Deprecated
    public void a(Rect rect, int i, RecyclerView recyclerView) {
        rect.set(0, 0, 0, 0);
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, ag agVar) {
        a(rect, ((LayoutParams) view.getLayoutParams()).g(), recyclerView);
    }

    @Deprecated
    public void b(Canvas canvas, RecyclerView recyclerView) {
    }

    public void b(Canvas canvas, RecyclerView recyclerView, ag agVar) {
        b(canvas, recyclerView);
    }
}
