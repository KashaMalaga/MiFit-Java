package cn.com.smartdevices.bracelet.a;

import java.io.File;
import java.io.FileFilter;

final class b implements FileFilter {
    b() {
    }

    public boolean accept(File file) {
        return file != null && file.getAbsolutePath().endsWith(".track");
    }
}
