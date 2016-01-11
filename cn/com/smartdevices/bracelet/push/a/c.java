package cn.com.smartdevices.bracelet.push.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.d.a.d;
import java.util.ArrayList;
import java.util.List;

public class c extends cn.com.smartdevices.bracelet.d.a.c {
    public static final String a = "push";
    public static final int b = 1;
    private static List<Class<? extends d>> c = new ArrayList();

    static {
        c.add(a.class);
    }

    public c(Context context) {
        super(context, a, b);
    }

    public List<Class<? extends d>> a() {
        return c;
    }

    public b b() {
        return (b) a(b.class);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
