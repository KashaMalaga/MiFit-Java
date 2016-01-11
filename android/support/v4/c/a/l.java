package android.support.v4.c.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.InputStream;

public class l {
    private static final String a = "RoundedBitmapDrawableFactory";

    public static j a(Resources resources, Bitmap bitmap) {
        return VERSION.SDK_INT >= 21 ? new k(resources, bitmap) : new m(resources, bitmap);
    }

    public static j a(Resources resources, InputStream inputStream) {
        j a = a(resources, BitmapFactory.decodeStream(inputStream));
        if (a.b() == null) {
            Log.w(a, "BitmapDrawable cannot decode " + inputStream);
        }
        return a;
    }

    public static j a(Resources resources, String str) {
        j a = a(resources, BitmapFactory.decodeFile(str));
        if (a.b() == null) {
            Log.w(a, "BitmapDrawable cannot decode " + str);
        }
        return a;
    }
}
