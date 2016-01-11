package com.activeandroid.d;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.activeandroid.a.a;
import com.activeandroid.a.b;
import com.activeandroid.c.e;
import com.activeandroid.g;
import com.activeandroid.j;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class f {
    public static final boolean a = (VERSION.SDK_INT >= 8);
    private static final HashMap<Class<?>, h> b = new g();
    private static HashMap<String, List<String>> c;
    private static HashMap<String, List<String>> d;
    private static HashMap<String, b> e;

    private static int a(Cursor cursor) {
        return cursor.moveToFirst() ? cursor.getInt(0) : 0;
    }

    public static int a(String str, String[] strArr) {
        Cursor rawQuery = com.activeandroid.b.d().rawQuery(str, strArr);
        int a = a(rawQuery);
        rawQuery.close();
        return a;
    }

    public static ArrayList<String> a(j jVar) {
        ArrayList<String> arrayList = new ArrayList();
        d = new HashMap();
        e = new HashMap();
        for (Field a : jVar.d()) {
            a(jVar, a);
        }
        if (d.isEmpty()) {
            return arrayList;
        }
        for (String str : d.keySet()) {
            List list = (List) d.get(str);
            b bVar = (b) e.get(str);
            arrayList.add(String.format("UNIQUE (%s) ON CONFLICT %s", new Object[]{TextUtils.join(", ", list), bVar.toString()}));
        }
        return arrayList;
    }

    public static <T extends g> List<T> a(Class<? extends g> cls, Cursor cursor) {
        String c = com.activeandroid.b.a((Class) cls).c();
        List<T> arrayList = new ArrayList();
        try {
            Constructor constructor = cls.getConstructor(new Class[0]);
            if (cursor.moveToFirst()) {
                List arrayList2 = new ArrayList(Arrays.asList(cursor.getColumnNames()));
                do {
                    g a = com.activeandroid.b.a((Class) cls, cursor.getLong(arrayList2.indexOf(c)));
                    if (a == null) {
                        a = (g) constructor.newInstance(new Object[0]);
                    }
                    a.loadFromCursor(cursor);
                    arrayList.add(a);
                } while (cursor.moveToNext());
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Your model " + cls.getName() + " does not define a default " + "constructor. The default constructor is required for " + "now in ActiveAndroid models, as the process to " + "populate the ORM model is : " + "1. instantiate default model " + "2. populate fields");
        } catch (Throwable e2) {
            b.e("Failed to process cursor.", e2);
        }
        return arrayList;
    }

    public static <T extends g> List<T> a(Class<? extends g> cls, String str, String[] strArr) {
        Cursor rawQuery = com.activeandroid.b.d().rawQuery(str, strArr);
        List<T> a = a((Class) cls, rawQuery);
        rawQuery.close();
        return a;
    }

    public static void a(j jVar, Field field) {
        String a = jVar.a(field);
        a aVar = (a) field.getAnnotation(a.class);
        if (!field.getName().equals("mId")) {
            String[] i = aVar.i();
            b[] j = aVar.j();
            if (i.length == j.length) {
                for (int i2 = 0; i2 < i.length; i2++) {
                    CharSequence charSequence = i[i2];
                    Object obj = j[i2];
                    if (!TextUtils.isEmpty(charSequence)) {
                        List list = (List) d.get(charSequence);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(a);
                        d.put(charSequence, list);
                        e.put(charSequence, obj);
                    }
                }
            }
        }
    }

    public static void a(String str) {
        com.activeandroid.b.d().execSQL(str);
    }

    public static void a(String str, Object[] objArr) {
        com.activeandroid.b.d().execSQL(str, objArr);
    }

    public static <T extends g> T b(Class<? extends g> cls, String str, String[] strArr) {
        List a = a(cls, str, strArr);
        return a.size() > 0 ? (g) a.get(0) : null;
    }

    public static List<String> b(String str) {
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder(100);
        Object obj = null;
        Object obj2 = null;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == ';' && obj2 == null && obj == null) {
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder(100);
                obj = null;
                obj2 = null;
            } else {
                if (charAt == '\'' && obj == null) {
                    obj2 = obj2 == null ? 1 : null;
                }
                obj = (charAt == '\\' && obj == null) ? 1 : null;
                stringBuilder.append(charAt);
            }
        }
        if (stringBuilder.length() > 0) {
            arrayList.add(stringBuilder.toString());
        }
        return arrayList;
    }

    public static void b(j jVar, Field field) {
        String a = jVar.a(field);
        a aVar = (a) field.getAnnotation(a.class);
        if (!field.getName().equals("mId")) {
            if (aVar.k()) {
                List arrayList = new ArrayList();
                arrayList.add(a);
                c.put(a, arrayList);
            }
            for (CharSequence charSequence : aVar.l()) {
                if (!TextUtils.isEmpty(charSequence)) {
                    List list = (List) c.get(charSequence);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(a);
                    c.put(charSequence, list);
                }
            }
        }
    }

    public static String[] b(j jVar) {
        ArrayList arrayList = new ArrayList();
        c = new HashMap();
        for (Field b : jVar.d()) {
            b(jVar, b);
        }
        if (c.isEmpty()) {
            return new String[0];
        }
        for (Entry entry : c.entrySet()) {
            arrayList.add(String.format("CREATE INDEX IF NOT EXISTS %s on %s(%s);", new Object[]{"index_" + jVar.b() + "_" + ((String) entry.getKey()), jVar.b(), TextUtils.join(", ", (Iterable) entry.getValue())}));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String c(j jVar) {
        Iterable arrayList = new ArrayList();
        for (Field c : jVar.d()) {
            CharSequence c2 = c(jVar, c);
            if (!TextUtils.isEmpty(c2)) {
                arrayList.add(c2);
            }
        }
        arrayList.addAll(a(jVar));
        return String.format("CREATE TABLE IF NOT EXISTS %s (%s);", new Object[]{jVar.b(), TextUtils.join(", ", arrayList)});
    }

    public static String c(j jVar, Field field) {
        StringBuilder stringBuilder = new StringBuilder();
        Class type = field.getType();
        String a = jVar.a(field);
        e b = com.activeandroid.b.b(field.getType());
        a aVar = (a) field.getAnnotation(a.class);
        Class b2 = b != null ? b.b() : type;
        if (b.containsKey(b2)) {
            stringBuilder.append(a);
            stringBuilder.append(" ");
            stringBuilder.append(((h) b.get(b2)).toString());
        } else if (d.a(b2)) {
            stringBuilder.append(a);
            stringBuilder.append(" ");
            stringBuilder.append(h.INTEGER.toString());
        } else if (d.a(b2, Enum.class)) {
            stringBuilder.append(a);
            stringBuilder.append(" ");
            stringBuilder.append(h.TEXT.toString());
        }
        if (TextUtils.isEmpty(stringBuilder)) {
            b.e("No type mapping for: " + b2.toString());
        } else {
            if (a.equals(jVar.c())) {
                stringBuilder.append(" PRIMARY KEY AUTOINCREMENT");
            } else if (aVar != null) {
                if (aVar.b() > -1) {
                    stringBuilder.append("(");
                    stringBuilder.append(aVar.b());
                    stringBuilder.append(")");
                }
                if (aVar.c()) {
                    stringBuilder.append(" NOT NULL ON CONFLICT ");
                    stringBuilder.append(aVar.d().toString());
                }
                if (aVar.g()) {
                    stringBuilder.append(" UNIQUE ON CONFLICT ");
                    stringBuilder.append(aVar.h().toString());
                }
            }
            if (a && d.a(b2)) {
                stringBuilder.append(" REFERENCES ");
                stringBuilder.append(com.activeandroid.b.a(b2).b());
                stringBuilder.append("(" + jVar.c() + ")");
                stringBuilder.append(" ON DELETE ");
                stringBuilder.append(aVar.e().toString().replace("_", " "));
                stringBuilder.append(" ON UPDATE ");
                stringBuilder.append(aVar.f().toString().replace("_", " "));
            }
        }
        return stringBuilder.toString();
    }
}
