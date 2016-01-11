package android.support.v4.content.b;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class a {
    public static Drawable a(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 21 ? b.a(resources, i, theme) : resources.getDrawable(i);
    }
}
