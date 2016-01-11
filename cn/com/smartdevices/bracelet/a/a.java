package cn.com.smartdevices.bracelet.a;

import android.os.Environment;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.A;
import com.xiaomi.channel.gamesdk.b;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class a {
    public static final File a = Environment.getExternalStorageDirectory();
    private static final String b = ".miband";
    private static final String c = "miband";
    private static final File d = new File(a, c);
    private static final File e = new File(d, c);
    private static final File f = new File(a, b);
    private static final File g = new File(f, "cache");
    private static final File h = new File(f, b.b);
    private static final File i = new File(f, "file");
    private static final File j = new File(f, "log");
    private static final File k = new File(f, "thumb");
    private static final File l = new File(k, ".nomedia");
    private static final String m = ".track";
    private static final String n = "share.jpg";

    public static File a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!f.exists()) {
            f.mkdir();
        }
        if (!g.exists()) {
            g.mkdir();
        }
        a(f, g.getAbsolutePath());
        return new File(g, str);
    }

    public static void a() {
        int i = 0;
        String[] strArr = new String[]{".MISportLab", ".gpsLog.txt", n, "tmpmap.jpg"};
        int length = strArr.length;
        while (i < length) {
            String str = strArr[i];
            b(new File(a, str));
            b(new File(f, str));
            i++;
        }
    }

    public static void a(long j) {
        File[] listFiles = k.listFiles(new b());
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.lastModified() < j) {
                    file.deleteOnExit();
                }
            }
        }
    }

    public static boolean a(File file) {
        boolean z = false;
        if (file.exists() && file.isDirectory()) {
            for (String str : file.list()) {
                File file2 = new File(file, str);
                if (file2.isFile()) {
                    file2.delete();
                } else if (file2.isDirectory()) {
                    File file3 = new File(file, str);
                    a(file3);
                    b(file3);
                    z = true;
                }
            }
        }
        return z;
    }

    public static boolean a(File file, String str) {
        return (file == null || TextUtils.isEmpty(str)) ? false : new File(file, str).mkdirs();
    }

    public static File b() {
        if (!f.exists()) {
            f.mkdir();
        }
        if (!j.exists()) {
            j.mkdir();
        }
        return j;
    }

    public static File b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!f.exists()) {
            f.mkdir();
        }
        if (!h.exists()) {
            h.mkdir();
        }
        return new File(h, str);
    }

    public static void b(File file) {
        if (file != null && file.exists()) {
            try {
                a(file);
                file.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!f.exists()) {
            f.mkdir();
        }
        if (!i.exists()) {
            i.mkdir();
        }
        return new File(i, str);
    }

    public static String c() {
        return c(n).getAbsolutePath();
    }

    public static File d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!f.exists()) {
            f.mkdir();
        }
        if (!j.exists()) {
            j.mkdir();
        }
        return new File(j, str);
    }

    public static void d() {
        if (!d.exists()) {
            d.mkdir();
        }
        if (f.exists()) {
            if (!A.b()) {
                a();
                A.b(true);
            }
            if (!A.a()) {
                Calendar instance = Calendar.getInstance();
                instance.set(1, 2015);
                instance.set(2, 0);
                instance.set(5, 10);
                a(instance.getTimeInMillis());
                A.a(true);
            }
        } else {
            f.mkdir();
        }
        if (!g.exists()) {
            g.mkdir();
        }
        if (!h.exists()) {
            h.mkdir();
        }
        if (!i.exists()) {
            i.mkdir();
        }
        if (!e.exists()) {
            e.mkdir();
        }
        if (!j.exists()) {
            j.mkdir();
        }
        if (!k.exists()) {
            k.mkdir();
        }
        if (!l.exists()) {
            try {
                l.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    public static String e(String str) {
        return c(str).getAbsolutePath();
    }

    public static File f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!f.exists()) {
            f.mkdir();
        }
        if (!k.exists()) {
            k.mkdir();
            if (!l.exists()) {
                try {
                    l.createNewFile();
                } catch (IOException e) {
                }
            }
        }
        return new File(k, str);
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!f.exists() && !f.mkdir()) {
            return null;
        }
        if (!k.exists() && !k.mkdir()) {
            return null;
        }
        File file = new File(k, str);
        return ((file.exists() || file.mkdir()) && file.isDirectory()) ? file.getAbsolutePath() : null;
    }

    public static File h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!d.exists()) {
            d.mkdir();
        }
        if (!e.exists()) {
            e.mkdir();
        }
        return new File(e, str);
    }

    public static String i(String str) {
        return h(str).getAbsolutePath();
    }
}
