package cn.com.smartdevices.bracelet.shoes.data.db;

import android.net.Uri;

public class n extends r {
    static final String a = "myshoes";
    public static final Uri b = Uri.parse(r.i + "/" + a);
    public static final Uri c = Uri.parse(r.j + "/" + a);
    public static final Uri d = b.buildUpon().appendPath("update").build();
    public static final Uri e = b.buildUpon().appendPath("insert").build();
}
