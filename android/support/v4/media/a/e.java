package android.support.v4.media.a;

import android.content.Context;
import android.media.MediaRouter.RouteCategory;
import java.util.ArrayList;
import java.util.List;

public final class e {
    public static CharSequence a(Object obj, Context context) {
        return ((RouteCategory) obj).getName(context);
    }

    public static List a(Object obj) {
        List arrayList = new ArrayList();
        ((RouteCategory) obj).getRoutes(arrayList);
        return arrayList;
    }

    public static int b(Object obj) {
        return ((RouteCategory) obj).getSupportedTypes();
    }

    public static boolean c(Object obj) {
        return ((RouteCategory) obj).isGroupable();
    }
}
