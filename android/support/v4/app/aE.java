package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.content.l;
import android.util.Log;

class aE implements aD {
    aE() {
    }

    public Intent a(Activity activity) {
        String c = aC.c(activity);
        if (c == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, c);
        try {
            return aC.b((Context) activity, componentName) == null ? l.a(componentName) : new Intent().setComponent(componentName);
        } catch (NameNotFoundException e) {
            Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + c + "' in manifest");
            return null;
        }
    }

    public String a(Context context, ActivityInfo activityInfo) {
        if (activityInfo.metaData == null) {
            return null;
        }
        String string = activityInfo.metaData.getString(aC.a);
        return string == null ? null : string.charAt(0) == '.' ? context.getPackageName() + string : string;
    }

    public boolean a(Activity activity, Intent intent) {
        String action = activity.getIntent().getAction();
        return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
    }

    public void b(Activity activity, Intent intent) {
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }
}
