package android.support.v4.d.a;

import android.content.Context;
import android.view.Display;

class b extends a {
    private final Object b;

    public b(Context context) {
        this.b = d.a(context);
    }

    public Display a(int i) {
        return d.a(this.b, i);
    }

    public Display[] a() {
        return d.a(this.b);
    }

    public Display[] a(String str) {
        return d.a(this.b, str);
    }
}
