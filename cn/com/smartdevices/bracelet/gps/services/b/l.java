package cn.com.smartdevices.bracelet.gps.services.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.List;

public class l {
    public static void a(Context context, Class<?> cls) {
        if (context == null || cls == null) {
            throw new IllegalArgumentException();
        }
        Intent intent = new Intent(new Intent(context, cls));
        intent.addFlags(268566528);
        context.startActivity(intent);
    }

    public static boolean a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || runningTasks.isEmpty()) {
            return false;
        }
        try {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            return componentName == null ? false : context.getPackageName().equals(componentName.getPackageName());
        } catch (RuntimeException e) {
            return false;
        }
    }
}
