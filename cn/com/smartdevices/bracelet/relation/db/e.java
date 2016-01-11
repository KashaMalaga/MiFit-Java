package cn.com.smartdevices.bracelet.relation.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.d.a.a;
import cn.com.smartdevices.bracelet.d.a.c;
import cn.com.smartdevices.bracelet.d.a.d;
import java.util.ArrayList;
import java.util.List;

public class e extends c {
    private static final int a = 2;
    private static final String b = "relation";
    private static List<Class<? extends d>> c = new ArrayList();

    static {
        c.add(f.class);
        c.add(Friend.class);
        c.add(a.class);
    }

    public e(Context context) {
        super(context, b, a);
    }

    public List<Class<? extends d>> a() {
        return c;
    }

    public g b() {
        return (g) a(g.class);
    }

    public d c() {
        return (d) a(d.class);
    }

    public b d() {
        return (b) a(b.class);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1 && i2 == a) {
            sQLiteDatabase.execSQL(a.a(a.class, a.j));
        }
    }
}
