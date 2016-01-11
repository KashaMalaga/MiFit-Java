package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class aF extends aE {
    aF() {
    }

    public Intent a(Activity activity) {
        Intent a = aG.a(activity);
        return a == null ? b(activity) : a;
    }

    public String a(Context context, ActivityInfo activityInfo) {
        String a = aG.a(activityInfo);
        return a == null ? super.a(context, activityInfo) : a;
    }

    public boolean a(Activity activity, Intent intent) {
        return aG.a(activity, intent);
    }

    Intent b(Activity activity) {
        return super.a(activity);
    }

    public void b(Activity activity, Intent intent) {
        aG.b(activity, intent);
    }
}
