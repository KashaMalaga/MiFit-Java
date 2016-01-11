package com.activeandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.activeandroid.d.b;

public final class a {
    public static void a() {
        b.a();
    }

    public static void a(Context context) {
        a(new e(context).a());
    }

    public static void a(Context context, boolean z) {
        a(new e(context).a(), z);
    }

    public static void a(c cVar) {
        a(cVar, false);
    }

    public static void a(c cVar, boolean z) {
        a(z);
        b.a(cVar);
    }

    public static void a(String str) {
        b.d().execSQL(str);
    }

    public static void a(String str, Object[] objArr) {
        b.d().execSQL(str, objArr);
    }

    public static void a(boolean z) {
        b.a(z);
    }

    public static void b() {
        b.b();
    }

    public static SQLiteDatabase c() {
        return b.d();
    }

    public static void d() {
        b.d().beginTransaction();
    }

    public static void e() {
        b.d().endTransaction();
    }

    public static void f() {
        b.d().setTransactionSuccessful();
    }

    public static boolean g() {
        return b.d().inTransaction();
    }
}
