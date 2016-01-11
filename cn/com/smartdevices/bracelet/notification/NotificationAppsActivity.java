package cn.com.smartdevices.bracelet.notification;

import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.l;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.g.a.b.b;
import com.xiaomi.hm.health.n;
import com.xiaomi.hm.health.r;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NotificationAppsActivity extends SystemBarTintActivity {
    public static final Comparator<c> a = new b();
    private static boolean b;
    private e c;

    public class PackageIntentReceiver extends BroadcastReceiver {
        final f a;

        public PackageIntentReceiver(f fVar) {
            this.a = fVar;
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter.addDataScheme(b.b);
            this.a.getContext().registerReceiver(this, intentFilter);
            intentFilter = new IntentFilter();
            intentFilter.addAction(l.a);
            intentFilter.addAction(l.b);
            this.a.getContext().registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            this.a.onContentChanged();
        }
    }

    public static List<ApplicationInfo> a(Context context, int i) {
        List<ApplicationInfo> installedApplications;
        BufferedReader bufferedReader;
        Exception e;
        Throwable th;
        PackageManager packageManager = context.getPackageManager();
        try {
            installedApplications = packageManager.getInstalledApplications(i);
        } catch (Exception e2) {
            installedApplications = new ArrayList();
            try {
                Process exec = Runtime.getRuntime().exec("pm list packages");
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        readLine = readLine.substring(readLine.indexOf(58) + 1);
                        packageManager.getPackageInfo(readLine, i);
                        installedApplications.add(packageManager.getApplicationInfo(readLine, i));
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
                exec.waitFor();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
                try {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e42) {
                            e42.printStackTrace();
                        }
                    }
                    return installedApplications;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e422) {
                            e422.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
        return installedApplications;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) n.activity_notification_app_list);
        b = false;
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager.findFragmentById(16908290) == null) {
            this.c = new e();
            fragmentManager.beginTransaction().add(com.xiaomi.hm.health.l.content, this.c).commit();
        }
    }

    public void onSystemUserAppSwitch(View view) {
        b = !b;
        if (b) {
            ((TextView) view).setText(r.phone_app_notifi_download_apps);
        } else {
            ((TextView) view).setText(r.phone_app_notifi_all_apps);
        }
        this.c.getLoaderManager().restartLoader(0, null, this.c);
    }
}
