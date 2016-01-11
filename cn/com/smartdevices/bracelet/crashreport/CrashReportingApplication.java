package cn.com.smartdevices.bracelet.crashreport;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import com.xiaomi.e.a;
import java.io.File;

public abstract class CrashReportingApplication extends Application implements OnSharedPreferenceChangeListener {
    protected static final String a = "ACRA";
    public static final String b = "RES_BUTTON_CANCEL";
    public static final String c = "RES_BUTTON_REPORT";
    public static final String d = "RES_BUTTON_RESTART";
    public static final String e = "RES_DIALOG_ICON";
    public static final String f = "RES_DIALOG_TITLE";
    public static final String g = "RES_DIALOG_TEXT";
    public static final String h = "RES_EMAIL_SUBJECT";
    public static final String i = "RES_EMAIL_TEXT";
    public static final String j = "acra.enable";
    private static final String k = "crash.txt";

    private void a() {
        d a = d.a();
        String str = a.f;
        a.a(b());
        a.a(this);
    }

    public void a(Thread thread, Throwable th) {
    }

    public void a(boolean z) {
        Editor edit = h().edit();
        edit.putBoolean(j, z);
        edit.commit();
    }

    public abstract String b();

    public abstract Bundle c();

    public String d() {
        String str;
        String str2 = a.f;
        PackageManager packageManager = getPackageManager();
        try {
            str = (String) packageManager.getApplicationInfo(getPackageName(), 0).loadLabel(packageManager);
            return str;
        } catch (NameNotFoundException e) {
            str = e;
            str.printStackTrace();
            return str2;
        } finally {
            System.gc();
        }
    }

    public String e() {
        String str;
        try {
            str = SportBaseInfo.VERSION + getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            str = a.f;
        } finally {
            System.gc();
        }
        return str;
    }

    public File f() {
        return new File(Environment.getExternalStorageDirectory(), k);
    }

    public void g() {
    }

    public SharedPreferences h() {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }

    public boolean i() {
        return true;
    }

    public boolean j() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    public void onCreate() {
        boolean z;
        super.onCreate();
        SharedPreferences h = h();
        h.registerOnSharedPreferenceChangeListener(this);
        try {
            z = h.getBoolean(j, i());
        } catch (Exception e) {
            z = e;
            z.printStackTrace();
            z = true;
            if (z) {
                a();
            }
        } finally {
            System.gc();
        }
        if (z) {
            a();
        }
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (j.equals(str)) {
            Boolean valueOf = Boolean.valueOf(true);
            try {
                valueOf = Boolean.valueOf(sharedPreferences.getBoolean(str, i()));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.gc();
            }
            if (valueOf.booleanValue()) {
                a();
            } else {
                d.a().d();
            }
        }
    }
}
