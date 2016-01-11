package cn.com.smartdevices.bracelet.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import cn.com.smartdevices.bracelet.push.MiPushMessageReceiver;
import com.tencent.connect.common.Constants;

public class fg {
    private static final String a = "status_bar_height";
    private static final String b = "navigation_bar_height";
    private static final String c = "navigation_bar_height_landscape";
    private static final String d = "navigation_bar_width";
    private static final String e = "config_showNavigationBar";
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final float n;

    private fg(Activity activity, boolean z, boolean z2) {
        boolean z3 = true;
        Resources resources = activity.getResources();
        this.m = resources.getConfiguration().orientation == 1;
        this.n = a(activity);
        this.h = a(resources, a);
        this.i = a((Context) activity);
        this.k = b(activity);
        this.l = c(activity);
        if (this.k <= 0) {
            z3 = false;
        }
        this.j = z3;
        this.f = z;
        this.g = z2;
    }

    @SuppressLint({"NewApi"})
    private float a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (VERSION.SDK_INT >= 16) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        return Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
    }

    @TargetApi(14)
    private int a(Context context) {
        if (VERSION.SDK_INT < 14) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843499, typedValue, true);
        return context.getResources().getDimensionPixelSize(typedValue.resourceId);
    }

    private int a(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", MiPushMessageReceiver.ANDROID);
        return identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
    }

    @TargetApi(14)
    private int b(Context context) {
        Resources resources = context.getResources();
        if (VERSION.SDK_INT < 14 || !d(context)) {
            return 0;
        }
        return a(resources, this.m ? b : c);
    }

    @TargetApi(14)
    private int c(Context context) {
        return (VERSION.SDK_INT < 14 || !d(context)) ? 0 : a(context.getResources(), d);
    }

    @TargetApi(14)
    private boolean d(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(e, "bool", MiPushMessageReceiver.ANDROID);
        if (identifier != 0) {
            return Constants.VIA_TO_TYPE_QQ_GROUP.equals(fe.b) ? false : Constants.VIA_RESULT_SUCCESS.equals(fe.b) ? true : resources.getBoolean(identifier);
        } else {
            if (ViewConfiguration.get(context).hasPermanentMenuKey()) {
                z = false;
            }
            return z;
        }
    }

    public int a(boolean z) {
        int i = 0;
        int i2 = this.f ? this.h : 0;
        if (z) {
            i = this.i;
        }
        return i + i2;
    }

    public boolean a() {
        return this.n >= 600.0f || this.m;
    }

    public int b() {
        return this.h;
    }

    public int c() {
        return this.i;
    }

    public boolean d() {
        return this.j;
    }

    public int e() {
        return this.k;
    }

    public int f() {
        return this.l;
    }

    public int g() {
        return (this.g && a()) ? this.k : 0;
    }

    public int h() {
        return (!this.g || a()) ? 0 : this.l;
    }
}
