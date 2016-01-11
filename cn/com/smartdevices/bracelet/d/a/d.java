package cn.com.smartdevices.bracelet.d.a;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class d {
    private static Map<Class<? extends d>, Field[]> b = new HashMap();
    protected long a = 0;

    public static Field[] a(Class<? extends d> cls) {
        Field[] fieldArr = (Field[]) b.get(cls);
        if (fieldArr != null) {
            return fieldArr;
        }
        Object declaredFields = cls.getDeclaredFields();
        b.put(cls, declaredFields);
        return declaredFields;
    }

    public long a() {
        return this.a;
    }

    public abstract boolean a(Cursor cursor);

    public abstract ContentValues b();
}
