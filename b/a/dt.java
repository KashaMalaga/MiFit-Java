package b.a;

import android.content.Context;

public class dt extends C0281a {
    private static final String a = "mac";
    private Context b;

    public dt(Context context) {
        super(a);
        this.b = context;
    }

    public String f() {
        String str = null;
        try {
            str = bW.p(this.b);
        } catch (Exception e) {
        }
        return str;
    }
}
