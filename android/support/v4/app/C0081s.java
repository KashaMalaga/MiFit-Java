package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class C0081s {
    C0081s() {
    }

    public static void a(Activity activity) {
        activity.finishAffinity();
    }

    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void a(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }
}
