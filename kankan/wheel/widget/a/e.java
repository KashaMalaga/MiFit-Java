package kankan.wheel.widget.a;

import android.content.Context;

public class e extends b {
    public static final int k = 9;
    private static final int l = 0;
    private int m;
    private int n;
    private String o;

    public e(Context context) {
        this(context, 0, k);
    }

    public e(Context context, int i, int i2) {
        this(context, i, i2, null);
    }

    public e(Context context, int i, int i2, String str) {
        super(context);
        this.m = i;
        this.n = i2;
        this.o = str;
    }

    public int a() {
        return (this.n - this.m) + 1;
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
        if (i < 0 || i >= a()) {
            return null;
        }
        int i2 = this.m + i;
        if (this.o == null) {
            return Integer.toString(i2);
        }
        return String.format(this.o, new Object[]{Integer.valueOf(i2)});
    }
}
