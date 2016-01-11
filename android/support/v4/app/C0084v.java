package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.l.p;
import android.view.View;

public class C0084v {
    protected C0084v() {
    }

    public static C0084v a(Activity activity, View view, String str) {
        return VERSION.SDK_INT >= 21 ? new C0085w(C0087y.a(activity, view, str)) : new C0084v();
    }

    public static C0084v a(Activity activity, p<View, String>... pVarArr) {
        String[] strArr = null;
        if (VERSION.SDK_INT < 21) {
            return new C0084v();
        }
        View[] viewArr;
        if (pVarArr != null) {
            View[] viewArr2 = new View[pVarArr.length];
            String[] strArr2 = new String[pVarArr.length];
            for (int i = 0; i < pVarArr.length; i++) {
                viewArr2[i] = (View) pVarArr[i].a;
                strArr2[i] = (String) pVarArr[i].b;
            }
            strArr = strArr2;
            viewArr = viewArr2;
        } else {
            viewArr = null;
        }
        return new C0085w(C0087y.a(activity, viewArr, strArr));
    }

    public static C0084v a(Context context, int i, int i2) {
        return VERSION.SDK_INT >= 16 ? new C0086x(C0088z.a(context, i, i2)) : new C0084v();
    }

    public static C0084v a(View view, int i, int i2, int i3, int i4) {
        return VERSION.SDK_INT >= 16 ? new C0086x(C0088z.a(view, i, i2, i3, i4)) : new C0084v();
    }

    public static C0084v a(View view, Bitmap bitmap, int i, int i2) {
        return VERSION.SDK_INT >= 16 ? new C0086x(C0088z.a(view, bitmap, i, i2)) : new C0084v();
    }

    public Bundle a() {
        return null;
    }

    public void a(C0084v c0084v) {
    }
}
