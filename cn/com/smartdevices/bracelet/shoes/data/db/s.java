package cn.com.smartdevices.bracelet.shoes.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

class s extends a {
    private static s b = null;

    protected s(Context context) {
        super(context);
    }

    public static synchronized s a(Context context) {
        s sVar;
        synchronized (s.class) {
            if (b == null) {
                b = new s(context);
            }
            sVar = b;
        }
        return sVar;
    }

    public SQLiteDatabase a(boolean z) {
        return super.a(z);
    }

    public void b() {
        super.b();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        super.onCreate(sQLiteDatabase);
    }
}
