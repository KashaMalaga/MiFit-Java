package kankan.wheel.widget;

import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedList;
import java.util.List;

public class k {
    private List<View> a;
    private List<View> b;
    private WheelView c;

    public k(WheelView wheelView) {
        this.c = wheelView;
    }

    private View a(List<View> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        View view = (View) list.get(0);
        list.remove(0);
        return view;
    }

    private List<View> a(View view, List<View> list) {
        if (list == null) {
            list = new LinkedList();
        }
        list.add(view);
        return list;
    }

    private void a(View view, int i) {
        int a = this.c.b().a();
        if ((i < 0 || i >= a) && !this.c.g()) {
            this.b = a(view, this.b);
            return;
        }
        while (i < 0) {
            i += a;
        }
        a = i % a;
        this.a = a(view, this.a);
    }

    public int a(LinearLayout linearLayout, int i, b bVar) {
        int i2 = 0;
        int i3 = i;
        while (i2 < linearLayout.getChildCount()) {
            if (bVar.a(i)) {
                i2++;
            } else {
                a(linearLayout.getChildAt(i2), i);
                linearLayout.removeViewAt(i2);
                if (i2 == 0) {
                    i3++;
                }
            }
            i++;
        }
        return i3;
    }

    public View a() {
        return a(this.a);
    }

    public View b() {
        return a(this.b);
    }

    public void c() {
        if (this.a != null) {
            this.a.clear();
        }
        if (this.b != null) {
            this.b.clear();
        }
    }
}
