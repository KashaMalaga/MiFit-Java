package kankan.wheel.widget.a;

import android.content.Context;

public class d<T> extends b {
    private T[] k;

    public d(Context context, T[] tArr) {
        super(context);
        this.k = tArr;
    }

    public int a() {
        return this.k.length;
    }

    public boolean b() {
        return false;
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public CharSequence f(int i) {
        if (i < 0 || i >= this.k.length) {
            return null;
        }
        Object obj = this.k[i];
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
