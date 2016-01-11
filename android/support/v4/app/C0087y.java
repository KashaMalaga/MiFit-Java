package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

class C0087y {
    private final ActivityOptions a;

    private C0087y(ActivityOptions activityOptions) {
        this.a = activityOptions;
    }

    public static C0087y a(Activity activity, View view, String str) {
        return new C0087y(ActivityOptions.makeSceneTransitionAnimation(activity, view, str));
    }

    public static C0087y a(Activity activity, View[] viewArr, String[] strArr) {
        Pair[] pairArr = null;
        if (viewArr != null) {
            Pair[] pairArr2 = new Pair[viewArr.length];
            for (int i = 0; i < pairArr2.length; i++) {
                pairArr2[i] = Pair.create(viewArr[i], strArr[i]);
            }
            pairArr = pairArr2;
        }
        return new C0087y(ActivityOptions.makeSceneTransitionAnimation(activity, pairArr));
    }

    public Bundle a() {
        return this.a.toBundle();
    }

    public void a(C0087y c0087y) {
        this.a.update(c0087y.a);
    }
}
