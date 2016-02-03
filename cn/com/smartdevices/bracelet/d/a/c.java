package cn.com.smartdevices.bracelet.d.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.xiaomi.e.a;
import java.util.List;

public abstract class c extends SQLiteOpenHelper {
    private static final String a = "NewDatabaseHelper";
    private Context b;

    public c(Context context, String str, int i) {
        super(context, str, null, i);
        this.b = context;
    }

    public c(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.b = context;
    }

    protected <T extends a<? extends d>> T a(Class<T> cls) {
        try {
            return (a) cls.getConstructor(new Class[]{c.class}).newInstance(new Object[]{this});
        } catch (Throwable e) {
            Log.e(a, "create access object error for [class:" + cls.getName() + "]", e);
        } catch (Throwable e2) {
            Log.e(a, "create access object error for [class:" + cls.getName() + "]", e2);
        } catch (Throwable e22) {
            Log.e(a, "create access object error for [class:" + cls.getName() + "]", e22);
        } catch (Throwable e222) {
            Log.e(a, "create access object error for [class:" + cls.getName() + "]", e222);
        }
        return null;
    }

    public abstract List<Class<? extends d>> a();

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Class cls;
        Throwable th;
        Object obj = null;
        List<Class> a = a();
        if (a != null) {
            sQLiteDatabase.beginTransaction();
            String b;
            try {
                cls = null;
                for (Class cls2 : a) {
                    try {
                        b = a.b(cls2);
                        String str;
                        try {
                            sQLiteDatabase.execSQL(b);
                            str = b;
                            cls = cls2;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            str = b;
                            cls = cls2;
                            th = th2;
                        }
                    } catch (SQLiteException e2) {
                        th = e2;
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
            } catch (SQLiteException e3) {
                th = e3;
                cls = null;
                if (cls == null) {
                    try {
                        b = a.f;
                    } catch (Throwable th3) {
                        sQLiteDatabase.endTransaction();
                    }
                } else {
                    b = cls.getSimpleName();
                }
                Log.e(a, String.format("[TABLE:%s] auto create failed, use [SQL:%s]", new Object[]{b, obj}), th);
                sQLiteDatabase.endTransaction();
            }
        }
    }

    public abstract void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
}
