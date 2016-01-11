package cn.com.smartdevices.bracelet;

import a.a.a.B;
import android.os.Environment;
import android.util.Log;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.xiaomi.account.openauth.h;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import kankan.wheel.widget.a;

public class C0596r {
    public static int a = -1;
    public static int b = 0;
    public static int c = 1;
    public static int d = 2;
    public static int e = b;
    public static boolean f = r;
    public static int g = 2;
    private static final int h = 20971520;
    private static boolean i = s;
    private static final boolean j = true;
    private static final boolean k = true;
    private static final boolean l = true;
    private static final boolean m = true;
    private static final boolean n = true;
    private static boolean o = r;
    private static boolean p = r;
    private static boolean q = r;
    private static final boolean r = true;
    private static final boolean s = false;
    private static final String t = "DEBUG";

    public static void a() {
        File file = new File(Environment.getExternalStorageDirectory() + "/mili_log.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    public static void a(Object obj) {
        if (p && obj == null) {
            C0596r.a(t, ">>> `NOT NULL` ASSERTION FAILED <<<", 0, 'e');
        }
    }

    public static void a(String str) {
        C0596r.a(t, str, 0, 'd');
    }

    public static void a(String str, String str2) {
        if (e > a) {
            Log.e(str, C0596r.f() + str2);
        }
    }

    private static void a(String str, String str2, int i, char c) {
        if (i) {
            String name = Thread.currentThread().getName();
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[i + 4];
            String className = stackTraceElement.getClassName();
            className = className.substring(className.lastIndexOf(46) + 1);
            String methodName = stackTraceElement.getMethodName();
            name = "[" + name + "]" + "<" + className + a.ci + methodName + a.ci + stackTraceElement.getLineNumber() + "> ";
            String str3 = com.xiaomi.e.a.f;
            switch (c) {
                case a.ar /*100*/:
                    Log.d(str, name + str2 + str3);
                    return;
                case ShareData.SHARE_TYPE_LAB_ROPE_SKIPPING_ACCUMULATE /*101*/:
                    Log.e(str, name + str2 + str3);
                    return;
                case B.n /*105*/:
                    Log.i(str, name + str2 + str3);
                    return;
                case 'v':
                    Log.v(str, name + str2 + str3);
                    return;
                case 'w':
                    Log.w(str, name + str2 + str3);
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (e > a) {
            Log.e(str, C0596r.f() + str2, th);
        }
    }

    public static void a(Thread thread) {
        if (p && thread != null && Thread.currentThread().getId() != thread.getId()) {
            C0596r.a(t, ">>> `RUN ON THREAD` ASSERTION FAILED <<<", 0, 'e');
        }
    }

    public static void a(boolean z) {
        if (p && !z) {
            C0596r.a(t, ">>> `TRUE` ASSERTION FAILED <<<", 0, 'e');
        }
    }

    public static void a(boolean z, boolean z2) {
        e = z ? b : a;
        C0596r.c(z);
        f = z2;
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        i = r;
        o = z;
        p = z2;
        q = z3;
        C0596r.h();
        C0596r.d("         ENABLE_VERBOSE: TRUE");
        C0596r.d("           ENABLE_DEBUG: TRUE");
        C0596r.d("            ENABLE_INFO: TRUE");
        C0596r.d("            ENABLE_WARN: TRUE");
        C0596r.d("           ENABLE_ERROR: TRUE");
        C0596r.d("           ENABLE_TRACE: " + (o ? "TRUE" : "FALSE"));
        C0596r.d("          ENABLE_ASSERT: " + (p ? "TRUE" : "FALSE"));
        C0596r.d("      ENABLE_DEBUG_LOCK: " + (q ? "TRUE" : "FALSE"));
        C0596r.d("        ENABLE_LOG_META: TRUE");
        C0596r.d("  ENABLE_LOG_TRACE_INFO: FALSE");
    }

    public static void b(Object obj) {
        if (p && obj != null) {
            C0596r.a(t, ">>> `NULL` ASSERTION FAILED <<<", 0, 'e');
        }
    }

    public static void b(String str) {
        if (q) {
            C0596r.a(t, "LOCK#" + str, 0, 'v');
        }
    }

    public static void b(String str, String str2) {
        if (f) {
            File file = new File(Environment.getExternalStorageDirectory() + "/mili_log.txt");
            if (file.exists() && file.length() > 20971520) {
                file.delete();
            }
            try {
                FileWriter fileWriter = new FileWriter(file, r);
                fileWriter.write(C0596r.g() + "  " + str + "  " + str2 + "\n");
                fileWriter.close();
            } catch (IOException e) {
            }
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (e > a && e < d) {
            Log.w(str, str2, th);
        }
    }

    public static void b(boolean z) {
        e = z ? b : a;
        f = z;
        C0596r.c(z);
    }

    public static boolean b() {
        return (e <= a || e >= d) ? s : r;
    }

    public static void c(String str) {
        C0596r.a(t, str, 0, 'e');
    }

    public static void c(String str, String str2) {
        if (f) {
            File file = new File(Environment.getExternalStorageDirectory() + "/hr_running.txt");
            if (file.exists() && file.length() > 20971520) {
                file.delete();
            }
            try {
                FileWriter fileWriter = new FileWriter(file, r);
                fileWriter.write(str2 + "\n");
                fileWriter.close();
            } catch (IOException e) {
            }
        }
    }

    public static void c(boolean z) {
        i = z;
        o = z;
        p = z;
        q = z;
    }

    public static boolean c() {
        return f;
    }

    public static void d() {
        if (e > a && e < c) {
            StackTraceElement stackTraceElement = new Exception().getStackTrace()[g - 1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(stackTraceElement.getMethodName());
            stringBuilder.append(a.ci);
            stringBuilder.append(stackTraceElement.getLineNumber());
            String className = stackTraceElement.getClassName();
            Log.i(className.substring(className.lastIndexOf(".") + 1), stringBuilder.toString());
        }
    }

    public static void d(String str) {
        C0596r.a(t, str, 0, 'i');
    }

    public static void d(String str, String str2) {
        if (e > a && e < c) {
            Log.i(str, C0596r.f() + str2);
        }
        C0596r.b(str, str2);
    }

    public static void e() {
        if (o) {
            C0596r.a(t, "<<<<====", 0, 'v');
        }
    }

    public static void e(String str) {
        C0596r.a(t, str, 0, 'v');
    }

    public static void e(String str, String str2) {
        if (e > a && e < c) {
            Log.i(str, C0596r.f() + str2);
        }
    }

    private static String f() {
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[g];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        String className = stackTraceElement.getClassName();
        stringBuilder.append(className.substring(className.lastIndexOf(".") + 1));
        stringBuilder.append(a.ci);
        stringBuilder.append(stackTraceElement.getMethodName());
        stringBuilder.append(a.ci);
        stringBuilder.append(stackTraceElement.getLineNumber());
        stringBuilder.append("> ");
        return stringBuilder.toString();
    }

    public static void f(String str) {
        C0596r.a(t, str, 0, 'w');
    }

    public static void f(String str, String str2) {
        if (e > a && e < c) {
            for (int i = 0; i <= str2.length() / h.E; i++) {
                int i2 = i * h.E;
                int i3 = (i + 1) * h.E;
                if (i3 > str2.length()) {
                    i3 = str2.length();
                }
                Log.i(str, C0596r.f() + str2.substring(i2, i3));
            }
        }
    }

    private static String g() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    public static void g(String str, String str2) {
        if (e > a && e < d) {
            Log.w(str, C0596r.f() + str2);
        }
    }

    private static void h() {
        C0596r.d("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        C0596r.d("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        C0596r.d("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        C0596r.d("MM.:  .:'   `:::  .:`MMMMMMMMMMM|`MMM'|MMMMMMMMMMM':  .:'   `:::  .:'.MM");
        C0596r.d("MMMM.     :          `MMMMMMMMMM  :*'  MMMMMMMMMM'        :        .MMMM");
        C0596r.d("MMMMM.    ::    .     `MMMMMMMM'  ::   `MMMMMMMM'   .     ::   .  .MMMMM");
        C0596r.d("MMMMMM. :   :: ::'  :   :: ::'  :   :: ::'      :: ::'  :   :: ::.MMMMMM");
        C0596r.d("MMMMMMM    ;::         ;::         ;::         ;::         ;::   MMMMMMM");
        C0596r.d("MMMMMMM .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `::MMMMMMM");
        C0596r.d("MMMMMM'     :           :           :           :           :    `MMMMMM");
        C0596r.d("MMMMM'______::____      ::    .     ::    .     ::     ___._::____`MMMMM");
        C0596r.d("MMMMMMMMMMMMMMMMMMM`---._ :: ::'  :   :: ::'  _.--::MMMMMMMMMMMMMMMMMMMM");
        C0596r.d("MMMMMMMMMMMMMMMMMMMMMMMMMM::.         ::  .--MMMMMMMMMMMMMMMMMMMMMMMMMMM");
        C0596r.d("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM-.     ;::-MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        C0596r.d("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM. .:' .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        C0596r.d("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.   .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        C0596r.d("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\\ /MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        C0596r.d("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMVMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        C0596r.d("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM .:ZylvanaS:. MM");
        C0596r.d("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    }
}
