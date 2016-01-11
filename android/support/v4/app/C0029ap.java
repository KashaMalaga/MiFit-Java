package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

final class C0029ap implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ Transition b;
    final /* synthetic */ View c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ Transition e;
    final /* synthetic */ ArrayList f;
    final /* synthetic */ Transition g;
    final /* synthetic */ ArrayList h;
    final /* synthetic */ Map i;
    final /* synthetic */ ArrayList j;
    final /* synthetic */ Transition k;

    C0029ap(View view, Transition transition, View view2, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4) {
        this.a = view;
        this.b = transition;
        this.c = view2;
        this.d = arrayList;
        this.e = transition2;
        this.f = arrayList2;
        this.g = transition3;
        this.h = arrayList3;
        this.i = map;
        this.j = arrayList4;
        this.k = transition4;
    }

    public boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.b != null) {
            this.b.removeTarget(this.c);
            C0025al.a(this.b, this.d);
        }
        if (this.e != null) {
            C0025al.a(this.e, this.f);
        }
        if (this.g != null) {
            C0025al.a(this.g, this.h);
        }
        for (Entry entry : this.i.entrySet()) {
            ((View) entry.getValue()).setTransitionName((String) entry.getKey());
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.k.excludeTarget((View) this.j.get(i), false);
        }
        this.k.excludeTarget(this.c, false);
        return true;
    }
}
