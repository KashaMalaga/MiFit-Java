package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import cn.com.smartdevices.bracelet.model.PersonInfo;

class L implements C0255f {
    final /* synthetic */ RecyclerView a;

    L(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public int a() {
        return this.a.getChildCount();
    }

    public int a(View view) {
        return this.a.indexOfChild(view);
    }

    public void a(int i) {
        View childAt = this.a.getChildAt(i);
        if (childAt != null) {
            this.a.i(childAt);
        }
        this.a.removeViewAt(i);
    }

    public void a(View view, int i) {
        this.a.addView(view, i);
        this.a.j(view);
    }

    public void a(View view, int i, LayoutParams layoutParams) {
        aj b = RecyclerView.b(view);
        if (b != null) {
            if (b.s() || b.c()) {
                b.l();
            } else {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + b);
            }
        }
        this.a.attachViewToParent(view, i, layoutParams);
    }

    public aj b(View view) {
        return RecyclerView.b(view);
    }

    public View b(int i) {
        return this.a.getChildAt(i);
    }

    public void b() {
        int a = a();
        for (int i = 0; i < a; i++) {
            this.a.i(b(i));
        }
        this.a.removeAllViews();
    }

    public void c(int i) {
        View b = b(i);
        if (b != null) {
            aj b2 = RecyclerView.b(b);
            if (b2 != null) {
                if (!b2.s() || b2.c()) {
                    b2.a((int) PersonInfo.INCOMING_CALL_DISABLE_BIT);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + b2);
                }
            }
        }
        this.a.detachViewFromParent(i);
    }
}
