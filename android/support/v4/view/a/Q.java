package android.support.v4.view.a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class Q implements X {
    final /* synthetic */ L a;
    final /* synthetic */ P b;

    Q(P p, L l) {
        this.b = p;
        this.a = l;
    }

    public Object a(int i) {
        C0113o a = this.a.a(i);
        return a == null ? null : a.a();
    }

    public List<Object> a(String str, int i) {
        List a = this.a.a(str, i);
        List<Object> arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0113o) a.get(i2)).a());
        }
        return arrayList;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return this.a.a(i, i2, bundle);
    }

    public Object b(int i) {
        C0113o b = this.a.b(i);
        return b == null ? null : b.a();
    }
}
