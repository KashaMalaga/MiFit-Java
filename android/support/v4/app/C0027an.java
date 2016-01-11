package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

final class C0027an implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ ar b;
    final /* synthetic */ Map c;
    final /* synthetic */ Map d;
    final /* synthetic */ Transition e;
    final /* synthetic */ ArrayList f;

    C0027an(View view, ar arVar, Map map, Map map2, Transition transition, ArrayList arrayList) {
        this.a = view;
        this.b = arVar;
        this.c = map;
        this.d = map2;
        this.e = transition;
        this.f = arrayList;
    }

    public boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        View a = this.b.a();
        if (a != null) {
            if (!this.c.isEmpty()) {
                C0025al.a(this.d, a);
                this.d.keySet().retainAll(this.c.values());
                for (Entry entry : this.c.entrySet()) {
                    View view = (View) this.d.get((String) entry.getValue());
                    if (view != null) {
                        view.setTransitionName((String) entry.getKey());
                    }
                }
            }
            if (this.e != null) {
                C0025al.b(this.f, a);
                this.f.removeAll(this.d.values());
                C0025al.b(this.e, this.f);
            }
        }
        return true;
    }
}
