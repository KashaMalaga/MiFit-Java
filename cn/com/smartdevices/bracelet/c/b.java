package cn.com.smartdevices.bracelet.c;

import java.io.File;
import java.io.FilenameFilter;

public class b implements FilenameFilter {
    String a = ".";

    public b(String str) {
        this.a += str;
    }

    public boolean accept(File file, String str) {
        return str.endsWith(this.a);
    }
}
