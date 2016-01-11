package cn.com.smartdevices.bracelet.d.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a<T extends d> extends com.c.a.c.a<T> {
    protected c a;
    private final String b;
    private final Class<T> c = getRawType();
    private final String d;
    private final Field[] e;

    public a(c cVar) {
        String a = a(this.c);
        this.d = a;
        this.b = a;
        this.a = cVar;
        this.e = d.a(this.c);
    }

    private T a(Cursor cursor) {
        d dVar = (d) this.c.newInstance();
        if (dVar == null) {
            return null;
        }
        dVar.a(cursor);
        return dVar;
    }

    public static String a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Annotation annotation = cls.getAnnotation(f.class);
        if (annotation == null) {
            return null;
        }
        Object a = ((f) annotation).a();
        return TextUtils.isEmpty(a) ? null : a;
    }

    public static String a(Class<? extends d> cls, String str) {
        String a = a((Class) cls);
        if (a == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("ALTER TABLE [");
        stringBuilder.append(a);
        stringBuilder.append("] ADD [");
        stringBuilder.append(str);
        stringBuilder.append("] ");
        for (Field field : cls.getDeclaredFields()) {
            e eVar = (e) field.getAnnotation(e.class);
            if (eVar != null) {
                Class type = field.getType();
                Object a2 = eVar.a();
                if (TextUtils.isEmpty(a2)) {
                    throw new RuntimeException("the column name of [Field:" + field.getName() + "] is null");
                } else if (a2.equals(str)) {
                    stringBuilder.append(d(type));
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String b(Class<? extends d> cls) {
        String a = a((Class) cls);
        if (a == null) {
            return null;
        }
        StringBuilder append = new StringBuilder("CREATE TABLE IF NOT EXISTS ").append(a).append('(');
        Map hashMap = new HashMap();
        for (Field field : cls.getDeclaredFields()) {
            e eVar = (e) field.getAnnotation(e.class);
            if (eVar != null) {
                Class type = field.getType();
                Object a2 = eVar.a();
                if (TextUtils.isEmpty(a2)) {
                    throw new RuntimeException("the column name of [Field:" + field.getName() + "] is null");
                }
                append.append(a2).append(' ');
                append.append(d(type));
                if (!com.xiaomi.e.a.f.equals(eVar.d())) {
                    String d = eVar.d();
                    List list = (List) hashMap.get(d);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(d, list);
                    }
                    list.add(field.getName());
                }
                if (eVar.b()) {
                    append.append(' ').append("PRIMARY KEY");
                }
                if (eVar.c()) {
                    append.append(' ').append("AUTOINCREMENT");
                }
                append.append(',');
            }
        }
        for (String a3 : hashMap.keySet()) {
            append.append(" INDEX ").append(a3).append("(");
            for (String a32 : (List) hashMap.get(a32)) {
                append.append(a32).append(f.i);
            }
            append.setCharAt(append.length() - 1, ')');
            append.append(f.i);
        }
        append.setCharAt(append.length() - 1, ')');
        return append.toString();
    }

    public static String c(Class<? extends d> cls) {
        String a = a((Class) cls);
        return a == null ? null : "DROP TABLE  " + a;
    }

    private static String d(Class<?> cls) {
        if (String.class == cls || URI.class == cls || URL.class == cls) {
            return "TEXT";
        }
        if (Long.class == cls || Long.TYPE == cls || Integer.class == cls || Integer.TYPE == cls || Byte.TYPE == cls || Byte.class == cls || Short.TYPE == cls || Short.class == cls) {
            return "INTEGER";
        }
        if (byte[].class == cls) {
            return "BLOB";
        }
        if (Float.class == cls || Float.TYPE == cls) {
            return "FLOAT";
        }
        if (Double.TYPE == cls || Double.class == cls) {
            return "DOUBLE";
        }
        if (Character.class == cls || Character.TYPE == cls) {
            return "CHAR(1)";
        }
        if (Date.class == cls) {
            return "DATE";
        }
        if (Enum.class == cls) {
            return "INTEGER";
        }
        if (Boolean.class == cls || Boolean.TYPE == cls) {
            return "INTEGER";
        }
        throw new RuntimeException("field type mapping error, [Type:" + cls + "]");
    }

    protected int a(ContentValues contentValues, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int update = writableDatabase.update(this.d, contentValues, str, strArr);
            writableDatabase.setTransactionSuccessful();
            return update;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    protected int a(T t, String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int update = writableDatabase.update(this.d, t.b(), str, strArr);
            writableDatabase.setTransactionSuccessful();
            return update;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public long a() {
        return DatabaseUtils.queryNumEntries(this.a.getReadableDatabase(), this.d);
    }

    public long a(String str) {
        return DatabaseUtils.queryNumEntries(this.a.getReadableDatabase(), this.d, str);
    }

    public T a(String str, String[] strArr) {
        T t = null;
        Cursor query = this.a.getReadableDatabase().query(this.d, t, str, strArr, t, t, t, t);
        if (query != null && query.moveToFirst()) {
            try {
                t = a(query);
            } catch (Throwable e) {
                Log.w(this.b, "create orm instance error", e);
            } catch (Throwable e2) {
                Log.w(this.b, "create orm instance error", e2);
            } catch (Throwable e22) {
                Log.w(this.b, "create orm instance error", e22);
            } finally {
                query.close();
            }
        } else if (query != null) {
            query.close();
        }
        return t;
    }

    public List<T> a(long j, long j2) {
        return a(null, null, null, null, null, j + f.i + j2);
    }

    public List<T> a(long j, long j2, String str) {
        return a(null, null, null, null, str, j + f.i + j2);
    }

    public List<T> a(long j, long j2, String str, String[] strArr) {
        return a(str, strArr, null, null, null, j + f.i + j2);
    }

    public List<T> a(long j, long j2, String str, String[] strArr, String str2) {
        return a(str, strArr, null, null, str2, j + f.i + j2);
    }

    public List<T> a(String str, String[] strArr, String str2, String str3, String str4, String str5) {
        Cursor query = this.a.getReadableDatabase().query(this.d, null, str, strArr, str2, str3, str4, str5);
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            return new ArrayList();
        }
        List<T> arrayList = new ArrayList();
        while (true) {
            try {
                arrayList.add(a(query));
                if (!query.moveToNext()) {
                    break;
                }
            } catch (Throwable e) {
                Log.w(this.b, "create orm instance error", e);
                return arrayList;
            } catch (Throwable e2) {
                Log.w(this.b, "create orm instance error", e2);
                return arrayList;
            } catch (Throwable e22) {
                Log.w(this.b, "create orm instance error", e22);
                return arrayList;
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    public boolean a(T t) {
        if (t == null) {
            Log.w(this.b, "you try to save a null entity");
            return false;
        }
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            long insert = writableDatabase.insert(this.d, null, t.b());
            if (insert < 0) {
                Log.e(this.b, "save entity failed , content is " + t.toString());
                writableDatabase.setTransactionSuccessful();
                return false;
            }
            t.a = insert;
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return true;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public boolean a(List<T> list) {
        if (list == null || list.isEmpty()) {
            Log.w(this.b, "you try to save a null entity");
            return false;
        }
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            boolean z = false;
            for (T t : list) {
                long insert = writableDatabase.insert(this.d, null, t.b());
                t.a = insert;
                if (insert < 0) {
                    Log.w(this.b, "save entity failed , content is " + t.toString());
                    z = false;
                } else {
                    writableDatabase.setTransactionSuccessful();
                    z = true;
                }
            }
            writableDatabase.setTransactionSuccessful();
            return z;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public int b(String str, String[] strArr) {
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int delete = writableDatabase.delete(this.d, str, strArr);
            writableDatabase.setTransactionSuccessful();
            return delete;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public List<T> b() {
        return a(null, null, null, null, null, null);
    }

    public int c() {
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int delete = writableDatabase.delete(this.d, null, null);
            writableDatabase.setTransactionSuccessful();
            return delete;
        } finally {
            writableDatabase.endTransaction();
        }
    }
}
