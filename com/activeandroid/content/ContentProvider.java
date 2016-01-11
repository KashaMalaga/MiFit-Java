package com.activeandroid.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.SparseArray;
import com.activeandroid.a;
import com.activeandroid.b;
import com.activeandroid.c;
import com.activeandroid.e;
import com.activeandroid.g;
import com.activeandroid.j;
import java.util.ArrayList;
import java.util.List;

public class ContentProvider extends android.content.ContentProvider {
    private static final UriMatcher a = new UriMatcher(-1);
    private static final SparseArray<Class<? extends g>> b = new SparseArray();
    private static String c;
    private static SparseArray<String> d = new SparseArray();

    public static Uri a(Class<? extends g> cls, Long l) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("content://");
        stringBuilder.append(c);
        stringBuilder.append("/");
        stringBuilder.append(b.c((Class) cls).toLowerCase());
        if (l != null) {
            stringBuilder.append("/");
            stringBuilder.append(l.toString());
        }
        return Uri.parse(stringBuilder.toString());
    }

    private Class<? extends g> a(Uri uri) {
        int match = a.match(uri);
        return match != -1 ? (Class) b.get(match) : null;
    }

    private void b(Uri uri) {
        getContext().getContentResolver().notifyChange(uri, null);
    }

    protected String a() {
        return getContext().getPackageName();
    }

    protected c b() {
        return new e(getContext()).a();
    }

    public int delete(Uri uri, String str, String[] strArr) {
        int delete = b.d().delete(b.c(a(uri)), str, strArr);
        b(uri);
        return delete;
    }

    public String getType(Uri uri) {
        int match = a.match(uri);
        String str = (String) d.get(match);
        if (str != null) {
            return str;
        }
        Class a = a(uri);
        Object obj = match % 2 == 0 ? 1 : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("vnd");
        stringBuilder.append(".");
        stringBuilder.append(c);
        stringBuilder.append(".");
        stringBuilder.append(obj != null ? "item" : "dir");
        stringBuilder.append("/");
        stringBuilder.append("vnd");
        stringBuilder.append(".");
        stringBuilder.append(c);
        stringBuilder.append(".");
        stringBuilder.append(b.c(a));
        d.append(match, stringBuilder.toString());
        return stringBuilder.toString();
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        Class a = a(uri);
        Long valueOf = Long.valueOf(b.d().insert(b.c(a), null, contentValues));
        if (valueOf == null || valueOf.longValue() <= 0) {
            return null;
        }
        Uri a2 = a(a, valueOf);
        b(a2);
        return a2;
    }

    public boolean onCreate() {
        a.a(b());
        c = a();
        List arrayList = new ArrayList(b.g());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            j jVar = (j) arrayList.get(i);
            int i2 = (i * 2) + 1;
            int i3 = (i * 2) + 2;
            a.addURI(c, jVar.b().toLowerCase(), i2);
            b.put(i2, jVar.a());
            a.addURI(c, jVar.b().toLowerCase() + "/#", i3);
            b.put(i3, jVar.a());
        }
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query = b.d().query(b.c(a(uri)), strArr, str, strArr2, null, null, str2);
        query.setNotificationUri(getContext().getContentResolver(), uri);
        return query;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int update = b.d().update(b.c(a(uri)), contentValues, str, strArr);
        b(uri);
        return update;
    }
}
