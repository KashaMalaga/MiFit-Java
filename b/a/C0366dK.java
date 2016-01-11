package b.a;

import android.content.Context;
import android.content.SharedPreferences;

public class C0366dK {
    private static final String a = "umeng_general_config";

    private C0366dK() {
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences(a, 0);
    }

    public static SharedPreferences a(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }
}
