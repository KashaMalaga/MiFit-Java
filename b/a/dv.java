package b.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dv extends C0281a {
    private static final String a = "utdid";
    private static final String b = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final Pattern c = Pattern.compile("UTDID\">([^<]+)");
    private Context d;

    public dv(Context context) {
        super(a);
        this.d = context;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = c.matcher(str);
        return matcher.find() ? matcher.group(1) : null;
    }

    private String g() {
        File h = h();
        if (h == null || !h.exists()) {
            return null;
        }
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(h);
            String b = b(C0352cm.a(fileInputStream));
            C0352cm.c(fileInputStream);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            C0352cm.c(fileInputStream);
        }
    }

    private File h() {
        if (!bW.a(this.d, b) || !Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        try {
            return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
        } catch (Exception e) {
            return null;
        }
    }

    public String f() {
        return g();
    }
}
