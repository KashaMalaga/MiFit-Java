package android.support.v4.g;

import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class c {
    public static final String a = "unknown";
    private static final String b = "EnvironmentCompat";

    public static String a(File file) {
        if (VERSION.SDK_INT >= 19) {
            return d.a(file);
        }
        try {
            if (file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath())) {
                return Environment.getExternalStorageState();
            }
        } catch (IOException e) {
            Log.w(b, "Failed to resolve canonical path: " + e);
        }
        return a;
    }
}
