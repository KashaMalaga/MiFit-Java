package cn.com.smartdevices.bracelet.crashreport;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.xiaomi.e.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class d implements UncaughtExceptionHandler {
    private static final String A = "StackTrace";
    private static final String B = "Local";
    private static final String E = "logcat -d -v time -f %s\n";
    private static d G = null;
    static final String b = "REPORT_FILE_NAME";
    static final String c = "REPORT_EMAIL";
    private static final String d = "ACRA";
    private static final String e = "VersionName";
    private static final String f = "VersionCode";
    private static final String g = "PackageName";
    private static final String h = "PhoneModel";
    private static final String i = "AndroidVersion";
    private static final String j = "SDKVersion";
    private static final String k = "Board";
    private static final String l = "Brand";
    private static final String m = "Device";
    private static final String n = "Display";
    private static final String o = "FingerPrint";
    private static final String p = "Host";
    private static final String q = "Id";
    private static final String r = "Model";
    private static final String s = "Product";
    private static final String t = "Tags";
    private static final String u = "Time";
    private static final String v = "Type";
    private static final String w = "User";
    private static final String x = "TotalMem";
    private static final String y = "AvailableMem";
    private static final String z = "CustomData";
    private String C;
    private final Properties D = new Properties();
    private UncaughtExceptionHandler F;
    private CrashReportingApplication H;
    private String I;
    Map<String, String> a = new HashMap();

    public static d a() {
        if (G == null) {
            G = new d();
        }
        return G;
    }

    public static String a(long j) {
        return a(j, false);
    }

    private static String a(long j, boolean z) {
        float f;
        String str;
        float f2 = (float) j;
        String str2 = "B";
        if (f2 > 900.0f) {
            str2 = "KB";
            f2 /= 1024.0f;
        }
        if (f2 > 900.0f) {
            str2 = "MB";
            f2 /= 1024.0f;
        }
        if (f2 > 900.0f) {
            str2 = "GB";
            f2 /= 1024.0f;
        }
        if (f2 > 900.0f) {
            str2 = "TB";
            f2 /= 1024.0f;
        }
        if (f2 > 900.0f) {
            f = f2 / 1024.0f;
            str = "PB";
        } else {
            String str3 = str2;
            f = f2;
            str = str3;
        }
        if (f < 1.0f) {
            str2 = String.format("%.2f", new Object[]{Float.valueOf(f)});
        } else if (f < 10.0f) {
            if (z) {
                str2 = String.format("%.1f", new Object[]{Float.valueOf(f)});
            } else {
                str2 = String.format("%.2f", new Object[]{Float.valueOf(f)});
            }
        } else if (f >= CropOverlayView.a) {
            str2 = String.format("%.0f", new Object[]{Float.valueOf(f)});
        } else if (z) {
            str2 = String.format("%.0f", new Object[]{Float.valueOf(f)});
        } else {
            str2 = String.format("%.2f", new Object[]{Float.valueOf(f)});
        }
        return str2 + str;
    }

    private void a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                this.D.put(e, packageInfo.versionName != null ? packageInfo.versionName : "not set");
                this.D.put(f, Integer.toString(packageInfo.versionCode));
            } else {
                this.D.put(g, "Package info unavailable");
            }
            this.D.put(g, context.getPackageName());
            this.D.put(h, Build.MODEL);
            this.D.put(i, VERSION.RELEASE);
            this.D.put(j, VERSION.SDK);
            this.D.put(k, Build.BOARD);
            this.D.put(l, Build.BRAND);
            this.D.put(m, Build.DEVICE);
            this.D.put(n, Build.DISPLAY);
            this.D.put(o, Build.FINGERPRINT);
            this.D.put(p, Build.HOST);
            this.D.put(q, Build.ID);
            this.D.put(r, Build.MODEL);
            this.D.put(s, Build.PRODUCT);
            this.D.put(t, Build.TAGS);
            this.D.put(u, new Date(Build.TIME).toGMTString());
            this.D.put(v, Build.TYPE);
            this.D.put(w, Build.USER);
            this.D.put(B, Locale.getDefault().toString());
            this.D.put(x, a(c()));
            this.D.put(y, a(b()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.gc();
        }
    }

    public static long b() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static String b(long j) {
        return a(j, true);
    }

    private void b(String str) {
        Intent intent = new Intent(this.H, CrashReportDialogActivity.class);
        intent.putExtra(b, str);
        intent.putExtra(c, this.I);
        intent.addFlags(268435456);
        this.H.startActivity(intent);
    }

    public static long c() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    private String e() {
        StringBuffer stringBuffer = new StringBuffer(a.f);
        StringBuffer stringBuffer2 = stringBuffer;
        for (String str : this.a.keySet()) {
            stringBuffer2 = stringBuffer2.append(str + " = " + ((String) this.a.get(str)) + "\n");
        }
        return stringBuffer2.toString();
    }

    private String f() {
        String path;
        try {
            File f = this.H.f();
            File parentFile = f.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!f.exists()) {
                f.createNewFile();
            }
            OutputStream fileOutputStream = new FileOutputStream(f);
            this.D.store(fileOutputStream, a.f);
            fileOutputStream.write(this.C.getBytes());
            fileOutputStream.write("\n\n".getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            path = f.getPath();
            return path;
        } catch (Exception e) {
            path = e;
            path.printStackTrace();
            return null;
        } finally {
            System.gc();
        }
    }

    public void a(CrashReportingApplication crashReportingApplication) {
        this.F = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.H = crashReportingApplication;
    }

    public void a(String str) {
        this.I = str;
    }

    public void a(String str, String str2) {
        this.a.put(str, str2);
    }

    void a(Throwable th) {
        if (th == null) {
            th = new Exception("Report requested by developer");
        }
        a(this.H);
        this.D.put(z, e());
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        this.C = stringWriter.toString();
        this.D.put(A, a.f);
        printWriter.close();
        b(f());
        th.printStackTrace();
    }

    public void d() {
        if (this.F != null) {
            Thread.setDefaultUncaughtExceptionHandler(this.F);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            this.H.a(thread, th);
            a(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        } finally {
            Process.killProcess(Process.myPid());
            System.exit(10);
        }
    }
}
