package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class aG {
    aG() {
    }

    public static Intent a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static String a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }

    public static boolean a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }
}
