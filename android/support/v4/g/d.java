package android.support.v4.g;

import android.os.Environment;
import java.io.File;

class d {
    d() {
    }

    public static String a(File file) {
        return Environment.getStorageState(file);
    }
}
