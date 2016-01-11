package b.a;

import android.content.Context;
import android.provider.Settings.Secure;

public class C0313be extends C0281a {
    private static final String a = "android_id";
    private Context b;

    public C0313be(Context context) {
        super(a);
        this.b = context;
    }

    public String f() {
        String str = null;
        try {
            str = Secure.getString(this.b.getContentResolver(), a);
        } catch (Exception e) {
        }
        return str;
    }
}
