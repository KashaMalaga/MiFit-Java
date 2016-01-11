package cn.com.smartdevices.bracelet.gps.services.b;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.a.a;
import cn.com.smartdevices.bracelet.c.f;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class o {
    private o() {
    }

    public static File a() {
        return a.d(".MISportLab");
    }

    public static File b() {
        File d = a.d(".MISportLab");
        if (d.isDirectory()) {
            File[] listFiles = d.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return null;
            }
            d = new File("/sdcard/tmplab.zip");
            try {
                if (d.exists()) {
                    d.delete();
                }
                f.a(Arrays.asList(listFiles), d);
                return d;
            } catch (IOException e) {
                C0596r.a("Log", e.getMessage());
            }
        }
        return null;
    }
}
