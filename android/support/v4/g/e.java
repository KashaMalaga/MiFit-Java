package android.support.v4.g;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public class e {
    public static <T> Creator<T> a(g<T> gVar) {
        if (VERSION.SDK_INT >= 13) {
            i.a(gVar);
        }
        return new f(gVar);
    }
}
